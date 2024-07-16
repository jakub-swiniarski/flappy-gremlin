package com.flappygremlin;

public class Tree extends Object {
    public Tree(float x, float y){
        super("tree.png", x, y);
        set_speed(-450, 0);
    }

    public void update(float dt){
        super.update(dt);
    }
}
