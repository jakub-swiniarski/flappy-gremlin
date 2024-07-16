package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Object {
    private final Texture img;
    private final TextureRegion img_reg;
    private final Rectangle rect;
    private final Vector2 speed;
    private float rotation;

    Object(String img_path, float x, float y) {
        img=new Texture(Gdx.files.internal(img_path));
        img_reg = new TextureRegion(img, 0, 0, img.getWidth(), img.getHeight());
        rect=new Rectangle();
        rect.width=img.getWidth();
        rect.height=img.getHeight();
        rect.x=x;
        rect.y=y;
        speed = new Vector2(0, 0);
        rotation = 0.0f;
    }

    public void flip_img_reg(boolean x, boolean y) {
        img_reg.flip(x, y);
    }

    public Rectangle get_rect() {
        return rect;
    }

    public void set_pos(float x, float y) {
        rect.x = x;
        rect.y = y;
    }

    public Vector2 get_speed() {
        return speed;
    }

    public void set_speed(float x, float y) {
        speed.x = x;
        speed.y = y;
    }

    public void add_speed(float x, float y) {
        speed.x += x;
        speed.y += y;
    }

    public void set_rotation(float rotation) {
        this.rotation = rotation;
    }

    public void add_rotation(float rotation) {
        this.rotation += rotation;
    }

    public void update(float dt) {
        rect.x += speed.x * dt;
        rect.y += speed.y * dt;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(img_reg, get_rect().x, get_rect().y, 0.0f, 0.0f, get_rect().width, get_rect().height, 1.0f, 1.0f, rotation);
    }

    public void dispose(){
        img.dispose();
    }
}
