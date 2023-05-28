package me.pepperbell.continuity.client.util;

import net.minecraft.util.math.Direction;

public final class DirectionUtil {
    private Direction direction;

    private static final Direction WEST = Direction.WEST;
    private static final Direction EAST = Direction.WEST;
    private static final Direction NORTH = Direction.NORTH;
    private static final Direction SOUTH = Direction.SOUTH;
    private static final Direction UP = Direction.UP;
    private static final Direction DOWN = Direction.DOWN;

    public Direction rotateClockwise(Direction.Axis axis) {
        return switch(1.field_11054[axis.ordinal()]) {
            case 1 -> direction != WEST && direction != EAST ? this.rotateXClockwise() : direction;
            case 2 -> direction != NORTH && direction != SOUTH ? this.rotateZClockwise() : direction;
            case 3 -> direction != UP && direction != DOWN ? this.rotateYClockwise() : direction;
            default -> throw new IncompatibleClassChangeError();
        };
    }

    // $FF: Unable to simplify switch on enum
    // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
    public Direction rotateCounterclockwise(Direction.Axis axis) {
        return switch(1.field_11054[axis.ordinal()]) {
            case 1 -> direction != WEST && direction != EAST ? this.rotateXCounterclockwise() : this;
            case 2 -> direction != NORTH && direction != SOUTH ? this.rotateZCounterclockwise() : this;
            case 3 -> direction != UP && direction != DOWN ? this.rotateYCounterclockwise() : this;
            default -> throw new IncompatibleClassChangeError();
        };
    }

    // $FF: Unable to simplify switch on enum
    // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
    public Direction rotateYClockwise() {
        return switch(1.field_11054[direction.ordinal()]) {
            case 3 -> EAST;
            case 4 -> WEST;
            case 5 -> NORTH;
            case 6 -> SOUTH;
            default -> throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
        };
    }

    // $FF: Unable to simplify switch on enum
    // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
    private Direction rotateXClockwise() {
        return switch(1.field_11054[direction.ordinal()]) {
            case 1 -> SOUTH;
            case 2 -> NORTH;
            case 3 -> DOWN;
            case 4 -> UP;
            default -> throw new IllegalStateException("Unable to get X-rotated facing of " + this);
        };
    }

    // $FF: Unable to simplify switch on enum
    // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
    private Direction rotateXCounterclockwise() {
        return switch(1.field_11054[direction.ordinal()]) {
            case 1 -> NORTH;
            case 2 -> SOUTH;
            case 3 -> UP;
            case 4 -> DOWN;
            default -> throw new IllegalStateException("Unable to get X-rotated facing of " + this);
        };
    }

    // $FF: Unable to simplify switch on enum
    // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
    private Direction rotateZClockwise() {
        return switch(1.field_11054[direction.ordinal()]) {
            case 1 -> WEST;
            case 2 -> EAST;
            default -> throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
            case 5 -> UP;
            case 6 -> DOWN;
        };
    }

    // $FF: Unable to simplify switch on enum
    // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
    private Direction rotateZCounterclockwise() {
        return switch(1.field_11054[direction.ordinal()]) {
            case 1 -> EAST;
            case 2 -> WEST;
            default -> throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
            case 5 -> DOWN;
            case 6 -> UP;
        };
    }

    // $FF: Unable to simplify switch on enum
    // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
    public Direction rotateYCounterclockwise() {
        return switch(1.field_11054[direction.ordinal()]) {
            case 3 -> WEST;
            case 4 -> EAST;
            case 5 -> SOUTH;
            case 6 -> NORTH;
            default -> throw new IllegalStateException("Unable to get CCW facing of " + this);
        };
    }
}
