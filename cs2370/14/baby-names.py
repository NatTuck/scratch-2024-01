
file = open("baby-names-2002.txt")

counts = {}

def add_count(name, count):
    xx = counts.get(name[0], 0)
    counts[name[0]] = xx + count

for line in file:
    (rank, mn, mc, fn, fc) = line.rstrip().split()
    add_count(mn, int(mc.replace(",", "")))
    add_count(fn, int(fc.replace(",", "")))

letters = list(counts.keys())
letters.sort()

max_count = 0

for letter in letters:
    if counts[letter] > max_count:
        max_count = counts[letter]

# print("max count:", max_count)

for letter in letters:
    pct = counts[letter] / max_count
    bar_size = int(50 * pct)
    print(letter, "=" * bar_size)
