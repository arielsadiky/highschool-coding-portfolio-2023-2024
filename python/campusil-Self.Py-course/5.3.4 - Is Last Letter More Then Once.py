def last_early(my_str):
    my_str = my_str.lower()
    if (my_str[:-1].find(my_str[-1]) == -1):
        return False
    else:
        return True

print (last_early("happy birthday"))
print (last_early("best of luck"))
print (last_early("Wow"))
print (last_early("X"))
print (last_early("Never Again"))
print (last_early("awed DhnEy"))
