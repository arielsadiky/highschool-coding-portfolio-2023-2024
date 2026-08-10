def grocery_list_managment(grocery_str):
    """
    makes a list from the param string and
    dous actions based on the users chose.
        1: print list
        2: amount of items in list
        3: if item is in list
        4: how meny times a item appears on the list
        5: removes item from list
        6: adds item to list
        7: list of elegal itams
        8: removes all doubles in list
        9: exit
    :param grocery_str: a string of items seporated by ','
    :type stop: string
    """
    grocery_list = grocery_str.split(',')
    stay = True
    users_num = 0
    while stay:
        users_num = input("Please enter a number, 1-9: ")
        if (users_num == '1'):
            print (grocery_list)
        elif (users_num == '2'):
            print ("ther are "+ str(len(grocery_list)) + " items in the grocery list")
        elif (users_num == '3'):
            users_item = input("Please enter a item: ")
            print (users_item + " is in the grocery list: " + str(users_item in grocery_list))
        elif (users_num == '4'):
            users_item = input("Please enter a item: ")
            print (users_item + " appears " + str(grocery_list.count(users_item)) + " times in the grocery list")
        elif (users_num == '5'):
            remove_from_grocery_list(grocery_list)
        elif (users_num == '6'):
            grocery_list.append(input("Please enter the item you want to add: "))
        elif (users_num == '7'):
            elegal_itams = []
            for item in grocery_list:
                if (len(item) < 3):
                    elegal_itams.append(item)
            print (elegal_itams)
        elif (users_num == '8'):
            grocery_list = list(set(grocery_list))
        elif (users_num == '9'):
            stay = False
            
def remove_from_grocery_list(grocery_list):
    """
    removes the item the user inputs from the list, 
    only the first apirences or all of them dipends 
    on thee users chose.
    :param my_list: a list of strings
    :type my_list: string
    """
    users_item = input("Please enter a item you\
 want to remove from the grocery list: ")
    all_or_one = ''
    while (all_or_one != 'all') and (all_or_one != 'one'):
        all_or_one = input("Do you want to remove all apirences of the\
 item ('all') or only the first one ('one'): ").lower().replace(" ", "")
    if (all_or_one == 'one'):
        grocery_list.remove(users_item)
    while (users_item in grocery_list) and (all_or_one == 'all'):
        grocery_list.remove(users_item)

def main():
    help(grocery_list_managment)
    grocery_list_managment("Milk,Cottage,Tomatoes,Tost,56,Saled,Saled,Saled,Milk")

if __name__ == "__main__":
    main()