original_temperatur = input("Insert the temperature you would like to convert: ").lower().replace(" ", "")
original_temperatur_no_simble = float(original_temperatur[:-1])
if (original_temperatur[-1] == 'c'):
    temperatur_in_f = (original_temperatur_no_simble*9 + 32*5)/5
    print (str(temperatur_in_f) + "F")
else:
    temperatur_in_c = (original_temperatur_no_simble*5 - 160)/9
    print (str(temperatur_in_c) + "C")
