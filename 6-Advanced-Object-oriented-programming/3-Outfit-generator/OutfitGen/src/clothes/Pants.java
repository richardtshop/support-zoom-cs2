package clothes;

public class Pants extends Clothes implements ShoeInterface {
  private boolean _casual;
  private int _waist;

  public Pants(String name, String color, String material, boolean isClean, boolean casual, int waist) {
    super(name, color, material, isClean);
    _casual = casual;
    _waist = waist;
  }

  // getters
  public boolean getCasual() {
    return _casual;
  }

  public int getWaist() {
    return _waist;
  }

  // setters
  protected void setCasual(boolean casual) {
    _casual = casual;
  }

  public void setWaist(int waist) {
    _waist = waist;
  }

  // compatibility methods
  public boolean goodWithSmartShoes() {
    if (_casual) {
      return false;
    }
    return true;
  }
}
