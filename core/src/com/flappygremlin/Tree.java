package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Tree {
    private Texture img;
    public TextureRegion imgR;
    public Rectangle rect;
    private float dt;

    public Tree(){
        img=new Texture(Gdx.files.internal("tree.png"));
        imgR = new TextureRegion(img, 0,0,256,1024);
        rect=new Rectangle();
        rect.width=256;
        rect.height=1024;
        rect.x=0;
        rect.y=0;
    }

    public void update(){
        dt=Gdx.graphics.getDeltaTime();
        rect.x-=450*dt;
    }

    public void draw(SpriteBatch batch){
        batch.draw(imgR, rect.x, rect.y);
    }

    public void dispose(){
        img.dispose();
    }
}
