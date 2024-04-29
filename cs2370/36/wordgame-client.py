from realtime.connection import Socket
import asyncio
from random import randint
import sys

NAME = "Orange"
URL = "wss://words.homework.quest/socket/websocket?vsn=2.0.0"

VOWELS = set("aeiou")

loop = asyncio.get_event_loop()
channel = None
done = False

words = []
fh = open("words.txt")
while word := fh.readline():
    words.append(word.strip())

def find_matches(pat):
    ys = []
    
    for word in words:
        matches = True
        
        if len(word) != len(pat):
            continue

        for ii in range(0, len(pat)):
            if pat[ii] != word[ii] and not pat[ii] == '-':
                matches = False

        if matches:
             ys.append(word)

    return ys

def letter_frequencies(xs):
    freqs = {}
    
    for word in xs:
        for ch in word:
            if ch in freqs:
                freqs[ch] += 1
            else:
                freqs[ch] = 1

    return freqs

def best_guess(freqs, guesses, default):
    options = set(freqs.keys()) - guesses - VOWELS

    max_score = 0
    max_guess = default

    for ch in options:
        score = freqs[ch]
        if score > max_score:
            max_score = score
            max_guess = ch

    return max_guess

# {"a": 3, "b": 5} + {"a": 4, "c": 7}
#    = {"a": 7, "b": 5, "c": 7 }
def freq_sum(fs1, fs2):
    return fs1


def letters():
    return set("abcdefghijklmnopqrstuvwxyz")


async def on_view(msg):
    global done
    
    print("\nmsg =", msg)
    puzzle = msg['puzzle']
    
    if not "-" in puzzle:
        done = True
        print("Game done.\n")
        return
    
    guesses = set(msg['guesses'])
    options = letters() - guesses
    print("options:", options)

    pats = puzzle.split(' ')

    freq_sum = {}
    for pat in pats:
        xs = find_matches(pat)
        print("pat", xs)
        freqs = letter_frequencies(xs)
        freq_sum = freq_add(freq_sum, freqs)
    guess = best_guess(freq_sum, guesses, list(options)[0])
    print("Guessing:", guess)

    await channel.send("guess", {"ch": guess}, "")

    
async def main():
    global channel

    client = Socket(URL, False, {"name": NAME})

    # connect to the server
    await client.connect()

    # fire and forget the listening routine
    listen_task = asyncio.ensure_future(client.listen())

    # join the channel
    channel = client.set_channel("game:practice" + str(randint(1, 1000)))
    await channel.join()

    channel.on("view", None, on_view)

    # we give it some time to complete
    while not done:
        await asyncio.sleep(1)

    # proper shut down
    listen_task.cancel()

    
if __name__ == '__main__':
    try:
        loop.run_until_complete(main())
    except KeyboardInterrupt:
        loop.stop()
        exit(0)
