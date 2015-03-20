package com.braain.entities;

import com.braain.level.LevelObject;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Door extends LevelObject {

  public Door(int x, int y, int test[], String type) {
    super(x, y,
      x + test[0], y + test[1],
      x + test[2], y + test[3],
      x + test[4], y + test[5],
      x + test[6], y + test[7],
      type);
  }

  public void update(int delta) throws SlickException {
  }

  public boolean collidedWith(LevelObject entity) {
    return true;
  }

  public void draw(Graphics g) {
    g.draw(getPoly());
  }
}
