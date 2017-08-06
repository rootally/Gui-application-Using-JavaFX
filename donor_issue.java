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

public class donor_issue {
	
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
Text tbranch =new Text("Branch"); 

Text ttamt=new Text("Amount"); 

Text cpenc;
Text cpen, cer,csh,cbag,clunch,cbot,csho, csoc, cswe, csoa, ctoo, cno,cnot, cclo, cfoo, cglo, cfir,cglu, cpro,cclok;

JFXComboBox<String> vbranch = new JFXComboBox<String>();
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

Calendar cal=Calendar.getInstance();
JFXDatePicker dp=new JFXDatePicker(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE)));

//JFXButton bn = new JFXButton("New");
JFXButton add = new JFXButton("Issue".toUpperCase());

donor_issue(){
	
	try {
		doConnect();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
	st=new Stage();
// TODO Auto-generated method stub
	
doFilllabel();
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
//bn.getStyleClass().add("button-raised");
dp.setStyle("-fx-font-size:15");
dp.setPromptText("Select Date");
dp.setLayoutX(200);
dp.setLayoutY(200);
dp.setPromptText("**");//not working
dp.requestFocus();

st.setTitle("jflAddUsers");


grid.setVgap(50);
grid.setHgap(40);
grid.setPrefSize(1400,800);
grid.setPadding(new Insets(30));
grid.setGridLinesVisible(false);
adu.setFont(Font.font("Arial" ,FontWeight.BOLD,20));
grid.add(adu, 0, 0, 2, 1);
grid.add(tbranch, 3, 1);
grid.add(ttamt, 1, 2);
grid.add(dp, 5, 2,2,1);
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

grid.add(vbranch, 4, 1,2,1);

grid.add(vamt,2, 2,2,1 );
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

add.setOnAction(e->doadd());
//bn.setOnAction(e->doclear());

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
		
		
			prepinst=con.prepareStatement("insert into branch_rec values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			prepinst.setString(1, vbranch.getSelectionModel().getSelectedItem());
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
			
			doadd2();
			
	} 
	catch (SQLException e )
	{
		e.printStackTrace();
	}
	
}

void doadd2() 
{ 
	flag=0;

	try {
		
			prepinst=con.prepareStatement("update total_rec set tamt =tamt- ?, tpen=tpen-?, tpenc=tpenc- ?,ter=ter -?, tsh=tsh -?, tnot=tnot -?, tbag=tbag -?, tlunch=tlunch -?, tbot=tbot -?, tsho=tsho -?, tsoc=tsoc -?, tswe=tswe -?, tsoa=tsoa -?, ttoo=ttoo-?, tno=tno -?, tclo=tclo -?, tfoo=tfoo -? where vbranch=?");
			
			tamt=		check2(1,vamt,tamt);
			tpen=		check2(2,vpen,tpen);
			tpenc=		check2(3,vpenc,tpenc);
			ter=		check2(4,ver,ter);
			tsh=		check2(5,vsh,tsh);
			tnot=		check2(6,vnot,tnot);
			tbag=		check2(7,vbag,tbag);
			tlunch=		check2(8,vlunch,tlunch);
			tbot=		check2(9,vbot,tbot);
			tsho=		check2(10,vsho,tsho);
			tsoc=		check2(11,vsoc,tsoc);
			tswe=		check2(12,vswe,tswe);
			tsoa=		check2(13,vsoa,tsoa);
			ttoo=		check2(14,vtoo,ttoo);
			tno=		check2(15,vno,tno);
			tclo=	check2(16,vclo,tclo);
			tfoo=	check2(17,vfoo,tfoo);
			prepinst.setString(18,"lol");
			//if(flag==0)
			prepinst.executeUpdate();
			prepinst.close();
			showMsg("Record Inserted....");
	} 
	catch (SQLException e )
	{
		e.printStackTrace();
	}
	System.out.println(tpenc);
	 
	 cpenc.setText("Pencil's"+"    "+tpenc);
	 cpen.setText("Pen"+"    "+"    "+tpen);
	 cer.setText("Eraser"+"    "+"    "+ter);
	 csh.setText("Sharpner's"+"    "+tsh);
	 cnot.setText("Notebook"+"    "+tnot);
	 cbag.setText("Bag"+"    "+tbag);
	 clunch.setText("Lunch Box"+"    "+tlunch);
	 cbot.setText("Bottles"+"    "+tbot);
	 csho.setText("Shoes"+"    "+tsho);
	 csoc.setText("Socks"+"    "+tsoc);
	 cswe.setText("Sweater"+"    "+tswe);
	 csoa.setText("Soap"+"    "+tsoa);
	 ctoo.setText("ToothPaste"+"    "+ttoo);
	 cno.setText("Novel's"+"    "+tno);
	 cclo.setText("Clothes"+"    "+tclo);
	 cfoo.setText("Football"+"    "+tfoo);
	
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
		
		 cpenc = new Text("Pencil's"+"    "+tpenc);
		 
		 //cpenc.setFont(Font.font("Verdana",FontWeight.BOLD, 18));
		 
		 cpen = new Text("Pen"+"    "+"    "+tpen);
		 cer = new Text("Eraser"+"    "+"    "+ter);
		 csh = new Text("Sharpner's"+"    "+tsh);
		 cnot = new Text("Notebook"+"    "+tnot);
		 cbag = new Text("Bag"+"    "+tbag);
		 clunch = new Text("Lunch Box"+"    "+tlunch);
		 cbot = new Text("Bottles"+"    "+tbot);
		 csho = new Text("Shoes"+"    "+tsho);
		 csoc = new Text("Socks"+"    "+tsoc);
		 cswe = new Text("Sweater"+"    "+tswe);
		 csoa = new Text("Soap"+"    "+tsoa);
		 ctoo = new Text("ToothPaste"+"    "+ttoo);
		 cno = new Text("Novel's"+"    "+tno);
		 cclo = new Text("Clothes"+"    "+tclo);
		 cfoo = new Text("Football"+"    "+tfoo);
		 
		 
	}
	catch (SQLException e)
	{
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
}

void doFilllabel()
{
	vbranch.getItems().clear();
	try 
	{
		
		prepinst=con.prepareStatement("select distinct vbranch from branch" );
		ResultSet rs= prepinst.executeQuery();
		ArrayList<String>lst=new ArrayList<String>();
		
		while(rs.next())
		{
			String p=rs.getString("vbranch");
			lst.add(p);
		}
		vbranch.getItems().addAll(lst);
		rs.close();
	}
	catch (SQLException e)
	{
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
}

}
