package data;

import java.util.ArrayList;

import java.util.function.BiConsumer;
import java.util.Scanner;

public class Stage {
  private String _id;
  private String _text;
  private String _inputText;
  private boolean _terminal;
  private ArrayList<Choice> _choices;
  private BiConsumer<ArrayList<Journal>, Integer> _methodToRun;

  public Stage(String id) {
    this(id, "");
  }

  public Stage(String id, String text) {
    this(id, text, null, false);
  }

  public Stage(String id, String text, BiConsumer<ArrayList<Journal>, Integer> methodToRun) {
    this(id, text, null, false, methodToRun);
  }

  public Stage(String id, String text, String inputText) {
    this(id, text, inputText, false);
  }

  public Stage(String id, String text, String inputText, BiConsumer<ArrayList<Journal>, Integer> methodToRun) {
    this(id, text, inputText, false, methodToRun);
  }

  public Stage(String id, String text, String inputText, boolean terminal) {
    this(id, text, inputText, false, null);
  }

  public Stage(String id, String text, String inputText, boolean terminal,
      BiConsumer<ArrayList<Journal>, Integer> methodToRun) {
    _id = id;
    _text = text;
    _inputText = inputText;
    _choices = new ArrayList<Choice>();
    _terminal = terminal;
    _methodToRun = methodToRun;
  }

  // We only want to be able to directly get the ID and text of a stage,
  // and update only the text. The choices ArrayList should be completely
  // hidden from users of this class, because they should not care how
  // we keep implement choice tracking.
  public String getID() {
    return _id;
  }

  public String getText() {
    return _text;
  }

  public String getInputText() {
    return _inputText;
  }

  public boolean getTerminal() {
    return _terminal;
  }

  public BiConsumer<ArrayList<Journal>, Integer> getMethodToRun() {
    return _methodToRun;
  }

  public void setText(String text) {
    _text = text;
  }

  public void setInputText(String inputText) {
    _inputText = inputText;
  }

  public void setTerminal(boolean terminal) {
    _terminal = terminal;
  }

  // This method allows users of the class to access information
  // about a given choice (the text to give the user, in this case)
  public String getNthChoiceText(int choiceIndex) {
    String _text = "";

    if (choiceIndex < _choices.size()) {
      _text = _choices.get(choiceIndex).getText();
    }

    return _text;
  }

  // This method allows users of the class to access information
  // about a given choice (the reference to the next stage, in
  // this case)
  public Stage getNthNextStage(int choiceIndex) {
    Stage stage = null;

    if (choiceIndex < _choices.size()) {
      stage = _choices.get(choiceIndex).getNextStage();
    }

    return stage;
  }

  // The number of choices is the length of the choice list
  public int getNumChoices() {
    return _choices.size();
  }

  // Add a new choice to the stage without having to know
  // how they are being represented
  public void addChoice(String text, Stage nextStage) {
    _choices.add(new Choice(text, nextStage));
  }

  public String toString() {
    return _id + ": " + _text;
  }

  // Allows a stage to be compared logically to any
  // other object
  public boolean equals(Object o) {
    boolean result = false;
    if (o instanceof Stage) {
      Stage s = (Stage) o;
      result = _id.equals(s._id);
    }
    return result;
  }
}
