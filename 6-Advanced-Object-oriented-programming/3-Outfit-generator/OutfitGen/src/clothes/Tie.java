package clothes;

public class Tie extends Accessories {
  private boolean _clipOn;
  private boolean _doneUp;
  private String _pattern;

  public Tie(String name, String color, String material, boolean isClean, String bodyLocation, boolean clipOn,
      boolean doneUp, String pattern) {
    super(name, color, material, isClean, bodyLocation);
    _clipOn = clipOn;
    _doneUp = doneUp;
    _pattern = pattern;
  }

  // getters
  public boolean getClipOn() {
    return _clipOn;
  }

  public boolean getDoneUp() {
    return _doneUp;
  }

  public String getPattern() {
    return _pattern;
  }

  // setters
  public void setDoneUp(boolean doneUp) {
    _doneUp = doneUp;
  }

  // other methods
  public void undoTie() {
    setDoneUp(false);
  }

  public void doUpTie() {
    setDoneUp(true);
  }
  // compatibility methods

  public boolean isPlain() {
    if ((getColor().equalsIgnoreCase("black") || getColor().equalsIgnoreCase("grey")
        || getColor().equalsIgnoreCase("brown")) && getPattern().equalsIgnoreCase("none")) {
      return true;
    } else
      return false;
  }

  public boolean isPatterned() {
    if (getPattern().equalsIgnoreCase("none")) {
      return false;
    }
    return true;
  };

}
