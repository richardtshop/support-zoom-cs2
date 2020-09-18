public class TestingBooks {
  public static void main(String[] args) {
    Book book1 = new Book("Once upon a time in Ottawa", "John McGee", 12536434);
    Book book2 = new Book("Montreal munchies", "David McGee", 353215);
    Book book3 = new Book("Toronto storm", "Billy Dee", 9253643);
    Book book4 = new Book("Book 4", "Donna Dee", 7925363);
    Book book5 = new Book("Book 5", "Sally Ivans", 121245);
    Book book6 = new Book("Book 6", "Juan Markio", 65744457);
    Book book7 = new Book("Book 7", "Helena Troy", 379367894);
    Book book8 = new Book("Book 8", "Miho Kim", 213575322);
    Book book9 = new Book("Book 9", "Mark Dennis", 47923451);
    Book book10 = new Book("Book 10", "Wendy Bow", 90653767);
    Book book11 = new Book("Book 11", "Doug", 76555347);
    Book book12 = new Book("Book 12", "Bort", 1609245905);

    // System.out.println(book1.getTitle());
    // System.out.println(book1.getAuthor());
    // System.out.println(book1.getISBN());

    Bookcase testBookcase = new Bookcase("Bookcase");
    Reader testReader = new Reader("Hugh");

    // Test generic adding and removing of books to shelves

    testBookcase.addBookToShelf(book1, 4);
    testBookcase.addBookToShelf(book2, 4);
    testBookcase.addBookToShelf(book3, 4);
    testBookcase.addBookToShelf(book4, 4);
    testBookcase.removeBookFromShelf(book1, 4);

    System.out.println("-------------------");
    System.out.println("-------------------");

    // Test reader taking and returning books from a specific bookshelf
    testReader.getBook(book1, testBookcase); // Book not found
    testReader.printReadersBook(); // User has no book
    testReader.returnBook(testBookcase); // No book to return
    testReader.getBook(book3, testBookcase); // Book removed
    testReader.getBook(book4, testBookcase); // Aready has book
    testReader.printReadersBook(); // Book 3
    testReader.returnBook(testBookcase); // Returned
    testReader.returnBook(testBookcase); // No book to return
    testReader.printReadersBook(); // User has no book
    testReader.getBook(book4, testBookcase); // Gets book 4
    testReader.printReadersBook(); // Book 4

    // print current state
    testBookcase.printBooksOnShelf(4); // Print books
    testBookcase.printBooksOnShelf(0); // No books on this shelf

    testBookcase.removeBookFromShelf(book2, 4); // listhead.next => null
    testBookcase.removeBookFromShelf(book2, 4); // null can't have a next

    // adding lots of books
    testBookcase.addBookToShelf(book4, 4);
    testBookcase.addBookToShelf(book5, 4);
    testBookcase.addBookToShelf(book6, 4);
    testBookcase.addBookToShelf(book7, 4);
    testBookcase.addBookToShelf(book8, 4);
    testBookcase.addBookToShelf(book9, 4);
    testBookcase.addBookToShelf(book10, 4);
    testBookcase.addBookToShelf(book11, 4);
    testBookcase.addBookToShelf(book12, 4);

    testReader.returnBook(testBookcase); // bookshelf full

    testBookcase.printBooksOnShelf(4);
  }
}
