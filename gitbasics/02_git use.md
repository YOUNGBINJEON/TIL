# 원격 저장소 기초 활용

## 준비

* 깃허브에 비어있는 저장소(repository) 만든다.

  

## 기본 명령어

### 원격저장소(remote repository) 설정

```bash
$git remote add origin __url__
# 예시
$git remote add origin https://github.com/YOUNGBINJEON/first.git
```

* 깃, 원격저장소(remote) 추가해줘(add) 오리진이라는 이름으로 (origin) URL!
* 설정된 원격 저장소를 확인하기 위해서는 아래의 명령어를 활용한다.

```bash
$ git remote -v
origin	https://github.com/YOUNGBINJEON/first.git (fetch)
origin	https://github.com/YOUNGBINJEON/first.git (push)
```



### `push`

```bash
$ git push origin master
Username for 'https://github.com': sh44972@gmail.com
Password for 'https://sh44972@gmail.com@github.com': 
Enumerating objects: 10, done.
Counting objects: 100% (10/10), done.
Delta compression using up to 8 threads
Compressing objects: 100% (8/8), done.
Writing objects: 100% (10/10), 1.04 KiB | 1.04 MiB/s, done.
Total 10 (delta 2), reused 0 (delta 0)
remote: Resolving deltas: 100% (2/2), done.
To https://github.com/YOUNGBINJEON/first.git
 * [new branch]      master -> master
```

* origin 원격 저장소로 push

### push error

```bash
$ git push origin master 
To https://github.com/*****/****** 
# push 실패
 ! [rejected]        master -> master (non-fast-forward) 
error: failed to push some refs to (url)
# 원격 저장소 커밋이 로컬저장소에 없다.
hint: Updates were rejected because the tip of your current branch is behind 
hint: its remote counterpart. Integrate the remote changes (e.g. 
hint: 'git pull ...') before pushing again. 
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```

#### 해결방법

```bash

```

* 원격저장소의 커밋과 로컬의 커밋을 병합하는 



### gitignore

* `.gitignore` 은 파일에 git으로 추적하지 않을 파일을 관리한다.

  ```bash
  data.csv # 특정 파일
  secret_folder/ # 특정 파일
  .zip # 특정 압축 파일, 확장자
  ```

* 일반적으로 개발 소스코드와 관련 없는 개발 환경 속으로 생성되는 파일들을 필수적을 넣는다. 

  `OS - mac/windows/linux`, `IDE / text editor`, 특정 언어 환경

* `gitignore` 작성 참고 사이트

  [gitignore](https://www.toptal.com/developers/gitignore) 에서 확인



### pull

```bash
$ git pull 
```



### clone

```bash
$ git clone __url___
```



## 협업

> 여러 명이 하나의 프로젝트를 보고 작성하고 병합하는 명령어를 살펴보자

### branch

* branch 생성

```bash
$ git branch ppt
```



### checkout

* branch 생성 및 이동

```bash
$ git checkout ___브랜치 이름___ # 브랜치 생성
$ git checkout =b ___브랜치 이름___ # 생성하고 이동
```



### merge

* branch 병합

```bash
$ git merch ___브랜치 이름___ # 
```

###



## 개인 포트폴리오 작성방법

깃허브 새 `repository` 만들고 깃허브 Pages 로 연동하면 된다.

username.github.io 로 작성하면 된다.