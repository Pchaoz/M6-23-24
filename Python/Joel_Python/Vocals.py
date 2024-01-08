cases = int(input())
i = 0

while i < cases:
    #DICCIONARIO DE VOCALES
    d1 = dict(a = 0, e = 0, i = 0, o = 0, u = 0)
    x = 0
    phrase = input()
    
    while x < len(phrase):
        if (phrase[x] == "a" or phrase[x] == 'A'):
            d1['a'] = d1['a'] + 1
        elif (phrase[x] == "e" or phrase[x] == 'E'):
            d1['e'] = d1['e'] + 1
        elif (phrase[x] == "i" or phrase[x] == 'I'):
            d1['i'] = d1['i'] + 1
        elif (phrase[x] == "o" or phrase[x] == 'O'):
            d1['o'] = d1['o'] + 1
        elif (phrase[x] == "u" or phrase[x] == 'U'):
            d1['u'] = d1['u'] + 1

        x = x+1

    print("A: " + str(d1['a']) + " E: " + str(d1['e']) + ' I: ' + str(d1['i']) + " O: " + str(d1['o']) +  " U: " + str(d1['u']))