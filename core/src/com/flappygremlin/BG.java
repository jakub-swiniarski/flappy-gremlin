package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class BG extends Object {
    private float dt;

    public BG(float x, float y){
        super("bg.png", x, y);
    }

    public void update(){
        dt=Gdx.graphics.getDeltaTime();
        rect.x-=45*dt;
        if(rect.x+rect.width<=0){
            rect.x=rect.width;
        }
    }
}
