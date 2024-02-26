croa = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()
for i in croa:
    word = word.replace(i, '1')
print(len(word))
