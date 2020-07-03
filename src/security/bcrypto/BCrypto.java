package security.bcrypto;

import org.mindrot.jbcrypt.BCrypt;

public class BCrypto {
	String password = "!@#$password1234";

	String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt(10));

	// ������ �ؽ��� ���� ��й�ȣ�� �����Ѵ�. ���� ��� true�� ��ȯ�Ѵ�.
	// �ַ� ȸ�� �α��� �������� ���ȴ�.
	boolean isValidPassword = BCrypt.checkpw(password, passwordHashed);
}
