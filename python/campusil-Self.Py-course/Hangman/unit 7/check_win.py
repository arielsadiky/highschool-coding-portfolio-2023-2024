def check_win(secret_word, old_letters_guessed):
    """
    checks if all the letters of secret_word are in old_letters_guessed.
    :param secret_word: a word
    :param old_letters_guessed: a list of letters
    :type secret_word: string
    :type old_letters_guessed: list
    :return: if all letters of secret_word are in old_letters_guessed
    :rtype: boolean
    """
    win = True
    for char in secret_word:
        if (char not in old_letters_guessed):
            win = False
    return win
    
    

def main():
    help(check_win )
    secret_word = "mammals"
    old_letters_guessed = ['s', 'p', 'j', 'i', 'm', 'k', 'l', 'y', 'e']
    print(check_win(secret_word, old_letters_guessed))
    print(check_win('yes', old_letters_guessed))

if __name__ == "__main__":
    main()