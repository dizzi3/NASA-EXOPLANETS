package nasa.exoplanets.nodes;

public class FlexibleRemoveQueryButton extends FlexibleButton{

	public FlexibleRemoveQueryButton() {
		
		setText("-");
		addListener();
		
	}
	
	private void addListener() {
		
		setOnAction( event -> {
			
			System.out.println("remove");
			
		});
		
	}
	
}
