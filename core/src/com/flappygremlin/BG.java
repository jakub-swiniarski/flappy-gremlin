package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class BG {
    private Texture img;
    public Rectangle rect;
    private float dt;

    public BG(){
        img=new Texture(Gdx.files.internal("bg.png"));
        rect=new Rectangle();
        rect.width=4563;
        rect.height=2220;
        rect.x=0;
        rect.y=0;
    }

    public void update(){
        dt=Gdx.graphics.getDeltaTime();
        rect.x-=45*dt;
        if(rect.x+rect.width<=0){
            rect.x=rect.width;
        }
    }

    public void draw(SpriteBatch batch){
        batch.draw(img, rect.x, rect.y);
    }

    public void dispose(){
        img.dispose();
    }
}
