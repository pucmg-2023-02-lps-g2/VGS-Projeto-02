package system;

import java.util.Scanner;

import system.managers.UserManager;
import system.models.User;
import system.models.users.Regular;

public class VGS {
	
	public User loggedUser;
	private boolean executing = true;
	Scanner scanner = new Scanner(System.in);
	
	private static VGS instance = new VGS();
	
	public static VGS getInstance() {
		return instance;
	}
	
	private VGS() {}
	
	public void start() {
		while (executing) {
			try {
			System.out.println("Bem-vindo ao VGS!");
			System.out.println("");
			System.out.println("1- Cadastrar");
			System.out.println("2- Logar");
			System.out.println("");
			System.out.println("0- Encerrar");
			System.out.println("");
			
			int option = Integer.parseInt(scanner.nextLine());
			
			switch (option) {
				case 0:
					endExecution();
					break;
				case 1:
					registerMenu();
					break;
				case 2:
					loginMenu();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			// Pode acabar quebrando o loop e saindo pra fora, reavaliar depois
			} catch (NumberFormatException e) {
				System.out.println("Opção Inválida");
			}
		}
	}
	
	private void endExecution() {
		executing = false;
		
		UserManager.getInstance().saveUsers();
	}
	
	private void logout() {
		this.loggedUser = null;
	}
	
	private void loginMenu() {
		System.out.println("Por favor, insira suas credenciais: \n");
		
		System.out.println("Nome de Usuario: ");
		String username = scanner.nextLine();
		
		System.out.println("Senha: ");
		String password = scanner.nextLine();
		
		loginUser(username, password);
		
	}
	
	public void loginUser(String username, String password) {
		User user = UserManager.getInstance().findUserByUsername(username);
		
		if (user == null || !user.getPassword().equals(password)) {
			System.out.println("Nome de usuário ou senha incorretos");
			return;
		}
		
		this.loggedUser = user;
		
		userMenu();
	}
	
	public void userMenu() {
		while (this.loggedUser != null) {
			System.out.println("Bem-vindo " + this.loggedUser.getUsername() + "!");
			
			System.out.println("O que deseja fazer? \n");
			
			loggedUser.showMenu();
			
			System.out.println("\n0- Logout \n");
			
			int option = Integer.parseInt(scanner.nextLine());
		
			switch (option) {
			case 0:
				logout();
				break;
			default:
				this.loggedUser.actOnOption(option);
				break;
			}
		}
	}
	
	private void registerMenu() {
		System.out.println("Por favor, insira as credenciais que deseja registrar: \n");
		
		System.out.println("Nome de Usuario: ");
		String username = scanner.nextLine();
		
		// Talvez mover esse "if" para "registerUser"
		if (UserManager.getInstance().findUserByUsername(username) != null) {
			System.out.println("Esse nome de usuario já está sendo utilizado");
			return;
		}
		
		System.out.println("Senha: ");
		String password = scanner.nextLine();
		
		registerUser(username, password);
	}
	
	public void registerUser(String username, String password) {
		User user = new Regular(username, password);

		UserManager.getInstance().addNewUser(user);
		
		System.out.println("Usuário: \"" + username + "\" : \"" + password + "\" registrado!");
	}
}