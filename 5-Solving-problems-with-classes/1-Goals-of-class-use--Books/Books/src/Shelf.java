import java.util.ArrayList;

public class Shelf {
  private static final int _BOOK_LIMIT = 10;

  private Book _listHead;
  private int _itemCount; // number of books stored
  private ArrayList<Book> _bookReferences; // Reference of ISBNs stored on the shelf, even if they have been removed

  public Shelf(Book listHead) {
    _listHead = listHead;
    _itemCount = 0;
    _bookReferences = new ArrayList<Book>();
  }

  // getters

  public int getBookLimit() {
    return _BOOK_LIMIT;
  }

  public Book getListHead() {
    return _listHead;
  }

  public int getItemCount() {
    return _itemCount;
  }

  public boolean checkISBN(Integer isbn) {

    if (_bookReferences.size() == 0) {
      return false;
    } else {
      boolean bookFound = false;
      for (Book bookRef : _bookReferences) {
        if (bookRef.getISBN() == isbn) {
          bookFound = true;
        }
      }
      return bookFound;
    }
  }

  // add a book to a shelf
  // If the bookshelf has space, return true, else return false
  public boolean addBook(Book book) {
    if (getItemCount() < getBookLimit()) {
      _listHead = book.addBookToBeginning(_listHead);
      _itemCount++;
      // Remove reference to books that were on this shelf
      _bookReferences.remove(book);
      System.out.println(book.getTitle() + " added to shelf");
      System.out.println("-------------------");
      return true;
    } else {
      System.out.println("Bookshelf is full");
      System.out.println("-------------------");
      return false;
    }
  }

  // check if a book exists on a shelf
  public boolean isBookOnShelf(Book bookToCheck) {
    if (getListHead() == null) {
      return false;
    } else {
      if (_listHead.getISBN() == bookToCheck.getISBN()) {
        return true;
      } else {
        Book currBook = _listHead;

        while (currBook.getNext() != null && currBook.getNext().getISBN() != bookToCheck.getISBN()) {
          currBook = currBook.getNext();
        }
        if (currBook.getNext() != null) {
          return true;
        } else {
          return false;
        }
      }
    }

  }

  // remove a book. Return the removed book if it exists, otherwise return an
  // empty book with ISBN -1 and update total count for shelf
  public Book removeBook(Book bookToRemove) {
    Book bookToReturn;
    Book bookNotFound = new Book("", "", -1);
    if (getListHead() == null) {
      return bookNotFound;
    } else {
      if (_listHead.getISBN() == bookToRemove.getISBN()) {
        _listHead = _listHead.getNext();
        bookToReturn = bookToRemove;
        _itemCount--;
      } else {
        Book currBook = _listHead;

        while (currBook.getNext() != null && currBook.getNext().getISBN() != bookToRemove.getISBN()) {
          currBook = currBook.getNext();
        }

        if (currBook.getNext() != null) {
          currBook.addBookToBeginning(currBook.getNext().getNext());
          bookToReturn = bookToRemove;
          _itemCount--;
        } else {
          bookToReturn = bookNotFound;
        }
      }
    }
    if (bookToReturn.getISBN() != -1) {
      // Add reference to removed book
      _bookReferences.add(bookToReturn);
      System.out.println(bookToReturn.getTitle() + " by " + bookToReturn.getAuthor() + " removed from shelf");
    }
    return bookToReturn;
  }
}