
# [Int] -> Int
# Sum all the even numbers in the list.
def sum_evens(xs):
    yy = 0
    for xx in xs:
        if xx % 2 == 0:
            yy += xx
    return yy

assert(6 == sum_evens([1,2,3,4]))


color = "blue"
rank = 2

class Bar:
    color = "red"
    rank = 6 

    def triple(self):
        return 3 * rank

def foo():
    color = "green"

    class Baz(Bar):
        def double(self):
            return 2 * self.rank

        def grape(self):
            global color

            return "My favorite color is " + color


    return Baz()

aa = foo()
bb = Bar()



#zz = input("hi> ")



def squid(aa, bb):
    if bb < 0:
        # Case A
        return 7
    if aa < bb:
        # Case B
        return squid(aa * 2, bb - 1)
    else:
        # Case C
        return 3 + squid(aa - 1, bb)

#print(squid(4, 3))

class Animal:
    def quack():
        raise Exception("Not a duck")


class Duck(Animal):
    def quack(self):
        print("Quack")


class Dog(Animal):
    def quack(self):
        print("Woof")



for xx in [Duck(), Duck(), Dog()]:
    xx.quack()





