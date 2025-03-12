package com.green.book_shop.book.mapper;

import com.green.book_shop.book.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookListMapper {
  //책 목록 리스트 조회 쿼리
  public List<BookDTO> getBookList();

  //카테고리 선택시 책 목록 리스트 조회 쿼리
  public List<BookDTO> getBook(int cateCode);
}
