package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.dto.ImgDTO;
import com.green.book_shop.book.service.BookService;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;
  private final UploadUtil uploadUtil;

  //도서 등록 api
  @PostMapping("")
  public void regBook(
        BookDTO bookDTO,
        @RequestParam(name = "mainImg", required = true)MultipartFile mainImg ,
        @RequestParam(name = "subImg", required = true) MultipartFile subImg){

    //첨부파일(도서 이미지) 업로드
    String mainAttachedFileName = uploadUtil.fileUpload(mainImg); // attachFileName = 첨부된 파일명
    String subAttachFileName = uploadUtil.fileUpload(subImg);

    //다음에 들어갈 bookCode 조회
    int nextBookCode = bookService.getNextBookCode();
    bookDTO.setBookCode(nextBookCode);

    //book 테이블에 데이터 insert
    bookService.regBook(bookDTO);

    //bookDTO에 이미지 데이터 저장
    List<ImgDTO> imgList = new ArrayList<>();

    ImgDTO mainImgDTO = new ImgDTO();
    mainImgDTO.setOriginFileName(mainImg.getOriginalFilename());
    mainImgDTO.setAttachedFileName(mainAttachedFileName);
    mainImgDTO.setIsMain("Y");
    mainImgDTO.setBookCode(nextBookCode);

    ImgDTO subImgDTO = new ImgDTO();
    subImgDTO.setOriginFileName(subImg.getOriginalFilename());
    subImgDTO.setAttachedFileName(subAttachFileName);
    subImgDTO.setIsMain("N");
    subImgDTO.setBookCode(nextBookCode);

    imgList.add(mainImgDTO);
    imgList.add(subImgDTO);

    bookDTO.setImgList(imgList);

    //BOOK_IMG 테이블에 도서 이미지 정보 INSERT
    bookService.insertImgs(bookDTO);
  }
}
