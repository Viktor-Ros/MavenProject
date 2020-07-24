package framework.products;

public class Product {//Класс продукта

	private String name;
	private int price;
	private int garantPrice;
	private String description;
	
	public Product(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setGarantPrice(int garantPrice) {
		this.garantPrice = garantPrice;
	}
	
	public int getGarantPrice() {
		return garantPrice;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
}