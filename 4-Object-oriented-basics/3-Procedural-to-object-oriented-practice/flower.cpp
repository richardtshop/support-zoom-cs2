#include <string.h>

#include <iostream>

using namespace std;

class flower {
   public:
    string color;
    int height;
    float percentWater;

    flower(string c, int h, float pW) {
        color = c;
        height = h;
        percentWater = pW;
    };

    void print() {
        cout << color << " (" << height << " cm, "
             << percentWater << "% water)" << endl;
    }

    void grow() {
        height += 2;
        percentWater -= 0.05f;
    }

    void water() {
        this->percentWater += 0.1f;
    }
};

int main() {
    flower f("purple", 10, 0.5);

    f.print();
    f.water();

    f.print();
    f.grow();

    f.print();

    return 0;
}
