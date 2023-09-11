package system.models.users;

import system.models.User;

public class Regular extends User {

	public Regular(String username, String password) {
		super(username, password);
	}
	
	private void gerenciarPedido() {
		
	}

	@Override
	public void actOnOption(int option) {
		switch (option) {
		case 1:
			gerenciarPedido();
			break;
		}
	}
	
	@Override
	public void showMenu() {
		System.out.println("1- Gerenciar Pedido");
	}
}
