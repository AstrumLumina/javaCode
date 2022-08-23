package serviceTest;

import com.xuanxie.pojo.Books;
import com.xuanxie.service.BooksService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceTest {

    @Test
    public void getAllBook(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService booksServiceImpl = context.getBean("booksServiceImpl", BooksService.class);
        for (Books queryAllBook : booksServiceImpl.queryAllBooks()) {
            System.out.println(queryAllBook);
        }
    }

    @Test
    public void lombokTest(){
        Books books = new Books();
        System.out.println(books.getBookID());
        System.out.println(books.getDetail());
    }


}
