package Database_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class employe {
	
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

Text adu=new Text("Add Employee");
Text tuid=new Text("Employee Name"); 
Text tmob=new Text("Mobile");
Text temail=new Text("Email-Id");
Text tadr=new Text("Address");
Text tcity=new Text("City");
Text tsal=new Text("Salary PM."); 

Text tdesg=new Text("Designation"); 
Text tbranch=new Text("Branch to Post"); 
BackgroundImage bg;

JFXComboBox<String> cdesg = new JFXComboBox<String>();
JFXComboBox<String> cbranch = new JFXComboBox<String>();


JFXTextField fuid = new JFXTextField();
JFXTextField vmob = new JFXTextField();
JFXTextField vemail = new JFXTextField();
JFXTextField vadr = new JFXTextField();
JFXTextField vcity = new JFXTextField();
JFXTextField vsal = new JFXTextField();

Stage st;
HBox hb=new HBox();

JFXButton bn = new JFXButton("New");
JFXButton add = new JFXButton("Save".toUpperCase());
JFXButton bs = new JFXButton("Search");
JFXButton del = new JFXButton("Delete");
JFXButton bu = new JFXButton("Update");

employe() {
	try {
		doConnect();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
	st=new Stage();
	
// TODO Auto-generated method stub
	
doFillUids();	
	
ArrayList<String>desgn=new ArrayList<String>();

desgn.add("Teacher");
desgn.add("Volunteer");
desgn.add("Other");

cdesg.getItems().addAll(desgn);

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
	
	vsal.setPromptText("Salary per month ");
	RequiredFieldValidator vasal = new RequiredFieldValidator();
	vasal.setMessage("Salary Required");
	vasal.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vsal.getValidators().add(vasal);
	vsal.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vsal.validate();
	});
	
	vemail.setPromptText("Enter your Email-Id...");
	RequiredFieldValidator vaemail = new RequiredFieldValidator();
	vaemail.setMessage("Email Required");
	vaemail.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vemail.getValidators().add(vaemail);
	vemail.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vemail.validate();
	});
	


add.getStyleClass().add("button-raised");
bu.getStyleClass().add("button-raised");
bs.getStyleClass().add("button-raised");

final ImageView imv = new ImageView();
final Image image2 = new Image(Branch_Master.class.getResourceAsStream("employee_portal.png"));
imv.setImage(image2);
st.setTitle("Employee's");


grid.setVgap(30);
grid.setHgap(40);
grid.setPrefSize(700,500);
grid.setPadding(new Insets(30));
grid.setGridLinesVisible(false);
adu.setFont(Font.font("Arial" ,FontWeight.BOLD,20));
grid.add(imv, 0, 0, 3, 1);
grid.add(tuid, 0, 2);
grid.add(tmob, 0, 3);
grid.add(temail, 0, 4);
grid.add(tadr, 0, 5);
grid.add(tcity, 0, 6);
grid.add(tsal, 0, 7);
grid.add(tdesg, 0, 8);
grid.add(tbranch, 0, 9);

grid.add(fuid, 1, 2);
grid.add(vmob,1 , 3 );
grid.add(vemail, 1, 4);
grid.add(vadr,1 , 5 );
grid.add(vcity, 1, 6);
grid.add(vsal, 1, 7);
grid.add(cdesg, 1, 8);
grid.add(cbranch, 1, 9);

bg= new BackgroundImage(new Image("Database_user/wall3.jpg",1400,750,false,true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
grid.setBackground(new Background(bg));

hb.setSpacing(20);
grid.add(bs, 3, 2);
hb.getChildren().addAll(add,bu);
grid.add(hb, 0,10, 5, 1);

add.setOnAction(e->doadd());
//bs.setOnAction(e->doSearch());
bu.setOnAction(e->doUpdate());
Scene sc=new Scene(grid);
sc.getStylesheets().add("Database_user/application.css");
st.setScene(sc);
st.show();
}

void doadd() 
{ 

	try {
	
	prepinst=con.prepareStatement("insert into employe values(?,?,?,?,?,?,?,?)");
	
	prepinst.setString(1, fuid.getText());
	prepinst.setString(2, vmob.getText());
	prepinst.setString(3, vemail.getText());
	prepinst.setString(4, vadr.getText());
	prepinst.setString(5, vcity.getText());
	prepinst.setString(6, vsal.getText());
	prepinst.setString(7, cdesg.getSelectionModel().getSelectedItem());
	prepinst.setString(8, cbranch.getSelectionModel().getSelectedItem());
	
	
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

void doUpdate() 
{
	
	{ 
	try 
	 {
		prepinst=con.prepareStatement("update users set vmob=?, vemail=?, vadr=?, vcity=?, vsal=?, cdesg=?, cbranch? where fuid=?");
		prepinst.setString(8, fuid.getText());
		prepinst.setString(1, vmob.getText());
		prepinst.setString(2, vemail.getText());
		prepinst.setString(3, vadr.getText());
		prepinst.setString(4, vcity.getText());
		prepinst.setString(5, vsal.getText());
		prepinst.setString(6, cdesg.getSelectionModel().getSelectedItem());
		prepinst.setString(7, cbranch.getSelectionModel().getSelectedItem());
		
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
Alert alert =new Alert(AlertType.INFORMATION);
alert.setTitle("Alert");
alert.setHeaderText("Done!");
alert.setContentText(msg);
alert.show();
}

void doFillUids()
{
	cbranch.getItems().clear();

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
		cbranch.getItems().addAll(lst);
		rs.close();
		
	}
	catch (SQLException e)
	{
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
}

}

