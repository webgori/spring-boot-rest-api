package kr.webgori.springbootrestapi.controller;

import kr.webgori.springbootrestapi.dto.MainDto;
import kr.webgori.springbootrestapi.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
  private final MainService mainService;

  @GetMapping("main")
  public EntityModel<MainDto.ResponseDto> getMainInfo() {
    return mainService.getMainInfo();
  }
}
