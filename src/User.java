
public class User {
	final static String country="Palestine";
	private String username;
	private String password;
	private String city;
	public User() {
		
	}
	public User(String username, String password, String city) {
		this.username = username;
		this.password = password;
		this.city = city;
	}
	public static String getCountry() {
		return country;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getCity() {
		return city;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return username+ " " + password + " "+city+ " " + country + "\n";
	}
}
