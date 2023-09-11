package system.models.users;

import java.util.Scanner;

import system.models.User;

public class Regular extends User {

	public Regular(String username, String password) {
		super(username, password);
	}

	@Override
	public void showOptions() {
		System.out.println("1- oi");
		String s = new Scanner(System.in).nextLine();
	}
	
}
