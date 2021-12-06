import sys

setNum = 0
currentset = 0
pline = 1
eline = 2
adjMatrix = []
pointNum = []


# 讀取資料
for index, line in enumerate(sys.stdin.read().splitlines()):
    if index == 0:
        setNum = int(line)
    elif index == pline:
        adjMatrix.append([[0]*int(line) for _ in range(int(line))])
        pointNum.append(int(line))
    elif index == eline:
        pline += int(line) + 2
        eline += int(line) + 2
    else:
        a, b = map(int, line.split(' '))
        adjMatrix[-1][a][b] = 1
        adjMatrix[-1][b][a] = 1

# 處理資料
for i in range(setNum):

    colorNum = 0
    disabled = []
    color = []

    for i in range(len(adjMatrix[currentset])):
        color.append(0)

    edgeNum = [sum(e) for e in adjMatrix[currentset]]

    for k in range(pointNum[currentset]):

        maxEdgePoint = [i for i in range(pointNum[currentset]) if edgeNum[i] == max(edgeNum) and edgeNum[i] != 0]

        for p in maxEdgePoint:

            if p not in disabled:

                color[p] = colorNum + 1
                disabled.append(p)
                edgeNum[p] = 0
                temp = adjMatrix[currentset][p]

                for i in range(pointNum[currentset]):
                    if i not in disabled:
                        if temp[i] == 0:
                             color[i] = colorNum + 1
                             disabled.append(i)
                             edgeNum[i] = 0
                             temp = [x + y for (x, y) in zip(adjMatrix[currentset][i], temp)]
                colorNum = colorNum + 1

        if 0 not in color:
            break

    if colorNum == 2:
        print("T")
    else:
        print("F")

    currentset += 1