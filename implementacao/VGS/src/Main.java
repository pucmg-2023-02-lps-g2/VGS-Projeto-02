import system.VGS;
import system.models.User;
import system.models.users.Regular;

public class Main {
	
    public static void main(String[] args) {
    	User c = new Regular("teste", "kkk");
		VGS.getInstance().loggedUser = c;
		VGS.getInstance().userMenu();
    }
}
