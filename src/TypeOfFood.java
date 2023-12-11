
public class TypeOfFood {
	private String type;
	public TypeOfFood() {
		
	}
	public TypeOfFood(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
	@Override
	public String toString() {
		return type + "\n";
	}
}
