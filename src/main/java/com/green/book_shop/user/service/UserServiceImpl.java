package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserMapper userMapper;

  @Override
  public int insertUser(UserDTO userDTO) {
    int result = 0;

    String userId = userMapper.isUsableId(userDTO.getUserId());
    String userTel = userMapper.isUsableTel(userDTO.getUserTel());

    if(userId != null){
      result = 2;
    }

    if(userTel != null){
      result = 3;
    }

    if (userId == null && userTel == null){
      result = userMapper.insertUser(userDTO);
    }

    return result;
  }

  @Override
  public UserDTO login(UserDTO userDTO) {
    return userMapper.login(userDTO);
  }

}
