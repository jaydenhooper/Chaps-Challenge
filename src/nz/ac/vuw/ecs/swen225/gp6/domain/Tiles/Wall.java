package nz.ac.vuw.ecs.swen225.gp6.domain.Tiles;

import nz.ac.vuw.ecs.swen225.gp6.domain.Domain;
import nz.ac.vuw.ecs.swen225.gp6.domain.TileAnatomy.*;

/**
 * A class representing a wall, which hero and enemy actors cannot move on.
 */
public class Wall extends AbstractTile{
    /**
     * Create a wall
     * @param info tile information
     */
    public Wall (TileInfo info){super(info);}

    @Override public TileType type(){ return TileType.Wall;}
    
    @Override public boolean obstructsHero(Domain d) { return true;} //no one can move on wall
    @Override public boolean obstructsEnemy(Domain d) { return true;}
    
}
