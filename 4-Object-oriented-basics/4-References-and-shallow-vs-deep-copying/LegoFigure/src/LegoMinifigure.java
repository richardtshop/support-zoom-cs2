
/* Define a class called LegoMinifigure. It should have a name (stored as a String), and references to the LegoHat it is wearing (if any) and each of the LegoItems it is holding in its left and right hands (if any). Provide a constructor (which allows each attribute to be set), as well as the following methods:

public String toString(), which converts the Lego minifigure to an appropriate String. For example, if the name of the Lego minifigure is "Rodney" and it is wearing a medium toque and holding a 10-gram sword in the left hand and a 15-gram shield in the right hand, then the method could return:

"A Lego minifigure named Rodney, who is wearing a medium toque and is holding a 10-gram sword in the left hand and a 15-gram shield in the right hand"

Note: it is possible that the Lego minifigure is not wearing a hat and/or not holding one or two objects; you need to account for this. If, for example, the Lego minifigure is not wearing a hat and only carrying a 10-gram sword in the left hand, then the method could return:

"A Lego minifigure named Rodney, who is holding a 10-gram sword in the left hand"

Hint: you should re-use the other toString() methods.
 
public void swapHands(), which swaps what is in the Lego minifigure’s left and right hands.
 
public void wearHat(LegoHat hat), which places the given hat on the Lego minifigure’s head (replacing the current hat, if any).
 
public void placeInLeftHand(LegoItem item), which puts the given item in the Lego minifigure’s left hand (replacing the current item, if any).
 
public void placeInRightHand(LegoItem item), which puts the given item in the Lego minifigure’s right hand (replacing the current item, if any).

public boolean isGood(String season, float threshold), which returns true if the Lego minifigure is good. A Lego minifigure is good if it is wearing a hat and the hat has style at least 6, and if it is not holding something heavy (this could mean, for example, that it is holding nothing in its hands).
 */

public class LegoMinifigure {

  public String name;
  public LegoHat hat;
  public LegoItem leftHand;
  public LegoItem rightHand;

  public LegoMinifigure(String figureName) {
    name = figureName;
  }

  public LegoMinifigure(String figureName, LegoHat figureHat, LegoItem figureLeftHand, LegoItem figureRightHand) {
    name = figureName;
    hat = figureHat;
    leftHand = figureLeftHand;
    rightHand = figureRightHand;
  }

  public String toString() {
    // output strings for optional items/hat
    String hatString = hat != null ? " who is wearing " + hat.toString() : "";
    String leftItemString = leftHand != null ? ", and holding " + leftHand.toString() + " in their left hand" : "";
    String rightItemString = rightHand != null ? ", and holding " + rightHand.toString() + " in their right hand" : "";
    // concatenate strings
    String figureString = "A lego minifigure named " + name + hatString + leftItemString + rightItemString + '.';
    return figureString;
  }

  public void swapHands() {
    LegoItem temp = leftHand;
    leftHand = rightHand;
    rightHand = temp;
  }

  public void wearHat(LegoHat newHat) {
    hat = newHat;
  }

  public void placeInLeftHand(LegoItem newItem) {
    leftHand = newItem;
  }

  public void placeInRightHand(LegoItem newItem) {
    rightHand = newItem;
  }

  public boolean isGood(String season, float threshold) {
    // has to wear a hat
    // weight below treshold for both hands
    // style must be 6
    // if not carrying anything, heavy is false
    boolean leftHandHeavy = leftHand != null ? leftHand.isHeavy(threshold) : false;
    // if not carrying anything, heavy is false
    boolean rightHandHeavy = rightHand != null ? rightHand.isHeavy(threshold) : false;
    int style = hat != null ? hat.computeStyle(season) : 0; // if not wearing a hat, style is 0
    if (hat != null && !leftHandHeavy && !rightHandHeavy && style >= 6) {
      return true;
    }
    return false;
  }
}