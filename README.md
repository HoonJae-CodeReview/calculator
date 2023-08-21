# code-review

### 객체지향 생활원칙을 적용하기
- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다. `도저히 안된다면 최대 2개까지`
- 규칙 2: else 예약어를 쓰지 않는다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 4: 한 줄에 점을 하나만 찍는다.
- 규칙 5: 줄여쓰지 않는다(축약 금지). `ex) BufferedReader br = new BufferedReader(); (X) -> BufferedReader bufferedReader = new BufferedReader(); (O)`
- 규칙 6: 모든 엔티티를 작게 유지한다.
- 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 규칙 8: 일급 콜렉션을 쓴다.
- 규칙 9: 게터/세터/프로퍼티를 쓰지 않는다. `필요하면 쓰기`

### 스트림과 람다를 활용하기
- 스트림과 람다를 사용 할 수 있는 건 스트림과 람다를 사용해서 구현하기.

### AngularJS Commit Message Conventions 중
### commit message 종류를 다음과 같이 구분
- feat (feature)
- fix (bug fix)
- docs (documentation)
- style (formatting, missing semi colons, …)
- refactor
- test (when adding missing tests)
- chore (maintain)

### gitignore 반영
- https://gitignore.io/ 에 접속해서 필요한 부분 ignore 반영, gradle, maven, intellij, macOS, window 등등
### 요구사항
- 콘솔로 구현입니다.(스윙으로 구현하시는 분들 계실까봐) 
- 객체지향적인 코드로 계산기 구현하기
    - [ ]  더하기
    - [ ]  빼기
    - [ ]  곱하기
    - [ ]  나누기
    - [ ]  우선순위(사칙연산)
- [ ]  테스트 코드 구현하기
- [ ]  계산 이력을 맵으로 데이터 저장기능 만들기
    - 애플리케이션이 동작하는 동안 데이터베이스 외에 데이터를 저장할 수 있는 방법을 고안해보세요.
- (선택) 정규식 사용
- 가능하면 단위 테스트도 작성하기.

### 실행결과(콘솔)
```
1. 조회
2. 계산

선택 : 2

1 + 2
3

1. 조회
2. 계산

선택 : 2

1 + 2 * 3
7

1. 조회
2. 계산

선택 : 1

1 + 2 = 3
1 + 2 * 3 = 7

선택 : 2

3 - 2 * 2
-1
```
