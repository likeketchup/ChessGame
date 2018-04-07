# ChessGame
Q3 work
## Author
Wendy Tan
Fiona Liu
Toma Chen
Eason Lu
## Basic intro
* there are only two players in the game, one represents `white` side and the other represents `black` side.
* white side player cannot move black pieces, and vice versa.
* players cannot move their pieces out of the board, which width is 8, and length is 8.
* players cannot eat their own side pieces.
* the game ends only if one side king is eaten by the other side pieces.
* players cannot move the space.
* if the player does not follow the following rules, he/she need to move the pieces on more time. 
## Regular Movement
### Pawn
- Pawn can only move forward if there is no other pieces in the top left(right) corner.
- Pawn can move to the top inclined corner only one step if there have other side piece.
- It can move `one` or `two` step(s) in the first move.
- It can only move `one` step if it have already moved.
### Bishop
- The bishop can move `any number` of squares diagonally.
- it cannot leap over other pieces.
### King
- The king moves `one` square in any direction.
### Knight
- The knight moves to any of the closest squares that are not on the same rank, file, or diagonal, thus the move forms an "L"-shape: two squares vertically and one square horizontally, or two squares horizontally and one square vertically. The knight is the only piece that can leap over other pieces.
### Queen
- The queen combines the power of a rook and bishop and can move `any number` of squares along a rank, file, or diagonal, but cannot leap over other pieces.
### Rook
- The rook can move `any number` of squares along a rank or file, but cannot leap over other pieces. 
## Special Movement
### Castling
Castling consists of moving the king two squares along the first rank toward a rook (which is on the player's first rank) and then placing the rook on the last square that the king has just crossed. It need to follow some conditions:
1. Neither the king nor the rook have previously moved during the game.
2. There cannot be any pieces between the king and the rook.
### Promotion
When a pawn advances to the eighth rank, as a part of the move it is promoted and must be exchanged for the player's choice of queen, rook, bishop, or knight of the same color.
## Attention
- Follow all the instructions when player starts the game.
- After typing the information, like name and coordinate, click `return` on the key board.
- The coordinate need to be written like "A8" or "H4". The letter should be capitalize.
- If the player does not follow the rules, he/she needs to retype.
- If the king is eaten, the game id over.
## Rules we do not contain
1. En passant
2. Check( When a king is under immediate attack by one or two of the opponent's pieces, the system does not have the function to save the king.)
3. Players cannot surrender in the game.