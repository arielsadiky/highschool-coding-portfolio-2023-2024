def show_hidden_word(secret_word, old_letters_guessed):
    """
    replaces '_' with the corect letter if it was guessed
    :param secret_word: a word
    :param old_letters_guessed: a list of letters
    :type secret_word: string
    :type old_letters_guessed: list
    :return: a string with '_' and letters 
    :rtype: string
    """
    word_reveal = ''
    for char in secret_word:
        if (char in old_letters_guessed):
            word_reveal += char+' '
        else:
            word_reveal += '_ '
    return word_reveal
    
    

def main():
    help(show_hidden_word )
    secret_word = "mammals"
    old_letters_guessed = ['s', 'p', 'j', 'i', 'm', 'k', 'l']
    print(show_hidden_word(secret_word, old_letters_guessed))

if __name__ == "__main__":
    main()