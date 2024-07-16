package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Object {
    private static final float ACCEL_GRAVITY  = -500.0f;
    private static final float SPEED_JUMP     = 600.0f;
    private static final float SPEED_ROTATION = 20.0f;

    private int     points;
    private float   rotation;
    private boolean passed;

    public Player() {
        super("gremlin.png", 0.0f, 0.0f);
        set_pos(
            (Gdx.graphics.getWidth() / 2.0f) - get_rect().width / 2.0f,
            (Gdx.graphics.getHeight() / 2.0f) - get_rect().height / 2.0f
        );
        points   = 0;
        rotation = 0f;
        passed   = false;
    }

    public int get_points() {
        return points;
    }

    public void add_points(int points) {
        this.points += points;
    }

    public boolean has_passed() {
        return passed;
    }

    public void set_passed(boolean passed) {
        this.passed = passed;
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if (Gdx.input.justTouched()) {
            set_speed(0.0f, SPEED_JUMP);
            rotation = 0.0f;
        }
        add_speed(0.0f, ACCEL_GRAVITY * dt);
        rotation += (get_speed().y > 0.0f) ? (SPEED_ROTATION * dt) : (-SPEED_ROTATION * dt);
    }
}
