#include "frame.h"

Frame::Frame()
{

    reset();

}


void Frame::reset(){

    for( int i{}; i<yMax-1; ++i) {
    for( int j{}; j<xMax-1; ++j ) {
    frame.at(i).at(j)= black ;
    }
    }
}

void Frame::put_point(int i, int j){

    frame.at(i-1).at(j-1)= point;
}


void Frame::put_line(int i, int j){

    frame.at(i-1).at(j-1)= white;
}


void Frame::show() const{

    for( int i{}; i<yMax-1; ++i) {
    for( int j{}; j<xMax-1; ++j ) {
    std::cout << frame.at(i).at(j);
    }
    std::cout << "|" << std::endl;
    }
    std::cout << "_______________________________________________________"<< std::endl;
}

bool Frame::on_frame(int, int) const{
bool frei=NULL;

    for( int i{}; i<yMax-1; ++i) {
    for( int j{}; j<xMax-1; ++j ) {
        if (frame.at(i).at(j)!= black){
            frei = true;
        }
        else {
            frei = false;
        }
    }
    }
    return frei;
}
