
import math

def circle_area(radius):
    return math.pi * pow(radius, 2)

def square_area(width):
    return pow(width, 2)


# A mosquito is a tuple (x, y)
mos1 = (100, 200)

# A rectangle is a tuple (width, height)

rect1 = (100, 200)

def rect_area(rect):
    (ww, hh) = rect
    return ww * hh


class Circle:
    def __init__(self, radius):
        self.radius = radius
    
    def area(self):
        return math.pi * pow(self.radius, 2)
 

class Square:
    def __init__(self, width):
        self.width = width

    def area(self):
        return self.width * self.width
    



