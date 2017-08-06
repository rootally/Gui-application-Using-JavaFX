package Database_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import de.jensd.fx.glyphs.GlyphsBuilder;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Branch_Master{
	
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

Text adu=new Text("Branch Master");
Text tbranch=new Text("Branch Name"); 
Text tadr=new Text("Address");
Text tloc=new Text("Location");
BackgroundImage bg;
Stage st;
JFXDialog dialog = new JFXDialog();


//JFXTextField fuid = new JFXTextField();
JFXTextField vbranch = new JFXTextField();
JFXTextField vadr = new JFXTextField();
JFXTextField vloc = new JFXTextField();

HBox hb=new HBox();

JFXButton add = new JFXButton("Save".toUpperCase());


public Branch_Master(){
Node content = null;

try {
	doConnect();
} catch (SQLException e1) {
	
	e1.printStackTrace();
}
st=new Stage();

	// TODO Auto-generated method stub
	
	
 // ************* Text Fields ****************************************************
	
	vbranch.setPromptText("Enter Branch Name...");
	RequiredFieldValidator vabranch = new RequiredFieldValidator();
	vabranch.setMessage("Branch Required");
	vabranch.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vbranch.getValidators().add(vabranch);
	vbranch.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vbranch.validate();
	});
	
	vadr.setPromptText("Enter branch Address..");
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
	    if(!newVal) vadr.validate();
	});
	
	vloc.setPromptText("Fill your city name...");
	RequiredFieldValidator valoc = new RequiredFieldValidator();
	valoc.setMessage("City Required");
	valoc.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vloc.getValidators().add(valoc);
	vloc.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vloc.validate();
	});
	
add.getStyleClass().add("button-raised");
final ImageView imv = new ImageView();
final Image image2 = new Image(Branch_Master.class.getResourceAsStream("Branch_Master.png"));
imv.setImage(image2);
st.setTitle("Branch Manager");


grid.setVgap(50);
grid.setHgap(90);
grid.setPrefSize(500,300);
grid.setPadding(new Insets(30));
grid.setGridLinesVisible(false);
adu.setFont(Font.font("Arial" ,FontWeight.BOLD,20));
grid.add(imv, 0, 0, 3, 1);
grid.add(tbranch, 0, 2);
grid.add(tadr, 0, 3);
grid.add(tloc, 0, 4);


grid.add(vbranch,1 , 2 );
grid.add(vadr, 1, 3);
grid.add(vloc,1 , 4 );

bg= new BackgroundImage(new Image("Database_user/wall1.jpg",1400,750,false,true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
grid.setBackground(new Background(bg));

hb.setSpacing(20);
hb.getChildren().addAll(add);

grid.add(hb, 0,5, 5, 1);

add.setOnAction(e->doadd());

Scene sc=new Scene(grid);
sc.getStylesheets().add("Database_user/application.css");
st.setScene(sc);
st.show();
}

void doadd() 
{ 

try {

prepinst=con.prepareStatement("insert into branch values(?,?,?)");

prepinst.setString(1, vbranch.getText());
prepinst.setString(2, vadr.getText());
prepinst.setString(3, vloc.getText());

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

void showMsg(String msg)
{
Alert alert =new Alert(AlertType.INFORMATION);
alert.setTitle("Alert");
alert.setHeaderText("Added");
alert.setContentText(msg);
alert.show();
}
}
