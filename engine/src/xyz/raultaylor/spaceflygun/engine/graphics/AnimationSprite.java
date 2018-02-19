package xyz.raultaylor.spaceflygun.engine.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by raultaylor on 28.01.18.
 */

public class AnimationSprite extends StaticSprite {
    public static final int REPEAT_LOOP_ANIMATION = 1;
    public static final int NO_REPEAT_ANIMATION = 0;
    //TextureAtlas atlas;
    private float time;
    private int loop;
    private int numberOfFrames;
    private int currentFrame;
    private float currentAniTime;
    private float timeOfFrame;

    private boolean flagPlay;
    public static boolean PLAY = true;
    public static boolean PAUSE = false;


    public AnimationSprite(TextureRegion[] textures, float time, int loop, Vector2 position){
        super(textures,position);
        this.time = time;
        if(loop == REPEAT_LOOP_ANIMATION || loop == NO_REPEAT_ANIMATION) {
            this.loop = loop;
        } else {
            this.loop = NO_REPEAT_ANIMATION;
        }
        currentAniTime = 0;
        numberOfFrames = textures.length;
        timeOfFrame = time/numberOfFrames;

    }

    public AnimationSprite(TextureRegion[] textures, float time, Vector2 position){
        this(textures,time, NO_REPEAT_ANIMATION, position);
    }

    public void play(){
        flagPlay = PLAY;
    }

    public void pause(){
        flagPlay = PAUSE;
    }

    public void stop(){
        restart();
        pause();
    }

    public void repeat(){
        restart();
        play();
    }

    private void restart(){
        currentFrame = 0;
        currentAniTime = 0;
    }

    public boolean isLoop(){
        return loop == REPEAT_LOOP_ANIMATION;
    }

    public float getTime(){
        return time;
    }

    public int getNumberOfFrames(){
        return numberOfFrames;
    }

    public int getCurrentFrame(){
        return currentFrame;
    }

    public float getCurrentAniTime(){
        return currentAniTime;
    }

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
        for(TextureRegion texture: textures){
            texture = null;
        }
    }

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

    public void update(float delta){

        if(flagPlay == PLAY){
            currentAniTime += delta;
        }
        if(currentAniTime > time && loop == REPEAT_LOOP_ANIMATION){
            currentAniTime -= time;
        } else {
            pause();
        }
        if(flagPlay == PLAY){
            currentFrame = (int)(currentAniTime / timeOfFrame);
        }

    }

    public void setPosition(Vector2 v){
        this.pos.set(v);
    }

    public boolean isPlay(){
        return flagPlay;
    }

    public boolean isPause(){
        return !flagPlay;
    }


}
