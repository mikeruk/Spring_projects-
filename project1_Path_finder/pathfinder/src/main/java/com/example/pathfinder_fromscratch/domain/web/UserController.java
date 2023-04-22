package com.example.pathfinder_fromscratch.domain.web;

import com.example.pathfinder_fromscratch.domain.binding.UserLoginBindingModel;
import com.example.pathfinder_fromscratch.domain.binding.UserRegisterBindingModel;


import com.example.pathfinder_fromscratch.domain.entities.service.UserServiceModel;
import com.example.pathfinder_fromscratch.domain.repositories.UserRepository;
import com.example.pathfinder_fromscratch.domain.service.UserService;
import com.example.pathfinder_fromscratch.domain.view.UserViewModel;
import com.example.pathfinder_fromscratch.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/users")
public class UserController {


    private final UserRepository userRepository;
    private final UserService userService;

    private final ModelMapper modelMapper;

    public UserController(UserRepository userRepository, UserService userService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    //each time we load UserControler class and any of its methods, SPRING will have empty object of class UserRegisterBindingModel
    //and our th:field="*{username}" which searches for such parent Object UserRegisterBindingModel will not highlight in RED, because it will
    //now be able to find such parent object UserRegisterBindingModel !!!
    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/register")
    public String register(Model model) {

//        if (!model.containsAttribute("userRegisterBindingModel")) {
//            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
//        }

        return "register";
    }

    //We edited the register.html ,and we used there th:object and th:field to access fields from objects. And now we need
    //to pass such objects to the register.html. We do this by adding the object as argument in the method, UserRegisterBindingModel
    //then we put @Valid which comes from hibernagte. @Valid will validate the values passed from the INPUT tags in our form.
    //Those limits for values must be defined in the UserRegisterBindingModel class, e.g. Size(min=2) for username.
    //When executed, this @Valid will find all fields which are INVALID/INCORRECT and will put them in a special object class BindingResult. if we Need
    //to access those object, we need to pass it as argument in the method.
    //VERY IMPORTANT !!!!!!!! -> we always need to add the bindingResult right after the adding of userRegisterBindingModel, if not - the info
    // will not be populated correctly.
    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        //after we added BindingResult as per the comments above, we need to access it and examine for errors:
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            //if we find errors, we would like to return them back to the HTML in order to be displayed.
            //To do this, we need to use a special class AND ADD THOSE ERRORS to this special class, and then we will return the class. This class is
            //called RedirectAttributes, and we pass it here on 3rd place as argument
            //we use 'Flash', because we like attribute to be flashed, as KEY-VALUE PAIRs!!
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);

            //if we want to implement some extra features of thymeleaf, when displaying the error on screen, we need to use WHOLE PATH to the class, like this:
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);

            return "redirect:register";

        }

        //step create userRepository and userService;

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        //NB! When we "redirect" we also pass on the model contained here
        return "redirect:login";
    }


    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (model.getAttribute("isExists") != null) {
            return "login";
        } else {
            model.addAttribute("isExists", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel",
                            userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);

            //NB! When we "redirect" we also pass on the model contained here
            return "redirect:login";
        }


        //this field user can be null, because we have .orElse(null); meaning it can return null here:
        UserServiceModel user = userService.findUserByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        //if the user from the upper line is really null, then we have error.
        //for errors - we have "redirectAttributes" to use.
        if (user == null) {
            redirectAttributes
                    .addFlashAttribute("isExists", false)
                    .addFlashAttribute("userLoginBindingModel",
                            userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);

            //NB! When we "redirect" we also pass on the model contained here
            return "redirect:login";
        }


        userService.loginUser(user.getId(), user.getUsername());


//NB! When we "redirect" we also pass on the model contained here
        return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }


    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id,
                          Model model) {
        UserServiceModel userServiceModel = userService.findById(id);
        UserViewModel userViewModel = modelMapper.map(userServiceModel, UserViewModel.class);

        model.addAttribute("user", userViewModel);

        return "profile";
    }

}
