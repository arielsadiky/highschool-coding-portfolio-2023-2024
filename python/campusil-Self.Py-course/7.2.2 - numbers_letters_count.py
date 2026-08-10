def numbers_letters_count(my_str):
    """
    makes a new list of all the numbers
    in my_list that are bigger then n.
    :param my_list: a list of numbers
    :param n: a number
    :type my_list: list
    :type stop: int/float
    :return: list of all the numbers
    in my_list that are bigger then n
    :rtype: list
    """
    list_of_bigger_then_n = []
    num_of_nums = 0
    for char in my_str:
        if (char.isdigit()):
            num_of_nums += 1
    return [num_of_nums, (len(my_str) - num_of_nums)]

def main():
    help(numbers_letters_count )
    print (numbers_letters_count("Python 3.6.3"))
    print (numbers_letters_count ("ase 4 r 5 6 yukgvm jm 0 o"))

if __name__ == "__main__":
    main()