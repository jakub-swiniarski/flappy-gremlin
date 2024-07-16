package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Object {
    private boolean jumping;
    public int points;
    private float rotation;

    public Player(){
        super("gremlin.png", 0, 0);
        rect.x=(int)(Gdx.graphics.getWidth()/2)-rect.width/2;
        rect.y=(int)(Gdx.graphics.getHeight()/2)-rect.height/2;
        jumping=false;
        points=0;
        rotation=0f;
    }

    public void update(float dt){
        super.update(dt);
        if(Gdx.input.justTouched()){
            speed.y=350;
            jumping=true;
            rotation=0;
        }

        if(jumping){
            speed.y+=35*dt;
            rotation+=0.5;
        }
        else{
            speed.y-=35*dt;
            rotation-=0.5;
        }

        if(speed.y>=1200*dt){
            jumping=false;
            speed.y=0;
        }
    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(imgR,rect.x,rect.y,0,0,rect.width,rect.height,1,1,rotation);
    }
}
