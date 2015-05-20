package com.iyoumei.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
public class VerifyCodeBean{
	private Random random ; //产生随机数
	private int width;//生成图片的宽度
	private int height;//生成图片的高度
	private String VerifyCode = "";//验证码字符串
	public VerifyCodeBean(){
		this.width = 60;
		this.height = 20;
		random = new Random();
	}
	public int getHeight(){
		return height;
	}
	public void setHeight(int height)	{
		this.height = height;
	}
	public Random getRandom(){
		return random;
	}
	public void setRandom(Random random)	{
		this.random = random;
	}
	public String getVerifyCode(){
		return VerifyCode;
	}
	public void setVerifyCode(String verifyCode){
		VerifyCode = verifyCode;
	}
	public int getWidth(){
		return width;
	}
	public void setWidth(int width){
		this.width = width;
	}	
	private Color getRandomColor(int foregroundColor,int backgroundColor)	{
		if(foregroundColor > 255){
			foregroundColor = 255;
		}
		if(backgroundColor > 255){
			backgroundColor = 255;
		}
		int r = foregroundColor + random.nextInt(backgroundColor-foregroundColor);
		int g = foregroundColor + random.nextInt(backgroundColor-foregroundColor);
		int b = foregroundColor + random.nextInt(backgroundColor-foregroundColor);
		return new Color(r,g,b);
	}	
	public BufferedImage getCreateVerifyImage()	{
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		Graphics g = (Graphics)g2d;
		g.setColor(this.getRandomColor(180, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		
		g.setColor(Color.BLUE);
		g.drawRect(0,0,width-1,height-1);
		//画随机线
		g.setColor(this.getRandomColor(160,200));
		for(int i = 0 ; i < 150 ; i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x+x1, y+y1);
		}
		String[] str = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z","1","2","3","4","5","6","7","8","9" };
		for(int i = 0 ; i < 4 ; i++){
			String randomStr = str[random.nextInt(str.length-1)];
			//String randomStr = String.valueOf(random.nextInt(10));
			VerifyCode+=randomStr;				// 取随机产生的认证码(4位数字)
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			g.drawString(randomStr,13*i+6,16);
		}
		g.dispose(); 
		return image;
	}
}

