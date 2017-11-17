SnakesAndLadders example playToEnd

A simple board game in which players roll a die to move from the starting square to the end. A square may contain a snake (moves you back) or a ladder (moves you up). If youland on a square already occupied, you go back to the start. If you move past the end, you reverse direction the remaining number of moves.

See http://en.wikipedia.org/wiki/Snakes_and_ladders for the rules of the game

SnakesAndLadders has the following responsibilities:
- enable scripting of an initial configuration of squares and players
- keep track of the rules of the game
- keep track whose turn it is to play
- initiate a move
- play a game to the end
- report on moves and intermediate game states
- stop when the game is over

Typical usage (see the example):
- Instantiate a new SnakesAndLadders
- Add squares, snakes and ladders to build the game board 
- Join players
- Play single moves or PlayToEnd