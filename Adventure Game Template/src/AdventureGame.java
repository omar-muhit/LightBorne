import java.util.ArrayList;
import java.util.Scanner;

public class AdventureGame {
    int lives = 3;
    int points = 0;
    ArrayList<String> inventory = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AdventureGame game = new AdventureGame();
        game.intro();
        new LevelOne(game).play();
        new LevelTwo(game).play();
        new LevelThree(game).play();
        new LevelFour(game).play();
        game.endGame();
    }
  public void intro() {
        System.out.println("Welcome to Code Quest!\n");
        System.out.println("You have 3 lives. Make good decisions to survive and earn points.\n");
        asciiWelcome();
        printStats();
    }

    public void endGame() {
        System.out.println("\nGame Over!");
        printStats();
        System.out.println("Inventory Collected: " + inventory);
        if (lives > 0) {
            System.out.println("Well done, adventurer!");
        } else {
            System.out.println("You have perished on your quest.");
        }
    }

    public void loadingAnimation(String message) {
        System.out.print(message);
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
                System.out.print(".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public void printStats() {
        System.out.println("Lives: " + lives + " | Points: " + points);
    }


    // ASCII Art Methods
public void asciiWelcome() {
    System.out.println(
            "************************************************************\n" +
            "*                                                          *\n" +
            "*   █████╗ ██████╗ ██╗   ██╗███████╗███╗   ██╗████████╗██╗   ██╗██████╗ ███████╗    *\n" +
            "*  ██╔══██╗██╔══██╗██║   ██║██╔════╝████╗  ██║╚══██╔══╝██║   ██║██╔══██╗██╔════╝    *\n" +
            "*  ███████║██║  ██║██║   ██║█████╗  ██╔██╗ ██║   ██║   ██║   ██║██████╔╝█████╗      *\n" +
            "*  ██╔══██║██║  ██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ██║   ██║██╔══██╗██╔══╝      *\n" +
            "*  ██║  ██║██████╔╝ ╚████╔╝ ███████╗██║ ╚████║   ██║   ╚██████╔╝██║  ██║███████╗    *\n" +
            "*  ╚═╝  ╚═╝╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝    *\n" +
            "*                                                                                    *\n" +
            "****************************************************************************"
    );
}
 public void asciiForest() {
    System.out.println(
            "****************************************************************************************\n" +
            "*                                                                                      *\n" +
            "*            ████                  ████         ███           ████      ████           *\n" +
            "*           ██████                ██████       █████         ██████    ██████          *\n" +
            "*          ████████              ████████     ███████       ████████  ████████         *\n" +
            "*         ██████████            ██████████   █████████     ██████████████████          *\n" +
            "*        ████████████          ████████████ ███████████   ████████████████             *\n" +
            "*       ██████████████        ██████████████████████████ ██████████████                *\n" +
            "*             ████                  ████         ████           ████                   *\n" +
            "*             ████                  ████         ████           ████                   *\n" +
            "*             ████                  ████         ████           ████                   *\n" +
            "*             ████                  ████         ████           ████                   *\n" +
            "*             ████                  ████         ████           ████                   *\n" +
            "*       ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓   *\n" +
            "*      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓   *\n" +
            "*                                                                                      *\n" +
            "****************************************************************************************"
    );
}
    public void asciiBridge() {
       System.out.println(
            "****************************************************************************************\n" +
            "*                                                                                      *\n" +
            "*                                                                                      *\n" +
            "*         ██████                                                      ██████           *\n" +
            "*        ████████                                                    ████████          *\n" +
            "*       ██████████                                                  ██████████         *\n" +
            "*      ████████████                                                ████████████        *\n" +
            "*     ██████████████                                              ██████████████       *\n" +
            "*    ████████████████                                            ████████████████      *\n" +
            "*   ██████████████████                                          ██████████████████     *\n" +
            "*  ████████████████████                                        ████████████████████    *\n" +
            "*  ████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████    *\n" +
            "*  ████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████    *\n" +
            "*  ████████          □         □         □         □         □         ████████████    *\n" +
            "*  ████████          |         |         |         |         |         ████████████    *\n" +
            "*  ▓▓▓▓▓▓▓▓          □         □         □         □         □         ▓▓▓▓▓▓▓▓▓▓▓▓    *\n" +
            "*  ▓▓▓▓▓▓▓▓                                                             ▓▓▓▓▓▓▓▓▓▓▓▓    *\n" +
            "*  ▓▓▓▓▓▓▓▓                                                             ▓▓▓▓▓▓▓▓▓▓▓▓    *\n" +
            "*  ▓▓▓▓▓▓▓▓▓▓▓▓    ▒▒▒▒    ▓▓▓▓▓▓▓▓▓▓▓▓    ▒▒▒▒    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓    *\n" +
            "*  ▓▓▓▓▓▓▓▓▓▓▓▓    ▒▒▒▒    ▓▓▓▓▓▓▓▓▓▓▓▓    ▒▒▒▒    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓    *\n" +
            "*                                                                                      *\n" +
            "****************************************************************************************"
    );
    }

    public void asciiDragon() {
      System.out.println(
    "************************************************************\n" +
    "*                                                          *\n" +
    "*                   ______________                         *\n" +
    "*        ,===:'.,            `-._                          *\n" +
    "*             `:.`---.__         `-._                      *\n" +
    "*               `:.     `--.         `.                    *\n" +
    "*                 \\.        `.         `.                  *\n" +
    "*         (,,(,    \\.         `.   ____,-`.,               *\n" +
    "*      (,'     `/   \\.   ,--.___`.'                        *\n" +
    "*  ,  ,'  ,--.  `,   \\.;'         `                        *\n" +
    "*   `{D, {    \\  :    \\;                                   *\n" +
    "*     V,,'    /  /    //                                   *\n" +
    "*     j;;    /  ,' ,-//.    ,---.      ,                   *\n" +
    "*     \\;'   /  ,' /  _  \\  /  _  \\   ,'/                 *\n" +
    "*           \\   `'  / \\  `'  / \\  `.' /                  *\n" +
    "*            `.___,'   `.__,'   `.__,'                    *\n" +
    "*                                                          *\n" +
    "************************************************************");
}}


class LevelOne extends AdventureGame {
    AdventureGame game;
    LevelOne(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("Level 1: The Mysterious Forest");
        game.asciiForest();
        System.out.println("You encounter a fork in the road. Left or right? (left/right)");
        String choice = game.scanner.nextLine();
        if (choice.equalsIgnoreCase("left")) {
            System.out.println("You found a hidden treasure! +10 points and a magic leaf");
            game.points += 10;
            game.inventory.add("Magic Leaf");
        } else {
            System.out.println("You fell into a trap. -1 life");
            game.lives--;
        }
    }
}


class LevelTwo extends AdventureGame {
    AdventureGame game;
    LevelTwo(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("\nLevel 2: The Bridge of Riddles");
        game.asciiBridge();
        System.out.println("Answer this riddle: What has keys but can't open locks?");
        String answer = game.scanner.nextLine();
        if (answer.toLowerCase().contains("piano")) {
            System.out.println("Correct! +10 points and you receive a gold coin");
            game.points += 10;
            game.inventory.add("Gold Coin");
        } else {
            System.out.println("Wrong! -1 life");
            game.lives--;
        }
    }
}

class LevelThree extends AdventureGame {
    AdventureGame game;
    LevelThree(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("\nLevel 3: The Dragon's Cave");
        game.asciiDragon();
        System.out.println("Do you fight the dragon or sneak past it? (fight/sneak)");
        String action = game.scanner.nextLine();
        if (action.equalsIgnoreCase("fight")) {
            game.loadingAnimation("Preparing for battle");
            System.out.println("Brave! You win and earn an extra life. +1 life, +20 points and a Dragon Scale");
            game.lives++;
            game.points += 20;
            game.inventory.add("Dragon Scale");
        } else {
            System.out.println("You sneak by safely but earn no reward.");
        }
    }
}

class LevelFour extends AdventureGame {
    AdventureGame game;
    LevelFour(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("\nLevel 4: The Cave of Chance");
        System.out.println("You enter a dark cave and find a mysterious chest...");
        int event = (int) (Math.random() * 3);
        switch (event) {
            case 0:
                System.out.println("A healing potion! +1 life and a Potion Bottle");
                game.lives++;
                game.inventory.add("Potion Bottle");
                break;
            case 1:
                System.out.println("It's a trap! -1 life");
                game.lives--;
                break;
            case 2:
                System.out.println("Treasure! +15 points and an Emerald Gem");
                game.points += 15;
                game.inventory.add("Emerald Gem");
                break;
        }
    }
}

class LevelFive extends AdventureGame {
    AdventureGame game;
    LevelFive(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("\nLevel 5: The Desert of Time");
        // Add ASCII art and gameplay mechanics here
        System.out.println("You encounter a vast desert. Do you follow the sun or the moon? (sun/moon)");
        String choice = game.scanner.nextLine();
        if (choice.equalsIgnoreCase("sun")) {
            System.out.println("You find an oasis! +10 points and a bottle of water");
            game.points += 10;
            game.inventory.add("Bottle of Water");
        } else {
            System.out.println("You wander into a sandstorm. -1 life");
            game.lives--;
        }
    }
}

class LevelSix extends AdventureGame {
    AdventureGame game;
    LevelSix(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("\nLevel 6: The Mountain Pass");
        // Add ASCII art and gameplay mechanics here
        System.out.println("A mountain pass lies ahead. Do you climb or take the long route? (climb/long)");
        String choice = game.scanner.nextLine();
        if (choice.equalsIgnoreCase("climb")) {
            System.out.println("You reach the peak and find a treasure chest! +15 points and a Ruby");
            game.points += 15;
            game.inventory.add("Ruby");
        } else {
            System.out.println("The long route takes time, but you avoid danger.");
        }
    }
}

class LevelSeven extends AdventureGame {
    AdventureGame game;
    LevelSeven(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("\nLevel 7: The Forgotten Temple");
        // Add ASCII art and gameplay mechanics here
        System.out.println("You enter an ancient temple. A puzzle lies before you. Solve it: What comes once in a minute, twice in a moment, but never in a thousand years?");
        String answer = game.scanner.nextLine();
        if (answer.toLowerCase().contains("m")) {
            System.out.println("Correct! +10 points and a Golden Key");
            game.points += 10;
            game.inventory.add("Golden Key");
        } else {
            System.out.println("Wrong answer! -1 life");
            game.lives--;
        }
    }
}

class LevelEight extends AdventureGame {
    AdventureGame game;
    LevelEight(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("\nLevel 8: The Enchanted Forest");
        // Add ASCII art and gameplay mechanics here
        System.out.println("You enter a magical forest. A fairy offers you a choice: A magical sword or a shield. Which one do you choose? (sword/shield)");
        String choice = game.scanner.nextLine();
        if (choice.equalsIgnoreCase("sword")) {
            System.out.println("You receive a glowing sword! +10 points and the sword");
            game.points += 10;
            game.inventory.add("Glowing Sword");
        } else {
            System.out.println("The shield will protect you later. No points but +1 life for safety.");
            game.lives++;
        }
    }
}

class LevelNine extends AdventureGame {
    AdventureGame game;
    LevelNine(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("\nLevel 9: The Labyrinth of Shadows");
        // Add ASCII art and gameplay mechanics here
        System.out.println("You enter a dark labyrinth. Do you go left or right? (left/right)");
        String choice = game.scanner.nextLine();
        if (choice.equalsIgnoreCase("left")) {
            System.out.println("You find the exit! +20 points and a map to the next level");
            game.points += 20;
            game.inventory.add("Map");
        } else {
            System.out.println("You walk in circles. -1 life");
            game.lives--;
        }
    }
}

class LevelTen extends AdventureGame {
    AdventureGame game;
    LevelTen(AdventureGame game) {
        this.game = game;
    }
    public void play() {
        System.out.println("\nLevel 10: The Final Battle");
        // Add ASCII art and gameplay mechanics here
        System.out.println("A fierce dragon awaits! Do you fight or flee? (fight/flee)");
        String action = game.scanner.nextLine();
        if (action.equalsIgnoreCase("fight")) {
            System.out.println("You defeat the dragon and win the game! +50 points and the Dragon's Crown");
            game.points += 50;
            game.inventory.add("Dragon's Crown");
        } else {
            System.out.println("You flee but lose points and a life.");
            game.points -= 10;
            game.lives--;
        }
    }
}

