
# Intro to Programming
#  - Writing computer programs
#    - A specific way of telling the computer to do stuff
#  - Computer program:
#    - A set of instructions for the computer to compute.
#    - Computer programs are written in computer programming
#      languages.

# This semester we wrote Python

def skip():
    print("input x")
    x = 10
    while x > 0:
        text = input("> ")
        x = int(text)
        if x % 2 == 0:
            print("x + 4 =", x + 4)

def add2(xx):
    return xx + 2


# Design Recipe (six steps):
#  1. Purpose statement
#  2. Signature
#  3. Write some test cases
#  4. Function stub - just name and parameters
#  5. Standard pattern
#  6. Code it


# Types of Data
#  - Simple types: int, String?, float, boolean
#  - Not so simple types:
#    - built in: list, dict, set, tuple
#    - user defined: class instances / objects




# Insert a number into the correct spot in
# a sorted list.
# [number], number -> [number]
def insert(xs, y):
    le = []
    gt = []
    for x in xs:
        if x <= y:
            le.append(x)
        if x > y:
            gt.append(x)
    return le + [y] + gt

assert([3] == insert([], 3))
assert([1, 3] == insert([3], 1))
assert([1, 2, 3] == insert([1, 3], 2))




# Sort a list of numbers
# [number] -> [number]
def isort(xs):
    ys = []
    for xx in xs:
        ys = insert(ys, xx)
    return ys

assert([] == isort([]))
assert([4] == isort([4]))
assert([2, 3, 4] == isort([4, 2, 3]))
assert([1,2,3,4] == isort([4,2,1,3]))


# {"goat": "baa", "sheep": "baaa"}
# {"goat", "sheep"}



# Vault password screen:
#
# for each position 1..8:
#   - try each letter until you get one
#     that works
# Assume password is worst case: "zzzzzzzz"
# How many guesses: 208
#
# for each letter:
#  - try all that letter
#  - remember any matches
# Now you know the answer, guess it.
# How many guesses: 27







