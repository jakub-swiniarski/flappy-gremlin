package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Object {
    private float velocity;
    private boolean jumping;
    public int points;
    private float dt;
    private float rotation;

    public Player(){
        super("gremlin.png", 0, 0);
        rect.x=(int)(Gdx.graphics.getWidth()/2)-rect.width/2;
        rect.y=(int)(Gdx.graphics.getHeight()/2)-rect.height/2;
        velocity=0f;
        jumping=false;
        points=0;
        rotation=0f;
    }

    public void update(){
        dt=Gdx.graphics.getDeltaTime();
        if(Gdx.input.justTouched()){
            velocity=350*dt;
            jumping=true;
            rotation=0;
        }

        if(jumping){
            rect.y+=velocity;
            velocity+=35*dt;
            rotation+=0.5;
        }
        else{
            rect.y+=velocity;
            velocity-=35*dt;
            rotation-=0.5;
        }

        if(velocity>=1200*dt){
            jumping=false;
            velocity=0;
        }
    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(imgR,rect.x,rect.y,0,0,rect.width,rect.height,1,1,rotation);
    }
}
