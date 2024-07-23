package bg.softuni.pathfinder.model.demo_uuid;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class TestUuidEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.UUID) //from the JPA API
    @UuidGenerator(style = UuidGenerator.Style.RANDOM) // from Hibernate
    private UUID id;

    private String content;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
