



# GitHub_IDE 연동

### 용어

원격 저장소 - remote repository(원격 url)

로컬 저장소 - local repository(내컴퓨터 폴더 지정)

commit - 로컬 저장소에 내 프로젝트를 저장

push - 원격 저장소에 내 프로젝트 전송(upstream)

fetch - 원격 저장소에서 프로젝트를 가져오기

merge - 기존 내 프로젝트와 fetch한 프로젝트 병합하기

pull - fetch + merge



## sts4에서 사용 방법

1. 깃허브

   깃허브 레포짓토리 생성 

   깃허브 `URL` 복사

2. sts4

   메뉴탭 : 윈도우 - perspective - other - git

   `clone a Git repository`  클릭

   

   ![입력1](../md-images/img%202021-04-27%202.08.04.png)

   

   Branch Selection 에서 원하는 branch 선택 후 `Next>` 클릭



​		![스크린샷 2021-04-27 오후 2.12.56](../md-images/img%202021-04-27%202.12.56.png)

​		Directory, branch, Remote name 확인 후 `Finish` 

3.   프로젝트 가져오기

   

   ![프로젝트 가져오기](../md-images/img%202021-04-27%203.07.18.png)

   

4. 프로젝트 수정 후

   로컬 레포짓토리로 연동되었다면 진행하는 프로젝트 `우클릭`  >  `Team`  > `Add to index` 





5. Commit and push

![Add to index](../md-images/img%202021-04-27%203.00.43.png)

Staged Changes 에 변경된 항목이 올라가있는지 확인 후 Commit Message 작성

​	`Add to index`클릭후 변화가 없다면 윈도우 - show view - other - git - git staging 클릭



`Commit and Push` (자신 혼자 사용하는 경우에만)  /  `Commit` (팀원 또는 Fork를 사용하는 경우)

`Commit`를 선택했다면 다시 프로젝트 `우클릭` > `Team` > `Push branch XXXX ` 진행



#### 팀프로젝트 가져오기

1. 깃허브 접속
2. 팀 프로젝트 레포짓토리 접속
3. fork 클릭
4.  fork 레포짓토리의 branch create
5. fork한 레포짓토리 URL 복사
6. sts4 에서 clone a repository 클릭
7. URL 작성, username, password 작성,  로컬 Directory 경로 설정, branch 네임 확인 
8. Working Tree 에서 원하는 프로젝트 Import Projects 클릭



#### Pull

github에서 업데이트된 레포짓토리를 기존 로컬 저장소에 있는 프로젝트로 가져오기

1. pull



