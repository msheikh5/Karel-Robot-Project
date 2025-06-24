import stanford.karel.SuperKarel;



public class Homework extends SuperKarel {
    int counter;
    int width;
    int height;

    private void putBeepers() {
        if (noBeepersPresent())
            putBeeper();
    }

    private void moveAndCount() {
        if (frontIsClear()) {
            move();
            counter++;
        }
    }

    private void walkToTheEnd() {
        while (frontIsClear())
            moveAndCount();
        if (leftIsBlocked())
            turnRight();
        else
            turnLeft();
    }

    private void calculateWidthAndHeight() {
        turnLeft();
        while (frontIsClear()) {
            moveAndCount();
            height++;
        }
        turnRight();
        while (frontIsClear()) {
            moveAndCount();
            width++;
        }
    }

    private void oddMap(int widthOrHeight, boolean direction) {
        if (facingEast())
            turnAround();
        for (int i = 0; i < (widthOrHeight / 2) ; i++) {
            moveAndCount();
        }
        putBeeper();
        if (facingWest() || facingNorth())
            turnLeft();
        else
            turnRight();
        while (frontIsClear()) {
            moveAndCount();
            putBeepers();
        }
        if (direction)
            turnRight();
        else
            turnLeft();
        walkToTheEnd();
    }

    private void evenMap(int widthOrHeight, boolean direction) {
        if (facingEast())
            turnAround();
        for (int i = 0; i < (widthOrHeight / 2) - 1; i++) {
            moveAndCount();
        }
        turnLeft();
        int j = 0;
        while (frontIsClear()) {
            putBeepers();
            if (j % 2 == 0) {
                turnRight();
                moveAndCount();
                putBeepers();
                turnLeft();
                moveAndCount();
            } else {
                turnLeft();
                moveAndCount();
                putBeepers();
                turnRight();
                moveAndCount();
            }
            j++;
        }
        if (frontIsBlocked()) {
            putBeepers();
        }
        if (direction)
            turnRight();
        else
            turnLeft();
        moveAndCount();
        putBeepers();
        if (facingNorth() || facingWest())
            turnAround();
        walkToTheEnd();
    }

    private void specialCase(int large, int number, int small) {
        for (int i = 0; i < (large - number) % (number + 1) - 1; i++) {
            putBeepers();
            if (small == 2) {
                if (leftIsBlocked()) {
                    turnRight();
                    moveAndCount();
                    putBeepers();
                    turnLeft();
                } else {
                    turnLeft();
                    moveAndCount();
                    putBeepers();
                    turnRight();
                }
            }
            moveAndCount();
        }
        while (frontIsClear()) {
            int j;
            if (large <= 4)
                j = -1;
            for (j = 0; j < (large - number) / (number + 1); j++) {
                moveAndCount();
            }
            putBeepers();
            if (small == 2) {
                if (rightIsBlocked()) {
                    turnLeft();
                    moveAndCount();
                    putBeepers();
                    turnRight();
                } else {
                    turnRight();
                    moveAndCount();
                    putBeepers();
                    turnLeft();
                }
            }
            moveAndCount();
        }
        if (small == 2) {
            if (facingWest())
                turnLeft();
            else
                turnRight();
            moveAndCount();
        }
    }

    private void normalCase() {
        if (width % 2 == 0 && height % 2 == 0) {
            evenMap(width, false);
            evenMap(height, false);
        } else if (width % 2 != 0 && height % 2 != 0) {
            oddMap(width, false);
            oddMap(height, false);
        } else if (width % 2 == 0 && height % 2 != 0) {
            evenMap(width, true);
            oddMap(height, false);
        } else {
            oddMap(width, false);
            evenMap(height, true);
        }
    }

    private void determineStatus() {
        int small = Math.min(width, height);
        int large = Math.max(width, height);

        if (small == height)
            turnAround();
        else
            turnRight();
        if (small == 2 && large == 2) {
            putBeepers();
            moveAndCount();
            turnLeft();
            moveAndCount();
            putBeepers();
        } else {
            if (large >= 7)
                specialCase(large, 3, small);
            else if (large == 5 || large == 6)
                specialCase(large, 2, small);
            else if (large == 3 || large == 4)
                specialCase(large, 1, small);
            else
                moveAndCount();
        }
    }

    public void run() {
        setBeepersInBag(1000000);
        width = 1;
        height = 1;
        counter = 0;
        calculateWidthAndHeight();
        System.out.println("Width : " + width);
        System.out.println("Height : " + height);
        if (width > 2 && height > 2)
            normalCase();
        else
            determineStatus();
        System.out.println("Number of steps =" + counter);
    }
}
