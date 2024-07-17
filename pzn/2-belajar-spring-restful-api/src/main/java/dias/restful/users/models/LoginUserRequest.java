package dias.restful.users.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoginUserRequest {

    @NotBlank
    @Size(max = 255)

    private String username;

    @Size(max = 255)

    @NotBlank
    private String password;

}
