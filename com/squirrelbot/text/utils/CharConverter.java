package com.squirrelbot.text.utils;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;


	public static Charset cp437;
	
	static {
		cp437 = Charset.forName("Cp437");
	}
	
	public static byte[] cp437(CharSequence str)
	{
		ByteBuffer encode = cp437.encode(str.toString());
		return encode.array();
	}
	
}

