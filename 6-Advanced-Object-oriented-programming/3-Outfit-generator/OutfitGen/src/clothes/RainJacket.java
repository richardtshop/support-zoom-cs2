package clothes;

public class RainJacket extends Outerwear {
  private int _waterproofRating;

  public RainJacket(String name, String color, String material, boolean isClean, String closingType, boolean hooded,
      int waterproofRating) {
    super(name, color, material, isClean, closingType, hooded);
    _waterproofRating = waterproofRating;

  }

  // getters
  public int getWaterproofRating() {
    return _waterproofRating;
  }
}
