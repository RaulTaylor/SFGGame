package xyz.raultaylor.spaceflygun.engine.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import xyz.raultaylor.spaceflygun.engine.base.Rect;

/**
 * Created by raultaylor on 28.01.18.
 */

public class StaticSprite extends Rect implements VisualObject{
    protected TextureRegion[] textures;
    protected boolean visibility;
    protected float angle;
    protected float scale;
    protected int currentFrame;

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

    public StaticSprite(TextureRegion[] textures, Vector2 position){
        this.textures = textures;
        this.pos.set(position);
        this.angle = 0f;
        this.scale = 0f;
        currentFrame = 0;
        show();
    }

    //public StaticSprite(Texture texture){
      //  this(texture, new Vector2(0,0));
    //}


    @Override
    public void draw(SpriteBatch spriteBatch) {
        if(visibility) {
            spriteBatch.draw(
                    textures[currentFrame], // текущий регион
                    getLeft(), getBottom(), // точка отрисовки
                    halfWidth, halfHeight, // точка вращения
                    getWidth(), getHeight(), // ширина и высота
                    scale, scale, // масштаб по x и y
                    angle // угол вращения
            );
        }
    }

    @Override
    public void dispose() {
        this.textures[currentFrame] = null;

    }

    public void setPosition(Vector2 position){
        this.pos.set(position);
    }


    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void resize(Rect worldBounds){

    }
}
