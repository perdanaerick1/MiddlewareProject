package service;

import java.util.ArrayList;
import java.util.List;

import model.Supplier;

/**
 * @author Perdana Erick Oktafianto
 * Date : 04 December 2017
 *
 */
public class SupplierService {
	List<Supplier> listOfSupplier = new ArrayList<>();

	/**
	 * For Create Supplier
	 * @param maxArray
	 */
	public void createSupplier(Integer maxArray) {
		System.out.println("created " + maxArray + " spaces for suppliers");
		for (int i = 0; i < maxArray; i++) {
			Supplier supplier = new Supplier(null, 0, 0);
			listOfSupplier.add(supplier);
		}
	}

	/**
	 * For Insert Supplier
	 * @param supplierName
	 * @param price
	 * @param latency
	 */
	public void insertSupplier(String supplierName, long price, int latency) {
		boolean status = true;// for insert or not
		for (int i = 0; i < listOfSupplier.size(); i++) {
			if (listOfSupplier.get(i).getSupplierName() == null) {
				listOfSupplier.get(i).setSupplierName(supplierName);
				listOfSupplier.get(i).setPrice(price);
				listOfSupplier.get(i).setLatency(latency);
				System.out.println("inserted as supplier " + ++i);
				status = true;
			} else {
				status = false;
			}

			if (status) {
				break;
			}
		}

		// if listOfSupplier has full of supplier
		if (!status || listOfSupplier.size() == 0) {
			System.out.println("cannot insert, spaces are fully occupied");
		}
	}

	/**
	 * For Get Min Supplier from Price
	 */
	public void getMinSupplierPrice() {
		long price = 0;
		Supplier supplierMin = new Supplier(null, 0, 0);
		for (Supplier supplier : listOfSupplier) {
			if (supplier.getSupplierName() != null) {
				price = supplier.getPrice();
				supplierMin = new Supplier(supplier.getSupplierName(),
						supplier.getPrice(), supplier.getLatency());
			}
			break;
		}

		for (Supplier supplier : listOfSupplier) {
			if (supplier.getSupplierName() != null) {
				if (price > supplier.getPrice()) {
					price = supplier.getPrice();
					supplierMin = new Supplier(supplier.getSupplierName(),
							supplier.getPrice(), supplier.getLatency());
				}
			}
		}

		System.out.println(supplierMin.getSupplierName() + " "
				+ supplierMin.getPrice() + " " + supplierMin.getLatency());
	}

	/**
	 * For Get Min Supplier from Latency
	 */
	public void getMinSupplierLatency() {
		int latency = 0;
		Supplier supplierMin = new Supplier(null, 0, 0);
		for (Supplier supplier : listOfSupplier) {
			if (supplier.getSupplierName() != null) {
				latency = supplier.getLatency();
				supplierMin = new Supplier(supplier.getSupplierName(),
						supplier.getPrice(), supplier.getLatency());
			}
			break;
		}

		for (Supplier supplier : listOfSupplier) {
			if (supplier.getSupplierName() != null) {
				if (latency > supplier.getLatency()) {
					latency = supplier.getLatency();
					supplierMin = new Supplier(supplier.getSupplierName(),
							supplier.getPrice(), supplier.getLatency());
				}
			}
		}

		System.out.println(supplierMin.getSupplierName() + " "
				+ supplierMin.getPrice() + " " + supplierMin.getLatency());
	}

	/**
	 * For Find Supplier
	 * @param price
	 */
	public void findSupplier(long price) {
		System.out.println("index \t" + "Supplier name \t" + "price \t"
				+ "latency");
		Integer index = 1;
		for (int i = 0; i < listOfSupplier.size(); i++) {
			if (listOfSupplier.get(i).getSupplierName() != null
					&& listOfSupplier.get(i).getPrice() <= price) {
				System.out.println(index++ + "\t"
						+ listOfSupplier.get(i).getSupplierName() + "\t \t"
						+ listOfSupplier.get(i).getPrice() + "\t"
						+ listOfSupplier.get(i).getLatency());
			}
		}
	}

	/**
	 * For Delete Supplier with Name Supplier
	 * @param supplierName
	 */
	public void deleteSupplierWithName(String supplierName) {
		for (int i = 0; i < listOfSupplier.size(); i++) {
			if (listOfSupplier.get(i).getSupplierName().contains(supplierName)) {
				listOfSupplier.get(i).setSupplierName(null);
				listOfSupplier.get(i).setPrice(0);
				listOfSupplier.get(i).setLatency(0);
			}
		}
		System.out.println(supplierName + " deleted");
	}

	/**
	 * For Delete Supplier with Index
	 * @param index
	 */
	public void deleteSupplierWithIndex(Integer index) {
		String supplierName = listOfSupplier.get(index - 1).getSupplierName();
		listOfSupplier.get(index - 1).setSupplierName(null);
		listOfSupplier.get(index - 1).setPrice(0);
		listOfSupplier.get(index - 1).setLatency(0);
		System.out.println(supplierName + " deleted");
	}

	public void showSupplier() {
		System.out.println("index \t" + "Supplier name \t \t" + "price \t"
				+ "latency");
		Integer index = 1;
		for (int i = 0; i < listOfSupplier.size(); i++) {
			if (listOfSupplier.get(i).getSupplierName() != null) {
				System.out.println(index++ + "\t"
						+ listOfSupplier.get(i).getSupplierName() + "\t \t"
						+ listOfSupplier.get(i).getPrice() + "\t"
						+ listOfSupplier.get(i).getLatency());
			}
		}
	}
}
