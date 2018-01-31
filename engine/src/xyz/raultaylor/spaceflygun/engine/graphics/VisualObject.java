package xyz.raultaylor.spaceflygun.engine.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by raultaylor on 28.01.18.
 */

public interface VisualObject {

    boolean SHOW_OBJECT = true;
    boolean HIDE_OBJECT = false;

    void update(float delta);
    void render(SpriteBatch sb);
    void dispose();
    boolean isHide();
    void hide();
    void show();
    boolean isShow();
}
