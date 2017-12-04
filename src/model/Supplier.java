package model;

public class Supplier {
	private String supplierName;
	private long price;
	private int latency;

	public Supplier(String supplierName, long price, int latency) {
		super();
		this.supplierName = supplierName;
		this.price = price;
		this.latency = latency;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getLatency() {
		return latency;
	}

	public void setLatency(int latency) {
		this.latency = latency;
	}

	public void printSupplierAttribut() {
		System.out.print(" " + supplierName);
		System.out.print(" " + price);
		System.out.println(" " + latency);
	}
}
