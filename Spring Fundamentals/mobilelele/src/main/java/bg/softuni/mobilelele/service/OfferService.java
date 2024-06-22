package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;

import java.util.List;

public interface OfferService {
    long createOffer(AddOfferDTO addOfferDTO);

    OfferDetailsDTO getOfferDetails(Long id);

    List<OfferDetailsDTO> getAllOffers();

    void deleteOffer(Long offerId);
}
