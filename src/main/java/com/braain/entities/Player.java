package com.braain.entities;

import com.braain.level.BlockMap;
import com.braain.level.LevelObject;
import com.braain.metroid.Keyboard;
import com.braain.metroid.Weasel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;

public final class Player extends LevelObject {

  private static final float MOVE_SPEED = 0.1f;                       // player velocity
  private static final int size[] = { 0, 0, 48, 0, 48, 48, 0, 48 };   // player dimensions
  private static Player instance;
  private Animation playerGoingLeft;
  private Animation playerGoingRight;
  private Animation playerStandLookingLeft;
  private Animation playerStandLookingRight;
  private Animation playerDefault;
  private Animation playerJumpingLeft;
  private Animation playerJumpingRight;
  private Animation playerFallingLeft;
  private Animation playerFallingRight;
  private Animation playerShootingLeft;
  private Animation playerShootingRight;
  private Animation fallback;

  public static Player getInstance() {
    if (instance == null) {
      try {
        instance = new Player(440, 340, "Player");
      } catch (SlickException ex) {
        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return instance;
  }

  private Player(float x, float y, String type) throws SlickException  {

    super(x, y,
      size[0], size[1],
      size[2], size[3],
      size[4], size[5],
      size[6], size[7],
      type);
     
    createSprite();
  }
  
  private void createSprite() throws SlickException {
    SpriteSheet sheet = new SpriteSheet("data/anim/samus.png", 48, 48);
    
    playerGoingLeft = new Animation();
    for (int frame = 0; frame < 10; frame++) {
      playerGoingLeft.addFrame(sheet.getSprite(frame, 0), 180);
    }
    playerGoingRight = new Animation();
    for (int frame = 0; frame < 10; frame++) {
      playerGoingRight.addFrame(sheet.getSprite(frame, 1), 180);
    }
    playerStandLookingLeft = new Animation();
    for (int frame = 0; frame < 4; frame++) {
      playerStandLookingLeft.addFrame(sheet.getSprite(frame, 2), 180);
    }
    playerStandLookingRight = new Animation();
    for (int frame = 0; frame < 4; frame++) {
      playerStandLookingRight.addFrame(sheet.getSprite(frame, 3), 180);
    }
    playerJumpingRight = new Animation();
    for (int frame = 0; frame < 8; frame++) {
      playerJumpingRight.addFrame(sheet.getSprite(frame, 10), 180);
    }
    playerJumpingLeft = new Animation();
    for (int frame = 0; frame < 8; frame++) {
      playerJumpingLeft.addFrame(sheet.getSprite(frame, 9), 180);
    }
    playerFallingLeft = new Animation();
    for (int frame = 0; frame < 8; frame++) {
      playerFallingLeft.addFrame(sheet.getSprite(frame, 4), 250);
    }
    playerFallingRight = new Animation();
    for (int frame = 0; frame < 8; frame++) {
      playerFallingRight.addFrame(sheet.getSprite(frame, 5), 250);
    }
    playerShootingLeft = new Animation();
    for (int frame = 0; frame < 10; frame++) {
      playerShootingLeft.addFrame(sheet.getSprite(frame, 11), 180);
    }
    playerShootingRight = new Animation();
    for (int frame = 0; frame < 10; frame++) {
      playerShootingRight.addFrame(sheet.getSprite(frame, 12), 180);
    }
    playerDefault = new Animation();
    for (int frame = 0; frame < 2; frame++) {
      playerDefault.addFrame(sheet.getSprite(frame, 6), 180);
    }

    playerGoingLeft.setAutoUpdate(false);
    playerGoingRight.setAutoUpdate(false);
    playerJumpingLeft.setAutoUpdate(false);
    playerJumpingRight.setAutoUpdate(false);
    playerStandLookingLeft.setAutoUpdate(false);
    playerStandLookingRight.setAutoUpdate(false);
    playerFallingLeft.setAutoUpdate(false);
    playerFallingRight.setAutoUpdate(false);
    playerDefault.setAutoUpdate(false);
    playerShootingLeft.setAutoUpdate(false);
    playerShootingRight.setAutoUpdate(false);
    fallback = playerDefault;
  }

  public void update(int delta) throws SlickException {

    if (Keyboard.isLeft()) {
      fallback = playerGoingLeft;
      playerGoingLeft.update(delta);
      if (BlockMap.isMapLeftBorder() || BlockMap.isMapRightBorder()) {
        setX(getX() - MOVE_SPEED * delta);
        getPoly().setX(getX());
      }
    }
    
    if (Keyboard.isRight()) {
      fallback = playerGoingRight;
      playerGoingRight.update(delta);
      if (BlockMap.isMapLeftBorder() || BlockMap.isMapRightBorder()) {
        setX(getX() + MOVE_SPEED * delta);
        getPoly().setX(getX());
      }
    }

    if (Keyboard.isUp()) {
      if (BlockMap.isMapTopBorder() || BlockMap.isMapBottomBorder()) {
        setY(getY() - MOVE_SPEED * delta);
        getPoly().setY(getY());
      }
    }

    if (Keyboard.isDown()) {
      if (BlockMap.isMapTopBorder() || BlockMap.isMapBottomBorder()) {
        setY(getY() + MOVE_SPEED * delta);
        getPoly().setY(getY());
      }
    }
  }

  public void draw(Graphics g) {
    g.setColor(Color.white);
    g.drawAnimation(fallback, getX(), getY());
    if (Weasel.isDebug())
      g.draw(getPoly());
  }

  public static float getMOVE_SPEED() {
    return MOVE_SPEED;
  }
}
