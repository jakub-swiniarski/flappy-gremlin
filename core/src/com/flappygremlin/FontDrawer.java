package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FontDrawer {
    private final GlyphLayout glyphLayout;
    private final SpriteBatch batch;

    FontDrawer(SpriteBatch batch) {
        glyphLayout = new GlyphLayout();
        this.batch = batch;
    }

    public void draw_centered(BitmapFont font, String str, int offset_top) {
        glyphLayout.setText(font, str);
        font.draw(batch, glyphLayout, (Gdx.graphics.getWidth() - glyphLayout.width)/2, Gdx.graphics.getHeight() - offset_top);
    }
}
