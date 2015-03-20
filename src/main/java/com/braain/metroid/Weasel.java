package com.braain.metroid;

import com.braain.states.TitleState;
import com.braain.states.GameState;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Weasel extends StateBasedGame {

  private final static boolean fullscreen = false;
  private static Weasel instance;
  private static boolean debug = true;
  private static int viewWidth;
  private static int viewHeight;

  private Weasel() {
    super("Space Weasel");
    setViewWidth(640);
    setViewHeight(480);
  }

  public void initStatesList(GameContainer container) throws SlickException {
    addState(new TitleState());
    addState(new GameState());
  }

  public static Weasel getInstance() {
    if (instance == null) {
      instance = new Weasel();
    }
    return instance;
  }

  public static boolean isDebug() {
    return debug;
  }

  public static void setDebug(boolean debug) {
    Weasel.debug = debug;
  }

  public static int getViewWidth() {
    return viewWidth;
  }

  public static int getViewHeight() {
    return viewHeight;
  }

  public static void setViewWidth(int viewWidth) {
    Weasel.viewWidth = viewWidth;
  }

  public static void setViewHeight(int viewHeight) {
    Weasel.viewHeight = viewHeight;
  }

  public static void main(String[] argv) {
    try {
      AppGameContainer container = new AppGameContainer(new Weasel());
      container.setDisplayMode(getViewWidth(), getViewHeight(), fullscreen);
      //container.setMouseGrabbed(true);
      container.start();
    } catch (SlickException e) {
      System.out.println("Zerror: " + e);
    }
  }
}
