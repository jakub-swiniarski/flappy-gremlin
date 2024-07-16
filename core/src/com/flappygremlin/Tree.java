package com.flappygremlin;

public class Tree extends Object {
    private static final float SPEED_X = -450.0f;

    public Tree(float x, float y) {
        super("tree.png", x, y);
        set_speed(SPEED_X, 0.0f);
    }
}
