
from pathlib import Path

print("current file:", __file__)
print("working directory:", Path.cwd())

#file = open("message.txt", "w")
#file.write("Dear Santa,\n\n")
#file.write("For Christmas, I want a pony.\n")
#file.close()


#file2 = open("message.txt", "a")
#file2.write("No, wait, I want a two ponies.\n")
#file2.close()


lines = 0
file = open("message.txt")
#for line in file:
#    lines += 1
while True:
    line = file.readline()
    print("line:", line)
    if line == "":
        break
file.close()
print(lines)
