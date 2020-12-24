# 6568번. 귀도 반 로썸은 크리스마스날 심심하다고 파이썬을 만들었다


import sys

pc = 0
ga = 0


def STA(pi):
    pass


def LDA(pi):
    pass


def BEQ(pi):
    pass


def NOP():
    pass


def DEC():
    pass


def INC():
    pass


def JMP(pi):
    pass


def HLT():
    pass


for line in sys.stdin:
    l = line.rstrip()
    op = l[0:3]  # 연산자
    pi = l[4:]  # 피연산자 (영어로 원래 operand)
    if op == '000':
        STA(pi)
    elif op == '001':
        LDA(pi)
    elif op == '010':
        BEQ(pi)
    elif op == '011':
        NOP()
    elif op == '100':
        DEC()
    elif op == '101':
        INC()
    elif op == '110':
        JMP(pi)
    elif op == '111':
        HLT()
