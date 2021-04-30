# Python구현 - 자동자 마일리지별로 차량 상태 구별

> .csv 외부 파일을 읽고 항목중 마일리지 항목 별로 차량의 상태를 나눔
>
> 마일리지 20000 이상 = 폐차직전
>
> 10000이상 ~ 20000 미만 = 심각한 중고
>
> 10000 미만 양호한 중고



### usedcars.csv 형태

![usedcars.csv](/Users/MisternB/Desktop/TIL/md-images/img%202021-04-30%209.38.50.png)







### 파일을 라인별로 출력하는 문장 구현 

```python
file = open("usedcars.csv", "r")
#file.read() # 파일 모든 문자열 리턴
# 라인 수 만큼 반복
for line in file :
  # ,(콤마) 별로 나누고 리스트형태로 저장
  line_list = line.split(",")
  print(linelist)
file.close()
  
```





### 항목별로 list 나눔구현

```python
file = open("usedcars.csv", "r")
#file.read() # 파일 모든 문자열 리턴
# 라인 수 만큼 반복
for line in file :
  # ,(콤마) 별로 나누고 리스트형태로 저장
  line_list = line.split(",")
  #list 기본은 str형태
  mile = line_list[3]
  if int(mile) >= 20000:
    line_list.append("폐차 직전")
  elif int(mile)>= 10000 int(mile) < 20000:
    line_list.append("심각한 중고")
  else :
    line_list.append("양호한 중고")
  print(linelist)
file.close()
```

* `line_list = line.split(",")` 는 선언되는 순간 라인을 전부 읽어오기에 수정이 필요하다
* `if`문에서 `.isdigit()`를 사용해 수정하기로 한다  

#### 필요에따라 항목별로 나누기 위한 코드

```python
file = open("usedcars.csv", "r")
for line in file :
  line_list = line.split(",")
  year = line_list[0]
  model = line_list[1]
  price = line_list[2]
  mile = line_list[3]
  color = line_list[4]
  trans = line_list[5]
```

* 리스트 인덱스별로 구별하여 원하는 항목을 구별할 수 있다



### 완성코드

```python
file = open("usedcars.csv", "r")
#file.read() # 파일 모든 문자열 리턴
# 라인 수 만큼 반복
for line in file :
  total += 1
  # ,(콤마) 별로 나누고 리스트형태로 저장
  line_list = line.split(",")
  #list 기본은 str형태
  mile = line_list[3]
  if mile.isdigit() and int(mile) >= 20000:
    line_list.append("폐차 직전")
  elif mile.isdigit() and int(mile)>= 10000 and int(mile) < 20000:
    line_list.append("심각한 중고")
  elif mile.isdigit() and int(mile) < 10000:
    line_list.append("양호한 중고")
  else :
    line_list.append("차량상태")
  print(line_list)
print("총 차량 수 : ", total)  

file.close()
```



### 결과 코드

![스크린샷 2021-04-30 오전 9.40.12](/Users/MisternB/Desktop/TIL/md-images/img%202021-04-30%209.40.12.png)

* 추가적으로 마일리지가 표기가 안된 상태를 보완해야함
* 년도별, 색상별 등 순서를 처리하는 방법 필요

