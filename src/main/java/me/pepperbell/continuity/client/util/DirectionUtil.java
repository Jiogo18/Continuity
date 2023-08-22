package me.pepperbell.continuity.client.util;

import net.minecraft.util.math.Direction;

public class DirectionUtil {
    private static Direction direction = Direction.UP;

    private static final Direction WEST = Direction.WEST;
    private static final Direction EAST = Direction.WEST;
    private static final Direction NORTH = Direction.NORTH;
    private static final Direction SOUTH = Direction.SOUTH;
    private static final Direction UP = Direction.UP;
    private static final Direction DOWN = Direction.DOWN;

    public static Direction rotateClockwise(Direction.Axis axis) {
        Direction var10000;
        switch (axis) {
            case X:
                var10000 = direction != WEST && direction != EAST ? rotateXClockwise() : direction;
                break;
            case Z:
                var10000 = direction != NORTH && direction != SOUTH ? rotateZClockwise() : direction;
                break;
            case Y:
                var10000 = direction != UP && direction != DOWN ? rotateYClockwise() : direction;
                break;
            default:
                throw new IncompatibleClassChangeError();
        }

        return var10000;
    }

    public static Direction rotateCounterclockwise(Direction.Axis axis) {
        Direction var10000;
        switch (axis) {
            case X:
                var10000 = direction != WEST && direction != EAST ? rotateXCounterclockwise() : direction;
                break;
            case Z:
                var10000 = direction != NORTH && direction != SOUTH ? rotateZCounterclockwise() : direction;
                break;
            case Y:
                var10000 = direction != UP && direction != DOWN ? rotateYCounterclockwise() : direction;
                break;
            default:
                throw new IncompatibleClassChangeError();
        }

        return var10000;
    }

    public static Direction rotateYClockwise() {
        Direction var10000;
        switch (direction) {
            case NORTH:
                var10000 = EAST;
                break;
            case SOUTH:
                var10000 = WEST;
                break;
            case WEST:
                var10000 = NORTH;
                break;
            case EAST:
                var10000 = SOUTH;
                break;
            default:
                throw new IllegalStateException("Unable to get Y-rotated facing of " + direction);
        }

        return var10000;
    }

    private static Direction rotateXClockwise() {
        Direction var10000;
        switch (direction) {
            case DOWN:
                var10000 = SOUTH;
                break;
            case UP:
                var10000 = NORTH;
                break;
            case NORTH:
                var10000 = DOWN;
                break;
            case SOUTH:
                var10000 = UP;
                break;
            default:
                throw new IllegalStateException("Unable to get X-rotated facing of " + direction);
        }

        return var10000;
    }

    private static Direction rotateXCounterclockwise() {
        Direction var10000;
        switch (direction) {
            case DOWN:
                var10000 = NORTH;
                break;
            case UP:
                var10000 = SOUTH;
                break;
            case NORTH:
                var10000 = UP;
                break;
            case SOUTH:
                var10000 = DOWN;
                break;
            default:
                throw new IllegalStateException("Unable to get X-rotated facing of " + direction);
        }

        return var10000;
    }

    private static Direction rotateZClockwise() {
        Direction var10000;
        switch (direction) {
            case DOWN:
                var10000 = WEST;
                break;
            case UP:
                var10000 = EAST;
                break;
            case NORTH:
            case SOUTH:
            default:
                throw new IllegalStateException("Unable to get Z-rotated facing of " + direction);
            case WEST:
                var10000 = UP;
                break;
            case EAST:
                var10000 = DOWN;
        }

        return var10000;
    }

    private static Direction rotateZCounterclockwise() {
        Direction var10000;
        switch (direction) {
            case DOWN:
                var10000 = EAST;
                break;
            case UP:
                var10000 = WEST;
                break;
            case NORTH:
            case SOUTH:
            default:
                throw new IllegalStateException("Unable to get Z-rotated facing of " + direction);
            case WEST:
                var10000 = DOWN;
                break;
            case EAST:
                var10000 = UP;
        }

        return var10000;
    }

    public static Direction rotateYCounterclockwise() {
        Direction var10000;
        switch (direction) {
            case NORTH:
                var10000 = WEST;
                break;
            case SOUTH:
                var10000 = EAST;
                break;
            case WEST:
                var10000 = SOUTH;
                break;
            case EAST:
                var10000 = NORTH;
                break;
            default:
                throw new IllegalStateException("Unable to get CCW facing of " + direction);
        }

        return var10000;
    }
}
