package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineTypeEnum;

public record OfferDetailsDTO(Long id,
                              String description,
                              Integer mileage,
                              EngineTypeEnum engineType) {
}
