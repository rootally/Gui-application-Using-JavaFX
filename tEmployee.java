package Database_user;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tEmployee {
	static Connection conn;
	PreparedStatement prep;
	static Connection con;
	PreparedStatement prepinst;
	Text ttl=new Text("All Customers");
	Text to = new Text("to");
	Text from = new Text("Date from");
	Text don =new Text("Branch");
	//ComboBox<String> c1=new ComboBox<String>();
	JFXComboBox<String> cbranch = new JFXComboBox<String>();

	JFXButton b1=new JFXButton("Fetch All");
	Button b2=new Button("All Cusomers");
	JFXButton b3=new JFXButton("Google");
	GridPane grid=new GridPane();
	TableView<cEmployee> tbl;
	HBox hb=new HBox();
	HBox hb1=new HBox();
	Text title;
	java.sql.Date   sqld,sqld1;
	JFXTextField t1 = new JFXTextField();
   
	Stage stage;
	
	JFXDatePicker dp=new JFXDatePicker();

	
	JFXDatePicker dp1=new JFXDatePicker();
	
	void doConnect() throws SQLException
	{
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regjava","root","amit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ok");
		
	}

	@SuppressWarnings("unchecked")
	public tEmployee() {
		
		try {
			doConnect();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		stage =new Stage();
		 //------grid----------
	    grid = new GridPane();
		//grid.setPadding(new Insets(100,0,0,175));
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(15);
		grid.setVgap(15);
		
		
		
				b3.getStyleClass().add("button-raised");
				b1.getStyleClass().add("button-raised");
		
		//-----text--------------
				title = new Text("Employee");
				title.setFont(Font.font("Lucida Sans", FontWeight.BOLD, 40));
				title.setFill(Color.BLACK);
				//GridPane.setConstraints(title, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(75, 0, 75, 0) );
		     	grid.add(title, 1, 0, 4, 1);
		     	//hb.setSpacing(75);
		     	//grid.add(hb, 5, 1);
		     	
		     	hb1.setSpacing(35);
		     	hb1.getChildren().addAll(don,t1,b3,b1);
		     	
		     	//hb1.getChildren().addAll(from,dp,to,dp1,b1);
		     	
		     	
		     	grid.add(hb1, 3, 2);
		     	
		     	//grid.setGridLinesVisible(true);
 tbl = new TableView<cEmployee>();


TableColumn<cEmployee,String> col_id=new TableColumn<>("Name");
col_id.setMinWidth(100);
col_id.setCellValueFactory(new PropertyValueFactory<>("fuid"));

TableColumn<cEmployee,Integer> col_mob=new TableColumn<>("Mobile");
col_mob.setMinWidth(100);
col_mob.setCellValueFactory(new PropertyValueFactory<>("vmob"));

TableColumn<cEmployee,Integer> col_adr=new TableColumn<>("Email-Id");
col_adr.setMinWidth(75);
col_adr.setCellValueFactory(new PropertyValueFactory<>("vemail"));

TableColumn<cEmployee,Integer> col_loc=new TableColumn<>("Address");
col_loc.setMinWidth(100);
col_loc.setCellValueFactory(new PropertyValueFactory<>("vadr"));

TableColumn<cEmployee,Integer> col_time=new TableColumn<>("City");
col_time.setMinWidth(100);
col_time.setCellValueFactory(new PropertyValueFactory<>("vcity"));

TableColumn<cEmployee,Integer> col1=new TableColumn<>("Salary");
col1.setMinWidth(75);
col1.setCellValueFactory(new PropertyValueFactory<>("vsal"));

TableColumn<cEmployee,Integer> col2=new TableColumn<>("Designation");
col2.setMinWidth(75);
col2.setCellValueFactory(new PropertyValueFactory<>("cdesg"));

TableColumn<cEmployee,Integer> col3=new TableColumn<>("Branch");
col3.setMinWidth(75);
col3.setCellValueFactory(new PropertyValueFactory<>("cbranch"));

tbl.getColumns().addAll(col_id,col_mob,col_adr,col_loc,col_time,col1,col2,col3);
tbl.setItems(tableFill());
b3.setOnAction(e->{tbl.setItems(googler());});
b1.setOnAction(e->{tbl.setItems(tableFill());});

GridPane.setConstraints(tbl, 0, 5, 10, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10,75,10,90));

grid.add(tbl, 0, 5, 10, 4);
Scene sc=new Scene(grid,1400,800);
sc.getStylesheets().add("Database_user/application.css");
stage.setScene(sc);
stage.show();
	}

	ObservableList<cEmployee> tableFill() {
		ObservableList<cEmployee> ary=FXCollections.observableArrayList();
		try{
			prep=(PreparedStatement) con.prepareStatement("select * from employe ");
			ResultSet rs=prep.executeQuery();
			
			while(rs.next())
			{
			 ary.add(new cEmployee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ary;		
	}

	ObservableList<cEmployee> googler()
	{
		ObservableList<cEmployee> ary=FXCollections.observableArrayList();
		try{
			prep=(PreparedStatement) conn.prepareStatement("select * from employe where vuid like '%"+t1.getText()+"%'");
			ResultSet rs=prep.executeQuery();
			while(rs.next())
			{
				 ary.add(new cEmployee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
								
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ary;		
	}
	
	
	}
	