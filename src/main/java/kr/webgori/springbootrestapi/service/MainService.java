package kr.webgori.springbootrestapi.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import kr.webgori.springbootrestapi.controller.MainController;
import kr.webgori.springbootrestapi.controller.UserController;
import kr.webgori.springbootrestapi.dto.LoginDto;
import kr.webgori.springbootrestapi.dto.MainDto;
import kr.webgori.springbootrestapi.dto.RegisterDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

@Service
public class MainService {
  public EntityModel<MainDto.ResponseDto> getMainInfo() {
    return EntityModel
        .of(new MainDto.ResponseDto(),
            linkTo(methodOn(MainController.class).getMainInfo()).withSelfRel())
        .add(linkTo(methodOn(UserController.class).register(new RegisterDto.RequestDto()))
            .withRel("register"))
        .add(linkTo(methodOn(UserController.class).login(new LoginDto.RequestDto()))
            .withRel("login"))
        .add(linkTo(methodOn(UserController.class).getUserInfo(0))
            .withRel("userInfo"));
  }
}
