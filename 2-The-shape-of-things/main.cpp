#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int row = 1;
    int midRow = 5;
    int columns = 19;
    bool reverse = false;
    while (row >= 1 && row <= midRow) {
        for (int hashNum = 1; hashNum <= columns; hashNum++) {
            if (
                (hashNum >= row && hashNum < row + row) ||
                (hashNum <= columns - row + 1 && hashNum >= columns - (row - 1) * 2) ||
                (row == midRow && hashNum == midRow * 2)) {
                cout << '#';
            }
            else {
                cout << ' ';
            }
        }
        cout << '\n';
        if (row == midRow && reverse == false) {
            reverse = true;
            row++;
        }

        if (reverse) row--;
        else row++;
    }
    return 0;
}