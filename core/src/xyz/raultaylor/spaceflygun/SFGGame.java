package xyz.raultaylor.spaceflygun;

import com.badlogic.gdx.Game;

import xyz.raultaylor.spaceflygun.screens.MenuScreen;

public class SFGGame extends Game{
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}
