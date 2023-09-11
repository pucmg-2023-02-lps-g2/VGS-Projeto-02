package system.exceptions;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String username) {
		super("Usuário \"" + username + "\" não foi encontrado");
	}

}
