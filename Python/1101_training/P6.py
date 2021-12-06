import sys

setNum = 0
sets = []

for index, line in enumerate(sys.stdin.read().splitlines()):
    if index == 0:
        setNum = int(line)
    else:
        sets.append(list(map(int, line.split(' '))))

for i in range(setNum):
    if sets[i][0] == sets[i][1]:
        print("=")
    elif sets[i][0] > sets[i][1]:
        print(">")
    else:
        print("<")