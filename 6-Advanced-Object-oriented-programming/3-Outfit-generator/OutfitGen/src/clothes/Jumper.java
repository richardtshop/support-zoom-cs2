package clothes;

public class Jumper extends Shirt {
  private boolean _buttoned;

  public Jumper(String name, String color, String material, boolean isClean, int chestSize, boolean buttoned) {
    super(name, color, material, isClean, chestSize);
    _buttoned = buttoned;
  }

  // getters
  public boolean getButtoned() {
    return _buttoned;
  }
}
