package kr.webgori.springbootrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.RepresentationModel;

public class UserInfoDto {
  private UserInfoDto() {
    throw new IllegalStateException("Utility class");
  }

  @SuperBuilder
  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class User {
    private int userId;
    private String email;
    private String username;
    private String password;
    private int point;
  }

  @EqualsAndHashCode(callSuper = true)
  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class UserDto extends RepresentationModel<UserDto> {
    private int userId;
    private String email;
    private String username;
    private int point;
  }
}
