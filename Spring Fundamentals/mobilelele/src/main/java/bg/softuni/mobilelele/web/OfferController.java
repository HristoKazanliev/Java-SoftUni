package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.enums.EngineTypeEnum;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/add")
    public String newOffer(Model model) {
        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDTO.empty());
        }

        model.addAttribute("allEngineTypes", EngineTypeEnum.values());

        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(AddOfferDTO addOfferDTO) {
        offerService.createOffer(addOfferDTO);

        return "offer-add";
    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("offerDetails", offerService.getOfferDetails(id));

        return "details";
    }
}
