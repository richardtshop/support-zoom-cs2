package clothes;

public class Shirt extends Clothes implements ShoeInterface {
  private int _chestSize;

  public Shirt(String name, String color, String material, boolean isClean, int chestSize) {
    super(name, color, material, isClean);
    _chestSize = chestSize;
  }

  // getters
  public int getChestSize() {
    return _chestSize;
  }

  // compatibility methods
  public boolean goodWithSmartShoes() {
    return true;
  }

  public boolean goesWithTie() {
    return false;
  }

}
