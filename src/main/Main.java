package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import service.SupplierService;

/**
 * @author Perdana Erick Oktafianto
 * Date : 04 December 2017
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		HashMap<String, Integer> commandMapping = new HashMap<String, Integer>();
		SupplierService supplierService = new SupplierService();

		// Hash Map for CLI
		commandMapping.put("Create", 1);
		commandMapping.put("Insert", 2);
		commandMapping.put("Min", 3);
		commandMapping.put("Find", 4);
		commandMapping.put("Delete", 5);
		commandMapping.put("Show", 6);

		// Input for Manual input or INput from file
		System.out.print("[1] Manual input; [2] Input from File : ");
		String commandLine = reader.nextLine();
		String[] command = commandLine.split(" ");

		// If Manual Input
		if (commandLine.contains("1")) {
			commandLine = reader.nextLine();
			command = commandLine.split(" ");
			while (commandMapping.containsKey(command[0])) {

				switch (commandMapping.get(command[0])) {
				case 1:
					supplierService.createSupplier(Integer.valueOf(command[1]));
					break;

				case 2:
					supplierService.insertSupplier(command[1],
							Integer.valueOf(command[2]),
							Integer.valueOf(command[3]));
					break;

				case 3:
					if (command[1].contains("price")) {
						supplierService.getMinSupplierPrice();
					} else if (command[1].contains("latency")) {
						supplierService.getMinSupplierLatency();
					}
					break;

				case 4:
					supplierService.findSupplier((long) Integer
							.valueOf(command[1]));
					break;

				case 5:
					if (command[1].contains("Supplier")) {
						supplierService.deleteSupplierWithName(command[1]);
					} else {
						supplierService.deleteSupplierWithIndex(Integer
								.valueOf(command[1]));
					}
					break;

				case 6:
					supplierService.showSupplier();
					break;

				default:
					System.out.println("COMMAND NOT FOUND");
					break;
				}

				// For next action
				commandLine = reader.nextLine();
				command = commandLine.split(" ");
			}
			reader.close();

		// If Input From File
		} else {
			String inputLocation = "E:/input.txt";

			try {
				FileReader fileReader = new FileReader(inputLocation);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				String commandString;

				while ((commandString = bufferedReader.readLine()) != null) {
					String[] commandInput = commandString.split(" ");

					switch (commandMapping.get(commandInput[0])) {
					case 1:
						supplierService.createSupplier(Integer
								.valueOf(commandInput[1]));
						break;

					case 2:
						supplierService.insertSupplier(commandInput[1],
								Integer.valueOf(commandInput[2]),
								Integer.valueOf(commandInput[3]));
						break;

					case 3:
						if (commandInput[1].contains("price")) {
							supplierService.getMinSupplierPrice();
						} else if (commandInput[1].contains("latency")) {
							supplierService.getMinSupplierLatency();
						}
						break;

					case 4:
						supplierService.findSupplier((long) Integer
								.valueOf(commandInput[1]));
						break;

					case 5:
						if (commandInput[1].contains("Supplier")) {
							supplierService.deleteSupplierWithName(commandInput[1]);
						} else {
							supplierService.deleteSupplierWithIndex(Integer
									.valueOf(commandInput[1]));
						}
						break;

					case 6:
						supplierService.showSupplier();
						break;

					default:
						System.out.println("COMMAND NOT FOUND");
						break;
					}
				}
				bufferedReader.close();
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
