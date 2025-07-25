# CCDSTRU_MP
Final output for CCDSTRU of SY 24-25

Uploaded for archival purposes

How to run:
  1. Run cmd in the MP folder
  2. Type javac DSTRU.java to compile the program
  3. Type java DSTRU to run the program
  4. Win

Rules of the game:
  1. The game will be played by 3 players: Tres, Uno, Dos in their respective order
  2. Tres and Uno must claim an unclaimed tile and form a certain pattern
  3. Dos must erase any occupied tiles by Tres or Uno
  4. If Tres or Uno completed a formation, Tres or Uno will win.
  5. If there are no more occupied tiles and there were no formations made, Dos will win.

Winning Formations (look for coordinates enclosed with brackets):

Subset 1
```
{
    [1,1], [1,2], [1,3], [1,4],
    (2,1), (2,2), (2,3), (2,4),
    (3,1), (3,2), (3,3), (3,4),
    (4,1), (4,2), (4,3), (4,4)
}
```

Subset2
```
{
    (1,1), (1,2), (1,3), [1,4],
    (2,1), (2,2), [2,3], (2,4),
    (3,1), [3,2], (3,3), (3,4),
    [4,1], (4,2), (4,3), (4,4)
}
```

Subset3
```
{
    (1,1), (1,2), (1,3), (1,4),
    (2,1), (2,2), (2,3), (2,4),
    (3,1), (3,2), (3,3), (3,4),
    [4,1], [4,2], [4,3], [4,4]
}
```
