def format_list(my_list):
    """
    makes a string of only the even slots of
    a list separeted by ', ' and an 'and' at the end.
    :param my_list: a even numberd string list
    :type my_list: list
    :return: a string of the even slots of a list 
    separeted by ', ' and an 'and' at the end.
    :rtype: string
    """
    list_of_even = my_list[::2]
    str_of_evens = ", ".join(list_of_even[:-1])
    return str_of_evens + ' and ' + list_of_even[-1]

def main():
    help(format_list)
    print (format_list(["hydrogen", "helium", "lithium", "beryllium", "boron", "magnesium"]))
    print (format_list(['monkey', 'asdfghj', 'asdfghjk', 'ertyujn']))
    print (format_list(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']))

if __name__ == "__main__":
    main()