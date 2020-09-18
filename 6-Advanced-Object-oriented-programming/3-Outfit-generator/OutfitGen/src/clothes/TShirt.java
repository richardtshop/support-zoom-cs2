package clothes;

public class TShirt extends Shirt {
  private boolean _graphic;
  private String _shirtText;

  public TShirt(String name, String color, String material, boolean isClean, int chestSize, boolean graphic,
      String shirtText) {
    super(name, color, material, isClean, chestSize);
    _graphic = graphic;
    _shirtText = shirtText;
  }

  // getters
  public boolean getGraphic() {
    return _graphic;
  }

  // setters
  public String getShirtText() {
    return _shirtText;
  }

  // other methods
  private void setShirtText(String shirtText) {
    _shirtText = shirtText;
  }

  public void updateText(String newText) {
    setShirtText(getShirtText() + newText);
  }

  // compatibility methods
  public boolean goodWithSmartShoes() {
    return false;
  }

}
