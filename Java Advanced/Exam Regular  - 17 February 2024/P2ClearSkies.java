import java.util.Scanner;

public class P2ClearSkies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[][] airspace = new String[n][n];
        int startRow = 0;
        int startCol = 0;
        int enemyCount = 0;

        for (int row = 0; row < airspace.length; row++) {
            String[] currRow = scanner.nextLine().split("");
            for (int col = 0; col < currRow.length; col++) {
                airspace[row][col] = currRow[col];

                if ("J".equals(airspace[row][col])) {
                    startRow = row;
                    startCol = col;
                } else if ("E".equals(airspace[row][col])) {
                    enemyCount++;
                }
            }
        }

        int currRow = startRow;
        int currCol = startCol;
        int armour = 300;
        int canFight = 0;

        boolean isShotDown= false;
        while (!isShotDown){
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    airspace[currRow][currCol] = "-";
                    currRow--;
                    break;
                case "down":
                    airspace[currRow][currCol] = "-";
                    currRow++;
                    break;
                case "right":
                    airspace[currRow][currCol] = "-";
                    currCol++;
                    break;
                case "left":
                    airspace[currRow][currCol] = "-";
                    currCol--;
                    break;
            }

            if (isOutOfBounds(airspace, currRow, currCol)){
                break;
            }

            String jetPosition = airspace[currRow][currCol];
            airspace[currRow][currCol] = "J";

            if ("E".equals(jetPosition)) {
                enemyCount--;
                if (canFight + 1 == 3){
                    isShotDown = true;
                    System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n", currRow, currCol);
                } else if (enemyCount == 0) {
                    isShotDown = true;
                    System.out.println("Mission accomplished, you neutralized the aerial threat!");
                    break;
                }

                armour -= 100;
                canFight++;
            } else if ("R".equals(jetPosition)) {
                armour = 300;
                canFight = 0;
            }
        }

        print(airspace);
    }

    private static boolean isOutOfBounds(String[][] airspace, int currRow, int currCol) {
        return currRow < 0 || currRow >= airspace.length ||
                currCol < 0 || currCol >= airspace[currRow].length;
    }

    private static void print(String[][] airspace) {
        for (int row = 0; row < airspace.length; row++) {
            for (int col = 0; col < airspace[row].length; col++) {
                System.out.print(airspace[row][col]);
            }
            System.out.println();
        }
    }
}
