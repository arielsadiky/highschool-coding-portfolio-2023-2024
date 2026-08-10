def main():
    """
    diturmens if two files have the same contents.
    :param file1: a txt file path
    :param file2: a txt file path
    :type file1: string
    :type file2: string
    :return: if two files have the same contents
    :rtype: boolean
    """
    my_files_path = input("Enter a file path: ")
    #file = r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\new 1.txt"
    #i believe i can fly i believe i can touch the sky
    #i think about it every night and day spread my wings and fly away
    task = input("Enter a task (sort/ rev/ last): ")
    with open(my_files_path, "r") as my_file:
        if (task == "sort"):
            list_of_all_words = sorted(my_file.read().replace("\n", " ").split(" "))
            for word in list_of_all_words:
                while (list_of_all_words.count(word) > 1):
                    list_of_all_words.remove(word)
            print (list_of_all_words)
        elif(task == "rev"):
            list_of_lines = my_file.read().split("\n")
            for line in list_of_lines:
                print (line[::-1])
        elif(task == "last"):
            num = int(input("Enter a full number: "))
            list_of_lines = my_file.read().split("\n")
            for line in list_of_lines[-num:]:
                print (line)

if __name__ == "__main__":
    main()