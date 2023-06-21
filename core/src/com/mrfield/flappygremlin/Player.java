package com.mrfield.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    public Texture img;
    public Rectangle rect;

    public Player(){
        img=new Texture(Gdx.files.internal("gremlin.png"));
        rect=new Rectangle();
        rect.width=791;
        rect.height=927;
        rect.x=100;
        rect.y=100;
    }

    public void update(){

    }
}
