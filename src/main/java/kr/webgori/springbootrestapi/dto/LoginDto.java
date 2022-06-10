package kr.webgori.springbootrestapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

public class LoginDto {
  private LoginDto() {
    throw new IllegalStateException("Utility class");
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class RequestDto {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
  }

  public static class ResponseDto extends RepresentationModel<ResponseDto> {

  }
}
