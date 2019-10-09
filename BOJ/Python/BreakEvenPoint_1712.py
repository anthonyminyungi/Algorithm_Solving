a, b, c = map(int, input().split())
if c - b > 0:
    if c - b != 0 and int(a / (c - b)) <= a / (c - b):
        print(int(a / (c - b)) + 1)
    else:
        print(int(a / (c - b)))
else:
    print(-1)
