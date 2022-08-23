package com.xuanxie.dao;

import com.xuanxie.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BooksMapper {
    int addBooks( Books books);
    int deleteBooks(@Param("bookID")int id);
    Books getBooksById(@Param("bookID")int id);
    int updateBook(Books books);
    List<Books> queryAllBooks();
    List<Books> queryBooksLike(@RequestParam("bookName")String bookNamePattern);
}
