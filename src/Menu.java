import javafx.scene.image.Image;

public class Menu extends TypeOfFood{
	private String name;
	private	double calories;
	private	double price;
	private String path;
	String description;
	public Menu() {
		
	}
	public Menu(String name, String type, double calories, double price, String path, String description) {
		super(type);
		this.name = name;
		this.calories = calories;
		this.price = price;
		this.path = path;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public double getCalories() {
		return calories;
	}
	public double getPrice() {
		return price;
	}
	public String getPath() {
		return path;
	}
	public String getDescription() {
		return description;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Name of food: " + name + "\nType of food: " + super.getType() + "\nThe calories: " + calories + "\nThe price: " + price + "$\nThe description of food:\n" + description;
	}
	public String toBill() {
		return name + "                                " + price + "$\n";
	}
	public String toFileBill() {
		return name + "," + calories + "," + price + "," + path + "," + description + "\n";
	}
}
