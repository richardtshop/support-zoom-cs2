#include <iostream>

using namespace std;

struct myTime {
    string period;  // AM or PM
    int hour;
    int minute;
    int seconds;
};

// convert time to 24 hour time
void twentyFourHourTime(myTime &currentTime) {
    // if current hour is in the afternoon and isn't 12, then add 12 to convert to 24hr time
    if (currentTime.period == "PM" && currentTime.hour != 12) {
        currentTime.hour += 12;
        // if current hour is in the morning and is 12, subtract 12 to convert to 24hr time
    } else if (currentTime.period == "AM" && currentTime.hour == 12) {
        currentTime.hour -= 12;
    }
}

void timeLeftToday(myTime currentTime) {
    // convert current hour to 24 hour time so all hour values can be subtracted from 24 to get the remaining hours in the day
    twentyFourHourTime(currentTime);
    // variables to modify the hours and minutes remaining
    // if the current time has minute or second values greater than 0, then we need to adjust the next component of the time so we are subtracting the correct amount of time
    int minuteModifer = 1;
    int hourModifier = 1;
    // calculate the number of seconds left in the current minute, minutes in the current hour and hours in the current day
    int secondsLeft = 60 - currentTime.seconds;
    // if seconds = 60, then minutes does not need to be decremented by 1 and seconds needs to be reset to 0
    if (secondsLeft == 60) {
        minuteModifer = 0;
        secondsLeft = 0;
    }
    // if minutes = 60, then hours need does not need to be decremented by 1 and minutes needs to be reset to 0
    int minutesLeft = 60 - currentTime.minute - minuteModifer;
    if (minutesLeft == 60) {
        hourModifier = 0;
        minutesLeft = 0;
    }
    int hoursLeft = 24 - currentTime.hour - hourModifier;
    cout << hoursLeft << ':' << minutesLeft << ':' << secondsLeft << endl;
}

int main() {
    myTime timeNow = {"PM", 3, 55, 32};
    timeLeftToday(timeNow);
    twentyFourHourTime(timeNow);
    cout << timeNow.hour;
}
