def who_is_missing(file_path):
    """
    copy source files content to destination file 
    :param source: a txt file path
    :param destination: a txt file path
    :type source: string
    :type destination: string
    """
    found_num = -1
    with open(file_path, "r") as my_file:
        sorted_num_list = sorted([eval(i) for i in (my_file.read().split(','))])
        for my_num, expected_num in zip(sorted_num_list, range(1, sorted_num_list[-1])):
            #print (str(my_num) + "  " + str(expected_num))
            if (my_num != expected_num) and (found_num == -1):
                found_num = expected_num
    with open(r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\found.txt", "w") as found_file:
        print (str(found_num))
        found_file.write(str(found_num))

def main():
    help(who_is_missing )
    find_me_path = r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\findMe.txt"
    who_is_missing(find_me_path)
    

if __name__ == "__main__":
    main()