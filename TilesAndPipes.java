//Sueda Bilen 150117044-Elif Gökpýnar 150117510
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//this class for creating tiles from main class
public class TilesAndPipes extends Main{
	//these variables for positioning of the array
	
	public String id;
    public String type;
    public String property;
//define constructor
public TilesAndPipes(String id,String type,String property) {
	this.id=id;
	this.type=type;
	this.property=property;
}
//this method for creating starter tiles
public Button starter(String id,String property) {
	if(property.equals("Vertical")) {
	Button vertical = new Button();
	vertical.setStyle("-fx-background-color: Black");
	Image starterVertical = new Image("images/starter-vertical.gif");
	ImageView sVertical = new ImageView(starterVertical);
	sVertical.setFitHeight(100);
	sVertical.setFitWidth(100);
	vertical.setGraphic(sVertical);
    vertical.setMaxHeight(100);
	vertical.setMaxWidth(100);
	
	return vertical;
	
	}
	else if(property.equals("Horizontal")) {
		Button horizontal = new Button();
		Image starterHorizontal = new Image("images/starter-horizontal.gif");
		ImageView sHorizontal = new ImageView(starterHorizontal);
		sHorizontal.setFitHeight(100);
		sHorizontal.setFitWidth(100);
		horizontal.setGraphic(sHorizontal);
	    horizontal.setMaxHeight(100);
		horizontal.setMaxWidth(100);
		return horizontal;
		
	}
	return null ;
	
}

//this method for creating end tiles
public Button end(String id,String property) {
	if(property.equals("Vertical")) {
		Button endvertical = new Button();
		endvertical.setStyle("-fx-background-color: Black");
		Image endVertical1 = new Image("images/end-vertical.gif");
		ImageView eVertical = new ImageView(endVertical1);
		eVertical.setFitHeight(100);
		eVertical.setFitWidth(100);
		endvertical.setGraphic(eVertical);
	    endvertical.setMaxHeight(100);
		endvertical.setMaxWidth(100);
		return endvertical;
		
		}
		else if(property.equals("Horizontal")) {
			Button endhorizontal = new Button();
			endhorizontal.setStyle("-fx-background-color: Black");
			Image endHorizontal1 = new Image("images/end-horizontal.gif");
			ImageView eHorizontal = new ImageView(endHorizontal1);
			eHorizontal.setFitHeight(100);
			eHorizontal.setFitWidth(100);
			endhorizontal.setGraphic(eHorizontal);
		    endhorizontal.setMaxHeight(100);
			endhorizontal.setMaxWidth(100);
			return endhorizontal;
			
		}
	return null;
}
//this method for creating pipe tiles
public Button pipe(String id,String property) {
	
	if(property.equals("Vertical")) {
		Button vertical = new Button();
		vertical.setStyle("-fx-background-color: Black");
		Image pipeVertical = new Image("images/pipe-vertical.gif");
		ImageView pVertical = new ImageView(pipeVertical);
		pVertical.setFitHeight(100);
		pVertical.setFitWidth(100);
		vertical.setGraphic(pVertical);
	    vertical.setMaxHeight(100);
		vertical.setMaxWidth(100);
		return vertical;
		
		}
		else if(property.equals("Horizontal")) {
			Button horizontal = new Button();
			horizontal.setStyle("-fx-background-color: Black");
			Image pipeHorizontal = new Image("images/pipe-horizontal.gif");
			ImageView pHorizontal = new ImageView(pipeHorizontal);
			pHorizontal.setFitHeight(100);
			pHorizontal.setFitWidth(100);
			horizontal.setGraphic(pHorizontal);
		    horizontal.setMaxHeight(100);
			horizontal.setMaxWidth(100);
			return horizontal;
			
		}
		else if(property.equals("00")) {
			Button curved00 = new Button();
			curved00.setStyle("-fx-background-color: Black");
			Image pipeCurved00 = new Image("images/curved00.gif");
			ImageView pCurved00 = new ImageView(pipeCurved00);
			pCurved00.setFitHeight(100);
			pCurved00.setFitWidth(100);
			curved00.setGraphic(pCurved00);
			curved00.setMaxHeight(100);
			curved00.setMaxWidth(100);
			return curved00;
		}
		else if(property.equals("01")) {
			Button curved01 = new Button();
			curved01.setStyle("-fx-background-color: Black");
			Image pipeCurved01 = new Image("images/curved01.gif");
			ImageView pCurved01 = new ImageView(pipeCurved01);
			pCurved01.setFitHeight(100);
			pCurved01.setFitWidth(100);
			curved01.setGraphic(pCurved01);
			curved01.setMaxHeight(100);
			curved01.setMaxWidth(100);
			return curved01;
		}
		else if(property.equals("10")) {
			Button curved10 = new Button();
			curved10.setStyle("-fx-background-color: Black");
			Image pipeCurved10 = new Image("images/curved10.gif");
			ImageView pCurved10 = new ImageView(pipeCurved10);
			pCurved10.setFitHeight(100);
			pCurved10.setFitWidth(100);
			curved10.setGraphic(pCurved10);
			curved10.setMaxHeight(100);
			curved10.setMaxWidth(100);
			return curved10;
		}
		else if(property.equals("11")){
			Button curved11 = new Button();
			curved11.setStyle("-fx-background-color: Black");
			Image pipeCurved11 = new Image("images/curved11.gif");
			ImageView pCurved11 = new ImageView(pipeCurved11);
			pCurved11.setFitHeight(100);
			pCurved11.setFitWidth(100);
			curved11.setGraphic(pCurved11);
			curved11.setMaxHeight(100);
			curved11.setMaxWidth(100);
			return curved11;
		}
	
				
	return null;
}

//this method for creating static pipe tiles
public Button pipeStatic(String id,String property) {
	if(property.equals("Vertical")) {
		Button psvertical = new Button();
		psvertical.setStyle("-fx-background-color: Black");
		Image pstaticVertical = new Image("images/pipestatic-vertical.gif");
		ImageView psVertical = new ImageView(pstaticVertical);
		psVertical.setFitHeight(100);
		psVertical.setFitWidth(100);
		psvertical.setGraphic(psVertical);
		psvertical.setMaxHeight(100);
		psvertical.setMaxWidth(100);
		return psvertical;
		
		}
		else if(property.equals("Horizontal")) {
			Button pshorizontal = new Button();
			pshorizontal.setStyle("-fx-background-color: Black");
			Image pstaticHorizontal = new Image("images/pipestatic-horizontal.gif");
			ImageView psHorizontal = new ImageView(pstaticHorizontal);
			psHorizontal.setFitHeight(100);
			psHorizontal.setFitWidth(100);
			pshorizontal.setGraphic(psHorizontal);
		    pshorizontal.setMaxHeight(100);
			pshorizontal.setMaxWidth(100);
			return pshorizontal;
			
		}
	return null;
}
//this method for creating empty tiles
public Button empty(String id,String property) {
	if(property.equals("none")) {
		Button emptyNone = new Button();
		emptyNone.setStyle("-fx-background-color: Black");
		Image emptynone = new Image("images/empty-none.gif");
		ImageView eNone = new ImageView(emptynone);
		eNone.setFitHeight(100);
		eNone.setFitWidth(100);
		emptyNone.setGraphic(eNone);
		emptyNone.setMaxHeight(100);
		emptyNone.setMaxWidth(100);
		return emptyNone;
		
		}
		else if(property.equals("Free")) {
			Button emptyFree  = new Button();
			emptyFree .setStyle("-fx-background-color: Black");
			Image emptyfree  = new Image("images/empty-free.gif");
			ImageView eFree  = new ImageView(emptyfree);
			eFree .setFitHeight(100);
			eFree .setFitWidth(100);
			emptyFree .setGraphic(eFree );
			emptyFree .setMaxHeight(100);
			emptyFree .setMaxWidth(100);
			return emptyFree ;
			
		}
	
	return null;
 }

public void start(Stage primaryStage) {

}


public static void main(String[] args) {
	launch(args);
}



//positioning of the tiles according to their id's/row
public int row(String id) {
	
	Integer id1=Integer.valueOf(id);
	if (1<=id1 && id1<=4) {
		
		
		return 0;
		
	}
	else if (5<=id1 && id1<=8) {
		
		
		return 1;
	}
	else if(9<=id1 && id1<=12) {
		
		return 2;
	}
	else if (13<=id1 && id1<=16) {
		
		
		return 3;

	}
	return 0;
}
//positioning of the tiles according to their id's/column
public int column(String id) {
	
	Integer id1 =Integer.valueOf(id);
	if(id1==1) {
		return 0;
	}
	else if(id1==2) {
		return 1;
	}
	else if(id1==3) {
		return 2;
	}
	else if(id1==4) {
		return 3;
	}
	else if(id1==5) {
		return 0;
	}
	else if(id1==6) {
		return 1;
	}
	else if(id1==7) {
		return 2;
	}
	else if(id1==8) {
		return 3;
	}
	else if(id1==9) {
		return 0;
	}
	else if(id1==10) {
		return 1;
	}
	else if(id1==11) {
		return 2;
	}
	else if(id1==12) {
		return 3;
	}
	else if(id1==13) {
		return 0;
	}
	else if(id1==14) {
		return 1;
	}
	else if(id1==15) {
		return 2;
	}
	else 
		return 3;
	
 }


}