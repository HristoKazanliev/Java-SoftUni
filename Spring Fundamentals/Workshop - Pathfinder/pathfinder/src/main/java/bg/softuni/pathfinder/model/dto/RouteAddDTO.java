package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.model.enums.CategoryType;
import bg.softuni.pathfinder.model.enums.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RouteAddDTO {
    private String name;
    private String description;
    private MultipartFile gpxCoordinates;
    private Level level;
    private String videoUrl;

    //private List<CategoryType> categories;

//    public RouteAddDTO() {
        //this.categories = new ArrayList<>();
//    }

    //    public List<CategoryType> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(List<CategoryType> categories) {
//        this.categories = categories;
//    }
}
