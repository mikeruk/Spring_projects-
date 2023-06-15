package com.example.pathfinder_fromscratch.domain.web;

import com.example.pathfinder_fromscratch.domain.binding.RouteAddBindingModel;
import com.example.pathfinder_fromscratch.domain.entities.service.RouteServiceModel;
import com.example.pathfinder_fromscratch.domain.service.RouteService;
import com.example.pathfinder_fromscratch.domain.view.RouteDetailsViewModel;
import com.example.pathfinder_fromscratch.domain.view.RouteViewModel;
import com.example.pathfinder_fromscratch.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String routes(Model model) {

        List<RouteViewModel> routeViewModels = routeService
                .findAllRoutesView();
        model.addAttribute("routes", routeViewModels);
        return "routes";
    }

    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel() {
        return new RouteAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        return "add-route";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid RouteAddBindingModel routeAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("routeAddBindingModel", routeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel", bindingResult);
            return "redirect:add";

        } else {

        }

        RouteServiceModel routeServiceModel = modelMapper
                .map(routeAddBindingModel, RouteServiceModel.class);
        routeServiceModel.setGpxCoordinates(new String(routeAddBindingModel
                .getGpxCoordinates()
                .getBytes()));

        routeService.addNewRoute(routeServiceModel);

        return "redirect:all";
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id,
                          Model model) {
        RouteDetailsViewModel routeDetailsViewModel = routeService.findRouteById(id);
        model.addAttribute("route", routeDetailsViewModel);


        return "route-details";
    }


}
