n = int(input())
for i in range(n) :
    stack = []
    cha = input()
    for j in cha :
        if j == ')':
            if len(stack) == 0 or stack[-1] != '(':
                print('NO')
                break
            else:
                stack.pop()
        else:
            stack.append(j)
    else:
        if len(stack) == 0:
            print('YES')
        else:
            print('NO')