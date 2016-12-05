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

    @Test
    public void shouldAddBook() throws Exception {
        String bookName = "Waling Dead: 1 Season";
        long bookId = 123L;

        Book save = this.bookRepository.save(new Book(bookId, bookName));

        assertThat(save.getName()).isEqualTo(bookName);
    }
}
