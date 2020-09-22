package clothes;

public class WinterCoat extends Outerwear {
  private int _temperatureRating;

  public WinterCoat(String name, String color, String material, boolean isClean, String closingType, boolean hooded,
      int temperatureRating) {
    super(name, color, material, isClean, closingType, hooded);
    _temperatureRating = temperatureRating;
  }

  // getters
  public int getTemperatureRating() {
    return _temperatureRating;
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

  public boolean goodWithShorts() {
    return false;
  }

}
