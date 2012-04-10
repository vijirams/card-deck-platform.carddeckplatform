package war.gui;

import client.gui.entities.Draggable;
import client.gui.entities.Droppable;
import logic.card.CardLogic;
import logic.client.LogicDroppable;
import android.content.Context;
import android.graphics.Canvas;

public class DeckArea extends Droppable {

	public DeckArea(Context context, int x,int y, LogicDroppable logicDroppable){
		this.x = x;
		this.y = y;
		this.logicDroppable = logicDroppable;
		this.context = context;
	}
	
	@Override
	public int sensitivityRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDrop(Draggable draggable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDraggable(Draggable draggable) {
		// TODO Auto-generated method stub
		draggable.setLocation(getX(), getY());

		draggable.setContainer(this);
		
		logicDroppable.addCard(draggable.getCardLogic());
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CardLogic getDraggable() {
		// TODO Auto-generated method stub
		return logicDroppable.getCards().peek();
	}

	@Override
	public void removeDraggable(Draggable draggable) {
		// TODO Auto-generated method stub
		logicDroppable.getCards().remove(draggable.getCardLogic());
	}

}