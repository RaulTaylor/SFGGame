package xyz.raultaylor.spaceflygun.engine.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by raultaylor on 28.01.18.
 */

public interface VisualObject {
    void update(float delta);
    void render(SpriteBatch sb);
    void dispose();
}
