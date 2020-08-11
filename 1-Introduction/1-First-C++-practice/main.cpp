#include <iostream>
#include <string>
#include <cmath>

using namespace std;


// orbitalSpeed takes an altitude in km and then uses the formula for calculating orbital velocity with the parameters for the earth's mass and radius to return the required speed to maintain orbit at that altitude above earth
float orbitalSpeed(int altitude)

{
    float massEarth = 5.972 * pow(10, 24); // mass of earth in kg
    float radiusEarth =  6.371 * pow(10, 6); // radius of earth in m
    float G = 6.67408 * pow(10, -11); // gravitational constant
    int altitudeMeters = altitude * 1000;
    float velocity = sqrt((G * massEarth)/(radiusEarth + altitudeMeters)); // velocity in m/s
    float velocityKph = velocity/1000*60*60;
    return velocityKph;
}


int main()
{
    cout << "Examples:" << endl;
    cout << "Velocity required for orbit at 2,000km altitude: " << orbitalSpeed(2000) << " km/h" << endl;
    cout << "Velocity required for orbit at  100,000km altitude: " << orbitalSpeed(100000) << " km/h" << endl << endl;

    int alt = 0;
    cout << "To calculate an orbital velocity, please enter an altitude above the earth in km" << endl;
    cin >> alt;
    if (cin.fail())
    {
        cout << "This is not a valid data type" << endl;
    }
    else if (alt <= 0)
    {
        cout << "Altitude cannot be less than 0" << endl;
    }
    else if (alt <= 100)
    {
        cout << "Altitudes below 100km are too low to maintain orbit without boosting due to air resitance." << endl;
        cout << "If there was no atmosphere, the velocity required for orbit at "<< alt << "km altitude would be " << orbitalSpeed(alt) << " km/h" << endl;
    }
    else
    {
        cout << "Velocity required for orbit at "<< alt << "km altitude: " << orbitalSpeed(alt) << " km/h" << endl;
    }
    return 0;
}