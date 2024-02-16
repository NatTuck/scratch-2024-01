
import pyglet
import random
import math

WINDOW_W = 800

MOS_N = 3

# A Bug is a tuple (int, int, int)
# representing (x, y, speed)

# Are the two bugs too close?
# Bug, Bug -> Boolean
def too_close(b1, b2):
    (x1, base_y1, _) = b1
    (x2, base_y2, _) = b2
    dx = x2 - x1
    dy = wavy_mos_y(base_y2, x2) - wavy_mos_y(base_y1, x1) 
    dist = math.sqrt(pow(dx, 2) + pow(dy, 2))
    return dist < 50


# Did this bug explode?
# Bug, [Bug] -> boolean
def bug_exploded(b1, bugs):
    for b2 in bugs:
        if b1 != b2 and too_close(b1, b2):
            return True
    return False

def move_mosquito(bug):
    (xx, yy, sp) = bug
    xx = (xx + sp) % WINDOW_W
    return (xx, yy, sp)


def wavy_mos_y(base_y, xx):
    return base_y + round(60 * math.sin(xx / 60))

            
#=========================================================
#
# For hw03, you don't need to change code below here.
#
#=========================================================


# Make a new random mosquito.
# None -> (int, int)
def new_mosquito():
    xx = random.randint(0, 100)
    yy = random.randint(50, 550)
    sp = random.randint(2, 6)
    return (xx, yy, sp)

    
# The main function for our program.
# None -> None
def main():
    # App state
    bugs = [new_mosquito() for _ii in range(MOS_N)]

    # Internal state
    up_pressed = False
    down_pressed = False

    # App logic
    random.seed()

    window = pyglet.window.Window(width=WINDOW_W, height=600, resizable=False,
                                  caption="Bat Defender 2: More Bugs")

    # Thanks, Pyglet Sprite example.
    pyglet.resource.path = ['./images']
    pyglet.resource.reindex()

    background = pyglet.shapes.Rectangle(x = 0, y = 0,
                                         width=window.width,
                                         height=window.height,
                                         color=(255, 255, 255))

    def load_image(file, flip=False):
        image = pyglet.resource.image(file, flip_x=flip)
        image.anchor_x = image.width // 2
        image.anchor_y = image.height // 2
        return image

    
    exs = []
    mss = []
    for ii in range(MOS_N):
        mm = pyglet.sprite.Sprite(load_image("mosquito.png", True),
                                  x=10, y=10 + ii)
        mm.scale = 0.5
        mss.append(mm)
        ex = pyglet.sprite.Sprite(load_image("boom.png", True),
                                  x=10, y=10 + ii)
        ex.scale = 0.5
        exs.append(ex)
        
    @window.event
    def on_draw():
        window.clear()
        background.draw()
        for mm in mss:
            mm.draw()
        for ex in exs:
            ex.draw()


    @window.event
    def on_key_press(key, _mods):
        nonlocal up_pressed, down_pressed

        if key == pyglet.window.key.UP:
            up_pressed = True
        if key == pyglet.window.key.DOWN:
            down_pressed = True

            
    @window.event
    def on_key_release(key, _mods):
        nonlocal up_pressed, down_pressed

        if key == pyglet.window.key.UP:
            up_pressed = False
        if key == pyglet.window.key.DOWN:
            down_pressed = False

            
    def tick(dt):
        nonlocal bugs, up_pressed, down_pressed
       
        for ii in range(MOS_N):
            bugs[ii] = move_mosquito(bugs[ii])
            (xx, base_y, _) = bugs[ii]
            if bug_exploded(bugs[ii], bugs):
                exs[ii].update(x=xx, y=wavy_mos_y(base_y, xx))
            else:
                mss[ii].update(x=xx, y=wavy_mos_y(base_y, xx))

        
    pyglet.clock.schedule_interval(tick, 1 / 30.0)
    pyglet.app.run()


if __name__ == '__main__':
    main()
