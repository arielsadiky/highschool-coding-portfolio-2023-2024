def func(num1, num2):
    """
    Raising num1 to the power of num2
    :parm num1: a number
    :parm num2: a number
    :type num1: float
    :type num2: float
    :return: num1 to the power of num2
    :rtype: float
    """
    return num1 ** num2

def main():
    help(func)
    print (func(6.6, 2.1))

if __name__ == "__main__":
    main()