package data;

import java.util.function.BiConsumer;
import java.util.ArrayList;
import java.util.Scanner;

public class Choice {
  private String _text;
  private Stage _nextStage;

  public Choice(String text, Stage nextStage) {
    _text = text;
    _nextStage = nextStage;
  }

  // Once a Choice object is created, it should not change;
  // therefore, we have only getters and no setters
  public String getText() {
    return _text;
  }

  public Stage getNextStage() {
    return _nextStage;
  }
}
