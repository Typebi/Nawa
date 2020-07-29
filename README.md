# Nawa

**1주일동안 Team Project로 진행했던 MVC Web Application입니다.**

### 담당분야
- Log-in Part
- Sign-up part
  
### 세부 구현 내용
  
- 공통
  - Singleton pattern (Lazyholder) 적용
  
- OAuth
  - 소셜로그인(카카오) 구현

- 보안
  - Bcrypt로 비밀번호 암호화 (향후 Argon2 대체 예정)

- 간단한 Log System
  - 방문자 IP 기록(프록시 경유 고려)
  - 현재시간 기록(Calendar.class)
  - 동기화가 필요없으므로 StringBuffer 대신 StringBuilder 사용
  - 성능저하 고려 로그 최소화
  
- 회원가입
  - ID/PW 유효성 체크
  - ID 중복확인 AJAX를 통해 검증
    - 서버 부하 고려 Lazy Query (형식 불일치 시 Query 미실행)
  - 직렬화포맷 JSON
  - GSON Library 사용
    1. 저용량 단계 전송속도 준수
    2. 패키지 상대적 경량
  - Javascript 유효성 체크 경계
  
- 테스트 코드 작성 시도
  - I/O와 로직 분리 노력
  
- Primitive Obsession (원시적 강박) 탈피 노력
  - 새로운 타입(Email, Exception 등) 설계
  
- 객체지향적 프로그래밍 노력
  - 모델 - 뷰 - 컨트롤러 기능과 역할 분리
  
- 인터페이스 설계
  
