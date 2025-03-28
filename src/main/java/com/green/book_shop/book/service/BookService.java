package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;

import java.util.List;

public interface BookService {
  //카테고리 목록 조회 기능
  public List<BookCategoryDTO> getCategory();

  //도서 등록 기능
  public void regBook(BookDTO bookDTO);

  //카테고리 등록 기능
  public int regCategory(BookCategoryDTO bookCategoryDTO);

  //카테고리 수정 기능
  public void updateCategory(BookCategoryDTO bookCategoryDTO);

  //카테고리 삭제 기능
  public void deleteCategory(int cateCode);

  //도서 이미지 등록 기능
  public void insertImgs(BookDTO bookDTO);

  //다음에 등록할 BOOK_CODE를 조회하는 기능
  public int getNextBookCode();

  public BookCategoryDTO getCategoryByCateCode(int cateCode);
}
