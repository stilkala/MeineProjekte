#ifndef LINE_H
#define LINE_H

#include "shape.h"

class Line : public Shape {
public:
Line() = delete; // keine Standardlinie
Line( int, int, int, int ); // ein Konstruktor
void set( int, int, int, int );
void draw(Frame* frame); // rein virtuelles shape::draw() ueberschreiben
void move( int h, int v ); // rein virtuelles shape::move() ueberschreiben
private:
int start_x, start_y, end_x, end_y;
};
Line::Line( int sx, int sy, int ex, int ey ) // Skizze Konstuktordefinition
: start_x{sx}, start_y{sy}, end_x{ex}, end_y{ey} { }
void Line::move( int h, int v ) { // Def. der line::move() Methode
start_x += h; start_y += v; end_x += h; end_y += v;
}
void Line::set(int sx, int sy, int ex, int ey){
    start_x = sx;
    start_y = sy;
    end_x = ex;
    end_y = ey;
}

void Line::draw(Frame* frame){
char c;
char b;

    if( end_x < start_x ) {
    // Start- und Endpunkt vertauschen
        int i = start_x;
        start_x = end_x;
        end_x = i;
    }

    if( end_y > start_y ) {
    // Vorzeichen beider Y-Koordinaten umdrehen
    // dafuer einen Merker setzen
        start_y = 0 - start_y;
        end_y = 0 - end_y;
        c = 'x';
    }

    if( (end_x - start_x) < (start_y - end_y) ) {
    // start_Xcoord mit start_Ycoord vertauschen
    // end_Xcoord mit end_Ycoord vertauschen
    // dafuer einen weiteren Merker setzen
            int i = start_x;
            start_x = start_y;
            start_y = i;
            i = end_x;
            end_x = end_y;
            end_y = i;
            b = 'z';
    }

    int dx,dy,p;
    dx=end_x-start_x;
    dy=end_y-start_y;
    p = 2 * (dy) - (dx);


    while(start_x <= end_x)
        {
            if(p < 0)
            {
                start_x=start_x+1;
                p = p + 2 * (dy);
            }
            else
            {
                start_x=start_x+1;
                start_y=start_y+1;
                p = p + 2 * (dy - dx);
            }
            frame->put_line(start_x,start_y);
    }



 frame->show();//kommt dann ans ende nachdem wir die line gedrawt haben



}//DRAW

#endif // LINE_H
