package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.EngineTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    @NotEmpty
    private String description;

    @Positive
    private Integer mileage;

    @Positive
    private Integer price;

    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Offer setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public Offer setEngine(EngineTypeEnum engine) {
        this.engine = engine;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Offer setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
