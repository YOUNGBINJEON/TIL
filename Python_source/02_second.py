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
'''

'''
#리턴값이 여러개인 함수 정의
def return3_func():
  return 1, 2, 3, 4, 5 # 리턴을 여러개 줬을때 r1은 튜플이다
r1= return3_func()

print(r1[0])

def return3_func():
  return [1, 2, 3, 4, 5] #리스트타입 
r1= return3_func()

print(type(r1))


def return3_func():
  return {1, 2, 3, 4, 5} #set 타입 
r1= return3_func()

print(type(r1))

'''


# 매개변수 / 지역번수 / 전역변수
a = "전역변수"
def vartest(b):
  global a #함수 내부에서 전역변수 a의 값을 수정하기위해 선언
  a= "전역변수 값 수정"
  c= "지역변수"
  print(a)
  print(b)
  print(c)


def vartest2(d):
  e= "다른지역변수"
  print(a)
  print(d)
  print(e)

vartest("매개변수1")
vartest2("매개변수2")
print(a)


global_var = 0
def inc():
  global global_var
  local_var = 1
  local_var = local_var + 1
  global_var = global_var + 1 # 전역변수기에 ㅅ호출을 계속 할 수록 값 증가
  print("지역변수 {} 값, 전역변수{} 값".format(local_var, global_var))
  
inc()
inc()
inc()


# 반복문 팩토리얼 함수1
def fact1(n):
  result = 1
  for i in range(1, n+1, 1):
    result = result * i
    print("{} 팩토리얼은 {} 입니다".format(i, result))
  return result
r1 = fact1(5)
print(r1)


# 재귀호출 팩토리얼 함수2
def fact2(n):
  if n == 0:
    return 1
  else :
    result = n * fact2(n-1) # 재귀호출 핵심 : 스스로를 호출
    print("재귀호출 {} 팩토리얼은 {} 입니다".format(n, result))
    return result

r2 = fact2(5)
print(r2)


# 자바스크립트와 파이썬 함수 변수 취급
# 함수 매개변수 =  callback함수, 지역함수 , 리턴함수
def f1():
  print("out put")

import time
def call_func(f):
  #Thread.sleep(5000) - 자바
  # setTime() - 자바스크립트
  time.sleep(5)
  f()

call_func(f1)


# map 함수 (함수를 매개변수 ) mapping
a = [2.5, 4.7, 3.6, 3.4]
print(a)
a = list(map(int, a)) #int로 바꾼 리스트 a 를 하나씩 매핑하는 것
print(a)

b = ["java programming", "oracle sql", "sping framework", "python programming"]
# 첫 문자만 대문자변경
def my_upper(s):
  return s[0:4].upper() + s[4:] #앞에서 4글자만 대문자 + 4번부터 이어서 붙여넣기

b= list(map(my_upper, b)) # b인덱스 만큼 수행하고 다시 리스트의형태로 변수 b에 저장
print(b)


def no_action():
  pass # 함수에 아무런 정의 없이 수행 - 무명의 함수
no_action()


# 람다식 - 리턴문 한가지만 가지는 무명의 함수 정의와 동시에 호출해야함
# 람다식 형태 => lambda 매개변수 : 리턴값
print((lambda : 0)())
print((lambda  x : x*x)(10))
print((lambda x, y : (x+y, x-y, x*y, x%y))(10, 2))










