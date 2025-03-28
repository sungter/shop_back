package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class BookCategoryController {
  private final BookService bookService;

  /// 카테고리 목록
  @GetMapping("")
  public ResponseEntity<?> getCategory(){

    try {
      List<BookCategoryDTO> list = bookService.getCategory();

      return ResponseEntity
              .status(HttpStatus.OK)
              .body(list);
    }catch (Exception e){
      e.printStackTrace();

//      return ResponseEntity
//              .status(HttpStatus.INTERNAL_SERVER_ERROR)
//              .body("카테고리 목록 조회 중 서버 오류 발생");
      //body()로 전달할 내용을 넣고 싶지 않을때 build()로 종료
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .build();
    }
  }

  /// 카테고리 등록
  @PostMapping("")
  public ResponseEntity<?> regCategory(@RequestBody BookCategoryDTO bookCategoryDTO){

    int result = bookService.regCategory(bookCategoryDTO);

    //created : 등록 성공 (201번) post에서 사용
    return ResponseEntity
            .status(result == 1 ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR)
            .body(result == 1 ? result : "알수없는 이유로 등록이 되지 않았습니다.");
  }

  @PutMapping("")
  public void updateCategory(@RequestBody BookCategoryDTO bookCategoryDTO){
    bookService.updateCategory(bookCategoryDTO);
  }

  @DeleteMapping("/{cateCode}")
  public void deleteCategory(@PathVariable("cateCode") int cateCode){
    bookService.deleteCategory(cateCode);
  }




  /// practice//////////////////////////////////////////////
  @GetMapping("/test1")
  public ResponseEntity<String> test1(){
    return ResponseEntity.status(HttpStatus.OK).body("JAVA");
  }

  @GetMapping("/test2")
  public ResponseEntity<Integer> test2(){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(10);
  }

  @GetMapping("/test3")
  public ResponseEntity<List<BookCategoryDTO>> test3(){
    List<BookCategoryDTO> list = bookService.getCategory();

    return ResponseEntity.status(HttpStatus.OK).body(list);
  }

  @GetMapping("/test4")
  public ResponseEntity<String> test4(){
    HttpHeaders headers = new HttpHeaders();
    headers.add("myName" , "hong");
    headers.add("myAge" , "20");

    return ResponseEntity.status(HttpStatus.OK).headers(headers).body("java");
  }

  @GetMapping("/test5/{cateCode}")
  public ResponseEntity<?> test5(@PathVariable("cateCode") int cateCode){

    try {
      //예외가 날 수 있는 코드 작성
      BookCategoryDTO resultDTO = bookService.getCategoryByCateCode(cateCode);

      return ResponseEntity
              .status(resultDTO == null ? HttpStatus.NOT_FOUND : HttpStatus.OK)
              .body(resultDTO == null ? "정보가 없습니다." : resultDTO);
    }catch (Exception e){
      //예외가 발생했을 때 실행할 코드
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("서버 오류 발생");
    }

  }
  /// //////////////////////////////////////////////////////////////////////////////////////////////


}
