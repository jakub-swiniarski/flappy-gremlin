package com.flappygremlin;

import com.badlogic.gdx.Gdx;

public class Tree extends Object {
    public Tree(float x, float y){
        super("tree.png", x, y);
        speed.x=-450;
    }

    public void update(float dt){
        super.update(dt);
    }
}
