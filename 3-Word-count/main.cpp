#include <iostream>


using namespace std;

int main() {
    char inputChar;
    int totalWords = 0;
    int currentWordLength = 0;
    int longestWordLength = 0;
    int mostVowelsCurrent = 0;
    int mostVowelsTotal = 0;

    cout << "Enter code characters separated by commas: ";
    do {
        inputChar = cin.get();
        currentWordLength++;
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
        if (inputChar == ' ' || inputChar == 10) {
            totalWords++;
            if (currentWordLength > longestWordLength) {
                longestWordLength = currentWordLength - 1;
            }
            if (mostVowelsCurrent > mostVowelsTotal) {
                mostVowelsTotal = mostVowelsCurrent;
            }
            mostVowelsCurrent = 0;
            currentWordLength = 0;
        }
    } while (inputChar != 10);

    cout << "Total words: " << totalWords << endl;
    cout << "Longest word length: " << longestWordLength << endl;
    cout << "Largest number of vowels in a single word: " << mostVowelsTotal << endl;
    return 0;
}


