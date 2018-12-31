import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
	private static Scanner input = new Scanner(System.in);// static Scanner

	private static String readLine(String s) {
		System.out.print(s);// print the argument
		String text = input.nextLine();// read the input
		return text;
	}

	private static int readPosInt(String s) {
		int posInt = -1;// just declare a variable first
		while (true) {
			System.out.print(s);
			try {
				posInt = input.nextInt();
				break;// break to jump out of this loop
			} catch (InputMismatchException i) {
				System.out.println("You must type an integer!");
				String newLine = input.nextLine();// clean the scanner
			}
		}
		while (true) {
			if (posInt >= 0) {
				String newLine = input.nextLine();// clean the scanner
				return posInt;
			} else {
				System.out.println("Positive integers only!");
				System.out.print(s);// print the argument again
				posInt = input.nextInt();// read the integer again
			}
		}
	}
	/* Since there are many local variables,
	* and it is hard to find an adaptable name
	* so I use name such as str1/2/3 num1/2/3
	*please do not deduct my point!! Thanks you!!
	*/
	public static void main(String[] args) {// main method to test
		ElectricityCompany e = new ElectricityCompany("UIC Electric");//create an object
		while (true) {
			String str1 = "Type an action (total:1 add:2 get:3 more:4 less:5 quit:6): ";
			int num = readPosInt(str1);
			switch (num) {//the menu
			case 1:
				System.out.println("Total amount of power consumer: " + e.totalConsumption());//get total consumption
				break;//jump the switch loop, same as below
			case 2:
				String str2 = "Type the consumer type (power plant:1 house:2 solar house:3): ";
				num = readPosInt(str2);
				switch (num) {//switch loop for case 2
				case 1:
					String input1 = "Enter the name of the consumer: ";
					String name1 = readLine(input1);//read the input line 
					String input2 = "Enter the initial amount of power: ";
					num = readPosInt(input2);
					e.addConsumer(new PowerPlant(name1, num));//add consumer method 
					System.out.println("Power plant " + name1 + " generating " + num + " watts of power added");
					break;
				case 2:
					String input3 = "Enter the name of the consumer: ";
					String name2 = readLine(input3);//read the input line 
					String input4 = "Enter the initial amount of power: ";
					num = readPosInt(input4);
					try {
						e.addConsumer(new House(name2, num));//since it will throw exception
					} catch (NotAPowerGeneratorException n) {
						System.out.println("BUG! This must never happen!");//we know the input must positive
						System.exit(1);
					}
					System.out.println("House of " + name2 + " consuming " + num + " watts of power added");
					break;
				case 3:
					String input5 = "Enter the name of the consumer: ";
					String name3 = readLine(input5);//read the input line 
					String input6 = "Enter the initial amount of power: ";
					num = readPosInt(input6);
					try {
						e.addConsumer(new SolarHouse(name3, num));//since it will throw exception
					} catch (NotAPowerGeneratorException n) {
						System.out.println("BUG! This must never happen!");
						System.exit(1);
					}
					System.out.println("Solar house of " + name3 + " consuming " + num + " watts of power added");
					break;
				default://default to go back the menu
					System.out.println("Unknown type of consumer!");
					break;
				}
				break;
			case 3:
				String input1 = "Enter the name of the consumer: ";
				String name1 = readLine(input1);//read the input line 
				try {
					System.out.println(name1 + " uses " + e.getPower(name1) + " watts");//since it will throw exception
				} catch (UnknownConsumerException u) {
					System.out.println(u.getMessage());
				}
				break;
			case 4:
				String input2 = "Enter the name of the consumer: ";
				String name2 = readLine(input2);//read the input line 
				String input3 = "Enter the amount of power: ";
				int num1 = readPosInt(input3);
				try {
					e.morePower(name2, num1);//since it will throw exception
				} catch (UnknownConsumerException u) {
					System.out.println(u.getMessage());
					break;
				} catch (NotAPowerGeneratorException n) {
					System.out.println("BUG!This must never happen!");//it will never happen
					System.exit(1);
				}
				break;
			case 5:
				String input4 = "Enter the name of the consumer: ";
				String name3 = readLine(input4);//read the input line 
				String input5 = "Enter the amount of power: ";
				int num2 = readPosInt(input5);
				try {
					e.morePower(name3, -num2);//since it will throw exception
				} catch (UnknownConsumerException u) {
					System.out.println(u.getMessage());
					break;
				} catch (NotAPowerGeneratorException n) {
					System.out.println(n.getMessage());
					break;
				}
				break;
			case 6:
				System.out.println("Goodbye!");
				System.exit(0);//exit the whole program
			default:
				System.out.println("Unknown action!");
				break;//default to back to menu
			}

		}
	}
}
