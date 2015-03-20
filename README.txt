
===================
General Infos  
===================

Current version: 0.70
last updated: 2009/08/10
Contact: anarchic.teapot@gmail.com


This game is made in Java, using Slick and LWJGL.
Development is done on linux, it's mostly untested 
on mac and windows. 
It's intended to be a 2d platformer with 
some rpg elements. Licence is GPL (Gnu Public Licence).
The copyrighted material (gfx,bgm and sfx) are all 
temporary. The plan is to use original resources later on.



====================
notes about the game
====================

Not really a metroid clone. i'm just picking ideas 
here and there. Nothing set in stone just yet but,
For example here's what i'd like to have:

* game is set in future, space
* character have an armor and weapons, both with upgrades
* platform game with rpg elements (collect items, 
  suit energy management, equip items, do quests)
* some levels (around a hundred rooms i think)
* multiples routes.. players are free to explore, use the 
  map and find their own way.
* probably no morphball.. 



==============
Project Status
==============

Right now, its just a bunch of rooms to test the engine. 
collision, gravity, enemy kill, and so on.. 
i can easily see it taking another 6months.
lots of levels need to be created, and atm, 
i'm still finishing some rough edges on the engine like:
gravity, optimizations etc...
version number scheme is, to get closer to a version 1.0 
"a fully functional release considered mostly bug free". 



============
requirements
============

* a java capable machine :)

optionaly:

* 3d acceleration
* internet connection 

see intructions below to start from CLI
and disable 3d accelerated rendering. 



======================================
 run project locally from command line
======================================

Go there: http://spaceweasel.googlecode.com/svn/wiki/
grab all *.jar files
then start the game like this:

java -Djava.library.path=/path/lwjgl-2.1.0/ \
-cp .:/path/lwjgl-2.1.0/lwjgl.jar:/path/slick/lib/slick.jar:\ 
/path/slick/lib/jorbis-0.0.15.jar:\
/path/slick/lib/jogg-0.0.7.jar:weasel.jar org.Weasel

for thoses without accelerated 3d drivers or hardware, add this: 
-Dorg.lwjgl.opengl.Display.allowSoftwareOpenGL=true



=========
Changelog
=========

2209/08/25 version 0.70
* better collision checks (no more "3 pixel floating above floor)
* walljumps :)
* some character animation fixes
* documented the code a bit more
* reduced amount of collision checks (blocks vs other entities) 


2009/08/10 version 0.67
* Info screen created (display this text)
* item initial implementation
* item can be collected 
* item are registered automagically in inventory



2009/08/02 version 0.60
* good looking map
* save /load game (wip)
* info screen



2009/07/29 version 0.57
* refactored player animation selecter
* added player shoot animation
* enemies got a bit smarter .. 
* enemies can shoot
* gameover state (allow to start a new game)
* player life decrease as he get shot at
* enemies have resistance (more than 1shot=kill)



2009/07/26 version 0.54
* 4 doors instead of 2 per map (allow multiple routes)
* automated room registration on map and amp show level shapes
* map switched from 16x16 to 8x8 grid (display wider area)


2009/07/23 version 0.52
* some timing problems on windows got fixed
* added map screen (registering rooms on the map is done manually)
* added option screen with sound level control
* added intro
* added some sfx and bgm


2009/06/20 version 0.4
* more things working..
* new collision system
* well you know.. other stuffs..


2008/11/19 version 0.3
    player can shoot
*   shoot gfx size is independent
    entities can have different gfx
    for their bullets
*   elevator switches 
    press return to activate switches
    and call elevator
*   player animation corrected
    still some stuffs left to do ..
*   new resolution: game is now 400x300
    better for immersion and need less gfx details
    on screens .. make it easier to create nice looking
    levels and apply backgrounds
*   new status panel
    to fit new resolution. appear now on top of screen
    if user press space key
*   new controls and title screens
    monospace font used (tnx hiero)
    look like terminal output
*   initial enemy resistance implemented
    some enemies will need to be shot few time before dying


2008/08/17
*   enemy now turn around, face player and shoot upon
    entering their detection zone.
*   if player is shoot, HP diminishes.
    if HP reach zero, game over happen.
*   bullet are  removed if they touch walls or player.
*   level loading (doors system) is back.
*   light engine reform:
    primitives (level's diagonal platform) will be reduced 
    to 12 instead of 20.


2008/08/9:
*	complete refactor of collision detection system
	less slowdowns: no longer check collision with 
	the whole world)..checks 1 tile all around entities
	(checks 9 tiles in all for an entities:
	3 left, 3 right, 3 up, and 3 down.
*	Added 1st enemy class: Marine.
	Marines are just walking around and stop when 
	detecting player few tiles ahead. 
	(next is to makes them fires at player)
*	Added a Status panel (press space key to make it appear)	
*	Added possibility to change camera focus: 
	focus on boss, Player can use vehicles, camera focus on ship.. 
	

2007/10/30:
*	elevator complete


2007/10/24:
*	complete new engine. better support for custom shaped tiles.


2007/10/20:
*	diagonals system working. system need to be ameliorated.
	idea:	update blocked method to eat few more axis.
	store axis in tiles. read them and use few tiles
	for all level contour collision.			



