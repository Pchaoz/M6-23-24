finish = False

while finish == False:
    phrase = input()

    if (phrase == "FIN"):
        finish = True
    else:
        abrir = 0
        cerrar = 0

        i = 0
        while i < len(phrase):
            if (phrase[i] == "!"):
                cerrar = cerrar + 1
            elif (phrase[i] == "¡"):
                abrir = abrir + 1

            i = i+1

        if (abrir == cerrar):
            print("SI")
        else:
            print("NO")