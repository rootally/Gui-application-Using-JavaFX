package Database_user;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import de.jensd.fx.glyphs.GlyphsBuilder;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class List_Issue {
	
    private static final String EM1 = "1em";
    private static final String ERROR = "error";
    
    

    void doConnect() throws SQLException
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/regjava","root","amit");
		}catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
	}
static Connection con;
PreparedStatement prepinst;
PreparedStatement prepdel;
PreparedStatement prepupd;
GridPane grid= new GridPane();

Text adu=new Text("Inventory");
DropShadow ds = new DropShadow();



Text ttamt=new Text("Total Amount"); 
Text cpenc = new Text("Pencil's");
Text cpen = new Text("Pen");
Text cer = new Text("Eraser");
Text csh = new Text("Sharpner's");
Text cnot = new Text("Notebook");
Text cbag = new Text("Bag");
Text clunch = new Text("Lunch Box");
Text cbot = new Text("Bottles");
Text csho = new Text("Shoes");
Text csoc = new Text("Socks");
Text cswe = new Text("Sweater");
Text csoa = new Text("Soap");
Text ctoo = new Text("ToothPaste");
Text cno = new Text("Novel's");
Text cclo = new Text("Clothes");
Text cfoo = new Text("Football");
Text cglo = new Text("Gloves");
Text cfir = new Text("First-Aid");
Text cglu = new Text("Glue");
Text cpro = new Text("Projector");
Text cclok = new Text("Clock's");


JFXTextField vamt = new JFXTextField();


JFXTextField vpenc = new JFXTextField();
JFXTextField vpen = new JFXTextField();
JFXTextField ver = new JFXTextField();
JFXTextField vsh = new JFXTextField();
JFXTextField vnot = new JFXTextField();
JFXTextField vbag = new JFXTextField();
JFXTextField vlunch = new JFXTextField();
JFXTextField vbot = new JFXTextField();
JFXTextField vsho = new JFXTextField();
JFXTextField vsoc = new JFXTextField();
JFXTextField vswe = new JFXTextField();
JFXTextField vsoa = new JFXTextField();
JFXTextField vtoo = new JFXTextField();
JFXTextField vno = new JFXTextField();
JFXTextField vclo = new JFXTextField();
JFXTextField vfoo = new JFXTextField();
JFXTextField vglo = new JFXTextField();
JFXTextField vfir = new JFXTextField();
JFXTextField vglu = new JFXTextField();
JFXTextField vpro = new JFXTextField();
JFXTextField vclok = new JFXTextField();

int flag=0;

int tpenc = 0;
int tamt = 0;
int tpen = 0;
int ter = 0;
int tsh = 0;
int tnot = 0;
int tbag = 0;
int tlunch = 0;
int tbot = 0;
int tsho = 0;
int tsoc = 0;
int tswe = 0;
int tsoa = 0;
int ttoo = 0;
int tno = 0;
int tclo = 0;
int tfoo = 0;
HBox hb=new HBox();
Stage st;
java.sql.Date dod;

//JFXButton bn = new JFXButton("New");
JFXButton add = new JFXButton("Close");


List_Issue() {
	
	try {
		doConnect();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
	
	st =new Stage();

// TODO Auto-generated method stub
	

doFillUids();	
ds.setOffsetX(7.0f);
ds.setOffsetY(7.0f);
adu.setEffect(ds);

 // ************* Text Fields ****************************************************
	
		
add.getStyleClass().add("button-raised");
st.setTitle("jflAddUsers");


grid.setVgap(50);
grid.setHgap(40);
grid.setPrefSize(1400,800);
grid.setPadding(new Insets(30));
grid.setGridLinesVisible(false);
adu.setFont(Font.font("Arial" ,FontWeight.BOLD,60));
grid.add(adu, 3, 0, 3, 2);

grid.add(ttamt, 2, 2);
//grid.add(dp, 5, 2,2,1);
grid.add(cpen, 0, 4);
grid.add(cpenc, 2, 4);
grid.add(cer, 4, 4);
grid.add(csh, 6, 4);
grid.add(cnot, 0, 5);
grid.add(cbag, 2, 5);
grid.add(clunch, 4, 5);
grid.add(cbot, 6, 5);

grid.add(csho, 0, 6);
grid.add(csoc, 2, 6);
grid.add(cswe, 4, 6);
grid.add(csoa, 6, 6);

grid.add(ctoo, 0, 7);
grid.add(cno, 2, 7);
grid.add(cclo, 4, 7);
grid.add(cfoo, 6, 7);


grid.add(vamt,3, 2,2,1 );
grid.add(vpen, 1, 4);
grid.add(vpenc,3 , 4 );
grid.add(ver,5 ,4 );
grid.add(vsh, 7, 4);

grid.add(vnot, 1, 5);
grid.add(vbag, 3, 5);
grid.add(vlunch,5, 5);
grid.add(vbot, 7, 5);

grid.add(vsho, 1, 6);
grid.add(vsoc, 3, 6);
grid.add(vswe, 5, 6);
grid.add(vsoa, 7, 6);

grid.add(vtoo, 1, 7);
grid.add(vno, 3, 7);
grid.add(vclo, 5, 7);
grid.add(vfoo, 7, 7);



hb.setSpacing(20);
hb.getChildren().addAll(add);

grid.add(hb, 0,8, 5, 1);



Scene sc=new Scene(grid);
sc.getStylesheets().add("Database_user/application.css");
st.setScene(sc);
st.show();
}

void check(int i, JFXTextField vv)
{
	if(vv.getText().isEmpty())
		try {
			prepinst.setInt(i, 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	else
		try {
			prepinst.setInt(i, Integer.parseInt(vv.getText()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("noo");
}

int check2(int i, JFXTextField vv, int t)
{
	if(vv.getText().isEmpty())
		try {
			prepinst.setInt(i, 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	else
	{
		if(t< Integer.parseInt(vpen.getText()) )
		{
			showMsg("Issue amount cannot be greater than the Inventory amount");
			flag=1;
		}
		
		try {
			prepinst.setInt(i, (Integer.parseInt(vpen.getText())));
			t=t-Integer.parseInt(vpen.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return t;
}


void showMsg(String msg)
{
	Alert alert =new Alert(AlertType.WARNING);
	alert.setTitle("Alert");
	alert.setHeaderText("Value Missing ");
	alert.setContentText(msg);
	alert.show();
}

void doFillUids()
{
	//vbranch.getItems().clear();
	try 
	{
		
		prepinst=con.prepareStatement("select * from total_rec where vbranch=?" );
		prepinst.setString(1, "lol");
		
		ResultSet rs= prepinst.executeQuery();
		//ArrayList<String>lst=new ArrayList<String>();

		tpenc=0;

		while(rs.next())
		{
				 tamt = rs.getInt(2);
				 tpen = rs.getInt(3);
				 tpenc = rs.getInt(4);
				 ter = rs.getInt(5);
				 tsh = rs.getInt(6);
				 tnot = rs.getInt(7);
				 tbag = rs.getInt(8);
				 tlunch = rs.getInt(9);
				 tbot = rs.getInt(10);
				 tsho = rs.getInt(11);
				 tsoc = rs.getInt(12);
				 tswe = rs.getInt(13);
				 tsoa = rs.getInt(14);
				 ttoo = rs.getInt(15);
				 tno = rs.getInt(16);
				 tclo = rs.getInt(17);
				 tfoo = rs.getInt(18);
				
			
		}
		
		rs.close();
		
				 
		 vamt.setText(tamt + "");
		 vpenc.setText(tpenc + "");
		 vpen.setText(tpen+ "");
		 ver.setText(ter+ "");
		 vsh.setText(tsh+ "");
		 vnot.setText(tnot+ "");
		 vbag.setText(tbag+ "");
		 vlunch.setText(tlunch+ "");
		 vbot.setText(tbot+ "");
		 vsho.setText(tsho+ "");
		 vsoc.setText(tsoc+ "");
		 vswe.setText(tswe+ "");
		 vsoa.setText(tsoa+ "");
		 vtoo.setText(ttoo+ "");
		 vno.setText(tno+ "");
		 vclo.setText(tclo+ "");
		 vfoo.setText(tfoo+ "");
		
	}
	catch (SQLException e)
	{
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
}


}
