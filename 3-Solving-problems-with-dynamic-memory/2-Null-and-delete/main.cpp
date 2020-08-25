#include <iostream>
using namespace std;

// Question 2
/* Removing the check for NULL pointer causes a segmentation fault error, as the print statement is printing out the value at the address
the pointer is pointing to, and as the pointer has NUll instead of a memory address value, it's not possible to 
read any variable as there is no address.
*/

int main() {
    const int ARRAY_SIZE = 4;
    int* pointerArray[ARRAY_SIZE];

    pointerArray[0] = new int;
    pointerArray[1] = new int;
    pointerArray[2] = NULL;
    pointerArray[3] = new int;

    *(pointerArray[0]) = 1;
    *(pointerArray[1]) = 10;
    *(pointerArray[3]) = 50;

    for (int i = 0; i < ARRAY_SIZE; i++) {
        if (pointerArray[i] != NULL) {  // print out integer values if the pointer points to an integer
            cout << *pointerArray[i] << endl;
        }
    }

    for (int i = 0; i < ARRAY_SIZE; i++) {
        if (pointerArray[i] != NULL) {
            delete pointerArray[i];
            pointerArray[i] = NULL;
        }
    }
    return 0;
}