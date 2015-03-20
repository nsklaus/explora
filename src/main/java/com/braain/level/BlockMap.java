package com.braain.level;

import com.braain.entities.Player;
import com.braain.metroid.Keyboard;
import com.braain.metroid.Weasel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import java.util.ArrayList;
import org.newdawn.slick.Graphics;

public class BlockMap {

  private static BlockMap instance;
  //private final Keyboard keyb = Keyboard.getInstance();
  //private final Player samus = Player.getInstance();
  //private final Weasel weasel = Weasel.getInstance();
  private final float mapSpeed = 0.1f;                           // map movement speed
  private int centerX, centerY;                                  // center of gameContainer
  private static ArrayList<LevelObject> entities;                       // register all block
  private static TiledMap tmap;                                         // tiled tmx map
  private static int mapWidth;                                          // map width in pixels
  private static int mapHeight;                                         // map height in pixels
  private static float mapX;                                            // map coord X
  private static float mapY;                                            // map coord Y  
  private static boolean mapLeftBorder;
  private static boolean mapTopBorder;
  private static boolean mapRightBorder;
  private static boolean mapBottomBorder;

  private final int dUp1[] = { 0, 16, 16, 8, 16, 16, 0, 16 };    // slope up1 
  //private final int dUp1[] = { 0, 8, 16, 0, 16, 16, 0, 16 };    // slope up1 
  private final int dUp2[] = { 0, 8, 16, 0, 16, 16, 0, 16 };     // slope up2
  private final int dDown1[] = { 0, 0, 16, 8, 16, 16, 0, 16 };   // slope down1 
  private final int dDown2[] = { 0, 8, 16, 16, 0, 16, 0, 8 };    // slope down2 
  private final int square[] = { 1, 1, 15, 1, 15, 15, 1, 15 };   // square tile
  private final int sDiag1[] = { 0, 0, 16, 0, 16, 8, 0, 0 };     // ceiling diag1 
  private final int sDiag2[] = { 0, 0, 16, 0, 16, 16, 0, 8 };    // ceiling diag2 
  private final int sDiag3[] = { 0, 0, 16, 0, 16, 8, 0, 16 };    // ceiling diag3 
  private final int sDiag4[] = { 0, 0, 16, 0, 0, 8, 0, 0 };      // ceiling diag4 

  //private BlockMap() { }
  public static BlockMap getInstance() {
    if (instance == null) {
      instance = new BlockMap();
    }
    return instance;
  }

  public void newMap(String ref) throws SlickException {
    tmap = null;
    mapWidth = 0;
    mapHeight = 0;
    centerX = 0;
    centerY = 0;
    entities = null;
    tmap = new TiledMap(ref, "data");
    mapWidth = tmap.getWidth() * tmap.getTileWidth();
    mapHeight = tmap.getHeight() * tmap.getTileHeight();
    centerX = (Weasel.getViewWidth() / 2) - 24;
    centerY = (Weasel.getViewHeight() / 2) - 24;
    entities = new ArrayList<LevelObject>();
    createObjects();
    initialMapPlacement();
  }

  /**
   * scan for tiles IDs, create polygons around tiles ( blocks, doors, elevators, buttons etc.. ) for collision check
   */
  private void createObjects() {
    for (int x = 0; x < tmap.getWidth(); x++) {
      for (int y = 0; y < tmap.getHeight(); y++) {
        int tileID = tmap.getTileId(x, y, 0);
//      int tileID2 = tmap.getTileId(x, y, 5);  /* entities layer */
//      if (tileID  == 1)  { entities.add(new Block(x * 16, y * 16, dUp1,   "slopeUp1")); }       
//      if (tileID  == 2)  { entities.add(new Block(x * 16, y * 16, dUp2,   "slopeUp2"));   }
//      if (tileID  == 3)  { entities.add(new Block(x * 16, y * 16, dDown1, "slopeDown1")); }
//      if (tileID  == 4)  { entities.add(new Block(x * 16, y * 16, dDown2, "slopeDown2")); }
//      if (tileID  == 7)  { entities.add(new Block(x * 16, y * 16, square, "square"));     }
//      if (tileID  == 17) { entities.add(new Block(x * 16, y * 16, sDiag1, "ceilling1"));  }
//      if (tileID  == 18) { entities.add(new Block(x * 16, y * 16, sDiag2, "ceilling2"));  }
//      if (tileID  == 19) { entities.add(new Block(x * 16, y * 16, sDiag3, "ceilling3"));  }
//      if (tileID  == 20) { entities.add(new Block(x * 16, y * 16, sDiag4, "ceilling4"));  }
//      if (tileID2 == 49) { /* create new player  */ }

        switch (tileID) {
          case 1:
            entities.add(new Block(x * 16, y * 16, dUp1, "slopeUp1"));
            break;
          case 2:
            entities.add(new Block(x * 16, y * 16, dUp2, "slopeUp2"));
            break;
          case 3:
            entities.add(new Block(x * 16, y * 16, dDown1, "slopeDown1"));
            break;
          case 4:
            entities.add(new Block(x * 16, y * 16, dDown2, "slopeDown2"));
            break;
          case 7:
            entities.add(new Block(x * 16, y * 16, square, "square"));
            break;
          case 17:
            entities.add(new Block(x * 16, y * 16, sDiag1, "ceilling1"));
            break;
          case 18:
            entities.add(new Block(x * 16, y * 16, sDiag2, "ceilling2"));
            break;
          case 19:
            entities.add(new Block(x * 16, y * 16, sDiag3, "ceilling3"));
            break;
          case 20:
            entities.add(new Block(x * 16, y * 16, sDiag4, "ceilling4"));
            break;
        }
      }
    }
  }

  /**
   * initial map placement based on hero coordinates
   */
  private void initialMapPlacement() {
    if (Player.getInstance().getX() > centerX) {
      mapX = -(mapWidth - Weasel.getViewWidth());
      setMapRightBorder(true);
    }
    if (Player.getInstance().getX() < centerX) {
      mapX = 0;
      setMapLeftBorder(true);
    }

    if (Player.getInstance().getY() < centerY) {
      mapY = 0;
      setMapTopBorder(true);
    }
    if (Player.getInstance().getY() > centerY) {
      mapY = -(mapHeight - Weasel.getViewHeight());
      setMapBottomBorder(true);
    }
  }

  public void update(int delta) throws SlickException {
    mapMovement(delta);
    mapBoundaries();
  }

  /**
   * only map moves until we reach a border. if we've reached a border only hero moves. see Player.update()
   *
   * @param delta
   */
  private void mapMovement(int delta) {

    // if hero reach the center of screen release lock on border
    if (Player.getInstance().getX() >= centerX && isMapLeftBorder()) {
      setMapLeftBorder(false);
      Player.getInstance().setX(centerX);
    }
    if (Player.getInstance().getX() <= centerX && isMapRightBorder()) {
      setMapRightBorder(false);
      Player.getInstance().setX(centerX);
    }
    if (Player.getInstance().getY() >= centerY && isMapTopBorder()) {
      setMapTopBorder(false);
      Player.getInstance().setY(centerY);
    }
    if (Player.getInstance().getY() <= centerY && isMapBottomBorder()) {
      setMapBottomBorder(false);
      Player.getInstance().setY(centerY);
    }

    // hero is in the center of screen, only map movement until we reach map borders
    if (Keyboard.isLeft() && !(isMapLeftBorder()) && (Player.getInstance().getX() == centerX)) {
      mapX += mapSpeed * delta;
    }
    if (Keyboard.isRight() && !(isMapRightBorder()) && (Player.getInstance().getX() == centerX)) {
      mapX -= mapSpeed * delta;
    }
    if (Keyboard.isUp() && !(isMapTopBorder()) && (Player.getInstance().getY() == centerY)) {
      mapY += mapSpeed * delta;
    }
    if (Keyboard.isDown() && !(isMapBottomBorder()) && (Player.getInstance().getY() == centerY)) {
      mapY -= mapSpeed * delta;
    }
  }

  /**
   * stop moving the map when we reach borders
   */
  private void mapBoundaries() {
    if (mapX >= 0) {
      mapX = 0;
      setMapLeftBorder(true);
    }
    if (mapX <= -(mapWidth - Weasel.getViewWidth())) {
      mapX = -(mapWidth - Weasel.getViewWidth());
      setMapRightBorder(true);
    }
    if (mapY >= 0) {
      mapY = 0;
      setMapTopBorder(true);
    }
    if (mapY <= -(mapHeight - Weasel.getViewHeight())) {
      mapY = -(mapHeight - Weasel.getViewHeight());
      setMapBottomBorder(true);
    }
  }

  public void drawScenery(Graphics g) {
    tmap.render(
      (int) mapX % 16,
      (int) mapY % 16,
      (int) (-mapX / 16),
      (int) (-mapY / 16),
      (Weasel.getViewWidth() / 16) + 2,
      (Weasel.getViewHeight() / 16) + 2,
      1, false);
  }

  public void drawBackgound(Graphics g) {
    tmap.render(
      (int) mapX % 16,
      (int) mapY % 16,
      (int) (-mapX / 16),
      (int) (-mapY / 16),
      (Weasel.getViewWidth() / 16) + 2,
      (Weasel.getViewHeight() / 16) + 2,
      2, false);
  }

  public void drawForeground(Graphics g) {
    tmap.render(
      (int) mapX % 16,
      (int) mapY % 16,
      (int) (-mapX / 16),
      (int) (-mapY / 16),
      (Weasel.getViewWidth() / 16) + 2,
      (Weasel.getViewHeight() / 16) + 2,
      3, false);
  }

  public static float getMapX() {
    return BlockMap.mapX;
  }

  public static float getMapY() {
    return BlockMap.mapY;
  }

//  public static void setMapX(float mapX) {
//    BlockMap.mapX = mapX;
//  }
//  public static void setMapY(float mapY) {
//    BlockMap.mapY = mapY;
//  }
//  public static int getMapWidth() {
//    return BlockMap.mapWidth;
//  }
//  public static int getMapHeight() {
//    return BlockMap.mapHeight;
//  }
//  public TiledMap getTmap() {
//    return BlockMap.tmap;
//  }
  public static ArrayList<LevelObject> getEntities() {
    return entities;
  }

  public static boolean isMapLeftBorder() {
    return mapLeftBorder;
  }

  public static boolean isMapTopBorder() {
    return mapTopBorder;
  }

  public static boolean isMapRightBorder() {
    return mapRightBorder;
  }

  public static boolean isMapBottomBorder() {
    return mapBottomBorder;
  }

  public static void setMapLeftBorder(boolean mapLeftBorder) {
    BlockMap.mapLeftBorder = mapLeftBorder;
  }

  public static void setMapTopBorder(boolean mapTopBorder) {
    BlockMap.mapTopBorder = mapTopBorder;
  }

  public static void setMapRightBorder(boolean mapRightBorder) {
    BlockMap.mapRightBorder = mapRightBorder;
  }

  public static void setMapBottomBorder(boolean mapBottomBorder) {
    BlockMap.mapBottomBorder = mapBottomBorder;
  }
}
