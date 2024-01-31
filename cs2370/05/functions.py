
def add2(xx):
    return xx + 2


def square(xx):
    return xx * xx

# square is a "pure" function - it has
# no side effects, it just calculates and returns a value

def sqrt(xx):
    guess = 1
    while square(square(guess) - xx) > 0.01:
        print(guess)
        guess = 0.5 * (guess + xx / guess)
    return round(guess, 1)



def greet(name):
    print("Hello,", name)

# greet has a side effect




def fpeq(xx, yy):
    if xx > yy:
        return xx - yy < 0.001
    else:
        return yy - xx < 0.001

# Design a function convert Farenheight to Celsius
#  Hint: C = (F - 32) * (5/9)

# Convert a temperature in Farenheight to Celsius
# f2c: float -> float
def f2c(temp_f):
    return (temp_f - 32) * (5 / 9)

assert(fpeq(f2c(32.0), 0.0))
assert(fpeq(f2c(212.0), 100.0))

# Design Recipie for a Function
#  - Purpose statement
#  - Type signature
#  - Examples
#  - Stub
#  - Standard pattern for input
#  - Actually write the function body
#  - Asserts


# Given a numeric grade (0-100) and the course
# syllabus, determine if that grade passes the class.



# Determine if a student passes or fails.
# studentPasses: float -> bool
def studentPasses(score):
    return score >= 60

assert(studentPasses(85.0))
assert(not studentPasses(31.0))
assert(studentPasses(60.0))




# Design a function that reverses a string.



# Reverse a string
# rev: string -> string
def rev(st):
    yy = ""
    for ch in st:
        yy = ch + yy
    return yy

assert(rev("hello") == "olleh")
assert(rev("") == "")


# Given two sports teams and their scores, as four
# parameters (t1, s1, t2, s2), return the name of
# the team that won the game.


# Find the winner.
# winner: string, int, string, int -> string
def winner(t1, s1, t2, s2):
    if s1 > s2:
        return t1
    elif s2 > s1:
        return t2
    else:
        return "Tie"

assert(winner("Celtics", 1, "Lakers", 1) == "Tie")
assert(winner("Bruins", 27, "Oilers", 2) == "Bruins")













