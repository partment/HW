import sys

sets = []
four = []
hundred = []
four_hundred = []

for line in sys.stdin.read().splitlines():
    sets.append(list(map(int, line.split(' '))))

for i in range(len(sets)):

    if sets[i][0] % 4 == 0:
        four.append(True)
    else:
        four.append(False)

    if sets[i][0] % 100 == 0:
        hundred.append(True)
    else:
        hundred.append(False)

    if sets[i][0] % 400 == 0:
        four_hundred.append(True)
    else:
        four_hundred.append(False)

    if (four[i] and not hundred[i]) or four_hundred[i]:
        print("a leap year")
    else:
        print("a normal year")