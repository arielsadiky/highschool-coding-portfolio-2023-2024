def distance(num1, num2, num3):
    if (abs(num2 - num1) < 2) and ((abs(num3 - num2) > 1 ) and (abs(num3 - num1) > 1 )):
        return True
    elif (abs(num3 - num1) < 2) and ((abs(num2 - num3) > 1 ) and (abs(num2 - num1) > 1 )):
        return True
    else:
        return False

print (distance(1, 2, 10))
print (distance(4, 5, 3))
print (distance(7, 5, 2))
print (distance(4, 9, 3))