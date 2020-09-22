# Recursion in Pseudo-code

1. Suppose you are given a number n, and you want to determine the sum of all integers from 1 to n (inclusive) using recursion. Explain in English what the base case would be, and how you would reduce the problem size for the recursive call. Write pseudo-code that illustrates what the recursive function would look like, including what the inputs and output would be.
   The base case would be n = 1;
   To reduce the problem size, the recursive function would take n as the last integer, and then call the recursive function, passing n -1, returning the last integer plus the value returned in the recursive call.

   ```
    IntegerRecursive(integer input) {
      // base case
    if (input == 1)  return input

    // input is the largest integer
    largest integer = input;
    // call recursive function
    int allButLastSum = IntegerRecursive(input - 1);

    return lastInteger + allButLastSum;
   }
   ``

   ```

2. The ancient hero Achilles has an amazing power: he can cut the distance to his goal in half with only a single step. Also, he can take a normal step, which (for Achilles) covers 1 meter. Write pseudocode for a recursive function that counts how many steps Achilles will take to reach his goal, given an input distance in meters.

```
 achillesSteps(distance) {
   // base case if achilles is only 1 meter away
    if (distance == 1) {
      return 1;
    }
    // last step is 1
    firstStep = 1;
    // initialise the total
    allButFirstStep;

    // below ensures the total distance is always an integer, either halving an even number, or decrementing one to make it even in the recursion call

    if distance is even {
      allButFirstStep = achillesSteps(distance / 2);
    } else {
      allButFirstStep = achillesSteps(distance - 1);
    }

    return lastStep + allButFirstStep; // which is the total of all steps
  }
```

Achilles code in java with test and outputs:

```java

import java.util.ArrayList;

public class Recursion {
  public static int achillesSteps(int distance) {
    if (distance == 1) {
      return 1;
    }
    int firstStep = 1;
    int allButFirstStep;
    if (distance % 2 == 0) {
      allButFirstStep = achillesSteps(distance / 2);
    } else {
      allButFirstStep = achillesSteps(distance - 1);
    }
    return firstStep + allButFirstStep;
  }

  public static void main(String[] args) {
    // achilles
    System.out.println(achillesSteps(1)); // 1
    System.out.println(achillesSteps(2)); // 2
    System.out.println(achillesSteps(4)); // 3
    System.out.println(achillesSteps(5)); // 4
    System.out.println(achillesSteps(10)); // 5
    System.out.println(achillesSteps(7)); // 5
    System.out.println(achillesSteps(70)); // 9
  }
}

```
