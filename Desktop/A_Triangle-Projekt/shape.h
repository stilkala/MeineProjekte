#ifndef SHAPE_H
#define SHAPE_H

#include "frame.h"

class Shape {
public:
Shape() : prev{ last } { last = this; } // Skizze Standardkonstruktor
virtual void draw( Frame* ptarget ) /*const*/ = 0; // rein virtuelle Methode
virtual void move( int hor, int ver ) = 0; // rein virtuelle Methode
// etc.
private:
static Shape* last; // Zeiger auf die zuletzt erzeugte Figur (d.h. Listenanfang)
Shape* prev; // Zeiger auf die zuvor erzeugte Figur
// (d.h. die naechste in der Liste)
};

Shape* Shape::last{ nullptr }; // initialisiert den static Member mit dem Nullzeiger
void show_all_shapes( Frame* ); // gibt alle Shape Objekte auf Frame* aus

#endif // SHAPE_H
