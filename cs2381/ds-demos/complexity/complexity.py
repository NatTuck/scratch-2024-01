
## After today, 4 weeks to go:
#  - Bonus topic 1
#  - Bonus topic 2
#  - Last week: Redo and Review
#  - Finals week

# Today: Computational Complexity

def fib(x):
    if x <= 1:
        return x

    return fib(x-1) + fib(x-2)

def fibCalls(x):
    if x <= 1:
        return x, 1

    y1, c1 = fibCalls(x-1)
    y2, c2 = fibCalls(x-2)
    return y1 + y2, c1 + c2 + 1

def fib2(x):
    ops = 0
    xs = [0, 1]

    for ii in range(2, x + 1):
        xs.append(xs[ii-1] + xs[ii-2])
        ops += 1

    return xs[x], ops


fibs = {}

def fib3(x):
    if x in fibs:
        return fibs[x], 1
    
    if x <= 1:
        fibs[x] = x
        return x, 1

    y1, c1 = fib3(x-1)
    y2, c2 = fib3(x-2)
    yy =  y1 + y2
    fibs[x] = yy
    return yy, c1 + c2 + 1


def constant(x):
    return 9999

def linear(x):
    return 999 * x

def quadratic(x):
    return 99 * pow(x, 2)

def polynomial(x):
    return 0.5 * pow(x, 3)

def exponential(x):
    return 0.5 * pow(2, x)


def testFib(x):
    (_, ops) = fibCalls(x)
    pol = polynomial(x)
    exp = exponential(x)
    print("fib=", ops, "; poly=", pol, "; exp=", exp)

# The number of operations required by the add3
# function is bounded above by a constant value.
# We can say that add3 is O(1).
def add3(x, y, z):
    return x + y + z, 2 

yy, ops = add3(1,2,3)
assert(ops < constant(3))

