def count_chars(my_str):
    """
    makes a dict contaning the amount 
    of each char in my_str.
    :param my_str: a string
    :type my_str: string
    :return: a dict contaning the amount 
    of each char in my_str.
    :rtype: dict
    """
    amount_of_each_char = {}
    for i in my_str:
        amount_of_each_char[i] = 0
    for j in my_str:
        amount_of_each_char[j] += 1
    del amount_of_each_char[' ']
    return amount_of_each_char

def main():
    help(count_chars)
    print(count_chars('babbi sadiky'))

if __name__ == "__main__":
    main()