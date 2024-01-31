from math import pi

class Circle:
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return pi * pow(self.radius, 2)

class Square:
    def __init__(self, width):
        self.width = width

    def area(self):
        return self.width * self.width

shapes = [Circle(2), Square(4)]

for sh in shapes:
    print(sh.area())
        
    
