'''
Bulls and Pigs:

 - The computer generates a random 4 digit sequence.
 - The user repeatedly guesses a 4 digit sequence.
 - After each guess, the computer scores the guess:
   - One bull for each correct digit in the right place.
   - One pig for each digit that's correct but misplaced.
 - When the user guesses entirely correctly (4 bulls) they
   win.
 - Goal: Win with fewest guesses.
'''

# Examples:
#   secret     guess    score
#    1234      3434     2 bulls, 2 pigs
#    1234      4567     0 bulls, 1 pig

import random

# Generate a random sequnce of 4 digits.
# None -> str
def new_secret():
    yy = ""
    for ii in range(0, 4):
        yy += str(random.randint(0, 9)) # 1 digit 
    return yy

# Check if guess is valid
# str -> boolean
def valid_guess(guess):
    return len(guess) == 4 and guess.isdigit()


# Determine the score for a guess.
# str, str -> (int, int)
def score_guess(secret, guess):
    bulls = 0
    pigs = 0


    for ii in range(0, 4):
        print(ii, guess[ii], secret[ii])
        if secret[ii] == guess[ii]:
            bulls += 1
            print("b")
        elif guess[ii] in secret:
            pigs += 1
            print("p")
        
    return (bulls, pigs)

secret = new_secret()

def main():
    guess = ""

    while not guess == secret:
        print("")
        print("Guess a 4 digit number")
        guess = input("> ")
        if valid_guess(guess):
            print("Your guess:", guess)
            print("    secret:", secret)
            (bulls, pigs) = score_guess(secret, guess)
            print(f"{bulls} bulls, {pigs} pigs")
        else:
            print("Bad guess")

    print("You win!")
    

        


if __name__ == '__main__':
    main()
