import com.ssm.bean.Book;
import com.ssm.dto.AppointExecution;
import com.ssm.mapper.BookMapper;
import com.ssm.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BookTest extends BaseTest{
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testQueryById() throws Exception {
        long bookId = 1000;
        Book book = bookMapper.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Book> books = bookMapper.queryAll(0, 2);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber() throws Exception {
        long bookId = 1000;
        int update = bookMapper.reduceNumber(bookId);
        System.out.println("update=" + update);
    }

    @Autowired
    private BookService bookService;
    @Test
    public void testAppoint() throws Exception{
        long bookId = 1002;
        long studentId = 12345678912L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }
}
