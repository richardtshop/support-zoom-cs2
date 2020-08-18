#include <iostream>

using namespace std;

struct course {
    string department;
    int course;
    string title;
};

const int ARRAY_SIZE = 10;
// current offered courses
course courseArray[ARRAY_SIZE] = {
    {"COMP", 1345, "Intro to Computer Science 3"},
    {"COMP", 1346, "Networking"},
    {"ENG", 1456, "Bridge building 1"},
    {"LIT", 8903, "Shakespeare on stage"},
    {"LIT", 8909, "American Literature"},
    {"HIS", 5673, "French Revolution"},
    {"PHY", 2453, "Quantum Relativity"},
    {"CHEM", 2489, "Physical Chemistry"},
    {"CHEM", 2490, "Organic Chemistry 2"},
    {"CHEM", 2492, "Advanced material synthesis"}};

int coursesPerDep(course courseArray[], int totalCourses, string department) {
    // initialise the course count to 0 to start
    int courseCount = 0;
    // loop through each course
    for (int i = 0; i < totalCourses; i++) {
        // if (courseArray[i].department.compare(department) == 0) // alternative compare
        // if the current course department = the passed department string, then increase the course count
        if (courseArray[i].department == department) {
            courseCount++;
        }
    }
    // return the course count, if the deparment doesn't exist courseCount will = 0
    return courseCount;
}

int main() {
    string department = "CHEM";
    int totalCourses = coursesPerDep(courseArray, ARRAY_SIZE, department);
    cout << "Total courses for " << department << ": " << totalCourses;
    return 0;
}
