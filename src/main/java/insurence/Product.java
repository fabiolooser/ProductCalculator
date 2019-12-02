package insurence;

public class Product {
	private final int price;
	private final String name;
	private final ProductType type;
	
	public Product(int price, String name, ProductType type) {
		this.price = price;
		this.name = name;
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public ProductType getType() {
		return type;
	}
	
	public String getProductDescription() {
		String description = "Product: " + name;
		if(ProductType.Boat == type) {
			description += " YACHT";
		}
		
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
