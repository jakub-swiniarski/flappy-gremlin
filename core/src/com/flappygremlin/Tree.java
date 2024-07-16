package com.flappygremlin;

import com.badlogic.gdx.Gdx;

public class Tree extends Object {
    private float dt;

    public Tree(float x, float y){
        super("tree.png", x, y);
    }

    public void update(){
        dt=Gdx.graphics.getDeltaTime();
        rect.x-=450*dt;
    }
}
