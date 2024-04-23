

from pathlib import Path


def search(path):
    for item in path.iterdir():
        if item.is_dir():
            search(item)
        else:
            print(item)

            
search(Path.cwd())
