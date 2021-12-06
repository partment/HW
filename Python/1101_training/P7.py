import sys

setNum = 0
sets = []
realsets = []

for index, line in enumerate(sys.stdin.read().splitlines()):
    if index == 0:
        setNum = int(line)
    else:
        sets.append(list(line))

realsets = [[]*setNum for _ in range(setNum)]

for i in range(setNum):
    for k in range(10):
        if k == 0:

            ascii_ = ord(sets[i][0])
            if ascii_ >= 65 and ascii_ <= 72:
                ascii_ -= 55
            elif ascii_ == 73:
                ascii_ = 34
            elif ascii_ >= 74 and ascii_ <= 78:
                ascii_ -= 56
            elif ascii_ == 79:
                ascii_ = 35
            elif ascii_ >= 80 and ascii_ <= 86:
                ascii_ -= 57
            elif ascii_ == 87:
                ascii_ = 32
            elif ascii_ == 90:
                ascii_ = 33
            else:
                ascii_ -= 58

            realsets[i].append(int(ascii_ / 10))
            realsets[i].append(ascii_ % 10)
        
        else:

            realsets[i].append(int(sets[i][k]))

for i in range(setNum):
    result = 0
    for k in range(11):
        if k == 0 or k == 10:
            result += realsets[i][k] * 1
        else:
            result += realsets[i][k] * (10 - k)
    if result % 10 == 0 and (realsets[i][2] == 1 or realsets[i][2] == 2):
        print("T")
    else:
        print("F")