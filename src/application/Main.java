package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Button[] button=new Button[5];
	public int index=0;
	@Override
	public void start(Stage primaryStage) {
			VBox root=new VBox(20);
			Scene scene = new Scene(root,800,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			HBox firstTabLayout=new HBox(5);
			firstTabLayout.prefHeightProperty().bind(scene.heightProperty());
			firstTabLayout.getChildren().add(new Button("Tab_1_myButton"));
			firstTabLayout.getChildren().add(new Button("Tab_1_myButton 1"));
			firstTabLayout.getChildren().add(new Button("Tab_1_myButton 2"));
			Tab firstTab=new Tab("Tab 1");
			firstTab.setContent(firstTabLayout);
			
			HBox secondTabLayout=new HBox(5);
			secondTabLayout.prefHeightProperty().bind(scene.heightProperty());
			secondTabLayout.getChildren().add(new Button("Tab_2_myButton"));
			secondTabLayout.getChildren().add(new Button("Tab_2_myButton 1"));
			secondTabLayout.getChildren().add(new Button("Tab_2_myButton 2"));
			Tab secondTab=new Tab("Tab 2");
			secondTab.setContent(secondTabLayout);
			
			HBox thirdTabLayout=new HBox(5);
			thirdTabLayout.prefHeightProperty().bind(scene.heightProperty());
			thirdTabLayout.getChildren().add(new Button("Tab_3_myButton"));
			thirdTabLayout.getChildren().add(new Button("Tab_3_myButton 1"));
			thirdTabLayout.getChildren().add(new Button("Tab_3_myButton 2"));
			Tab thirdTab=new Tab("Tab 3");
			thirdTab.setContent(thirdTabLayout);
			
			HBox fourdTabLayout=new HBox(5);
			fourdTabLayout.prefHeightProperty().bind(scene.heightProperty());
			fourdTabLayout.getChildren().add(new Button("Tab_4_myButton"));
			fourdTabLayout.getChildren().add(new Button("Tab_4_myButton 1"));
			fourdTabLayout.getChildren().add(new Button("Tab_4_myButton 2"));
			Tab fourdTab=new Tab("Tab 4");
			fourdTab.setContent(fourdTabLayout);
			
			TabPane tabpane=new TabPane();
			tabpane.getTabs().addAll(firstTab,secondTab,thirdTab,fourdTab);
			root.getChildren().add(tabpane);
			SelectionModel<Tab> selectionModel=tabpane.getSelectionModel();
			
			HBox buttonGroup=new HBox(20);
			//Creating Buttons
			for(Button b:button) {
				b=new Button("Select Tab n°"+ ++index);
				buttonGroup.getChildren().add(b);
				b.setOnMouseClicked(e->{
					Button localButton=(Button)e.getSource();
					//getting the index of the tab by taking the last char of the button text 
					//i did subtract 1 because the selectionModel start from 0
					int theIndex=Integer.parseInt(localButton.getText().charAt(localButton.getText().length()-1)+"")-1;
					//handling the exception when the we have buttons more than tabs
					try {
					if(theIndex>tabpane.getTabs().size()-1) {
						throw new Exception("index Out Of Bounds");
					}
					selectionModel.select(theIndex);
					}
					catch(Exception x) {
						System.out.println(x.getMessage());
					}
				});
			}
			root.getChildren().add(buttonGroup);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
