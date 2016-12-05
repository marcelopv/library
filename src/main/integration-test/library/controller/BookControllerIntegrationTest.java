package library.controller;

import library.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PropertySource("classpath:application.properties")
public class BookControllerIntegrationTest {

    private final String bookName = "Walking Dead: 1 Season";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addBook() throws Exception {
        Book book = new Book(bookName);

        ResponseEntity<Book> addedBook = this.restTemplate.postForEntity("/book", book, Book.class);

        assertThat(addedBook.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(addedBook.getBody().getName()).isEqualTo(bookName);
    }

    @Test
    public void findBook() throws Exception {
        Book book = new Book(bookName);

        ResponseEntity<Book> addedBookResponse = this.restTemplate.postForEntity("/book", book, Book.class);
        Long addedBookResponseId = addedBookResponse.getBody().getId();

        ResponseEntity<Book> bookResponse = this.restTemplate.getForEntity(String.format("/book/%d", addedBookResponseId), Book.class);

        assertThat(bookResponse.getBody().getId()).isEqualTo(addedBookResponseId);
    }

}
