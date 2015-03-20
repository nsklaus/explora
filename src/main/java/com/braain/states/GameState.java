package com.braain.states;

import com.braain.entities.Player;
import com.braain.level.BlockMap;
import com.braain.level.LevelObject;
import com.braain.metroid.Keyboard;
import com.braain.metroid.Weasel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {

  public static final int ID = 2;

  public int getID() {
    return ID;
  }

  public void init(GameContainer container, StateBasedGame game) throws SlickException {
    container.setVSync(true);
    BlockMap.getInstance().newMap("data/level/level0001.tmx");
    container.setShowFPS(true);
  }

  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    Keyboard.pollKeyboard(container);
    Player.getInstance().update(delta);
    BlockMap.getInstance().update(delta);
  }

  public void render(GameContainer container, StateBasedGame game, Graphics g) {
    BlockMap.getInstance().drawScenery(g);
    BlockMap.getInstance().drawBackgound(g);
    if (!Weasel.isDebug())
      Player.getInstance().draw(g);
    BlockMap.getInstance().drawForeground(g);

    if (Weasel.isDebug()) {
      for (LevelObject entity : BlockMap.getEntities()) {
        g.translate(BlockMap.getMapX(), BlockMap.getMapY());
        entity.draw(g);
        g.resetTransform();
      }
      Player.getInstance().draw(g);
    }
  }
}
