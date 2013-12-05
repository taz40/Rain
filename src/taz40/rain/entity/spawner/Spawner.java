package taz40.rain.entity.spawner;

import taz40.rain.entity.Entity;
import taz40.rain.entity.particle.Particle;
import taz40.rain.level.Level;

public abstract class Spawner extends Entity {
	
	public enum Type{
		PARTICLE, MOB
	}
	
	private Type type;
	
	public Spawner(int x, int y, Type type, int amount, Level level){
		this.x = x;
		this.y = y;
		this.type = type;
		this.level = level;
	}
	
}
