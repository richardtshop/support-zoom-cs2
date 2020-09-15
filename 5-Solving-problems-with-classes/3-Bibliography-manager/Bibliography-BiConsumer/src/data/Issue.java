// Class for an Issue. It should have the year it was published, a volume number, an issue number, an ArrayList of Articles, and a reference to the Journal under which it was published.

package data;

import java.util.ArrayList;

public class Issue {

  private int _year;
  private int _volume;
  private int _issueNumber;
  private ArrayList<Article> _articles;
  private Journal _journal;

  // constructor
  public Issue(int year, int volume, int issueNumber) {
    this(year, volume, issueNumber, null);
  }

  public Issue(int year, int volume, int issueNumber, Journal journal) {
    setYear(year);
    setVolume(volume);
    setIssueNumber(issueNumber);
    setArticles();
    setJournal(journal);
  }

  ////
  // getters
  public int getYear() {
    return _year;
  }

  public int getVolume() {
    return _volume;
  }

  public int getIssueNumber() {
    return _issueNumber;
  }

  public ArrayList<Article> getArticles() {
    return _articles;
  }

  public Journal getJournal() {
    return _journal;
  }

  ////
  // setters
  public void setYear(int year) {
    _year = year;
  }

  public void setVolume(int volume) {
    _volume = volume;
  }

  public void setIssueNumber(int issueNumber) {
    _issueNumber = issueNumber;
  }

  public void setArticles() {
    _articles = new ArrayList<Article>();
  }

  public void setJournal(Journal journal) {
    _journal = journal;
  }

  // other methods

  public void addArticle(Article articleToAdd) {
    System.out.println("Article added");
    _articles.add(articleToAdd);
  }

  public void removeArticle(Article articleToRemove) {
    System.out.println("Article removed");
    _articles.remove(articleToRemove);
  }
}
