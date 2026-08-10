inputed_text = input ("Please enter a string: ")
inputed_text = inputed_text[:int(len(inputed_text)/2)].lower() + inputed_text[int(len(inputed_text)/2):].upper()
print (inputed_text)
