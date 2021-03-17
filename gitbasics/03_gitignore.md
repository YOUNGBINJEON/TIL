# .gitignore

> 깃과 깃허브에서  비공개로 다뤄야할 파일을 처리해주는 파일

* `.gitignore` 은 파일에 git으로 추적하지 않을 파일을 관리한다.

  ```bash
  data.csv # 특정 파일
  secret_folder/ # 특정 파일
  *.zip # 특정 압축 파일, 확장자
  ```

* 일반적으로 개발 소스코드와 관련 없는 개발 환경 속으로 생성되는 파일들을 필수적을 넣는다. 

  `OS - mac/windows/linux`, `IDE / text editor`, 특정 언어 환경

* `gitignore` 작성 참고 사이트

  [gitignore](https://www.toptal.com/developers/gitignore) 에서 확인

  ### .gitignore 변경사항 반영하기

  

  ```bash
  $ git rm -r --cached . # cache에 기록된 tracking 중인 파일리스트 삭제
  $ git add .
  $ git commit -m '__커밋 메시지 작성__'
  $ git push origin master # git push __remote__ __branch__ 
  ```

  1. `.gitignore` 파일을 수정한다.
  2. 이후 위와같은 코드로 작성하여 깃허브로 연동