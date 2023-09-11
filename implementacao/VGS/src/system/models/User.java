package system.models;

public abstract class User {
	
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
	
	public abstract void showOptions();

	public void showMenu() {
		// É estranho mas faz sentido. Todos os usuários fazem logout
		// mas você precisa exibir pra eles opções diferentes de menu
		
		showOptions();
		
		System.out.println("0- Logout");
	}
	
}
