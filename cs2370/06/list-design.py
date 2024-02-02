# Design recipe for a function:
#  - Purpose statement
#  - Type Signature
#  - Examples
#  - Function stub (the def line)
#  - Write down the standard pattern
#  - Write the function body
#  - Test with asserts


# Problem:
# Design a function that prints a square with
# a given interior size using the "+ - |" characters
# as lines and corners.

# Print a square of the given size with ascii art.
# printSquare: int -> None
def printSquare(size):
    print("+" + (" - " * size) + "+")
    for ii in range(0, size):
        print("|" + ("   " * size) + "|")
    print("+" + (" - " * size) + "+")


# Example printed:
#  printSquare(3)
# +---+
# |   |
# |   |
# |   |
# +---+


# Design a function that finds the maximum value in a list

# Find max value in list.
# max_val: [number] -> number
def max_val(xs):
    if xs == []:
        raise Exception("Expected non-empty list")
    
    yy = xs[0]
    for xx in xs:
        if xx > yy:
            yy = xx
    return yy


assert(max_val([1]) == 1)
assert(max_val([10, 13, 16, 9, 42, 89]) == 89)
assert(max_val([-12.4, 13, 2.4, -39]) == 13)
assert(max_val([-11, -2, -8, -5]) == -2)




# Design a function that, given a list of numbers,
# returns the list of numbers each one greater than
# the numbers in the input.



# Get new list by adding 1 to each item in list.
# add1_to_all: [number] -> [number]
def add1_to_all(xs):
    ys = []

    for xx in xs:
        ys.append(xx + 1)

    return ys

assert(add1_to_all([1,2,3]) == [2,3,4])
assert(add1_to_all([3.5,2.5,3.5]) == [4.5,3.5,4.5])
assert(add1_to_all([-3]) == [-2])
assert(add1_to_all([]) == [])


# Design a function that adds one to each item in
# a list in-place.
# add1_to_each: [number] -> None
def add1_to_each(xs):
    for ii in range(0, len(xs)):
        xs[ii] = xs[ii] + 1
















