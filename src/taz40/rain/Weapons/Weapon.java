package taz40.rain.Weapons;

import taz40.rain.entity.projectile.Projectile;
import taz40.rain.entity.projectile.WizardProjectile;
import taz40.rain.graphics.Screen;
import taz40.rain.level.Level;

public abstract class Weapon {

	public int FIRERATE;
	public int firerate;
	public Level level;
	
	public Weapon(){
	}
	
	public void init(Level level){
		this.level = level;
	}
	
	public void update(){
		if(firerate > 0) firerate--;
	}
	
	public void render(Screen screen){
		
	}
	
	public abstract void shoot(double x, double y, double dir);
	
}
