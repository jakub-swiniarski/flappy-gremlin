package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Object {
    public Texture img;
    public TextureRegion imgR;
    public Rectangle rect;
    public Vector2 speed;

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
