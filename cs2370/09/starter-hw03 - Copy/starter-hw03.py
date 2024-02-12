
import pyglet
import random
import math


BAT_X = 500
MOS_N = 3


def move_mosquito(bug):
    return bug


def bat_caught_mosquito(bat_y, bug):
    (mos_x, _) = bug
    return mos_x > 600


def bat_eat_any_nearby_bugs(bat_y, bugs):
    bug = bugs[0]
    if bat_caught_mosquito(bat_y, bug):
        return bugs[1:4] + bugs[0:1]
    else:
        return bugs[1:4] + bugs[0:1]
    # new_mosquito() makes a new random mosqutio
            
#=========================================================
#
# For hw03, you don't need to change code below here.
#
#=========================================================


# Move bat when arrow key pressed.
# int, str -> int
def move_bat(bat_y, key):
    if key == "up":
        return min(bat_y + 5, 600)
    if key == "down":
        return max(bat_y - 5, 0)

# Make a new random mosquito.
# None -> (int, int)
def new_mosquito():
    xx = random.randint(0, 100)
    yy = random.randint(50, 550)
    return (xx, yy)

    
# The main function for our program.
# None -> None
def main():
    # App state
    bat_y = 300
    bugs = [new_mosquito() for _ii in range(MOS_N)]

    # Internal state
    up_pressed = False
    down_pressed = False

    # App logic
    random.seed()

    window = pyglet.window.Window(width=800, height=600, resizable=False,
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


    bat = pyglet.sprite.Sprite(load_image("bat.png"), x=BAT_X, y=bat_y)
    bat.scale = 0.5

    mss = []
    for ii in range(MOS_N):
        mm = pyglet.sprite.Sprite(load_image("mosquito.png", True),
                                  x=10, y=10 + ii)
        mm.scale = 0.5
        mss.append(mm)

        
    @window.event
    def on_draw():
        window.clear()
        background.draw()
        bat.draw()
        for mm in mss:
            mm.draw()


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
        nonlocal bat_y, bugs, up_pressed, down_pressed

        # Handle moving bat
        if up_pressed:
            bat_y = move_bat(bat_y, "up")

        if down_pressed:
            bat_y = move_bat(bat_y, "down")

        bat.y = bat_y


        # Handle moving mosquitoes
        bugs = bat_eat_any_nearby_bugs(bat_y, bugs)
        
        for ii in range(MOS_N):
            bugs[ii] = move_mosquito(bugs[ii])
            (xx, yy) = bugs[ii]
            mss[ii].update(x=xx, y=yy)

        
    pyglet.clock.schedule_interval(tick, 1 / 30.0)
    pyglet.app.run()


if __name__ == '__main__':
    main()
