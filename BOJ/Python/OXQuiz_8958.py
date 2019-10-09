n = int(input())
oxlist = []

for i in range(0, n, 1):
    point = 0
    res = 0
    oxlist = list(input())
    for j in range(0, len(oxlist), 1):
        if oxlist[j] == 'O':
            point = point + 1
        elif oxlist[j] == 'X':
            point = 0
        res = res + point
    print(res)
