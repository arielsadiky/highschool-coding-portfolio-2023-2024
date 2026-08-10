def longest(my_list):
    """
    finds longest string in list of strings.
    :param my_list: a list of strings
    :type my_list: list
    :return: longest string in list
    :rtype: string
    """
    my_list_sorted_by_length = sorted(my_list, key=len)
    return my_list_sorted_by_length[-1]

def main():
    help(longest)
    print (longest(["111", "234", "2000", "goru", "birthday", "09"]))


if __name__ == "__main__":
    main()