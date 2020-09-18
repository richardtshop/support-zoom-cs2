package clothes;

public class PoloShirt extends CollaredShirt {
  private String _logo;
  private boolean _collarUpturned;

  public PoloShirt(String name, String color, String material, boolean isClean, int chestSize, int pocketCount,
      String logo, boolean collarUpturned) {
    super(name, color, material, isClean, chestSize, pocketCount);
    _logo = logo;
    _collarUpturned = collarUpturned;
  }

  // getters
  public String getLogo() {
    return _logo;
  }

  public boolean getCollarUpturned() {
    return _collarUpturned;
  }

  // setters
  private void setCollarUpturned(boolean collarUpturned) {
    _collarUpturned = collarUpturned;
  }

  // other methods
  public void upturnCollar() {
    setCollarUpturned(true);
  }
  // compatibility methods
}
