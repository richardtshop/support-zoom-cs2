public class TestingFlower {
  public static void main(String[] args) {
    Flower f = new Flower("purple", 10, 0.5f);
    f.print();
    f.water();

    f.print();
    f.grow();

    f.print();
  }
}
