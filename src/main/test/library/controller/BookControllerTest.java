package library.controller;

import library.model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class BookControllerTest {

	private BookController bookController;

	@Before
	public void setUp() throws Exception {
		bookController = new BookController();
	}

	@Test
	public void shouldReturnBookNameOfProvidedBook(){
		String bookName = "bookName";
		Book expectedBookName = bookController.book(bookName);
		assertThat(expectedBookName.getName()).isEqualTo(bookName);
	}

}
