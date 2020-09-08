
// A bookcase should be able to hold up to 10 books on each of 5 distinct shelves. A book can be added or removed from the shelf it is on. If removed, a reference to the book should be provided to whoever was asking to remove it.

// Are shelves chosen by the user when adding a book  - YES

// Do shelves need to be chosen by the user when removing a book - YES

// 1. A book can be added to a specific shelf
// 2. A book can be removed from the shelf it is on (Does shelf need to be specified)
// 3. If removed, a reference to the book should be provided to whoever was asking to remove it.

public class Bookcase {
  private static final int SHELF_LIMIT = 5;

  private String _name; // bookcase name
  private Shelf[] _shelves; // array of shelves

  public Bookcase(String name) {
    _name = name;
    _shelves = new Shelf[SHELF_LIMIT];
    for (int i = 0; i < SHELF_LIMIT; i++) {
      _shelves[i] = new Shelf(null);
    }
  }

  private class Shelf {
    private static final int _BOOK_LIMIT = 10;

    private Book _listHead;
    private int _itemCount; // number of books stored

    public Shelf(Book listHead) {
      _listHead = listHead;
      _itemCount = 0;
    }

    ////
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

    // add a book to a shelf
    // If the bookshelf has space, return true, else return false
    public boolean addBook(Book book) {
      if (getItemCount() < getBookLimit()) {
        _listHead = book.addBookToBeginning(_listHead);
        _itemCount++;
        System.out.println(book.getTitle() + " added to shelf");
        System.out.println("-------------------");
        return true;
      } else {
        System.out.println("Bookshelf is full");
        System.out.println("-------------------");
        return false;
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
        System.out.println(bookToReturn.getTitle() + " by " + bookToReturn.getAuthor() + " removed from shelf");
      }
      return bookToReturn;
    }
  }

  // Print all books on a current shelf
  public void printBooksOnShelf(int shelfToPrint) {
    Shelf currShelf = _shelves[shelfToPrint];
    Book currentBook = currShelf._listHead;
    System.out.println("Shelf " + shelfToPrint + ":");
    if (currentBook == null) {
      System.out.println("This shelf is empty");
    } else {
      while (currentBook != null) {
        System.out.println("Title: " + currentBook.getTitle());
        System.out.println("Author: " + currentBook.getAuthor());
        System.out.println("ISBN: " + currentBook.getISBN());
        System.out.println("Next: " + currentBook.getNext());
        System.out.println("");
        currentBook = currentBook.getNext();
      }
    }
    System.out.println("-------------------");
  }

  ////

  public String getName() {
    return _name;
  }

  public Shelf[] getShelves() {
    return _shelves;
  }

  // Add book to specific shelf by index of shelf if the shelf index is valid
  // Otherwise print that the shelf doesn't exist
  // If book added, return true, otherwise false
  public boolean addBookToShelf(Book newBook, int shelf) {
    if (shelf < SHELF_LIMIT && shelf >= 0) {
      Shelf currShelf = _shelves[shelf];
      boolean bookAdded = currShelf.addBook(newBook);
      return bookAdded;
    } else {
      System.out.println("Shelf doesn't exist");
      System.out.println("-------------------");
      return false;
    }
  }

  // Remove a book from a shelf if the shelf index is valid
  // Otherwise print that the shelf doesn't exist
  // If book removed, return the book, otherwise empty book with ISBN -1
  public Book removeBookFromShelf(Book bookToRemove, int shelf) {
    if (shelf < SHELF_LIMIT && shelf >= 0) {
      Shelf currShelf = _shelves[shelf];
      Book removedBook = currShelf.removeBook(bookToRemove);
      return removedBook;
    } else {
      System.out.println("Shelf doesn't exist");
      System.out.println("-------------------");
      return new Book("", "", -1);
    }
  }
}
