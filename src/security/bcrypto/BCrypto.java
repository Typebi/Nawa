package security.bcrypto;

import org.mindrot.jbcrypt.BCrypt;

public class BCrypto {
	String password = "!@#$password1234";

	String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt(10));

	// 생성된 해쉬를 원래 비밀번호로 검증한다. 맞을 경우 true를 반환한다.
	// 주로 회원 로그인 로직에서 사용된다.
	boolean isValidPassword = BCrypt.checkpw(password, passwordHashed);
}
