a = int(input())

dp = []
dp.append(0)
dp.append(0)
dp.append(1)
dp.append(1)
dp.append(2)
dp.append(3)
dp.append(2)
dp.append(3)
dp.append(3)
dp.append(2)
dp.append(3)

i = 11
while i <= a:
    f = []
    if i % 3 == 0 and i % 2 == 0:
        f.append(dp[int(i / 3)]) if dp[int(i / 3)] < dp[int(i / 2)] else f.append(dp[int(i / 2)])
    elif i % 3 == 0 and i % 2 != 0:
        f.append(dp[int(i / 3)]) if dp[int(i / 3)] < dp[i - 1] else f.append(dp[i - 1])
    elif i % 2 == 0 and i % 3 != 0:
        f.append(dp[int(i / 2)]) if dp[int(i / 2)] < dp[i - 1] else f.append(dp[i - 1])
    else:
        f.append(dp[int(i - 1)])
    f.sort()
    dp.append(f[0] + 1)
    i += 1

print(dp[a])
