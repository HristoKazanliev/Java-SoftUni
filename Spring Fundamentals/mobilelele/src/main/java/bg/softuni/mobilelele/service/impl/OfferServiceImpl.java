package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;
import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.ExRateService;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ExRateService exRateService;

    public OfferServiceImpl(OfferRepository offerRepository, ExRateService exRateService) {
        this.offerRepository = offerRepository;
        this.exRateService = exRateService;
    }

    @Override
    public long createOffer(AddOfferDTO addOfferDTO) {
        return offerRepository.save(map(addOfferDTO)).getId();
    }

    @Override
    public OfferDetailsDTO getOfferDetails(Long id) {
        return this.offerRepository
                .findById(id)
                .map(this::toOfferDetails)
                .orElseThrow();
    }

    @Override
    public List<OfferDetailsDTO> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(this::toOfferDetails)
                .toList();
    }

    @Override
    public void deleteOffer(Long offerId) {
        offerRepository.deleteById(offerId);
    }

    private static Offer map (AddOfferDTO addOfferDTO) {
        return new Offer()
                .setDescription(addOfferDTO.description())
                .setMileage(addOfferDTO.mileage())
                .setPrice(addOfferDTO.price())
                .setEngine(addOfferDTO.engineType());
    }

    private OfferDetailsDTO toOfferDetails(Offer offer) {
        return new OfferDetailsDTO(offer.getId(), offer.getDescription(), offer.getMileage(), offer.getPrice(), offer.getEngine(), exRateService.allSupportedCurrencies());
    }
}
