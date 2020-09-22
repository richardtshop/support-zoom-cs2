package data;

import clothes.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Random;

public class OutfitGen {
  private Wardrobe _wardrobe;

  public OutfitGen(Wardrobe wardrobe) {
    _wardrobe = wardrobe;
  }

  // get methods
  public Wardrobe getWardrobe() {
    return _wardrobe;
  }

  public Wardrobe getOutfit() {
    return _wardrobe;
  }

  // other methods
  public int randomNumber(int max) {
    Random random = new Random();
    int min = 0;
    int index = random.nextInt(max - min + 1) + min;
    return index;
  }

  public int plainCount(ArrayList<Clothes> outfit) {
    int plainCount = 0;
    for (Clothes outfitItem : outfit) {
      if (outfitItem.isPlain()) {
        plainCount++;
      }
    }
    return plainCount;
  }

  // count number of items that are denim
  public int denimCount(ArrayList<Clothes> outfit) {
    int denimCount = 0;
    for (Clothes outfitItem : outfit) {
      if (outfitItem.getMaterial().equalsIgnoreCase("denim")) {
        denimCount++;
      }
    }
    return denimCount;
  }

  // Check if items with patterns have the same pattern
  public boolean arePatternsDuplicated(ArrayList<Clothes> outfit) {
    ArrayList<String> patternList = new ArrayList<String>();
    boolean duplicatePatterns = false;
    for (Clothes outfitItem : outfit) {
      if (outfitItem.isPatterned()) {
        patternList.add(outfitItem.getPattern());
      }
    }
    // create a Set to pass the patterns to, and then compare this to the original
    // list
    // As sets remove duplicates, if the Set is larger, then a pattern is repeated
    if (patternList.size() > 1) {
      Set<String> patternListSet = new LinkedHashSet<String>();
      patternListSet.addAll(patternList);
      if (patternListSet.size() < patternList.size()) {
        duplicatePatterns = true;
      }
    }
    return duplicatePatterns;
  }

  // Print outfit item names
  public void printOutfit(Shirt shirt, Pants pants, Shoes shoes, Outerwear outer, Accessories acc) {
    System.out.println("Shirt: " + shirt.getName());
    System.out.println("Pants: " + pants.getName());
    System.out.println("Shoes: " + shoes.getName());
    System.out.println("Outerwear: " + outer.getName());
    System.out.println("Accessories: " + acc.getName());
  }

  // generate a random outfit from the supplied wardrobe
  // print out each outfit and then declare if it is good or bad
  public void generateRandomOutfit() {
    ArrayList<Shirt> shirts = _wardrobe.getShirtsList();
    ArrayList<Pants> pants = _wardrobe.getPantsList();
    ArrayList<Shoes> shoes = _wardrobe.getShoesList();
    ArrayList<Outerwear> outerwear = _wardrobe.getOuterwearList();
    ArrayList<Accessories> accessories = _wardrobe.getAccessoriesList();

    // pick a random item of clothing from each clothing list
    Shirt randomShirt = shirts.get(randomNumber(shirts.size() - 1));
    Pants randomPants = pants.get(randomNumber(pants.size() - 1));
    Shoes randomShoes = shoes.get(randomNumber(shoes.size() - 1));
    Outerwear randomOuterwear = outerwear.get(randomNumber(outerwear.size() - 1));
    Accessories randomAccessories = accessories.get(randomNumber(accessories.size() - 1));

    // calculate if the outfit passes all the conditions for a good outfit
    boolean isGood = isOutfitGood(randomShirt, randomPants, randomShoes, randomOuterwear, randomAccessories);

    // Print the outfit along with a statement
    // If the outfit is bad repeat generation
    printOutfit(randomShirt, randomPants, randomShoes, randomOuterwear, randomAccessories);
    if (!isGood) {
      System.out.println("\nThis outfit is bad. I will try again\n");
      generateRandomOutfit();
    } else {
      System.out.println("Random outfit generation a success!");
    }
  }

  // runs tests to check if outfits passed it a good outfit
  public boolean isOutfitGood(Shirt shirt, Pants pants, Shoes shoes, Outerwear outer, Accessories acc) {
    ArrayList<Clothes> outfit = new ArrayList<Clothes>();
    ArrayList<String> problems = new ArrayList<String>();

    outfit.add(shoes);
    outfit.add(shirt);
    outfit.add(pants);
    outfit.add(outer);
    outfit.add(acc);

    // Something that is good with everything makes an outfit good, regardless of
    // other rules
    for (Clothes outfitItem : outfit) {
      if (outfitItem.goodWithEverything()) {
        System.out.println(outfitItem.getName() + " looks great, it really ties everything together.");
        return true;
      }
    }

    // check if any clothes are dirty
    for (Clothes outfitItem : outfit) {
      if (!outfitItem.getIsClean()) {
        problems.add("Your outfit is dirty!");
      }
    }
    // check if more than two items are denim
    if (denimCount(outfit) > 1) {
      problems.add("Your outfit can't contain double denim");
    }

    if (plainCount(outfit) > 1) {
      problems.add("Your outfit is too plain");
    }

    // if wearing smart shoes, check shirt and pants match them
    if (shoes instanceof SmartShoes) {
      if (!shirt.goodWithSmartShoes()) {
        problems.add("Your shirt doesn't match your " + shoes.getName());
      }
      if (!pants.goodWithSmartShoes()) {
        problems.add("Your pants don't match your " + shoes.getName());
      }
    }

    // An outfit with a hat, can't contian incompatible outewear
    if (acc instanceof Hat && !outer.goodWithHat()) {
      problems.add("That hat doesn't go with your outerwear");
    }

    // If pants is shorts, need to check if a winter coat is being worn
    if (pants instanceof Shorts && (outer.isWinterClothing() || shoes.isWinterClothing())) {
      problems.add("Pick a season, you can't wear shorts and winter clothes");
    }

    // if wearing a tie, need to check the shirt matches
    if (acc instanceof Tie && !shirt.goesWithTie()) {
      problems.add("Where are you gonna put that tie? Eh?");
    }

    // two items cannot have the same pattern
    if (arePatternsDuplicated(outfit)) {
      problems.add("You have duplicated patterns, please change.");
    }

    // If there are problems in the array, print them and return false
    // Otherwise the outfit is good
    if (problems.size() > 0) {
      for (String problem : problems) {
        System.out.println(problem);
      }
      return false;
    } else {
      System.out.println("Nice outfit");
      return true;
    }
  }
}
