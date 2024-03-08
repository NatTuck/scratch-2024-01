#items1 = 5
#items2 = [12, 8, 5]
items3 = [12, [8, 5], 3, 2]

# Some Mess -> int
def sum_nested(xs):
    sum = 0

    if type(xs) is list:
        for xx in xs:
            sum += sum_nested(xx)
    else:
        sum += xs

    return sum

print(sum_nested(items3))

