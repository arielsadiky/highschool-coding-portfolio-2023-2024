my_word = input("enter a word/sentence: ").lower().replace(" ", "")
if (my_word != my_word[::-1]):
    print ("NOT")
else:
    print ("OK")
