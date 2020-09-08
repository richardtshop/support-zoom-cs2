// Books should have some key information, such as title, author, and ISBN (Links to an external site.).

public class Book {
  private String _title;
  private String _author;
  private int _ISBN;
  private Book _next;

  public Book(String title, String author, int ISBN) {
    _title = title;
    _author = author;
    _ISBN = ISBN;
    _next = null;
  }

  public String getTitle() {
    return _title;
  }

  public String getAuthor() {
    return _author;
  }

  public int getISBN() {
    return _ISBN;
  }

  public Book getNext() {
    return _next;
  }

  public void setListHead(Book newBook) {
    _next = newBook;
  }

  // add a book to the beginning of a shelf
  public Book addBookToBeginning(Book listHead) {
    this._next = listHead;
    return this;
  }
}
