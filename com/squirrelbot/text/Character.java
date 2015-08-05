package com.squirrelbot.text;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.graphics.Color;

public class Character implements TweenAccessor<Character> {
	
	private int id;
	private Color color;
	private float opacity;
	private int special;
	
	public Character(int id, Color color, float opacity)
	{
		setId(id);
		setColor(color);
		setOpacity(opacity);
		setSpecial(0);
	}
	
	public Character(int id, Color color)
	{
		this(id, color, 1);
	}
	
	public Character(int id)
	{
		this(id, Color.WHITE.cpy(), 1);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public float getOpacity() {
		return opacity;
	}
	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}
	public int getSpecial() {
		return special;
	}
	public void setSpecial(int special){
		this.special = special;
	}

    // The following lines define the different possible tween types.
    // It's up to you to define what you need :-)

    public static final int CHAR_ID = 1;
    public static final int COLOR_RGB = 2;
    public static final int OPACITY = 3;

    // TweenAccessor implementation

    @Override
    public int getValues(Character target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case CHAR_ID: 
            	returnValues[0] = target.getId(); 
            	return 1;
            case COLOR_RGB: 
            	returnValues[0] = target.getColor().r;
            	returnValues[1] = target.getColor().b; 
            	returnValues[2] = target.getColor().g;
            	return 3;
            case OPACITY:
                returnValues[0] = target.getOpacity();
                return 1;
            default: assert false; return -1;
        }
    }
    
    @Override
    public void setValues(Character target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case CHAR_ID: 
            	target.setId(Math.round(newValues[0])); 
            	break;
            case COLOR_RGB: 
            	target.getColor().set(newValues[0], newValues[1], newValues[2], 1);
            	break;
            case OPACITY:
                target.setOpacity(newValues[0]);
                break;
            default: assert false; break;
        }
    }

	
}
