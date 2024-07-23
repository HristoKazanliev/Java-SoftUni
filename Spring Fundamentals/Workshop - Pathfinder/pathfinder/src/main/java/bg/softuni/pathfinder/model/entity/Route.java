package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.Comment;
import bg.softuni.pathfinder.model.entity.Picture;
import bg.softuni.pathfinder.model.enums.Level;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "routes")
@Getter
@Setter
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(optional = false)
    private User author;

    @OneToMany(targetEntity = Comment.class, mappedBy = "route")
    private Set<Comment> comments;

    @OneToMany(targetEntity = Picture.class, mappedBy = "route")
    private Set<Picture> pictures;

    @ManyToMany
    private Set<Category> categories;
    public Route() {
        this.comments = new HashSet<>();
        this.pictures = new HashSet<>();
        this.categories = new HashSet<>();
    }

}
