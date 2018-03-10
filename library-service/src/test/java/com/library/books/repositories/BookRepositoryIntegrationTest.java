package com.library.books.repositories;

import com.library.books.model.Book;
import com.palantir.docker.compose.DockerComposeRule;
import com.palantir.docker.compose.connection.waiting.HealthChecks;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Ignore("Tests are failing for docker. Need to find a way to fix.")
public class BookRepositoryIntegrationTest {

    @ClassRule
    public static DockerComposeRule docker = DockerComposeRule.builder()
            .file("src/test/resources/docker-compose.yml")
            .waitingForService("db", HealthChecks.toHaveAllPortsOpen())
            .skipShutdown(false)
            .build();

    @Autowired
    private BookRepository bookRepository;

    private String bookName = "Walking Dead: 1 Season";

    @Test
    public void shouldAddBook() {
        Book save = this.bookRepository.save(new Book(bookName));

        assertThat(save.getName()).isEqualTo(bookName);
    }

    @Test
    public void shouldReadBook() {
        Book save = this.bookRepository.save(new Book(bookName));

        Optional<Book> book = this.bookRepository.findById(save.getId());

        book.ifPresent(presentBook -> assertThat(presentBook.getName()).isEqualTo(bookName));
    }
}
