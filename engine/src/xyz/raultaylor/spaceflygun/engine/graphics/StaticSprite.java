package xyz.raultaylor.spaceflygun.engine.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by raultaylor on 28.01.18.
 */

public class StaticSprite implements VisualObject{
    private Texture texture;
    private Vector2 drawPosition;
    private Vector2 position;
    private float height;
    private float width;
    private boolean visibility;

    @Override
    public boolean isHide() {
        return !visibility;
    }

    @Override
    public void hide() {
        visibility = HIDE_OBJECT;
    }

    @Override
    public void show() {
        visibility = SHOW_OBJECT;
    }

    @Override
    public boolean isShow() {
        return visibility;
    }

    public StaticSprite(Texture texture, Vector2 position){
        this.texture = texture;
        this.height = texture.getHeight();
        this.width = texture.getWidth();
        this.position = position;
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
        if(visibility) {
            drawPosition.set(position.x - width / 2, position.y - height / 2);
            spriteBatch.draw(texture, drawPosition.x, drawPosition.y);
        }
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    public void setPosition(Vector2 position){
        this.position = position;
    }

    public void setStaticPosition(Vector2 staticPosition){
        setPosition(new Vector2(staticPosition));
    }

    public void setStaticPosition(float x, float y){
        setPosition(new Vector2(x,y));
    }

}
