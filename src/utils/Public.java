package utils;

import handlers.PublicEventsHandler;

import java.util.ArrayList;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import carddeckplatform.game.BitmapHolder;
import client.gui.entities.Droppable;
import client.gui.entities.MetricsConvertion;


public class Public extends Droppable{	
	private PublicEventsHandler handler;
	
	private ArrayList<Card> cards=new ArrayList<Card>();	
	
	
	
	public Public(PublicEventsHandler handler,Position.Public position) {
		super(position.getId(),position, new Point(10,13));
		this.handler=handler;
		
		
		this.image = "playerarea";
		
		BitmapHolder.get().scaleBitmap(image, this.scale);
	}
	
//	public void setPosition(Position.Public position) {
//		this.position = position;
//	}
//	
	
	@Override
	public void addCard(Player player,Card card){
		cards.add(card);
		handler.onCardAdded(this,player, card);
	}
	@Override
	public void removeCard(Player player,Card card){
		cards.remove(card);
		handler.onCardRemoved(this,player, card);
		
	}
	
	public void revealCard(Player player,Card card){
		card.reveal();
		handler.onCardRevealed(this,player, card);
	}
	
	public void roundEnded(Player player){
		handler.onRoundEnd(this,player);
	}

//	@Override
//	public int getX() {
//		return MetricsConvertion.pointRelativeToPx(position.getPoint()).getX();		
//	}
//
//	@Override
//	public int getY() {
//		return MetricsConvertion.pointRelativeToPx(position.getPoint()).getY();		
//	}

//	@Override
//	public void draw(Canvas canvas,Context context) {
//		Paint paint=new Paint();
//		paint.setColor(Color.BLUE);
//		canvas.drawCircle(shape.getCenterX(), shape.getCenterY(), 50, paint);
//		canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(), 0x7f02002e),getX()-28,getY()-27,null);
//	}

	@Override
	public void deltCard(Card card) {
		cards.add(card);
		card.setLocation(getX(), getY());
		
	}

	@Override
	public int cardsHolding() {		
		return cards.size();
	}

	@Override
	public boolean isEmpty() {
		return cards.isEmpty();
	}

	@Override
	public void clear() {
		cards.clear();		
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public Card peek(){
		if (!cards.isEmpty()){
			return cards.get(cards.size()-1);
		}else{
			return null;
		}
	}	
}
