package nasa.exoplanets.nodes;

import javafx.scene.control.TextField;

public class FlexibleTextField extends TextField{
	
	public static TextField model;
	
	public FlexibleTextField() {
		
		FlexibleNode.copyProperties(this, model);
		
		//TODO: delete below
		setText("2021");
		
	}

}
