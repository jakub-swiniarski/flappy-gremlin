package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Object {
    private final Texture img;
    public TextureRegion imgR;
    private final Rectangle rect;
    private final Vector2 speed;

    Object(String img_path, float x, float y) {
        img=new Texture(Gdx.files.internal(img_path));
        imgR = new TextureRegion(img, 0, 0, img.getWidth(), img.getHeight());
        rect=new Rectangle();
        rect.width=img.getWidth();
        rect.height=img.getHeight();
        rect.x=x;
        rect.y=y;
        speed = new Vector2(0, 0);
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

    public void update(float dt) {
        rect.x += speed.x * dt;
        rect.y += speed.y * dt;
    }

    public void draw(SpriteBatch batch){
        batch.draw(imgR, rect.x, rect.y);
    }

    public void dispose(){
        img.dispose();
    }
}
