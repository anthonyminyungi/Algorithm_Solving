n = int(input())
for i in range(0, n, 1):
    tlist = list(str(input()).split())
    s = list(tlist[1])
    for k in range(0, len(s), 1):
        for j in range(0, int(tlist[0]), 1):
            print(s[k], end='')
    print()
