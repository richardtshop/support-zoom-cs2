package data;

import java.util.ArrayList;

public class TestingBIbliographyDatabase {
  public static void main(String[] args) {

    ArrayList<Journal> sampleJournals = Journal.getSampleJournals();
    BibliographyDatabase journalsDB = new BibliographyDatabase("Science journals", sampleJournals);

    journalsDB.printAll();
    Journal seismologyJournal = new Journal("Seismology international");
    journalsDB.addJournal(seismologyJournal);
    journalsDB.removeIssue("Nature", 2, 3);
    journalsDB.printAll();

    /*
     * TODO alter this so a new issue can only be made with a direct reference to a
     * journal title string (using the journal title instead of nothing)
     */

    Issue issueToAdd = new Issue(2000, 3, 7);
    journalsDB.addIssue("The Astronomical Journal", issueToAdd);

    // add issue to journal by journal object
    Issue directAddIssue = new Issue(1989, 99, 4, seismologyJournal);
    seismologyJournal.addIssue(directAddIssue);
    journalsDB.printAll();

    // add article by journal title
    Article newArticleToAdd = new Article("New article on Discovery", "Mark Smith");
    journalsDB.addArticle("Seismology international", 99, 4, newArticleToAdd);

    journalsDB.printAll();
    journalsDB.removeArticle("Seismology international", "New article on Discovery");
    journalsDB.printAll();

    // remove issue
    journalsDB.removeIssue("Seismology international", 99, 4);

    // remove journal
    journalsDB.removeJournalByTitle("Seismology international");
  }
}
