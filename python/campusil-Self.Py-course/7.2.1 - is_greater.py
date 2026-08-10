def is_greater (my_list, n):
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
    for num in my_list:
        if (num > n):
            list_of_bigger_then_n += [num]
    return list_of_bigger_then_n

def main():
    help(is_greater )
    print (is_greater ([1, 30.4657, 25, 60, 27.67, 28], 28))
    print (is_greater ([1, 30, 25, 60.3, 27, 28], 20))
    print (is_greater ([1, 3, 5.2, 16, 27, 28.56], 7))

if __name__ == "__main__":
    main()