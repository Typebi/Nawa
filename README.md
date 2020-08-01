# Nawa

**일주일동안 Team Project로 진행했던 MVC Web Application입니다.**

### 담당분야
- Log-in Part
- Sign-up part
  
### 세부 구현 내용
  
- 공통
  - 프레임워크 미사용
  - Singleton pattern (Lazyholder) 적용
  
- OAuth
  - 소셜로그인(카카오) 구현

- 보안
  - Bcrypt로 비밀번호 암호화 (Argon2로 마이그레이션 예정)

- 간단한 Log System
  - 방문자 IP(프록시 경유 고려), 행동 기록
  - 현재시간 기록
  - StringBuilder 사용으로 코스트 최소화(Thread safe 하므로)
  - 성능저하 고려 로그 내용 최소화
  
- 회원가입
  - ID/PW 유효성 체크
  - ID 중복확인 AJAX를 통해 검증
    - 서버 부하 고려 Lazy Query (email 형식 일치 시에만 Query 실행)
  - 직렬화포맷 JSON
  - GSON Library 사용
    1. 타 Library 대비 저용량 단계 전송속도 준수
    2. 패키지가 상대적으로 경량
  - Javascript 유효성 체크 경계
    1. Javascript 브라우저에서 일부 핸들링 할 수 있으므로, 반드시 서버에서의 유효성 체크 병행
  
- 테스트 코드 작성 시도
  - 테스트 코드의 유용성 경험
  - 좋은 테스트 코드를 위해 I/O와 로직 분리 노력
  
- Primitive Obsession (원시적 강박) 탈피 노력
  - 새로운 타입(Email, Exception 등) 설계
  - 인터페이스 설계
  
- 객체지향적 프로그래밍 노력
  - 모델 - 뷰 - 컨트롤러 기능과 역할 분리
  
- 인터페이스 설계
  - 타입 캐스팅 적극 활용
