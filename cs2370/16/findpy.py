
from pathlib import Path

wd = Path.cwd()
print("Current directory is", wd)
print("")
print("Files ending in .py:")
print("")

def search(path):
    # Base case:
    #   A directory containing no other directories.
    #
    # General case:
    #   A directory containin another directory.
    #
    # Assumption:
    #   You can't infinitely nest directories
    #   on a computer.
    for item in path.iterdir():
        if str(item).endswith(".py"):
            print(item)
        if item.is_dir():
            search(item)

#search(wd)

