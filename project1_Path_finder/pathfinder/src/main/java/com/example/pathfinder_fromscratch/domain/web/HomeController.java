package com.example.pathfinder_fromscratch.domain.web;

import com.example.pathfinder_fromscratch.domain.service.PictureService;
import com.example.pathfinder_fromscratch.domain.service.RouteService;
import com.example.pathfinder_fromscratch.domain.view.MostCommentedRouteViewDto;
import com.example.pathfinder_fromscratch.domain.view.RouteViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {

    private final PictureService pictureService;
    private final RouteService routeService;

    public HomeController(PictureService pictureService, RouteService routeService) {
        this.pictureService = pictureService;
        this.routeService = routeService;
    }


    @GetMapping("/")
    public String getHome(Model model){

        model.addAttribute("pictures",
                pictureService.findAllUrls());

        MostCommentedRouteViewDto mostCommentedRoute = routeService.getMostCommentedRoute();
        System.out.println(mostCommentedRoute.getName());
        System.out.println(mostCommentedRoute.getDescription());
        System.out.println(mostCommentedRoute.getId());
        model.addAttribute("mostCommentedRoute", mostCommentedRoute);

        return "index";
    }

    @GetMapping("/about")
    public String about(){

        return "about";
    }

}
