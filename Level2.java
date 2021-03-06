import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{

    private String maze1=
        "WWOWWOWWWOOOOOW"+
        "WHOOOOOWWOWWWOW"+
        "WWOWWOWWWOOWWOW"+
        "WWWWWOOOOOWWWOW"+
        "WOOOWWWOWOOWWWW"+
        "WOWOOOWWWWOWWWW"+
        "WOWWWOOOOOOOOWW"+
        "WOWOOOWWWWWWOWW"+
        "WOWWOWWOWWWWOWW"+
        "WOWWOWWOOOOOOWW"+
        "OOWWOWWWWOOWWWW"+
        "OWWOOOOWWWOOOOO"+
        "OWOOWWOWWWWOWWW"+
        "OWWWWOOWWWWOWWW"+
        "OWWOOOWWOOOOOWW";
    public Level2()
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
        Grape grape = new Grape();
        addObject(grape, 148, 587);
        grape.setLocation(142, 583);
    }
}
