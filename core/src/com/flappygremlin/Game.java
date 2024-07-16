package com.flappygremlin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	Tree[] tree = new Tree[2];
	boolean gameStarted, gameOver;
	BitmapFont fontBig, fontSmall;
	boolean passed;
	BG[] bg = new BG[2];
	GameStatus game_status;

	public enum GameStatus {
		MENU,
		IN_PROGRESS,
		OVER
	}

	public void reset(){
		player=new Player();
		player.points=0;

		tree[0].rect.x=1080*2;
		tree[0].rect.y=-200;

		tree[1].rect.x=1080*2;
		tree[1].rect.y=1600;

		for(int i=0; i<2; i++){
			bg[i]=new BG(0, 0);
			bg[i].rect.x=i*bg[i].rect.width;
		}

		passed=false;
	}
	@Override
	public void create () {
		batch = new SpriteBatch();
		for(int i=0; i<2; i++) {
			tree[i] = new Tree(0, 0);
		}
		tree[1].imgR.flip(false,true);
		reset();

		game_status = GameStatus.MENU;

		FontGenerator font_generator = new FontGenerator("font.ttf");
		fontBig = font_generator.generate_font(120, 3);
		fontSmall = font_generator.generate_font(56, 2);
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

			if(gameStarted){
				bg[i].update(dt);
				tree[i].update(dt);
			}
		}
		player.draw(batch);
		if(gameStarted)player.update(dt);

		switch (game_status) {
			case MENU:
				fontBig.draw(batch, "FLAPPY GREMLIN", 60, 1500);
				fontSmall.draw(batch, "TOUCH THE SCREEN TO START", 150, 1400);
				break;
			case IN_PROGRESS:
				fontBig.draw(batch, Integer.toString(player.points), 480,1800);
			case OVER:
				fontBig.draw(batch, "GAME OVER!", 200, 1500);
				fontSmall.draw(batch, "TOUCH THE SCREEN TO START AGAIN", 50, 1400);
		}

		if(game_status != GameStatus.IN_PROGRESS && Gdx.input.justTouched()){
			reset();
			gameStarted=true;
			gameOver=false;
		}

		batch.end();

		if(tree[0].rect.x<0-tree[0].rect.width){
			passed=false;
			tree[0].rect.x=1080;
			tree[1].rect.x=1080;

			tree[0].rect.y=-500+(float)Math.random() * 201;
			tree[1].rect.y=1400+(float)Math.random() * 201;
		}

		if(player.rect.x>tree[0].rect.x && !passed){
			passed=true;
			player.points++;
		}

		for(int i=0; i<2; i++){
			if(player.rect.overlaps(tree[i].rect) || player.rect.y<=0 || player.rect.y+player.rect.height>=Gdx.graphics.getHeight()){
				gameStarted=false;
				gameOver=true;
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
