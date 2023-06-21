package com.mrfield.flappygremlin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyGremlin extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	Tree[] tree = new Tree[4];
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player=new Player();
		for(int i=0; i<4; i++){
			tree[i]=new Tree();
			if(!(i%2==0)){
				tree[i].img=new Texture(Gdx.files.internal("treeF.png"));
			}
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 1, 1, 1);
		batch.begin();
		batch.draw(player.img,player.rect.x,player.rect.y);
		for(int i=0; i<4; i++){
			batch.draw(tree[i].img,tree[i].rect.x,tree[i].rect.y);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.img.dispose();
		for(int i=0; i<4; i++){
			tree[i].img.dispose();
		}
	}
}
