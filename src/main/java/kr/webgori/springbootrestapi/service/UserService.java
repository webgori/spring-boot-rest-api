package kr.webgori.springbootrestapi.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import kr.webgori.springbootrestapi.controller.MainController;
import kr.webgori.springbootrestapi.controller.UserController;
import kr.webgori.springbootrestapi.dto.LoginDto;
import kr.webgori.springbootrestapi.dto.RegisterDto;
import kr.webgori.springbootrestapi.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
  private static final String REL_PROFILE = "profile";
  private static final String LOCALHOST = "http://localhost:8080";

  private final ModelMapper modelMapper;

  public EntityModel<UserInfoDto.UserDto> getUserInfo(int userId) {
    UserInfoDto.User user = getUsers()
        .stream()
        .filter(u -> u.getUserId() == userId)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("can not found user"));

    UserInfoDto.UserDto userDto = modelMapper.map(user, UserInfoDto.UserDto.class);

    return EntityModel
        .of(userDto, linkTo(methodOn(UserController.class).getUserInfo(userId)).withSelfRel())
        .add(Link.of(LOCALHOST + "/swagger-ui/index.html?urls.primaryName=유저%20정보%20조회")
            .withRel(REL_PROFILE));
  }

  public EntityModel<RegisterDto.ResponseDto> register(RegisterDto.RequestDto requestDto) {
    return EntityModel
        .of(new RegisterDto.ResponseDto(),
            linkTo(methodOn(UserController.class).register(requestDto)).withSelfRel())
        .add(linkTo(methodOn(MainController.class).getMainInfo()).withRel("main"))
        .add(Link.of(LOCALHOST + "/swagger-ui/index.html?urls.primaryName=회원%20가입")
            .withRel(REL_PROFILE));
  }

  public EntityModel<LoginDto.ResponseDto> login(LoginDto.RequestDto requestDto) {
    return EntityModel
        .of(new LoginDto.ResponseDto(),
            linkTo(methodOn(UserController.class).login(requestDto)).withSelfRel())
        .add(linkTo(methodOn(MainController.class).getMainInfo()).withRel("main"))
        .add(Link.of(LOCALHOST + "/swagger-ui/index.html?urls.primaryName=로그인")
            .withRel(REL_PROFILE));
  }

  /**
   * 유저 더미 정보 조회 (라이엇 데이터)
   * https://www.leagueoflegends.com/en-us/champions/
   * @return 유저 더미 정보
   */
  private List<UserInfoDto.User> getUsers() {
    UserInfoDto.User leona = UserInfoDto.User
        .builder()
        .userId(1)
        .email("leona@riotgames.com")
        .username("leona")
        .password("38op4wfnjy65o3q")
        .point(100)
        .build();

    UserInfoDto.User ashe = UserInfoDto.User
        .builder()
        .userId(2)
        .email("ashe@riotgames.com")
        .username("ashe")
        .password("38op4wfnjy65o3q")
        .point(250)
        .build();

    return List.of(leona, ashe);
  }
}
