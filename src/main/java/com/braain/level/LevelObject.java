package com.braain.level;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;

// ====================================
// a generic class for all game objects
// ====================================
public abstract class LevelObject {

  private float x;
  private float y;
  private String type;
  private Polygon poly;
  private String lastDirection;

  //public static boolean debugMode = false;

  public LevelObject(
    float x, float y,
    float topLeftX, float topLeftY,
    float topRightX, float topRightY,
    float downRightX, float downRightY,
    float downLeftX, float downLeftY,
    String type) {

    this.x = x;
    this.y = y;
    this.type = type;

    poly = new Polygon(new float[]{
      topLeftX, topLeftY,
      topRightX, topRightY,
      downRightX, downRightY,
      downLeftX, downLeftY
    });
    
      
    
    poly.setX(x);
    poly.setY(y);
    
//    if (type.equals("slopeUp1")||(type.equals("slopeUp2"))){
//      System.out.println(""
//        + "-----------------------\n"
//        + "type=["+type+"]\n"
//        + "pixelX=["+x+"]         pixelY=["+y+"]\n"
//        + "tileX=["+(x/16)+"]           tileY=["+(y/16)+"]\n"
//        + "topLeftX=["+topLeftX+"]      topLeftY=["+topLeftY+"]\n"
//        + "topRightX=["+topRightX+"]    topRightY=["+topRightY+"]\n"
//        + "downRightX=["+downRightX+"]  downRightY=["+downRightY+"]\n"
//        + "downLeftX=["+downLeftX+"]    downLeftY=["+downLeftY+"]\n"
//        + "-----------------------\n");
//    }
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public void setX(float x) {
    this.x = x;
  }

  public void setY(float y) {
    this.y = y;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Polygon getPoly() {
    return poly;
  }

  public String getLastDirection() {
    return lastDirection;
  }

  public void setLastDirection(String lastDirection) {
    this.lastDirection = lastDirection;
  }

  public abstract void update(int delta) throws SlickException;

  public abstract void draw(Graphics g);

  public boolean isCollisionWith(LevelObject other) throws SlickException {
    return poly.intersects(this.poly);
  }
}
