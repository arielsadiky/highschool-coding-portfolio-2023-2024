num = input ("Enter three digits (each digit for one pig): ")
num = int(num)
sum = (num%10) + (int(num/10)%10) + (int(num/100)%10)
numEach = (int(sum)/3)
leftOver = sum%3
isDivadeble = (sum%3) == 0

print ("sum ", sum)
print ("numEach ", int(numEach))
print ("leftOver ", leftOver)
print ("isDivadeble ", isDivadeble)