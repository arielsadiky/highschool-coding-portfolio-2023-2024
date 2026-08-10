import calendar
date = input("Enter a date(dd/mm/yyyy): ").replace(" ", "")
weekday = calendar.weekday(int(date[6:]), int(date[3:5]), int(date[:2]))
if (weekday == 0):
    print ("Monday")
elif (weekday == 1):
    print ("Tuesday")
elif (weekday == 2):
    print ("Wednesday")
elif (weekday == 3):
    print ("Thursday")
elif (weekday == 4):
    print ("Friday")
elif (weekday == 5):
    print ("Saturday")
elif (weekday == 6):
    print ("Sunday")