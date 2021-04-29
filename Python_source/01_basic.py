# 변수 연산자 조건문 반복문 문법
#int i = 10
#let j = 20

k = None
print(type (k))

k= 30
print(type (k))

k= 3.14
print(type (k))

k=True
print(type (k))

k = 'abc'
print(type (k))

k
print(type (k))


#파이썬 1개 값 저장 변수타입 = int float bool str MonoType
# 연산자
a= 10
b= 3

print("a/b=", a/b) #실수몫
print("a//b=", a//b) #정수몫
print("a%b=", a%b) # 정수몫 구한 이후 나머지
print("a 를 2진수로 : ", bin(a))
print("a 를 16진수로 : ", hex(a))
print("a 를 8진수로 : ", oct(a))

# 문자연산자
a="abc"
b="def"
print(a+b) # 문자 ㅇ결합
print(a*3) # 문자*int 문자를 int 반복

d = '''Sting문장의
여러 범위를 ㄴ지정해주는
기호 '''
print(d)

print(a[2:4]) # 2번 인덱스부터 4번 인덱스 이전까지 부분 문자열 표기
print(a[2:]) # 2번 인덱스부터 나머지 문자열 
print(a[:4]) # 0번 인덱스부터 4번 인덱스 이전까지 문자열 출력
print(a[-1:4])

a="multicampus"
# a변수에  'cam'  이라는 문자 포함 여부-bool
print('cam' in a)
# a변수에 'cam' 에 몇번 인덱스인지 확인
print(a.find('cam'))
# 왼쪽부터 문자열 인덱스 찾음 
print(a.rfind('cam'))

# a 변수에서 'cam' 문자열부터 나머지 문자열 출력
print(a[a.find('cam'):])

print(a.count('m')) # m 문자 갯수
print(len(a)) # 총 문자 갯수
print(dir(a)) # 변수 a에(str) 사용가능한 함수목록 확인 

a='multi'
b='python'
c=100 # str타입 변경
print("{0}는 정수이고, {1}은 문자열입니다".format(c, a))
#실수 데이터자릿수 조정
print("{: 10.2f}".format(10/3))
#정수 데이터자릿수 조정
print("{: 10d}".format(10//3))

# 정수/실수 -> 문자열로
print(type(100)) #int
print(type(str(100))) # str
      
print("abc" + "def" + str(100))
'''
#입력받은 문자열 -> 정수, 실수 변환 
inl = input('정수 1개를 입력하세요 : ')
print(int(inl))
fol = input('실수 1개를 입력하세요 : ')
print(float(fol))

bol = input('논리값 1개를 입력하세요 : ')
print(bool(bol))
'''

# 파이썬 여러개 ㅌ데이터 저장 타입 - 리스트 튜플 셋 딕셔너리
a2 =[1, 2, 3 ,4 , 5] 
a = ['title', 1, 2.235, True,'4.2',[5, 2, 4]]
print(type(a))
print(a[0])
print(a[1:3])
print( 1 in a2)

# 셋 - 인덱스가 없다, value만 있다, 중복 데이터를 가질 수 없다
b = {1, 2, 3, 4, 5}
print(type(b))
print(len(b))
print(b)

c= (1,2,3,4,5)
print(type(c))


# 딕셔너리{key : value} = 자바 map(key, value) 쌍 데이터 모음
# 인덱스가 없다
# 딕셔너리는 key가 중복되면 안된다
d = {'name': 'JEON', '2': 200}
print(type(d))
print(d.items()) # 조회
print(d.keys()) # 키값 조회
print(d.values()) # 벨류값 조회

#in - 포함여부확인 데이터 문자열|리스트|셋|튜플|딕셔너리
print('id' in c)#ture
d['id'] = 'python' # id key 값 변경 수정
d['email']= '112@mail.com' # email 키, 벨류 추가
print(d.items())

d={'seq': 1, 'title': '제목', 'contents':'내용', 'addfiles':['a.png', 'b.doc', 'c.ppt']}
print(d['addfiles'][0])# 'addfiles'에 첫번째 파일 가져와라

# 딕셔너리 삭제
d.pop('contents')
print(d.items())

# a ㅂ변수의 길이를 구하는 함수
print(len(a)) # 6개
print(len(a[4])) # 3

a.append(100)
print(len(a))
print(a[6])

a.insert(1, 200)
print(len(a))
print(a[1])


a[1] = 300 # 해당 index가 존재하면 변경 / 없으면 오류
print(a)

# 리스트 마지막 데이터 삭제
a.pop()
print(a)
# 리스트에서 ()안 해당 데이터를 삭제
a.remove(300)
print(a)

# 0번 인덱스 데이터 삭제
del a[0]
print(a)


# sort함수 : 정렬 / 숫자 문자가 섞여있으면 반복문을 통해 해결
a2.sort() # 오름차순
print(a2)
a2.reverse() # 내림차순
print(a2)


# 튜플 : 값을 변경할 수 없는(추가 삭제 수정) 리스트
# 함수 리턴 값 - 여러개 튜플
d= (1, 2, 3, 4, 5)
print(type(d))
print(d[0])

# ()가 없는 튜플
a = 1, 2, 3, 4, 5
print(a)
print(type(a))

#튜플을 동시에 선언
a, b = (1, 2), (2)
print(a)
print(type(a))
print(b)
print(type(b))

# 조건문 
if 10 > 5 :
  print(1)
else :
  print(2)
'''
#quiz:  a변수에 사용자 입력값 저장, 0이면 프로그램 종료하고 아니면 3 / a 출력
a = input()
a = int(a)
if a == 0 :
  print("0 으로 나누기 불가")
  print("프로그램 종료")

else :
  print('3을 {}로 나눈 결과는 {} 입니다.'.format(a, 3/a))

# switch-case 파이썬에서 3.10.x 버전 이후 match-case 조건문 추가
'''


'''
import sys
kor = int(sys.argv[1])
mat = int(sys.argv[2])
eng = int(sys.argv[3])
print(sys.argv[1])
print(sys.argv[2])
print(sys.argv[3])

total = kor + mat + eng
avg = total / 3

if avg >= 90 :
  grage = "A"
elif avg >= 80:
  grade = "B"
elif avg >= 70:
  grade = "C"
elif avg >= 60:
  grade = "D"
else :
  grade = "F"

print(grade)
'''


#num 짝수인지 홀수인지 검사
import random
#num = random.radint(1, 100)  1 <= ? <= 100
num= random.randrange(1, 101)
print(num)

if num % 2 == 0:
  print("ㅊ짝수 입니다")
else : 
  print("홀수")

'''
#num(문자열 타입) 작수인지 홀수인지 검사2
num = input("정수 입력하세요")
# 짝수 홀수는 1의 자리숫자만으로도 판별이 가능하기에 1의 자리를 구별하는 코드 
num[len(num)-1]
if num in "02468" :
  print("짝수 입니다")
elif num in "13579":
  print("홀수")
else:
  print("정수 형태의 데이터가 아닙니다")
'''

# 반복문
'''
while 조건식:
  반복 수행문장:
'''
count = 1
total = 0
while count <= 10: # 횟수를 잘 모를때 주로 사용
  print(count)
  total = total + count
  print(total)
  count=count+1
#활용
'''
mynum = 50;
while True:
  inputnum = int(input("숫자를 입력하세요 : "))
  if inputnum > mynum:
    print("작은 숫자를 쌩각해보세요")
  elif inputnum< mynum :
    print("큰 숫자를 생각해보세요")
  elif inputnum == mynum :
    print("정답입니다")
    break
  else
    print("정수 형태가 아닙니다")
'''    

import random
# randint(1, 45)는 1 <= ? <= 45/ randrange(1, 46)는 1< ? < 46
lottoset = set()
#데이터 없는 set 생성 함수 - {}
#중복 데이터 허용x add 무시
while True:
  lotto = random.randrange(1, 46)
  cnt = cnt +1
  print("{} 번째 난수 {} 를 생성합니다.".format(cnt, lotto))
  lottoset.add(lotto)
  if len(lottoset) == 6 :
    break


'''
for  변수 in 반복할 횟수:
  반복 수행 문장 :
'''
# range(11) = 0~10까지 1씩 증가
# 1부터 11까지 1씩 증가 표현
for i in range(1, 11, 1) :
  print(i)

a = [1,2,3,4,5]
pirnt(a)

for i in range(0, len(a), 1):
  print("{}번째 인덱스 값은 {} 입니다.".format(i, a[i]))

for i in a:
  print(i)

for i in (1,2,3,4,5):
  print(i)

for i in {1,2,3,4,5}:
  print(i)

for i in {'k1': 1, 'k2': 2, 'k3': 3}:
  print(i)

d = {'k1': 1, 'k2': 2, 'k3': 3, 'k4':4, 'k5':5}
#(1, 2)- tuple
a, b = (1, 2)

#('k1' : 1, 'k3' : 3)
d.items()
for key, value in d.items():
  print("{} 키의 값은 {} 입니다 ".format(key, value))

#함수 
'''
import sys
#run customized 실행으로 사용
print(sys.argv[1])
print(sys.argv[2])
print(sys.argv[3])
'''


      
''' 여러줄 주석처리
'''



#모듈 - basic.py 파이썬 소스파일= 모듈
# 파이썬 설치하면서 포함된 다른 모듈 math.py : a()
import math
a=3
b=2
print("math.pow(a,b)=", math.pow(a,b))
print("math.trunc(a/b)=", math.trunc(a/b))

# 파이썬 기본 내장함수
print("math.abs(-10)=", abs(-10))
print("math.round(a/b)=", round(a/b))

# 파이썬 기본 내장함수 확인
print(dir(__builtins__))


# 파이썬 사용자 정의 함수
# 자바스크립트 함수/메소드 = 파이썬 함수/메소드 = 자바 메소드
# 함수 - 입력값 (매개변수), 특정 기능 구현 문장 = 결과 리턴값
'''
def 함수이름(매개변수) :
  들여쓰기 문장
  return 값

#호출 실행 메모리 할당 O
리턴결과변수 = 함수이름(값 전달)

'''

#매개변수 없는 함수
def hello_3times():
  print('hello')
  print('hello')
  print('hello')

#실행
hello_3times()


#매개변수 있는 함수
def message_3times(message):
  print(message)
  print(message)
  print(message)

#실행
message_3times("hello")
# 자바, 파이썬 - 매개변수 갯수 일치
# 자바스크립트는 매개변수 갯수 남기는 것 오류처리안함


#매개변수 2개 있는 함수
def message_ntimes(message, n):
  for i in range(1, n+1, 1):
    print(message)
  
  

#실행
message_ntimes("hello", 5)




#기본 매개변수 있는 함수
def basic_ntimes(message="java", n=5):
  for i in range(1, n+1, 1):
    print(message)
  
  

#실행
basic_ntimes()
basic_ntimes(n=4) #n 4번 출력 
basic_ntimes("python", 10) # python을 10번 출력



#가변 매개변수 함수
def dynamic_message(*msg): # *을 붙혀서 매개변수를 자유롭게 전달받도록 
  print(msg)

#실행
dynamic_message("python")
dynamic_message("python", "java")
dynamic_message("python", "css", "spring")

# 다중으로 매개변수를 받을 경우 일반매개변수를 앞으로 선언
def dynamic_message2(n, *msg):
  for i in msg:
    print(msg)

#실행
dynamic_message2(4, "python")
dynamic_message2("python", "java")
dynamic_message2("python", "css", "spring")







