package mrmathami.thegame.entity;

/**
 * A game entity
 */
public interface GameEntity {
    /**
     * @return field pos x
     */
    abstract double getX();

    /**
     * @return field pos y
     */
    abstract double getY();

    /**
     * @return field width
     */
    abstract double getWidth();

    /**
     * @return field height
     */
    abstract double getHeight();

}
