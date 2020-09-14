// Class for an Article. It should have a title, an author, and a reference to the Issue in which it appears (if any).

package data;

public class Article {
  private String _title;
  private String _author;
  private Issue _issue;

  public Article(String title, String author) {
    this(title, author, null);
  }

  public Article(String title, String author, Issue issue) {
    setTitle(title);
    setAuthor(author);
    setIssue(issue);
  }

  ////
  // getters
  public String getTitle() {
    return _title;
  }

  public String getAuthor() {
    return _author;
  }

  public Issue getIssue() {
    return _issue;
  }

  ////
  // setters
  public void setTitle(String title) {
    _title = title;
  }

  public void setAuthor(String author) {
    _author = author;
  }

  public void setIssue(Issue issue) {
    _issue = issue;
  }
}
