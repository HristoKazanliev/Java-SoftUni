package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineTypeEnum;

import java.util.List;

public record OfferDetailsDTO(Long id,
                              String description,
                              Integer mileage,
                              Integer price,
                              EngineTypeEnum engineType,
                              List<String> allCurrencies) {
}
