package com.flappygremlin;

public class BG extends Object {
    public BG(float x, float y){
        super("bg.png", x, y);
        speed.x=-45;
    }

    public void update(float dt){
        super.update(dt);
        if(rect.x+rect.width<=0){
            rect.x=rect.width;
        }
    }
}
