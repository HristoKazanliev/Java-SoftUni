package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineTypeEnum;

public record AddOfferDTO(
        String description,
        Integer mileage,
        EngineTypeEnum engineType
) {

    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, null, null);
    }
}
