package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FontDrawer {
    private final GlyphLayout glyph_layout;
    private final SpriteBatch batch;

    FontDrawer(SpriteBatch batch) {
        glyph_layout = new GlyphLayout();
        this.batch = batch;
    }

    public void draw_centered(BitmapFont font, String str, int offset_top) {
        glyph_layout.setText(font, str);
        font.draw(batch, glyph_layout, (Gdx.graphics.getWidth() - glyph_layout.width) / 2.0f, Gdx.graphics.getHeight() - offset_top);
    }
}
