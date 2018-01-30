package xyz.raultaylor.spaceflygun;

import com.badlogic.gdx.Game;

public class SFGGame extends Game{
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}
