package xyz.raultaylor.spaceflygun.engine.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by raultaylor on 28.01.18.
 */

public class StaticSprite implements VisualObject{
    Texture texture;
    Vector2 drawPosition;
    float height;
    float width;

    public StaticSprite(Texture texture, Vector2 position){
        this.texture = texture;
        this.height = texture.getHeight();
        this.width = texture.getWidth();
        this.drawPosition = new Vector2(position.x - width/2, position.y - height/2);
    }

    public StaticSprite(Texture texture){
        this(texture, new Vector2(0,0));
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, drawPosition.x,drawPosition.y);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    public void setPosition(Vector2 position){
        this.drawPosition = drawPosition.set(position.x - width/2, position.y - height/2);
    }

}
