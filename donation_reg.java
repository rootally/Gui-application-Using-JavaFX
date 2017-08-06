package Database_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import de.jensd.fx.glyphs.GlyphsBuilder;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class donation_reg {
	
    private static final String EM1 = "1em";
    private static final String ERROR = "error";
    TableView<TDonorRecord>tbl;
    
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

//Text adu=new Text("Donator's Regestration");
Text tuid=new Text("Name"); 
Text tadr=new Text("Address");
Text tmob=new Text("Mobile");
Text tcity=new Text("City");
BackgroundImage bg;

JFXTextField vuid = new JFXTextField();
JFXTextField vadr = new JFXTextField();
JFXTextField vmob = new JFXTextField();
JFXTextField vcity = new JFXTextField();
Stage st;
HBox hb=new HBox();

JFXButton bn = new JFXButton("New");
JFXButton add = new JFXButton("Save".toUpperCase());

 donation_reg()
{
	try {
		doConnect();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
	st=new Stage();
// TODO Auto-generated method stub
	
	
 // ************* Text Fields ****************************************************
	
	vuid.setPromptText("Enter your Name...");
	RequiredFieldValidator vauid = new RequiredFieldValidator();
	vauid.setMessage("Branch Required");
	vauid.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vuid.getValidators().add(vauid);
	vuid.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vuid.validate();
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
	    if(!newVal) vadr.validate();
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

	vmob.setPromptText("Eny your Mobile Number...");
	RequiredFieldValidator vamob = new RequiredFieldValidator();
	vamob.setMessage("City Required");
	vamob.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.WARNING)
            .size(EM1)
            .styleClass(ERROR)
            .build());
	vcity.getValidators().add(vamob);
	vcity.focusedProperty().addListener((o,oldVal,newVal)->
	{
	    if(!newVal) vcity.validate();
	});
	
	
add.getStyleClass().add("button-raised");
bn.getStyleClass().add("button-raised");


final ImageView imv = new ImageView();
final Image image2 = new Image(Branch_Master.class.getResourceAsStream("donor's_reg.png"));
imv.setImage(image2);
hb.setSpacing(20);
st.setTitle("Donor's Portal");


grid.setVgap(50);
grid.setHgap(90);
grid.setPrefSize(700,400);
grid.setPadding(new Insets(30));
grid.setGridLinesVisible(false);
//adu.setFont(Font.font("Arial" ,FontWeight.BOLD,20));
grid.add(imv, 0, 0, 4, 1);
grid.add(tuid, 0, 2);
grid.add(tmob, 0, 3);
grid.add(tadr, 0, 4);
grid.add(tcity, 0, 5);

grid.add(vuid,1 , 2 );
grid.add(vmob, 1, 3);
grid.add(vadr,1 , 4 );
grid.add(vcity,1 ,5 );

hb.getChildren().addAll(bn,add);

bg= new BackgroundImage(new Image("Database_user/wall2.jpg",1400,750,false,true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
grid.setBackground(new Background(bg));

grid.add(hb, 0,6, 5, 1);

add.setOnAction(e->doadd());
bn.setOnAction(e->doclear());

Scene sc=new Scene(grid);
sc.getStylesheets().add("Database_user/application.css");
st.setScene(sc);
st.show();

 }

void doadd() 
{ 

	try {
		
			prepinst=con.prepareStatement("insert into dreg values(?,?,?,?,curdate())");
			
			prepinst.setString(1, vuid.getText());
			prepinst.setString(2, vmob.getText());
			prepinst.setString(3, vadr.getText());
			prepinst.setString(4, vcity.getText());
			
			prepinst.executeUpdate();
			prepinst.close();
			showMsg("Record Inserted....");
	} 
	catch (SQLException e )
	{
		e.printStackTrace();
	}
}

void showMsg(String msg)
{
	Alert alert =new Alert(AlertType.WARNING);
	alert.setTitle("Alert");
	alert.setHeaderText("Value Missing ");
	alert.setContentText(msg);
	alert.show();
}

void doclear()
{
	vuid.clear();
	vmob.clear();
	vadr.clear();
	vcity.clear();
}
}
