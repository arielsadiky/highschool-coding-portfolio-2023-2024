def print_hangman(num_of_tries):
    """
    print the apropriat hangman fo amount of trise. 
    :param num_of_tries: number of trise faild
    :type num_of_tries: int
    """
    HANGMAN_PHOTOS = {1: "x-------x",
    2: """
x-------x
|
|
|
|
|
    """,
    3: """
x-------x
|       |
|       0
|
|
|
    """,
    4: """
x-------x
|       |
|       0
|       |
|
|
    """,
    5: """
x-------x
|       |
|       0
|      /|\\
|
|
    """,
    6: """
x-------x
|       |
|       0
|      /|\\
|      /
|
    """,
    7: """
x-------x
|       |
|       0
|      /|\\
|      / \\
|
    """}
    if (num_of_tries in HANGMAN_PHOTOS):
        print (HANGMAN_PHOTOS[num_of_tries])

def main():
    help(print_hangman)
    print(print_hangman(1))
    print(print_hangman(2))
    print(print_hangman(3))
    print(print_hangman(4))
    print(print_hangman(5))
    print(print_hangman(6))
    print(print_hangman(7))

if __name__ == "__main__":
    main()