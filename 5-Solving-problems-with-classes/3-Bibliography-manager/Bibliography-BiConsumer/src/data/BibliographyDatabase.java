package data;

import java.util.ArrayList;

public class BibliographyDatabase {
  private String _name;
  private ArrayList<Journal> _journals;

  public BibliographyDatabase(String name) {
    this(name, null);
  }

  public BibliographyDatabase(String name, ArrayList<Journal> journals) {
    setName(name);
    setJournals(journals);
  }

  ////
  // getters
  public String getName() {
    return _name;
  }

  public ArrayList<Journal> getJournals() {
    return _journals;
  }

  ////
  // setters
  public void setName(String name) {
    _name = name;
  }

  public void setJournals(ArrayList<Journal> journals) {
    _journals = journals;
  }

  ////
  // other methods

  // Add a new journal to the database
  public void addJournal(Journal journalToAdd) {
    // xxx check that journal doesn't already exist (check index to return -1)
    _journals.add(journalToAdd);
  }

  // find a journal index by title
  private int findJournalIndex(String journalTitle) {
    Journal journalFound = null;
    for (Journal journal : _journals) {
      // do I need to alter the default equals? xxx
      if (journal.getTitle().equals(journalTitle)) {
        journalFound = journal;
      }
    }

    if (journalFound != null) {
      return _journals.indexOf(journalFound);
    }
    // returns -1 if journal == null
    return -1;
  }

  // remove a journal index by titel
  public Journal removeJournalByTitle(String journalTitle) {
    int journalIndex = this.findJournalIndex(journalTitle);
    if (journalIndex != -1 && journalIndex < _journals.size()) {
      _journals.remove(journalIndex);
    }
    // xxx what do I want to return
    return null;
  }

  // add an issue to a specific journal
  // 2. check issue does not already exist xxx
  public void addIssue(String journalTitle, Issue issue) {
    int journalIndex = this.findJournalIndex(journalTitle);
    if (journalIndex != -1 && journalIndex < _journals.size()) {
      Journal journal = _journals.get(journalIndex);
      journal.addIssue(issue);
    }
  }

  // remove an issue from a specific journal by volume and issue number
  public void removeIssue(String journalTitle, int volume, int issueNumber) {
    int journalIndex = this.findJournalIndex(journalTitle);
    if (journalIndex != -1 && journalIndex < _journals.size()) {
      Journal journal = _journals.get(journalIndex);
      journal.removeIssue(volume, issueNumber);
    }
    // xxx what do I want to return
  }

  // add article to specific journal
  public void addArticle(String journalTitle, int volume, int issueNumber, Article articleToAdd) {
    int journalIndex = this.findJournalIndex(journalTitle);
    if (journalIndex != -1 && journalIndex < _journals.size()) {
      Journal journal = _journals.get(journalIndex);
      int issueIndex = journal.findIssueIndex(volume, issueNumber);
      if (issueIndex != -1) {
        Issue issue = journal.getIssues().get(issueIndex);
        // add issue reference to article before adding article to issue
        articleToAdd.setIssue(issue);
        issue.addArticle(articleToAdd);
      }
    }

  }

  public void removeArticle(String journalTitle, String articleTitle) {
    int journalIndex = this.findJournalIndex(journalTitle);
    Issue issueFound = null;
    Article articleFound = null;
    if (journalIndex != -1 && journalIndex < _journals.size()) {
      Journal journal = _journals.get(journalIndex);
      ArrayList<Issue> journalIssues = journal.getIssues();
      for (Issue issue : journalIssues) {
        ArrayList<Article> issueArticles = issue.getArticles();
        for (Article article : issueArticles) {
          if (article.getTitle().equals(articleTitle)) { // article has been found
            issueFound = issue;
            articleFound = article;
          }
        }
      }
      if (issueFound != null && articleFound != null) {
        issueFound.removeArticle(articleFound);
      }
    }
  }

  // print out the contents of a list of journals
  public void printAll() {
    ArrayList<Journal> journalsToPrint = _journals;
    for (Journal journal : journalsToPrint) {
      journal.printJournal();
    }
    System.out.println("----------------------------------");
  }
}
