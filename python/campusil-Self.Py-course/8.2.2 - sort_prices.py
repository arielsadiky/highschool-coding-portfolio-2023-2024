def sort_prices(list_of_tuples):
    """
    makes a list sorted by price
    :param list_of_tuples: list of: (item, price), bouth strings
    :type list_of_tuples: list
    :return: a sorted list by price
    :rtype: list
    """
    return sorted(list_of_tuples, key=get_price, reverse=True)

def get_price(current_tuple):
    """
    gets the price of the item
    :param current_tuple: (item, price), bouth strings
    :type current_tuple: tuple
    :return: the price of the item
    :rtype: floet
    """
    return float(current_tuple[1])
    
def main():
    help(sort_prices)
    help(get_price)
    products = [('milk', '5.5'), ('candy', '2.5'), ('bread', '9.0')]
    print(sort_prices(products))

if __name__ == "__main__":
    main()