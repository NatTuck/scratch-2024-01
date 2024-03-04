

# Recursive functions:
#  - Rule 1: They can't always call themselves,
#    because then they never finish.

def find_solution():
    find_solution()

# Sum from 0 to an integer >= 0.
# int -> int
def sum_to_xx(xx):
    if xx <= 0:
        # The base case, where we don't
        # need a recursive call.
        return 0
    else:
        # The general case, where we do
        # need a recursive call.
        #
        # This case needs to make progress.
        return xx + sum_to_xx(xx - 1)


# How to figure out a recursive function:
#  - First, find the base case and convince
#    yourself it works.
#  - Then, look at the general case.
#    - We can assume the base case is good.
#    - So we just need to determine that
#      the general case does one more step.


import sys
print(sys.getrecursionlimit())
sys.setrecursionlimit(500_000)




