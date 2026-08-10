def extend_list_x(list_x, list_y):
    """
    extends list x with list y first without
    the operator + or the method extend().
    :param list_x: a list
    :param list_y: a list
    :type list_x: list
    :type list_y: list
    :return: list x extended with list y first
    :rtype: list
    """
    list_x = [*list_y, *list_x]
    return list_x

def main():
    help(extend_list_x)
    print (extend_list_x([0, 1, 2], ['monkey', 2.0, 1]))
    print (extend_list_x([2, 4, 'y', 8], ['a', 'b', 'c', 'd', 'e', 'f']))
    x = [4, 5, 6]
    y = [1, 2, 3]
    print (extend_list_x(x, y))

if __name__ == "__main__":
    main()