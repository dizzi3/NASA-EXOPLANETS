package nasa.exoplanets.nodes;

import javafx.scene.Node;
import javafx.scene.control.Control;

public class FlexibleNode {

	private static void copyStyleClasses(Node node, Node model) {
		
		for(String style : model.getStyleClass())
			node.getStyleClass().add(style);

	}
	
	private static void copyChosenProperties(Control c, Control model) {
		
		c.setPrefWidth(model.getPrefWidth());
		c.setPrefHeight(model.getPrefHeight());
		
	}
	
	public static void copyProperties(Control c, Control model) {
		
		copyStyleClasses(c, model);
		copyChosenProperties(c, model);
		
	}
	
}
