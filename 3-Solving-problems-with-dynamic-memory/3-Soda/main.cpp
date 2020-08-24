#include <iostream>
using namespace std;

int main() {
    struct soda {
        int gramsOfSugar;
        float gramsOfCarbonation;
    };

    const int ARRAY_SIZE = 3;
    soda **sodaArray = new soda *[ARRAY_SIZE];

    // create structs as new on the heap and assign values
    sodaArray[0] = new soda;
    sodaArray[0]->gramsOfSugar = 1;
    sodaArray[0]->gramsOfCarbonation = 1.1;
    sodaArray[1] = new soda;
    sodaArray[1]->gramsOfSugar = 2;
    sodaArray[1]->gramsOfCarbonation = 2.2;
    sodaArray[2] = new soda;
    sodaArray[2]->gramsOfSugar = 3;
    sodaArray[2]->gramsOfCarbonation = 3.3;

    // loop through array and print struct values
    for (int i = 0; i < ARRAY_SIZE; i++) {
        cout << "Soda " << i + 1 << ':' << endl;
        cout << "Grams of sugar: " << sodaArray[i]->gramsOfSugar << endl;
        cout << "Grams of carbonation: " << sodaArray[i]->gramsOfCarbonation << endl;
    }

    // delete structs
    for (int i = 0; i < ARRAY_SIZE; i++) {
        delete sodaArray[i];
        sodaArray[i] = NULL;
    }
    // delete array
    delete[] sodaArray;
    sodaArray = NULL;
}
