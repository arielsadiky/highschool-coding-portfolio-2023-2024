def seven_boom(end_number):
    """
    makes a int list, 0-end_number, 
    and every time the number includes 7 
    or is divideble by 7 ther is the word 'Boom'.
    :param end_number: a full number
    :type end_number: int
    :return: list, 0-end_number, and every time 
    the number includes 7 or is divideble by 7 
    ther is the word 'Boom'.
    :rtype: list
    """
    seven_boom_list = []
    for num in range(end_number):
        if (num % 7 == 0) or ('7' in str(num)):
            seven_boom_list += ['Boom']
        else:
            seven_boom_list += [num]
    return seven_boom_list

def main():
    help(seven_boom )
    print (seven_boom(17))
    print (seven_boom (38))

if __name__ == "__main__":
    main()