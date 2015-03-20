package com.braain.metroid;

import com.braain.entities.Player;
import com.braain.level.BlockMap;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Keyboard {

  private static Keyboard instance;
  private static boolean up;
  private static boolean down;
  private static boolean left; 
  private static boolean right; 
  private static boolean jump;
  private static boolean select;
  private static boolean shoot;
  private static boolean fscreen;
  private static boolean enter;
  private static boolean esc;
  private static int nu=0;

  public static void pollKeyboard(GameContainer container) throws SlickException {
    setEnter(container.getInput().isKeyDown(Input.KEY_RETURN));
    setUp(container.getInput().isKeyDown(Input.KEY_UP));
    setDown(container.getInput().isKeyDown(Input.KEY_DOWN));
    setLeft(container.getInput().isKeyDown(Input.KEY_LEFT));
    setRight(container.getInput().isKeyDown(Input.KEY_RIGHT));
    setSelect(container.getInput().isKeyDown(Input.KEY_LSHIFT));
    setJump(container.getInput().isKeyDown(Input.KEY_W));
    setShoot(container.getInput().isKeyDown(Input.KEY_X));
    setEsc(container.getInput().isKeyDown(Input.KEY_ESCAPE));
    
    if (Keyboard.isEsc()) {
      //System.exit(0);
      container.setFullscreen(!container.isFullscreen());
    }
    if (Keyboard.isShoot()) {
      Weasel.setDebug(!Weasel.isDebug());
      //nu +=1;
      //BlockMap.getInstance().newMap("data/level/level000"+nu+".tmx");
    }
    if (Keyboard.isJump()) {
      //Weasel.setDebug(!Weasel.isDebug());
      System.out.println("nu=["+nu+"]");
      nu +=1;
      BlockMap.getInstance().newMap("data/level/level000"+nu+".tmx");
    }
    
//    if (Keyboard.isSelect()) {
//      System.out.println("mapx=[" + BlockMap.getMapX() + "]"
//        + " mapY=[" + BlockMap.getMapY() + "]\n"
//        + " samX=[" + Player.getInstance().getX() + "]"
//        + " samY=[" + Player.getInstance().getY() + "]\n"
//        + " mapLeftBorder=[" + BlockMap.isMapLeftBorder() + "]"
//        + " mapRightBorder=[" + BlockMap.isMapRightBorder() + "]\n"
//        + " mapTopBorder=[" + BlockMap.isMapTopBorder() + "]"
//        + " mapBottomBorder=[" + BlockMap.isMapBottomBorder() + "]\n"
//        + " =====================");
//    }
  }

  public static Keyboard getInstance() {
    if (instance == null) {
      instance = new Keyboard();
    }
    return instance;
  }

  public static boolean isUp() {
    return up;
  }

  public static void setUp(boolean up) {
    Keyboard.up = up;
  }

  public static boolean isDown() {
    return down;
  }

  public static void setDown(boolean down) {
    Keyboard.down = down;
  }

  public static boolean isLeft() {
    return left;
  }

  public static void setLeft(boolean left) {
    Keyboard.left = left;
  }

  public static boolean isRight() {
    return right;
  }

  public static void setRight(boolean right) {
    Keyboard.right = right;
  }

  public static boolean isJump() {
    return jump;
  }

  public static void setJump(boolean jump) {
    Keyboard.jump = jump;
  }

  public static boolean isSelect() {
    return select;
  }

  public static void setSelect(boolean select) {
    Keyboard.select = select;
  }

  public static boolean isShoot() {
    return shoot;
  }

  public static void setShoot(boolean shoot) {
    Keyboard.shoot = shoot;
  }

  public static boolean isFscreen() {
    return fscreen;
  }

  public static void setFscreen(boolean fscreen) {
    Keyboard.fscreen = fscreen;
  }

  public static boolean isEnter() {
    return enter;
  }

  public static void setEnter(boolean enter) {
    Keyboard.enter = enter;
  }

  public static boolean isEsc() {
    return esc;
  }

  public static void setEsc(boolean esc) {
    Keyboard.esc = esc;
  }
}
