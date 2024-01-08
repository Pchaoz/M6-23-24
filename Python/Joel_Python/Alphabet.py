cases = int(input())
i = 0

while i < cases:
    phrase = input()
    phrase_strp = phrase.replace(" ", "")

    phraseChar = []
    x = 0

    while x < len(phrase_strp):
        phraseChar.append(phrase_strp[x])
        x = x+1

    phraseChar.sort()
    print(''.join(phraseChar))