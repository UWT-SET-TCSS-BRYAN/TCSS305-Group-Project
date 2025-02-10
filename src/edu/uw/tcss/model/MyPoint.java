/*
 * TCSS 305
 * 
 * An implementation of the classic game "Tetris".
 */

package edu.uw.tcss.model;

import java.util.Objects;

/**
 * Represents a 2D Point with x and y coordinates.
 * Point objects are immutable.
 * (Compare to java.awt.Point which are mutable)
 * 
 * @author Alan Fowler
 * @version 1.2
 */
public final class MyPoint implements Point {

    /** The X coordinate. */
    private final int myX;

    /** The Y coordinate. */
    private final int myY;

    /**
     * Constructs a Point using the provided coordinates.
     * 
     * @param theX the X coordinate.
     * @param theY the Y coordinate.
     */
    public MyPoint(final int theX, final int theY) {
        super();
        myX = theX;
        myY = theY;
    }

    // Queries
    @Override
    public int x() {
        return myX;
    }

    @Override
    public int y() {
        return myY;
    }

    @Override
    public MyPoint transform(final int theX, final int theY) {
        return new MyPoint(myX + theX, myY + theY);
    }
    
    @Override
    public MyPoint transform(final Point thePoint) {
        return transform(thePoint.x(), thePoint.y());
    }

    // overridden methods of class Object

    @Override
    public boolean equals(final Object theOther) {
        boolean result = false;
        if (theOther == this) {
            result = true;
        } else if (theOther != null && theOther.getClass() == getClass()) {
            final MyPoint p = (MyPoint) theOther;
            result = myX == p.myX && myY == p.myY;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myX, myY);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", myX, myY);
    }
}
