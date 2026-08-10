def arrow(my_str, max_num):
    """
    prints a str arrow
    :param my_str: a one charecter string
    :param max_num: a full number
    :type my_str: string
    :type max_num: int
    """
    for num1 in range(1, max_num):
        print (my_str*num1)
    for num2 in range(max_num, 0, -1):
        print (my_str*num2)
    

def main():
    help(arrow )
    arrow("*", 5)
    arrow("*", 8)

if __name__ == "__main__":
    main()