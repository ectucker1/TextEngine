package com.squirrelbot.text.utils;

public class Array2D<E> {

	E[] array;
	
	int width;
	int height;

	public Array2D(int width, int height)
	{
		this.width = width;
		this.height = height;
		array = (E[])new Object[width * height];
	}
	
	public E get(int x, int y)
	{
		return array[index(x, y)];
	}
	
	public void set(int x, int y, E object)
	{
		array[index(x, y)] = object;
	}
	
	public int index(int x, int y)
	{
		return x + width * y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void fill(E object)
	{
		for (int i = 0; i < array.length; i++) 
		{
			array[i] = object;
		}
	}
	
}

