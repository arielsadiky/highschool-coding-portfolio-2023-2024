def try_update_letter_guessed (letter_guessed, old_letters_guessed):
    """
    if the letter guessed is a valid guess,
    one English letter that was'nt guessed alredy,
    adds it to the old_letters_guessed list,
    if not remids the player the letters alredy guessed.
    :param letter_guessed: a string 
    :param old_letters_guessed: a list of strings 
    :type letter_guessed: string
    :type old_letters_guessed: list
    :return: if the string was added to list 
    :rtype: boolean
    """
    if ((len(letter_guessed) == 1) and (letter_guessed.isalpha()) and (letter_guessed.lower() not in old_letters_guessed)):
        old_letters_guessed += letter_guessed
        return True
    else:
        print('X')
        print(" -> ".join(sorted(old_letters_guessed)))
        return False


def main():
    help(try_update_letter_guessed)
    old_letters = ['a', 'p', 'c', 'f']
    print (try_update_letter_guessed('A', old_letters))
    print (try_update_letter_guessed('s', old_letters))
    print (try_update_letter_guessed('$', old_letters))
    print (try_update_letter_guessed('d', old_letters))
    print (try_update_letter_guessed("u", old_letters))
    current_guess  = input("please enter your guess, a letter a-z: ").lower()
    print (try_update_letter_guessed(current_guess, old_letters))
    print (old_letters)

if __name__ == "__main__":
    main()