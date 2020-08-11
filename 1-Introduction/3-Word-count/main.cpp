#include <iostream>

using namespace std;

int main() {
    char inputChar;
    int totalWords = 0;
    int currentWordLength = 0;
    int longestWordLength = 0;
    int mostVowelsCurrent = 0;
    int mostVowelsTotal = 0;
    bool spaceLastChar = false;

    cout << "Enter words separated by spaces: ";
    do {
        inputChar = cin.get();
        if (inputChar != ' ' && inputChar != 10) {
            if (inputChar != ',' && inputChar != '.' && inputChar != '?' && inputChar != '!') {
                currentWordLength++;
            }
            spaceLastChar = false;
            if (
                inputChar == 'a' ||
                inputChar == 'e' ||
                inputChar == 'i' ||
                inputChar == 'o' ||
                inputChar == 'u' ||
                inputChar == 'A' ||
                inputChar == 'E' ||
                inputChar == 'I' ||
                inputChar == 'O' ||
                inputChar == 'U'
                ) {
                mostVowelsCurrent++;
            }
        }
        else { // if input character is a space or EOL
            totalWords++;
            if (currentWordLength > longestWordLength) {
                longestWordLength = currentWordLength;
            }
            if (mostVowelsCurrent > mostVowelsTotal) {
                mostVowelsTotal = mostVowelsCurrent;
            }
            if (inputChar == ' ') {
                if (spaceLastChar || currentWordLength == 0) { // if multiple spaces or input starts with a space, decrement word count each time
                    totalWords--;
                }
                spaceLastChar = true;
            }
            mostVowelsCurrent = 0;
            currentWordLength = 0;
        }
    } while (inputChar != 10);

    if (longestWordLength == 0) {
        cout << "You must enter at least one word." << endl;
    }
    else {
        if (spaceLastChar) totalWords--;
        cout << "Total words: " << totalWords << endl;
        cout << "Longest word length: " << longestWordLength << endl;
        cout << "Largest number of vowels in a single word: " << mostVowelsTotal << endl;
    }
    return 0;
}


