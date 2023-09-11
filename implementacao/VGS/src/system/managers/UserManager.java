package system.managers;

import java.util.ArrayList;
import java.util.List;

import system.models.User;

public class UserManager {
	
	private static List<User> users = new ArrayList<>();
	private static UserManager instance = new UserManager();
	
	public static UserManager getInstance() {
		return instance;
	}
	
	private UserManager() {
		loadUsers();
	}
	
	public void addNewUser(User user) {
		users.add(user);
	}
	
	public User findUserByUsername(String username) {
		return users.stream()
				.filter(user -> user.getUsername().equals(username))
				.findFirst()
				.get();
		// Talvez seja melhor não gerar uma exception aqui e verificar onde o método é chamado
		// se "User" não é "null". Ter que usar "try catch" em algumas partes polui muito.
		// Então, melhor dar "throw" na exception onde o método for chamado e "user == null"
//				.orElseThrow(() -> new UserNotFoundException(username));
	}
	
	public void loadUsers() {
		
	}
	
	public void saveUsers() {
		
	}
	
}
