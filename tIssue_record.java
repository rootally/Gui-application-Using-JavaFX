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

public class tIssue_record extends Application{
	static Connection conn;
	PreparedStatement prep;
	static Connection con;
	PreparedStatement prepinst;
	Text ttl=new Text("All Customers");
	Text to = new Text("to");
	Text dum = new Text("");
	Text from = new Text("Date from");
	Text don =new Text("Donor");
	//ComboBox<String> c1=new ComboBox<String>();
	JFXComboBox<String> cdonor = new JFXComboBox<String>();

	JFXButton b1=new JFXButton("Fetch");
	Button b2=new Button("All Cusomers");
	JFXButton b3=new JFXButton("Google");
	GridPane grid=new GridPane();
	TableView<cDonation_Record> tbl;
	HBox hb=new HBox();
	HBox hb1=new HBox();
	Text title;
	java.sql.Date   sqld,sqld1;
	
   
	
	JFXDatePicker dp=new JFXDatePicker();

	
	JFXDatePicker dp1=new JFXDatePicker();
	
	JFXButton add = new JFXButton("Issue".toUpperCase());
	public static void main(String[] args)
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
		launch(args);
	}

	@SuppressWarnings("unchecked")
	public void start(Stage stage) throws Exception {
		
	doFillUids();
	cdonor.setPromptText("Donor's Name");
	cdonor.getSelectionModel().selectedIndexProperty().addListener((property,oldValue,newValue)->{
		tbl.setItems(doFetch());
    	
    });
		 //------grid----------
	    grid = new GridPane();
		//grid.setPadding(new Insets(100,0,0,160));
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(15);
		grid.setVgap(15);
		
		
		
				b3.getStyleClass().add("button-raised");
				b1.getStyleClass().add("button-raised");
		
		//-----text--------------
				title = new Text("Donation History");
				title.setFont(Font.font("Lucida Sans", FontWeight.BOLD, 40));
				title.setFill(Color.BLACK);
				//GridPane.setConstraints(title, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(30, 0, 30, 0) );
		     	grid.add(title, 1, 0, 4, 1);
		     	hb.setSpacing(50);
		     	hb.getChildren().addAll(don,cdonor);
		     	grid.add(hb, 5, 1);
		     	
		     	hb1.setSpacing(35);
		     	hb1.getChildren().addAll(from,dp,to,dp1,b1);
		     	
		     	
		     	grid.add(hb1, 5, 2);
		     	
		     	//grid.setGridLinesVisible(true);
 tbl = new TableView<cDonation_Record>();


TableColumn<cDonation_Record,String> col_id=new TableColumn<>(" Name ");
col_id.setMinWidth(100);
col_id.setCellValueFactory(new PropertyValueFactory<>("vuid"));

TableColumn<cDonation_Record,Integer> col_mob=new TableColumn<>("Amount");
col_mob.setMinWidth(100);
col_mob.setCellValueFactory(new PropertyValueFactory<>("vamt"));

TableColumn<cDonation_Record,Integer> col_adr=new TableColumn<>("Pen");
col_adr.setMinWidth(30);
col_adr.setCellValueFactory(new PropertyValueFactory<>("vpen"));

TableColumn<cDonation_Record,Integer> col_loc=new TableColumn<>("Pencil");
col_loc.setMinWidth(100);
col_loc.setCellValueFactory(new PropertyValueFactory<>("vpenc"));

TableColumn<cDonation_Record,Integer> col_time=new TableColumn<>("Eraser");
col_time.setMinWidth(100);
col_time.setCellValueFactory(new PropertyValueFactory<>("ver"));

TableColumn<cDonation_Record,Integer> col1=new TableColumn<>("Sharpner");
col1.setMinWidth(30);
col1.setCellValueFactory(new PropertyValueFactory<>("vsh"));

TableColumn<cDonation_Record,Integer> col2=new TableColumn<>("Notebook");
col2.setMinWidth(30);
col2.setCellValueFactory(new PropertyValueFactory<>("vnot"));

TableColumn<cDonation_Record,Integer> col3=new TableColumn<>("Bag's");
col3.setMinWidth(30);
col3.setCellValueFactory(new PropertyValueFactory<>("vbag"));

TableColumn<cDonation_Record,Integer> col4=new TableColumn<>("L-Box");
col4.setMinWidth(30);
col4.setCellValueFactory(new PropertyValueFactory<>("vlunch"));

TableColumn<cDonation_Record,Integer> col5=new TableColumn<>("Bottle's");
col5.setMinWidth(30);
col5.setCellValueFactory(new PropertyValueFactory<>("vbot"));

TableColumn<cDonation_Record,Integer> col6=new TableColumn<>("Shoe's");
col6.setMinWidth(30);
col6.setCellValueFactory(new PropertyValueFactory<>("vsho"));

TableColumn<cDonation_Record,Integer> col7=new TableColumn<>("Socks");
col7.setMinWidth(30);
col7.setCellValueFactory(new PropertyValueFactory<>("vsoc"));

TableColumn<cDonation_Record,Integer> col8=new TableColumn<>("Sweater");
col8.setMinWidth(30);
col8.setCellValueFactory(new PropertyValueFactory<>("vswe"));

TableColumn<cDonation_Record,Integer> col9=new TableColumn<>("Soap");
col9.setMinWidth(30);
col9.setCellValueFactory(new PropertyValueFactory<>("vsoa"));

TableColumn<cDonation_Record,Integer> col10=new TableColumn<>("Toothpaste");
col10.setMinWidth(30);
col10.setCellValueFactory(new PropertyValueFactory<>("vtoo"));

TableColumn<cDonation_Record,Integer> col11=new TableColumn<>("Novel");
col11.setMinWidth(30);
col11.setCellValueFactory(new PropertyValueFactory<>("vno"));

tbl.getColumns().addAll(col_id,col_mob,col_adr,col_loc,col_time,col1,col2,col3,col4,col5,col6,col7,col8,col9,col10,col11);
tbl.setItems(tableFill());
b1.setOnAction(e->{tbl.setItems(acdDate());});

GridPane.setConstraints(tbl, 0, 5, 10, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10,80,10,90));

grid.add(tbl, 0, 5, 10, 4);
Scene sc=new Scene(grid,1400,800);
sc.getStylesheets().add("Database_user/application.css");
stage.setScene(sc);
stage.show();
	}

	ObservableList<cDonation_Record> tableFill() {
		ObservableList<cDonation_Record> ary=FXCollections.observableArrayList();
		try{
			prep=(PreparedStatement) con.prepareStatement("select * from don_rec  ");
			ResultSet rs=prep.executeQuery();
			
			while(rs.next())
			{
			 ary.add(new cDonation_Record(rs.getString("vuid"), rs.getInt(2),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9), rs.getInt(10), rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),rs.getInt(16),rs.getInt(17)));
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ary;		
	}
	
	ObservableList<cDonation_Record> doFetch() {
		ObservableList<cDonation_Record> ary=FXCollections.observableArrayList();
		try{
			prep=(PreparedStatement) con.prepareStatement("select * from don_rec where vuid=?  ");
			prep.setString(1, cdonor.getSelectionModel().getSelectedItem());
			ResultSet rs=prep.executeQuery();
			
			while(rs.next())
			{
			 ary.add(new cDonation_Record(rs.getString("vuid"), rs.getInt(2),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9), rs.getInt(10), rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),rs.getInt(16),rs.getInt(17)));
				
			}
			System.out.println("yes");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ary;		
	}
	
	ObservableList<cDonation_Record> acdDate()
	{
		ObservableList<cDonation_Record> ary=FXCollections.observableArrayList();
		
			
			DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
			
			String dos=((TextField)dp.getEditor()).getText();
			Date dosObj;
			try {
					dosObj =  format.parse(dos);
				    sqld =new java.sql.Date(dosObj.getTime());	
			    }
			catch (ParseException e) {
				
				e.printStackTrace();
			}
			
      DateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
			
			String dos1=((TextField)dp1.getEditor()).getText();
			Date dosObj1;
			try {
					dosObj1 =  format1.parse(dos1);
				    sqld1 =new java.sql.Date(dosObj1.getTime());	
			    }
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		try {
			prep=(PreparedStatement) con.prepareStatement("Select * From don_rec where dod>=? and dod<=?");
			prep.setDate(1, sqld);
			prep.setDate(2, sqld1);
			ResultSet rs=prep.executeQuery();
			while(rs.next())
			{
			   ary.add(new cDonation_Record(rs.getString("vuid"), rs.getInt(2),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9), rs.getInt(10), rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),rs.getInt(16),rs.getInt(17)));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ary;
	}
	
	void doFillUids()
	{
		cdonor.getItems().clear();
		try 
		{
			
			prepinst=(PreparedStatement) con.prepareStatement("select distinct vuid from don_rec" );
			ResultSet rs= prepinst.executeQuery();
			ArrayList<String>lst=new ArrayList<String>();
			
			while(rs.next())
			{
				String p=rs.getString("vuid");
				lst.add(p);
			}
			cdonor.getItems().addAll(lst);
			rs.close();
		}
		catch (SQLException e)
		{
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		}

	}
	
	
	
	}
	