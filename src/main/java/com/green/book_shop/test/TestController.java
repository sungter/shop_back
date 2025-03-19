package com.green.book_shop.test;

import com.green.book_shop.book.dto.BookDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("/1")
  public int test1(){
    return 5;
  }

  //첨부파일을 자바에서 받기 위해서 FormData 객체를 사용했다.
  //전달되는 데이터의 형태도 multipart/form-data 형식으로 변환해서 전달.
  //전달된 데이터를 받기 위한 코드를 변경했기 때문에
  //평소랑 다르게 데이터를 전달받아야함
  //DTO 객체로 전달된 데이터를 받지만, @RequestBody 어노테이션은 사용하지 않는다.
  //DTO 객체로 첨부파일 정보를 받는 것은 아니다.
  //첨부파일 데이터를 받을때, MultipartFile 객체를 사용한다.
  //첨부파일 연습 1
  @PostMapping("/upload1")
  public void upload1(BookDTO bookDTO, @RequestParam("firstFile") MultipartFile file){
    System.out.println(bookDTO);
    System.out.println("첨부된 원본 파일명 : " + file.getOriginalFilename());

    //업로드 가능 경로(경로에 한글 있다면 안될수도 있음)
    String uploadPath = "D:\\01-STUDY\\devel\\ShopProject\\backEnd\\book_shop\\src\\main\\resources\\upload\\";

    //첨부한 원본 파일명
    String attachedFileName = file.getOriginalFilename();

    //업로드 경로, 파일명을 연결
    //java.io 클래스 File
    File f = new File(uploadPath + attachedFileName);


    try {
      //파일 첨부
      file.transferTo(f);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }




}
