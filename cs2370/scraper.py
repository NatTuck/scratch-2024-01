import requests
import bs4
import re

#resp = requests.get("http://homework.quest")
#tree = bs4.BeautifulSoup(resp.text, 'html.parser')

#for item in tree.select('main li a'):
#    text = str(item.contents[0])
#    if text.startswith('CS'):
#        print(f"{text}")

resp = requests.get("https://en.wikipedia.org/wiki/List_of_Pok%C3%A9mon")
tree = bs4.BeautifulSoup(resp.text, 'html.parser')

for item in tree.select('table.wikitable th a'):
    text = str(item.contents[0])
    if text.startswith("Generation"):
        print(str(item))


def foo():
    xs = []
    ready = False
    for item in tree.select('table.wikitable td a'):
        if item.contents and len(item.contents) > 0:
            text = str(item.contents[0])
            if text == 'Bulbasaur':
                ready = True
            if ready and re.match(r'^[A-Z]', text):
                xs.append(text)




