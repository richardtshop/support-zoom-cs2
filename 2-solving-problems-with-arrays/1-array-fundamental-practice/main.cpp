#include<iostream>

using namespace std;

bool isSorted(int array[], int numItems) {
    bool sorted = true;

    int currentPosition = 1;
    // loop through array if sorted is still true and we haven't looped through all elements
    // if array has a single element it is sorted and the while loop doesn't run
    while (sorted == true && currentPosition < numItems) {
        // if current element is smaller than the previous, then the array is not sorted
        // assign sorted to true, which exits the while loop
        if (array[currentPosition] < array[currentPosition - 1]) {
            sorted = false;
        }
        // increment to check next elements
        currentPosition++;
    }
    return sorted;
}

char upperCaseCounter(const char array[], int numItems) {
    int upperCaseCount = 0;
    // initialize variables for the character codes for uppercase A and Z. 
    const int A = 0 + 'A';
    const int Z = 0 + 'Z';
    for (int i = 0; i < numItems; i++) {
        // get the character code for the current character
        int currentCharCode = 0 + array[i];
        // if the current character code is between the A and Z variables (inclusive), then increment the upperCaseCount by 1
        if (currentCharCode >= A && currentCharCode <= Z) {
            upperCaseCount++;
        }
    }
    return upperCaseCount;
}


int main() {
    // isSorted
    const int ARRAY_LENGTH = 11;
    int myArray[ARRAY_LENGTH] ={ 1, 2, 3, 4, 5, 6, 8, 11, 14, 21, 30 };
    bool sortedTest = isSorted(myArray, ARRAY_LENGTH);
    cout << "The input array is ";
    if (sortedTest == 1) {
        cout << "sorted";
    }
    else {
        cout << "not sorted";
    }
    cout << endl;

    // Upper case character count
    const char characterArray[ARRAY_LENGTH] ={ 'n', 'm', 'L', 'p', 'Q', 'e', 'V', 'r', 'E', 'd', 'P' };
    int uppercaseCount = upperCaseCounter(characterArray, ARRAY_LENGTH);
    cout << "Uppercase count: " << uppercaseCount;
    return 0;
}