package nasa.exoplanets.nodes;

import nasa.exoplanets.query.QueryUI;
import nasa.exoplanets.query.QueryUIElement;

public class FlexibleRemoveQueryButton extends FlexibleButton{

	private QueryUIElement element;
	private QueryUI queryUI;
	
	public FlexibleRemoveQueryButton(QueryUI queryUI, QueryUIElement element) {
		
		this.queryUI = queryUI;
		this.element = element;
		
		setText("-");
		addListener();
		
	}
	
	private void addListener() {
		
		setOnAction( event -> {
			
			if(queryUI.getAmountOfElements() <= 1)
				return;
			
			queryUI.removeElement(element);
			
		});
		
	}
	
}
