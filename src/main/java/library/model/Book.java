package library.model;

public class Book {

  private long id;
  private String name;

  public Book(long id, String name){
    this.id = id;
    this.name = name;
  }

  public long getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

}
