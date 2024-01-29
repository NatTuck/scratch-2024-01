

ff = open("nums.txt")

sum = 0

for line in ff:
    line = line.rstrip()
    sum = sum + int(line)

print("Sum =", sum)
