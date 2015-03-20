package com.braain.level;

import org.newdawn.slick.Graphics;

public class Block extends LevelObject {

	public Block(float x, float y, int test[],String type) {
		super(x, y,
				x+test[0], y+test[1],
				x+test[2], y+test[3],
				x+test[4], y+test[5],
				x+test[6], y+test[7],
				type);
	}

	public void update(int delta){
	}

	public void draw(Graphics g) {
		g.draw(getPoly());
	}
  
//  public String toString(){
//    System.out.println("x="+this.x+", y=");
//	}
}