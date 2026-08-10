current_guess  = input("please enter your guess, a letter a-z: ").lower()
if (len(current_guess) > 1) and not (current_guess.isalpha()):
    print ("E3")
elif (len(current_guess) > 1):
    print ("E1")
elif (not current_guess.isalpha()):
    print ("E2")
else:
    print(current_guess)