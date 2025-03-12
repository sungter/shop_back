package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homes")
@RequiredArgsConstructor
public class BookListController {
  private final BookListService bookService;

  @GetMapping("")
  public List<BookDTO> getBookList(){
    return bookService.getBookList();
  }

  @GetMapping("/{cateCode}")
  public List<BookDTO> getBook(@PathVariable("cateCode") int cateCode){
    return bookService.getBook(cateCode);
  }
}
