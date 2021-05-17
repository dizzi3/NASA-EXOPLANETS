package nasa.exoplanets.nodes;

import nasa.exoplanets.query.Query;
import nasa.exoplanets.query.QueryUI;

public class FlexibleAddQueryButton extends FlexibleButton{
	
	private QueryUI queryUI;
	
	public FlexibleAddQueryButton(QueryUI queryUI) {
		
		this.queryUI = queryUI;
		
		setText("+");
		addListener();
		
	}
	
	private void addListener() {
		
		setOnAction( event -> {
			
			int maxAmountOfElements = Query.queries.size();
			
			if(queryUI.getAmountOfElements() >= maxAmountOfElements)
				return;
			
			queryUI.addElement();
			
		});
		
	}

}
