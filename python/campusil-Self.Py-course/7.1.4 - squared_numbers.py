def squared_numbers (start, stop):
    """
    makes a list of the second power of each 
    full number from start to stop.
    :param start: a int
    :param stop: a int
    :type start: int
    :type stop: int
    :return: list of the second power of each
    full number from start to stop
    :rtype: list
    """
    squared_numbers_list = []
    while (start <= stop):
        squared_numbers_list += [start**2]
        start += 1
    return squared_numbers_list

def main():
    help(squared_numbers )
    print (squared_numbers (3, 8))
    print (squared_numbers (-2, 5))
    print (squared_numbers (11, 15))

if __name__ == "__main__":
    main()