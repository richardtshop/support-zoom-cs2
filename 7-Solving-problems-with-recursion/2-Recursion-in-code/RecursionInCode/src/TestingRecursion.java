public class TestingRecursion {
  public static int doubleFactorial(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * doubleFactorial(n - 2);
  }

  public static int Fib(int n) {
    if (n == 1 || n == 0) {
      return n;
    }
    return Fib(n - 1) + Fib(n - 2);
  }

  public static void main(String[] args) {

    // Testing factorial2
    System.out.println(doubleFactorial(0)); // 0
    System.out.println(doubleFactorial(1)); // 1
    System.out.println(doubleFactorial(2)); // 2
    System.out.println(doubleFactorial(3)); // 3
    System.out.println(doubleFactorial(4)); // 8
    System.out.println(doubleFactorial(5)); // 15
    System.out.println(doubleFactorial(7)); // 105
    System.out.println(doubleFactorial(8)); // 384

    // Test Fib
    System.out.println(Fib(0)); // 0
    System.out.println(Fib(1)); // 1
    System.out.println(Fib(4)); // 3
    System.out.println(Fib(5)); // 5
    System.out.println(Fib(6)); // 8
    System.out.println(Fib(10)); // 55

  }

}
