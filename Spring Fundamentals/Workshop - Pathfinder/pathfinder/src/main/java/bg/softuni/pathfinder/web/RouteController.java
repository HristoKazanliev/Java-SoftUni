package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.RouteAddDTO;
import bg.softuni.pathfinder.model.dto.RouteAllDTO;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.pathfinder.model.enums.CategoryType;
import bg.softuni.pathfinder.model.enums.Level;
import bg.softuni.pathfinder.service.impl.RouteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RouteController {
    private final RouteServiceImpl routeService;

    @ModelAttribute("routeData")
    public RouteAddDTO routeData() {
        return new RouteAddDTO();
    }

    @GetMapping("/routes")
    public String routes(Model model) {
        //RouteAllDTO routeAllDTO = routeService.getRandomRoute();
        List<RouteAllDTO> routes = routeService.getAll();

        model.addAttribute("allRoutes", routes);

        return "routes";
    }

    @GetMapping("/add-route")
    public String addRoute(Model model) {
        model.addAttribute("levels", Level.values());
        model.addAttribute("categoryTypes", CategoryType.values());

        return "add-route";
    }

    @PostMapping("/add-route")
    public String addRoute(@Valid RouteAddDTO routeAddDTO,
                           @RequestParam("gpxCoordinates") MultipartFile file,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) throws IOException {
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("routeData", routeAddDTO);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeData", bindingResult);
//
//            return "redirect:/add-route";
//        }

        routeService.add(routeAddDTO, file);

        return "routes";
    }
}
