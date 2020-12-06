#include <iostream>
#include "frame.h"
#include "line.h"
#include "triangle.h"
using namespace std;

int main()
{




    Frame frame1;
    frame1.reset();
    Triangle t1(20,20,5,6,61);

    t1.draw(&frame1);


    return 0;
}
