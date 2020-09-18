package clothes;

public class Cloak extends Outerwear {
  private String _pattern;

  public Cloak(String name, String color, String material, boolean isClean, String closingType, boolean hooded,
      String pattern) {
    super(name, color, material, isClean, closingType, hooded);
    _pattern = pattern;
  }

  // getters
  public String getPattern() {
    return _pattern;
  }

  // setters

  // other methods
  public void swoosh() {
    System.out.println("Swooooooooooooooooooooooooosh!");
  }

  // compatibility methods
  public boolean goodWithHat() {
    return true;
  }

  public boolean goodWithEverything() {
    return true;
  }

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
