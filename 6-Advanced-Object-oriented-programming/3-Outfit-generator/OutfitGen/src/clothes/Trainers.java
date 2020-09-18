package clothes;

public class Trainers extends Shoes {
  private String _sport;

  public Trainers(String name, String color, String material, boolean isClean, String fastening, boolean fastened,
      String sport) {
    super(name, color, material, isClean, fastening, fastened);
    _sport = sport;
  }

  // getters
  public String getSport() {
    return _sport;
  }

  // setters
  public void setSport(String sport) {
    _sport = sport;
  }
  // other methods
  // compatibility methods

  public boolean goodWithShorts() {
    return true;
  }
}
