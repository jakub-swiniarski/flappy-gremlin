package com.mrfield.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    public Texture img;
    public Rectangle rect;
    private float velocity;
    private boolean jumping;
    public int points;
    private float dt;

    public Player(){
        img=new Texture(Gdx.files.internal("gremlin.png"));
        rect=new Rectangle();
        rect.width=256;
        rect.height=256;
        rect.x=(int)(Gdx.graphics.getWidth()/2)-rect.width/2;
        rect.y=(int)(Gdx.graphics.getHeight()/2)-rect.height/2;
        velocity=0f;
        jumping=false;
        points=0;
    }

    public void update(){
        dt=Gdx.graphics.getDeltaTime();
        if(Gdx.input.justTouched()){
            velocity=350*dt;
            jumping=true;
        }

        if(jumping){
            rect.y+=velocity;
            velocity+=35*dt;
        }
        else{
            rect.y+=velocity;
            velocity-=35*dt;
        }

        if(velocity>=1200*dt){
            jumping=false;
            velocity=0;
        }
    }
}
