## Design Recipe for a Function
#  1. Purpose statement (what does this do?)
#  2. Signature (data types of arguments and return value)
#  3. Function header ("def ...")
#  4. Examples - which will later turn into tests
#  5. Standard pattern
#  6. Actually write the code for the function body
#  7. Write the tests (asserts)

## Design Recipe for a Function
#  1. Purpose statement (what does this do?)
#  2. Signature (data types of arguments and return value)
#  3. Function header ("def ...")
#  7. Write the tests (asserts)
#  5. Standard pattern
#  6. Actually write the code for the function body
#  7 again. Write more tests

## Purpose statement
##  - One liner
##  - What are we doing?

# The the square root
def sqrt1(xx):
    pass



# Count the number of 1's in the list
# [int] -> int
def count_ones(xs):
    pass

# count_onesA([1, 11, 21, 31]) -> 5
# count_onesA([1, 11, 21, 31]) -> 1

## Signature
# - Specify the types of function arguments
# - Specify return value
# arg, arg, arg, ... -> ret

# Take the square root
# number -> float
def sqrt(xx):
    pass

# sqrt(9) -> 3.0

## Standard Patterns

### Simple Values

# int -> None
def process(xx):
    ... xx ...

# That's the same for any simple value data type
#  simple values: int, float,
#     str if we don't plan to look at the individual charcters

# None -> int
def produce():
    return 5


# int -> int
def funkify(xx):
    yy = ... xx ...
    return yy


### Lists

    
# [[int]] -> None
def process2(ys):
    for xs in ys:
        for xx in xs:
            ... xx ...

# [int] -> None
def process(xs):
    for xx in xs:
        ... xx ...

# None -> [int]
def produce_list():
    ys = []
    ys.append(5)
    return ys

# [int] -> [int]
def process_list(xs):
    ys = []
    for xx in xs:
        ys.append(... xx ...)
    return ys


# Change the elements of the list in place.
# [int] -> None
def mutate_list(xs):
    for ii in range(0, len(xs)):
        xx = xs[ii]
        xs[ii] = ... xx ...


### Dictionaries

# {string: string} -> None
def process(items):
    ... items['squid'] ...


# {string: string} -> None
def processAll(items):
    for key in items.key():
        ... items[key] ...


# None -> {string: string}
def produceDict():
    dict1 = {}
    dict1['color'] = 'blue'
    return dict1


# {string: string} -> {string: int}
def elephantize(info):
    length = {}
    for key in info.key():
        length[key] = ... info[key] ...
    

## Combos

# [str] -> {str: str}
def list_to_dict(xs):
    info = {}
    for xx in xs:
        info[xx] = xx
    return info




# [str], [int] -> [str]
def two_lists(xs, ys):
    zs = []
    for xx in xs:
        zs.append( ... xx )
    for yy in ys:   
        zz.append( ... yy )
    return zs


# [str], [int] -> [str]
def two_lists2(xs, ys):
    zs = []
    for xx in xs:
        for yy in ys:   
            zz.append( ... xx ... yy )
    return zs


## Tests
# - Translate examples into asserts
# - Try to make sure the asserts will run all the code
#   in the function in every combination
# - For complicated functions and complicated programs,
#   we'll need a better testing system than asserts


def zoo():
    if a:
        if b:
            if c:
                pass
            elif d:
                pass
            else:
                pass
        else:
            pass
    else:
        pass

    if e:
        pass
    else:
        pass
        

















    











