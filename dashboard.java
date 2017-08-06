package Database_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class dashboard {


	Label lblTitle,lblBranchM,lblDonor,lblDonation,lblIssue,lblEmploye,lblVolunterR,lblInventory,lblEmployeR,lblBranchR,lblDonationR,lblDonorR,lblIssueR;
	 
	 Stage stage;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	dashboard(){
		
		Stage stage1=new Stage();
		stage=new Stage();
		
		Circle cir1 = new Circle(250,200,80); 
		cir1.setStroke(Color.SEAGREEN); 
		cir1.setFill(Color.SNOW); 
		cir1.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		Circle cir2 = new Circle(250,200,80); 
		cir2.setStroke(Color.SEAGREEN); 
		cir2.setFill(Color.SNOW); 
		cir2.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		Circle cir3 = new Circle(250,200,80); 
		cir3.setStroke(Color.SEAGREEN); 
		cir3.setFill(Color.SNOW); 
		cir3.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		Circle cir4 = new Circle(250,200,80); 
		cir4.setStroke(Color.SEAGREEN); 
		cir4.setFill(Color.SNOW); 
		cir4.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		Circle cir5 = new Circle(250,200,80); 
		cir5.setStroke(Color.SEAGREEN); 
		cir5.setFill(Color.SNOW); 
		cir5.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		Circle cir6 = new Circle(250,200,80); 
		cir6.setStroke(Color.SEAGREEN); 
		cir6.setFill(Color.SNOW);
		Circle cir7 = new Circle(250,200,80); 
		cir7.setStroke(Color.SEAGREEN); 
		cir7.setFill(Color.SNOW);
		cir7.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		Circle cir8 = new Circle(250,200,80); 
		cir8.setStroke(Color.SEAGREEN); 
		cir8.setFill(Color.SNOW);
		cir8.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		
		Circle cir9 = new Circle(250,200,80); 
		cir9.setStroke(Color.SEAGREEN); 
		cir9.setFill(Color.SNOW);
		cir9.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		
		Circle cir10 = new Circle(250,200,80); 
		cir10.setStroke(Color.SEAGREEN); 
		cir10.setFill(Color.SNOW);
		cir10.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		
		Circle cir11 = new Circle(250,200,80); 
		cir11.setStroke(Color.SEAGREEN); 
		cir11.setFill(Color.SNOW);
		cir11.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		
		Circle cir12 = new Circle(250,200,80); 
		cir12.setStroke(Color.SEAGREEN); 
		cir12.setFill(Color.SNOW);
		cir12.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		cir1.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("branch.png"))));
		cir2.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("donor.jpg"))));
		cir3.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("donation.jpg"))));
		cir4.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("issue.png"))));
		cir5.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("employe.png"))));
		cir6.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("volunteer.png"))));
		cir7.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("rinventory.gif"))));
		cir8.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("remploye.jpg"))));
		cir9.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("rbranch.png"))));
		cir10.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("rdonation.jpg"))));
		cir11.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("rdonor.png"))));
		cir12.setFill(new ImagePattern(new Image(dashboard.class.getResourceAsStream("rissue.png"))));
		
		DropShadow ds = new DropShadow();
		ds.setOffsetX(3.0f);
		ds.setOffsetY(3.0f);
		
		lblTitle=new Label("Portal");
		lblTitle.setFont(Font.font("AR BONNIE", 48));
		lblTitle.setEffect(ds);
		lblBranchM=new Label("Branch Manager",cir1);
		lblBranchM.setFont(Font.font("AR BONNIE", 20));
		lblBranchM.setContentDisplay(ContentDisplay.TOP);
		lblDonor=new Label("Donor's",cir2);
		lblDonor.setFont(Font.font("AR BONNIE", 20));
		lblDonor.setContentDisplay(ContentDisplay.TOP);
		lblDonation=new Label("Donation",cir3);
		lblDonation.setFont(Font.font("AR BONNIE", 20));
		lblDonation.setContentDisplay(ContentDisplay.TOP);
		lblIssue=new Label("Issue",cir4);
		lblIssue.setFont(Font.font("AR BONNIE", 20));
		lblIssue.setContentDisplay(ContentDisplay.TOP);
		lblEmploye=new Label("Employee's",cir5);
		lblEmploye.setFont(Font.font("AR BONNIE", 20));
		lblEmploye.setContentDisplay(ContentDisplay.TOP);
		lblVolunterR=new Label("Volunteer's",cir6);
		lblVolunterR.setFont(Font.font("AR BONNIE", 20));
		lblVolunterR.setContentDisplay(ContentDisplay.TOP);;
		lblInventory=new Label("Inventory",cir7);
		lblInventory.setFont(Font.font("AR BONNIE", 20));
		lblInventory.setContentDisplay(ContentDisplay.TOP);
		lblEmployeR=new Label("Employee Record",cir8);
		lblEmployeR.setFont(Font.font("AR BONNIE", 20));
		lblEmployeR.setContentDisplay(ContentDisplay.TOP);
		lblBranchR=new Label("Branch Record",cir9);
		lblBranchR.setFont(Font.font("AR BONNIE", 20));
		lblBranchR.setContentDisplay(ContentDisplay.TOP);
		lblDonationR=new Label("Donation Record",cir10);
		lblDonationR.setFont(Font.font("AR BONNIE", 20));
		lblDonationR.setContentDisplay(ContentDisplay.TOP);
		lblDonorR=new Label("Donor Record",cir11);
		lblDonorR.setFont(Font.font("AR BONNIE", 20));
		lblDonorR.setContentDisplay(ContentDisplay.TOP);
		lblIssueR=new Label("Issue Record",cir12);
		lblIssueR.setFont(Font.font("AR BONNIE", 20));
		lblIssueR.setContentDisplay(ContentDisplay.TOP);
		
		
		GridPane grid=new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 20, 10, 20));
		grid.setAlignment(Pos.CENTER);
		
		GridPane.setConstraints(lblTitle, 0, 0, 4, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 35, 5, 35));
		grid.getChildren().add(lblTitle);
		GridPane.setConstraints(lblBranchM, 0, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblBranchM);
		GridPane.setConstraints(lblDonor, 1, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblDonor);
		GridPane.setConstraints(lblDonation, 2, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblDonation);
		GridPane.setConstraints(lblIssue, 3, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblIssue);
		GridPane.setConstraints(lblVolunterR, 0, 3, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblVolunterR);
		GridPane.setConstraints(lblEmploye, 1, 3, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblEmploye);
		GridPane.setConstraints(lblInventory, 2, 3, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblInventory);
		GridPane.setConstraints(lblEmployeR, 3, 3, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblEmployeR);
		GridPane.setConstraints(lblBranchR, 0, 4, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblBranchR);
		GridPane.setConstraints(lblDonationR, 1, 4, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblDonationR);
		GridPane.setConstraints(lblDonorR, 2, 4, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblDonorR);
		GridPane.setConstraints(lblIssueR, 3, 4, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblIssueR);
	
	
		Scene scene = new Scene(grid,1400,800);
		stage1.setScene(scene);
		stage1.show();
		
		lblBranchM.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblBranchM.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblBranchM.opacityProperty(),.5))).play();
			}
		});
		lblBranchM.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblBranchM.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblBranchM.opacityProperty(),1))).play();
				
			}
		});
		
		lblBranchR.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblBranchR.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblBranchR.opacityProperty(),.5))).play();
			}
		});
		lblBranchR.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblBranchR.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblBranchR.opacityProperty(),1))).play();
				
			}
		});
		lblDonor.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblDonor.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblDonor.opacityProperty(),.5))).play();
			}
		});
		lblDonor.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblDonor.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblDonor.opacityProperty(),1))).play();
				
			}
		});
		lblDonation.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblDonation.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblDonation.opacityProperty(),.5))).play();
			}
		});
		lblDonation.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblDonation.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblDonation.opacityProperty(),1))).play();
				
			}
		});
		
		lblIssue.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblIssue.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblIssue.opacityProperty(),.5))).play();
			}
		});
		
		lblIssue.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblIssue.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblIssue.opacityProperty(),1))).play();
				
			}
		});
		
		
		lblIssueR.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblIssueR.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblIssueR.opacityProperty(),.5))).play();
			}
		});
		
		lblIssueR.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblIssueR.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblIssueR.opacityProperty(),1))).play();
				
			}
		});
				
		lblEmploye.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblEmploye.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblEmploye.opacityProperty(),.5))).play();
			}
		});
		lblEmploye.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblEmploye.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblEmploye.opacityProperty(),1))).play();
				
			}
		});
		lblVolunterR.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblVolunterR.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblVolunterR.opacityProperty(),.5))).play();
			}
		});
		lblVolunterR.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblVolunterR.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblVolunterR.opacityProperty(),1))).play();
				
			}
		});
		lblInventory.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblInventory.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblInventory.opacityProperty(),.5))).play();
			}
		});
		lblInventory.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblInventory.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblInventory.opacityProperty(),1))).play();
				
			}
		});
		
		lblEmployeR.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblEmployeR.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblEmployeR.opacityProperty(),.5))).play();
			}
		});
		lblEmployeR.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblEmployeR.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblEmployeR.opacityProperty(),1))).play();
				
			}
		});
		

		lblDonorR.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblDonorR.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblDonorR.opacityProperty(),.5))).play();
			}
		});
		lblDonorR.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblDonorR.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblDonorR.opacityProperty(),1))).play();
				
			}
		});
		

		lblDonationR.setOnMouseEntered(new EventHandler() {
			
			public void handle(Event arg0) {
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblDonationR.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblDonationR.opacityProperty(),.5))).play();
			}
		});
		lblDonationR.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblDonationR.opacityProperty(),1)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblDonationR.opacityProperty(),1))).play();
				
			}
		});


		
		lblBranchM.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new Branch_Master();
			}
		});
		
		lblEmploye.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new employe();
			}
		});
		
		lblDonor.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new donation_reg();
			}
		});
		
		lblDonation.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new donation_record();
			}
		});
		

		lblIssue.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new donor_issue();
			}
		});
		
		

		lblVolunterR.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new ComboList();
			}
		});
		
		lblDonationR.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new Tt_don_rec();
			}
		});
		
		lblBranchR.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new tBranch_Master();
			}
		});
		
		lblEmployeR.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new tEmployee();
			}
		});
		
		lblInventory.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new List_Issue();
			}
		});
		
				
		lblInventory.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new List_Issue();
			}
		});
		
		lblIssueR.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new tBranch_Record();
			}
		});
		
		lblDonorR.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stage.setIconified(true);
				new tBranch_Record();
			}
		});
		
	}
}


