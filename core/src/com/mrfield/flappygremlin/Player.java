package com.mrfield.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private Texture img;
    private TextureRegion imgR;
    public Rectangle rect;
    private float velocity;
    private boolean jumping;
    public int points;
    private float dt;
    private float rotation;

    public Player(){
        img=new Texture(Gdx.files.internal("gremlin.png"));
        imgR=new TextureRegion(img,0,0,256,256);
        rect=new Rectangle();
        rect.width=256;
        rect.height=256;
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

    public void draw(SpriteBatch batch){
        batch.draw(imgR,rect.x,rect.y,0,0,rect.width,rect.height,1,1,rotation);
    }

    public void dispose(){
        img.dispose();
    }
}
