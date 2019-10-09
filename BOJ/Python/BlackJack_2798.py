N, M = map(int, input().split())
card = list(map(int, input().split(' ')))
answer = 0
for i in range(0, N - 2):
    for j in range(i + 1, N - 1):
        for k in range(j + 1, N):
            if (card[i] + card[j] + card[k]) <= M and M - (card[i] + card[j] + card[k]) < M - answer:
                answer = card[i] + card[j] + card[k]
print(answer)

# Other Solving - this needs more memory and gets more time.
# from itertools import combinations
#
# N, M = map(int, input().split())
# num_list = list(map(int, input().split()))
# res_list = []
# for comb in combinations(num_list, 3):
#     comb_sum = sum(comb)
#     res_list.append(comb_sum)
#
# res_list = list(filter(lambda t: t <= 0, list(set(map(lambda x: x - M, res_list)))))
# res_list = sorted(res_list, key=int, reverse=True)
# print(M + res_list[0])
