package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.model.enums.CategoryType;
import bg.softuni.pathfinder.model.enums.Level;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class RouteAddDTO {
    private String name;
    private String description;
    private MultipartFile gpxCoordinates;
    private Level level;
    private String videoUrl;

    //private List<CategoryType> categories;

    public RouteAddDTO() {
        //this.categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

//    public List<CategoryType> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(List<CategoryType> categories) {
//        this.categories = categories;
//    }
}
