// Class for a Journal. It should have an ArrayList of Issues as well as a title.

package data;

import java.util.ArrayList;

public class Journal {

  private String _title;
  private ArrayList<Issue> _issues;

  public Journal(String title) {
    setTitle(title);
    setIssues();
  }

  ////
  // getters
  public String getTitle() {
    return _title;
  }

  public ArrayList<Issue> getIssues() {
    return _issues;
  }

  ////
  // setters
  public void setTitle(String title) {
    _title = title;
  }

  public void setIssues() {
    _issues = new ArrayList<Issue>();
  }

  /////
  // other methods

  int findIssueIndex(int volume, int issueNumber) {
    Issue issueFound = null;
    for (Issue issue : _issues) {
      if (issue.getVolume() == volume && issue.getIssueNumber() == issueNumber) {
        issueFound = issue;
      }
    }

    if (issueFound != null) {
      return _issues.indexOf(issueFound);
    }
    return -1;
  }

  public void addIssue(Issue issueToAdd) {
    _issues.add(issueToAdd);
  }

  public void removeIssue(int volume, int issueNumber) {
    int issueIndex = this.findIssueIndex(volume, issueNumber);
    if (issueIndex != -1) {
      _issues.remove(issueIndex);
    }
  }

  public void printJournal() {
    System.out.println("----------------------------------");
    System.out.println(_title);
    for (Issue issue : _issues) {
      System.out.println("---------");
      System.out.println("Volume " + issue.getVolume());
      System.out.println("---------");
      for (Article article : issue.getArticles()) {
        System.out.println("Issue " + article.getIssue().getIssueNumber() + ": " + article.getTitle());
      }
    }
  }

  // create sample journals for testing
  public static ArrayList<Journal> getSampleJournals() {

    // create journals
    Journal natureJournal = new Journal("Nature");
    Journal astronomyJournal = new Journal("The Astronomical Journal");

    // create issues
    Issue natureIssue1 = new Issue(1999, 2, 3, natureJournal);
    Issue natureIssue2 = new Issue(2000, 2, 4, natureJournal);
    Issue astronomyIssue1 = new Issue(2000, 3, 6, astronomyJournal);
    Issue astronomyIssue2 = new Issue(2000, 3, 6, astronomyJournal);

    // create articles
    Article natureArticle1 = new Article("Floating under a levitating liquid", "Benjamin Apffel", natureIssue1);
    Article natureArticle2 = new Article("Butterfly effect and a self-modulating El Niño response to global warming",
        "Wenju Cai", natureIssue1);
    Article natureArticle3 = new Article("Biosynthesis of medicinal tropane alkaloids in yeast", "Prashanth Srinivasan",
        natureIssue2);
    Article natureArticle4 = new Article(
        "Human germinal centres engage memory and naive B cells after influenza vaccination", "Jackson Turner",
        natureIssue2);
    Article natureArticle5 = new Article(
        "Human germinal centres engage memory and naive B cells after influenza vaccination 2", "Jackson Turner",
        natureIssue2);

    Article astronomyArticle1 = new Article("Discovery of a Nearby Young Brown Dwarf Disk", "Maria Schutte",
        astronomyIssue1);
    Article astronomyArticle2 = new Article("The Nebula N103B in the LMC Contains Parts of Two Supernova Remnants",
        "John Dickel", astronomyIssue1);
    Article astronomyArticle3 = new Article("EVIDENCE FOR A DISTANT GIANT PLANET IN THE SOLAR SYSTEM",
        "Konstantin Batygin", astronomyIssue2);
    Article astronomyArticle4 = new Article("Overview of the DESI Legacy Imaging Surveys", "Arjun Dey",
        astronomyIssue2);
    Article astronomyArticle5 = new Article("Overview of the DESI Legacy Imaging Surveys 2", "Arjun Dey",
        astronomyIssue2);
    Article astronomyArticle6 = new Article("Overview of the DESI Legacy Imaging Surveys 3", "Arjun Dey",
        astronomyIssue2);

    // add articlers to issues
    natureIssue1.getArticles().add(natureArticle1);
    natureIssue1.getArticles().add(natureArticle2);
    natureIssue2.getArticles().add(natureArticle3);
    natureIssue2.getArticles().add(natureArticle4);
    natureIssue2.getArticles().add(natureArticle5);

    astronomyIssue1.getArticles().add(astronomyArticle1);
    astronomyIssue1.getArticles().add(astronomyArticle2);
    astronomyIssue2.getArticles().add(astronomyArticle3);
    astronomyIssue2.getArticles().add(astronomyArticle4);
    astronomyIssue2.getArticles().add(astronomyArticle5);
    astronomyIssue2.getArticles().add(astronomyArticle6);

    // add issues to journals
    natureJournal.getIssues().add(natureIssue1);
    natureJournal.getIssues().add(natureIssue2);
    astronomyJournal.getIssues().add(astronomyIssue1);
    astronomyJournal.getIssues().add(astronomyIssue2);

    // Add created journals to output
    ArrayList<Journal> sampleJournals = new ArrayList<Journal>();
    sampleJournals.add(natureJournal);
    sampleJournals.add(astronomyJournal);
    return sampleJournals;
  }
}
