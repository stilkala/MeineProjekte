#ifndef FRAME_H
#define FRAME_H

#include<iostream>
#include<array>

const int xMax {55}; // Zeichen pro Frame-Zeile
const int yMax {34}; // Zeilen pro Frame

class Frame {
public:
enum color { black = ' ', white = '*', point = '0'};
Frame( ); //GG
void put_point( int i, int j ); // Punkt im Frame speichern GG
void put_line(int i, int j);
void reset( ); // Frame leeren GG
void show( ) const; // Frame auf die Konsole ausgeben GG
bool on_frame( int, int ) const; // "Clipping"
private:
std::array< std::array<char,xMax>, yMax > frame;
};

#endif // FRAME_H
