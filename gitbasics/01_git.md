# git 기초

> 분산버전관리시스템(DVCS)

## 로컬 저장소 설정

``` bash
$ git init
Initialized empty Git repository in /Users/MisternB/.git/

```

* `.git`  폴더가 생성되고, 여기에 git과 관련된 모든 정보들이 저장된다. 



## 기본 작업 흐름

모든 작업은 `touch`  명령어를 통해서 파일을 만드는 것으로 대체

```bash
$ git add _디렉토리_ #문법 형태
$ git add a.txt #특정 파일을 넣을 수 있고
$ git add my_folder/ #특정 폴더를 넣을 수도 있고
$ git add a.txt b.txt #특정 파일들을 넣을 수 있고
$ git add . #현재 디렉토리(하위 디렉토리 포함)
```

* 커밋 대상 파일 목록에 추가한다.

* working directory의 변경사항(첫 번째 통)을 staging area(두 번째 통)상태로 변경시킨다.

```bash
$ git status
On branch master

No commits yet
# track X 파일들
# git으로 관리된 적이 없는 파일(새로 만든 파일 등)

Untracked files:
# 커밋이 될 것에 포함시키기 위해서는 git add 명령어를 사용..
# => 두번째 통(staging area)에 담기 위해서... 
  (use "git add <file>..." to include in what will be committed)
  # 파일 목록
	new.txt

# 스테이징 에어리어(SA)에 없고
# 워킹 디렉토리(WD) 에는 있다.
nothing added to commit but untracked files present (use "git add" to track
```

## add 이후

```bash
$ git add .
$ git status
On branch master

No commits yet
# 변경사항들 .. 커밋될
# Staging area  에 있다.
Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
	new file:   new.txt
```



## commit

```bash
$ git commit -m 'Add new.txt'
[master (root-commit) 5a074be] Add new.txt
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 new.txt
```

* `commit` 지금 파일 상태를 스냅샷 찍는다(버전을 저장)
* 커밋 메시지는 코드 변경사항(이력/버전/커밋)을 충분히 잘 나타낼 수 있도록 작성한다.
* 아래의 명령어를 통해서 지금까지 기록된 커밋을 확인할 수 있다.

### commit 메시지 편집기 등록

```bash 
$ git commit #vs코드로 커밋 메시지를 많이 작성할 수 있다
```









### commit message 작성팁

* [깃 커밋 메시지 가이드라인](https://meetup.toast.com/posts/106)



## log 

```bash
$ git log
commit 5a074bef35ff255e8a97f9ed00cbc93d5a67d30c (HEAD -> master)
Author: YOUNGBIN <sh44972@gmail.com>
Date:   Tue Mar 16 15:08:13 2021 +0900

    Add new.txt

$ git log --oneline
5a074be (HEAD -> master) Add new.txt

$ git log -1 # 숫자 1은 로그 1개만 보여달라는 의미
commit 5a074bef35ff255e8a97f9ed00cbc93d5a67d30c (HEAD -> master)
Author: YOUNGBIN <sh44972@gmail.com>
Date:   Tue Mar 16 15:08:13 2021 +0900

    Add new.txt

$ git log --oneline -1
5a074be (HEAD -> master) Add new.txt
```

## git config -author

* 커밋을 남기는 사람에 대한 정보(이메일, 이름)을 설정함 

```bash
$ git config --global user.name 'YOUNGBINJEON'
$ git config --global user.email 'sh44972@gmail.com'
$ git config --global -l #커밋 설정정보 확인
```

* 깃허브 이메일주소와 동일하게 지정하면, 커밋 기록이 깃허브 계정과 연동되어 표기(잔디밭 심기)
  * 기록(log)만 남기는 것
* 주의! 이 설정은 깃허브 접근권한과는 전혀 상관없음
  * 윈도우 : 자격증명 관리자
  * 맥 : 키체인