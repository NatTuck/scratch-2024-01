


import math

class Shape:
    def grassCost(self, pricePerSqFt):
        return self.area() * pricePerSqFt

    def area(self):
        raise Exception("not implemented")


class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius

    # Area in square feet
    def area(self):
        return math.pi * pow(self.radius, 2)
 

class Square(Shape):
    def __init__(self, width):
        self.width = width

    def area(self):
        return self.width * self.width


class Triangle(Shape):
    # Assume a right triangle perpendicular
    # to the X and Y axes.
    def __init__(self, width, height):
        self.width = width
        self.height = height


