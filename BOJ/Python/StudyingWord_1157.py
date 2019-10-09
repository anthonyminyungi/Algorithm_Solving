word = str(input())
arr = []
ascl = 97
ascc = 65
for i in range(1, 27, 1):
    tmp = word.count(chr(ascc)) + word.count(chr(ascl))
    arr.append(tmp)
    ascc = ascc + 1
    ascl = ascl + 1
arr2 = arr.copy()
arr2.sort(reverse=True)

if (arr2[0] == arr2[1]):
    print('?')
else:
    print(chr(arr.index(arr2[0]) + 65))
