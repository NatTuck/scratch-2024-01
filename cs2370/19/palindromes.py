
import gzip


def stripAll0(xs):
    ys = []
    for xx in xs:
        ys.append(xx.rstrip())
    return ys

def rstrip(st):
    return st.rstrip()

def stripAll1(xs):
    return map1(rstrip, xs)

def map1(func, xs):
    ys = []
    for xx in xs:
        ys.append(func(xx))
    return ys

def stripAll(xs):
    return map1(lambda st: st.rstrip(), xs)












def reverse(st):
    yy = ""
    for ch in st:
        yy = ch + yy
    return yy


# Is this a palindrome?
# str -> boolean
def is_palindrome1(st):
    return st == reverse(st)


# Is this a palindrome?
# str -> boolean
def is_palindrome(st):
    if len(st) <= 1:
        return True
    if st[0] != st[-1]:
        return False
    return is_palindrome(st[1:-1])


file = gzip.open("words.txt.gz", "rt")
# words = list(map(lambda st: st.rstrip(), file))
words = [word.rstrip() for word in file]
file.close()

last_letters = {}

for word in words:
    last = word[-1]
    xs = last_letters.get(last, [])
    xs.append(word)
    last_letters[last] = xs


#for w1 in words:
#    for w2 in last_letters[w1[0]]:
#        if is_palindrome(w1 + w2):
#            print(w1 + " " + w2)

rwords = [reverse(word) for word in words]
rwords.sort()

ii = 0
jj = 0

while ii < len(words) and jj < len(rwords):
    w1 = words[ii]
    w2 = reverse(rwords[jj])

    for word in words:
        if is_palindrome(w1 + word + w2):
            print(w1 + ' ' + word + ' ' + w2)

    #if is_palindrome(w1 + w2):
    #    print(w1 + ' ' + w2)
    #   ii += 1
    #    jj += 1
    #    continue

    if words[ii] < rwords[jj]:
        ii += 1
    else:
        jj += 1
    
    


    





