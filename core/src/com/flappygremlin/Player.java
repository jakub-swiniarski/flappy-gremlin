package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Object {
    private boolean jumping;
    public int points;
    private float rotation;

    public Player(){
        super("gremlin.png", 0, 0);
        set_pos(
            (int)(Gdx.graphics.getWidth()/2)-get_rect().width/2,
            (int)(Gdx.graphics.getHeight()/2)-get_rect().height/2
        );
        jumping=false;
        points=0;
        rotation=0f;
    }

    public void update(float dt){
        super.update(dt);
        if(Gdx.input.justTouched()){
            set_speed(get_speed().x, 450);
            jumping=true;
            rotation=0;
        }

        if(jumping){
            set_speed(get_speed().x, get_speed().y + 35 * dt);
            rotation+=0.5;
        }
        else{
            set_speed(get_speed().x, get_speed().y - 35 * dt);
            rotation-=0.5;
        }

        if(get_speed().y>=1200*dt){
            jumping=false;
            set_speed(get_speed().x, 0);
        }
    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(imgR, get_rect().x, get_rect().y, 0, 0, get_rect().width, get_rect().height, 1, 1, rotation);
    }
}