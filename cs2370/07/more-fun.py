

# Insert number into sorted list.
# [number], number -> [number]
def insert_in_order(xs, yy):
    ys = []

    for xx in xs:
        #print("first loop, looking at", xx)
        if xx <= yy:
            #print("insert it")
            ys.append(xx)
        #print("ys is", ys)

    ys.append(yy)

    for xx in xs:
         if xx > yy:
            ys.append(xx)

    return ys

assert(insert_in_order([], 5) == [5])
assert(insert_in_order([5], 7) == [5, 7])
assert(insert_in_order([5], 2) == [2, 5])
assert(insert_in_order([1], 1) == [1, 1])

# Given a list of numbers, return those
# numbers in sorted order (ascending).

# Sort the numbers
# [number] -> [number]
def sort_nums(xs):
    ys = []
    
    for xx in xs:
        ys = insert_in_order(ys, xx)

    return ys

assert(sort_nums([]) == [])
assert(sort_nums([5]) == [5])
assert(sort_nums([21, 2, 8]) == [2, 8, 21])


# [number], number -> None
def insert_in_order2(xs, y):
    ii = 0
    while ii < len(xs):
        if xs[ii] < y:
            ii += 1
        else:
            break
    xs.insert(ii, y)


# Sort the numbers
# [number] -> [number]
def sort_nums2(xs):
    ys = []
    
    for xx in xs:
        insert_in_order2(ys, xx)

    return ys

assert(sort_nums2([]) == [])
assert(sort_nums2([5]) == [5])
assert(sort_nums2([21, 2, 8]) == [2, 8, 21])


