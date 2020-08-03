package com.twu.refactoring;

public class Direction {
    private final char direction;
    private final char[] directionArray = {'N','E','S','W'};

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        for (int i = 0; i < directionArray.length; i++) {
            if (direction == directionArray[i]) {
                return new Direction(directionArray[(i+1)%4]);
            }
        }
        throw new IllegalArgumentException();
    }

    public Direction turnLeft() {
        for (int i = 0; i < directionArray.length; i++) {
            if (direction == directionArray[i]) {
                return new Direction(directionArray[(i+3)%4]);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
