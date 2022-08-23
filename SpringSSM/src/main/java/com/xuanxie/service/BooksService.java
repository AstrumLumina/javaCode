package com.xuanxie.service;

import com.xuanxie.dao.BooksMapper;
import com.xuanxie.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksService {
    int addBooks( Books books);
    int deleteBooks(int id);
    Books getBooksById(int id);
    int updateBook(Books books);
    List<Books> queryAllBooks();
    List<Books> booksNameLike(String bookNamePattern);
}
