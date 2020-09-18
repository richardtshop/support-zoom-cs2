package clothes;

public class WinterBoots extends Boots {
  private int _temperatureRating;

  public WinterBoots(String name, String color, String material, boolean isClean, String fastening, boolean fastened,
      int height, int temperatureRating) {
    super(name, color, material, isClean, fastening, fastened, height);
    _temperatureRating = temperatureRating;
  }

  // getters
  public int getTemperatureRating() {
    return _temperatureRating;
  }

  // setters
  public void setTemperatureRating(int temperatureRating) {
    _temperatureRating = temperatureRating;
  }

  // other methods
  public boolean isTooCold(int temp) {
    if (temp < getTemperatureRating()) {
      return true;
    }
    return false;
  }

  // compatibility methods
  public boolean isWinterClothing() {
    return true;
  }
}
