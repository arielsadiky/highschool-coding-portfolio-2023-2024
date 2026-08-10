inputed_text = input ("Please enter a string: ")
firt_letter = inputed_text[0]
inputed_text = inputed_text.replace(firt_letter, 'e')
inputed_text = firt_letter + inputed_text[1:]
print (inputed_text)