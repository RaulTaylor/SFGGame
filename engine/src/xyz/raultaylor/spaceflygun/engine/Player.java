package xyz.raultaylor.spaceflygun.engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import xyz.raultaylor.spaceflygun.engine.graphics.VisualObject;

/**
 * Created by raultaylor on 28.01.18.
 */

public class Player implements VisualObject {

    private Texture texture;
    private Vector2 centerPos;
    private Vector2 drawPos;
    private Vector2 position;
    private Vector2 targetPos;
    private float speed;

    public Player(Texture texture, float speed) {
        this.texture = texture;
        this.speed = speed;
        drawPos = new Vector2(0, 0);
        centerPos = drawPos.cpy().add(new Vector2(texture.getWidth() / 2, texture.getHeight() / 2));
        targetPos = new Vector2(centerPos);
        position = new Vector2(centerPos);

        System.out.println(centerPos);

    }

    @Override
    public void update(float delta) {
        Vector2 range = new Vector2(targetPos);
        range.sub(position);
        if (range.len() > 0.1f) {
            Vector2 speedVector = range.cpy().nor().scl(speed * delta);
            if (range.len() > speedVector.len()) {
                position.add(speedVector);
                drawPos.set(position).sub(centerPos);

            } else {
                position.set(targetPos);
                drawPos.set(position).sub(centerPos);
            }


        }


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(texture, drawPos.x, drawPos.y);

    }

    @Override
    public void dispose() {
        texture.dispose();
    }


    public void setTarget(float x, float y) {

        targetPos.set(x, y);
        System.out.println("Drag: " + targetPos);
    }
}
