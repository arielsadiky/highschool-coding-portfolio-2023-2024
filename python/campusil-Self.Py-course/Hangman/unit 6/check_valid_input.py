def check_valid_input(letter_guessed, old_letters_guessed):
    """
    checks if the letter guessed is a valid guess,
    one English letter that was'nt guessed alredy.
    :param letter_guessed: a string 
    :param old_letters_guessed: a list of strings 
    :type letter_guessed: string
    :type old_letters_guessed: list
    :return: if the string is a valid guess
    :rtype: boolean
    """
    return ((len(letter_guessed) == 1) and (letter_guessed.isalpha()) and (letter_guessed not in old_letters_guessed))

def main():
    help(check_valid_input)
    old_letters = ['a', 'b', 'c']
    print (check_valid_input("sdfg$fg", old_letters))
    print (check_valid_input("a", old_letters))
    print (check_valid_input("ts", old_letters))
    print (check_valid_input("$", old_letters))
    print (check_valid_input("u", old_letters))
    current_guess  = input("please enter your guess, a letter a-z: ").lower()
    print (check_valid_input(current_guess, old_letters))

if __name__ == "__main__":
    main()