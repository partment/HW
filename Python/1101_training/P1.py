import sys

sets = []

for line in sys.stdin.read().splitlines():
    sets.append(list(map(int, line.split(' '))))

for i in range(len(sets)):
    result = 0
    result += 24 * sets[i][0]
    result += 14 * sets[i][1]
    result += 6 * sets[i][2]

    print(result)