package com.mygdx.game;

/**
 * Created by TheParticleBridge on 01/08/2015.
 */

import java.util.Arrays;
import com.mygdx.game.SevenSeg;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Arrays;
import java.util.Iterator;

public class InstrumentPanel implements ApplicationListener {
    private Texture dropImage;
    private Texture bucketImage;
    private Sound dropSound;
    private Music rainMusic;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Rectangle slider;
    private long lastDropTime;
    public SevenSeg sevenseg;


    @Override
    public void create() {
        //Load camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        //Load sprite
        batch = new SpriteBatch();

        // create a Rectangle to logically represent the slider
        slider = new Rectangle();
        slider.x = 800 / 2 - 64 / 2;
        slider.y = 20;
        slider.width = 64;
        slider.height = 64;

        // load the images for the droplet and the bucket, 64x64 pixels each
     //   dropImage = new Texture(Gdx.files.internal("ss_dp.png"));
    //
    //
      bucketImage = new Texture(Gdx.files.internal("bucket.png"));

        // load the drop sound effect and the rain background "music"
    //    dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
    //Display
        sevenseg= new SevenSeg();
        sevenseg.setSevenSeg();
    }



    @Override
    public void render() {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);

        //Standrad seven segment display
        // 4 long as wide
        //  1xxx
        // 2    7
        // x    x
        // x    x
        // x    x
        //  3xxx
        // 4    6
        // x    x
        // x    x
        // x    x
        //  5xxx  8
        batch.begin();

        batch.draw(bucketImage, slider.x, slider.y);
;     //  batch.setColor(1, 0, 0, 1);

     // batch.draw(dropImage, 50, 50, 5, 20);
        sevenseg.setRenderBatchSS(batch);
        batch.end();

        //Monitor user input
        /*if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            slider.x = touchPos.x - 64 / 2;
        }

        //Keep bucket in screen
        if (slider.x < 0) slider.x = 0;
        if (slider.x > 800 - 64) slider.x = 800 - 64;

        //New raindrop
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();

        // move the raindrops, remove any that are beneath the bottom edge of
        // the screen or that hit the bucket. In the later case we play back
        // a sound effect as well.
        Iterator<Rectangle> iter = sevenseg.iterator();
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if (raindrop.y + 64 < 0) iter.remove();
            //bucket raindrop collision
            if (raindrop.overlaps(slider)) {
                dropSound.play();
                iter.remove();
            }
        }
        */
    }


    @Override
    public void dispose() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}