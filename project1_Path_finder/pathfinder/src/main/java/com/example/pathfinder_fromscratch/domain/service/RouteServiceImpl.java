package com.example.pathfinder_fromscratch.domain.service;

import com.example.pathfinder_fromscratch.domain.entities.Route;
import com.example.pathfinder_fromscratch.domain.entities.service.RouteServiceModel;
import com.example.pathfinder_fromscratch.domain.repositories.RouteRepository;
import com.example.pathfinder_fromscratch.domain.view.MostCommentedRouteViewDto;
import com.example.pathfinder_fromscratch.domain.view.RouteDetailsViewModel;
import com.example.pathfinder_fromscratch.domain.view.RouteViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    private final UserService userService;
    private final CategoryService categoryService;


    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public List<RouteViewModel> findAllRoutesView() {

        List<RouteViewModel> routeViewModels = routeRepository
                .findAll()
                .stream()
                .map(routeEntity -> {
                    RouteViewModel routeViewModel = modelMapper
                            .map(routeEntity, RouteViewModel.class);

                    if (routeEntity.getPictures().isEmpty()) {
                        routeViewModel.setPictureUrl("images/pic4.jpg"); //т.е. ня сме намерили снимки в базата
                        //алтернатива е да хард коднем една дефолтна снимка винаги да се показва
                        //когато няма снимки в базата
                    } else {
                        routeViewModel.setPictureUrl(routeEntity
                                .getPictures()
                                .stream()
                                .findFirst()
                                .get()
                                .getUrl());
                    }
                    return routeViewModel;
                })
                .collect(Collectors.toList());
        return routeViewModels;

    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {

        Route route = modelMapper.map(routeServiceModel, Route.class);

        route.setAuthor(userService.findCurrentLoginUserEntity());

        route.setCategories(routeServiceModel
                .getCategories()
                .stream()
                .map(categoryEnum -> categoryService.findCategoryByName(categoryEnum))
                .collect(Collectors.toSet()));


        routeRepository.save(route);

    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {

        RouteDetailsViewModel routeDetailsViewModel = routeRepository.findById(id)
                .map(route -> modelMapper
                        .map(route, RouteDetailsViewModel.class))
                .orElse(null);

        return routeDetailsViewModel;
    }


    @Override
    public MostCommentedRouteViewDto getMostCommentedRoute() {
        Optional<List<Route>> mostCommentedRoute = routeRepository.findMostCommented();

        return MostCommentedRouteViewDto.fromRoute(this.routeRepository
                .findMostCommented()
                .orElseThrow(NoSuchElementException::new)
                .get(0));
    }


}
