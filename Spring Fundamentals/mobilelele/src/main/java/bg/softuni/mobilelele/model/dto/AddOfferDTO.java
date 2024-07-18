package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record AddOfferDTO(
        @NotEmpty(message = "{add.offer.description.not.empty}")
        @Size(min = 5, max = 500) String description,
        @NotNull @PositiveOrZero Integer mileage,
        @NotNull @PositiveOrZero Integer price,
        @NotNull EngineTypeEnum engineType
) {

    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, 0, 0, null);
    }
}
