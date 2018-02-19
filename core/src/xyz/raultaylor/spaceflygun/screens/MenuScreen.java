package xyz.raultaylor.spaceflygun.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import xyz.raultaylor.spaceflygun.engine.Base2DScreen;

/**
 * Created by raultaylor on 28.01.18.
 */

public class MenuScreen extends Base2DScreen {

    public MenuScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }



    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {


        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {


        return true;
    }
}
