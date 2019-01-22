import java.util.Scanner;
import com.zubiri.user.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Interface {

	public static void main(String[] args) throws IOException {
		Users users = new Users();
		User user = new User();
		Scanner sc = new Scanner(System.in);
		boolean play = true;
		File file = new File("userData.txt");

		FileWriter write = new FileWriter(file, true);
		
		while (play == true) {
			System.out.println("1.- Register");
			System.out.println("2.- Login");
			System.out.println("3.- Quit");

			String option = sc.next();

			switch (option) {

			default:
				System.out.println("Please enter a valid option");
				break;

			case "1":
				System.out.println("Enter a username:");
				String username = sc.next();
				System.out.println("Enter a password");
				String password = sc.next();

				boolean userverify = user.checkName(username);
				boolean passverify = user.checkPassword(password);

				if (userverify == true && passverify == true) {
					User regis = new User();
					regis.setName(username);
					regis.setPassword(password);
					write.append(username + " " + password + System.getProperty("line.separator"));
					write.flush();
					System.out.println("Properly registered");
				} else {
					if (userverify = false) {
						System.out.println("Incorrect username. It must be just letters");
					}

					else {
						System.out.println(
								"Incorrect password. It must be minimum 8 characters and content letters, digits and symbols");
					}
				}
				break;

			case "2":
				System.out.println("Enter the username:");
				username = sc.next();
				System.out.println("Enter the password");
				password = sc.next();
				boolean login=false;
				Scanner sc2 = new Scanner(file);

				while (sc2.hasNextLine()) {
					
					String[] data = sc2.nextLine().split(" ");
					
					if (data[0].equals(username) && data[1].equals(password)) {
						
						login=true;
					}
					

				}

				if (login == false) {
					System.out.println("Incorrect combination");
				} else {
					System.out.println("Welcome " + username);
					boolean flag = true;
					while (flag) {
						System.out.println("What do you want to do?");
						System.out.println("1.- LogOut");

						switch (sc.next()) {
						default:
							System.out.println("Enter a valid option");
							break;

						case "1":

							System.out.println("Bye " + username + "!");
							flag = false;
							break;

						}
					}
				}
				break;

			case "3":
				System.out.println("Bye!");
				play = false;
				break;
			}
		}
	}
}
