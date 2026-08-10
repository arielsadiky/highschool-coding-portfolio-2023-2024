def filter_teens(a = 13, b = 13, c = 13):
    return fix_age(a) + fix_age(b) + fix_age(c)
    
def fix_age(age):
    if ((age >= 13) and (age <15)) or ((age > 16) and (age <= 19)):
        return 0
    else:
        return age


print (filter_teens())
print (filter_teens(1, 2, 3))
print (filter_teens(2, 13, 1))
print (filter_teens(2, 1, 15))
print (filter_teens(34, 14, 2))
