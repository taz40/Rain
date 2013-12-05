package taz40.rain.entity.mob;

import java.util.List;

import taz40.rain.Game;
import taz40.rain.entity.Entity;
import taz40.rain.entity.projectile.Projectile;
import taz40.rain.entity.projectile.WizardProjectile;
import taz40.rain.graphics.AnimatedSprite;
import taz40.rain.graphics.Screen;
import taz40.rain.graphics.SpriteSheet;
import taz40.rain.input.Keyboard;
import taz40.rain.input.Mouse;

public class Player extends Mob {
	
	private Keyboard input;
	private int anim = 0;
	private boolean walking = false;
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3, 7);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32, 32, 3, 7);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 3, 7);
	
	private AnimatedSprite animSprite = null;
	
	private int firerate = 0;

	public Player(Keyboard input){
		this.input = input;
		animSprite = down;
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		firerate = WizardProjectile.FIRERATE; 
		animSprite = down;
	}
	
	public void update(){
		if(walking) animSprite.update();
		else animSprite.setFrame(0);
		if(firerate > 0) firerate--;
		double xa=0,ya=0;
		double speed = 1;
		if(input.up) ya -= speed;
		if(input.down) ya += speed;
		if(input.right) xa += speed;
		if(input.left) xa -= speed;
		if(xa != 0 || ya != 0){
			move(xa, ya);
			walking = true;
		}else{
			walking = false;
		}
		clear();
		updateShooting();
	}
	
	private void clear() {
		// TODO Auto-generated method stub
		for(int i = 0; i < level.projectiles.size(); i++){
			Projectile p = level.projectiles.get(i);
			if(p.isRemoved()) level.projectiles.remove(i);
		}
	}

	private void updateShooting() {
		if(Mouse.getButton() == 1 && firerate <= 0){
			double dx = Mouse.getX() - (Game.width*Game.scale)/2;
			double dy = Mouse.getY() - (Game.height*Game.scale)/2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			firerate = WizardProjectile.FIRERATE;
		}
	}

	public void render(Screen screen){
		int flip = 0;
		if(dir == 0) {
			animSprite = up;
		}
		if(dir == 1){
			animSprite = right;
		}
		if(dir == 2){
			animSprite = down;
		}
		if(dir == 3){
			flip = 1;
			animSprite = right;
		}
		sprite = animSprite.getSprite();
		screen.renderMob((int)(x - 16),(int) (y - 16), sprite, flip);
	}
	
}
