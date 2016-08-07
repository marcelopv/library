package controller;

import java.util.concurrent.atomic.AtomicLong;

import model.Book;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BookController {

  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/book")
  public Book book(@RequestParam(value="name") String name){
    return new Book(counter.incrementAndGet(), name);
  }

}
