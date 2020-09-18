package clothes;

public class Outerwear extends Clothes implements Winter {
  private String _closingType;
  private boolean _hooded;

  public Outerwear(String name, String color, String material, boolean isClean, String closingType, boolean hooded) {
    super(name, color, material, isClean);
    _closingType = closingType;
    _hooded = hooded;
  }

  // getters
  public String getClosingType() {
    return _closingType;
  }

  public boolean getHooded() {
    return _hooded;
  }

  // compatibility methods
  public boolean isWinterClothing() {
    return false;
  }

  public boolean goodWithShorts() {
    return true;
  }

  public boolean goodWithHat() {
    return false;
  }
}
