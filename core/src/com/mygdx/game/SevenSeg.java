package com.mygdx.game;

//To do: Test file loads
//To do: scale elements
//To do: figure out how to structure the set postion and batch draw method
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SevenSeg {

    private Sprite pA;
    private Sprite pB;
    private Sprite pC;
    private Sprite pD;
    private Sprite pE;
    private Sprite pF;
    private Sprite pG;
    private Sprite pH;
    private Sprite pDp;

    private TextureAtlas textureAtlas;

    private boolean showDp = true;
    private float pX = 100;
    private float pY = 100;
    private float pscale = 1;
    private float onR = 1, onG = 0, onB = 0, offR = 0, offG = 0, offB = 0;

    private boolean seg[];

    public void setSevenSeg() {
        //FIX need to test file loads
        seg = new boolean[]{true, true, true, true, true, true, true, true};
        textureAtlas = new TextureAtlas(Gdx.files.internal("sevenseg.atlas"));
        pDp = new Sprite(textureAtlas.findRegion("dp"));
        pA = new Sprite(textureAtlas.findRegion("A"));
        pB = new Sprite(textureAtlas.findRegion("B"));
      //  pC = new Sprite(textureAtlas.findRegion("C"));
      //  pD = new Sprite(textureAtlas.findRegion("D"));
     //   pE = new Sprite(textureAtlas.findRegion("E"));
     //   pF = new Sprite(textureAtlas.findRegion("F"));
     //   pG = new Sprite(textureAtlas.findRegion("G"));
     //   pH = new Sprite(textureAtlas.findRegion("H"));

    }

    public void setDpSS(boolean dp) {
        showDp = dp;
    }

    public void setXSS(float displayX) {
        pX = displayX;
    }

    public void setYSS(float displayY) {
        pY = displayY;
    }

    public void setDisplayScaleSS(float scale) {
        pscale = scale;
    }

    public void setOffColourSS(float red, float green, float blue) {
        offR = red;
        offG = green;
        offG = blue;
    }

    public void setOnColourSS(float red, float green, float blue) {
        onR = red;
        onG = green;
        onB = blue;
    }

    public void setOnSS(boolean A, boolean B, boolean C, boolean D, boolean E, boolean F, boolean G, boolean Dp) {
        seg[0] = Dp;
        seg[1] = A;
        seg[2] = B;
        seg[3] = C;
        seg[4] = D;
        seg[5] = E;
        seg[6] = F;
        seg[7] = G;


    }

    public void setSegs() {
        //FIX: Need to make position of elements scale
        pA.setPosition(pX, pY+100);
        pA.setColor(onR, onG, onB, 1);
        pB.setPosition(pX + 95, pY + 50);
        pB.setColor(onR, onG, onB, 1);
        pDp.setPosition(pX+111, pY);
        pDp.setColor(onR, onG, onB, 1);
    }


    public void setRenderBatchSS(SpriteBatch batch){
        setSegs();
        pA.draw(batch);
        pB.draw(batch);
        pDp.draw(batch);

    }
        }
