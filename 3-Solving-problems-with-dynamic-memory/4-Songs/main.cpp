#include <iostream>
#include <sstream>
#include <string>

using namespace std;

// enum for the ratings a song can have out of five
enum stars { One = 1,
             Two = 2,
             Three = 3,
             Four = 4,
             Five = 5,
};

struct song {
    string title;
    string artist;
    int year;
    stars rating;
};

void stringsongToString(song s) {
    stringstream songStream;                                                                 // declare songstream
    songStream << s.artist << '-' << s.title << " (" << s.year << ") " << s.rating << "/5";  // create string stream using song struct member values
    string songString = songStream.str();                                                    // convert string stream into string
    cout << songString << endl;                                                              // print string
}

song **songsFromYear(song **songs, int size, int year, int *resultSize) {
    // loop to calculate the total number of songs that match the correct year
    for (int i = 0; i < size; i++) {
        if (songs[i]->year == year) {
            *resultSize += 1;  // increment resultSize if years match
        };
    }

    // declare songArrayFromYear using the resultSize int
    song **songArrayFromYear = new song *[4];
    int newSongIndex = 0;              // initialise the current index to insert the new songs in the new array
    for (int i = 0; i < size; i++) {   // loop through the original array
        if (songs[i]->year == year) {  // if the year matches the passed year, then add the song to the new array at the current index
            songArrayFromYear[newSongIndex] = new song;
            songArrayFromYear[newSongIndex]->title = songs[i]->title;
            songArrayFromYear[newSongIndex]->artist = songs[i]->artist;
            songArrayFromYear[newSongIndex]->year = songs[i]->year;
            songArrayFromYear[newSongIndex]->rating = songs[i]->rating;
            newSongIndex++;  // increment index for next song
        }
    }
    return songArrayFromYear;
}

int main() {
    const int ARRAY_SIZE = 5;
    // declare dynamiclly sized array
    song **songArray = new song *[ARRAY_SIZE];

    // assign variables to song structs
    songArray[0] = new song;
    songArray[0]->title = "Party Hard";
    songArray[0]->artist = "Andrew WK";
    songArray[0]->year = 2000;
    songArray[0]->rating = Five;

    songArray[1] = new song;
    songArray[1]->title = "She Is Beautiful";
    songArray[1]->artist = "Andrew WK";
    songArray[1]->year = 2001;
    songArray[1]->rating = Five;

    songArray[2] = new song;
    songArray[2]->title = "It's Time To Party";
    songArray[2]->artist = "Andrew WK";
    songArray[2]->year = 2001;
    songArray[2]->rating = Three;

    songArray[3] = new song;
    songArray[3]->title = "Danger! High Voltage";
    songArray[3]->artist = "Electrix Six";
    songArray[3]->year = 2003;
    songArray[3]->rating = Five;

    songArray[4] = new song;
    songArray[4]->title = "I Love NYC";
    songArray[4]->artist = "Andrew WK";
    songArray[4]->year = 2001;
    songArray[4]->rating = Five;

    // print song string
    stringsongToString(*songArray[4]);

    // initialise resultsSize variable as 0 for new songsFromYearArray
    int resultsSize = 0;
    song **songsFromYearArray = songsFromYear(songArray, ARRAY_SIZE, 2001, &resultsSize);

    // loop through each song in new year array and print
    if (resultsSize > 0) {
        for (int i = 0; i < resultsSize; i++) {
            stringsongToString(*songsFromYearArray[i]);
        }
    }

    // delete structs
    for (int i = 0; i < ARRAY_SIZE; i++) {
        delete songArray[i];
        songArray[i] = NULL;
        // as songsFromYearArray cannot be larger than original array, memory for this can be deallocated in this loop
        if (i < resultsSize) {
            delete songsFromYearArray[i];
            songsFromYearArray[i] = NULL;
        }
    }

    // delete arrays
    delete[] songArray;
    songArray = NULL;
    delete[] songsFromYearArray;
    songsFromYearArray = NULL;
    return 0;
}
