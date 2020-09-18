package clothes;

public class Hat extends Accessories {
  private int _circumference;
  private String _type;

  public Hat(String name, String color, String material, boolean isClean, String bodyLocation, String type,
      int circumference) {
    super(name, color, material, isClean, bodyLocation);
    _circumference = circumference;
    _type = type;
  }

  // getters
  public int getCircumference() {
    return _circumference;
  }

  public String getType() {
    return _type;
  }

  // setters
  // other methods
  public void doff() {
    System.out.println("Tilts hat");
  }

}
