package com.flappygremlin;

public class BG extends Object {
    private static final float SPEED_X = -45.0f;

    public BG(float x, float y) {
        super("bg.png", x, y);
        set_speed(SPEED_X, 0.0f);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if (get_rect().x + get_rect().width <= 0.0f) {
            get_rect().x = get_rect().width;
        }
    }
}
