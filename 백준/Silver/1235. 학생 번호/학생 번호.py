N = int(input())
students = []
for i in range(N):
    students.append(input())

for i in range(len(students[0])):
    temp = []
    for st in students:
        if (temp.count(st[len(students[0])-i-1:]) == 1):
            break
        else:
            temp.append(st[len(students[0])-i-1:])
    if (len(temp) == N):
        print(i+1)
        break