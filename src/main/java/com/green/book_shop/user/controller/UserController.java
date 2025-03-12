package com.green.book_shop.user.controller;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  //회원가입
  @PostMapping("")
  public int insertUser(@RequestBody UserDTO userDTO){
    return userService.insertUser(userDTO);
  }

  //조회이기 때문에 GetMapping 방식으로 진행하는게 맞지만,
  //PostMapping으로 사용하는 이유는 ?
  //@PathVariable, @RequestParam으로 전달되는 데이터는
  //url에 노출됨 => id,pw 유출 우려
  //but, GetMapping으로 받아서 axios에서 데이터를 보낼때 params방식으로 데이터를 넘겨주어 DTO로 받으면 사용 가능
  @GetMapping("/login")
  public UserDTO login(UserDTO userDTO){
    //조회된 데이터가 있다면, 로그인 가능! -> loginUser 가 null이 아니다.
    //조회된 데이터가 없다면, 로그인 불가능! -> loginUser 가 null이다.
    UserDTO loginUser = userService.login(userDTO);

    return loginUser;
  }

}
