package userManagement.domain;

import userManagement.exceptions.*;

public class Test {
	void email() {
		String value = "a@a.a";
		if (value.matches("^[a-zA-Z0-9]++@+[a-zA-Z0-9]++.+[a-zA-Z]+$")){
			//^[a-zA-Z0-9]{1,10}+@[a-zA-Z0-9]{1,15}$
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	void pwd() {
		String value = "123!!aaaaaaaa";
		if (value.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,20}$")){
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	void nick() {
		String value = "";
		if (value.matches("^[��-�Ra-zA-Z0-9]{2,8}$")){
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	void run() {
		//email();
		//pwd();
		//nick();
		try {
			new Email("a@a.a");
			new Pwd("123!!aaaaaaaa");
			new Nick("12312");
		}catch(EmailException e) { System.out.println("Email ��ü���� ����");
		}catch(PwdException e) { System.out.println("Pwd ��ü���� ����");
		}catch(NickException e) { System.out.println("Nick ��ü���� ����");
		}
	}
	public static void main (String ars[]) {
		new Test().run();
	}
}