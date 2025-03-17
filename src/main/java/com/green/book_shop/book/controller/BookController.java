package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;

  //도서 등록 api
  @PostMapping("")
  public void regBook(@RequestBody BookDTO bookDTO){
    //첨부파일(도서 이미지) 업로드


    //book 테이블에 데이터 insert
    bookService.regBook(bookDTO);
  }
}
