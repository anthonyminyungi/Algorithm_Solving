n = int(input())
grn = 0
for i in range(n):
    slist = list(str(input()))
    for j in range(len(slist)):
        if j != len(slist) - 1 and slist[j] == slist[j + 1]:
            pass
        elif slist[j + 1:].count(slist[j]) != 0:
            break
        elif j == len(slist) - 1:
            grn += 1
print(grn)
