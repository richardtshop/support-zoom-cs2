package clothes;

public class Accessories extends Clothes {
  private String _bodyLocation;

  public Accessories(String name, String color, String material, boolean isClean, String bodyLocation) {
    super(name, color, material, isClean);
    _bodyLocation = bodyLocation;
  }

  // getters
  public String getBodyLocation() {
    return _bodyLocation;
  }
}
