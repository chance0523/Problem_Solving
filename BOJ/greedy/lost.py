def _1541():
    N = str(input())
    arr = []
    arr = N.split('-')
    if len(arr) == 1:
        ret = 0
        arr = N.split('+')
        for i in range(len(arr)):
            ret += int(arr[i])
        print(ret)
        return

    ret = 0
    for i in range(len(arr)):
        if '+' in arr[i] and i != 0:
            temp = arr[i].split('+')
            for j in range(len(temp)):
                ret -= int(temp[j])

        elif '+' not in arr[i] and i == 0:
            ret += int(arr[i])

        elif '+' in arr[i] and i == 0:
            temp = arr[i].split('+')
            for j in range(len(temp)):
                ret += int(temp[j])
        else:
            ret -= int(arr[i])
    print(ret)

_1541()
