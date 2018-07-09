import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {

	public static void initialConnect() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please login to continue, or create a new account. (login / create)");
		String loggingIn = sc.nextLine();
		
		if (loggingIn.equals("login") || loggingIn.equals("create")) {
		while (loggingIn.equals("login") || loggingIn.equals("create")) {
			String loginUsername, loginPassword, loginPasswordCheck = "";
			System.out.print("Username: ");
			loginUsername = sc.nextLine();
			String path = "C:\\Users\\knewt\\Desktop\\Programming\\BankingApp\\BankingApplication\\src\\BankingAccounts\\"
					+ loginUsername + ".txt";
			File f = new File(path);
			System.out.print("Password: ");
			loginPassword = sc.nextLine();

			if (loggingIn.equals("create")) {
				System.out.print("Repeat Password: ");
				loginPasswordCheck = sc.nextLine();
				if (!loginPassword.equals(loginPasswordCheck)) {
					System.out.println("Passwords do not match.");
					loggingIn = "Complete";
				} else if (f.exists()) {
					System.out.println("Username already in use.");
					loggingIn = "Complete";
					break;
				} else {
					f.getParentFile().mkdirs();
					try {
						f.createNewFile();
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					try (FileWriter fw = new FileWriter(path)) {
						fw.write(loginUsername + "; " + loginPassword + "; Balance: 0.00");
						fw.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					System.out.println("Account creation successful.  Please log in again.");
				}
				break;
			} else {
				if (loggingIn.equals("login")) {
					// Check the database to see if the account exists
					if (f.exists()) {
						System.out.println("This account exists!");
						// check to see if password is the same as in the file.
						// If password is the same, call function to successfully log in.

					} else {
						System.out.println("Account was not found.");
						loggingIn = "Complete";
					}
				} else {
					// The only other option is "create", so create a new account in .UserDetails

					UserDetails.createAccount(loginUsername, loginPassword);
					loggingIn = "Complete";
				}
			}

		}
		sc.close();
	}
		else {
			System.out.println("Invalid input");
		}
	}
}
