package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.mapper.BookListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookListServiceImpl implements BookListService {
  private final BookListMapper bookMapper;

  @Override
  public List<BookDTO> getBookList() {
    return bookMapper.getBookList();
  }

  @Override
  public List<BookDTO> getBook(int cateCode) {
    return bookMapper.getBook(cateCode);
  }


}
