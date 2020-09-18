package clothes;

public class Clothes {
  private String _name;
  private String _color;
  private String _material;
  private boolean _isClean;

  public Clothes(String name, String color, String material, boolean isClean) {
    _name = name;
    _color = color;
    _material = material;
    _isClean = isClean;
  }

  ////
  // getters
  public String getName() {
    return _name;
  }

  public String getColor() {
    return _color;
  }

  public String getMaterial() {
    return _material;
  }

  public boolean getIsClean() {
    return _isClean;
  }

  // setters
  public void setName(String name) {
    _name = name;
  }

  public void setColor(String color) {
    _color = color;
  }

  public void setIsClean(boolean isClean) {
    _isClean = isClean;
  }

  ////
  // other methods

  public boolean clean() {
    if (!getIsClean()) {
      setIsClean(true);
      return true;
    }
    return false;
  }

  public boolean isPlain() {
    if (getColor().equalsIgnoreCase("black") || getColor().equalsIgnoreCase("grey")
        || getColor().equalsIgnoreCase("brown")) {
      return true;
    } else
      return false;
  };

  public String getPattern() {
    return "none";
  }

  // compatibility methods

  public boolean isDirty() {
    return !getIsClean();
  }

  public boolean goodWithEverything() {
    return false;
  }

  public boolean isPatterned() {
    return false;
  };

}
