public class Flower {
  // Define attributes first
  String color;
  int height;
  float percentWater;

  // Now define the constructors
  public Flower(String color, int height, float percentWater) {
    this.color = color;
    this.height = height;
    this.percentWater = percentWater;
  }

  public void print() {
    System.out.println(" (" + height + " cm, " + percentWater + "% water)");
  }

  void grow() {
    height += 2;
    percentWater -= 0.05;
  }

  void water() {
    this.percentWater += 0.1;
  }
}
