package Database_user;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tBranch_Master{
	
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
	TableView<cBranch_Master> tbl;
	HBox hb=new HBox();
	Text title;
	java.sql.Date   sqld,sqld1;
		Stage stage;
	JFXDatePicker dp=new JFXDatePicker();

	
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

	@SuppressWarnings("unchecked")
	
	tBranch_Master() {
		try {
			doConnect();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		stage = new Stage();
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
				title = new Text("Branch Master");
				title.setFont(Font.font("Lucida Sans", FontWeight.BOLD, 40));
				title.setFill(Color.BLACK);
				//GridPane.setConstraints(title, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(20, 0, 20, 0) );
		     	grid.add(title, 0, 0, 4, 1);
		     	
		     	//grid.setGridLinesVisible(true);
 tbl = new TableView<cBranch_Master>();


TableColumn<cBranch_Master,String> col_id=new TableColumn<>("Branch");
col_id.setMinWidth(200);
col_id.setCellValueFactory(new PropertyValueFactory<>("vbranch"));

TableColumn<cBranch_Master,String> col_mob=new TableColumn<>("Address");
col_mob.setMinWidth(200);
col_mob.setCellValueFactory(new PropertyValueFactory<>("vadr"));

TableColumn<cBranch_Master,String> col_adr=new TableColumn<>("Location");
col_adr.setMinWidth(200);
col_adr.setCellValueFactory(new PropertyValueFactory<>("vloc"));

tbl.getColumns().addAll(col_id,col_mob,col_adr);
tbl.setItems(tableFill());
grid.add(tbl, 0, 5, 8, 1);
Scene sc=new Scene(grid,800,550);
sc.getStylesheets().add("Database_user/application.css");
stage.setScene(sc);
stage.show();
	}

	ObservableList<cBranch_Master> tableFill() {
		ObservableList<cBranch_Master> ary=FXCollections.observableArrayList();
		try{
			prep=(PreparedStatement) conn.prepareStatement("select * from branch ");
			ResultSet rs=prep.executeQuery();
			
			while(rs.next())
			{
				ary.add(new cBranch_Master(rs.getString(1),rs.getString(2),rs.getString(3)));
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ary;		
	}
	
	}
	