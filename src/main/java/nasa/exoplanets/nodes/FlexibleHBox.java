package nasa.exoplanets.nodes;

import javafx.scene.layout.HBox;

public class FlexibleHBox extends HBox{
	
	public FlexibleHBox(HBox box) {

		setAlignment(box.getAlignment());
		setSpacing(box.getSpacing());
		setPrefWidth(box.getPrefWidth());
		setPrefHeight(box.getPrefHeight());
		
	}
	

}
