# 자바 c, c++, c# --> 컴파일 언어
# 자바소스파일 -> 1- 마지막 문법 검사 = 바이너리 변경(컴파일 결과를 .class파일로 저장) - 실행
# 자바스크립트 파이썬 --> 1문장마다 문법 검사 실행  = 인터프리터언어라 한다
'''
try:
  실행하고자하는 문장
except ValueError :
  문제가 발생했을 때 실행 문장
'''

try:
  money = input("대출 금액 상환개월수 입력하세요 : ")
  two_items = money.split()
  loan = int(two_items[0]) # 대출금액
  payback = int(two_items[1]) # 개월수
  if payback <= 0 :
    #raise = 무조건 실행 키워드 / ValueError을
    raise ValueError("상환개월은 음수값을 입력할 수 없습니다") 
  monthly_return = loan / payback
except IndexError: # 입력값 대출과 금액 두개 입력 안하면 발생
  print("대출 금액이나 개월수 입력확인하세요 ")
except ValueError as ve: # 정수가 아닌 문자와 같은 입력시
  print(ve)
else : #오류없이 정상실행되었을 때
  print(monthly_return, " 을 매달 상환하셔야합니다")
finally:
  print("영업 종료")
