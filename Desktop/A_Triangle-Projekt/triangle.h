#ifndef TRIANGLE_H
#define TRIANGLE_H

#include "shape.h"

class Triangle : public Shape {
public:
Triangle() = delete; // kein Standarddreieck
Triangle( int p1_x, int p1_y, int p2_x, int p2_y, int p3_x, int p3_y ); // Skizze Konstruktor
Triangle( int hor, int ver, int len1, int len2, int len3 );
void draw( Frame* ); // rein virtuelles shape::draw() ueberschreiben
void move( int h, int v ); // rein virtuelles shape::move() ueberschreiben
bool test( int p1_x, int p1_y, int p2_x, int p2_y, int p3_x, int p3_y );
bool test( int hor, int ver, int len1, int len2, int len3 );
private:
int p1_x, p1_y, p2_x, p2_y, p3_x, p3_y = NULL;
int hor, ver, len1, len2, len3 = NULL;
};

Triangle::Triangle( int p1_x, int p1_y, int p2_x, int p2_y, int p3_x, int p3_y ) // Skizze Konstuktordefinition
: p1_x{p1_x}, p1_y{p1_y}, p2_x{p2_x}, p2_y{p2_y}, p3_x{p3_x}, p3_y{p3_y} { }

Triangle::Triangle( int hor, int ver, int len1, int len2, int len3 )
: hor{hor}, ver{ver}, len1{len1}, len2{len2}, len3{len3}{ }

void Triangle::move( int h, int v ) { // Def. der triangle::move() Methode
p1_x+=h ; p1_y+=v ; p2_x+=h ; p2_y+=v ; p3_x+=h ; p3_y+=v ;
}

bool Triangle::test(int p1_x, int p1_y, int p2_x, int p2_y, int p3_x, int p3_y){

    bool machbar = true;

        if(p1_x==p2_x==p3_x){//grade auf der x achse
           machbar = false;
        }//if p1x
        else if (p1_y==p2_y==p3_y) {//grade auf der y achse
            machbar = false;
        }//if p1y
        else if (p1_x==p1_y&&p2_x==p2_y&&p3_x==p3_y) {//lineare grade
            machbar = false;
        }
        else {
            machbar = true;
        }

    return machbar;

}

bool Triangle::test(int hor, int ver, int len1, int len2, int len3){

    bool machbar = true;

    if((len1*len1)+(len2*len2)!=len3){
        machbar=false;
    }
    else {
        machbar = true;
    }

    return machbar;
}











void Triangle::draw(Frame * frame){



    if( p1_x, p1_y, p2_x, p2_y, p3_x, p3_y != NULL){
        if(test(p1_x,  p1_y,  p2_x,  p2_y,  p3_x, p3_y)==true){
            frame->put_point(p1_x, p1_y);
            frame->put_point(p2_x, p2_y);
            frame->put_point(p3_x, p3_y);
        }//test true
        else {
            std::cout<<"Werte ergeben kein dreieck!! " << std::endl;
        }

    }//ifp1x.....
    else {
        if(test(hor,  ver,  len1,  len2,  len3)==true){

            int punkt1, punkt2;

            punkt1 = ver + len1;
            punkt2 = hor + len2;

            frame->put_point(hor, ver);
            frame->put_point(hor, punkt1);
            frame->put_point(punkt2, ver);



        }
        else {
           std::cout<<"Werte ergeben kein dreieck!! " << std::endl;
        }

    }//else hor......


frame->show();//wieder fürs ende mann kennt ihn

}//draw












#endif // TRIANGLE_H
