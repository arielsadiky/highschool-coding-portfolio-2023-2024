def is_valid_input(letter_guessed):
    """
    checks if the letter guessed is a valid guess,
    one English letter.
    :param letter_guessed: a string 
    :type letter_guessed: string
    :return: if the string is a valid guess
    :rtype: boolean
    """
    return ((len(letter_guessed) == 1) and (letter_guessed.isalpha()))

def main():
    help(is_valid_input)
    print (is_valid_input("sdfg$fg"))
    print (is_valid_input("a"))
    print (is_valid_input("ts"))
    print (is_valid_input("$"))
    current_guess  = input("please enter your guess, a letter a-z: ").lower()
    print (is_valid_input(current_guess))

if __name__ == "__main__":
    main()