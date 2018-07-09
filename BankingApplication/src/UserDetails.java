import java.io.*;

public class UserDetails {

	public UserDetails() {
		String username;
		String password;
		int dollars;
		int cents;
	}

	public UserDetails(String startUsername, String startPassword) {
		String username = startUsername;
		String password = startPassword;
		int dollars;
		int cents;
	}

	public static void createAccount(String username, String password) {
		String newUsername = username;
		String newPassword = password;
		File filename = new File("C:\\Users\\knewt\\Desktop\\Programming\\BankingApp\\BankingApplication\\src\\BankingAccounts\\"+username+".txt");
		try (FileWriter fw = new FileWriter(filename)){
			fw.write(newUsername + "; " + newPassword + "; Balance: 0.00");
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
