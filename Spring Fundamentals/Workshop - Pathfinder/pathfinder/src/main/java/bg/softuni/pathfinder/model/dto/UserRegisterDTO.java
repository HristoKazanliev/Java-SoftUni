package bg.softuni.pathfinder.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterDTO {
    @Size(min = 2)
    @NotBlank
    private String username;
    @Size(min = 5)
    @NotEmpty
    private String fullName;
    @Email
    private String email;
    @Min(0)
    @Max(90)
    private Integer age;
    @Size(min = 5)
    private String password;

    private String confirmPassword;

}
