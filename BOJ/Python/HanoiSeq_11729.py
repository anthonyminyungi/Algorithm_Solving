def hanoi(n, f, temp, to):
    if (n == 1):
        print(str(f) + ' ' + str(to))
    else:
        hanoi(n - 1, f, to, temp)
        print(str(f) + ' ' + str(to))
        hanoi(n - 1, temp, f, to)
    return;


n = int(input())
print(2 ** n - 1)
hanoi(n, 1, 2, 3)
