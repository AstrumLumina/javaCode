package com.xuanxie.controller;

import com.xuanxie.pojo.Books;
import com.xuanxie.service.BooksService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired()
    @Qualifier("booksServiceImpl")
    private BooksService booksService;

    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    //查询所有的书籍
    @RequestMapping("/allBook")
    public String getAllBook(Model model){
        List<Books> books = booksService.queryAllBooks();
        model.addAttribute("list",books);
        return "allBook";
    }

    //跳转到添加书籍的也页面
    @RequestMapping("/toAddBookPage")
    public String addBookPage(){
        return "addBookPage";
    }
    //添加书籍,返回到书籍列表页
    @RequestMapping("/addBook")
    public String addBook(Books books){
        booksService.addBooks(books);
        return "redirect:/book/allBook";
    }

    //跳转到修改书籍的页面
    @RequestMapping("/toUpdateBookPage")
    public String updateBookPage(@RequestParam("bookID") int id, Model model){
        System.out.println("+++++++++++++++++++++");
        System.out.println(id);
        System.out.println("++++++++++++++++++++++++++");
        model.addAttribute("book",booksService.getBooksById(id));
        return "updateBookPage";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        booksService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook")
    public String updateBookPage(@RequestParam("bookID")int id){
        booksService.deleteBooks(id);
        return "redirect:/book/allBook";
    }

    //查询所有可能的书籍
    @RequestMapping("/booksLike")
    public String getBookLike(@RequestParam("bookName") String bookNamePatter,Model model){
        List<Books> books = booksService.booksNameLike(bookNamePatter);
        model.addAttribute("list",books);
        return "allBook";
    }

}
