package kr.webgori.springbootrestapi.dto;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

public class MainDto {
  private MainDto() {
    throw new IllegalStateException("Utility class");
  }

  @AllArgsConstructor
  public static class ResponseDto extends RepresentationModel<ResponseDto> {

  }
}
