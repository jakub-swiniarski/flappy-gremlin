package com.mrfield.flappygremlin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyGremlin extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	Tree[] tree = new Tree[4];
	boolean gameStarted, gameOver;
	FreeTypeFontGenerator generator;
	FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	BitmapFont fontBig, fontSmall;

	public void reset(){
		player=new Player();
		tree[0].rect.x=1080*2;
		tree[0].rect.y=-200;

		tree[1].rect.y=1600;
		tree[1].rect.x=1080*2;

		tree[2].rect.x=9999;
		tree[2].rect.y=-250;

		tree[3].rect.x=9999;
		tree[3].rect.y=1380;
	}
	@Override
	public void create () {
		batch = new SpriteBatch();
		for(int i=0; i<4; i++) {
			tree[i] = new Tree();
			if (!(i % 2 == 0)) {
				tree[i].img = new Texture(Gdx.files.internal("treeF.png"));
			}
		}
		reset();

		gameStarted=false;
		gameOver=false;

		generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 120;
		parameter.borderWidth=3;
		parameter.borderColor = Color.LIME;
		fontBig = generator.generateFont(parameter);

		parameter.size=56;
		parameter.borderWidth=1;
		fontSmall=generator.generateFont(parameter);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 1, 1, 1);
		batch.begin();
		batch.draw(player.img,player.rect.x,player.rect.y);
		if(gameStarted)player.update();
		for(int i=0; i<4; i++){
			batch.draw(tree[i].img,tree[i].rect.x,tree[i].rect.y);
			if(gameStarted)tree[i].update();
		}

		if(!gameStarted && !gameOver){
			fontBig.draw(batch, "FLAPPY GREMLIN", 60, 1500);
			fontSmall.draw(batch, "TOUCH THE SCREEN TO START", 150, 1400);
		}
		if(gameOver){
			fontBig.draw(batch, "GAME OVER!", 200, 1500);
			fontSmall.draw(batch, "TOUCH THE SCREEN TO START AGAIN", 50, 1400);
		}
		if(!gameStarted && Gdx.input.justTouched()){
			reset();
			gameStarted=true;
			gameOver=false;
		}

		batch.end();

		if(tree[2].rect.x<0-tree[2].rect.width){
			tree[2].rect.x=1080*3;
			tree[3].rect.x=1080*3;
			tree[0].rect.x=1080;
			tree[1].rect.x=1080;

			tree[0].rect.y=-100-(float)Math.random() * 201;
			tree[1].rect.y=1500-(float)Math.random() * 201;
		}

		if(tree[0].rect.x<0-tree[0].rect.width){
			tree[0].rect.x=1080*3;
			tree[1].rect.x=1080*3;
			tree[2].rect.x=1080;
			tree[3].rect.x=1080;

			tree[2].rect.y=-500+(float)Math.random() * 201;
			tree[3].rect.y=1300+(float)Math.random() * 201;
		}

		for(int i=0; i<4; i++){
			if(player.rect.overlaps(tree[i].rect) || player.rect.y<=0){
				gameStarted=false;
				gameOver=true;
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.img.dispose();
		for(int i=0; i<4; i++){
			tree[i].img.dispose();
		}
		fontSmall.dispose();
		fontBig.dispose();
		generator.dispose();
	}
}
