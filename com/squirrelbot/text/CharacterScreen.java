package com.squirrelbot.text;

import com.badlogic.gdx.graphics.Color;
import com.squirrelbot.text.utils.Array2D;

public class CharacterScreen {

	Array2D<Character> characters;
	float scale;
	
	public CharacterScreen(int width, int height)
	{
		characters = new Array2D<Character>(width, height);
		characters.fill(new Character(0));
	}
	
	public Character getCharacter(int x, int y)
	{
		return characters.get(x, y);
	}
	
	public void setCharacter(int x, int y, Character character)
	{
		characters.set(x, y, character);
	}
	
	public void writeText(int x, int y, byte[] text, Color color)
	{
		for(int i = 0; i < text.length; i++)
		{
			if(x + i < getWidth())
			{
				setCharacter(x + i, y, new Character(text[i], color));
			}
		}
	}
	
	public int getWidth()
	{
		return characters.getWidth();
	}
	
	public int getHeight()
	{
		return characters.getHeight();
	}
	
}
