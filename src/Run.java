import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ForkJoinTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Run extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {	
		// Create file of User
		File userFile = new File("User.txt");
		PrintWriter print = new PrintWriter(userFile);
		print.print("anas 123 Jerusalem Palestine\r\n"
				+ "saja 234 Hebron Palestine\r\n"
				+ "jihan 658 Ramallah Palestine\r\n"
				+ "nadine 965 Bethlehem Palestine\r\n"
				+ "nour 658 Hebron Palestine\r\n"
				+ "mohamad 562 Hebron Palestine\r\n"
				+ "renad 2003 Jerusalem Palestine\r\n"
				+ "rami 5625 Bethlehem Palestine\r\n"
				+ "sama 5632 Ramallah Palestine\r\n"
				+ "bisan 6252 Jerusalem Palestine\r\n"
				+ "razan 5641 Hebron Palestine\r\n"
				+ "ahmad 5258 Bethlehem Palestine");
		print.close();
		Scanner scannerUserFile = new Scanner(userFile);
		ArrayList<String> listOfString = new ArrayList<String>();
		while(scannerUserFile.hasNextLine()) {
			String data= scannerUserFile.next();
			 String[] array = data.split(" ");
			ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
			for (int i = 0; i < list.size(); i++) {
				listOfString.add(list.get(i));
			}
			}
		ArrayList<User> userList = new ArrayList<User>();
		for (int i = 0; i < listOfString.size()-1; i=i+4) {
			User user = new User();
			user.setUsername(listOfString.get(i));
			user.setPassword(listOfString.get(i+1));
			user.setCity(listOfString.get(i+2));
			userList.add(user);
		}
		//Create file of type of food
		File fileOfType = new File("Type.txt");
		PrintWriter print1 = new PrintWriter(fileOfType);
		print1.print("Seafood\r\n"
				+ "meat\r\n"
				+ "Fast food\r\n"
				+ "Mexican food\r\n"
				+ "Chinese food\r\n"
				+ "drinks");
		print1.close();
		Scanner scannerTypeOfFood = new Scanner(fileOfType);
		ArrayList<TypeOfFood> listTypeOfFood = new ArrayList<TypeOfFood>();
		while(scannerTypeOfFood.hasNextLine()) {
			TypeOfFood type = new TypeOfFood();
			type.setType(scannerTypeOfFood.nextLine());
			listTypeOfFood.add(type);
			}
		//Create file for the sea-food menu
		File fileOfSeafood = new File("Seafood.txt");
		PrintWriter printSeafood = new PrintWriter(fileOfSeafood);
		printSeafood.print("Sauce Crab,300,20,Sauce Crab.jpg,Saute shellfish in butter. Add white sauce and season with salt and pepper\r\n"
				+ "Squid Fried shrimp,350,30,Squid Fried shrimp.jpg,Shrimp-squid-curry powder-dijon mustard\r\n"
				+ "Rica-rica Green Scallops,400,35,Rica-rica Green Scallops.jpg,Butternut squash-brussels sprouts-sea scallops-balsamic\r\n"
				+ "Grilled Shrimp,200,25,Grilled Shrimp.jpg,Shrimp-soy sauce-chili garlic sauce-honey-olive oil");
		printSeafood.close();
		Scanner scannerSeafood = new Scanner(fileOfSeafood);
		ArrayList<String> listOfSeafoodString = new ArrayList<String>();
		while(scannerSeafood.hasNextLine()) {
				String data= scannerSeafood.nextLine();
				 String[] array = data.split(",");
				ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
				for (int i = 0; i < list.size(); i++) {
					listOfSeafoodString.add(list.get(i));
				}
		}
		ArrayList<Menu> MenuSeafood = new ArrayList<Menu>();
		for (int i = 0; i < listOfSeafoodString.size()-1; i=i+5) {
			Menu menu = new Menu();
			menu.setName(listOfSeafoodString.get(i));
			Double calories = new Double(listOfSeafoodString.get(i+1));
			menu.setCalories(calories);
			Double price = new Double(listOfSeafoodString.get(i+2));
			menu.setPrice(price);	
			menu.setPath(listOfSeafoodString.get(i+3));
			menu.setDescription(listOfSeafoodString.get(i+4));
			menu.setType(listTypeOfFood.get(0).getType());
			MenuSeafood.add(menu);
		}
		//Create file of the menu of meat
		File fileOfmeat = new File("meat.txt");
		PrintWriter printmeat = new PrintWriter(fileOfmeat);
		printmeat.print("Stuffed Flank Steak,120,50,StuffedFlankSteak.jpg,Flank steak-red wine vinegar-red bell peppers-parmesan\r\n"
				+ "Mutton Vadai,250,20,Mutton Vadai.jpg,Chana dal- mutton- garam masala powder-black gram\r\n"
				+ "Lamb Chops,200,35,Lamb Chops.jpg,Lamb chops-rosemary-olive oil-black pepper\r\n"
				+ "Country Ribs,150,30,Country Ribs.jpg,Country style ribs-apple cider vinegar-purple cabbage-pear");
		printmeat.close();
		Scanner scannermeat = new Scanner(fileOfmeat);
		ArrayList<String> listOfmeat = new ArrayList<String>();
		while(scannermeat.hasNextLine()) {
				String data= scannermeat.nextLine();
				 String[] array = data.split(",");
				ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
				for (int i = 0; i < list.size(); i++) {
					listOfmeat.add(list.get(i));
				}
		}
		ArrayList<Menu> MenuOfMeat = new ArrayList<Menu>();
		for (int i = 0; i < listOfSeafoodString.size()-1; i=i+5) {
			Menu menu = new Menu();
			menu.setName(listOfmeat.get(i));
			Double calories = new Double(listOfmeat.get(i+1));
			menu.setCalories(calories);
			Double price = new Double(listOfmeat.get(i+2));
			menu.setPrice(price);	
			menu.setPath(listOfmeat.get(i+3));
			menu.setDescription(listOfmeat.get(i+4));
			menu.setType(listTypeOfFood.get(1).getType());
			MenuOfMeat.add(menu);
		}
		//Create file of the menu of Fast Food
				File fileOfFastFood = new File("Fast Food.txt");
				PrintWriter printFastFood = new PrintWriter(fileOfFastFood);
				printFastFood.print("Cheese Burger,373,22,Cheese Burger.jpg,Fed ground beef-pickle juice-sweet hawaiian buns-cheddar\r\n"
						+ "Original Pizza,355,20,Original Pizza.jpg,Topped with mozzarella-ground beef-mushroom-jalapeno\r\n"
						+ "Honey Chicken,277,15,Honey Chicken.jpg,Grilled chicken combined with house special spicy\r\n"
						+ "Fried Oysters,198,17,Fried Oysters.jpg,Fried oysters with horseradish cocktail sauce");
				printFastFood.close();
				Scanner scannerFastFood = new Scanner(fileOfFastFood);
				ArrayList<String> listOfFastFood = new ArrayList<String>();
				while(scannerFastFood.hasNextLine()) {
						String data= scannerFastFood.nextLine();
						 String[] array = data.split(",");
						ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
						for (int i = 0; i < list.size(); i++) {
							listOfFastFood.add(list.get(i));
						}
				}
				ArrayList<Menu> MenuOfFastFood = new ArrayList<Menu>();
				for (int i = 0; i < listOfFastFood.size()-1; i=i+5) {
					Menu menu = new Menu();
					menu.setName(listOfFastFood.get(i));
					Double calories = new Double(listOfFastFood.get(i+1));
					menu.setCalories(calories);
					Double price = new Double(listOfFastFood.get(i+2));
					menu.setPrice(price);	
					menu.setPath(listOfFastFood.get(i+3));
					menu.setDescription(listOfFastFood.get(i+4));
					menu.setType(listTypeOfFood.get(2).getType());
					MenuOfFastFood.add(menu);
				}
				//Create file of the menu of Mexican food
				File fileOfMexicanfood = new File("Mexican food.txt");
				PrintWriter printMexicanfood = new PrintWriter(fileOfMexicanfood);
				printMexicanfood.print("Black Bean Burrito,240,20,Black Bean Burrito.jpg,onions-bell peppers and jalapenos are heated in a skillet\r\n"
						+ "Vegetarian Casserole,421,50,Vegetarian Casserole.jpg,soy burger style crumbles-tomatoes-rice \r\n"
						+ "Mexican Mahi,222,30,Mexican Mahi.jpg,Mahi Mahi-avocado serrano salsa-lime herb butter-shrimp-guacamole-mexican or cilantro rice-spicy black beans\r\n"
						+ "Chimichurri steak,213,26,Chimichurri steak.jpg,Skirt Steak-homemade chimichurri sauce-served with fresh salad-mexican rice-spicy refried beans");
				printMexicanfood.close();
				Scanner scannerMexicanfood = new Scanner(fileOfMexicanfood);
				ArrayList<String> listOfMexicanfood = new ArrayList<String>();
				while(scannerMexicanfood.hasNextLine()) {
						String data= scannerMexicanfood.nextLine();
						 String[] array = data.split(",");
						ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
						for (int i = 0; i < list.size(); i++) {
							listOfMexicanfood.add(list.get(i));
						}
				}
				ArrayList<Menu> MenuOfMexicanfood = new ArrayList<Menu>();
				for (int i = 0; i < listOfMexicanfood.size()-1; i=i+5) {
					Menu menu = new Menu();
					menu.setName(listOfMexicanfood.get(i));
					Double calories = new Double(listOfMexicanfood.get(i+1));
					menu.setCalories(calories);
					Double price = new Double(listOfMexicanfood.get(i+2));
					menu.setPrice(price);	
					menu.setPath(listOfMexicanfood.get(i+3));
					menu.setDescription(listOfMexicanfood.get(i+4));
					menu.setType(listTypeOfFood.get(3).getType());
					MenuOfMexicanfood.add(menu);
				}
				//Create file of the menu of Chinese food
				File fileOfChinesefood = new File("Chinesefood.txt");
				PrintWriter printChinesefood = new PrintWriter(fileOfChinesefood);
				printChinesefood.print("Siu mai,122,45,Siu mai.jpg,These dumplings are not sealed and have a cup-like appearance so you can see the minced pork or prawn filling inside\r\n"
						+ "Pai gwut,145,40,Pai gwut.jpg,It consists of steamed pork ribs.The pork rib tips are steamed with oil and while black beans\r\n"
						+ "Spring Rolls,133,48,Spring Rolls.jpg,A crisp appetizer where shredded veggies are encased in thin sheets and then fried golden\r\n"
						+ "Stir Fried Tofu with Rice,345,32,Stir Fried Tofu with Rice.jpg,A simple stir-fry with tofu and oriental sauces");
				printChinesefood.close();
				Scanner scannerChinesefood = new Scanner(fileOfChinesefood);
				ArrayList<String> listOfChinesefood = new ArrayList<String>();
				while(scannerChinesefood.hasNextLine()) {
						String data= scannerChinesefood.nextLine();
						 String[] array = data.split(",");
						ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
						for (int i = 0; i < list.size(); i++) {
							listOfChinesefood.add(list.get(i));
						}
				}
				ArrayList<Menu> MenuOfChinesefood = new ArrayList<Menu>();
				for (int i = 0; i < listOfChinesefood.size()-1; i=i+5) {
					Menu menu = new Menu();
					menu.setName(listOfChinesefood.get(i));
					Double calories = new Double(listOfChinesefood.get(i+1));
					menu.setCalories(calories);
					Double price = new Double(listOfChinesefood.get(i+2));
					menu.setPrice(price);	
					menu.setPath(listOfChinesefood.get(i+3));
					menu.setDescription(listOfChinesefood.get(i+4));
					menu.setType(listTypeOfFood.get(4).getType());
					MenuOfChinesefood.add(menu);
				}
				//Create file of the menu of drinks
				File fileOfdrinks = new File("drinks.txt");
				PrintWriter printdrinks = new PrintWriter(fileOfdrinks);
				printdrinks.print("Margarita,45,15,Margarita.jpg,Tequila-Cointreau-Lime & Salt\r\n"
						+ "Fruit tingle,30,15,Fruit tingle.jpg,Vodka-Blue Curracao-Lemonmade & Raspberry\r\n"
						+ "Mojito,29,15,Mojito.jpg,White Rum-Mint & Fresh Lime\r\n"
						+ "White Lady,23,15,White Lady.jpg,White Rum-Pineapple & Coconut");
				printdrinks.close();
				Scanner scannerdrinks = new Scanner(fileOfdrinks);
				ArrayList<String> listOfdrinks = new ArrayList<String>();
				while(scannerdrinks.hasNextLine()) {
						String data= scannerdrinks.nextLine();
						 String[] array = data.split(",");
						ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
						for (int i = 0; i < list.size(); i++) {
							listOfdrinks.add(list.get(i));
						}
				}
				ArrayList<Menu> MenuOfdrinks = new ArrayList<Menu>();
				for (int i = 0; i < listOfdrinks.size()-1; i=i+5) {
					Menu menu = new Menu();
					menu.setName(listOfdrinks.get(i));
					Double calories = new Double(listOfdrinks.get(i+1));
					menu.setCalories(calories);
					Double price = new Double(listOfdrinks.get(i+2));
					menu.setPrice(price);	
					menu.setPath(listOfdrinks.get(i+3));
					menu.setDescription(listOfdrinks.get(i+4));
					menu.setType(listTypeOfFood.get(5).getType());
					MenuOfdrinks.add(menu);
				}
				/*----------------------------------------------
				 * Start to create The program
				 */
				//First Scene: 
				StackPane stack = new StackPane();
				stack.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
				Label restaurantName = new Label("YUMMY Restaurant");
				restaurantName.setFont(Font.font("Times New Roman",FontWeight.BOLD , 80));
				Label quote = new Label("\"If you're not at the table, you're on the menu.\"");
				quote.setFont(Font.font("Times New Roman",FontWeight.BOLD , FontPosture.ITALIC, 30));
				Button start = new Button("GO TO MENU");
				start.setShape(new Circle(1.4));
				start.setFont(Font.font("Times New Roman",FontWeight.BOLD , FontPosture.REGULAR, 40));
				Image image = new Image("food-removebg-preview.png");
				ImageView imageview = new ImageView(image);
				imageview.setFitHeight(500);
				imageview.setFitWidth(500);
				VBox vbox = new VBox();
				vbox.setSpacing(60);
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(restaurantName,quote,imageview,start);
				stack.getChildren().add(vbox);
				stack.widthProperty().addListener(ov -> vbox.setMaxWidth(stack.getWidth()));
				stack.heightProperty().addListener(ov -> vbox.setMaxHeight(stack.getHeight()));
				Scene scene = new Scene(stack);
				primaryStage.setScene(scene);
				primaryStage.setFullScreen(true);
				primaryStage.show();
				//Second Scene:
				StackPane stack2 = new StackPane();
				stack2.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
				Shape rectangle = new Rectangle(700,700);
				rectangle.setFill(Color.WHITESMOKE);
				stack2.getChildren().add(rectangle);
				stack2.setAlignment(Pos.CENTER);
				Text login = new Text("LOG-IN");
				login.setFill(Color.BLACK);
				login.setFont(Font.font("Times New Roman",FontWeight.BOLD , 80));
				login.setStrokeWidth(2);
				login.setStroke(Color.ANTIQUEWHITE);
				login.setUnderline(true);
				Image profileImage = new Image("profile-removebg-preview.png");
				ImageView profileView = new ImageView(profileImage);
				profileView.setFitHeight(50);
				profileView.setFitWidth(50);
				TextField username = new TextField("Username");
				username.setFont(Font.font("Times New Roman",FontWeight.BOLD , 20));
				HBox hbox2 = new HBox();
				hbox2.getChildren().addAll(profileView,username);
				hbox2.setAlignment(Pos.CENTER);
				Image passwordIamge = new Image("download-removebg-preview.png");
				ImageView passwordView = new ImageView(passwordIamge);
				passwordView.setFitHeight(50);
				passwordView.setFitWidth(50);
				PasswordField password = new PasswordField();
				password.setFont(Font.font("Times New Roman",FontWeight.BOLD , 20));
				HBox hbox21 = new HBox();
				hbox21.getChildren().addAll(passwordView,password);
				hbox21.setAlignment(Pos.CENTER);
				Image cityImage = new Image("city-removebg-preview.png");
				ImageView cityView = new ImageView(cityImage);
				cityView.setFitHeight(110);
				cityView.setFitWidth(110);
				RadioButton bethlehem = new RadioButton("Bethlehem");
				RadioButton jerusalem = new RadioButton("Jerusalem");
				RadioButton hebron = new RadioButton("Hebron");
				RadioButton ramallah = new RadioButton("Ramallah");
				ToggleGroup toggleGroup = new ToggleGroup();
				bethlehem.setToggleGroup(toggleGroup);
				jerusalem.setToggleGroup(toggleGroup);
				hebron.setToggleGroup(toggleGroup);
				ramallah.setToggleGroup(toggleGroup);
				bethlehem.setFont(Font.font("Times New Roman",FontWeight.BOLD , 20));
				jerusalem.setFont(Font.font("Times New Roman",FontWeight.BOLD , 20));
				hebron.setFont(Font.font("Times New Roman",FontWeight.BOLD , 20));
				ramallah.setFont(Font.font("Times New Roman",FontWeight.BOLD , 20));
				VBox VCity = new VBox();
				VCity.setSpacing(10);
				VCity.getChildren().addAll(bethlehem,jerusalem,hebron,ramallah);
				HBox HBOXcity = new HBox();
				HBOXcity.setAlignment(Pos.CENTER);
				HBOXcity.getChildren().addAll(cityView,VCity);
				VBox mainVBOX = new VBox();
				mainVBOX.setAlignment(Pos.CENTER);
				Image countryImage = new Image("palestine-removebg-preview.png");
				ImageView countryView = new ImageView(countryImage);
				countryView.setFitHeight(120);
				countryView.setFitWidth(150);
				Label palestine = new Label("Palestine");
				palestine.setFont(Font.font("Times New Roman",FontWeight.BOLD , 40));
				HBox country = new HBox();
				country.setAlignment(Pos.CENTER);
				country.getChildren().addAll(countryView,palestine);
				Button loginbtn = new Button("Login");
				loginbtn.setFont(Font.font("Times New Roman",FontWeight.BOLD , 40));
				loginbtn.setShape(new Circle(15));
				HBox Hbtnlog = new HBox();
				Hbtnlog.setAlignment(Pos.CENTER);
				Hbtnlog.getChildren().add(loginbtn);
				mainVBOX.getChildren().addAll(login,hbox2,hbox21,HBOXcity,country,Hbtnlog);
				stack2.getChildren().add(mainVBOX);
				stack2.setAlignment(Pos.CENTER);
				stack2.widthProperty().addListener(ov -> mainVBOX.setMaxWidth(stack2.getWidth()));
				stack2.heightProperty().addListener(ov -> mainVBOX.setMaxHeight(stack2.getHeight()));
				Scene scene2 = new Scene(stack2,scene.getHeight(),scene.getWidth());
				start.setOnAction(event -> {primaryStage.setScene(scene2);
				primaryStage.setFullScreen(true);
				});
				//Third Scene
				Button chinesefood = new Button("",new ImageView("chinesefood-removebg-preview.png"));
				Button drinks = new Button(null,new ImageView("drinks-removebg-preview.png"));
				Button fastfood = new Button(null,new ImageView("fastfood-removebg-preview.png"));
				Button meat = new Button(null,new ImageView("meat-removebg-preview.png"));
				Button mexicanfood = new Button("",new ImageView("mexicanfood-removebg-preview.png"));
				Button seafood = new Button(null,new ImageView("seafood-removebg-preview.png"));
				chinesefood.setShape(new Circle());
				drinks.setShape(new Circle());
				fastfood.setShape(new Circle());
				meat.setShape(new Circle());
				mexicanfood.setShape(new Circle());
				seafood.setShape(new Circle());
				PathTransition pathOfmexicanfood = new PathTransition();
				Circle circlemexicanfood = new Circle(100);
				circlemexicanfood.setCenterX(100);
				circlemexicanfood.setCenterY(0);
				circlemexicanfood.setFill(Color.LAVENDER);
			    pathOfmexicanfood.setDuration(Duration.millis(4000));
			    pathOfmexicanfood.setPath(circlemexicanfood);
			    pathOfmexicanfood.setNode(mexicanfood);
			    pathOfmexicanfood.setOrientation(
			    PathTransition.OrientationType.NONE);
			    pathOfmexicanfood.play();
				PathTransition pathOfmeat = new PathTransition();
				Circle circlemeat = new Circle(100);
				circlemeat.setCenterX(circlemexicanfood.getCenterX());
				circlemeat.setCenterY(circlemexicanfood.getCenterY()+200);
				circlemeat.setFill(Color.LAVENDER);
			    pathOfmeat.setDuration(Duration.millis(4000));
			    pathOfmeat.setPath(circlemeat);
			    pathOfmeat.setNode(meat);
			    pathOfmeat.setOrientation(
			    PathTransition.OrientationType.NONE);
			    pathOfmeat.play();
			    PathTransition pathOffastfood = new PathTransition();
			    Circle circlefastfood = new Circle(100);
				circlefastfood.setCenterX(circlemexicanfood.getCenterX()+200);
				circlefastfood.setCenterY(circlemexicanfood.getCenterY()-30);
				circlefastfood.setFill(Color.LAVENDER);
			    pathOffastfood.setDuration(Duration.millis(4000));
			    pathOffastfood.setPath(circlefastfood);
			    pathOffastfood.setNode(fastfood);
			    pathOffastfood.setOrientation(
			    PathTransition.OrientationType.NONE);
			    pathOffastfood.play();
				PathTransition pathOfchinesefood = new PathTransition();
				Circle circlechinesefood = new Circle(100);
				circlechinesefood.setCenterX(circlemexicanfood.getCenterX());
				circlechinesefood.setCenterY(circlemeat.getCenterY()+130);
				circlechinesefood.setFill(Color.LAVENDER);
			    pathOfchinesefood.setDuration(Duration.millis(4000));
			    pathOfchinesefood.setPath(circlechinesefood);
			    pathOfchinesefood.setNode(chinesefood);
			    pathOfchinesefood.setOrientation(
			    PathTransition.OrientationType.NONE);
			    pathOfchinesefood.play();
			    PathTransition pathOfseafood = new PathTransition();
				Circle circleseafood = new Circle(100);
				circleseafood.setCenterX(circlefastfood.getCenterX());
				circleseafood.setCenterY(circlemeat.getCenterY()+10);
				circleseafood.setFill(Color.LAVENDER);
			    pathOfseafood.setDuration(Duration.millis(4000));
			    pathOfseafood.setPath(circleseafood);
			    pathOfseafood.setNode(seafood);
			    pathOfseafood.setOrientation(
			    PathTransition.OrientationType.NONE);
			    pathOfseafood.play();
			    PathTransition pathOfdrinks = new PathTransition();
				Circle circledrinks = new Circle(100);
				circledrinks.setCenterX(circlefastfood.getCenterX());
				circledrinks.setCenterY(circlechinesefood.getCenterY());
				circledrinks.setFill(Color.LAVENDER);
			    pathOfdrinks.setDuration(Duration.millis(4000));
			    pathOfdrinks.setPath(circledrinks);
			    pathOfdrinks.setNode(drinks);
			    pathOfdrinks.setOrientation(
			    PathTransition.OrientationType.NONE);
			    pathOfdrinks.play();
			    StackPane panePATH = new StackPane();
			    panePATH.getChildren().add(circlemexicanfood);
			    panePATH.getChildren().addAll(chinesefood,mexicanfood,meat,seafood,drinks,fastfood);
			    BorderPane borderPane = new BorderPane();
			    borderPane.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
			    Label title = new Label("Type Of food");
			    title.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,80));
			    Label note = new Label("    \"Click on the image of each type of food you\n"
			    		+ "want to see the foods and their prices in the restaurant\"");
			    note.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,25));
			    VBox vert = new VBox();
			    vert.getChildren().addAll(title,note);
			    vert.setAlignment(Pos.CENTER);
			    borderPane.setTop(vert);
			    borderPane.setAlignment(title,Pos.CENTER);
			    borderPane.setCenter(panePATH);
			    Image logo = new Image("Black_Continuous_Line_Plate_Fork_Knife_Circle_Restaurant_Logo-removebg-preview.png");
			    ImageView logoView = new ImageView(logo);
			    borderPane.setLeft(logoView);
			    borderPane.setAlignment(logoView, Pos.CENTER);
			    borderPane.widthProperty().addListener(ov -> panePATH.setMaxWidth(borderPane.getWidth()));
			    borderPane.heightProperty().addListener(ov -> panePATH.setMaxHeight(borderPane.getHeight()));
			    Scene scenepath = new Scene(borderPane,scene.getHeight(),scene.getWidth());
			    //the action of login button			
			    loginbtn.setOnAction(e->{
			    	String usernameText = username.getText();
			    	String passwordText = password.getText();
			    		for (int i = 0; i < userList.size(); i++) {
							if((bethlehem.isSelected()) && (usernameText.equals(userList.get(i).getUsername())) && (passwordText.equals(userList.get(i).getPassword())) && ("bethlehem".equalsIgnoreCase(userList.get(i).getCity()))) {
								pathOfdrinks.play();
							    pathOfchinesefood.play();
							    pathOffastfood.play();
							    pathOfmeat.play();
							    pathOfmexicanfood.play();
							    pathOfseafood.play();
								primaryStage.setScene(scenepath);
								primaryStage.setFullScreen(true);
								break;
								}
							if((ramallah.isSelected()) && (usernameText.equals(userList.get(i).getUsername())) && (passwordText.equals(userList.get(i).getPassword())) && ("ramallah".equalsIgnoreCase(userList.get(i).getCity()))) {
								pathOfdrinks.play();
							    pathOfchinesefood.play();
							    pathOffastfood.play();
							    pathOfmeat.play();
							    pathOfmexicanfood.play();
							    pathOfseafood.play();
								primaryStage.setScene(scenepath);
								primaryStage.setFullScreen(true);
								break;
								}
							if((hebron.isSelected()) && (usernameText.equals(userList.get(i).getUsername())) && (passwordText.equals(userList.get(i).getPassword())) && ("hebron".equalsIgnoreCase(userList.get(i).getCity()))) {
								pathOfdrinks.play();
							    pathOfchinesefood.play();
							    pathOffastfood.play();
							    pathOfmeat.play();
							    pathOfmexicanfood.play();
							    pathOfseafood.play();
								primaryStage.setScene(scenepath);
								primaryStage.setFullScreen(true);
								break;
								}
							if((jerusalem.isSelected()) && (usernameText.equals(userList.get(i).getUsername())) && (passwordText.equals(userList.get(i).getPassword())) && ("jerusalem".equalsIgnoreCase(userList.get(i).getCity()))) {
								pathOfdrinks.play();
							    pathOfchinesefood.play();
							    pathOffastfood.play();
							    pathOfmeat.play();
							    pathOfmexicanfood.play();
							    pathOfseafood.play();
								primaryStage.setScene(scenepath);
								primaryStage.setFullScreen(true);
								break;
								}
			    		}
			    });
				//Fourth Scene
				/*
				 * For Sea-food
				 */
				StackPane stackOfSeafood = new StackPane();
				stackOfSeafood.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
				Label lblSeafood = new Label("Dishes of Sea-food");
				lblSeafood.setFont(Font.font("Times New Roman",FontWeight.BOLD , 80));
				lblSeafood.setUnderline(true);
				CheckBox firstdishOfSEAFOOD = new CheckBox();
				firstdishOfSEAFOOD.setGraphic(new ImageView(MenuSeafood.get(0).getPath()));
				Label firstdishDescription = new Label(MenuSeafood.get(0).toString());
				HBox hboxfirstSEAFOOD = new HBox();
				hboxfirstSEAFOOD.setSpacing(15);
				hboxfirstSEAFOOD.getChildren().addAll(firstdishOfSEAFOOD,firstdishDescription);
				CheckBox seconsdishOfSEAFOOD = new CheckBox();
				seconsdishOfSEAFOOD.setGraphic(new ImageView(MenuSeafood.get(1).getPath()));
				Label seconddishDescription = new Label(MenuSeafood.get(1).toString());
				HBox hboxsecondSEAFOOD = new HBox();
				hboxsecondSEAFOOD.setSpacing(15);
				hboxsecondSEAFOOD.getChildren().addAll(seconsdishOfSEAFOOD,seconddishDescription);
				VBox vboxfirstandsecondSEAFOOD = new VBox();
				vboxfirstandsecondSEAFOOD.setSpacing(15);
				vboxfirstandsecondSEAFOOD.getChildren().addAll(hboxfirstSEAFOOD,hboxsecondSEAFOOD);
				CheckBox thirddishOfSEAFOOD = new CheckBox();
				thirddishOfSEAFOOD.setGraphic(new ImageView(MenuSeafood.get(2).getPath()));
				Label thirddishDescription = new Label(MenuSeafood.get(2).toString());
				HBox hboxthirdSEAFOOD = new HBox();
				hboxthirdSEAFOOD.setSpacing(15);
				hboxthirdSEAFOOD.getChildren().addAll(thirddishOfSEAFOOD,thirddishDescription);
				CheckBox fourthdishOfSEAFOOD = new CheckBox();
				fourthdishOfSEAFOOD.setGraphic(new ImageView(MenuSeafood.get(3).getPath()));
				Label fourthdishDescription = new Label(MenuSeafood.get(3).toString());
				HBox hboxfourthSEAFOOD = new HBox();
				hboxfourthSEAFOOD.setSpacing(15);
				hboxfourthSEAFOOD.getChildren().addAll(fourthdishOfSEAFOOD,fourthdishDescription);
				VBox vboxthirdandfourthSEAFOOD = new VBox();
				vboxthirdandfourthSEAFOOD.setSpacing(15);
				vboxthirdandfourthSEAFOOD.getChildren().addAll(hboxthirdSEAFOOD,hboxfourthSEAFOOD);
				Button backSEAFOOD = new Button("BACK");
				backSEAFOOD.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				Button addSEAFOOD = new Button("ADD");
				addSEAFOOD.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				HBox hboxbtnSEAFOOD = new HBox();
				hboxbtnSEAFOOD.setSpacing(20);
				hboxbtnSEAFOOD.setAlignment(Pos.CENTER);
				hboxbtnSEAFOOD.getChildren().addAll(backSEAFOOD,addSEAFOOD);
				HBox hboxMenuSEAFOOD = new HBox();
				hboxMenuSEAFOOD.setSpacing(20);
				hboxMenuSEAFOOD.setAlignment(Pos.CENTER);
				hboxMenuSEAFOOD.getChildren().addAll(vboxfirstandsecondSEAFOOD,vboxthirdandfourthSEAFOOD);
				VBox vboxSEAFOODfinal = new VBox();
				vboxSEAFOODfinal.setAlignment(Pos.CENTER);
				vboxSEAFOODfinal.setSpacing(30);
				vboxSEAFOODfinal.getChildren().addAll(lblSeafood,hboxMenuSEAFOOD,hboxbtnSEAFOOD);
				stackOfSeafood.getChildren().addAll(vboxSEAFOODfinal);
				stackOfSeafood.widthProperty().addListener(ov -> vboxSEAFOODfinal.setMaxWidth(stackOfSeafood.getWidth()));
				stackOfSeafood.heightProperty().addListener(ov -> vboxSEAFOODfinal.setMaxHeight(stackOfSeafood.getHeight()));
				Scene sceneOfMenuSEAFOOD = new Scene(stackOfSeafood);
				seafood.setOnAction(e->{
					primaryStage.setScene(sceneOfMenuSEAFOOD);
					primaryStage.setFullScreen(true);
				});
				backSEAFOOD.setOnAction(e->{
					primaryStage.setScene(scenepath);
					primaryStage.setFullScreen(true);
				});
				/*
				 * For Meat
				 */
				StackPane stackOfMeat = new StackPane();
				stackOfMeat.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
				Label lblMeat = new Label("Dishes of Meat");
				lblMeat.setFont(Font.font("Times New Roman",FontWeight.BOLD , 80));
				lblMeat.setUnderline(true);
				CheckBox firstdishOfMEAT = new CheckBox();
				firstdishOfMEAT.setGraphic(new ImageView(MenuOfMeat.get(0).getPath()));
				Label firstdishDescriptionMEAT = new Label(MenuOfMeat.get(0).toString());
				HBox hboxfirstMEAT = new HBox();
				hboxfirstMEAT.setSpacing(15);
				hboxfirstMEAT.getChildren().addAll(firstdishOfMEAT,firstdishDescriptionMEAT);
				CheckBox seconsdishOfMEAT = new CheckBox();
				seconsdishOfMEAT.setGraphic(new ImageView(MenuOfMeat.get(1).getPath()));
				Label seconddishDescriptionMEAT= new Label(MenuOfMeat.get(1).toString());
				HBox hboxsecondMEAT = new HBox();
				hboxsecondMEAT.setSpacing(15);
				hboxsecondMEAT.getChildren().addAll(seconsdishOfMEAT,seconddishDescriptionMEAT);
				VBox vboxfirstandsecondMEAT = new VBox();
				vboxfirstandsecondMEAT.setSpacing(15);
				vboxfirstandsecondMEAT.getChildren().addAll(hboxfirstMEAT,hboxsecondMEAT);
				CheckBox thirddishOfMEAT = new CheckBox();
				thirddishOfMEAT.setGraphic(new ImageView(MenuOfMeat.get(2).getPath()));
				Label thirddishDescriptionMEAT = new Label(MenuOfMeat.get(2).toString());
				HBox hboxthirdMEAT = new HBox();
				hboxthirdMEAT.setSpacing(15);
				hboxthirdMEAT.getChildren().addAll(thirddishOfMEAT,thirddishDescriptionMEAT);
				CheckBox fourthdishOfMEAT = new CheckBox();
				fourthdishOfMEAT.setGraphic(new ImageView(MenuOfMeat.get(3).getPath()));
				Label fourthdishDescriptionMEAT = new Label(MenuOfMeat.get(3).toString());
				HBox hboxfourthMEAT = new HBox();
				hboxfourthMEAT.setSpacing(15);
				hboxfourthMEAT.getChildren().addAll(fourthdishOfMEAT,fourthdishDescriptionMEAT);
				VBox vboxthirdandfourthMEAT = new VBox();
				vboxthirdandfourthMEAT.setSpacing(15);
				vboxthirdandfourthMEAT.getChildren().addAll(hboxthirdMEAT,hboxfourthMEAT);
				Button backMEAT = new Button("BACK");
				backMEAT.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				Button addMEAT = new Button("ADD");
				addMEAT.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				HBox hboxbtnMEAT = new HBox();
				hboxbtnMEAT.setSpacing(20);
				hboxbtnMEAT.setAlignment(Pos.CENTER);
				hboxbtnMEAT.getChildren().addAll(backMEAT,addMEAT);
				HBox hboxMenuMEAT = new HBox();
				hboxMenuMEAT.setSpacing(20);
				hboxMenuMEAT.setAlignment(Pos.CENTER);
				hboxMenuMEAT.getChildren().addAll(vboxfirstandsecondMEAT,vboxthirdandfourthMEAT);
				VBox vboxMEATfinal = new VBox();
				vboxMEATfinal.setAlignment(Pos.CENTER);
				vboxMEATfinal.setSpacing(30);
				vboxMEATfinal.getChildren().addAll(lblMeat,hboxMenuMEAT,hboxbtnMEAT);
				stackOfMeat.getChildren().addAll(vboxMEATfinal);
				stackOfMeat.widthProperty().addListener(ov -> vboxMEATfinal.setMaxWidth(stackOfMeat.getWidth()));
				stackOfMeat.heightProperty().addListener(ov -> vboxMEATfinal.setMaxHeight(stackOfMeat.getHeight()));
				Scene sceneOfMenuMEAT = new Scene(stackOfMeat);
				meat.setOnAction(e->{
					primaryStage.setScene(sceneOfMenuMEAT);
					primaryStage.setFullScreen(true);
				});
				backMEAT.setOnAction(e->{
					primaryStage.setScene(scenepath);
					primaryStage.setFullScreen(true);
				});
				/*
				 * For Fast-food
				 */
				StackPane stackOfFASTFOOD = new StackPane();
				stackOfFASTFOOD.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
				Label lblFASTFOOD = new Label("Dishes of Fast-Food");
				lblFASTFOOD.setFont(Font.font("Times New Roman",FontWeight.BOLD , 80));
				lblFASTFOOD.setUnderline(true);
				CheckBox firstdishOFASTFOOD = new CheckBox();
				firstdishOFASTFOOD.setGraphic(new ImageView(MenuOfFastFood.get(0).getPath()));
				Label firstdishDescriptionFASTFOOD = new Label(MenuOfFastFood.get(0).toString());
				HBox hboxfirstFASTFOOD = new HBox();
				hboxfirstFASTFOOD.setSpacing(15);
				hboxfirstFASTFOOD.getChildren().addAll(firstdishOFASTFOOD,firstdishDescriptionFASTFOOD);
				CheckBox seconsdishOfFASTFOOD = new CheckBox();
				seconsdishOfFASTFOOD.setGraphic(new ImageView(MenuOfFastFood.get(1).getPath()));
				Label seconddishDescriptionFASTFOOD= new Label(MenuOfFastFood.get(1).toString());
				HBox hboxsecondFASTFOOD = new HBox();
				hboxsecondFASTFOOD.setSpacing(15);
				hboxsecondFASTFOOD.getChildren().addAll(seconsdishOfFASTFOOD,seconddishDescriptionFASTFOOD);
				VBox vboxfirstandsecondFASTFOOD = new VBox();
				vboxfirstandsecondFASTFOOD.setSpacing(15);
				vboxfirstandsecondFASTFOOD.getChildren().addAll(hboxfirstFASTFOOD,hboxsecondFASTFOOD);
				CheckBox thirddishOfFASTFOOD = new CheckBox();
				thirddishOfFASTFOOD.setGraphic(new ImageView(MenuOfFastFood.get(2).getPath()));
				Label thirddishDescriptionFASTFOOD = new Label(MenuOfFastFood.get(2).toString());
				HBox hboxthirdFASTFOOD = new HBox();
				hboxthirdFASTFOOD.setSpacing(15);
				hboxthirdFASTFOOD.getChildren().addAll(thirddishOfFASTFOOD,thirddishDescriptionFASTFOOD);
				CheckBox fourthdishOfFASTFOOD = new CheckBox();
				fourthdishOfFASTFOOD.setGraphic(new ImageView(MenuOfFastFood.get(3).getPath()));
				Label fourthdishDescriptionFASTFOOD = new Label(MenuOfFastFood.get(3).toString());
				HBox hboxfourthFASTFOOD = new HBox();
				hboxfourthFASTFOOD.setSpacing(15);
				hboxfourthFASTFOOD.getChildren().addAll(fourthdishOfFASTFOOD,fourthdishDescriptionFASTFOOD);
				VBox vboxthirdandfourthFASTFOOD = new VBox();
				vboxthirdandfourthFASTFOOD.setSpacing(15);
				vboxthirdandfourthFASTFOOD.getChildren().addAll(hboxthirdFASTFOOD,hboxfourthFASTFOOD);
				Button backFASTFOOD = new Button("BACK");
				backFASTFOOD.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				Button addFASTFOOD = new Button("ADD");
				addFASTFOOD.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				HBox hboxbtnFASTFOOD = new HBox();
				hboxbtnFASTFOOD.setSpacing(20);
				hboxbtnFASTFOOD.setAlignment(Pos.CENTER);
				hboxbtnFASTFOOD.getChildren().addAll(backFASTFOOD,addFASTFOOD);
				HBox hboxMenuFASTFOOD = new HBox();
				hboxMenuFASTFOOD.setSpacing(20);
				hboxMenuFASTFOOD.setAlignment(Pos.CENTER);
				hboxMenuFASTFOOD.getChildren().addAll(vboxfirstandsecondFASTFOOD,vboxthirdandfourthFASTFOOD);
				VBox vboxFASTFOODfinal = new VBox();
				vboxFASTFOODfinal.setAlignment(Pos.CENTER);
				vboxFASTFOODfinal.setSpacing(30);
				vboxFASTFOODfinal.getChildren().addAll(lblFASTFOOD,hboxMenuFASTFOOD,hboxbtnFASTFOOD);
				stackOfFASTFOOD.getChildren().addAll(vboxFASTFOODfinal);
				stackOfFASTFOOD.widthProperty().addListener(ov -> vboxFASTFOODfinal.setMaxWidth(stackOfFASTFOOD.getWidth()));
				stackOfFASTFOOD.heightProperty().addListener(ov -> vboxFASTFOODfinal.setMaxHeight(stackOfFASTFOOD.getHeight()));
				Scene sceneOfMenuFASTFOOD = new Scene(stackOfFASTFOOD);
				fastfood.setOnAction(e->{
					primaryStage.setScene(sceneOfMenuFASTFOOD);
					primaryStage.setFullScreen(true);
				});
				backFASTFOOD.setOnAction(e->{
					primaryStage.setScene(scenepath);
					primaryStage.setFullScreen(true);
				});
				/*
				 * For Mexican food
				 */
				StackPane stackOfMexicanfood = new StackPane();
				stackOfMexicanfood.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
				Label lblMexicanfood = new Label("Dishes of Mexican food");
				lblMexicanfood.setFont(Font.font("Times New Roman",FontWeight.BOLD , 80));
				lblMexicanfood.setUnderline(true);
				CheckBox firstdishOfMexicanfood = new CheckBox();
				firstdishOfMexicanfood.setGraphic(new ImageView(MenuOfMexicanfood.get(0).getPath()));
				Label firstdishDescriptionMexicanfood = new Label(MenuOfMexicanfood.get(0).toString());
				HBox hboxfirstMexicanfood = new HBox();
				hboxfirstMexicanfood.setSpacing(15);
				hboxfirstMexicanfood.getChildren().addAll(firstdishOfMexicanfood,firstdishDescriptionMexicanfood);
				CheckBox seconsdishOfMexicanfood = new CheckBox();
				seconsdishOfMexicanfood.setGraphic(new ImageView(MenuOfMexicanfood.get(1).getPath()));
				Label seconddishDescriptionMexicanfood= new Label(MenuOfMexicanfood.get(1).toString());
				HBox hboxsecondMexicanfood = new HBox();
				hboxsecondMexicanfood.setSpacing(15);
				hboxsecondMexicanfood.getChildren().addAll(seconsdishOfMexicanfood,seconddishDescriptionMexicanfood);
				VBox vboxfirstandsecondMexicanfood = new VBox();
				vboxfirstandsecondMexicanfood.setSpacing(15);
				vboxfirstandsecondMexicanfood.getChildren().addAll(hboxfirstMexicanfood,hboxsecondMexicanfood);
				CheckBox thirddishOfMexicanfood = new CheckBox();
				thirddishOfMexicanfood.setGraphic(new ImageView(MenuOfMexicanfood.get(2).getPath()));
				Label thirddishDescriptionMexicanfood = new Label(MenuOfMexicanfood.get(2).toString());
				HBox hboxthirdMexicanfood = new HBox();
				hboxthirdMexicanfood.setSpacing(15);
				hboxthirdMexicanfood.getChildren().addAll(thirddishOfMexicanfood,thirddishDescriptionMexicanfood);
				CheckBox fourthdishOfMexicanfood = new CheckBox();
				fourthdishOfMexicanfood.setGraphic(new ImageView(MenuOfMexicanfood.get(3).getPath()));
				Label fourthdishDescriptionMexicanfood = new Label(MenuOfMexicanfood.get(3).toString());
				HBox hboxfourthMexicanfood = new HBox();
				hboxfourthMexicanfood.setSpacing(15);
				hboxfourthMexicanfood.getChildren().addAll(fourthdishOfMexicanfood,fourthdishDescriptionMexicanfood);
				VBox vboxthirdandfourthMexicanfood = new VBox();
				vboxthirdandfourthMexicanfood.setSpacing(15);
				vboxthirdandfourthMexicanfood.getChildren().addAll(hboxthirdMexicanfood,hboxfourthMexicanfood);
				Button backMexicanfood = new Button("BACK");
				backMexicanfood.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				Button addMexicanfood = new Button("ADD");
				addMexicanfood.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				HBox hboxbtnMexicanfood = new HBox();
				hboxbtnMexicanfood.setSpacing(20);
				hboxbtnMexicanfood.setAlignment(Pos.CENTER);
				hboxbtnMexicanfood.getChildren().addAll(backMexicanfood,addMexicanfood);
				HBox hboxMenuMexicanfood = new HBox();
				hboxMenuMexicanfood.setSpacing(20);
				hboxMenuMexicanfood.setAlignment(Pos.CENTER);
				hboxMenuMexicanfood.getChildren().addAll(vboxfirstandsecondMexicanfood,vboxthirdandfourthMexicanfood);
				VBox vboxMexicanfoodfinal = new VBox();
				vboxMexicanfoodfinal.setAlignment(Pos.CENTER);
				vboxMexicanfoodfinal.setSpacing(30);
				vboxMexicanfoodfinal.getChildren().addAll(lblMexicanfood,hboxMenuMexicanfood,hboxbtnMexicanfood);
				stackOfMexicanfood.getChildren().addAll(vboxMexicanfoodfinal);
				stackOfMexicanfood.widthProperty().addListener(ov -> vboxMexicanfoodfinal.setMaxWidth(stackOfMexicanfood.getWidth()));
				stackOfMexicanfood.heightProperty().addListener(ov -> vboxMexicanfoodfinal.setMaxHeight(stackOfMexicanfood.getHeight()));
				Scene sceneOfMenuMexicanfood = new Scene(stackOfMexicanfood);
				mexicanfood.setOnAction(e->{
					primaryStage.setScene(sceneOfMenuMexicanfood);
					primaryStage.setFullScreen(true);
				});
				backMexicanfood.setOnAction(e->{
					primaryStage.setScene(scenepath);
					primaryStage.setFullScreen(true);
				});
				/*
				 * For Chinese food
				 */
				StackPane stackOfChinesefood = new StackPane();
				stackOfChinesefood.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
				Label lblChinesefood = new Label("Dishes of Chinese food");
				lblChinesefood.setFont(Font.font("Times New Roman",FontWeight.BOLD , 80));
				lblChinesefood.setUnderline(true);
				CheckBox firstdishOfChinesefood = new CheckBox();
				firstdishOfChinesefood.setGraphic(new ImageView(MenuOfChinesefood.get(0).getPath()));
				Label firstdishDescriptionChinesefood = new Label(MenuOfChinesefood.get(0).toString());
				HBox hboxfirstChinesefood = new HBox();
				hboxfirstChinesefood.setSpacing(15);
				hboxfirstChinesefood.getChildren().addAll(firstdishOfChinesefood,firstdishDescriptionChinesefood);
				CheckBox seconsdishOfChinesefood = new CheckBox();
				seconsdishOfChinesefood.setGraphic(new ImageView(MenuOfChinesefood.get(1).getPath()));
				Label seconddishDescriptionChinesefood = new Label(MenuOfChinesefood.get(1).toString());
				HBox hboxsecondChinesefood = new HBox();
				hboxsecondChinesefood.setSpacing(15);
				hboxsecondChinesefood.getChildren().addAll(seconsdishOfChinesefood,seconddishDescriptionChinesefood );
				VBox vboxfirstandsecondChinesefood = new VBox();
				vboxfirstandsecondChinesefood.setSpacing(15);
				vboxfirstandsecondChinesefood.getChildren().addAll(hboxfirstChinesefood,hboxsecondChinesefood);
				CheckBox thirddishOfChinesefood = new CheckBox();
				thirddishOfChinesefood.setGraphic(new ImageView(MenuOfChinesefood.get(2).getPath()));
				Label thirddishDescriptionChinesefood = new Label(MenuOfChinesefood.get(2).toString());
				HBox hboxthirdChinesefood = new HBox();
				hboxthirdChinesefood.setSpacing(15);
				hboxthirdChinesefood.getChildren().addAll(thirddishOfChinesefood,thirddishDescriptionChinesefood);
				CheckBox fourthdishOfChinesefood = new CheckBox();
				fourthdishOfChinesefood.setGraphic(new ImageView(MenuOfChinesefood.get(3).getPath()));
				Label fourthdishDescriptionChinesefood = new Label(MenuOfChinesefood.get(3).toString());
				HBox hboxfourthChinesefood = new HBox();
				hboxfourthChinesefood.setSpacing(15);
				hboxfourthChinesefood.getChildren().addAll(fourthdishOfChinesefood,fourthdishDescriptionChinesefood);
				VBox vboxthirdandfourthChinesefood = new VBox();
				vboxthirdandfourthChinesefood.setSpacing(15);
				vboxthirdandfourthChinesefood.getChildren().addAll(hboxthirdChinesefood,hboxfourthChinesefood);
				Button backChinesefood = new Button("BACK");
				backChinesefood.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				Button addChinesefood = new Button("ADD");
				addChinesefood.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				HBox hboxbtnChinesefood = new HBox();
				hboxbtnChinesefood.setSpacing(20);
				hboxbtnChinesefood.setAlignment(Pos.CENTER);
				hboxbtnChinesefood.getChildren().addAll(backChinesefood,addChinesefood);
				HBox hboxMenuChinesefood = new HBox();
				hboxMenuChinesefood.setSpacing(20);
				hboxMenuChinesefood.setAlignment(Pos.CENTER);
				hboxMenuChinesefood.getChildren().addAll(vboxfirstandsecondChinesefood,vboxthirdandfourthChinesefood);
				VBox vboxChinesefoodfinal = new VBox();
				vboxChinesefoodfinal.setAlignment(Pos.CENTER);
				vboxChinesefoodfinal.setSpacing(30);
				vboxChinesefoodfinal.getChildren().addAll(lblChinesefood,hboxMenuChinesefood,hboxbtnChinesefood);
				stackOfChinesefood.getChildren().addAll(vboxChinesefoodfinal);
				stackOfChinesefood.widthProperty().addListener(ov -> vboxChinesefoodfinal.setMaxWidth(stackOfChinesefood.getWidth()));
				stackOfChinesefood.heightProperty().addListener(ov -> vboxChinesefoodfinal.setMaxHeight(stackOfChinesefood.getHeight()));
				Scene sceneOfMenuChinesefood = new Scene(stackOfChinesefood);
				chinesefood.setOnAction(e->{
					primaryStage.setScene(sceneOfMenuChinesefood);
					primaryStage.setFullScreen(true);
				});
				backChinesefood.setOnAction(e->{
					primaryStage.setScene(scenepath);
					primaryStage.setFullScreen(true);
				});
				/*
				 * For drinks
				 */
				StackPane stackOfdrinks = new StackPane();
				stackOfdrinks.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
				Label lbldrinks = new Label("The drinks");
				lbldrinks.setFont(Font.font("Times New Roman",FontWeight.BOLD , 80));
				lbldrinks.setUnderline(true);
				CheckBox firstdishOfdrinks = new CheckBox();
				firstdishOfdrinks.setGraphic(new ImageView(MenuOfdrinks.get(0).getPath()));
				Label firstdishDescriptiondrinks = new Label(MenuOfdrinks.get(0).toString());
				HBox hboxfirstdrinks = new HBox();
				hboxfirstdrinks.setSpacing(15);
				hboxfirstdrinks.getChildren().addAll(firstdishOfdrinks,firstdishDescriptiondrinks);
				CheckBox seconsdishOfdrinks = new CheckBox();
				seconsdishOfdrinks.setGraphic(new ImageView(MenuOfdrinks.get(1).getPath()));
				Label seconddishDescriptiondrinks = new Label(MenuOfdrinks.get(1).toString());
				HBox hboxseconddrinks = new HBox();
				hboxseconddrinks.setSpacing(15);
				hboxseconddrinks.getChildren().addAll(seconsdishOfdrinks,seconddishDescriptiondrinks );
				VBox vboxfirstandseconddrinks = new VBox();
				vboxfirstandseconddrinks.setSpacing(15);
				vboxfirstandseconddrinks.getChildren().addAll(hboxfirstdrinks,hboxseconddrinks);
				CheckBox thirddishOfdrinks = new CheckBox();
				thirddishOfdrinks.setGraphic(new ImageView(MenuOfdrinks.get(2).getPath()));
				Label thirddishDescriptiondrinks = new Label(MenuOfdrinks.get(2).toString());
				HBox hboxthirddrinks = new HBox();
				hboxthirddrinks.setSpacing(15);
				hboxthirddrinks.getChildren().addAll(thirddishOfdrinks,thirddishDescriptiondrinks);
				CheckBox fourthdishOfdrinks = new CheckBox();
				fourthdishOfdrinks.setGraphic(new ImageView(MenuOfdrinks.get(3).getPath()));
				Label fourthdishDescriptiondrinks = new Label(MenuOfdrinks.get(3).toString());
				HBox hboxfourthdrinks = new HBox();
				hboxfourthdrinks.setSpacing(15);
				hboxfourthdrinks.getChildren().addAll(fourthdishOfdrinks,fourthdishDescriptiondrinks);
				VBox vboxthirdandfourthdrinks = new VBox();
				vboxthirdandfourthdrinks.setSpacing(15);
				vboxthirdandfourthdrinks.getChildren().addAll(hboxthirddrinks,hboxfourthdrinks);
				Button backdrinks = new Button("BACK");
				backdrinks.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				Button adddrinks = new Button("ADD");
				adddrinks.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,20));
				HBox hboxbtndrinks = new HBox();
				hboxbtndrinks.setSpacing(20);
				hboxbtndrinks.setAlignment(Pos.CENTER);
				hboxbtndrinks.getChildren().addAll(backdrinks,adddrinks);
				HBox hboxMenudrinks = new HBox();
				hboxMenudrinks.setSpacing(20);
				hboxMenudrinks.setAlignment(Pos.CENTER);
				hboxMenudrinks.getChildren().addAll(vboxfirstandseconddrinks,vboxthirdandfourthdrinks);
				VBox vboxdrinksfinal = new VBox();
				vboxdrinksfinal.setAlignment(Pos.CENTER);
				vboxdrinksfinal.setSpacing(30);
				vboxdrinksfinal.getChildren().addAll(lbldrinks,hboxMenudrinks,hboxbtndrinks);
				stackOfdrinks.getChildren().addAll(vboxdrinksfinal);
				stackOfdrinks.widthProperty().addListener(ov -> vboxdrinksfinal.setMaxWidth(stackOfdrinks.getWidth()));
				stackOfdrinks.heightProperty().addListener(ov -> vboxdrinksfinal.setMaxHeight(stackOfdrinks.getHeight()));
				Scene sceneOfMenudrinks = new Scene(stackOfdrinks);
				drinks.setOnAction(e->{
					primaryStage.setScene(sceneOfMenudrinks);
					primaryStage.setFullScreen(true);
				});
				backdrinks.setOnAction(e->{
					primaryStage.setScene(scenepath);
					primaryStage.setFullScreen(true);
				});
				//Fifth Scene
				StackPane stackOfFifth = new StackPane();
				stackOfFifth.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
				ImageView logoOfRestaurant = new ImageView("Black_Continuous_Line_Plate_Fork_Knife_Circle_Restaurant_Logo-removebg-preview.png");
				Label describe = new Label("Click on the bill button if you want the final total of your order,"
						+ "\nwhile if you want to order food from other types click on the types button.");
				describe.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD, FontPosture.REGULAR,40));
				describe.setAlignment(Pos.CENTER);
				Button bill = new Button("Bill",new Circle());
				bill.setFont(Font.font("",FontWeight.BLACK, FontPosture.REGULAR,20));
				Button type = new Button("TYPE",new Circle());
				type.setFont(Font.font("",FontWeight.BLACK, FontPosture.REGULAR,20));
				HBox buttons = new HBox();
				buttons.setAlignment(Pos.CENTER);
				buttons.setSpacing(30);
				buttons.getChildren().addAll(type,bill);
				VBox chooseButton = new VBox();
				chooseButton.setAlignment(Pos.CENTER);
				chooseButton.setSpacing(30);
				chooseButton.getChildren().addAll(logoOfRestaurant,describe,buttons);
				stackOfFifth.getChildren().add(chooseButton);
				Scene fifthScene = new Scene(stackOfFifth);
				ArrayList<Menu> OrderSeafood = new ArrayList<Menu>();
				addSEAFOOD.setOnAction(e->{
					System.out.println("NEW IS ADDED");
					if(firstdishOfSEAFOOD.isSelected()) {
						OrderSeafood.add(MenuSeafood.get(0));
					}
					if(seconsdishOfSEAFOOD.isSelected()) {
						OrderSeafood.add(MenuSeafood.get(1));
					}
					if(thirddishOfSEAFOOD.isSelected()) {
						OrderSeafood.add(MenuSeafood.get(2));
					}
					if(fourthdishOfSEAFOOD.isSelected()) {
						OrderSeafood.add(MenuSeafood.get(3));
					}
					primaryStage.setScene(fifthScene);
					primaryStage.setFullScreen(true);
				});
				ArrayList<Menu> OrderMeat = new ArrayList<Menu>();
				addMEAT.setOnAction(e->{
					if(firstdishOfMEAT.isSelected()) {
						OrderMeat.add(MenuOfMeat.get(0));
					}
					if(seconsdishOfMEAT.isSelected()) {
						OrderMeat.add(MenuOfMeat.get(1));
					}
					if(thirddishOfMEAT.isSelected()) {
						OrderMeat.add(MenuOfMeat.get(2));
					}
					if(fourthdishOfMEAT.isSelected()) {
						OrderMeat.add(MenuOfMeat.get(3));
					}
					primaryStage.setScene(fifthScene);
					primaryStage.setFullScreen(true);
				});
				ArrayList<Menu> OrderFastfood = new ArrayList<Menu>();
				addFASTFOOD.setOnAction(e->{
					if(firstdishOFASTFOOD.isSelected()) {
						OrderFastfood.add(MenuOfFastFood.get(0));
					}
					if(seconsdishOfFASTFOOD.isSelected()) {
						OrderFastfood.add(MenuOfFastFood.get(1));
					}
					if(thirddishOfFASTFOOD.isSelected()) {
						OrderFastfood.add(MenuOfFastFood.get(2));
					}
					if(fourthdishOfFASTFOOD.isSelected()) {
						OrderFastfood.add(MenuOfFastFood.get(3));
					}
					primaryStage.setScene(fifthScene);
					primaryStage.setFullScreen(true);
				});
				ArrayList<Menu> OrderMexicanfood = new ArrayList<Menu>();
				addMexicanfood.setOnAction(e->{
					if(firstdishOfMexicanfood.isSelected()) {
						OrderMexicanfood.add(MenuOfMexicanfood.get(0));
					}
					if(seconsdishOfMexicanfood.isSelected()) {
						OrderMexicanfood.add(MenuOfMexicanfood.get(1));
					}
					if(thirddishOfMexicanfood.isSelected()) {
						OrderMexicanfood.add(MenuOfMexicanfood.get(2));
					}
					if(fourthdishOfMexicanfood.isSelected()) {
						OrderMexicanfood.add(MenuOfMexicanfood.get(3));
					}
					primaryStage.setScene(fifthScene);
					primaryStage.setFullScreen(true);
				});
				ArrayList<Menu> OrderChinese = new ArrayList<Menu>();
				addChinesefood.setOnAction(e->{
					if(firstdishOfChinesefood.isSelected()) {
						OrderChinese.add(MenuOfChinesefood.get(0));
					}
					if(seconsdishOfChinesefood.isSelected()) {
						OrderChinese.add(MenuOfChinesefood.get(1));
					}
					if(thirddishOfChinesefood.isSelected()) {
						OrderChinese.add(MenuOfChinesefood.get(2));
					}
					if(fourthdishOfChinesefood.isSelected()) {
						OrderChinese.add(MenuOfChinesefood.get(3));
					}
					primaryStage.setScene(fifthScene);
					primaryStage.setFullScreen(true);
				});
				ArrayList<Menu> OrderDrinks = new ArrayList<Menu>();
				adddrinks.setOnAction(e->{
					if(firstdishOfdrinks.isSelected()) {
						OrderDrinks.add(MenuOfdrinks.get(0));
					}
					if(seconsdishOfdrinks.isSelected()) {
						OrderDrinks.add(MenuOfdrinks.get(1));
					}
					if(thirddishOfdrinks.isSelected()) {
						OrderDrinks.add(MenuOfdrinks.get(2));
					}
					if(fourthdishOfdrinks.isSelected()) {
						OrderDrinks.add(MenuOfdrinks.get(3));
					}
					primaryStage.setScene(fifthScene);
					primaryStage.setFullScreen(true);
				});
				File billFile = new File("billFile.txt");
				PrintWriter printBill = new PrintWriter(billFile);
				bill.setOnAction(e->{
					ArrayList<Menu> Bill = new ArrayList<Menu>();
					StackPane sixthStack = new StackPane();
					sixthStack.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
					ImageView logores = new ImageView("Black_Continuous_Line_Plate_Fork_Knife_Circle_Restaurant_Logo-removebg-preview.png");
					Label nameANDprice = new Label("Name Of dish" + "              \t\t\tPrice");
					nameANDprice.setUnderline(true);
					nameANDprice.setFont(Font.font("",FontWeight.NORMAL,FontPosture.REGULAR,20));
					VBox vsixthScene = new VBox();
					vsixthScene.getChildren().addAll(logores,nameANDprice);
					for (int i = 0; i < OrderChinese.size(); i++) {
						Bill.add(OrderChinese.get(i));
					}
					for (int i = 0; i < OrderDrinks.size(); i++) {
						Bill.add(OrderDrinks.get(i));
					}
					for (int i = 0; i < OrderFastfood.size(); i++) {
						Bill.add(OrderFastfood.get(i));
					}
					for (int i = 0; i < OrderMeat.size(); i++) {
						Bill.add(OrderMeat.get(i));
					}
					for (int i = 0; i < OrderMexicanfood.size(); i++) {
						Bill.add(OrderMexicanfood.get(i));
					}
					for (int i = 0; i < OrderSeafood.size(); i++) {
						Bill.add(OrderSeafood.get(i));
					}
					for (int i = 0; i < Bill.size(); i++) {
						Label lbl = new Label();
						lbl.setText(Bill.get(i).toBill());
						lbl.setFont(Font.font("",FontWeight.NORMAL,FontPosture.REGULAR,20));
						vsixthScene.getChildren().add(lbl);
					}
					sixthStack.getChildren().add(vsixthScene);
					double sum = 0;
					for (int i = 0; i < Bill.size(); i++) {
						sum+=Bill.get(i).getPrice();
					}
					Label total = new Label("Total price = " + sum + "$");
					total.setFont(Font.font("",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,20));
					vsixthScene.getChildren().add(total);
					vsixthScene.setAlignment(Pos.CENTER);
					Scene sixthScene = new Scene(sixthStack);
					primaryStage.setScene(sixthScene);
					primaryStage.setTitle("Total Price");
					for (int i = 0; i < Bill.size(); i++) {
						printBill.print(Bill.get(i).toFileBill());
					}
					printBill.close();
				});
				type.setOnAction(e->{
					primaryStage.setScene(scenepath);
					primaryStage.setFullScreen(true);
				});
				primaryStage.setFullScreen(true);
	}
					
	public static void main(String[] args) {
		launch(args);
	}
}
