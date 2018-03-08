package com.library.books.repositories;

import com.library.books.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@PropertySource("classpath:application-dev.properties")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private String bookName = "Waling Dead: 1 Season";

    @Test
    public void shouldAddBook() throws Exception {
        Book save = this.bookRepository.save(new Book(bookName));

        assertThat(save.getName()).isEqualTo(bookName);
    }

    @Test
    public void shouldReadBook() throws Exception {
        Book save = this.bookRepository.save(new Book(bookName));

        Optional<Book> book = this.bookRepository.findById(save.getId());

        book.ifPresent(presentBook -> assertThat(presentBook.getName()).isEqualTo(bookName));
    }
}
