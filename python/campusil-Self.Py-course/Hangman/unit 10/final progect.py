import os.path


def choose_word(index, file_path=r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\Hangman\unit 9\words.txt"):
    """
    choses word from file in index position.
    :param index: a number
    :param file_path: a txt file path
    :type index: int
    :type file_path: string
    :return: word in index position
    :rtype: string
    """
    with open(file_path, "r") as words_file:
        list_of_words = words_file.read().split(" ")
    while (index > len(list_of_words)):
        index = index - len(list_of_words)
    return (list_of_words[index - 1])


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
            word_reveal += char + ' '
        else:
            word_reveal += '_ '
    return word_reveal


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


def try_update_old_letter_guessed(letter_guessed, old_letters_guessed):
    """
    if the letter guessed is a valid guess,
    adds it to the old_letters_guessed list,
    if not remids the player the letters alredy guessed.
    :param letter_guessed: a string 
    :param old_letters_guessed: a list of strings 
    :type letter_guessed: string
    :type old_letters_guessed: list
    :return: if the string was added to list 
    :rtype: boolean
    """
    if (check_valid_input(letter_guessed, old_letters_guessed)):
        old_letters_guessed += letter_guessed
        return True
    else:
        print('X')
        print(" -> ".join(sorted(old_letters_guessed)))
        return False


def print_hangman(num_of_tries):  ###
    """
    print the apropriat hangman fo amount of trise. 
    :param num_of_tries: number of trise faild
    :type num_of_tries: int
    """
    HANGMAN_PHOTOS = {0: "x-------x",
                      1: """
x-------x
|
|
|
|
|
    """,
                      2: """
x-------x
|       |
|       0
|
|
|
    """,
                      3: """
x-------x
|       |
|       0
|       |
|
|
    """,
                      4: """
x-------x
|       |
|       0
|      /|\\
|
|
    """,
                      5: """
x-------x
|       |
|       0
|      /|\\
|      /
|
    """,
                      6: """
x-------x
|       |
|       0
|      /|\\
|      / \\
|
    """}
    if (num_of_tries in HANGMAN_PHOTOS):
        print(HANGMAN_PHOTOS[num_of_tries])


def opening_screen(MAX_TRIES):
    """
    prints the opening screen
    """
    print("""Welcome to the game Hangman
  _    _                    
 | |  | |                                        
 | |  | |                                        
 | |__| | __ _ _ __   __ _ _ __ ___   __ _ _ __  
 |  __  |/ _` | '_ \ / _` | '_ ` _ \ / _` | '_ \ 
 | |  | | (_| | | | | (_| | | | | | | (_| | | | |
 |_|  |_|\__,_|_| |_|\__, |_| |_| |_|\__,_|_| |_|
                      __/ |      
                     |___/	
                     """)

    print("Max trise in this game: " + str(MAX_TRIES))


def word_genarator():
    """
    gets information for the function choose_word
    :return: word genarated
    :rtype: string
    """
    print("choosing a word for the game...")
    index = int(input('Enter the index of your choice: '))
    file_path = ""
    while (file_path != "my") and (file_path != "default"):
        file_path = input('Do you want to choose a word from your file (my) or from the default file (default): ')
    if (file_path == "my"):
        file_path = input('Enter your file path: ')
        while (not os.path.isfile(file_path)):
            file_path = input('File dose  not exsist. Enter your file path: ')
        secret_word = choose_word(index, file_path)
    else:
        secret_word = choose_word(index)
    print("\nword was chosen, lets start!\n")
    return secret_word


def main():
    MAX_TRIES = 6
    num_of_tries = 0
    old_letters_guessed = []
    win = False
    letter_guessed = ""
    valid_guess = False
    opening_screen(MAX_TRIES)
    secret_word = word_genarator()
    print_hangman(num_of_tries)
    print(show_hidden_word(secret_word, old_letters_guessed) + "\n")
    while (not win) and (num_of_tries < MAX_TRIES):
        while (not valid_guess):
            letter_guessed = input("Guess a letter: ").lower()
            valid_guess = try_update_old_letter_guessed(letter_guessed, old_letters_guessed)
        if (letter_guessed not in secret_word):
            num_of_tries += 1
            print_hangman(num_of_tries)
        print(show_hidden_word(secret_word, old_letters_guessed) + "\n")
        valid_guess = False
        win = check_win(secret_word, old_letters_guessed)
    if (check_win(secret_word, old_letters_guessed)):
        print("WIN!!!")
    else:
        print("LOSE!!!")


if __name__ == "__main__":
    main()
