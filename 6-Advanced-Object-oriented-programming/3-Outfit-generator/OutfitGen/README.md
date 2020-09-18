# README

## Object Heirachy

I set up the object heirachy with Clothes and the Base class, and the 5 clothing types as subclasses:

- Shirt
- Pants
- Shoes
- Outwear
- Accessories

  I set up subclass below each of these classes, to represent the clothing types for each category. I set up some classes below these in some categories, to further refine the objects that could be created.

  Below the shirts subclass, I set up a collardShirt abstract subclass, as it in itself would not be instatiated as an object, as polo and buttoned shirt covered the available options and have different characterstics. I added the pocketCount attribute as this is one they both would share. I also created further subclasses below boots, to further specify. However boots was not abstract as it does not cover all use cases. I also created an interface for checking shoe compatibility as the `goodWithSmartShoes()` method is used in the Shoes and Pants classes, and nowhere else, so these classes implement this interface.

  The most generic methods were added to the Clothes class, so they could be overriden if required. I considered making an interface for some methods, such as isPlain, but the methods I used to loop through to check this were using the Clothes class, so this method needed to exist in this class, and as the base class, an interface wasn't required. I did set up an interface for Winter for the `isWinterClothing()` method, to be implemented in Shoes and Outwear, returned false by default but true for Winter boots and Winter shoes.

## Characteristics check

The characteristics I added checks for were:

### Clothes

isPlain()
isDirty()
goodWithEverything()
isPatterned()

### Outerwear

goodWithHat()
goodWithShorts()
isWinterClothing()

### Shirt

goodWithSmartShoes()
goodWithTie()

### Pants

goodWithSmartShoes()

## Rules

_The rules you used to determine if an outfit was a good one and how you implemented them in code._

For all rules, if a problem is found, then this is added to the create problemsArray. If this has a `length > 0` then the problems are printed out and the `isOutfitGood()` method will return false. This method accepts five objects, one of the five main clothing classes.

- Good with everything check
  If the method `goodWithEverything()` returns true, no other checks are carried out and the outfit is good and isOutfitGood() returns true. All clothes return this as false by default unless the method is overridden (Cloak in this case).

- No clothing items can be dirty
  All outfit items are looped through and the `getIsClean()` method returns true/false if they are clean.

- Only one denim item allowed
  All outfit items are looped through and if the item is patterned, then the string is checked to see if it is denim. For each denim found, a count is incremented and then returned.

- Max one plain item
  All outfit items are looped through and if the item is checked using `isPlain()`. For each plain item found, a count is incremented and then returned.

- Smart shoes can't be worn with certain pants or shirts.
  If the outfit's shoes are SmartShoes `shoes instanceof SmartShoes`, goodWithSmartShoes() is run on the shirt and pants, returns true or false.
-

- Hats can't be worn with hooded outerwear
  If the accessory is a hat, `goodWithHat()` is run to see if it's compatible.

- Winter clothing cannot be worn with shorts
  If the pants in the outfit are shorts, `isWinterClothing()` is run on the Outerwear and Shoes. If this returns true, then a problem is added to the ArrayList.

- Ties can only be worn with a buttoned shirt
  If a tie is worn, `goeWithTie()` is run on the shirt to see if it is compatible, adding a problem if it is not.

- Two items can't have the same pattern
  The `arePatternsDuplicated()` method accept the outfit `ArrayList<Clothes>` as an argument.
  First this method loops through the items in the outfit and if `isPatterned()` returns true, this item pattern String is added to a new ArrayList. This list is then added to a new Set to remove duplicates. If this is shorter than the original ArrayList passed to the function, then duplicates exist and this method returns true, and a new problem is added.

The OutfitGen has a wardrobe attribute, which is a Wardrobe object, containing ArrayLists of all five clothing types. The static method `getSampleWardrobe()` in the Wardrobe class can be used to generate sample clothing to use in a new OutfitGen.

The `generateRandomOutfit()` method takes each list from the wardrobe attribute, and then uses the `randomNumber()` method (which accepts the length of each list as an parameter). This generates a random number which is used as an index to return a random item from each list. These objects are then passed to `isOutfitGood()`. If this returns true, the outfit is printed out. If false, the outfit is printed out with the problems, and the method runs again until a outfit with 0 problems is generated.
