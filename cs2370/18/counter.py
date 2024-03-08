
def make_counter():
    count = 0

    def counter():
        nonlocal count

        count = count + 1
        return count

    return counter

aa = make_counter()
print(aa())
print(aa())
bb = make_counter()
print(bb())
print(aa())
