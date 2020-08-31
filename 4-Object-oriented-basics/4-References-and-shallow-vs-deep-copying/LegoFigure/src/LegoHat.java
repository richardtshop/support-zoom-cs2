/* Define a class called LegoHat. It should have a style (stored as a String) and a size (stored as an int). Provide a constructor (which allows each attribute to be set), as well as the following methods:

public String toString(), which converts the hat to an appropriate String. For example, if the style is "toque" and the size is "medium", then the method could return "a medium toque".
 
public int computeStyle(String season), which returns an int that represents the degree to which the hat is stylish, described on a scale of 1 (completely ugly) to 10 (completely perfect). You can compute this however you like, subject to the restrictions that "toque"s are completely ugly unless the season is "winter", and "sun visor"s are completely ugly unless the season is "summer". */

public class LegoHat {
    public String style;
    public int size;

    public LegoHat(String hatStyle, int hatSize) {
        style = hatStyle;
        size = hatSize;
    }

    public String toString() {
        String hatString = "a size " + size + " " + style + " hat";
        return hatString;
    }

    public int computeStyle(String season) {
        // return 1 if sun visor in winter or toque in summer
        if ((style.equals("toque") && !season.equals("winter"))
                || (style.equals("sun-visor") && !season.equals("summer"))) {
            return 1;
        }

        // return 10 if sun visor in summer or toque in winter
        if ((style.equals("toque") && season.equals("winter"))
                || (style.equals("sun-visor") && season.equals("summer"))) {
            return 10;
        }
        // return random integer between 1 and 10
        return (int) (Math.random() * (10 - 1) + 1);
    }
}
