package xyz.raultaylor.spaceflygun.engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import xyz.raultaylor.spaceflygun.engine.graphics.StaticSprite;
import xyz.raultaylor.spaceflygun.engine.graphics.VisualObject;

/**
 * Created by raultaylor on 28.01.18.
 */

public class Player implements VisualObject {

    private StaticSprite sprite;
    private Vector2 position;
    private Vector2 targetPos;
    private float speed;
    private boolean visibility;

    public Player(Texture texture,Vector2 startPosition, float speed) {
        this.speed = speed;
        position = startPosition;
        targetPos = new Vector2(startPosition);
        sprite = new StaticSprite(texture, position);
        show();
    }

    @Override
    public boolean isHide() {
        return !visibility;
    }

    @Override
    public void hide() {
        sprite.hide();
    }

    @Override
    public void show() {
        sprite.show();
    }

    @Override
    public boolean isShow() {
        return visibility;
    }

    @Override
    public void update(float delta) {
        Vector2 range = new Vector2(targetPos);
        range.sub(position);
        if (range.len() > 0) {
            Vector2 speedVector = range.cpy().nor().scl(speed * delta);
            if (range.len() > speedVector.len()) {
                position.add(speedVector);
               // sprite.setPosition(position);
            } else {
                position.set(targetPos);
               // sprite.setPosition(position);
            }


        }


    }

    @Override
    public void render(SpriteBatch sb) {
        sprite.render(sb);
    }

    @Override
    public void dispose() {
        sprite.dispose();
    }


    public void setTarget(float x, float y) {
        targetPos.set(x, y);
    }
}
