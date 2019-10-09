n = int(input())
to = []
for i in range(n):
    a = int(input())
    if to.count(a) == 0:
        to.append(a)

to.sort()

for k in to:
    print(k)
