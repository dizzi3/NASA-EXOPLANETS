package nasa.exoplanets.nodes;

import javafx.scene.control.Button;

public class FlexibleButton extends Button{

	public static Button model;
	
	public FlexibleButton() {
		
		FlexibleNode.copyProperties(this, model);
		
	}
	
}
