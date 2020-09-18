package clothes;

public abstract class CollaredShirt extends Shirt {
  private int _pocketCount;

  public CollaredShirt(String name, String color, String material, boolean isClean, int chestSize, int pocketCount) {
    super(name, color, material, isClean, chestSize);
    _pocketCount = pocketCount;
  }

  // getters
  public int getPocketCount() {
    return _pocketCount;
  }
  // setters

  // other methods
  // compatibility methods

}
