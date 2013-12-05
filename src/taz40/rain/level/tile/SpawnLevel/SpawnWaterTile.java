package taz40.rain.level.tile.SpawnLevel;

import taz40.rain.graphics.Screen;
import taz40.rain.graphics.Sprite;
import taz40.rain.level.tile.Tile;

public class SpawnWaterTile extends Tile {

	public SpawnWaterTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}

}
