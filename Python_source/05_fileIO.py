# 파이썬 데이터 소스로부터 데이터를 가져와서 분석 - 결과를 테이블, 그래프 형태로 시각적으로 표현

#파일 읽기
import os
print(os.getcwd()) #/Users/MisternB/Downloads/kdigital/Python_source
# 현재 파일 디렉토리의 리스트['04_exception.py', '.DS_Store', '03_moduletest.py', '05_fileIO.py', '01_basic.py', '02_second.py']
print(os.listdir())


#read
try:
  #한글 에러시 open('04_exception.py', "r", encoding="UTF-8") 사용
  file = open('a.txt', "r") 
  print(file.read()) 
except FileNotFoundError:
  print("a.txt 없음")
file.close()


# write
file2 = open("a.txt", "w") # 읽기시도 후 파일이 없으면 생성
file2.write("새로운 파일을 생성합니다")
file2.close()


# write2 (a)
file3 = open("a.txt" "a") #파일 없으면 새로 생성 / 파일 있으면 기존 내용 뒤에 추가 쓰기 저장
file3.write("\n 새로운 라인을 추가합니다")
file3.close()


# 파일 한라인씩 읽어서 리스트에 저장
# file_list=[]
file_list= list()
file4 = open("a.txt", "r")
for line in file4:
  file_list.append(line)
file3.close()


# 리스트에 저장내용 확인 출력
linenum=1
for line in file_list:
  print("{}번 라인".format(linenum), line, end='') #end='' 기본값 \n을 공백으로 바꿔줌
  linenum+=1


# 리스트에 저장내용 확인 출력2
for index in range(1, len(file_list), 1):
  print("{}번 라인".format(index), file_list[index], end='')


#라인번호 있는 상태의 모든 내용을 새로운 파일 a2.txt에 저장
file5 = open("a2.txt", "w")
#file_list에 저장된것을 불러와서 다른파일에 라인번호 넣어서 추가
for index in range(1, len(file_list), 1):
  line = str(index) + " 번 라인 : " + file_list[index]
  file5.write(line)
file5.close()











