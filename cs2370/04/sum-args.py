import sys

sum = 0

for arg in sys.argv:
    if arg.isdecimal():
        sum = sum + int(arg)

print("Sum =", sum)

