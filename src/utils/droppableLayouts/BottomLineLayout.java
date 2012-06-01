package utils.droppableLayouts;

import utils.Card;
import utils.Point;
import client.gui.entities.Droppable;
import client.gui.entities.MetricsConvertion;

public class BottomLineLayout extends DroppableLayout {

	public BottomLineLayout(Droppable droppable) {
		super(droppable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rearrange() {
		// TODO Auto-generated method stub
		Point newLocation=null;
		Point location = new Point(droppable.getX() , droppable.getY());
		int numberOfCards = droppable.getCards().size();
		
		// gets the step that each card would move.
		float step = MetricsConvertion.pointRelativeToPx(new Point(7 , 0)).getX();
		if(numberOfCards>0)
			newLocation = new Point((int)(location.getX() - step * numberOfCards/2) , location.getY());
		
		System.out.println("BottomLineLayout.rearrange()");
		for(Card c : droppable.getCards()){
			//c.setLocation(newLocation.getX(), newLocation.getY());
			
			animate(c , newLocation, 0,1000);
			newLocation.setX(newLocation.getX() + step);
			
		}
		for (Card c : droppable.getCards()) {
			
			System.out.println(c.getX());
		}
		System.out.println("BottomLineLayout.rearrange()");
	}
}