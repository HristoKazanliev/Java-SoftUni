package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.EngineTypeEnum;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer mileage;
    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
