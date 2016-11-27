package library.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  public Book(Long id, String name){
    this.id = id;
    this.name = name;
  }

  public Book(String name){
    this.name = name;
  }

  public Book(){

  }

  public Long getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

}
