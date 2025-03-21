package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;
  private final UploadUtil uploadUtil;

  //도서 등록 api
  @PostMapping("")
  public void regBook(BookDTO bookDTO, @RequestParam(name = "mainImg", required = false)MultipartFile mainImg , @RequestParam(name = "detailImg") MultipartFile detailImg){
    System.out.println(bookDTO);
    //첨부파일(도서 이미지) 업로드
    uploadUtil.fileUpload(mainImg);
    uploadUtil.fileUpload(detailImg);

    //book 테이블에 데이터 insert
//    bookService.regBook(bookDTO);
  }
}
