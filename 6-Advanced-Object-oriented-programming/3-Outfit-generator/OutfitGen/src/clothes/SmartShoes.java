package clothes;

public class SmartShoes extends Shoes {
  private String _style;
  private int _heelHeight;

  public SmartShoes(String name, String color, String material, boolean isClean, String fastening, boolean fastened,
      String style, int heelHeight) {
    super(name, color, material, isClean, fastening, fastened);
    _style = style;
    _heelHeight = heelHeight;
  }

  // getters
  public String getStyle() {
    return _style;
  }

  public int getHeelHeigh() {
    return _heelHeight;
  }

  // no setters
  // other methods
  // compatibility methods
}
