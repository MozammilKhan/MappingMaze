import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    private String maze1=
        "WWWWWOWWWOWWOWW"+
        "WHW000WWW0W000W"+
        "W0W0W0W000W0W0W"+
        "W000W000W00WW0W"+
        "W0WWWWOOWW00W0W"+
        "W000O00W00W0W0W"+
        "WWWWOWWWW0W000W"+
        "W0000W0000W0W0W"+
        "WWW0WWWOW0W00WW"+
        "W00O0W00W00W0WW"+
        "WWWWOWW0WW0WWOW"+
        "W00000000W0000W"+
        "WWOWWWWWOWWWW0W"+
        "W000W000000W00W"+
        "WWWWWWWWWOWWWWW";
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        buildMaze(maze1);

        prepare();
    }

    public void buildMaze(String maze)
    {
        int x=20;
        int y=20;
        for(int p=0;p<maze.length();p++){
            if(maze.charAt(p)=='W'){
                addObject(new Wall(),x,y);
            }
            if(maze.charAt(p)=='H'){
                addObject(new Bug(),x,y);
            }

            x+=40;    //move one space to the right
            if(x>getWidth()){    //when at the right edge of the world, move to the next row
                y+=40;
                x=20;
            }
        } 
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Strawberry strawberry = new Strawberry();
        addObject(strawberry, 386, 581);
        strawberry.setLocation(380, 585);
    }
}
