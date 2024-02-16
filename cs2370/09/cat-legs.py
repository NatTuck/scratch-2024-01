
legs = {
    'dog': 4,
    'chicken': 2,
    'cat': 4,
    'spider': 8,
}

legs2 = [
    ('dog', 4),
    ('chicken', 2),
    ('cat', 4),
    ('spider', 8)
]

def get(xs, key):
    for (kk, vv) in xs:
        if kk == key:
            return vv
    raise Exception("key not found")


# Design a function that takes a list of
# integers as input and ouptuts a list
# of how many times the value in each
# position repeats.

# Count repeats in list
# [int] -> [int]
def count_repeats(xs):
    ys = []
    ops = 0
    for x1 in xs:
        count = 0
        for x2 in xs:
            ops += 1
            if x1 == x2:
                count += 1
        ys.append(count)
    print("ops =", ops)
    return ys
        
#assert(count_repeats([1, 1, 2]) == [2, 2, 1])



# Count repeats in list.
# [int] -> [int]
def count_reps(xs):
    ops = 0
    counts = {}
    for xx in xs:
        ops += 1
        seen = counts.get(xx, 0)
        counts[xx] = seen + 1

    ys = []
    for xx in xs:
        ops += 1
        ys.append(counts[xx])

    print("ops =", ops)
    return ys

l1 = [1, 1, 3, 1]
l2 = [1, 2, 3, 4, 5, 6, 1, 2]


# 1.7 Billion Cycles Per Second
# In simplest case, that means
#   1.7 billion operations per second


order = [
    ("sugar", 1, 3.0),
    ("eggs", 1, 0.5),
    ("eggs", 1, 0.5),
    ("flour", 1, 2.0),
    ("vanilla extract", 1, 5.0),
    ("eggs", 2, 0.5),
    ("raisins", 1, 3.0),
    ("eggs", 1, 0.5),
]


# Summary of shopping order
# [(string, int, double)] -> {name: count}
def total_counts(items):
    recipt = {}

    for (name, count, price_each) in items:
        if name in recipt:
            recipt[name] += 1
        else:
            recipt[name] = count

    return recipt










