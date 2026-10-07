# Algorithm & SQL Study
알고리즘과 SQL 문제 풀이를 통해 문제 해결 역량과 논리적 사고를 기르는 스터디입니다.


## 👥 참여자 

| 이름 | GitHub | 풀이 |
|---|---|---|
| 김세현 | [sehyeon262](https://github.com/sehyeon262) | [Algorithm](./sehyeon-kim/Algorithm/) · [SQL](./sehyeon-kim/SQL/) |
| 임건빈 | [gunbread0418](https://github.com/gunbread0418) | [Algorithm](./geonbin-lim/Algorithm/) · [SQL](./geonbin-lim/SQL/) |
| 정현우 | [Hyunwoo](https://github.com/Ro-cks) | [Algorithm](./hyunwoo-jung/Algorithm/) · [SQL](./hyunwoo-jung/SQL/) |



## 📅 스터디 규칙

1. **진행 기간**: 2026.10.08 ~ 진행 중
2. **문제 선정**: 각자 자신의 난이도에 맞는 문제를 선택합니다.
3. **평일 인증**: 월요일 ~ 금요일까지 알고리즘 1문제와 SQL 1문제를 풉니다.
4. **제출 기한**: 당일 23:59까지 풀이를 커밋하고 PR을 올립니다. 알고리즘과 SQL은 각각 별도 PR로 제출합니다.
5. **주말 참여**: 선택 사항이며, 밀린 문제 보충이나 추가 학습에 활용합니다.


## 🔄 제출 방식

1. 문제 풀이 코드를 각자의 폴더에 저장합니다.
2. 문제마다 별도의 커밋을 `main`에 올립니다.
3. 코드 커밋 후 **Issues → New issue → 풀이 기록** 템플릿을 선택합니다.
4. Issue 제목은 `[YYMMDD] 이름 | 문제명` 형식으로 작성합니다.
5. Issue 본문에 문제 종류와 언어를 체크하고, 문제 링크·커밋 링크·회고를 기록합니다.

   
## 📝 커밋 컨벤션

커밋 메시지는 `종류: 내용` 형식으로 작성합니다.

| 종류 | 사용 목적 | 형식 |
|---|---|---|
| `solve` | 알고리즘·SQL 문제 풀이 추가 또는 수정 | `solve: YYMMDD_과목_플랫폼_문제번호_문제이름` | 
| `chore` | 폴더 구조나 저장소 설정 변경 | `chore: 작업내용` | 
| `docs` | README 등 문서 작성 또는 수정 | `docs: 변경내용` | 

- 날짜는 문제를 푼 날짜로 작성합니다.
- 종류·과목·플랫폼은 소문자로 작성합니다.
- 문제 이름은 문제 사이트의 표기를 따릅니다.

  
### 커밋 예시

- 알고리즘 풀이: `solve: 261008_algorithm_pgs_1000_A+B`
- SQL 풀이: `solve: 261008_sql_pgs_59034_모든레코드조회하기`
- 폴더 구조 변경: `chore: add hyunwoo-jung directories`
- 문서 수정: `docs: update README`


## 📁 폴더 구조
```text
sehyeon-kim/
├── Algorithm/
│   └── implementation/                      # 알고리즘 유형
│       └── PGS-1000-A+B/                    # 플랫폼-문제번호-문제명
│           └── solution.py                  # 풀이 파일
│
└── SQL/ 
    └── select/                              # SQL 유형
        └── PGS-59034-모든레코드조회하기/     # 플랫폼-문제번호-문제명
            └── solution.sql                 # 풀이 파일
```
