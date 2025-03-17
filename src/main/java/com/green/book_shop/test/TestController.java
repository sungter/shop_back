package com.green.book_shop.test;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("/1")
  public int test1(){
    return 5;
  }

  //첨부파일 연습 1
  @PostMapping("/upload1")
  public void upload1(){

  }




}
