1. GameController
   - view (요청과 응답)
     - InputView (사용자 요청)
     - OutputView (요청 응답)
   - service (메인 로직)
     - BridgeMaker
   - 


메서드 (파라미터, 응답값)
파라미터는 로직을 처리하기 위해서 필요한 값
응답값은 로직을 처리하고 나온 값

메서드 명이랑 응답값이랑 일관성이 있게 만드는 것이 중요
예를 들어 메서드 명만 보고 어떤 값이 출력이 되겠다 라는 것을
예측할 수 있다면 좋은 메서드 명과 리턴 값을 지닌 것임

전체 아키텍쳐

**view -> controller -> service, domain**
view 에서 요청이 들어오면 controller 가 적절한 클래스를 찾아 연결 시켜주고
service 단에서는 domain 을 이용해 해당 요청에 관련된 로직을 처리해준다.
로직을 처리하면 다시 controller 로 보내 응답을 클라이언트 단으로 보낸다.

**Controller의 역할은?**
사용자 클라이언트의 요청과 응답을 처리하기 위해서
다른 로직 클래스를 적절히 사용하는 보드

1. ready (게임 준비)
    - view : 다리의 길이를 입력해주세요.
    - input (request) : 다리 길이 요청
    - output (response) : start 응답
   
2. start (메인 게임, 반복 구문 처리)
    - view : 이동할 칸을 선택해주세요. (위: U, 아래: D)
    - input (request) : 이동할 칸 입력 요청
    - output (response) : 
      1. 이동 후 결과 Map 응답 
      2. 이동 후 결과 성공 -> 게임 진행 응답 or 게임 끝 응답
      3. 이동 후 결과 실패 -> retry 응답

3. retry
    - view : 게임을 다시 시도할지 여부를 입력해주세요.
    - input (request) : 재시작 or 종료 요청
    - output (response) : 
      1. 재시작 요청 시 -> start 응답
      2. 종료 요청 시 -> finish 응답

4. finish
   - view : 최종 게임 결과
   