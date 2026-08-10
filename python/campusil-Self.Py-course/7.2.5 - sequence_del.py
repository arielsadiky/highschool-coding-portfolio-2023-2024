def sequence_del(my_str):
    """
    makes a new list of all the numbers
    in my_list that are bigger then n.
    :param my_list: a list of numbers
    :type stop: int/float
    :return: list of all the numbers
    in my_list that are bigger then n
    :rtype: string
    """
    new_str = my_str[0]
    for char in my_str:
        if (char == new_str[-1]):
            continue
        new_str += char
    return new_str

def main():
    help(sequence_del )
    print (sequence_del("ppyyyyythhhhhooonnnnn"))
    print (sequence_del ("SSSSsssshhhh"))
    print (sequence_del ("Heeyyy   yyouuuu!!!"))

if __name__ == "__main__":
    main()