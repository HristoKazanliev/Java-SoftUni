package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.EngineTypeEnum;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    private String description;
    private Integer mileage;
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

}
