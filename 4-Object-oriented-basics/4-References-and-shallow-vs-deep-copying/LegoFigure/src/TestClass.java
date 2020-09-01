public class TestClass {

  public static void main(String[] args) throws Exception {

    // testing LegoHat class
    LegoHat sunVisor = new LegoHat("sun-visor", 10);
    LegoHat toque = new LegoHat("toque", 10);
    LegoHat cowboy = new LegoHat("cowboy", 10);

    System.out.println(sunVisor.toString()); // a size 10 sun-visor hat
    System.out.println(toque.computeStyle("summer")); // false
    System.out.println(toque.computeStyle("winter")); // true
    System.out.println(sunVisor.computeStyle("winter")); // false
    System.out.println(sunVisor.computeStyle("summer")); // true
    System.out.println(cowboy.computeStyle("summer")); // true or false

    // testing LegoItem class
    LegoItem hammer = new LegoItem("hammer", 4000);

    System.out.println(hammer.toString()); // a 4000.0-gram hammer
    System.out.println(hammer.isHeavy(3500)); // true
    System.out.println(hammer.isHeavy(4500)); // false

    // testing LegoFigure class

    // figure with all attributes
    // LegoMinifigure dave = new LegoMinifigure("dave", new LegoHat("bowler", 10),
    // new LegoItem("sword", 4000),
    // new LegoItem("hammer", 5000));
    LegoMinifigure dave = new LegoMinifigure("dave", new LegoHat("bowler", 10), new LegoItem("sword", 4000), null);
    // figure with only the required name
    LegoMinifigure hugh = new LegoMinifigure("hugh", null, null, null);

    System.out.println(dave);
    // A lego minifigure named dave who is wearing a size 10 bowler hat and holding
    // a 4000.0-gram sword in their left hand, and a 5000.0-gram hammer in their
    // right hand.
    System.out.println(hugh); // A lego minifigure named hugh.
    dave.swapHands();
    dave.wearHat(new LegoHat("top", 12));
    System.out.println(dave);
    // A lego minifigure named dave who is wearing a size 12 top hat and holding a
    // 5000.0-gram hammer in their left hand, and a 4000.0-gram sword in their right
    // hand.
    dave.placeInLeftHand(new LegoItem("cloth", 100));
    dave.placeInRightHand(new LegoItem("chicken", 2000));
    // A lego minifigure named dave who is wearing a size 12 top hat and holding a
    // 100.0-gram cloth in their left hand, and a 2000.0-gram chicken in their right
    // hand.
    System.out.println(dave);
    dave.swapHands();
    System.out.println(dave.isGood("winter", 2000)); // true or false
    dave.wearHat(new LegoHat("toque", 10));
    System.out.println(dave.isGood("winter", 2000)); // true
  }
}