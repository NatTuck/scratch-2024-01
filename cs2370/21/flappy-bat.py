
import pyglet
import random
import math

class Animal:
    def __init__(self):
        self.x = 0
        self.y = 0
        
    def distanceTo(self, other):
        dx = self.x - other.x
        dy = self.y - other.y
        return math.sqrt(pow(dx, 2) + pow(dy, 2))


class Bat(Animal):
    def __init__(self):
        self.x = 200
        self.y = 300
        self.v = 0

    def tick(self):
        self.v -= 0.5
        self.y += self.v

    def flap(self):
        self.v += 15

    def can_reach_bug(self, bug):
        return self.distanceTo(bug) < 40
    

class Bug(Animal):
    def __init__(self):
        self.x = random.randint(700, 1200)
        self.y = random.randint(25, 575)

    def tick(self):
        self.x -= 5

    def is_off_screen(self):
        return self.x < 0

class Boom:
    def __init__(self, x, y, ttl):
        self.x = x
        self.y = y
        self.ttl = ttl

    def tick(self):
        # TODO: decrease TTL
        # When rendering, show
        pass
    

class Wall:
    def __init__(self):
        self.x = 800
        self.gap_top = random.randint(350, 550)
        self.height = random.randint(150, 350)

    def tick(self):
        self.x -= 2

        if self.x < 0:
            self.x = 800
            self.gap_top = random.randint(350, 550)

    def touches(self, other):
        return (abs(other.x - self.x) < 20 and
                ((other.y < self.gap_top - self.height) or
                (other.y > self.gap_top)))

    
# The main function for our program.
# None -> None
def main():
    MOS_N = 5
    
    # App state
    bat = None
    boom = None
    wall = None
    bugs = None
    
    def reset():
        nonlocal bat, wall, bugs

        bat = Bat()
        wall = Wall()
        bugs = [Bug() for _ii in range(MOS_N)]

    reset()

    # App logic
    random.seed()

    window = pyglet.window.Window(width=800, height=600, resizable=False,
                                  caption="Bat Defender 3: Flappy Bat")

    batch = pyglet.graphics.Batch()
    layer0 = pyglet.graphics.Group(order=0)
    layer1 = pyglet.graphics.Group(order=1)
    layer2 = pyglet.graphics.Group(order=2)

    # Thanks, Pyglet Sprite example.
    pyglet.resource.path = ['./images']
    pyglet.resource.reindex()

    background = pyglet.shapes.Rectangle(x = 0, y = 0,
                                         width=window.width,
                                         height=window.height,
                                         color=(255, 255, 255),
                                         batch=batch,group=layer0)

    wall_top = pyglet.shapes.Rectangle(x = 100, y = 0,
                                       width=40,
                                       height=100,
                                       color=(0, 0, 0),
                                       batch=batch, group=layer1)
    wall_bot = pyglet.shapes.Rectangle(x = 100, y = 500,
                                       width=40,
                                       height=100,
                                       color=(0, 0, 0),
                                       batch=batch, group=layer1)

    def load_image(file, flip=False):
        image = pyglet.resource.image(file, flip_x=flip)
        image.anchor_x = image.width // 2
        image.anchor_y = image.height // 2
        return image


    bat_sp = pyglet.sprite.Sprite(load_image("bat.png"),
                                  x=bat.x, y=bat.y,
                                  batch=batch, group=layer2)
    bat_sp.scale = 0.5


    mss = []
    msb = []
    for ii in range(MOS_N):
        mm = pyglet.sprite.Sprite(load_image("mosquito.png", True),
                                  x=bugs[ii].x, y=bugs[ii].y + 10*ii,
                                  batch=batch, group=layer1)
        mm.scale = 0.5
        mss.append(mm)

        mb = pyglet.sprite.Sprite(load_image("boom.png"),
                                  x=-100, y=-100,
                                  batch=batch, group=layer2)
        mb.scale = 0.25
        msb.append(mb)

        
    @window.event
    def on_draw():
        window.clear()
        batch.draw()

    @window.event
    def on_key_press(key, _mods):
        bat.flap()
            
    @window.event
    def on_key_release(key, _mods):
        pass
            
    def tick(dt):
        nonlocal boom
        
        bat.tick()
        bat_sp.update(x=bat.x, y=bat.y)

        wall.tick()

        if wall.touches(bat):
            reset()

        if boom:
            boom_sp.x = boom.x
            boom_sp.y = boom.y

        wall_top.x = wall.x
        wall_top.y = wall.gap_top
        wall_top.height = 600 - wall.gap_top

        wall_bot.x = wall.x
        wall_bot.y = 0
        wall_bot.height = wall.gap_top - wall.height

        for xx in msb:
            xx.tick()
        
        for ii in range(MOS_N):
            if wall.touches(bugs[ii]):
                msb[ii].update(x=bugs[ii].x, y=bugs[ii].y)
                bugs[ii] = Bug()
                
            if bat.can_reach_bug(bugs[ii]) or bugs[ii].is_off_screen():
                bugs[ii] = Bug()
            else:
                bugs[ii].tick()
                mss[ii].update(x=bugs[ii].x, y=bugs[ii].y)

        
    pyglet.clock.schedule_interval(tick, 1 / 30.0)
    pyglet.app.run()


if __name__ == '__main__':
    main()
