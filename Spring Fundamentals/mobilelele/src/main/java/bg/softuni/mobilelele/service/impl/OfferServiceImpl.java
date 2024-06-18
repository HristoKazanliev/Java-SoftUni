package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;
import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public long createOffer(AddOfferDTO addOfferDTO) {
        return offerRepository.save(map(addOfferDTO)).getId();
    }

    @Override
    public OfferDetailsDTO getOfferDetails(Long id) {
        return this.offerRepository
                .findById(id)
                .map(OfferServiceImpl::toOfferDetails)
                .orElseThrow();
    }

    private static Offer map (AddOfferDTO addOfferDTO) {
        return new Offer()
                .setDescription(addOfferDTO.description())
                .setMileage(addOfferDTO.mileage())
                .setEngine(addOfferDTO.engineType());
    }

    private static OfferDetailsDTO toOfferDetails(Offer offer) {
        return new OfferDetailsDTO(offer.getId(), offer.getDescription(), offer.getMileage(), offer.getEngine());
    }
}
