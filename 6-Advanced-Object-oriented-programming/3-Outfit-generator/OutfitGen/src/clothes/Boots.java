package clothes;

public class Boots extends Shoes {
  private int _height;

  public Boots(String name, String color, String material, boolean isClean, String fastening, boolean fastened,
      int height) {
    super(name, color, material, isClean, fastening, fastened);
    _height = height;
  }

  // getters
  public int getHeight() {
    return _height;
  }
  // setters

  // other methods
  public void stomp() {
    System.out.println("STOMP! STOMP! STOMP!");
  }

  // compatibility methods
  public boolean goodWithShorts() {
    return false;
  }

}
