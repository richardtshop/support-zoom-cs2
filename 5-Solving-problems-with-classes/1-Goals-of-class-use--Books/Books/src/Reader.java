public class Reader {
  private String _name;
  private Book _book;

  public Reader(String name) {
    _name = name;
    _book = null;
  }

  // getters
  public String getName() {
    return _name;
  }

  public Book getCurrentBook() {
    return _book;
  }

  // otherMethods
  public void getBook(Book book, Bookcase bookcase) {
    if (getCurrentBook() == null) {
      Book bookToCheck = bookcase.removeBookFromShelf(book);

      if (bookToCheck.getISBN() == -1) {
        System.out.println("Book cannot be found");
      } else {
        _book = bookToCheck;
      }
    } else {
      System.out.println("You cannot have more than one book at a time");
    }
    System.out.println("-------------------");
  }

  // return book to previous shelf
  public void returnBook(Bookcase bookcase) {
    if (getCurrentBook() != null) {
      boolean bookReturned = bookcase.returnBookToShelf(getCurrentBook());
      if (bookReturned) {
        _book = null;
      } else {
        System.out.println("Bookshelf is full");
      }
    } else {
      System.out.println("You don't have a book to return");
      System.out.println("-------------------");
    }
  }

  // return book to specific shelf
  public void returnBook(Bookcase bookcase, int shelf) {
    if (getCurrentBook() != null) {
      boolean bookReturned = bookcase.returnBookToShelf(getCurrentBook(), shelf);
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
