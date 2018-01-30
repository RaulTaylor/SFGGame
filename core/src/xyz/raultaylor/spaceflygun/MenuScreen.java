package xyz.raultaylor.spaceflygun;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import xyz.raultaylor.spaceflygun.engine.BackGround;
import xyz.raultaylor.spaceflygun.engine.Base2DScreen;
import xyz.raultaylor.spaceflygun.engine.Player;
import xyz.raultaylor.spaceflygun.engine.graphics.VisualObject;

/**
 * Created by raultaylor on 28.01.18.
 */

public class MenuScreen extends Base2DScreen {

    ArrayList<VisualObject> visualObjectList;
    SpriteBatch spriteBatch;
    Player player;


    public MenuScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
        visualObjectList = new ArrayList<VisualObject>();
        spriteBatch = new SpriteBatch();
        player = new Player(new Texture("images/ship.png"),new Vector2(100,100), 500);
        visualObjectList.add(new BackGround(new Texture("images/bg.png")));
        visualObjectList.add(player);
    }

    @Override
    public void dispose() {
        super.dispose();
        for(VisualObject obj : visualObjectList){
            obj.dispose();
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        for(VisualObject obj : visualObjectList){
            obj.update(delta);
            obj.render(spriteBatch);
        }
        spriteBatch.end();
    }



    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {


        player.setTarget(screenX, Gdx.graphics.getHeight()-screenY);

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {


        player.setTarget(screenX, Gdx.graphics.getHeight()-screenY);

        return true;
    }
}
