package main;

import java.util.Scanner;

/* Class BinaryTree */
public class BinaryTreeMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of BT */
		BT bt = new BT();
		/* Perform tree operations */
		System.out.println("Binary Tree Test\n");

		char ch;
		do {
			System.out.println("\nBinary Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. check distance of nodes \n ");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert : \n");
				while (scan.hasNextInt()) {
					int dataToInsert = scan.nextInt();
					bt.insert(dataToInsert);
					System.out.println("Type 'y' to exit OR continue to enter numbers \n");
				}
				break;
			case 2:
				System.out.println(
						"Choose from 1 to " + (bt.maxDepth() - 1) + ", level to calculate distance of 2 nodes : \n");
				int level = scan.nextInt();
				if (level >= 1 && level <= bt.maxDepth()) {
					bt.printGivenLevel(level);
					System.out.println("Distance :" + getNodes(scan, bt, level));
				} else {
					System.out.println("Invalid input for level.");
				}
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}

			System.out.println("\n\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		scan.close();
	}

	private static int getNodes(Scanner scan, BT bt, int level) {
		System.out.println("\nEnter first node");
		int first = scan.nextInt();
		System.out.println("\nEnter second node");
		int second = scan.nextInt();
		return bt.findDistance(first, second, level);

	}
}