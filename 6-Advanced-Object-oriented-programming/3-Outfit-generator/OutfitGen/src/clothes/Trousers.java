package clothes;

public class Trousers extends Pants {
  private boolean _belted;
  private int _length;
  private int _rolledUpLength;

  public Trousers(String name, String color, String material, boolean isClean, boolean casual, int waist,
      boolean belted, int length, int rolledUpLength) {
    super(name, color, material, isClean, casual, waist);
    setCasual(false);
    _belted = belted;
    _length = length;
    _rolledUpLength = rolledUpLength;
  }

  // getters
  public boolean getBelted() {
    return _belted;
  }

  public int getLength() {
    return _length;
  }

  public int getRolledUpLength() {
    return _rolledUpLength;
  }

  // setters
  private void setLength(int length) {
    _length = length;
  }

  public void setRolledUpLength(int rolledUpLength) {
    _rolledUpLength = rolledUpLength;
  }

  public boolean rollUp(int amount) {
    if (amount > (getLength() / 2)) {
      System.out.println("You can't roll up your trousers by more than half their length");
      return false;
    }
    setLength(getLength() - amount);
    return true;
  }

}
