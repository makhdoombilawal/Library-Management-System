import java.util.*;
public class AdminPanel {
    private final String adminName = "Bilawal"; 
    private final int adminId = 11;    
	
	public int getId(){
		return adminId;
	}
	public boolean isValidAdmin(String name, int id) {
        return this.adminName.equalsIgnoreCase(name) && this.adminId == id;
    }
	
	public void displayAdminInfo() {
        System.out.println("Admin Name: " + adminName);
        System.out.println("Admin ID: " + adminId);
    }
}