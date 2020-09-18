
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

  // Print all books on a current shelf
  public void printBooksOnShelf(int shelfToPrint) {
    Shelf currShelf = _shelves[shelfToPrint];
    Book currentBook = currShelf.getListHead();
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

  // getters

  public String getName() {
    return _name;
  }

  public Shelf[] getShelves() {
    return _shelves;
  }

  // Return book to shelf
  // take a book from the reader and get the index of the shelf it was on
  // (this needs to be stored in shelf when it is removed)
  // and then call addBookToShelf with the current index
  public boolean returnBookToShelf(Book bookToReturn) {
    // get the index of where the book was, and then use the addBookToShelf method

    int shelfIndex = -1;
    // loop through each shelf
    for (int i = 0; i < SHELF_LIMIT; i++) {
      if (_shelves[i].checkISBN(bookToReturn.getISBN())) {
        // if isbn mataches a book that was previously stored on the shelves, set
        // shelfIndex this shelf
        shelfIndex = i;
      }
    }
    if (shelfIndex == -1) {
      return false;
    } else {
      // if valid shelf index, use this index to return the book
      addBookToShelf(bookToReturn, shelfIndex);
      return true;
    }
  }

  public boolean returnBookToShelf(Book bookToReturn, int shelf) {
    return addBookToShelf(bookToReturn, shelf);
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

  // remove a book if it exists on any shelf
  public Book removeBookFromShelf(Book bookToRemove) {
    // get index
    int shelfIndex = -1;

    // get the index that a book is on
    for (int i = 0; i < SHELF_LIMIT; i++) {

      // if book exists on shelf, use this shelf index
      if (_shelves[i].isBookOnShelf(bookToRemove)) {
        shelfIndex = i;
        i = SHELF_LIMIT;
      }
    }

    if (shelfIndex != -1) {
      Book removedBook = removeBookFromShelf(bookToRemove, shelfIndex);
      return removedBook;
    } else {
      // if valid shelf index, use this index to get the book
      return new Book("", "", -1);
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
