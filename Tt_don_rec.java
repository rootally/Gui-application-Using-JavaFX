package Database_user;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.mysql.jdbc.Connection;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tt_don_rec {

	static Connection conn;
	PreparedStatement prep;
	Text ttl=new Text("All Customers");
	Text to = new Text("to");
	Text from = new Text("Date from");
	Text don =new Text("Donor");
	//ComboBox<String> c1=new ComboBox<String>();
	JFXTextField t1 = new JFXTextField();
	JFXButton b1=new JFXButton("Fetch");
	Button b2=new Button("All Cusomers");
	JFXButton b3=new JFXButton("Google");
	GridPane grid=new GridPane();
	TableView<TDonorRecord> tbl;
	HBox hb=new HBox();
	Text title;
	java.sql.Date   sqld,sqld1;
	
   
	
	JFXDatePicker dp=new JFXDatePicker();

	Stage stage;
	JFXDatePicker dp1=new JFXDatePicker();
	
	JFXButton add = new JFXButton("Issue".toUpperCase());
	
	void doConnect() throws SQLException
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/regjava","root","amit");
		}catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
	}

	
	Tt_don_rec()
	{
		
		try {
			doConnect();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		stage =new Stage();
		
		 //------grid----------
	    grid = new GridPane();
		grid.setGridLinesVisible(false);
		//grid.setPadding(new Insets(100,0,0,160));
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(15);
		grid.setVgap(15);
		
		
		
b3.getStyleClass().add("button-raised");
b1.getStyleClass().add("button-raised");
		
		//-----text--------------
				title = new Text("Received Donations");
				title.setFont(Font.font("Lucida Sans", FontWeight.BOLD, 40));
				title.setFill(Color.BLACK);
				//GridPane.setConstraints(title, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(20, 0, 20, 0) );
		     	grid.add(title, 0, 0, 4, 1);
		     	
		     	grid.add(don, 0, 1);
		     	grid.add(t1, 1, 1);
		     	grid.add(b3, 2, 1,2,1);
		     	grid.add(from, 0, 2);
		     	grid.add(dp, 1, 2);
		     	grid.add(to, 2, 2);
		     	grid.add(dp1, 3, 2);

		     	grid.add(b1, 4, 2);
		     	//grid.setGridLinesVisible(true);
 tbl = new TableView<TDonorRecord>();


TableColumn<TDonorRecord,String> col_id=new TableColumn<>("Donor Id");
col_id.setMinWidth(100);
col_id.setCellValueFactory(new PropertyValueFactory<>("vuid"));

TableColumn<TDonorRecord,String> col_mob=new TableColumn<>("Mobile No");
col_mob.setMinWidth(100);
col_mob.setCellValueFactory(new PropertyValueFactory<>("vmob"));

TableColumn<TDonorRecord,String> col_adr=new TableColumn<>("Address");
col_adr.setMinWidth(100);
col_adr.setCellValueFactory(new PropertyValueFactory<>("vadr"));

TableColumn<TDonorRecord,String> col_loc=new TableColumn<>("Location");
col_loc.setMinWidth(100);
col_loc.setCellValueFactory(new PropertyValueFactory<>("vcity"));

TableColumn<TDonorRecord,String> col_time=new TableColumn<>("Date");
col_time.setMinWidth(100);
col_time.setCellValueFactory(new PropertyValueFactory<>("vdate"));

tbl.getColumns().addAll(col_id,col_mob,col_adr,col_loc,col_time);
tbl.setItems(tableFill());
b1.setOnAction(e->{tbl.setItems(acdDate());});
b3.setOnAction(e->{tbl.setItems(googler());});
grid.add(tbl, 0, 5, 8, 1);
Scene sc=new Scene(grid,1100,600);
sc.getStylesheets().add("Database_user/application.css");
stage.setScene(sc);
stage.show();
	}

	ObservableList<TDonorRecord> tableFill() {
		ObservableList<TDonorRecord> ary=FXCollections.observableArrayList();
		try{
			prep=(PreparedStatement) conn.prepareStatement("select * from dreg  ");
			ResultSet rs=prep.executeQuery();
			
			while(rs.next())
			{
				ary.add(new TDonorRecord(rs.getString(1),rs.getString("vmob"),rs.getString("vadr"),rs.getString("vcity"),rs.getString("dob")));
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ary;		
	}
		
	ObservableList<TDonorRecord> acdDate()
	{
		ObservableList<TDonorRecord> ary=FXCollections.observableArrayList();
		
			
			DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
			
			String dos=((TextField)dp.getEditor()).getText();
			Date dosObj;
			try {
					dosObj =  format.parse(dos);
				    sqld =new java.sql.Date(dosObj.getTime());	
			    }
			catch (ParseException e) {
				// TODO Auto-generated catch block
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
			prep=(PreparedStatement) conn.prepareStatement("Select * From dreg where dob>=? and dob<=?");
			prep.setDate(1, sqld);
			prep.setDate(2, sqld1);
			ResultSet rs=prep.executeQuery();
			while(rs.next())
			{
				ary.add(new TDonorRecord(rs.getString("vuid"),rs.getString("vmob"),rs.getString("vadr"),rs.getString("vcity"),rs.getString("dob")));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ary;
	}
	
	ObservableList<TDonorRecord> googler()
	{
		ObservableList<TDonorRecord> ary=FXCollections.observableArrayList();
		try{
			prep=(PreparedStatement) conn.prepareStatement("select * from dreg where vuid like '%"+t1.getText()+"%'");
			ResultSet rs=prep.executeQuery();
			while(rs.next())
			{
				ary.add(new TDonorRecord(rs.getString("vuid"),rs.getString("vmob"),rs.getString("vadr"),rs.getString("vcity"),rs.getString("dob")));
					
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ary;		
	}
	}
	