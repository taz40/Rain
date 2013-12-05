package taz40.rain.entity.spawner;

import taz40.rain.entity.particle.Particle;
import taz40.rain.entity.spawner.Spawner.Type;
import taz40.rain.level.Level;

public class ParticleSpawner extends Spawner {

	private int life;
	
	public ParticleSpawner(int x, int y, int life, int amount, Level level) {
		super(x, y, Type.PARTICLE, amount, level);
		this.life = life;
		for(int i = 0; i < amount; i++){
				level.add(new Particle(x, y, life));
		}

		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	
}
