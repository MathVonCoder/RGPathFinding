# RGPathFinding

This is a short libraray and demo code for a 2D pathfinding algorithm implementation.

it is a two step algorithm :
first a region growing starting from the starting point. A region growing is a recursive way of finding all the connected cell from a starting point (same algorithm used for filling a zone with a color in drawing software). I use a twist where each cell as a parent back relation-ship to stroe what cell it is originated from.

Then if the region connected to the starting point reach the end point. We do do have a path, else if the algorithm stop without including the end point, it is a proof that there is no path from start to end.

The second pass, is simply going from the end, and using the parent relationship going back to the starting point. This list of cell is our path.

running :
just launch the main.class, 
you will hava a random board with obstacle draw
then the path (if any) from bottom left  to upper right.

Note : you can allow diagonal move by changing 
`pf.diagonalModeAllowed = false;` to `true`
```
'C:\dev\JDK\jdk-11.0.9.101-hotspot\bin\java.exe'  '-Dfile.encoding=UTF-8' '-cp' 'C:\dev\github\RGPathFinding\target\classes' 'com.adelya.pathfinding.Main' 
+--------------------+
|XX   X   XXX    X   |
|                    |
|       X      X    X|
|X           X  X  X |
|          X X       |
|X  X  X   X         |
|   XXX    XX      X |
|     X      XX XXXX |
|          X     X   |
|X X X X XX      XX  |
|   X    XX X X  XX  |
|X   X    X   X      |
| X          X       |
| X      X    X X    |
| X               X  |
|XXX       XX X  X X |
|X X     X       X   |
|      XX X   XX  X X|
| X X         X   XX |
| X   X X X          |
+--------------------+

+--------------------+
|XX   X   XXX    X  .|
|                  ..|
|       X      X  ..X|
|X           X  X .X |
|          X X    .  |
|X  X  X   X      .  |
|   XXX    XX  ....X |
|     X      XX.XXXX |
|          X   . X   |
|X X X X XX    . XX  |
|   X    XX X X. XX  |
|X   X    X   X.     |
| X          X .     |
| X      X    X.X    |
| X       ......  X  |
|XXX    ...XX X  X X |
|X X  ...X       X   |
|......XX X   XX  X X|
|.X X         X   XX |
|.X   X X X          |
+--------------------+
```
