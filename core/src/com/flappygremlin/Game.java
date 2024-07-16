package com.flappygremlin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	private static final String FONT_NAME = "font.ttf";
	private static final int FONT_SIZE_BIG = 120;
	private static final int FONT_SIZE_SMALL = 56;
	private static final int FONT_BORDER_BIG = 3;
	private static final int FONT_BORDER_SMALL = 2;

	SpriteBatch batch;
	Player player;
	Tree[] tree = new Tree[2];
	BitmapFont fontBig, fontSmall;
	BG[] bg = new BG[2];
	GameStatus game_status;
	GlyphLayout glyphLayout;

	public enum GameStatus {
		MENU,
		IN_PROGRESS,
		OVER
	}

	public void reset(){
		player=new Player();

		tree[0].set_pos(Gdx.graphics.getWidth() * 2, -200);
		tree[1].set_pos(Gdx.graphics.getWidth() * 2, 1600);

		for(int i=0; i<2; i++) {
			bg[i].set_pos(i * bg[i].get_rect().width, 0);
		}
	}
	@Override
	public void create () {
		batch = new SpriteBatch();
		glyphLayout = new GlyphLayout();
		for(int i=0; i<2; i++) {
			tree[i] = new Tree(0, 0);
			bg[i] = new BG(0, 0);
		}
		tree[1].imgR.flip(false,true);
		reset();

		game_status = GameStatus.MENU;

		FontGenerator font_generator = new FontGenerator(FONT_NAME);
		fontBig = font_generator.generate_font(FONT_SIZE_BIG, FONT_BORDER_BIG);
		fontSmall = font_generator.generate_font(FONT_SIZE_SMALL, FONT_BORDER_SMALL);
		font_generator.dispose();
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		ScreenUtils.clear(0, 1, 1, 1);
		batch.begin();
		for(int i=0; i<2; i++){
			bg[i].draw(batch);
			tree[i].draw(batch);
		}
		player.draw(batch);

		switch (game_status) {
			case MENU:
				glyphLayout.setText(fontBig, "FLAPPY GREMLIN");
				fontBig.draw(batch, glyphLayout, (Gdx.graphics.getWidth() - glyphLayout.width)/2, Gdx.graphics.getHeight() - 100);
				glyphLayout.setText(fontSmall, "TOUCH THE SCREEN TO START");
				fontSmall.draw(batch, glyphLayout, (Gdx.graphics.getWidth() - glyphLayout.width)/2, Gdx.graphics.getHeight() - 200);
				break;
			case IN_PROGRESS:
				glyphLayout.setText(fontBig, Integer.toString(player.get_points()));
				fontBig.draw(batch, glyphLayout, (Gdx.graphics.getWidth() - glyphLayout.width)/2, Gdx.graphics.getHeight() - 100);

				for(int i=0; i<2; i++) {
					bg[i].update(dt);
					tree[i].update(dt);
				}
				player.update(dt);
				break;
			case OVER:
				glyphLayout.setText(fontBig, "GAME OVER!");
				fontBig.draw(batch, glyphLayout, (Gdx.graphics.getWidth() - glyphLayout.width)/2, Gdx.graphics.getHeight() - 100);
				glyphLayout.setText(fontSmall, "TOUCH THE SCREEN TO START AGAIN");
				fontSmall.draw(batch, glyphLayout, (Gdx.graphics.getWidth() - glyphLayout.width)/2, Gdx.graphics.getHeight() - 200);
				break;
		}

		batch.end();

		if(game_status != GameStatus.IN_PROGRESS && Gdx.input.justTouched()){
			reset();
			game_status = GameStatus.IN_PROGRESS;
		}

		if(tree[0].get_rect().x<0-tree[0].get_rect().width){
			player.set_passed(false);
			tree[0].set_pos(1080, -500+(float)Math.random() * 200);
			tree[1].set_pos(1080, 1400+(float)Math.random() * 200);
		}

		if(player.get_rect().x>tree[0].get_rect().x && !player.has_passed()){
			player.set_passed(true);
			player.add_points(1);
		}

		for(int i=0; i<2; i++){
			if(player.get_rect().overlaps(tree[i].get_rect()) || player.get_rect().y<=0 || player.get_rect().y+player.get_rect().height>=Gdx.graphics.getHeight()){
				game_status = GameStatus.OVER;
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
		for(int i=0; i<2; i++){
			tree[i].dispose();
			bg[i].dispose();
		}
		fontSmall.dispose();
		fontBig.dispose();
	}
}
