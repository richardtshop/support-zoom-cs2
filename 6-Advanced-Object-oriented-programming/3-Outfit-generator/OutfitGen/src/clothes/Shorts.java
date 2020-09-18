package clothes;

public class Shorts extends Pants {
  private String _pattern;
  private String _length;

  public Shorts(String name, String color, String material, boolean isClean, boolean casual, int waist, String pattern,
      String length) {
    super(name, color, material, isClean, casual, waist);
    setCasual(true);
    _pattern = pattern;
    _length = length;
  }

  // getters
  public String getPattern() {
    return _pattern;
  }

  public String getLength() {
    return _length;
  }

  // other methods
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
