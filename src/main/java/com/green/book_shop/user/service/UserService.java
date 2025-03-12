package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;

public interface UserService {
  //회원 가입을 위한 기능
  public int insertUser(UserDTO userDTO);

  //로그인 확인 쿼리
  public UserDTO login(UserDTO userDTO);
}
