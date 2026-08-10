def are_files_equal(file1, file2):
    """
    diturmens if two files have the same contents.
    :param file1: a txt file path
    :param file2: a txt file path
    :type file1: string
    :type file2: string
    :return: if two files have the same contents
    :rtype: boolean
    """
    my_file1 = open(file1, "r")
    my_file2 = open(file2, "r")
    if (my_file1.read() != my_file2.read()):
        my_file1.close()
        my_file2.close()
        return False
    my_file1.close()
    my_file2.close()
    return True

def main():
    help(are_files_equal)
    file1 = r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\new 1.txt"
    file2 = r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\new 2.txt"
    print(are_files_equal(file1, file1))
    print(are_files_equal(file1, file2))

if __name__ == "__main__":
    main()