from pathlib import Path

def count(path):
    if path.is_dir():
        print(".")
        yy = 0
        for item in path.iterdir():
            try:
                yy += 1 + count(item)
            except:
                pass
        return yy
    else:
        return 1


root = Path("C:\\")
print(count(root))
