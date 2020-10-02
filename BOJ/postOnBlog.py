from datetime import datetime
time = str(datetime.now())[:19]
date = str(datetime.now())[:10]

# -----------------------------

file = '1407_2로몇번나누어질까'
category = 'dp'
tier = 'gold4'


# ---------------------------
# 여기 아래부터는 수정 필요 X
# ---------------------------

# --------------------- #
# Python 파일을 읽어옴
# --------------------- #

file_num, file_name = file.split('_')
file_num += ('_')

if tier[0] == 'b':
    f = open(
        f"D:/VSCode/Algorithms/BOJ/1.bronze/{file_num+file_name}.py", "r", encoding='utf-8')
elif tier[0] == "s":
    f = open(
        f"D:/VSCode/Algorithms/BOJ/2.silver/{tier}/{file_num+file_name}.py", "r", encoding='utf-8')
elif tier[0] == "g":
    f = open(
        f"D:/VSCode/Algorithms/BOJ/3.gold/{tier}/{file_num+file_name}.py", "r", encoding='utf-8')
elif tier[0] == "p":
    f = open(
        f"D:/VSCode/Algorithms/BOJ/4.platinum/{tier}/{file_num+file_name}.py", "r", encoding='utf-8')
tier = (tier[0].upper())+tier[1:]
problem_num = file_num[:-1]

lines = f.readlines()
problem_name = (lines[0])[2:-1]
print(problem_name)
problem_code = []
for line in lines[2:]:
    problem_code.append(line)
f.close()


# MD 파일 작성

f = open(
    f"D:/VSCode/gitio/samuel950523.github.io/_posts/2020/algorithms/{date}-algorithm-{file_name}.md", "w", encoding='utf-8')

f.write(f'---\ntitle: "[Python] BOJ {problem_name}"')
f.write(f'''
layout: single
author_profile: true
read_time: true
comments: true
share: true
related: true
categories: Algorithm BOJ {category} {tier}
meta_keywords: 알고리즘,백준,파이썬,{problem_num}번
date: {time} -0400
last_modified_at: {date}T{time[11:]}+08:00
---

# {problem_name}

### 문제 링크\n''')

f.write(
    '- <https://www.acmicpc.net/problem/%d>{: target="\_blank"}' % int(problem_num))

f.write(f"""
\n### 풀이 코드

```python
# {problem_name}\n\n""")


for row in problem_code:
    f.write(row)
f.write("```")

f.write("\n\n### 비고")

f.close()
