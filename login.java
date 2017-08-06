package Database_user;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class login extends Application {

	static Connection con;
	PreparedStatement pst;
	
	static void doConnect() throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regjava","root","amit");
			System.out.println("ok");
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
	
		try {
			doConnect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		launch(args);

	}

	Scene scene,scene2;
	GridPane grid,grid2;
	ImageView img,img1;
	Text lbltitle,lbluid,lblpwd;
	TextField txtuid;
	PasswordField txtpwd;
	DropShadow ds;
	HBox h;
	Button log,btnsms;
	Alert msg;
	String name="";
    String pwd="";
	Stage theStage;
	BackgroundImage myBI,bg;
	
	
	Text ttitle,about,t1,t2,t3,t4,t5,t6,t7,t8;
	ListView<String> lst;
	ArrayList<String> ary;
	HBox h1,h2,h3,h4,h5,h6,h7,h8;
	ImageView img2,img3,img4,img5,img6,img7,img8,img9;
	
	@Override
	public void start(Stage st) throws Exception {
		
		st.setTitle("Window");
		theStage= st;
		
		
//-------------------grid---------------------------------------------------------		
		grid=new GridPane();
		grid.setGridLinesVisible(false);
		grid.setPadding(new Insets(80,0,0,80));
		grid.setHgap(10);
		grid.setVgap(10);
		
		
//-------------------------logo----------------------------------------------------		
		img=new ImageView(new Image(login.class.getResourceAsStream("login.png")));
		img.setFitHeight(60);
		img.setFitWidth(60);
		GridPane.setConstraints(img, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(20,20,20,30));
		
//-------------------------label---------------------------------------------------
		
		lbltitle=new Text("login Form");
		lbluid=new Text("User Id:");
		lblpwd=new Text("Password:");
		lbltitle.setFont(Font.font("Verdana",FontWeight.BOLD,45));
		lbluid.setFont(Font.font("Arial",FontWeight.MEDIUM,18));
		lblpwd.setFont(Font.font("Arial",FontWeight.MEDIUM,18));
		
		//GridPane.setMargin(lbltitle, new Insets(20,0,20,30));
		GridPane.setConstraints(lbltitle, 1, 0, 2, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(20,0,20,80));
		GridPane.setConstraints(lbluid, 1, 1, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(15,91,3,0));
		GridPane.setConstraints(lblpwd, 1, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(15,65,3,0));
		
		
//-------------------------------styling title----------------------------------------------		
		ds=new DropShadow();
		ds.setOffsetY(1.0);
		//ds.setOffsetX(3);
		ds.setColor(Color.color(0.4, 0.4, 0.4));
		lbltitle.setFill(Color.valueOf("#e91640"));
		lbltitle.setEffect(ds);
		
		lbluid.setFill(Color.valueOf("#ffd480"));
		lblpwd.setFill(Color.valueOf("#ffd480"));
		
//---------------------------------button----------------------------------------------
		h=new HBox();
		log=new Button("login");
		btnsms=new Button("SMS Pwd");
		
		log.setPrefSize(90, 30);
		btnsms.setPrefSize(90, 30);
		
		
		log.setStyle("-fx-background-color:#9696e8");
		btnsms.setStyle("-fx-background-color:#9696e8");
		h.getChildren().addAll(log,btnsms);
		h.setSpacing(30);
		GridPane.setConstraints(h, 0, 5, 3, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(40,0,0,90));
	
		log.setOnAction(e->doadd());
		//log.setOnAction(e->temp());
		btnsms.setOnAction(e->sendSMS());
		
//---------------------fields------------------------------------------------------
		txtuid=new TextField();
		txtpwd=new PasswordField();
		txtuid.setPromptText("Enter the user id");
		txtpwd.setPromptText("Enter the password");
		
		
//-----------------------add-------------------------------------------------------
		grid.add(img, 0, 0);
		grid.add(lbltitle, 1, 0);
		grid.add(lbluid, 1, 1);
		grid.add(lblpwd, 1, 3);
		grid.add(txtuid, 1, 2);
		grid.add(txtpwd, 1, 4);
		grid.add(h, 0, 5);
		
//---------------------------------scene2-------------------------------------------
		
		grid2=new GridPane();
		grid2.setGridLinesVisible(false);
		grid2.setPadding(new Insets(10,0,0,10));
		grid2.setHgap(10);
		grid2.setVgap(10);
		
		
		ttitle=new Text("Dashboard");
		ttitle.setFont(Font.font("Verdana",FontWeight.BOLD,40));
		ttitle.setFill(Color.valueOf("#ffd480"));
		grid2.setConstraints(ttitle, 1, 0, 2, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(0,0,0,0));
		
		lst=new ListView<String>();
		ary=new ArrayList<String>();
		
		lst.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		ary.add(" ");
		ary.add("About");
		ary.add("Customer Info");
		ary.add("Bill Record");
		ary.add("Tables");
		ary.add("Statistics");
		
		for(String item:ary)
		{
		lst.getItems().add(item);
		}
		lst.setPrefSize(180, 730);
	
		lst.getSelectionModel().select(1);
		lst.setStyle("-fx-font-size: 20px; "
				+ "-fx-font-family: 'SketchFlow Print';"
				+ "-fx-control-inner-background: #0d0d0d;-fx-background-insets: 0");
		grid2.setConstraints(lst, 0, 0, 1, 13, HPos.LEFT, VPos.CENTER, null, null, new Insets(0,0,0,0));

//----------------------------------about------------------------------------------------------------		
		h1=new HBox();
		about=new Text("It is a Java application which is made to help the Milk Person of an area.\nIt provides forms which can be used by him to maintain the records of customers.\nThis project is made by LOL :p under the guidance of Mr.Rajesh Bansal.");
		about.setFont(Font.font("Verdana",FontWeight.BOLD,18));
		about.setFill(Color.valueOf("#eda891"));
		grid2.setConstraints(about, 1, 2, 2, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(0,0,0,30));
		
		
////--------------------------------------events---------------------------------------
//		
//		img2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				new CustomerConsole();
//				
//			}
//		});
//		
//		img3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				new DailyRecord();
//				
//			}
//		});
//		
//		img4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				new BillGen();
//				
//			}
//		});
//		
//		img5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				new BillCollector();
//				
//			}
//		});
//		
//		img6.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				new CustomerTbl();
//				
//			}
//		});
//		
//		img7.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				new PaymentTbl();
//				
//			}
//		});
//		
//		img8.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				new MilkBowlTbl();
//				
//			}
//		});
//		
//		img9.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				new Stats();
//				
//			}
//		});
//		
		
//-----------------------------add2--------------------------------------------------
	//	grid2.getChildren().addAll(ttitle,lst,about,h1,h2,h3,h4,h5,h6,h7,h8);
		
//-----------------------set---------------------------------------------------------	
		
		
		bg= new BackgroundImage(new Image("Database_user/bground.jpg",1400,750,false,true),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		
		myBI= new BackgroundImage(new Image("Database_user/bground.jpg",1400,750,false,true),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		//then you set to your node
		grid.setBackground(new Background(myBI));
		
		
		//then you set to your node
		grid2.setBackground(new Background(bg));
		scene2=new Scene(grid2, 1400, 750);
		
		scene=new Scene(grid,1400,750);
		st.setScene(scene);
		st.show();

	}
	
private Object sendSMS() {
		
		String m="Your password is root and UserId is Amit ";
		String resp=SST_SMS.bceSunSoftSend("9988556829", m);
		//System.out.println(resp);
		if(resp.indexOf("Exception")!=-1)
		{
		System.out.println("Check Internet Connection");
		showMsg("Check Internet Connection");
		}
		else
		if(resp.indexOf("successfully")!=-1)
		{
		System.out.println("Sent");
		showMsg("Message Sent");
		}
		else
		
		System.out.println( "Invalid Number");
		return null;
	}

	void showMsg(String msg)
	{
		Alert al=new Alert(AlertType.INFORMATION);
		al.setHeaderText("Message");
		al.setContentText(msg);
		al.showAndWait();
	}
	
	
	
	void doadd() 
	{ 

		 try {
				
				pst = con.prepareStatement("select * from loginup where sname=?");
				pst.setString(1, "Amit" );
				
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
						name = rs.getString("sname");
					    pwd = rs.getString("pwd");	

				}
				rs.close();
				System.out.println(name);
				if(name.equals(txtuid.getText()) && pwd.equals(txtpwd.getText()))
				{
					showMsg("You have successfully logged in ");
					new dashboard();
					
				}
				else
						showMsg("Either Username or password is incorrect ");
			
			} catch (SQLException e) 
		    {
				e.printStackTrace();
			}
	}
	

}
