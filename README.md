#explora

game similar to metroid series.
made in java, uses tiled and slick2d.
its status is techdemo, abandonned.

features so far:
- free exploration
- automap
- collisions
- dynamic level creation
- tile engine
- inventory management
- shield, health, energy, munition management
- ennemies
- doors, elevators, switches
- wall jump
- speed run
- animated intro
- options screen

<img src=https://github.com/nsklaus/explora/blob/master/data/screenshots/sw1.png?raw=true width=120> 
<img src=https://github.com/nsklaus/explora/blob/master/data/screenshots/sw2.png?raw=true width=120> 
<img src=https://github.com/nsklaus/explora/blob/master/data/screenshots/sw3.png?raw=true width=120> 
<img src=https://github.com/nsklaus/explora/blob/master/data/screenshots/sw4.png?raw=true width=120> 
<img src=https://github.com/nsklaus/explora/blob/master/data/screenshots/sw5.png?raw=true width=120> 
<img src=https://github.com/nsklaus/explora/blob/master/data/screenshots/sw6.png?raw=true width=120> 


run from webstart, or from CLI:  
java -Djava.library.path=/path/lwjgl-2.1.0/ \
-cp .:/path/lwjgl-2.1.0/lwjgl.jar:/path/slick/lib/slick.jar:\ 
/path/slick/lib/jorbis-0.0.15.jar:\
/path/slick/lib/jogg-0.0.7.jar:weasel.jar org.Weasel

if you don't have 3d drivers, add this: 
-Dorg.lwjgl.opengl.Display.allowSoftwareOpenGL=true


