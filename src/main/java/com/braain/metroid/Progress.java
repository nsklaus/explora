package com.braain.metroid;

public class Progress {

  public static String version = "v0.70";
  public static boolean showIntro;
  public static boolean initial;
  public static boolean ingame;
  public static boolean sndModified;
  public static boolean musModified;
  public static float musicVol = 20;
  public static float sfxVol = 20;
  public static String areaName;
  public static String bgm;
  public static boolean musicCtrl;
  public static boolean gameOver;
  public static int shields;
  public static float health;
  public static int energy;
  public static float strength;

  public static String setMusic() {
    bgm = "data/music/Intrigue.ogg";
    return bgm;
  }
}
