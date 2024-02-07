
import math

# We are going to represent a sheep as a pair
# (a tuple of length 2) of (String, String)
# containing the name and color of the sheep.

sheep = [
    ("Alice", "green"),
    ("Bob", "pink"),
    ("Carol", "pink"),
    ("Dave", "purple"),
    ("Erin", "green"),
    ("Frank", "black"),
]

# Design a function that counts the pink
# sheep in a list.

# Count pink sheep.
# [(string, string)] -> int
def count_pink_sheep(xs):
    count = 0

    for sh in xs:
        (name, color) = sh
        if color == "pink":
            count += 1
        
    return count



# Given a list of integers and an integer x, determine
# how many times x appears on the list.

# Count how many of an integer there are in a list.
# [int], int -> int
def count_occurances(xs, yy):
    occurances = 0

    for xx in xs:
        if xx == yy:
            occurances += 1

    return occurances

assert(count_occurances([17, 38, 24, 17, 6], 17) == 2)
assert(count_occurances([8, 9, 10], 11) == 0)
assert(count_occurances([1, 1, 2, 2], 1) == 2)
assert(count_occurances([], 7) == 0)


# Given a list of integers, produce a list showing the
# number of times the item in each position occurs in
# the whole list.

# Count how many times each number is repeated in a list.
# [int] -> [int]
def count_repeats(xs):
    ys = []

    for xx in xs:
        ys.append(count_occurances(xs, xx))

    return ys

assert(count_repeats([]) == [])
assert(count_repeats([3]) == [1])
assert(count_repeats([1, 1, 2, 1, 3, 3]) ==
       [3, 3, 1, 3, 2, 2])


# Design a function that returns a list of the
# first n prime numbers.

# Is this number prime?
# int -> boolean
def is_prime(xx):
    for ii in range(2, 1 + int(math.sqrt(xx))):
        if xx % ii == 0:
            return False
    return True


# List first n primes.
# int -> [int]
def list_primes(n):
    ys = []
    ii = 2

    while len(ys) < n:
        if is_prime(ii):
            ys.append(ii)
        ii = ii + 1

    return ys

#assert(list_primes(0) == [])
#assert(list_primes(1) == [2])
#assert(list_primes(2) == [2, 3])


def get_prime(xx):
    return list_primes(xx)[-1]


