import sys
from itertools import permutations


def main():
    N = int(sys.stdin.readline())
    arr = []

    for _ in range(N):
        arr.append(list(map(int, sys.stdin.readline().split())))

    order_nums = permutations(range(N))
    final_cost = 1000000 * N

    for order_num in order_nums:
        if arr[order_num[-1]][order_num[0]] == 0:
            continue
        check = False
        cost = 0

        for idx in range(len(order_num) - 1):
            if arr[order_num[idx]][order_num[idx + 1]] == 0:
                check = True
                break

            cost += arr[order_num[idx]][order_num[idx + 1]]

            if cost >= final_cost:
                check = True
                break

        if check:
            continue

        cost += arr[order_num[-1]][order_num[0]]
        final_cost = min(final_cost, cost)

    print(final_cost)


main()