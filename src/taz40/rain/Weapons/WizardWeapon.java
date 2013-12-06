package taz40.rain.Weapons;

import taz40.rain.entity.projectile.Projectile;
import taz40.rain.entity.projectile.WizardProjectile;
import taz40.rain.input.Mouse;
import taz40.rain.level.Level;

public class WizardWeapon extends Weapon {

	
	public WizardWeapon() {
		FIRERATE = 10;
		firerate = FIRERATE;
	}

	public void shoot(double x, double y, double dir){
		if(Mouse.getButton() == 1 && firerate <= 0){
			Projectile p = new WizardProjectile(x, y, dir);
			level.add(p);
			firerate = FIRERATE;
		}
	}
}
