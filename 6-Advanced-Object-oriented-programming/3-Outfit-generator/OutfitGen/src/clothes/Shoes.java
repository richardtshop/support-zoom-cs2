package clothes;

public class Shoes extends Clothes implements Winter {
  private String _fastening;
  private boolean _fastened;

  public Shoes(String name, String color, String material, boolean isClean, String fastening, boolean fastened) {
    super(name, color, material, isClean);
    _fastening = fastening;
    _fastened = fastened;
  }

  // getters

  public String getFastening() {
    return _fastening;
  }

  public boolean getFastened() {
    return _fastened;
  }

  // setters
  public void setFastened(boolean fastened) {
    _fastened = fastened;
  }

  // other methods

  public void fasten() {
    setFastened(true);
  }

  // compatibility methods

  public boolean isWinterClothing() {
    return false;
  }

  public boolean goodWithShorts() {
    return false;
  }

}
