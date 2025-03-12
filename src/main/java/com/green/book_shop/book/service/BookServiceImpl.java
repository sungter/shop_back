package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
  private final BookMapper bookMapper;

  //카테고리 목록 조회
  @Override
  public List<BookCategoryDTO> getCategory() {
    return bookMapper.getCategory();
  }

  //도서 등록
  @Override
  public void regBook(BookDTO bookDTO) {
    bookMapper.regBook(bookDTO);
  }

  //카테고리 등록 기능
  @Override
  public int regCategory(BookCategoryDTO bookCategoryDTO) {
    int result = 0;
    //풀이; 카테고리 명이 중복인지 확인한다.
    //cateName이 null이면 사용가능한 카테고리명,
    //null이 아니면 중복데이터이기에 사용불가함 (유효성 검사)
    String cateName = bookMapper.isUsableCateName(bookCategoryDTO.getCateName());

    //풀이; 중복이 아닐경우 카테고리를 등록한다.
    if (cateName == null){
      result = bookMapper.regCategory(bookCategoryDTO);
    }
    return result;
  }

  //카테고리 수정 기능
  @Override
  public void updateCategory(BookCategoryDTO bookCategoryDTO) {
    bookMapper.updateCategory(bookCategoryDTO);
  }

  //카테고리 삭제 기능
  @Override
  public void deleteCategory(int cateCode) {
    bookMapper.deleteCategory(cateCode);
  }
}
