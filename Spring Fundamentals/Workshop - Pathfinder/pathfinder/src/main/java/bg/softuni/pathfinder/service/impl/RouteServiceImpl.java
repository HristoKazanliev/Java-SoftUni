package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.model.dto.RouteAllDTO;
import bg.softuni.pathfinder.model.entity.Picture;
import bg.softuni.pathfinder.model.entity.Route;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteServiceImpl {
    private RouteRepository routeRepository;
    private Random random;
    private ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;

        this.random = new Random();
        this.modelMapper = new ModelMapper();
    }

    @Transactional
    public RouteAllDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;

        Optional<Route> route = routeRepository.findById(randomId);

        if (route.isEmpty()) {
            //error handling
        }

        return mapToShortInfo(route.get());
    }

    @Transactional
    public List<RouteAllDTO> getAll() {
        return routeRepository.findAll().stream().map(this::mapToShortInfo).toList();
    }

    private RouteAllDTO mapToShortInfo(Route route) {
        RouteAllDTO dto = modelMapper.map(route, RouteAllDTO.class);

        Optional<Picture> firstPicture = route.getPictures().stream().findFirst();
        dto.setImageUrl(firstPicture.get().getUrl());

        return dto;
    }
}
