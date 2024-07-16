package com.flappygremlin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontGenerator {
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    FontGenerator(String font_path) {
        generator = new FreeTypeFontGenerator(Gdx.files.internal(font_path));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    }

    BitmapFont generate_font(int size, int border_width, Color color, Color border_color) {
        parameter.size = size;
        parameter.borderWidth = border_width;
        parameter.color = color;
        parameter.borderColor = border_color;

        return generator.generateFont(parameter);
    }

    public void dispose() {
        generator.dispose();
    }
}
