def mult_tuple(tuple1, tuple2):
    """
    makes a tuple of all the posible duos from the two param tuples.
    :param tuple1: a tuple
    :param tuple2: a tuple
    :type tuple1: tuple
    :type tuple2: tuple
    :return: if all letters of secret_word are in old_letters_guessed
    :rtype: boolean
    """
    tuple_list = []
    for i in tuple1:
        for j in tuple2:
            tuple_list.append((i, j))
            tuple_list.append((j, i))
    return tuple(tuple_list) 

def main():
    help(mult_tuple)
    first_tuple = (1, 2)
    second_tuple = (4, 5)
    tuple1, tuple2 = (1, 2, 3), (4, 5, 6)
    print(mult_tuple(first_tuple, second_tuple))
    print(mult_tuple(tuple1, tuple2))

if __name__ == "__main__":
    main()