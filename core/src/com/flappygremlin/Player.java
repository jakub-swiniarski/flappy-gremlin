package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Object {
    public int points;
    private float rotation;

    public Player(){
        super("gremlin.png", 0, 0);
        set_pos(
            (int)(Gdx.graphics.getWidth()/2)-get_rect().width/2,
            (int)(Gdx.graphics.getHeight()/2)-get_rect().height/2
        );
        points=0;
        rotation=0f;
    }

    public void update(float dt){
        super.update(dt);
        if(Gdx.input.justTouched()){
            set_speed(0, 450);
            rotation=0;
        }
        add_speed(0, -350 * dt);
        rotation += (float)((get_speed().y > 0) ? (10 * dt) : (-10 * dt));
    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(imgR, get_rect().x, get_rect().y, 0, 0, get_rect().width, get_rect().height, 1, 1, rotation);
    }
}