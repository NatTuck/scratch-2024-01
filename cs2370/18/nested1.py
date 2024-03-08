def nested_add1(xx):
    def add1():
        return xx + 1
    return add1()

print(nested_add1(5))
