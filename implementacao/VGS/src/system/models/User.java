package system.models;

import java.util.Scanner;

public abstract class User {
	
	Scanner scanner = new Scanner(System.in);
	
	String username, password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	// Cuidado ao implementar esses metodos. "0" é a opção de logout
	public abstract void actOnOption(int option);

	public abstract void showMenu();
}
