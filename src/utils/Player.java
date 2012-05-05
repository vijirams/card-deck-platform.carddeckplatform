package utils;

import handlers.PlayerEventsHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

import IDmaker.IDMaker;

import communication.link.ServerConnection;

import client.controller.ClientController;




public class Player extends Observable implements Serializable, Comparable<Player>{
	private PlayerEventsHandler handler;
	private String userName;
	private ArrayList<Card>hand;
	boolean myTurn;
	Position.Player position;
	Position.Player globalPosition;
	int id;
	
	
	
	
	public Player(String userName,Position.Player globalPosition, PlayerEventsHandler handler) {
		this.userName=userName;
		this.globalPosition=globalPosition;
		this.position=globalPosition.sitMe(globalPosition);
		this.id=globalPosition.getId();
		this.handler=handler;
		this.hand=new ArrayList<Card>();
		this.myTurn=false;
		addObserver(ClientController.getController());
	}
	public Position.Player getGlobalPosition() {
		return globalPosition;
	}
	public PlayerEventsHandler getHandler() {
		return handler;
	}
	public Position.Player getPosition() {
		return position;
	}
	public String getUserName() {
		return userName;
	}
	public int getId() {
		return id;
	}
	public void addCard(Card card) {
		card.setOwner(userName);
		hand.add(card);		
		handler.onCardAdded(this, card);
		
	}
	public void remove(Card card) {
		hand.remove(card);
		handler.onCardRemoved(this, card);
		
	}
	public void roundEnded(Player player) {
		
		
	}
	public boolean isMyTurn() {
		return myTurn;
	}
	public void startTurn(){
		myTurn=true;
		setChanged();
		notifyObservers(myTurn);
	}
	public void endTurn(){
		myTurn=false;
		setChanged();
		notifyObservers(myTurn);
		ClientController.sendAPI().endTurn(position);
	}
	public void deltCard(Card card) {
		card.setOwner(userName);
		hand.add(card);			
	}
	public int cardsHolding() {		
		return hand.size();
	}

	
	public boolean isEmpty() {
		return hand.isEmpty();
	}

	
	public void clear() {
		hand.clear();
		
	}
	@Override
	public int compareTo(Player another) {
		return this.globalPosition.compareTo(another.getGlobalPosition());
	}
	
	public void setRelativePosition(utils.Position.Player myGlobalPos) {
		position=this.globalPosition.getRelativePosition(myGlobalPos);
		
	}
	
}
