def shift_left(my_list):
    """
    shifts the list to the left
    :param my_list: a list
    :type my_list: list
    :return: the list shifted one spot to the left
    :rtype: list
    """
    return my_list[1:] + my_list[0:1]

def main():
    help(shift_left)
    print (shift_left([0, 1, 2]))
    print (shift_left(['monkey', 2.0, 1]))
    print (shift_left([2, 4, 'y', 8]))
    print (shift_left(['a', 'b', 'c', 'd', 'e', 'f']))

if __name__ == "__main__":
    main()