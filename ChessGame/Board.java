public class Board
{
    // instance variables - replace the example below with your own
    static int count = 0;
    Piece[][] pieces = new Piece[8][8];
    private static final Board b = new Board();
    private Board(){
        this.pieces[0][0] = Rook.factory("B",0,0);
        this.pieces[0][1] = Knight.factory("B",0,1);
        this.pieces[0][2] = Bishop.factory("B",0,2);
        this.pieces[0][4] = King.factory("B",0,4);
        this.pieces[0][3] = Queen.factory("B",0,3);
        this.pieces[0][5] = Bishop.factory("B",0,5);
        this.pieces[0][6] = Knight.factory("B",0,6);
        this.pieces[0][7] = Rook.factory("B",0,7);
        for(int i=0;i<8;i++){
            pieces[1][i] = Pawn.factory("B",1,i);
        }
        for(int i=2;i<6;i++){
            for(int j = 0;j<8;j++){
                this.pieces[i][j] = new Space();
            }
        }
        for(int i = 0;i<8;i++){
            pieces[6][i] = Pawn.factory("W",6,i);
        }
        this.pieces[7][0] = Rook.factory("W",7,0);
        this.pieces[7][1] = Knight.factory("W",7,1);
        this.pieces[7][2] = Bishop.factory("W",7,2);
        this.pieces[7][4] = King.factory("W",7,4);
        this.pieces[7][3] = Queen.factory("W",7,3);
        this.pieces[7][5] = Bishop.factory("W",7,5);
        this.pieces[7][6] = Knight.factory("W",7,6);
        this.pieces[7][7] = Rook.factory("W",7,7);
    }
    
    public String toString(){
        return printBoard();
    }
    private String printBoard(){
        String board = "";
        for(int i = 0;i<8;i++){
            board = board+(i+1);
            for(int j = 0;j<8;j++){
                board = board+"  "+pieces[i][j];
            }
            board = board+"\n";
        }
        board = board+"   A    B    C    D    E    F    G    H";
        return board;
    }
    static public Board getBoard(){
        return b;
    }
    static public Board factory(){
        count++;
        if(count>1){
            throw new RuntimeException("you can only initialize one board");
        }  
        return b;
    }
    public boolean movePiece(int y1, int x1, int y2,int x2) {
        if (pieces[y1][x1] instanceof Space) {
            throw new RuntimeException("there is not have any piece in your appointed coordinate.");

        }//prevent player to move the space.
        if (pieces[y1][x1].color.equals(pieces[y2][x2].color)) {
            throw new RuntimeException("you cannot eat the piece in the same side!");

        }//prevent player eat the same color piece.
        if (pieces[y1][x1].move(y2, x2, this.pieces)) {
            if (pieces[y2][x2] instanceof King) return true;
            if ((pieces[y1][x1] instanceof King) && (Math.abs(x2 - x1) == 2)) {
                b.castling(y1, x1, y2, x2);
                return false;
            }
            pieces[y2][x2] = pieces[y1][x1];
            pieces[y1][x1] = new Space();
        }

        return false;
    }
    public void castling(int y1, int x1, int y2, int x2) {
        boolean kingLeft = x2 == x1 - 2;
        int max = 2;
        int count = 0;
        if (b.getPieceColor(y1, x1).equals("W")) {
            System.out.println("www");
        }
        int dirR = -1;
        int rookY = 7;
        int dirK = 1;
        if (kingLeft) {
            dirK = -1;
            dirR = 1;
            max = 3;
            rookY = 0;
        }

        for (int i = 1; i < max + 1; i++) {
            if (pieces[y1][4 + dirK * i] instanceof Space) {
                count++;
            }
        }

        if (count == max) {
            if (pieces[y1][rookY] instanceof Rook && pieces[y1][rookY].getHasMove()) {

                pieces[y2][x2] = pieces[y1][x1];
                pieces[y1][x1] = new Space();//king move
                pieces[y1][x1].move(y2,x1,this.pieces);

                pieces[y1][rookY+dirR*max]=pieces[y1][rookY];
                pieces[y1][rookY]=new Space();
                pieces[y1][rookY].move(y1,rookY+dirR*max,this.pieces);


            }
        }
    }
    public String getPieceColor ( int y, int x) {
        return pieces[y][x].color;
    }
    public Piece getPiece(int x,int y){
        return pieces[x][y];
    }
    public void changePiece(int y, int x, String pieceType, String color){
        String c = "B";
        if(color.equals("White")) c = "W";

        if (pieceType.equals("Bishop")) this.pieces[y][x] = Bishop.factory(c,x,y);
        if (pieceType.equals("Rook")) this.pieces[y][x] = Rook.factory(c,x,y);
        if (pieceType.equals("Queen")) this.pieces[y][x] = Queen.factory(c,x,y);
        if (pieceType.equals("Knight")) this.pieces[y][x] = Knight.factory(c,x,y);
    }

    }
