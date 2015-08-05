package com.squirrelbot.text.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;
import com.squirrelbot.text.CharacterScreen;

public class ScreenRenderer implements Disposable {
	
	CharacterScreen screen;
	Texture font;
	TextureRegion[] fontChars;
	
	SpriteBatch batch;
	int fontWidth;
	int fontHeight;
	
	float scale = 0;
	
	Color tmp;
	
	Settings settings;

	public ScreenRenderer(CharacterScreen screen, Texture font, int fontWidth, int fontHeight)
	{
		this.screen = screen;
		this.font = font;
		this.fontWidth = fontWidth;
		this.fontHeight = fontHeight;
		
        TextureRegion[][] tmp = TextureRegion.split(font, fontWidth, fontHeight);
        fontChars = new TextureRegion[tmp.length * tmp[0].length];
        
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                fontChars[index++] = tmp[i][j];
            }
        }
        
        batch = new SpriteBatch();

        batch.getProjectionMatrix().setToOrtho2D(0f,0f,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        
        screenResize(960, 540);
	}
	
	public CharacterScreen getScreen()
	{
		return screen;
	}
	
	public void render()
	{
		batch.begin();
		for(int i = 0; i < screen.getWidth(); i++)
		{
			for(int j = 0; j < screen.getHeight(); j++)
			{
				tmp = screen.getCharacter(i, j).getColor();
				tmp.a = screen.getCharacter(i, j).getOpacity();
				batch.setColor(tmp);
				batch.draw(fontChars[screen.getCharacter(i, j).getId()], i * fontWidth * scale, j * fontHeight * scale, fontWidth * scale, fontHeight * scale);
			}
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	
	
	public void screenResize(int width, int height)
	{
		batch = new SpriteBatch();
		
		scale = ((float)width / (float)screen.getWidth()) / (float)fontWidth;
		System.out.println("Scale:" + scale);
		if(scale * fontHeight > height)
		{
			scale = ((float)height / (float)screen.getHeight()) / (float)fontHeight;
			System.out.println("Scale:" + scale);
		}
	}
	
}
