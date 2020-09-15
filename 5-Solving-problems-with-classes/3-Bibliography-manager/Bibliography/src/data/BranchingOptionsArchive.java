// Question
// For the looping methods that loop through all journals, and then issues etc, would they be best to live here
// or in Journal/Issue

// I see two sides. Adding them here means these methods are specific to this data for the UI
// However adding it to the journal makes a general method that could be accessed elswhere

// My thoughts are it depends on how/if the method should be restricted

package data;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class BranchingOptionsArchive {

  // The branching story only needs to know the first Stage
  // since those Stages will reference whatever Stages come
  // next
  private Stage firstStage;

  // The branching story also keeps track of where we are
  // in the story
  private Stage currentStage;

  // Tracks whether a story is in progress or not
  private boolean inProgress;

  public BranchingOptionsArchive(Stage newFirstStage) {
    firstStage = newFirstStage;
  }

  // This is the only information outsiders need to access directly.
  // Everything else users need to do can be done through more
  // specific methods.
  public Stage getCurrentStage() {
    return currentStage;
  }

  // Start a new story, resetting the current Stage
  public void start() {
    currentStage = firstStage;
    inProgress = true;
  }

  // Stop a story
  public void stop() {
    inProgress = false;
  }

  // Is the story finished?
  public boolean isFinished() {
    return !inProgress;
  }

  // Checks if user input choice is valid
  public void makeChoice(int choiceIndex) {
    // once a user has input a choice, chec k if
    Stage s = currentStage.getNthNextStage(choiceIndex);
    if (s != null) {
      currentStage = s;
    }
  }

  // Checks if user input choice is valid
  public boolean validChoice(int choiceIndex) {
    // once a user has input a choice, chec k if
    Stage s = currentStage.getNthNextStage(choiceIndex);
    if (s != null) {
      currentStage = s;
      return true;
    } else {
      return false;
    }
  }

  public void runChoiceMethod(String currStageID, int methodIndex, ArrayList<Journal> journalList, Scanner userInput) {
    // System.out.println(getCurrentStage().getNthNextStage(methodIndex).getText());
    switch (currStageID) {
      case "Main":
        switch (methodIndex) {
          case 0:
            // printArticlesByYear(journalList, userInput);
            break;
          case 1:
            // addArticleToIssue(journalList, methodIndex);
            // get all issues
            // print them out
            break;
          case 2:
            // Loop through all articles and create ArrayList that contains author names
            // printMostCommonAuthor(journalList);
            break;
          case 3:
            // exit
            getCurrentStage().setTerminal(true);
            break;
          default:
            break;
        }
      default:
        break;
    }

  }

  // Print articles based from a user inputted year
  public static void printArticlesByYear(ArrayList<Journal> journalList, Integer userInput) {
    int year = userInput;
    boolean issueFound = false;
    for (Journal journal : journalList) {
      for (Issue issue : journal.getIssues()) {
        if (issue.getYear() == year) {
          issueFound = true;
          for (Article article : issue.getArticles()) {
            System.out.println(article.getAuthor() + ". " + article.getTitle() + ". " + journal.getTitle() + ", "
                + issue.getVolume() + "(" + issue.getIssueNumber() + "), " + issue.getYear());
          }
        }
      }
    }
    if (!issueFound) {
      System.out.println("No articles found for " + year + ".\nPlease try another year.");
    }
  }

  // Prints all available issues and returns issues
  public static ArrayList<Issue> getAvailableIssues(ArrayList<Journal> journals, int methodIndex) {
    ArrayList<Issue> issues = new ArrayList<Issue>();
    // populate arrayList with issues
    for (Journal journal : journals) {
      for (Issue issue : journal.getIssues()) {
        issues.add(issue);
      }
    }

    for (int i = 0; i < issues.size(); i++) {
      Issue issue = issues.get(i);
      System.out.println((i + 1) + ". " + issue.getJournal().getTitle() + ", Volume" + issue.getVolume() + ", Issue "
          + issue.getIssueNumber());
    }
    return issues;
  }

  ////
  // add articles to an issue
  // TODO a lot of this needs to be moved to the UI
  public static void addArticleToIssue(ArrayList<Journal> journals, int methodIndex) {
    ArrayList<Issue> allIssues = getAvailableIssues(journals, methodIndex);
    System.out.println("What issue would you like to add to?");
    ////
    Scanner input = new Scanner(System.in);
    ////
    int issueIndex = input.nextInt() - 1;
    if (issueIndex >= 0 && issueIndex < allIssues.size()) {
      // get article title
      System.out.println("Please specify the article title:");
      input = new Scanner(System.in);
      String title = input.next();
      // get article author
      System.out.println("Please specify the article author:");
      input = new Scanner(System.in);
      String author = input.next();
      Issue chosenIssue = allIssues.get(issueIndex);
      Article articleToAdd = new Article(title, author, chosenIssue);
      chosenIssue.addArticle(articleToAdd);
    } else {
      System.out.println("Sorry, that is not a valid choice.");
    }
  }

  ////
  // Method to print the most common author
  public static void printMostCommonAuthor(ArrayList<Journal> journals, Integer userInput) {
    ArrayList<String> authors = new ArrayList<String>();
    // Loop through each journal and create ArrayList ofg all authors
    for (Journal journal : journals) {
      for (Issue issue : journal.getIssues()) {
        for (Article article : issue.getArticles()) {
          authors.add(article.getAuthor());
        }
      }
    }
    // Get the most commmon element in the ArrayList
    int frequency = 1;
    int tempFrequency;
    String mostFrequentAuthor = authors.get(0);
    String tempString = "";
    for (int i = 0; i < authors.size(); i++) {
      tempString = authors.get(i);
      tempFrequency = 1;
      for (int j = 1; j < authors.size(); j++) {
        if (tempString.equals(authors.get(j)))
          tempFrequency++;
      }
      if (tempFrequency > frequency) {
        mostFrequentAuthor = tempString;
        frequency = tempFrequency;
      }
    }

    if (mostFrequentAuthor != null) {
      System.out.println(mostFrequentAuthor);
    }
  }

  // A static helper method that returns an example story that we can use
  // for testing
  public static BranchingOptionsArchive getArchiveOptions() {

    BiConsumer<ArrayList<Journal>, Integer> stage2Method = (ArrayList<Journal> journalList, Integer userInput) -> {
      printArticlesByYear(journalList, userInput);
    };

    BiConsumer<ArrayList<Journal>, Integer> stage3Method = (ArrayList<Journal> journalList, Integer userInput) -> {
      addArticleToIssue(journalList, userInput);
    };

    BiConsumer<ArrayList<Journal>, Integer> stage4Method = (ArrayList<Journal> journalList, Integer userInput) -> {
      printMostCommonAuthor(journalList, userInput);
    };

    Stage Stage1 = new Stage("Main", "You may perform the following operations:",
        "Please enter your choice (1,2,3,4):");

    // Stages to indicate choices that run methods - no subsequent stages
    Stage Stage2 = new Stage("ChooseYear", "What year are you interested in?", stage2Method);
    Stage Stage3 = new Stage("ChooseIssue", "Here are the available issues", "What issue would you like to add to?",
        stage3Method);
    Stage Stage4 = new Stage("FindAuthor", "The most published author is:", stage4Method);
    Stage Stage5 = new Stage("Exit", "Bye!\n");

    ///////////////////////////////////////////////////////////////

    // Main menu options
    Stage1.addChoice("Find articles from a given year.", Stage2);
    Stage1.addChoice("Add an article to an issue", Stage3);
    Stage1.addChoice("Find the most-published author", Stage4);
    Stage1.addChoice("Exit", Stage5);

    ///////////////////////////////////////////////////////////////

    BranchingOptionsArchive archive = new BranchingOptionsArchive(Stage1);

    return archive;

  }

}

////
// Notes

////
// Tried to dynamically add choices to a dynamic stage, but couldn't get it to
//// work