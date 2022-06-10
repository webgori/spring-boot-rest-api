package kr.webgori.springbootrestapi.controller;

import jakarta.validation.Valid;
import kr.webgori.springbootrestapi.dto.LoginDto;
import kr.webgori.springbootrestapi.dto.RegisterDto;
import kr.webgori.springbootrestapi.dto.UserInfoDto;
import kr.webgori.springbootrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("{user-id}")
  public EntityModel<UserInfoDto.UserDto> getUserInfo(@PathVariable("user-id") int userId) {
    return userService.getUserInfo(userId);
  }

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public EntityModel<RegisterDto.ResponseDto> register(
      @Validated @RequestBody RegisterDto.RequestDto requestDto) {
    return userService.register(requestDto);
  }

  @PostMapping("login")
  public EntityModel<LoginDto.ResponseDto> login(
      @RequestBody @Valid LoginDto.RequestDto requestDto) {
    return userService.login(requestDto);
  }
}
