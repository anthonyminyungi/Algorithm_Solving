def fact(n):
    if n == 1:
        return 1
    else:
        return n * fact(n - 1)


def fac2(k, r, l):
    if l == k - r + 1:
        return l
    else:
        return l * fac2(k, r, l - 1)


a, b = map(int, input().split())
if b == 0 or a == b:
    print(1)
else:
    print(int(fac2(a, b, a) // fact(b)))
# same code with 11050
