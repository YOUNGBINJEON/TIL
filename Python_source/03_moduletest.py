#module / 모듈로 기능 구현을 나눠서 사용
# a,b 부품 결합 - 완성품 x
# a, c - 완성품 y

# 이미 몇개 설치 모듈 사용
import random
import math
import time
import sys

random.randint(1, 10)
math.trunc(3.14)
time.sleep(5)
print(sys.argv[1])

# 다른 모듈 import하는 방법 1
import math
math.trunc(3.14)
math.log(10,2)
math.sin(50)

# 다른 모듈 import하는 방법 2
from math import trunc, log
trunc(3.14)
log(10,2)

# 다른 모듈 import하는 방법 3
from math import *
trunc(3.14)
log(10, 2)
sin()


# 다른 모듈 import하는 방법 4 alias로 별칭을 줘 간략화가능
import math as ma
ma.trunc(3.14)
ma.log(10, 2)
ma.sin()


# random 모듈 사용
import random
print(random.randint(1, 100))
print(random.randrange(1, 101))
name_list = ['a','b','c','d','e', '가','나','다','라','마']
print(random.choice(name_list))
random.shuffle(name_list) # 리스트를 섞어줌
print(name_list) # 섞여서 출력됨
print(random.sample(name_list, 2)) # name_list에서 2개 뽑아오기


# system 모듈 정보 확인
import sys
print(sys.version)
print(sys.path)


# os 모듈
import os
print(os.name)
print(os.getcwd())
print(os.listdir()) #해당 py 파일의 디렉토리 리스트 알려줌
#os.rename('파일명', '변경이름')
#os.remove('파일명')


# 날짜 모듈
import datetime
now = datetime.datetime.now()
print(now)
print(now.year)
print(now.month)
print(now.day)
print(now.hour)
print(now.minute)
print(now.second)
# 1년 뒤의 년도 구하는 방법
after_1year = now.replace(year=(now.year+1))
print(after_1year)
print(after_1year.year)


import time
sec = time.time() # 현재시간을 초단위
now = time.localtime(sec) # 년 월 일 시분초 변경
print(now.tm_year)
print(now)


# 아직 설치되지않은 모듈 설치 import-사용코드
# 자바는 라이브러리 - ojdbc8.jar(오라클 폴더 -> jre) jstl.jar springxx.jar(maven)
# 파이썬은 도스 pip3를 활용


#pypi.org 사이트 검색 - ㄱ명령어 복사
# 터미널에서 pip install beautifulsoup4 명령어 입력
# pip list
# pip show beautifulsoup4 - location 정보
# sys.path 포함
import urllib.request as req
from bs4 import BeautifulSoup as bs
response = req.urlopen("http://127.0.0.1:9091")
soup = bs(response, "html.parser")
#페이지 전체내용 출력
rescontents = soup.prettify()
print(rescontents)

#rescontents = response.read() # 구글페이지 소스내용 확인 가능
#print(rescontents)


#h3 태그
print(soup.find("h3")) #.find는 태그의 첫번째만 가져옴
print(soup.find("h3").sting)
print(soup.find("img")['src']) # 속성 값을 출력
for h3 in soup.findAll("h3"): # 해당 태그의 전체 출력
  print(h3.string)

response.close()







