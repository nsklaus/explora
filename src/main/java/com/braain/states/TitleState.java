package com.braain.states;

import com.braain.metroid.Keyboard;
import java.util.ArrayList;
import com.braain.metroid.Progress;
import java.util.Arrays;
import java.util.List;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class TitleState extends BasicGameState {

  private List<String> menu;
  private String start, control, exit, load, save, resume, info;
  private final Keyboard keyb = Keyboard.getInstance();
  private int selected;
  private StateBasedGame game;
  private Image logo, titlebg, screen;
  public static final int ID = 0;
  private Font font;
  public static Music titleMusic;
  private Sound menuSelect;
  private int menuDelay = 100;
  private int menuTime = menuDelay;

  public int getID() {
    return ID;
  }

  public void init(GameContainer container, StateBasedGame game) throws SlickException {

    this.game = game;
    titlebg = new Image("data/image/titlebg.jpg");
    logo = new Image("data/image/sweaselLogo.png");
    font = new AngelCodeFont("data/font/weasel.fnt", "data/font/weasel.png");
    screen = new Image("data/image/ctrlScreen3.png");

    start = "Start Game";
    control = "Options";
    load = "Load n/a";
    save = "Save n/a";
    info = "Info";
    exit = "Exit";

    menu = Arrays.asList(start, control, load, save, info, exit);

    menuSelect = new Sound("data/sound/Click3.ogg");
    titleMusic = new Music(Progress.setMusic());
    titleMusic.loop();
  }

  public void update(GameContainer container, StateBasedGame game, int delta) {
    keyb.pollKeyboard(container);
    //System.out.println("menuTiming=[" + menuTiming + "]");
    if (keyb.isUp()) {
      prevMenu(delta);
    }
    if (keyb.isDown()) {
      nextMenu(delta);
    }
    if (keyb.isEnter()) {
      titleMusic.stop();
      game.enterState(GameState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    }
  }

  private void nextMenu(int delta) {
    if (selected < menu.size() - 1) {
      menuTime += delta;
      if (menuTime > menuDelay) {
        selected++;
        menuTime = 0;
      }
    }
  }

  private void prevMenu(int delta) {
    if (selected > 0) {
      menuTime += delta;
      if (menuTime > menuDelay) {
        selected--;
        menuTime = 0;
      }
    }
  }

  public void render(GameContainer container, StateBasedGame game, Graphics g) {
    g.drawImage(titlebg, 0, 0);
    g.drawImage(logo, 200 - (logo.getWidth() / 2), 60 - (logo.getHeight() / 2));
    g.drawImage(screen, 88, 100);
    g.setColor(Color.white);
    g.drawString(Progress.version, 420, 5);
    g.setFont(font);

    for (int i = 0; i < menu.size(); i++) {

      if (selected == i) {
        g.setColor(Color.white);
        menu.get(i);
        g.drawString("[ " + menu.get(i) + " ]", 110, 120 + i * 18);
      } else {
        g.setColor(Color.gray);
        menu.get(i);
        g.drawString("  " + menu.get(i), 110, 120 + i * 18);
      }
    }
  }
}
