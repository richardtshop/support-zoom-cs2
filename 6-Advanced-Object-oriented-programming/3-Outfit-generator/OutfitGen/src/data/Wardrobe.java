// This class stores lists of each clothing type 
// and also a static method to generate a sample wardrobe 
// full of

package data;

import clothes.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Wardrobe {
  private ArrayList<Shirt> _shirtsList;
  private ArrayList<Pants> _pantsList;
  private ArrayList<Shoes> _shoesList;
  private ArrayList<Outerwear> _outerwearList;
  private ArrayList<Accessories> _accessoriesList;

  // constructor
  public Wardrobe() {
    _pantsList = new ArrayList<Pants>();
    _shoesList = new ArrayList<Shoes>();
    _outerwearList = new ArrayList<Outerwear>();
    _shirtsList = new ArrayList<Shirt>();
    _accessoriesList = new ArrayList<Accessories>();
  }
  // getters

  public ArrayList<Shirt> getShirtsList() {
    return _shirtsList;
  }

  public ArrayList<Pants> getPantsList() {
    return _pantsList;
  }

  public ArrayList<Shoes> getShoesList() {
    return _shoesList;
  }

  public ArrayList<Outerwear> getOuterwearList() {
    return _outerwearList;
  }

  public ArrayList<Accessories> getAccessoriesList() {
    return _accessoriesList;
  }

  // setters

  public void setShirtList(ArrayList<Shirt> shirtsList) {
    _shirtsList = shirtsList;
  }

  public void setPantsList(ArrayList<Pants> pantsList) {
    _pantsList = pantsList;
  }

  public void setShoesList(ArrayList<Shoes> shoesList) {
    _shoesList = shoesList;
  }

  public void setOuterwearList(ArrayList<Outerwear> outerwearList) {
    _outerwearList = outerwearList;
  }

  public void setAccessoriesList(ArrayList<Accessories> accessoriesList) {
    _accessoriesList = accessoriesList;
  }

  // static method to generate a sample wardrobe for testings
  public static Wardrobe getSampleWardrobe() {
    // create lists
    // create clothes to add to lists

    Wardrobe sampleWardrobe = new Wardrobe();

    // Shirts
    ButtonedShirt buttonedShirt = new ButtonedShirt("Buttoned", "Blue", "Denim", true, 40, 2, true, 10, true);
    Shirt shirt = new Shirt("Plain shirt", "Black", "Cotton", true, 42);
    Jumper jumper = new Jumper("Winter jumper", "Green", "Wool", true, 44, true);
    TShirt tshirt = new TShirt("Casual T", "Yellow", "Cotton", true, 40, true, "My other tshirt is a poncho");
    PoloShirt poloShirt = new PoloShirt("Polo", "White", "Cotton", true, 40, 1, "Horse", true);
    PoloShirt dirtyPoloShirt = new PoloShirt("Used polo", "Red", "Cotton", false, 40, 1, "Horse", true);

    // Pants
    Shorts denimShorts = new Shorts("80s", "Blue", "Denim", true, true, 32, "None", "Knee");
    Pants pants = new Pants("Plain pants", "Blue", "Cotton", true, true, 30);
    Pants denimPants = new Pants("Deniom pants", "Black", "Denim", true, true, 30);
    Trousers trousers = new Trousers("Smart slacks", "Orange", "Cotton", true, false, 30, true, 28, 0);
    Shorts shorts = new Shorts("Bermudas", "Yellow", "Flannel", false, true, 38, "Plaid", "Knee");

    // Shoes

    Shoes shoes = new Shoes("Shoes", "Black", "Suede", true, "Laces", true);
    Trainers trainers = new Trainers("Trainers", "White", "Polyester", true, "Velcro", true, "Tennis");
    WinterBoots winterBoots = new WinterBoots("Sorels", "Brown", "Polyester", true, "Laces", true, 20, -30);
    WorkBoots workBoots = new WorkBoots("Timberlands", "Beige", "Suede", true, "Laces", true, 20, true, "");
    SmartShoes smartShoes = new SmartShoes("Work shoes", "Brown", "Leather", true, "None", true, "Brogues", 1);

    // Outerwear
    RainJacket rainJacket = new RainJacket("Mac", "Yellow", "Nylon", true, "", true, 0);
    WinterCoat winterCoat = new WinterCoat("Fjall", "Blue", "G1000", true, "Zip", true, -30);
    Cloak cloak = new Cloak("Cloaky", "Red", "Wool", true, "", false, "Swirly");

    // Accessories

    Watch watch = new Watch("Apple watch", "Silver", "Steel", true, "Arm", "Smartwatch", 90);
    Tie plainTie = new Tie("Wool tie", "Grey", "Wool", true, "Neck", true, true, "Plaid");
    Tie fancyTie = new Tie("Silk tie", "Magenta", "Silk", true, "Neck", false, true, "None");
    Hat bowler = new Hat("Dockers hat", "Black", "Felt", false, "Head", "Bowler", 22);
    Hat topHat = new Hat("Fancy hat", "Black", "Silk", true, "Head", "Top", 20);

    // Add sample clothes to wardrobe Array Lists
    sampleWardrobe.setShirtList(
        new ArrayList<Shirt>(Arrays.asList(shirt, jumper, tshirt, buttonedShirt, poloShirt, dirtyPoloShirt)));
    sampleWardrobe.setPantsList(new ArrayList<Pants>(Arrays.asList(pants, trousers, shorts, denimShorts, denimPants)));
    sampleWardrobe
        .setShoesList(new ArrayList<Shoes>(Arrays.asList(shoes, trainers, winterBoots, workBoots, smartShoes)));
    sampleWardrobe.setOuterwearList(new ArrayList<Outerwear>(Arrays.asList(winterCoat, rainJacket, cloak)));
    sampleWardrobe
        .setAccessoriesList(new ArrayList<Accessories>(Arrays.asList(watch, plainTie, fancyTie, bowler, topHat)));

    return sampleWardrobe;
  }
}
