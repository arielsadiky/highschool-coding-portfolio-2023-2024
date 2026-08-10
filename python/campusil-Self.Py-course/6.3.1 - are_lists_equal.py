def are_lists_equal(list1, list2):
    """
    checks if lists have the same values in them.
    :param list1: a int and float list
    :param list2: a int and float list
    :type list1: list
    :type list2: list
    :return: if lists have the same values in them
    :rtype: boolean
    """
    if (sorted(list1) == sorted(list2)):
        return True
    else:
        return False

def main():
    help(are_lists_equal)
    print (are_lists_equal([0.6, 1, 2, 3], [3, 2, 0.6, 1]))
    print (are_lists_equal([0.6, 1, 2, 3], [9, 0, 5, 10.5]))

if __name__ == "__main__":
    main()