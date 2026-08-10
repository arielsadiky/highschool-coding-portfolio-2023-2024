def choose_word(file_path, index):
    """
    counts amount of non reppiting words and choses word in index position.
    :param file_path: a txt file path
    :param index: a number
    :type file_path: string
    :type index: int
    :return: ampunt of words and word in index position
    :rtype: tuple
    """
    with open(file_path, "r") as words_file:
        list_of_words = words_file.read().split(" ")
    while(index > len(list_of_words)):
        index = index - len(list_of_words)
    my_word = list_of_words[index-1]
    list_of_words = list(set(list_of_words))
    return (len(list_of_words), my_word)

def main():
    help(choose_word )
    file_path = r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\Hangman\unit 9\words.txt"
    
    print(choose_word(file_path, 60))
    

if __name__ == "__main__":
    main()