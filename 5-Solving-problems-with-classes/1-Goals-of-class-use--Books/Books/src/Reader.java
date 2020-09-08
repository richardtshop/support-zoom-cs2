public class Reader {
  private String _name;
  private Book _book;
  private int _shelfIndex;

  public Reader(String name) {
    _name = name;
    _book = null;
    _shelfIndex = -1;
  }

  ////
  // getters
  public String getName() {
    return _name;
  }

  public Book getCurrentBook() {
    return _book;
  }

  public int getShelfIndex() {
    return _shelfIndex;
  }
  ////
  // setters

  // otherMethods

  public void getBook(Book book, Bookcase bookcase, int shelf) {
    if (getCurrentBook() == null) {
      Book bookToCheck = bookcase.removeBookFromShelf(book, shelf);

      if (bookToCheck.getISBN() == -1) {
        System.out.println("Book cannot be found");
      } else {
        _book = bookToCheck;
        _shelfIndex = shelf;
      }
    } else {
      System.out.println("You cannot have more than one book at a time");
    }
    System.out.println("-------------------");
  }

  // return book to previous shelf
  public void returnBookToShelf(Bookcase bookcase) {
    returnBookToShelf(bookcase, getShelfIndex());
  }

  // return book to specific shelf
  public void returnBookToShelf(Bookcase bookcase, int shelf) {
    if (getCurrentBook() != null) {
      boolean bookReturned = bookcase.addBookToShelf(getCurrentBook(), shelf);
      if (bookReturned) {
        _book = null;
      }
    } else {
      System.out.println("You don't have a book to return");
      System.out.println("-------------------");
    }
  }

  public void printReadersBook() {
    if (getCurrentBook() == null) {
      System.out.println(_name + " currently has no book");
    } else {
      System.out.println(_name + " is holding " + _book.getTitle() + " by " + _book.getAuthor());
    }
    System.out.println("-------------------");
  }
}
