from datetime import date

def main():
    """
    does actions based on the users chose:
        1: print Mariahs last name
        2: print number of Mariahs birth month
        3: print amout of Mariahs hobbies
        4: print Mariahs last hobbe
        5: add cooking to hobbe list
        6: print Mariahs birth date at tuple
        7: print Mariahs age
        8: exit
    """
    mariahs_life = {"first_name": "Mariah", "last_name": "Carey", "birth_date": "27.03.1970", "hobbies": ["Singing", "Composing", "Acting"]}
    stay = True
    while stay:
        users_num = input("Please enter a number, 1-8: ")
        if (users_num == '1'):
            print ("Mariahs last name is %s" %mariahs_life["last_name"])
        elif (users_num == '2'):
            print ("The number of Mariahs birth month is %s" % mariahs_life["birth_date"][3:5])
        elif (users_num == '3'):
            print ("Mariah has %d hobbies" % len(mariahs_life["hobbies"]))
        elif (users_num == '4'):
            print ("One of Mariahs hobbies is %s" % mariahs_life["hobbies"][-1])
        elif (users_num == '5'):
            mariahs_life["hobbies"].append("Cooking")
        elif (users_num == '6'):
            print (tuple(mariahs_life["birth_date"].split('.')))
        elif (users_num == '7'):
            today = date.today()
            age = today.year - int(mariahs_life["birth_date"][-4:]) - ((today.month, today.day) < (int(mariahs_life["birth_date"][3:5]), int(mariahs_life["birth_date"][:2])))
            print ("Mariah is %d years old" % age)
        elif (users_num == '8'):
            stay = False

if __name__ == "__main__":
    main()
   

