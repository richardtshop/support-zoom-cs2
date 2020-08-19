#include <iostream>

using namespace std;

struct domino {
    int top;
    int bottom;
};

void printDominoes(domino dominoes[], int size) {
    // 7 possible values for each half of a domino
    const int VALUES_SIZE = 7;
    // each value layout has three rows
    const int PATTERN_ARRAY_SIZE = 3;
    // array of set patterns for each domino layout in three rows for each int 0-6
    string patterns[VALUES_SIZE][PATTERN_ARRAY_SIZE] = {{"  ", "   ", "  "}, {"  ", " * ", "  "}, {"*  ", "   ", "  *"}, {"* ", " * ", "  *"}, {"* *", "   ", "* *"}, {"* *", " * ", "* *"}, {"* *", "* *", "* *"}};
    // loop through each domino stuct stored in the arrat
    for (int dom = 0; dom < size; dom++) {
        // print the top value by accessing the patterns array index using the value of the top member of the current domino
        for (int i = 0; i < PATTERN_ARRAY_SIZE; i++) {
            cout << patterns[dominoes[dom].top][i] << endl;
        }
        // print break between top and bottom of the domino
        cout << "---" << endl;

        // print the bottom value by accessing the patterns array index using the value of the top member of the current domino
        for (int j = 0; j < PATTERN_ARRAY_SIZE; j++) {
            cout << patterns[dominoes[dom].bottom][j] << endl;
        }
        cout << endl;
    }
}

int main() {
    int ARRAY_SIZE = 28;  // a complete double-six set contains 28 dominoes
    domino dominoes[ARRAY_SIZE];
    int current = 0;

    // a double-six contains seven rows of dominos, divided into rows by the bottom value
    for (int row = 0; row < 7; row++) {
        // for each row, insert a domino struct into the arrary. Each row contains 1 more domino than the previous row, starting at 1
        for (int column = 0; column <= row; column++) {
            dominoes[current].bottom = row;  // top value increments by 1 until it equals the current row/bottom value
            dominoes[current].top = column;  // bottom value remains the same for each row
            current++;
        }
    }

    // sort array by top domino value
    int start = 0;
    int end = ARRAY_SIZE - 1;
    // insertation sort to move the dominoes by the top value
    for (int i = start; i <= end; i++) {
        for (int j = i; j > start && dominoes[j - 1].top > dominoes[j].top; j--) {
            domino temp = dominoes[j - 1];
            dominoes[j - 1] = dominoes[j];
            dominoes[j] = temp;
        }
    }

    printDominoes(dominoes, ARRAY_SIZE);
    return 0;
}