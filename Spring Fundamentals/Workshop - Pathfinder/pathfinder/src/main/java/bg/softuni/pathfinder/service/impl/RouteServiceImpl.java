package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.model.dto.RouteAddDTO;
import bg.softuni.pathfinder.model.dto.RouteAllDTO;
import bg.softuni.pathfinder.model.entity.Picture;
import bg.softuni.pathfinder.model.entity.Route;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteServiceImpl {
    private final RouteRepository routeRepository;
    private final Random random;
    private final ModelMapper modelMapper;

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

    public boolean add(RouteAddDTO routeAddDTO, MultipartFile file) throws IOException {
        Route routeToInsert = modelMapper.map(routeAddDTO, Route.class);

        Path destinationFile = Paths.get("pathfinder", "src","main", "resources", "uploads", "file.gpx").normalize().toAbsolutePath();

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        }

        return false;
    }
}
