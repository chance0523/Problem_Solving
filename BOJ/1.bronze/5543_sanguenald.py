# 5543. 상근날드


sang = int(input())
choong = int(input())
ha = int(input())
col = int(input())
sa = int(input())

min_set = min(sang, choong, ha) + min(col, sa) - 50

print(min_set)
