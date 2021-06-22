# 13866번. 팀 나누기


a,b,c,d = map(int,input().split())
s = a+b+c+d
team1 = max(a,b,c,d)+min(a,b,c,d)
team2 = s - team1
print(abs(team1-team2))