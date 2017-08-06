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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class donation_record {
	
    private static final String EM1 = "1em";
    private static final String ERROR = "error";
    
    static Connection con;
   	PreparedStatement pst;

   	void doConnect() throws SQLException
   	{
   		try {
   			Class.forName("com.mysql.jdbc.Driver");
   			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regjava","root","amit");
   			System.out.println("ok");
   		} 
   		catch (ClassNotFoundException e) {

   			e.printStackTrace();
   		}
   	}
   	
PreparedStatement prepinst;
PreparedStatement prepdel;
PreparedStatement prepupd;
GridPane grid= new GridPane();

Text adu=new Text("Donation Record");
Text tuid=new Text("Donor's"); 

Text tamt=new Text("Amount"); 
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


JFXComboBox<String> vuid = new JFXComboBox<String>();
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
Stage st;
HBox hb=new HBox();

java.sql.Date dod;

Calendar cal=Calendar.getInstance();
//JFXDatePicker blueDatePicker = new JFXDatePicker();
JFXDatePicker dp=new JFXDatePicker(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE)));

JFXButton bn = new JFXButton("New");
JFXButton add = new JFXButton("Save".toUpperCase());


donation_record() {

try {
	doConnect();
} catch (SQLException e1) {
	
	e1.printStackTrace();
}
st=new Stage();
// TODO Auto-generated method stub
	
doFillUids();	
	
 // ************* Text Fields ****************************************************
	
	
	vamt.setPromptText("Enter the Amount...");
	RequiredFieldValidator vaamt = new RequiredFieldValidator();
	vaamt.setMessage("Amount Required");
	vaamt.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vamt.getValidators().add(vaamt);
	vamt.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vamt.validate();
	});
	
	
add.getStyleClass().add("button-raised");
bn.getStyleClass().add("button-raised");
dp.setStyle("-fx-font-size:15");
dp.setPromptText("Select Date");
dp.setLayoutX(200);
dp.setLayoutY(200);
dp.setPromptText("**");//not working
dp.requestFocus();


st.setTitle("jflAddUsers");


grid.setVgap(50);
grid.setHgap(40);
grid.setPrefSize(900,800);
grid.setPadding(new Insets(30));
grid.setGridLinesVisible(false);
adu.setFont(Font.font("Arial" ,FontWeight.BOLD,20));
grid.add(adu, 0, 0, 2, 1);
grid.add(tuid, 2, 1);
grid.add(tamt, 0, 2);
grid.add(dp, 2, 2);
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

grid.add(vuid, 3, 1);

grid.add(vamt,1 , 2 );
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
hb.getChildren().addAll(bn,add);

grid.add(hb, 0,8, 5, 1);

add.setOnAction(e->doadd());

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
			prepinst.setInt(i, Integer.parseInt(vpen.getText()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("noo");
}
void doadd() 
{ 

	try {
		
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String dos=format.format(cal.getTime());
		Date dosObj;
		try {
				dosObj =  format.parse(dos);
			    dod =new java.sql.Date(dosObj.getTime());	
		    }
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			prepinst=con.prepareStatement("insert into don_rec values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			prepinst.setString(1, vuid.getSelectionModel().getSelectedItem());
			prepinst.setInt(2, Integer.parseInt(vamt.getText()));
			prepinst.setDate(3, dod);
			check(4,vpen);
			check(5,vpenc);
			check(6,ver);
			check(7,vsh);
			check(8,vnot);
			check(9,vbag);
			check(10,vlunch);
			check(11,vbot);
			check(12,vsho);
			check(13,vsoc);
			check(14,vswe);
			check(15,vsoa);
			check(16,vtoo);
			check(17,vno);
			check(18,vclo);
			check(19,vfoo);
			
			prepinst.executeUpdate();
			prepinst.close();
			showMsg("Record Inserted....");
			
			doUpdate();
			
	} 
	catch (SQLException e )
	{
		e.printStackTrace();
	}
}

void doUpdate() 
{
	
	{ 
	try 
	 {
		prepinst=con.prepareStatement("update total_rec set tamt =tamt + ?, tpen=tpen +?, tpenc=tpenc+ ?,ter=ter +?, tsh=tsh +?, tnot=tnot +?, tbag=tbag +?, tlunch=tlunch +?, tbot=tbot +?, tsho=tsho +?, tsoc=tsoc +?, tswe=tswe +?, tsoa=tsoa +?, ttop=ttoo, tno=tno +?, tclo=tclo +?, tfoo=tfoo +? where vbranch=?");
		
		check(1,vamt);
		check(2,vpen);
		check(3,vpenc);
		check(4,ver);
		check(5,vsh);
		check(6,vnot);
		check(7,vbag);
		check(8,vlunch);
		check(9,vbot);
		check(10,vsho);
		check(11,vsoc);
		check(12,vswe);
		check(13,vsoa);
		check(14,vtoo);
		check(15,vno);
		check(16,vclo);
		check(17,vfoo);
		prepinst.setString(18,"lol");
		
		prepinst.executeUpdate();
		prepinst.close();
		showMsg("Record Inserted....");

		int x=prepinst.executeUpdate();
		prepinst.close();
		if(x==0)
		showMsg("Invalid id");
		else
		showMsg("Record Updated....");
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	}
	//fuid.clear();
	//fpwd.clear();
	//fmob.clear();
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
	vuid.getItems().clear();
	try 
	{
		
		prepinst=con.prepareStatement("select distinct vuid from dreg" );
		ResultSet rs= prepinst.executeQuery();
		ArrayList<String>lst=new ArrayList<String>();
		
		while(rs.next())
		{
			String p=rs.getString("vuid");
			lst.add(p);
		}
		vuid.getItems().addAll(lst);
		rs.close();
	}
	catch (SQLException e)
	{
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
}

}
