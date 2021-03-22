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

### gitignore

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

  

* `.gitignore` 수정된 파일 깃허브에 리스트 적용하기

```bash
git rm -r --cached . //cache에 기록된 tracking 중인 파일리스트 삭제
git add .
git commit -m '메시지'
git push {remote} {branch} 
```





### pull

```bash
$ git pull 
```



### clone

```bash
$ git clone __url___
```





## 개인 포트폴리오 작성방법

깃허브 새 `repository` 만들고 깃허브 Pages 로 연동하면 된다.

username.github.io 로 작성하면 된다.