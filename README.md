# scaleProject
 
***

# Contents <br>
1. [개요](#star-개요)  
2. [팀 소개 및 주요 기능](#star-팀-소개-및-주요-기능)
3. [구현 기능](#star-구현-기능)
    - [회원가입 - 유효성검사](#pushpin-회원가입---유효성검사)
    - [회원가입 - 아이디 중복 조회](#pushpin-회원가입---아이디-중복-조회)
    - [회원가입 - 이메일 인증](#pushpin-회원가입---이메일-인증)
    - [회원가입 - 주소 검색](#pushpin-회원가입---주소-검색)   
    - [로그인](#pushpin-로그인)   
    - [아이디 찾기](#pushpin-아이디-찾기)
    - [비밀번호 재설정(이메일 인증 활용)](#pushpin-비밀번호-재설정(이메일-인증-활용))
    - [공지사항](#pushpin-공지사항)
    - [자주묻는질문](#pushpin-자주묻는질문)
    - [1:1 문의](#pushpin-11-문의)
    - [정책](#pushipin-정책)

4. [Document](#star-document)

***

# :star: 개요
- 프로젝트명 : scaleProject <br>

- 보고서 : [도미파솔라조_SCALE_최종보고서.pdf](https://github.com/yullmm0531/scaleProject/files/10849236/_SCALE_.pdf)<br>

- 기획 의도  <br>
  - 늘어난 중고거래 속 가품사기 방지 필요성 증가 <br>
  - 믿을만한 중간역할 중개자의 필요 <br>
  - 1대1 거래서비스에서 원하는 가격에 구매 <br>
  - 1대1 거래서비스에서 원하는 가격에 판매 <br>

- 개발 환경 <br><br>
![image](https://user-images.githubusercontent.com/115603858/221830442-edf7066a-29dc-4288-9f90-3c6306eb630e.png)<br>

***

# :star: 팀 소개 및 주요 기능
<img width="600" src="https://user-images.githubusercontent.com/115603858/221831163-b235dd60-382b-4981-bf52-9663c21982cc.png">
<img width="600" src="https://user-images.githubusercontent.com/115603858/221831218-f8bb8b1a-52e4-406f-9354-4099f2b8a5b7.png">

***
# :star: 구현 기능
 

### :pushpin: 회원가입 - 유효성검사
![image](https://user-images.githubusercontent.com/91313067/222188765-f1a5d76b-ef7c-4d63-a6ea-b20a1cef03c5.gif)

- 모든 필드에 각 입력값 유효성검사
- 1)필수값 입력/비입력 확인 2)입력값 형식 확인 순으로 검사
- 유효성검사 통과 시 안내문구 비노출 또는 확인문구로 변경
- 필드 입력 외 '아이디 중복조회', '이메일인증', '약관 동의'는 alert으로 사용자 행동 유도
- 회원가입 버튼 클릭 시 유효성검사 통과하지 못한 필드에 focus

  
### :pushpin: 회원가입 - 아이디 중복 조회
![idCheck](https://user-images.githubusercontent.com/91313067/222195695-f11a9e08-cedf-4f4a-a69a-e0ca7478d847.gif)

- 아이디 중복 조회 후 동일한 아이디가 있을 경우 안내문구 노출
- 중복된 아이디가 아닐 경우 사용 가능 안내문구 노출

  
### :pushpin: 회원가입 - 이메일 인증
![email_1](https://user-images.githubusercontent.com/91313067/222196893-86e16d42-5ace-4098-b8c8-c18b4b19a261.gif)

- 이메일 인증버튼 클릭 시 이메일 형식에 맞지 않을 경우 안내문구 노출
- 인증메일 발송 후 인증번호 인풋 display, 인증버튼 -> '재인증'으로 버튼명 변경



### :pushpin: 회원가입 - 주소 검색

  
### :pushpin: 로그인

  
### :pushpin: 아이디 찾기

  
### :pushpin: 비밀번호 재설정(이메일 인증 활용)

  
### :pushpin: 공지사항

### :pushpin: 자주묻는질문

### :pushpin: 1:1 문의

### :pushpin: 정책


***
# :star: Document

## 개발 일정 <br>
<img width="1519" alt="scale일정" src="https://user-images.githubusercontent.com/115603858/222172225-fb978526-b900-47b5-9c14-766c87c00b10.png">
<br>

## 유스케이스 <br>
![use_case](https://user-images.githubusercontent.com/115603858/222172313-c7e3f1ed-f061-4595-a0a1-f9c745f5fafb.jpg)
<br>

## DB 설계 <br>
<img width="1436" alt="scaleDB" src="https://user-images.githubusercontent.com/115603858/222171803-047a9066-7e0b-43b2-9aba-f943b4fd83cd.png">
<br>
