//Sueda Bilen 150117044-Elif Gökpýnar 150117510
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import java.io.*;
import java.nio.file.*;
import java.util.*;
//this class for executing the game board
public class Main extends Application {
	Stage window;
	Scene sceneFirst,scene;
	public static int moveNumber=0;
	public static int levelNumber = 1;
	public Button buttonGray;
	public Button buttonEnd;
	public Button buttonStarter;
	public Button buttonPipeStatic;
	public Button moves;
	public Button level;
	public Button exitGame;
	public Button playSound;
	public Button stopSound;
	public Button [][] buttonArray = new Button[4][4];
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//opening the first scene to user
		window=primaryStage;
		Button buttonStart= new Button("START GAME");
		buttonStart.setStyle("-fx-font-size: 4em;");
		buttonStart.setOnAction(e -> window.setScene(scene));
		Button buttonQuit = new Button("Quit");
		buttonQuit.setStyle("-fx-font-size: 3em;");
		buttonQuit.setOnAction(e -> System.exit(0));
		
		VBox vboxFirst = new VBox();
		vboxFirst.setPadding(new Insets(200,50,50,100));
		vboxFirst.getChildren().addAll(buttonStart,buttonQuit);
		sceneFirst = new Scene(vboxFirst,500,500);
	    
	    //reading input file without commas,change the commas with white spaces
		List<String> lines = Files.readAllLines(Paths.get("level1.txt"));
		PrintWriter changedInput = new PrintWriter("output.txt");
			for(String line : lines) {
				line=line.replace(",", " ");
				String[] result = line.split(",");
				for(String s: result)
					changedInput.println(s);
				System.out.println();
			}
			changedInput.close();
		File read1=new File("output.txt");
		//reading the file
		try(
				Scanner read= new Scanner(read1);
				
				) {
			while (read.hasNext()) {
				String id = read.next();
				String type = read.next();
				if(type.equals("Starter")) {
					String property= read.next();
					TilesAndPipes x = new TilesAndPipes(id,type,property);
					if(property.equals("Vertical")) {
						
						buttonArray[x.row(id)][x.column(id)]=x.starter(id, property);
						
					}
					else if (property.equals("Horizontal")) {
						buttonArray[x.row(id)][x.column(id)]=x.starter(id, property);
					}
				}
				if(type.equals("End")) {
					String property = read.next();
					TilesAndPipes x = new TilesAndPipes(id,type,property);
                    if(property.equals("Vertical")) {
						
                    	buttonArray[x.row(id)][x.column(id)]=x.end(id, property);
						
					}
					else if (property.equals("Horizontal")) {
						buttonArray[x.row(id)][x.column(id)]=x.end(id, property);
						
					}
				}
				
				if(type.equals("Pipe")) {
					String property = read.next();
					TilesAndPipes x = new TilesAndPipes(id,type,property);
                    if(property.equals("Vertical")) {
						
                    	buttonArray[x.row(id)][x.column(id)]=x.pipe(id, property);
                    	
					}
					else if (property.equals("Horizontal")) {
						buttonArray[x.row(id)][x.column(id)]=x.pipe(id, property);
						
					}
					else if (property.equals("00")) {
						buttonArray[x.row(id)][x.column(id)]=x.pipe(id, property);
						
					}
					else if (property.equals("01")) {
						buttonArray[x.row(id)][x.column(id)]=x.pipe(id, property);
						
					}
					else if (property.equals("10")) {
						buttonArray[x.row(id)][x.column(id)]=x.pipe(id, property);
						
					}
					else if (property.equals("11")) {
						buttonArray[x.row(id)][x.column(id)]=x.pipe(id, property);
						
					}
				}
				if(type.equals("PipeStatic")) {
					String property = read.next();
					TilesAndPipes x = new TilesAndPipes(id,type,property);
                    if(property.equals("Vertical")) {
						
                    	buttonArray[x.row(id)][x.column(id)]=x.pipeStatic(id, property);
                    	
                    	
					}
					else if (property.equals("Horizontal")) {
						buttonArray[x.row(id)][x.column(id)]=x.pipeStatic(id, property);
						
					}
				}
				if(type.equals("Empty")) {
					String property = read.next();
					TilesAndPipes x = new TilesAndPipes(id,type,property);
                    if(property.equals("none")) {
                    	buttonArray[x.row(id)][x.column(id)]=x.empty(id, property);
                    	
					}
					else if (property.equals("Free")) {
						buttonArray[x.row(id)][x.column(id)]=x.empty(id, property);
						
					}
				}
		}
	}		
		//create a new pane.
		GridPane root = new GridPane();
		//set the emptyFree,end,starter,PipeStatic tiles non-dynamically
		buttonGray = buttonArray[3][1];
		buttonEnd = buttonArray[3][3];
		buttonStarter = buttonArray[0][0];
		buttonPipeStatic = buttonArray[3][2];
	//add array elements to root GridPane for specific coordinates
	int i, j;   
	    for(i = 0; i < 4; i++) {
				for(j = 0; j < 4; j++)
				{
					root.add(buttonArray[i][j], j, i);
					buttonArray[i][j].setPrefHeight(100);
					buttonArray[i][j].setPrefWidth(100);
				}
			}
	     //movement loop for buttonArray
	     for (i = 0;i < 4;i++) {  
	          for(j = 0; j < 4; j++) {    
				int x = i;
				int y = j;
				buttonArray[i][j].setOnMouseDragged(e -> {
					
						Drag( buttonArray,x,y,root,buttonGray,buttonEnd,buttonStarter,buttonPipeStatic);
					});
	          }
		}
		
	     	//To show level and move numbers. 
			level = new Button("Level: " + Integer.toString(levelNumber));
			level.setStyle("-fx-background-color: #3CB371;-fx-font-size: 3em;");
			moves = new Button("Moves: " + Integer.toString(moveNumber));
		    moves.setStyle("-fx-background-color: #5F9EA0;-fx-font-size: 3em; ");
		    //If the user wants to quit the game,click the button.
		    exitGame= new Button("Quit");
		    exitGame.setStyle("-fx-background-color: #3CB371;-fx-font-size: 3em; ");
		    exitGame.setOnAction(e-> System.exit(0));
		    //to set sound to the game
		    playSound = new Button("Play");
		    playSound.setStyle("-fx-background-color: #5F9EA0;-fx-font-size: 3em; ");
		    stopSound = new Button("Stop");
		    stopSound.setStyle("-fx-background-color: #5F9EA0;-fx-font-size: 3em; ");
		    File file = new File("gamesong.mp3");
		    AudioClip audioClip = new AudioClip(file.toURI().toString());
		    playSound.setOnAction(e -> {
		      audioClip.stop();
		      audioClip.setCycleCount(2);
		      audioClip.play();
		    });
		    stopSound.setOnAction(e -> audioClip.stop());
		//option buttons adding
		HBox markers=new HBox();
		markers.getChildren().addAll(moves,level,playSound,stopSound,exitGame);
		//all panes are added this bigPane
		VBox bigPane =new VBox();
		bigPane.getChildren().addAll(markers,root);
		
		//show the bigPane
		scene = new Scene(bigPane, 600 , 600);
		window.setScene(sceneFirst);
		window.show();
		}
	//the method for dragging tiles	
	public void Drag(Button buttonArray[][],int row, int column,GridPane root,Button buttonGray,Button buttonEnd,Button buttonStarter,Button buttonPipeStatic) {
		
		if(row==0 && column==3) {
			//if the tile isn't end,starter or pipe static selected tile can move
			if(control(buttonArray[row][column],buttonStarter,buttonEnd,buttonPipeStatic)) {
				if(buttonArray[row][column].equals(buttonGray)) {
					//if the buttonArray [x][y] is gray tile,it cannot move.
				}
				if(buttonArray[row][column-1].equals(buttonGray)) {
					//if this array element equals gray tile,button array[x][y] element can move
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//count the move 
					Button temp;
					temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column-1];
					buttonArray[row][column-1]=temp;
					//Swap the array contents.
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column-1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column-1], column-1, row);
					//Remove the arrays old position,and add the new ones.
 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row+1][column].equals(buttonGray)) {
					moves.setText("Moves: " + Integer.toString(moveNumber++));
					//count the move 
					Button temp;
					temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row+1][column];
					buttonArray[row+1][column]=temp;
					//Swap the array contents.
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row+1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row+1][column], column, row+1);
					//Remove the arrays old position,and add the new ones.

 				}
			}
		}
		if(row==3 && column==0) {
			if(control(buttonArray[row][column],buttonStarter,buttonEnd,buttonPipeStatic)) {
                if(buttonArray[row][column].equals(buttonGray)) {
                	//if the buttonArray [x][y] is gray tile,it cannot move.
				}
              //if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row-1][column].equals(buttonGray)) {
					//count the move
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp;
					temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row-1][column];
					buttonArray[row-1][column]=temp;
				
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row-1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row-1][column], column, row-1);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column+1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp;
					temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column+1];
					buttonArray[row][column+1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column+1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column+1], column+1, row);
					//Remove the arrays old position,and add the new ones.

 				}
			}
		}
		if(row==3 && column==3) {
			if(control(buttonArray[row][column],buttonStarter,buttonEnd,buttonPipeStatic)) {
                if(buttonArray[row][column].equals(buttonGray)) {
                	//if the buttonArray [x][y] is gray tile,it cannot move.
				}
                //if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row-1][column].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row-1][column];
					buttonArray[row-1][column]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row-1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row-1][column], column, row-1);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column-1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column-1];
					buttonArray[row][column-1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column-1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column-1], column-1, row);
					//Remove the arrays old position,and add the new ones.

 				}
			}
		}
		if(row==0 && column>0 && column<3) {
			if(control(buttonArray[row][column],buttonStarter,buttonEnd,buttonPipeStatic)) {
                if(buttonArray[row][column].equals(buttonGray)) {
                	//if the buttonArray [x][y] is gray tile,it cannot move.
				}
                //if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column-1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column-1];
					buttonArray[row][column-1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column-1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column-1], column-1, row);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column+1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column+1];
					buttonArray[row][column+1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column+1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column+1], column+1, row);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row+1][column].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row+1][column];
					buttonArray[row+1][column]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row+1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row+1][column], column, row+1);
					//Remove the arrays old position,and add the new ones.

 				}
			}
		}
		if(row>0 && row<3 && column==0) {
			if(control(buttonArray[row][column],buttonStarter,buttonEnd,buttonPipeStatic)) {
                if(buttonArray[row][column].equals(buttonGray)) {
                	//if the buttonArray [x][y] is gray tile,it cannot move.
				}
                //if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row-1][column].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row-1][column];
					buttonArray[row-1][column]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row-1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row-1][column], column, row-1);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row+1][column].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row+1][column];
					buttonArray[row+1][column]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row+1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row+1][column], column, row+1);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column+1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column+1];
					buttonArray[row][column+1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column+1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column+1], column+1, row);
					//Remove the arrays old position,and add the new ones.

 				}
			}
		}
		if(row==3 && column>0 && column<3) {
			if(control(buttonArray[row][column],buttonStarter,buttonEnd,buttonPipeStatic)) {
                if(buttonArray[row][column].equals(buttonGray)) {
                	//if the buttonArray [x][y] is gray tile,it cannot move.
				}
                //if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column-1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column-1];
					buttonArray[row][column-1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column-1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column-1], column-1, row);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row-1][column].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row-1][column];
					buttonArray[row-1][column]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row-1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row-1][column], column, row-1);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column+1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column+1];
					buttonArray[row][column+1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column+1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column+1], column+1, row);
 				}
			}
		}
		if(row>0 && row<3 && column==3) {
			if(control(buttonArray[row][column],buttonStarter,buttonEnd,buttonPipeStatic)) {
                if(buttonArray[row][column].equals(buttonGray)) {
                }
                //if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row+1][column].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row+1][column];
					buttonArray[row+1][column]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row+1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row+1][column], column, row+1);
					//Remove the arrays old position,and add the new ones.
 				}
				//if this array element equals gray tile,button array[x][y] element can move  
				if(buttonArray[row-1][column].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row-1][column];
					buttonArray[row-1][column]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row-1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row-1][column], column, row-1);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column-1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column-1];
					buttonArray[row][column-1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column-1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column-1], column-1, row);
					//Remove the arrays old position,and add the new ones.
 				}
			}
		}
		if(row>0 && row<3 && column>0 && column<3) {
			if(control(buttonArray[row][column],buttonStarter,buttonEnd,buttonPipeStatic)) {
				if(buttonArray[row][column].equals(buttonGray)) {
					//if the buttonArray [x][y] is gray tile,it cannot move.
				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row+1][column].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row+1][column];
					buttonArray[row+1][column]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row+1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row+1][column], column, row+1);
					//Remove the arrays old position,and add the new ones.
					
 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row-1][column].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row-1][column];
					buttonArray[row-1][column]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row-1][column]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row-1][column], column, row-1);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column-1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column-1];
					buttonArray[row][column-1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column-1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column-1], column-1, row);
					//Remove the arrays old position,and add the new ones.

 				}
				//if this array element equals gray tile,button array[x][y] element can move
				if(buttonArray[row][column+1].equals(buttonGray)) {
					//count the move 
					moves.setText("Moves: " + Integer.toString(++moveNumber));
					//Swap the array contents.
					Button temp=buttonArray[row][column];
					buttonArray[row][column]=buttonArray[row][column+1];
					buttonArray[row][column+1]=temp;
					
					root.getChildren().remove(buttonArray[row][column]);
					root.getChildren().remove(buttonArray[row][column+1]);
					root.add(buttonArray[row][column],column,row);
					root.add(buttonArray[row][column+1], column+1, row);
					//Remove the arrays old position,and add the new ones.

 				}
			}
		}
 	}
	//It checks the button is not equal to starter,end,pipestatic
		public boolean control(Button button,Button buttonStarter,Button buttonEnd,Button buttonPipeStatic) {
			if(!button.equals(buttonEnd) && !button.equals(buttonStarter) && !button.equals(buttonPipeStatic)) {
				
				return true;
			}
			
			else {
				return false;
			}
		
		}
      
public static void main(String[] args) {
		launch(args);
	}




}
		