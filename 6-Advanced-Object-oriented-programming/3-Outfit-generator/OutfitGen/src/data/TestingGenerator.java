package data;

import clothes.*;

public class TestingGenerator {
  public static void main(String[] args) {

    OutfitGen testingGenerator = new OutfitGen(Wardrobe.getSampleWardrobe());

    // Outfit 1 - double denim
    ButtonedShirt buttonedShirt = new ButtonedShirt("Buttoned", "Blue", "Denim", true, 40, 2, true, 10, true);
    Shorts denimShorts = new Shorts("80s", "Blue", "Denim", true, true, 32, "None", "Knee");
    Shoes shoes = new Shoes("Shoes", "Black", "Suede", true, "Laces", true);
    RainJacket rainJacket = new RainJacket("Mac", "Yellow", "Nylon", true, "", true, 0);
    Watch watch = new Watch("Apple watch", "Silver", "Steel", true, "Arm", "Smartwatch", 90);

    // Outfit 2 - tie with non-buttoned shirt
    Shirt shirt = new Shirt("Plain shirt", "Black", "Cotton", true, 42);
    Pants pants = new Pants("Plain pants", "Blue", "Cotton", true, true, 30);
    Trainers trainers = new Trainers("Trainers", "White", "Polyester", true, "Velcro", true, "Tennis");
    WinterCoat winterCoat = new WinterCoat("Fjall", "Blue", "G1000", true, "Zip", true, -30);
    Tie plainTie = new Tie("Wool tie", "Grey", "Wool", true, "Neck", true, true, "Plaid");

    // Outfit 3 - good cloak
    Jumper jumper = new Jumper("Winter jumper", "Green", "Wool", true, 44, true);
    Pants denimPants = new Pants("Deniom pants", "Black", "Denim", true, true, 30);
    WinterBoots winterBoots = new WinterBoots("Sorels", "Brown", "Polyester", true, "Laces", true, 20, -30);
    Cloak cloak = new Cloak("Cloaky", "Red", "Wool", true, "", false, "Swirly");
    Tie fancyTie = new Tie("Silk tie", "Magenta", "Silk", true, "Neck", false, true, "None");

    // Outfit 4 - good cloak
    TShirt tshirt = new TShirt("Casual T", "Yellow", "Cotton", true, 40, true, "My other tshirt is a poncho");
    Trousers trousers = new Trousers("Smart slacks", "Orange", "Cotton", true, false, 30, true, 28, 0);
    WorkBoots workBoots = new WorkBoots("Timberlands", "Beige", "Suede", true, "Laces", true, 20, true, "");
    RainJacket rainJacket2 = new RainJacket("Mac", "Yellow", "Nylon", true, "", true, 0);
    Hat bowler = new Hat("Dockers hat", "Black", "Felt", true, "Head", "Bowler", 22);

    // Outfit 5 - pants don't match your workshoes
    PoloShirt poloShirt = new PoloShirt("Polo", "White", "Cotton", true, 40, 1, "Horse", true);
    Shorts shorts = new Shorts("Bermudas", "White", "Flannel", false, true, 38, "Plaid", "Knee");
    SmartShoes smartShoes = new SmartShoes("Work shoes", "Brown", "Leather", true, "None", true, "Brogues", 1);
    WinterCoat winterCoat2 = new WinterCoat("Fjall", "Black", "G1000", true, "Zip", true, -30);
    Watch watch1 = new Watch("Apple watch", "Brown", "Steel", true, "Arm", "Smartwatch", 90);

    // Outfit 6 - shorts in winter
    PoloShirt topPoloShirt = new PoloShirt("Polo best", "Black", "Cotton", true, 40, 1, "Horse", true);
    Shorts shorts2 = new Shorts("Bermudas", "Yellow", "Flannel", true, true, 38, "Plaid", "Knee");
    WinterBoots winterBoots2 = new WinterBoots("Sorels", "Red", "Polyester", true, "Laces", true, 20, -30);
    RainJacket rainJacket3 = new RainJacket("Mac", "Yellow", "Nylon", true, "", true, 0);
    Watch watch2 = new Watch("Apple watch", "Pink", "Steel", true, "Arm", "Smartwatch", 90);

    // Outfit 6 - shorts in winter
    PoloShirt bestPolo = new PoloShirt("Used polo", "Black", "Cotton", true, 40, 1, "Horse", true);
    Trousers trousers2 = new Trousers("Smart slacks", "Orange", "Cotton", true, false, 30, true, 28, 0);
    WinterBoots winterBoots3 = new WinterBoots("Sorels", "Red", "Polyester", true, "Laces", true, 20, -30);
    RainJacket rainJacket4 = new RainJacket("Mac", "Yellow", "Nylon", true, "", true, 0);
    Watch watch3 = new Watch("Apple watch", "Pink", "Steel", true, "Arm", "Smartwatch", 90);

    // Testing
    System.out.println("\nOutfit 1");
    testingGenerator.isOutfitGood(buttonedShirt, denimShorts, shoes, rainJacket, watch);
    // Your outfit can't contain double denim
    System.out.println("\nOutfit 2");
    testingGenerator.isOutfitGood(shirt, pants, trainers, winterCoat, plainTie);
    // Your outfit can't contain double denim
    System.out.println("\nOutfit 3");
    testingGenerator.isOutfitGood(jumper, denimPants, winterBoots, cloak, fancyTie);
    // Sick cloak, it really ties everything together.
    System.out.println("\nOutfit 4");
    testingGenerator.isOutfitGood(tshirt, trousers, workBoots, rainJacket2, bowler);
    // That hat doesn't go with your outerwear
    System.out.println("\nOutfit 5");
    testingGenerator.isOutfitGood(poloShirt, shorts, smartShoes, winterCoat2, watch1);
    // Your pants don't match your Work shoes
    // Your outfit is dirty!
    // Your outfit is too plain
    System.out.println("\nOutfit 6");
    testingGenerator.isOutfitGood(topPoloShirt, shorts2, winterBoots2, rainJacket3, watch2);
    // Pick a season, you can't wear shorts and winter clothes
    System.out.println("\nOutfit 7");
    testingGenerator.isOutfitGood(bestPolo, trousers2, winterBoots3, rainJacket4, watch3);
    // Nice outfit

    // Random outfit generator
    testingGenerator.generateRandomOutfit();
  }

}
