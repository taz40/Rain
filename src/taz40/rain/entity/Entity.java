package taz40.rain.entity;

import java.util.Random;

import taz40.rain.graphics.Screen;
import taz40.rain.level.Level;

public abstract class Entity {

	public double x, y;
	private boolean removed = false;
	protected Level level;
	protected Random random = new Random();
	
	public abstract void update();
	
	public void render(Screen screen){
	}
	
	public void remove(){
		//Remove from level
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
	
	public void init(Level level){
		this.level = level;
	}
	
}
