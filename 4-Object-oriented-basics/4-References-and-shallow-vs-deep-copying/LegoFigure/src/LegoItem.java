/* Define a class called LegoItem. It should have a name (stored as a String) and a weight in grams (stored as a float). Provide a constructor (which allows each attribute to be set), as well as the following methods:

public String toString(), which converts the item to an appropriate String. For example, if the name of the item is "sword" with weight 10 grams, then the method could return "a 10-gram sword". 

public boolean isHeavy(float threshold), which returns true if the weight of the item exceeds the given threshold. */

public class LegoItem {
  public String name;
  public float weight; // in grams

  public static String unit = "gram";

  public LegoItem(String itemName, float itemWeight) {
    name = itemName;
    weight = itemWeight;
  }

  public String toString() {
    String hatString = "a " + weight + '-' + unit + ' ' + name;
    return hatString;
  }

  public boolean isHeavy(float threshold) {
    if (weight > threshold) {
      return true;
    }
    return false;
  }
}