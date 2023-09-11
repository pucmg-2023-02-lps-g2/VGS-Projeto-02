package system.models.users;

import system.models.User;

public class Agent extends User {

	public Agent(String username, String password) {
		super(username, password);
	}
	
	private void editOrder() {
		
	}
	
	private void rateOrder() {
		
	}

	@Override
	public void actOnOption(int option) {
		switch (option) {
		case 1:
			editOrder();
			break;

		case 2:
			rateOrder();
			break;
		}
	}

	@Override
	public void showMenu() {
		System.out.println("1- Editar pedido");
		System.out.println("2- Avaliar pedido");
	}
}
