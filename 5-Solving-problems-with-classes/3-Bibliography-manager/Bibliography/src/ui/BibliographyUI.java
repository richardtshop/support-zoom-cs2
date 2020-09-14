package ui;

import data.BibliographyDatabase;
import data.BranchingOptionsArchive;
import data.Journal;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliographyUI {
  private ArrayList<Journal> _journalList;
  private BranchingOptionsArchive _archive;

  public BibliographyUI(BranchingOptionsArchive archive, ArrayList<Journal> journalList) {
    _archive = archive;
    _journalList = journalList;

  }

  void run() {
    _archive.start();
    System.out.println("Welcome to the Bibliography Database!\n");
    while (!_archive.isFinished()) {
      // Print out the stage text
      if (_archive.getCurrentStage().getTerminal()) {
        System.out.println("Exiting");
        _archive.stop();
      } else {
        System.out.println(_archive.getCurrentStage().getText() + "\n");
        // Choices: display the options
        for (int i = 0; i < _archive.getCurrentStage().getNumChoices(); i++) {
          System.out.println((i + 1) + ". " + _archive.getCurrentStage().getNthChoiceText(i));
        }
        if (_archive.getCurrentStage().getInputText() != null) {
          System.out.println(_archive.getCurrentStage().getInputText());
        }
        // Get the user's choice
        Scanner input = new Scanner(System.in);
        int choiceIndex = input.nextInt() - 1; // subtract for zero indexing

        // run methods to return data for each choice
        if (_archive.validChoice(choiceIndex)) {
          input = new Scanner(System.in);
          String currStageID = _archive.getCurrentStage().getID();
          _archive.runChoiceMethod(currStageID, choiceIndex, _journalList, input);
        } else {
          System.out.println("Sorry, that is not a valid choice.");
        }
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Journal> journalList = Journal.getSampleJournals();

    BibliographyUI ui = new BibliographyUI(BranchingOptionsArchive.getArchiveOptions(), journalList);
    ui.run();
  }
}
