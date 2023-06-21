package com.mrfield.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Tree {
    public Texture img;
    public Rectangle rect;

    public Tree(){
        img=new Texture(Gdx.files.internal("tree.png"));
        rect=new Rectangle();
        rect.width=256;
        rect.height=1024;
        rect.x=0;
        rect.y=0;
    }

    public void update(){

    }
}
