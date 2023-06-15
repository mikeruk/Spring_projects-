package com.example.pathfinder_fromscratch.domain.service;


import com.example.pathfinder_fromscratch.domain.entities.service.RouteServiceModel;
import com.example.pathfinder_fromscratch.domain.view.MostCommentedRouteViewDto;
import com.example.pathfinder_fromscratch.domain.view.RouteDetailsViewModel;
import com.example.pathfinder_fromscratch.domain.view.RouteViewModel;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteServiceModel routeServiceModel);

    RouteDetailsViewModel findRouteById(Long id);

    MostCommentedRouteViewDto getMostCommentedRoute();



}
