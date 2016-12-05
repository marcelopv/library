package library.repository;

import library.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    private String bookName = "Waling Dead: 1 Season";

    @Test
    public void shouldAddBook() throws Exception {
        Book save = this.bookRepository.save(new Book(bookName));

        assertThat(save.getName()).isEqualTo(bookName);
    }

    @Test
    public void shouldReadBook() throws Exception {
        Book save = this.bookRepository.save(new Book(bookName));

        Book book = this.bookRepository.findOne(save.getId());

        assertThat(book.getName()).isEqualTo(bookName);
    }
}
