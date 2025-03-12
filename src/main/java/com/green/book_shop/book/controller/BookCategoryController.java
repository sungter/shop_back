package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class BookCategoryController {
  private final BookService bookService;

  @GetMapping("")
  public List<BookCategoryDTO> getCategory(){
    return bookService.getCategory();
  }

  @PostMapping("")
  public int regCategory(@RequestBody BookCategoryDTO bookCategoryDTO){
    return bookService.regCategory(bookCategoryDTO);
  }

  @PutMapping("")
  public void updateCategory(@RequestBody BookCategoryDTO bookCategoryDTO){
    bookService.updateCategory(bookCategoryDTO);
  }

  @DeleteMapping("/{cateCode}")
  public void deleteCategory(@PathVariable("cateCode") int cateCode){
    bookService.deleteCategory(cateCode);
  }

}
