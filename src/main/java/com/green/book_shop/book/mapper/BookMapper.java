package com.green.book_shop.book.mapper;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.dto.ImgDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
  //카테고리 목록 조회 쿼리
  public List<BookCategoryDTO> getCategory();

  //도서 등록 쿼리
  public void regBook(BookDTO bookDTO);

  //카테고리 등록 쿼리
  public int regCategory(BookCategoryDTO bookCategoryDTO);

  //카테고리명 중복 확인 쿼리 (유효성 검사)
  public String isUsableCateName(String cateName);

  //카테고리 수정 쿼리
  public void updateCategory(BookCategoryDTO bookCategoryDTO);

  //카테고리 삭제 쿼리
  public void deleteCategory(int cateCode);

  //도서 이미지 등록 쿼리
  //public void insertImgs(List<ImgDTO> imgList);
  public void insertImgs(BookDTO bookDTO); //BookDTO 안 자료형이 List<ImgDTO> imgList 있음

  //다음에 등록할 BOOK_CODE를 조회하는 쿼리
  public int getNextBookCode();

  public BookCategoryDTO getCategoryByCateCode(int cateCode);
}
