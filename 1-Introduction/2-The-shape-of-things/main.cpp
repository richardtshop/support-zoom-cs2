#include <cmath>
#include <iostream>

using namespace std;

int main() {
    int currentRow = 1;      // starting row
    int centerRowIndex = 5;  // last row before image is mirrored
    int totalColumns = 19;   // total columns

    // The loop will count up to the centerRow and then reverse counting down
    // to produce the mirrored printout
    // This boolean will be used to check if the row numbers in the loop should increase or decrease
    bool rowNumberIncreasing = true;

    // loop while the rows are between 1 and the center (halfway row)
    // as the loop is counting up then down, this will create all the rows we need
    while (currentRow >= 1 && currentRow <= centerRowIndex) {
        // nested for loop going through each column position in each row from left to right
        for (int currentColumn = 1; currentColumn <= totalColumns; currentColumn++) {
            // the three conditions in the if statement calculate if a # should be printed
            // 1. Calculate the right-hand start and end for printing # for each row
            // Start printing: current column is larger/equal to the current row
            // End printing: current column is smaller then 2* row

            // 2. Calculate the right-hand start and end for printing # for each row
            // Start printing: current column smaller than total columns minus current row + 1
            // End printing: current column is greater than total columns minus ((current row - 1) * 2)

            // 3. The above doesn't calculate for the center row, so if the loop is on the center row, also
            // print if the current column is double the center row value
            if (
                (currentColumn >= currentRow && currentColumn < 2 * currentRow) ||
                (currentColumn <= totalColumns - currentRow + 1 && currentColumn >= totalColumns - ((currentRow - 1) * 2)) ||
                (currentRow == centerRowIndex && currentColumn == centerRowIndex * 2)) {
                cout << '#';
            } else {
                cout << ' ';
            }
        }

        cout << '\n';
        // When we reach the center row index in the loop when incrementing, set the rowNumberIncreasing to false to reverse the loop
        if (currentRow == centerRowIndex && rowNumberIncreasing == true) {
            rowNumberIncreasing = false;
            currentRow++;  // increment once more so the below if statement will correctly decrement and repeat the center row
        }

        // If rowNumberIncreasing then we want to incremement the currenRow, otherwise decrement
        if (rowNumberIncreasing) {
            currentRow++;
        } else {
            currentRow--;
        }
    }
    return 0;
}