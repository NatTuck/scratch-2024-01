
import pyglet
from pyglet.shapes import Rectangle, Triangle
import math
from random import randint


batch = pyglet.graphics.Batch()

black = (0,0,0)
white = (255,255,255)

def outer_tri(bx, by, size):
    s2 = size / 2.0
    return Triangle(bx, by + size,
                    bx - s2, by,
                    bx + s2, by, black, batch=batch)

count = 0

def generate(depth, bx, by, size):
    global count
    
    if depth == 0:
        return []
    else:
        #color = (randint(0,255), randint(0,255), randint(0,255))
        color = (count, count, count * 63 % 256)
        s2 = size / 2.0
        count += 1
        inner = Triangle(bx, by,
                         bx - s2, by + size,
                         bx + s2, by + size, color, batch=batch)
        ys = [inner]
        ys += generate(depth - 1, bx - s2, by, s2)
        ys += generate(depth - 1, bx + s2, by, s2)
        ys += generate(depth - 1, bx, by + size, s2)
        return ys


# The main function for our program.
# None -> None
def main():
    window = pyglet.window.Window(width=800, height=600, resizable=False,
                                  caption="Many Triangles")
    
    background = Rectangle(x = 0, y = 0,
                           width=window.width,
                           height=window.height,
                           color=(255, 255, 255))

    tris = [outer_tri(400, 25, 550)] + (
            generate(0, 400, 25, 550/2))

    print("count =", count + 1)

    @window.event
    def on_draw():
        window.clear()
        background.draw()
        batch.draw()

    @window.event
    def on_key_press(key, _mods):
        pass
            
    @window.event
    def on_key_release(key, _mods):
        pass

    depth = 1
            
    def tick(dt):
        nonlocal tris, depth
        global batch, count

        count = 0
        batch = pyglet.graphics.Batch()
        tris = [outer_tri(400, 25, 550)] + (
                generate(depth, 400, 25, 550/2))
        depth += 1
        print("count", count)
        if (depth > 10):
            depth = 0

        
    pyglet.clock.schedule_interval(tick, 1.0)
    pyglet.app.run()


if __name__ == '__main__':
    main()
