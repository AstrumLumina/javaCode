package com.xuanxie.service;

import com.xuanxie.dao.BooksMapper;
import com.xuanxie.pojo.Books;

import java.util.List;

public class BooksServiceImpl implements BooksService{
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBooks(Books books) {
        return booksMapper.addBooks(books);
    }

    @Override
    public int deleteBooks(int id) {
        return booksMapper.deleteBooks(id);
    }

    @Override
    public Books getBooksById(int id) {
        return booksMapper.getBooksById(id);
    }

    @Override
    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    @Override
    public List<Books> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }

    @Override
    public List<Books> booksNameLike(String bookNamePattern) {
        return booksMapper.queryBooksLike(bookNamePattern);
    }
}
