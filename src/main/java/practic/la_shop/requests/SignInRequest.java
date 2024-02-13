package practic.la_shop.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class SignInRequest {

    @Schema(example = "qwerty@mail.ru")
    @NotBlank
    private String email;

    @Schema(example = "password")
    @NotBlank
    private String password;
}
