/*
 * TCSS 305
 * 
 * An implementation of the classic game "Tetris".
 */

package edu.uw.tcss.model.wallkicks;

import edu.uw.tcss.model.Point;
import edu.uw.tcss.model.Rotation;
import edu.uw.tcss.model.TetrisPiece;

/**
 * Enumeration of Rotation types.
 * 
 * @author Alan Fowler
 * @version Spring 2014
 */
public final class WallKick {
    
    /**
     * The kick offsets for rotations of J, L, S, T, and Z pieces. 
     */
    private static final Point[][] JLSTZ_OFFSETS = {
        {Point.buildPoint(0, 0), Point.buildPoint(-1, 0), Point.buildPoint(-1, +1),
                Point.buildPoint(0, -2), Point.buildPoint(-1, -2)},  // NONE to QUARTER
        {Point.buildPoint(0, 0), Point.buildPoint(+1, 0), Point.buildPoint(+1, -1),
                Point.buildPoint(0, +2), Point.buildPoint(+1, +2) }, // QUARTER to NONE
        {Point.buildPoint(0, 0), Point.buildPoint(+1, 0), Point.buildPoint(+1, -1),
                Point.buildPoint(0, +2), Point.buildPoint(+1, +2) }, // QUARTER to HALF
        {Point.buildPoint(0, 0), Point.buildPoint(-1, 0), Point.buildPoint(-1, +1),
                Point.buildPoint(0, -2), Point.buildPoint(-1, -2) }, // HALF to QUARTER
        {Point.buildPoint(0, 0), Point.buildPoint(+1, 0), Point.buildPoint(+1, +1),
                Point.buildPoint(0, -2), Point.buildPoint(+1, -2) }, // HALF to THREEQUARTER
        {Point.buildPoint(0, 0), Point.buildPoint(-1, 0), Point.buildPoint(-1, -1),
                Point.buildPoint(0, +2), Point.buildPoint(-1, +2) }, // THREEQUARTER to HALF
        {Point.buildPoint(0, 0), Point.buildPoint(-1, 0), Point.buildPoint(-1, -1),
            Point.buildPoint(0, +2), Point.buildPoint(-1, +2) }, // THREEQUARTER to NONE
        {Point.buildPoint(0, 0), Point.buildPoint(+1, 0), Point.buildPoint(+1, +1),
            Point.buildPoint(0, -2), Point.buildPoint(+1, -2) }  // NONE to THREEQUARTER
    };
    
    /**
     * The kick offsets for rotations of I pieces.
     */
    private static final Point[][] I_OFFSETS = {
        {Point.buildPoint(0, 0), Point.buildPoint(-2, 0), Point.buildPoint(+1, 0),
                Point.buildPoint(-2, -1), Point.buildPoint(+1, +2)},  // NONE to QUARTER
        {Point.buildPoint(0, 0), Point.buildPoint(+2, 0), Point.buildPoint(-1, 0),
                Point.buildPoint(+2, +1), Point.buildPoint(-1, -2) }, // QUARTER to NONE
        {Point.buildPoint(0, 0), Point.buildPoint(-1, 0), Point.buildPoint(+2, 0),
                Point.buildPoint(-1, +2), Point.buildPoint(+2, -1) }, // QUARTER to HALF
        {Point.buildPoint(0, 0), Point.buildPoint(+1, 0), Point.buildPoint(-2, 0),
                Point.buildPoint(+1, -2) , Point.buildPoint(-2, +1) }, // HALF to QUARTER
        {Point.buildPoint(0, 0), Point.buildPoint(+2, 0), Point.buildPoint(-1, 0),
                Point.buildPoint(+2, +1), Point.buildPoint(-1, -2) }, // HALF to THREEQUARTER
        {Point.buildPoint(0, 0), Point.buildPoint(-2, 0), Point.buildPoint(+1, 0),
                Point.buildPoint(-2, -1), Point.buildPoint(+1, +2) }, // THREEQUARTER to HALF
        {Point.buildPoint(0, 0), Point.buildPoint(+1, 0), Point.buildPoint(-2, 0),
                Point.buildPoint(+1, -2), Point.buildPoint(-2, +1) }, // THREEQUARTER to NONE
        {Point.buildPoint(0, 0), Point.buildPoint(-1, 0), Point.buildPoint(+2, 0),
                Point.buildPoint(-1, +2), Point.buildPoint(+2, -1) }  // NONE to THREEQUARTER
    };
    
    /**
     * Private constructor to inhibit external instantiation.
     */
    private WallKick() {
        // do nothing
    }
    
    /**
     * Returns an array of Points representing the wall kick offsets
     * for the situation defined by the parameters.
     * 
     * @param thePiece the piece type being rotated
     * @param theOriginalRotation the rotational state before the rotation
     * @param theGoalRotation the desired rotational state
     * @return The wall kick offsets for these conditions
     */
    public static Point[] getWallKicks(final TetrisPiece thePiece,
                                   final Rotation theOriginalRotation,
                                   final Rotation theGoalRotation) {
        
        Point[] result = new Point[0];
        
        if (thePiece == TetrisPiece.I) {
            
            switch (theOriginalRotation) {
                case NONE:
                    if (theGoalRotation == Rotation.QUARTER) {
                        result = I_OFFSETS[0];
                    } else if (theGoalRotation == Rotation.THREEQUARTER) {
                        result = I_OFFSETS[7];
                    }
                    break;
                case QUARTER:
                    if (theGoalRotation == Rotation.HALF) {
                        result = I_OFFSETS[2];
                    } else if (theGoalRotation == Rotation.NONE) {
                        result = I_OFFSETS[1];
                    }
                    break;
                case HALF:
                    if (theGoalRotation == Rotation.THREEQUARTER) {
                        result = I_OFFSETS[4];
                    } else if (theGoalRotation == Rotation.QUARTER) {
                        result = I_OFFSETS[3];
                    }
                    break;
                case THREEQUARTER:
                    if (theGoalRotation == Rotation.NONE) {
                        result = I_OFFSETS[6];
                    } else if (theGoalRotation == Rotation.HALF) {
                        result = I_OFFSETS[5];
                    }
                    break;
                default:
                    // should never happen
                    break;
            }

        } else if (thePiece != TetrisPiece.O) {
            switch (theOriginalRotation) {
                case NONE:
                    if (theGoalRotation == Rotation.QUARTER) {
                        result = JLSTZ_OFFSETS[0];
                    } else if (theGoalRotation == Rotation.THREEQUARTER) {
                        result = JLSTZ_OFFSETS[7];
                    }
                    break;
                case QUARTER:
                    if (theGoalRotation == Rotation.HALF) {
                        result = JLSTZ_OFFSETS[2];
                    } else if (theGoalRotation == Rotation.NONE) {
                        result = JLSTZ_OFFSETS[1];
                    }
                    break;
                case HALF:
                    if (theGoalRotation == Rotation.THREEQUARTER) {
                        result = JLSTZ_OFFSETS[4];
                    } else if (theGoalRotation == Rotation.QUARTER) {
                        result = JLSTZ_OFFSETS[3];
                    }
                    break;
                case THREEQUARTER:
                    if (theGoalRotation == Rotation.NONE) {
                        result = JLSTZ_OFFSETS[6];
                    } else if (theGoalRotation == Rotation.HALF) {
                        result = JLSTZ_OFFSETS[5];
                    }
                    break;
                default:
                    // should never happen
                    break;
            }

        }
        
        return result;
    }

}
