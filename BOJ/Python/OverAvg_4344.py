n = int(input())
for i in range(0, n, 1):
    nlist = list(map(int, input().split()))
    s = nlist[0]
    well = []
    nlist.remove(s)
    avg = float(sum(nlist) / len(nlist))
    for j in range(0, len(nlist), 1):
        if nlist[j] > avg:
            well.append(nlist[j])
    wavg = float(len(well) / len(nlist)) * 100
    print('%.3f' % wavg + '%')
