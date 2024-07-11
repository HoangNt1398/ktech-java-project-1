# K-Tech 프로제트
## TODO Application 만들기
터미널 출력으로, 사용자에게 선택지를 보여주고, 사용자는 해당 선택지를 확인하고 동작을 텍스트로 전달하는 방식으로 동작하는 텍스트 기반 애플리케이션을 만들어보자.
### Simple TODO
내가 할일을 기록하고, 해당 할일을 다 했다고 표시할 수 있는 TODO List 애플리케이션을 만들어보자.
#### 첫 화면
프로그램을 시작하면 나오는 출력이다.
```bash
Welcome!

You have no more TODOs left!!!

1. Create TODO
2. Edit TODO
3. Finish TODO
4. Delete TODO
5. Exit

Input: 
```
이때, 사용자의 커서는 `Input:`  뒤에 머물러 사용자 입력을 대기한다.

만약 이미 만들어진 TODO가 있다면 다음과 같이 출력이 바뀐다.
```bash
Welcome!

You have 2 TODOs left.

1. Do dishes
2. Throw out trash (Done)
3. Study for exam

1. Create TODO
2. Edit TODO
3. Finish TODO
4. Delete TODO
5. Exit

Input: 
```
 
이때 TODO의 순서는 만들때 제공한 기한을 빠른 날짜부터 정렬한 것이며,
다한 TODO는 오른쪽에 (Done)이 붙는다. 또한 만들어진 TODO가 없거나 목록의 모든 TODO가 (Done)이 된다면, You have no more TODOs left!!!, 하나의 TODO가 (Done)이 아니면 You have 1 TODO left., 두개 이상의 TODO가 (Done)이 아니면 You have <남은 갯수> TODOs left.를 출력한다. 또한, 기한이 현재 날짜보다 이르면서 완료한 TODO의 경우 목록에 나오지 않는다.
#### 종료하기
첫 화면에서 5를 입력하면 애플리케이션이 종료된다.
#### TODO 만들기
`첫 화면`에서 `1`을 입력하면 다음의 순서로 TODO를 새로 만든다.

1. TODO 제목 입력
2. 기한을 `yyyy-mm-dd` 순으로 입력
3. 잘 입력되면 `Saved!!!` 출력

아래는 예시로 검은색 글씨는 출력, 초록색 글씨는 사용자 입력이다.
```bash
Title: Study Java Stream
Until: 2024-07-22
Saved!!!
```
이후 다시 첫 화면으로 돌아간다.

#### TODO 수정하기
첫 화면에서 2를 입력하면 다시 TODO 번호를 입력한다. 없는 번호의 경우 첫 화면으로 이동한다. 아래는 예시이다.
```bash
 Edit TODO number: 1
```
이후 다음의 순서로 TODO를 수정한다.

1. TODO 제목 입력
2. 기한을 `yyyy-mm-dd` 순으로 입력
3. 잘 입력되면 `Saved!!!` 출력
4. 입력이 비어있을 경우 해당 항목은 수정하지 않는다.

아래는 예시로 검은색 글씨는 출력, 초록색 글씨는 사용자 입력이다.

```bash
Title: Study Database
Until: 
Saved!!!
```

이후 1번 TODO의 내용이 Study Database로 변경되며, 날짜는 변경되지 않는다. 이후 첫 화면으로 이동한다.
#### TODO 완료하기
첫 화면에서 3를 입력하면 다시 TODO 번호를 입력한다. 없는 번호의 경우 첫 화면으로 이동한다. 아래는 예시이다.
```bash
Finish TODO number: 1
```
이후 해당 TODO는 완료 상태가 되고, 첫 화면으로 이동한다. 완료상태가 된 TODO는 첫 화면에서 (Done)이 표시된다.

```bash
Welcome!

You have 1 TODO left.

1. Do dishes (Done)
2. Throw out trash (Done)
3. Study for exam

1. Create TODO
2. Edit TODO
3. Finish TODO
4. Delete TODO
5. Exit

Input: 
```
#### TODO 삭제하기
첫 화면에서 4를 입력하면 다시 TODO 번호를 입력한다. 없는 번호의 경우 첫 화면으로 이동한다. 아래는 예시이다.
```bash
Delete TODO number: 3
```
이후 해당 TODO는 삭제 되고, 첫 화면으로 이동한다. 삭제된 TODO는 첫 화면에 보이지 않는다.
```bash
Welcome!

You have no more TODOs left!!!

1. Do dishes (Done)
2. Throw out trash (Done)

1. Create TODO
2. Edit TODO
3. Finish TODO
4. Delete TODO
5. Exit

Input: 
```

#### 공통 요구사항
TODO가 남은 상태로 프로그램을 종료, 재시작할 경우 해당 TODO를 여전히 확인할 수 있다.

각 기능을 실행할 때, 사용자가 적절한 입력을 진행할 수 있도록 출력을 자유롭게 구성할것.

사용자가 입력한 내용이 허용되지 않은 내용(없는 번호 고르기, 잘못된 날짜 입력 등)이라면, 해당 메시지를 보여주고 이전 메시지를 다시 출력해준다.
#### 기타 참고사항
1. TODO 목록을 출력할 때, 반드시 숫자가 `1.` 부터 시작할 필요는 없습니다.
2. 파일 입출력 과정을 제외한 `IOException`은 발생했을 때 무시하여도 상관 없습니다.
3. `Scanner` 또는 `BufferedReader`를 사용할 때 `System.in`을 여러번 사용하면 생각한데로 동작하지 않을 수 있습니다.
4. 코드를 한 클래스에 만들기보단, 데이터를 읽고 쓰고, 사용자에게 입력을 요구하고, 그들의 기능을 적당한 시점에 실행하는 클래스를 별도로 만드는 것을 고려해보세요.

## 시택
* Java 8 LTS
## 실행
1.본 Repository 를 clone 받는다.

2.Intellij IDEA를 이용해 clone 받은 풀더를 연다.

3.[Main.java](https://github.com/HoangNt1398/ktech-java-project-1/blob/main/src/vn/hoangnt/Main.java)의 `main`을 실행한다.

## 완수한 요구사항
- [x]  첫 화면
- [x]  종료하기
- [x]  TODO 만들기
- [x]  TODO 수정하기
- [x]  TODO 완료하기
- [x]  TODO 삭제하기
- [x]  재시작해도 TODO 유지
- [x]  오류 입력에 대한 대응