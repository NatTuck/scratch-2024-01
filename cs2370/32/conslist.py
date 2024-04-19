# Upcoming: Redo opportunities
#  - Next week: Redo an old lab
#  - Next week: Redo one (or more) old HWs
#    - You can do more than one if you have at least three
#      sub-50 hw grades, not to exceed 1/3rd of your sub-50
#      grades.

# ConsList; Singly-Linked List

# A ConsList is one of:
#  - Empty
#  - Cons(item, ConsList)


class Empty:
    def __repr__(self):
        return "()"

    # ConsList -> boolean
    def isEmpty(self):
        return True

    # ConsList -> Int
    def length(self):
        return 0

    def __eq__(self, other):
        return isinstance(other, Empty)

empty = Empty()


class Cons:
    # first is an item
    # rest is a list of items
    def __init__(self, first, rest):
        self.first = first
        self.rest = rest

    def __repr__(self):
        return f"Cons({self.first}, {self.rest})"

    def __eq__(self, other):
        return (isinstance(other, Cons) and
                self.first == other.first and
                self.rest == other.rest)

    # ConsList -> boolean
    def isEmpty(self):
        return False

    # ConsList -> Int
    def length(self):
        return 1 + self.rest.length()

def ConsList_pattern(xs):
    if xs.isEmpty():
        # We have Empty
        # return some default
        pass
    else:
        # We have a Cons
        pass
        #return xs.first ... ConsList_pattern(xs.rest)


def list(*items):
    if len(items) == 0:
        return empty
    else:
        return Cons(items[0], list(*items[1:]))

# (ConsList of Number) -> Number
# Sum the list of numbers
def sum(xs):
    if xs.isEmpty():
        # We have Empty
        return 0
    else:
        # We have a Cons
        return xs.first + sum(xs.rest)


# (ConsList of Number) -> (ConsList of Number)
# Add 1 to each item in list
def add1_to_all(xs):
    if xs.isEmpty():
        return empty
    else:
        return Cons(xs.first + 1, add1_to_all(xs.rest))    

assert(list(2, 3, 4) == add1_to_all(list(1, 2, 3)))


def reduce(op, default, xs):
    if xs.isEmpty():
        return default
    else:
        # We have a Cons
        return op(xs.first, reduce(op, default, xs.rest))
    

# 0 vs empty


# (ConsList of String) -> (ConsList of Number)
# Get a list of the lengths of the strings in the input
def lengths(xs):
    if xs.isEmpty():
        return empty
    else:
        return Cons(len(xs.first), lengths(xs.rest))    
    
assert(list(1, 4) == lengths(list("a", "bbbb")))


def map(op, xs):
    if xs.isEmpty():
        return empty
    else:
        return Cons(op(xs.first), map(op, xs.rest))    


list1 = list(1, 2, 3)
#assert(6 == sum(list1))


def add3(a, b, c):
    return a + b + c

if __name__ == '__main__':
    print(list1)
    print(sum(list1))
    print(list1.length())
    





