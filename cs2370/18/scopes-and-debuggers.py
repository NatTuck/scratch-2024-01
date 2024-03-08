
color = "blue"

def add1(xx):
    # xx and yy are local variables
    # parameters like xx work the same as variables declared
    # like yy, but always are assigned as part of the function
    # call process
    yy = xx + 1
    return yy

print(add1(5))

