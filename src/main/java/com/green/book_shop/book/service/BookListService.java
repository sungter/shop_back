package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookDTO;

import java.util.List;

public interface BookListService {
  //책 목록 리스트 조회 기능
  public List<BookDTO> getBookList();

  //카테고리 선택시 책 목록 리스트 조회 기능
  public List<BookDTO> getBook(int cateCode);
}
