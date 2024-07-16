package com.flappygremlin;

public class BG extends Object {
    public BG(float x, float y){
        super("bg.png", x, y);
        set_speed(-45, 0);
    }

    public void update(float dt){
        super.update(dt);
        if(get_rect().x+get_rect().width<=0) {
            get_rect().x=get_rect().width;
        }
    }
}
