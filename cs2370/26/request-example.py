import requests
import bs4
import re

resp = requests.get("https://nhlottery.com/Winning-Numbers")

tree = bs4.BeautifulSoup(resp.text, 'html.parser')

tiles = tree.select('.draw-game-tile')

def get_game_name(xs):
    for cl in xs:
        if match := re.search(r'--(.+)', cl):
            return match[1].capitalize()
    return "Unknown"

winners = {}

for tile in tiles:
    name = get_game_name(tile['class'])

    winning_numbers = tile.select('.ball__number')
    ws = []
    for num in winning_numbers:
        try:
            ws.append(int(num.string))
        except:
            pass

    winners[name] = ws

