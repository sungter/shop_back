package com.green.book_shop.book.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImgDTO {
  private int imgCode;
  private String originFileName;
  private String attachedFileName;
  private String isMain;
  private int bookCode;

}
