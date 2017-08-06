package Database_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.validation.RequiredFieldValidator;

import de.jensd.fx.glyphs.GlyphsBuilder;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class ComboList {
	
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

DropShadow ds = new DropShadow();

Text adu=new Text("Volunteer's");

//Text adu=new Text("Add Users");
Text tuid=new Text("Name"); 
Text tmob=new Text("Mobile");
Text tadr=new Text("Address");
Text tcity=new Text("City");
Text tocu=new Text("Occupation"); 
Text temail=new Text("Email-Id"); 
Text tgender=new Text("Gender"); 
Text tstate=new Text("State"); 

JFXTextField fuid = new JFXTextField();
RadioButton chk;

JFXRadioButton male = new JFXRadioButton("Male");
JFXRadioButton female = new JFXRadioButton("Female");

JFXTextField vmob = new JFXTextField();
JFXTextField vadr = new JFXTextField();
JFXTextField vcity = new JFXTextField();
JFXTextField vocu = new JFXTextField();
JFXTextField vemail = new JFXTextField();


HBox hb=new HBox();

final ToggleGroup group = new ToggleGroup();
String gender="";
Stage st;
JFXToggleButton toggle = new JFXToggleButton();
int status=0;   

JFXButton bn = new JFXButton("New");
JFXButton add = new JFXButton("Add".toUpperCase());
JFXButton bs = new JFXButton("Search");
JFXButton del = new JFXButton("Delete");
JFXButton bu = new JFXButton("Update");


ComboList() {
	try {
		doConnect();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
	st=new Stage();

// TODO Auto-generated method stub

	ds.setOffsetX(3.0f);
	ds.setOffsetY(3.0f);
    adu.setFont(Font.font("AR BONNIE", 48));
	adu.setEffect(ds);

 // ************* Text Fields ****************************************************
	
	vmob.setPromptText("Enter Mobile No...");
	RequiredFieldValidator vamob = new RequiredFieldValidator();
	vamob.setMessage("Mobile Required");
	vamob.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vmob.getValidators().add(vamob);
	vmob.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vmob.validate();
	});
	
	vadr.setPromptText("Enter your Address..");
	RequiredFieldValidator vaadr = new RequiredFieldValidator();
	vaadr.setMessage("Address Required");
	vaadr.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vadr.getValidators().add(vaadr);
	vadr.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vmob.validate();
	});
	
	vcity.setPromptText("Fill your city name...");
	RequiredFieldValidator vacity = new RequiredFieldValidator();
	vacity.setMessage("City Required");
	vacity.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vcity.getValidators().add(vacity);
	vcity.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vcity.validate();
	});
	
	vocu.setPromptText("Enter your Occupation...");
	RequiredFieldValidator vaocu = new RequiredFieldValidator();
	vaocu.setMessage("Mobile Required");
	vaocu.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vocu.getValidators().add(vaocu);
	vocu.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vocu.validate();
	});
	
	vemail.setPromptText("Enter your Email-Id...");
	RequiredFieldValidator vaemail = new RequiredFieldValidator();
	vaocu.setMessage("Email Required");
	vaocu.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vocu.getValidators().add(vaemail);
	vocu.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vocu.validate();
	});
	
	
	male.setPadding(new Insets(10));
	male.setToggleGroup(group);
	//JFXRadioButton female = new JFXRadioButton("Female");
	female.setPadding(new Insets(10));
	female.setToggleGroup(group);

	
//doFillUids();


bn.getStyleClass().add("button-raised");
add.getStyleClass().add("button-raised");
del.getStyleClass().add("button-raised");
bs.getStyleClass().add("button-raised");
bu.getStyleClass().add("button-raised");

//fuid.getItems().add(0,"Select");
//fuid.getSelectionModel().select(0);
//fuid.setEditable(true);
st.setTitle("Volunteer's!");
// grid.setGridLinesVisible(true);
grid.setVgap(30);
grid.setHgap(20);
grid.setPrefSize(700,500);
grid.setPadding(new Insets(30));
grid.setGridLinesVisible(false);
//adu.setFont(Font.font("Arial" ,FontWeight.BOLD,20));
grid.add(adu, 0, 0, 3, 2);
grid.add(tuid, 0, 2);
grid.add(tmob, 0, 3);
grid.add(tadr, 0, 4);
grid.add(tcity, 0, 5);
grid.add(tocu, 0, 6);
grid.add(temail, 0, 9);
grid.add(tgender,0, 7);
grid.add(fuid, 1, 2);
grid.add(tstate, 0, 8);
	
grid.add(vmob,1 , 3 );
grid.add(vadr,1 , 4 );
grid.add(vcity, 1, 5);
grid.add(vocu, 1, 6);
grid.add(vemail, 1, 9);

grid.add(male, 1, 7);
grid.add(female, 2, 7);

grid.add(toggle, 1, 8);
hb.setSpacing(20);
grid.add(bs, 3, 2);
hb.getChildren().addAll(bn,add,del,bu);
grid.add(hb, 0,10, 5, 1);
add.setOnAction(e->doadd());
del.setOnAction(e->dodel());
bs.setOnAction(e->doSearch());
bu.setOnAction(e->doUpdate());
Scene sc=new Scene(grid);
sc.getStylesheets().add("Database_user/application.css");
st.setScene(sc);
st.show();
}
void doadd() 
{ 
//System.out.println(fuid.getSelectionModel().getSelectedItem());
//System.out.println(fpwd.getText());
//System.out.println(fmob.getText());

	if(male.isSelected()) 
        gender="Male";
	else
		gender = "Female";

if(toggle.isSelected() == true)
{
	status=1;
}

try {

prepinst=con.prepareStatement("insert into users values(?,?,?,?,?,?,?,?)");

prepinst.setString(1, fuid.getText());
prepinst.setString(2, vmob.getText());
prepinst.setString(3, vadr.getText());
prepinst.setString(4, vcity.getText());
prepinst.setString(5, vocu.getText());
prepinst.setString(6, gender);
prepinst.setInt(7, status);
prepinst.setString(8, vemail.getText());



prepinst.executeUpdate();
prepinst.close();
showMsg("Record Inserted....");
} 
catch (SQLException e )
{
// TODO Auto-generated catch block
e.printStackTrace();
}
}
//fuid.clear();
//fpwd.clear();
//fmob.clear();


void doUpdate() 
{
	
	{ 
	try 
	 {
		if(male.isSelected()) 
	        gender="Male";
		else
			gender = "Female";
		
		if(toggle.isSelected() == true)
			status=1;
		else
			status=0;
		
		
		prepinst=con.prepareStatement("update users set vmob=?, vadr=?, vcity=?, vocu=?, gender=?, state=?, vemail=? where fuid=?");
		prepinst.setString(8, fuid.getText());
		prepinst.setString(1, vmob.getText());
		prepinst.setString(2, vadr.getText());
		prepinst.setString(3, vcity.getText());
		prepinst.setString(4, vocu.getText());
		prepinst.setString(5, gender);
		prepinst.setInt(6, status);
		prepinst.setString(7, vemail.getText());
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
void dodel() 
{
/*if(fuid.getText().isEmpty() || fpwd.getText().isEmpty())
{
showMsg("Either userid, password is not entered.\n"
+ "Password must be entered to verify acc to delete it");
}
else*/
{
try 
	{
		prepdel=con.prepareStatement("delete from users where fuid=?");
		prepdel.setString(1, fuid.getText());
		
		int x=prepdel.executeUpdate();
		
		if(x==1)
		{
			showMsg(" Record Deleted");
			
		}
		else
		showMsg(" Invalid Id");
		prepdel.close();
	}
catch (SQLException e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}
void doSearch()
{
try
	{
		prepinst=con.prepareStatement("select * from users where fuid=?" );
		prepinst.setString(1, fuid.getText());
		ResultSet rs= prepinst.executeQuery();
		if(rs.next())
		{
			vmob.setText(rs.getString("vmob"));
			vadr.setText(rs.getString("vadr"));
			vcity.setText(rs.getString("vcity"));
			vocu.setText(rs.getString("vocu"));
			String gen= rs.getString("gender");
			
			 if(gen .equals("Male"))
				 male.setSelected(true);
			 else
				 female.setSelected(true);
			 int stat = rs.getInt("state");
			 	if(stat == 1)
			 		toggle.setSelected(true);
			 	else
			 		toggle.setSelected(false);
			 	
			vemail.setText(rs.getString("vemail"));
		}
		else
			showMsg("Invalid ID");
		rs.close();
	}
catch (SQLException e)
	{
		e.printStackTrace();
	}
}
//=========================

}
