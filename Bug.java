import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Maze game character "Bug" moves through the maze guided by the player's arrow keys.
 * This scenario utilizes the typical isKeyDown()/setLocation() strategy for controlling character motion,
 * but notice that within each conditional statement associated with the arrow keys, another conditional 
 * statement is embedded. This embedded conditional statement tests for a collision with (a) the wall and 
 * (b) the world edge.
 * 
 * @author (Brian Myers) 
 * @version (February 2010)
 */
public class Bug extends Actor
{       
    public Bug(){
        getImage().scale(30,30);
    }
    public void act() 
    {
        if (canMove())
        {
            tryMove();
        }
        
    }   

    /**  
     * Returns true if the Bug is within the World's borders
     */

    public boolean canMove()

    {

        if (getX() > 0)
        {
            return true; 
        }

        else if (getY() > 0)
        {
            return true; 
        }

        else if (getX() < 500)
        {
            return true; 
        }

        else if (getY() < 500)
        {
            return true; 
        }

        else

            return false;

    }

    /**
     * Move, after verifying that we are not moving outside the world boundary and a 
     * directional key was pressed
     */
    public void tryMove()
    {
        if (Greenfoot.isKeyDown("up")) //Move UP one "square"
        {
            setLocation(getX(), getY() - 5);
            setRotation(270);
            Actor aWallCell = getOneIntersectingObject(Wall.class) ;
            if (aWallCell != null)
                setLocation (getX() , getY() + 5 ) ;
        }
        else if (Greenfoot.isKeyDown("down")) //Move DOWN one "square"
        {
            setLocation(getX(), getY() + 5);
            setRotation(90);
            Actor aWallCell = getOneIntersectingObject(Wall.class) ;
            if (aWallCell != null)
                setLocation (getX() , getY() - 5 ) ;
        }
        if (Greenfoot.isKeyDown("right")) //Move UP one "square"
        {
            setLocation(getX() + 5, getY());
            setRotation(360);
            Actor aWallCell = getOneIntersectingObject(Wall.class) ;
            if (aWallCell != null)
                setLocation (getX()  - 5  , getY()) ;
        }
        else if (Greenfoot.isKeyDown("left")) //Move DOWN one "square"
        {
            setLocation(getX() - 5, getY());
            setRotation(180);
            Actor aWallCell = getOneIntersectingObject(Wall.class) ;
            if (aWallCell != null)
                setLocation (getX()  + 5 , getY()) ;
        }
        
        if (isTouching(Strawberry.class)){
            removeTouching(Strawberry.class);
            Greenfoot.setWorld( new Level2() );
        }
         if (isTouching(Grape.class)){
             removeTouching(Grape.class);
             Greenfoot.setWorld( new Level3() );
        }
         if (isTouching(Apple.class)){
            removeTouching(Apple.class);
             Greenfoot.setWorld( new Win() );
        }
    }


   


}
