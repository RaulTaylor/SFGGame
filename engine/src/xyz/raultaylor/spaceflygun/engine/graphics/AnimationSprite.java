package xyz.raultaylor.spaceflygun.engine.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by raultaylor on 28.01.18.
 */

public class AnimationSprite implements VisualObject{
    public static final int REPEAT_LOOP_ANIMATION = 1;
    public static final int NO_REPEAT_ANIMATION = 0;
    private TextureRegion[] textures;
    //TextureAtlas atlas;
    private float time;
    private int loop;
    private int numberOfFrames;
    private int currentFrame;
    private float currentAniTime;
    private float height;
    private float width;
    private Vector2 position;
    private float timeOfFrame;

    private boolean flagPlay;
    public static boolean PLAY = true;
    public static boolean PAUSE = false;


    public AnimationSprite(TextureRegion[] textures, float time, int loop){
        this.textures = textures;
        this.time = time;
        if(loop == REPEAT_LOOP_ANIMATION || loop == NO_REPEAT_ANIMATION) {
            this.loop = loop;
        } else {
            this.loop = NO_REPEAT_ANIMATION;
        }
        currentAniTime = 0;
        currentFrame = 0;
        numberOfFrames = textures.length;
        position = new Vector2(0,0);
        height = textures[0].getRegionHeight();
        width = textures[0].getRegionWidth();
        timeOfFrame = time/numberOfFrames;
    }

    public AnimationSprite(TextureRegion[] textures, float time){
        this(textures,time, NO_REPEAT_ANIMATION);
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
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(textures[currentFrame], position.x - width/2, position.y - height/2);
    }

    @Override
    public void dispose() {
        for(TextureRegion texture: textures){
            texture = null;
        }
    }

    @Override
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
        this.position = v;
    }

    public boolean isPlay(){
        return flagPlay;
    }

    public boolean isPause(){
        return !flagPlay;
    }


}
