package xyz.raultaylor.spaceflygun.engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import xyz.raultaylor.spaceflygun.engine.graphics.VisualObject;


/**
 * Created by raultaylor on 28.01.18.
 */

public class BackGround implements VisualObject {

    private Texture texture;

    public BackGround(Texture texture){
        this.texture = texture;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(texture,0,0);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
