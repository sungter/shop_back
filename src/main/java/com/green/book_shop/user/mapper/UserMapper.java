package com.green.book_shop.user.mapper;

import com.green.book_shop.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  //회원 가입을 위한 쿼리
  public int insertUser(UserDTO userDTO);

  //회원 가입 아이디 유효성 검사 쿼리
  public String isUsableId(String userId);

  //회원 가입 전화번호 유효성 검사 쿼리
  public String isUsableTel(String userTel);

  //로그인 확인 쿼리
  public UserDTO login(UserDTO userDTO);
}
