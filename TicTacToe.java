/*
A PROGRAM TO DEMONSTRATE THE HOUSEHOLD GAME “TICTACTOE”.

Copyrights reserved to developers.
For more details : README.txt
*/

import java.io.*;
class Developer
{
    void names()throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\n\n");
        System.out.println("\t<<<<<<<<<<<< T I C  T A C  T O E >>>>>>>>>>>>");
        System.out.println("\n\n\t\tDEVELOPERS : \n");
        System.out.println("\t\t\tANURAAG BISWAS");
        System.out.println("\t\t\tANUPAM GHOSH");
        System.out.println("\t\t\tSOUMYADEEP GHOSH\n");
        System.out.println(". . . . P R E S S  E N T E R  T O  C O N T I N U E . . . .");
        String enter=in.readLine();
        System.out.println("\f");
    }
}
class Game
{
    protected char[][] board,display;
    protected int column,row;
    void newGame()
    {
        board=new char[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=' ';
            }
        }
        display=new char[5][10];
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<10;j++)
            {
                display[i][j]=' ';
            }
        }
        newBoard();
    }
    boolean input(int r,int c,char ch)
    {
        int row=r-1;
        int col=c-1;
        if(row<3 && col<3 && board[row][col]==' ')
            board[row][col]=ch;
        else
        {
            System.out.println("Invalid Move");
            return true;
        }
        return false;
    }
    void generateMove(char ch)
    {
        if(winLose())
        {
            if(nextMoveWin(ch))
                blockOrWin(ch);
        }
        else
        {
            int x=0,y=0;
            do
            {
                x=(int)(Math.random()*10);
                y=(int)(Math.random()*10);
            }while(x>2||y>2||board[x][y]!=' ');
            board[x][y]=ch;
        }
    }
    void makeDisplay()
    {
        int a=0,b=0;
        for(int i=0;i<5;i=i+2)
        {
            for(int j=1;j<10;j=j+4)
            {
                display[i][j]=board[a][b++];
            }
            a++;
            b=0;
        }
    }
    void printBoard()
    {
        makeDisplay();
        for(int i=0;i<5;i++)
        {
            System.out.print("\t\t\t\t");
            for(int j=0;j<10;j++)
            {
                System.out.print(display[i][j]);
            }
            System.out.print("\n");
        }
    }
    void newBoard()
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<10;j++)
            {
                if(i%2==1&&j%2==1)
                {
                    display[i][j]='-';
                }
                if(j==3||j==7)
                {
                    display[i][j]='|';
                }
            }
        }
    }
    boolean winLose()
    {
        if(rowCheck()||columnCheck()||diagonalCheck())
                {
                    return(true);
                }
        return false;
    }
    boolean rowCheck()
    {
        for(int i=0;i<3;i++)
        {
            char ar[]={board[i][0],board[i][1],board[i][2]};
            int c=0;
            for(int j=0;j<3;j++)
            {
                if(ar[j]==' ')
                {
                    c++;
                }
            }
            if(c==1)
            {
                if(ar[0]==ar[1]||ar[1]==ar[2]||ar[2]==ar[0])
                {
                    row=i;
                    return true;
                }
            }
        }
        return false;
    }
    int rowCheck(int r)
    {
        char ar[]={board[r][0],board[r][1],board[r][2]};
        if(ar[0]==ar[1])
            return 2;
        else if(ar[0]==ar[2])
            return 1;
        return 0;
    }
    boolean columnCheck()
    {
        for(int i=0;i<3;i++)
        {
            char ar[]={board[0][i],board[1][i],board[2][i]};
            int c=0;
            for(int j=0;j<3;j++)
            {
                if(ar[j]==' ')
                {
                    c++;
                }
            }
            if(c==1)
            {
                if(ar[0]==ar[1]||ar[1]==ar[2]||ar[2]==ar[0])
                {
                    column=i;
                    return true;
                }
            }
        }
        return false;
    }
    int columnCheck(int c)
    {
        char ar[]={board[0][c],board[1][c],board[2][c]};
        if(ar[0]==ar[1])
            return 2;
        else if(ar[0]==ar[2])
            return 1;
        return 0;
    }
    boolean diagonalCheck()
    {
        char ld[]={board[0][0],board[1][1],board[2][2]};
        char rd[]={board[0][2],board[1][1],board[2][0]};
        int c1=0,c2=0;
        for(int j=0;j<3;j++)
        {
            if(ld[j]==' ')
            {
               c1++;
            }
        }
        for(int j=0;j<3;j++)
        {
            if(rd[j]==' ')
            {
               c2++;
            }
        }
        if(c1==1)
        {
            if(ld[0]==ld[1]||ld[1]==ld[2]||ld[2]==ld[0])
                return true;
        }
        if(c2==1)
        {
            if(rd[0]==rd[1]||rd[1]==rd[2]||rd[2]==rd[0])
                return true;
        }
        return false;
    }
    int leftDiagCheck()
    {
        char ar[]={board[0][0],board[1][1],board[2][2]};
        if(ar[0]==ar[1] && ar[0]!=' ')
            return 2;
        if(ar[0]==ar[2] && ar[2]!=' ')
            return 1;
        if(ar[1]==ar[2] && ar[1]!=' ')
            return 0;
        return -1;
    }
    int rightDiagCheck()
    {
        char ar[]={board[0][2],board[1][1],board[2][0]};
        if(ar[0]==ar[1])
            return 2;
        if(ar[0]==ar[2])
            return 1;
        return 0;
    }
    boolean nextMoveWin(char ch)
    {
        int row_index,col_index;
        for(int i=0;i<3;i++)
        {
            if(rowCheck() && board[i][rowCheck(i)]==' ')
            {
                row_index=rowCheck(i);
                board[i][row_index]=ch;
                if(whoWin()==ch)
                    return false;
                else
                    board[i][row_index]=' ';
            }
            else if(columnCheck() && board[columnCheck(i)][i]==' ')
            {
                col_index=columnCheck(i);
                board[col_index][i]=ch;
                if(whoWin()==ch)
                    return false;
                else
                    board[col_index][i]=' ';
            }
            else if(diagonalCheck())
            {
                if(leftDiagCheck()!=-1 && board[i][i]==' ')
                {
                    board[i][i]=ch;
                    if(whoWin()==ch)
                        return false;
                    else
                        board[i][i]=' ';
                }
                else if(leftDiagCheck()==-1 && board[i][2-i]==' ')
                {
                    board[i][2-i]=ch;
                        if(whoWin()==ch)
                    return false;
                        else
                    board[i][2-i]=' ';
                }
            }
        }
        return true;
    }
    void blockOrWin(char ch)
    {
        if(rowCheck())
        {
            board[row][rowCheck(row)]=ch;
        }
        else if(columnCheck())
        {
            board[columnCheck(column)][column]=ch;
        }
        else if(diagonalCheck())
        {
            if(leftDiagCheck()!=-1)
            {
                board[leftDiagCheck()][leftDiagCheck()]=ch;
            }
            else
            {
                board[rightDiagCheck()][2-rightDiagCheck()]=ch;
            }
        }
    }
    char whoWin()
    {
        for(int i=0;i<3;i++)
        {
            if(board[i][0]==board[i][1]&&board[i][0]==board[i][2]&&board[i][0]!=' ')
                return board[i][0];
            if(board[0][i]==board[1][i]&&board[0][i]==board[2][i]&&board[0][i]!=' ')
                return board[0][i];
        }
        if(board[0][0]==board[1][1]&&board[0][0]==board[2][2]&&board[0][0]!=' ')
            return board[0][0];
        if(board[0][2]==board[1][1]&&board[0][2]==board[2][0]&&board[0][2]!=' ')
            return board[0][2];
        return 'C';
    }   
}
public class TicTacToe
{
    static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    static String player_name[]=new String[50];
    static int player_stat[][]=new int[50][2];
    static int pos=0;
    public static void main(String[]args)throws IOException
    {
        Developer name=new Developer();
        name.names();
        Game TTT=new Game();
        int ch1=0;
        System.out.println("\n\n\n\n");
        System.out.println("\t\t\4\4\4\4 ******* TIC TAC TOE ******* \4\4\4\4");
        System.out.println("\n\n");
        do
        {
            System.out.println("\n1. New Game");
            System.out.println("2. Exit\n");
            ch1=Integer.parseInt(in.readLine());
            switch(ch1)
            {
                case 1:
                int ch2=0;
                do
                {
                    System.out.println("\n1. Single Player: Player vs Computer");
                    System.out.println("2. Single Player: Computer vs Player");
                    System.out.println("3. Multiplayer");
                    System.out.println("4. End\n");
                    ch2=Integer.parseInt(in.readLine());
                    switch(ch2)
                    {
                        case 1:
                        checkPlayers();
                        TTT.newGame();
                        int a=-1,r1,c1;
                        do
                        {
                            a+=2;
                            do
                            {
                                TTT.printBoard();
                                System.out.println("Enter row");
                                r1=Integer.parseInt(in.readLine());
                                System.out.println("Enter column");
                                c1=Integer.parseInt(in.readLine());
                            }while(TTT.input(r1,c1,'X'));
                            if(TTT.whoWin()=='X')
                            {
                                TTT.printBoard();
                                System.out.println(player_name[pos]+" Wins!!! ");
                                player_stat[pos][0]=player_stat[pos][0]+1;
                                System.out.println("Wins: "+player_stat[pos][0]);
                                System.out.println("Losses: "+player_stat[pos][1]);
                                break;
                            }
                            if(a!=9)
                            TTT.generateMove('O');
                            if(TTT.whoWin()=='O')
                            {
                                TTT.printBoard();
                                System.out.println(player_name[pos]+" Loses!!!");
                                player_stat[pos][1]=player_stat[pos][1]+1;
                                System.out.println("Wins: "+player_stat[pos][0]);
                                System.out.println("Losses: "+player_stat[pos][1]);
                                break;
                            }
                            if(a==9)
                            {
                                TTT.printBoard();
                                System.out.println("Draw");
                            }
                        }while(a<9);
                        break;
                        case 2:
                        checkPlayers();
                        TTT.newGame();
                        int b=-1,r2,c2;
                        do
                        {
                            b+=2;
                            TTT.generateMove('O');
                            if(TTT.whoWin()=='O')
                            {
                                TTT.printBoard();
                                System.out.println(player_name[pos]+" Loses!!!");
                                player_stat[pos][1]=player_stat[pos][1]+1;
                                System.out.println("Wins: "+player_stat[pos][0]);
                                System.out.println("Losses: "+player_stat[pos][1]);
                                break;
                            }
                            if(b!=9)
                            {
                                do
                                {
                                    TTT.printBoard();
                                    System.out.println("Enter row");
                                    r2=Integer.parseInt(in.readLine());
                                    System.out.println("Enter column");
                                    c2=Integer.parseInt(in.readLine());
                                }while(TTT.input(r2,c2,'X'));
                                if(TTT.whoWin()=='X')
                                {
                                    TTT.printBoard();
                                    System.out.println(player_name[pos]+" Wins!!!");
                                    player_stat[pos][0]=player_stat[pos][0]+1;
                                    System.out.println("Wins: "+player_stat[pos][0]);
                                    System.out.println("Losses: "+player_stat[pos][1]);
                                    break;
                                }
                            }
                            if(b==9)
                            {
                                TTT.printBoard();
                                System.out.println("Draw");
                            }
                        }while(b<9);
                        break;
                        case 3:
                        checkPlayers();
                        int pos1=pos;
                        checkPlayers();
                        int pos2=pos;
                        TTT.newGame();
                        int d=-1,r3,c3,r4,c4;
                        do
                        {
                            d+=2;
                            do
                            {
                                TTT.printBoard();
                                System.out.println("Enter row");
                                r3=Integer.parseInt(in.readLine());
                                System.out.println("Enter column");
                                c3=Integer.parseInt(in.readLine());
                            }while(TTT.input(r3,c3,'X'));
                            if(TTT.whoWin()=='X')
                            {
                                TTT.printBoard();
                                System.out.println(player_name[pos1]+" Wins!!!");
                                player_stat[pos1][0]=player_stat[pos1][0]+1;
                                player_stat[pos2][1]=player_stat[pos2][1]+1;
                                System.out.println("Wins: "+player_stat[pos1][0]);
                                System.out.println("Losses: "+player_stat[pos1][1]);
                                break;
                            }
                            if(d!=9)
                            {
                                do
                                {
                                    TTT.printBoard();
                                    System.out.println("Enter row");
                                    r4=Integer.parseInt(in.readLine());
                                    System.out.println("Enter column");
                                    c4=Integer.parseInt(in.readLine());
                                }while(TTT.input(r4,c4,'O'));
                                if(TTT.whoWin()=='O')
                                {
                                    TTT.printBoard();
                                    System.out.println(player_name[pos2]+" Wins!!!");
                                    player_stat[pos2][0]=player_stat[pos2][0]+1;
                                    player_stat[pos1][1]=player_stat[pos1][1]+1;
                                    System.out.println("Wins: "+player_stat[pos2][0]);
                                    System.out.println("Losses: "+player_stat[pos2][0]);
                                    break;
                                }
                            }
                            if(d==9)
                            {
                                TTT.printBoard();
                                System.out.println("Draw");
                            }
                        }while(d<9);
                        break;
                        case 4:
                        System.out.println("End");
                        break;
                        default:
                        System.out.println("Wrong choice");
                    }
                }while(ch2!=4);
                case 2:
                System.out.println("End");
                break;
                default:System.out.println("Wrong Choice");
            }
        }while(ch1!=2);
    }
    private static void checkPlayers()throws IOException
    {
        System.out.println("Enter name");
        String name=in.readLine();
        if(search(name)==-1)
        {
            for(int i=0;i<50;i++)
                if(player_name[i]==null)
                {
                    pos=i;
                    break;
                }
        }
        else
        pos=search(name);
        player_name[pos]=name;
    }
    private static int search(String name)
    {
        for(int i=0;player_name[i]!=null;i++)
        if(player_name[i].equalsIgnoreCase(name))
        return i;
        return -1;
    }
}
