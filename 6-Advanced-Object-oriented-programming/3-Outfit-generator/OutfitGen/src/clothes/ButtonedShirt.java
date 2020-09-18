package clothes;

public class ButtonedShirt extends CollaredShirt {
  private boolean _buttonedCollar;
  private int _buttonCount;
  private boolean _buttoned;

  public ButtonedShirt(String name, String color, String material, boolean isClean, int chestSize, int pocketCount,
      boolean buttonedCollar, int buttonCount, boolean buttoned) {
    super(name, color, material, isClean, chestSize, pocketCount);
    _buttonedCollar = buttonedCollar;
    _buttonCount = buttonCount;
    _buttoned = buttoned;
  }

  // getters
  public boolean getButtonedCollar() {
    return _buttonedCollar;
  }

  public int getButtonCount() {
    return _buttonCount;
  }

  public boolean getButtoned() {
    return _buttoned;
  }

  // setters
  private void setButtonCount(int buttonCount) {
    _buttonCount = buttonCount;
  }

  private void setButtoned(boolean buttoned) {
    _buttoned = buttoned;
  }
  // other methods

  public void toggleButtoned() {
    setButtoned(!getButtoned());
  }

  public void popButton() {
    setButtonCount(getButtonCount() - 1);
    System.out.println("You lost a button, you now have " + getButtonCount() + " buttons.");
  }

  public boolean goesWithTie() {
    return true;
  }
  // compatibility methods
}
