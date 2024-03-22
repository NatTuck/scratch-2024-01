
import pyglet
import math
from copy import deepcopy
from random import randint
from math import sqrt

def load_image(file, flip=False):
    image = pyglet.resource.image(file, flip_x=flip)
    image.anchor_x = image.width // 2
    image.anchor_y = image.height // 2
    return image



class Animal:
    flip = False
    
    def __init__(self, x, y):
        self.moveTo(x, y)

    # Animal -> None
    def draw(self):
        image = load_image(self.image, self.flip)
        sprite = pyglet.sprite.Sprite(image, x=self.x, y=self.y)
        sprite.scale = 0.5
        sprite.draw()

    def speak(self):
        print(f"The animal says {self.sound}")

    def moveTo(self, x, y):
        self.x = x
        self.y = y

    def tick(self):
        pass


class Bat(Animal):
    image = "bat.png"
    sound = "Squeak"

    def tick(self):
        self.x = (self.x + randint(-5, 5)) % 800
        self.y = (self.y + randint(-10, 10)) % 600

class Cow(Animal):
    image = "cow.png"
    sound = "Moo"

    def tick(self):
        if self.y > 100:
            self.y -= 5
        else:
            self.x = (self.x + 3) % 800

class Pig(Animal):
    image = "pig.png"
    sound = "Oink"
    flip = True

    def tick(self):
        self.x = (self.x + 5) % 800
        self.y = 300 + 200 * math.sin(self.x / 200.0)


def distance(aa, bb):
    dx = aa['x'] - bb['x']
    dy = aa['y'] - bb['y']
    return sqrt(dx**2 + dy**2)
    

def main():

    # App state
    animals = [Cow(150, 400), Bat(300, 400), Cow(400, 100), Pig(600, 450)]

    # App logic
    window = pyglet.window.Window(width=800, height=600, resizable=False,
                                  caption="Animls")

    # Thanks, Pyglet Sprite example.
    pyglet.resource.path = ['./images']
    pyglet.resource.reindex()

    background = pyglet.shapes.Rectangle(x = 0, y = 0,
                                         width=window.width,
                                         height=window.height,
                                         color=(255, 255, 255))

    
    @window.event
    def on_draw():
        window.clear()
        background.draw()
        for animal in animals:
            animal.draw()  

    @window.event
    def on_mouse_press(xx, yy, _btns, _mods):
        pass
            
    def tick(dt):
        for aa in animals:
            aa.tick()
            
        
    pyglet.clock.schedule_interval(tick, 1 / 30.0)
    pyglet.app.run()


if __name__ == '__main__':
    main()
