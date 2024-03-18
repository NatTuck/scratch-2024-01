
import pyglet
import random
import math

def distance(aa, bb):
    dx = aa.x - bb.x
    dy = aa.y - bb.y
    return math.sqrt(pow(dx, 2) + pow(dy, 2))


class Bat:
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
        return distance(self, bug) < 40
    

class Bug:
    def __init__(self):
        self.x = random.randint(700, 1200)
        self.y = random.randint(25, 575)

    def tick(self):
        self.x -= 5

    def is_off_screen(self):
        return self.x < 0


class Wall:
    def __init__(self):
        self.x = 800
        self.gap_top = random.randint(500, 700)
        self.height = 300

    def tick(self):
        self.x -= 2

        if self.x < 0:
            self.x = 800


# The main function for our program.
# None -> None
def main():
    MOS_N = 5
    
    # App state
    bat = Bat()
    wall = Wall()
    bugs = [Bug() for _ii in range(MOS_N)]

    # App logic
    random.seed()

    window = pyglet.window.Window(width=800, height=600, resizable=False,
                                  caption="Bat Defender 3: Flappy Bat")

    # Thanks, Pyglet Sprite example.
    pyglet.resource.path = ['./images']
    pyglet.resource.reindex()

    background = pyglet.shapes.Rectangle(x = 0, y = 0,
                                         width=window.width,
                                         height=window.height,
                                         color=(255, 255, 255))

    wall_top = pyglet.shapes.Rectangle(x = 100, y = 0,
                                       width=40,
                                       height=100,
                                       color=(0, 0, 0))
    wall_bot = pyglet.shapes.Rectangle(x = 100, y = 500,
                                       width=40,
                                       height=100,
                                       color=(0, 0, 0))

    def load_image(file, flip=False):
        image = pyglet.resource.image(file, flip_x=flip)
        image.anchor_x = image.width // 2
        image.anchor_y = image.height // 2
        return image


    bat_sp = pyglet.sprite.Sprite(load_image("bat.png"),
                                  x=bat.x, y=bat.y)
    bat_sp.scale = 0.5

    mss = []
    for ii in range(MOS_N):
        mm = pyglet.sprite.Sprite(load_image("mosquito.png", True),
                                  x=bugs[ii].x, y=bugs[ii].y + 10*ii)
        mm.scale = 0.5
        mss.append(mm)

        
    @window.event
    def on_draw():
        window.clear()
        background.draw()
        wall_top.draw()
        wall_bot.draw()
        bat_sp.draw()
        for mm in mss:
            mm.draw()


    @window.event
    def on_key_press(key, _mods):
        bat.flap()
            
    @window.event
    def on_key_release(key, _mods):
        pass
            
    def tick(dt):
        # Handle moving mosquitoes
        #bugs = bat_eat_any_nearby_bugs(bat_y, bugs)

        bat.tick()
        bat_sp.update(x=bat.x, y=bat.y)

        wall.tick()
        wall_top.x=wall.x
        wall_top.y=wall.gap_top
        wall_top.heiight=600-wall.gap_top
        print("x", wall_top.x)
        
        #wall_bot.update(x=wall.x, y=0, height=wall.gap_top-wall.height)
        
        for ii in range(MOS_N):
            if bat.can_reach_bug(bugs[ii]) or bugs[ii].is_off_screen():
                bugs[ii] = Bug()
            else:
                bugs[ii].tick()
                mss[ii].update(x=bugs[ii].x, y=bugs[ii].y)

        
    pyglet.clock.schedule_interval(tick, 1 / 30.0)
    pyglet.app.run()


if __name__ == '__main__':
    main()
