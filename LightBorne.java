import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class LightBorne {
    // Game state variables
    private int lives;
    private int points;
    private int currentRealm;
    private ArrayList<String> artifacts;
    private boolean hasFlameRelic;
    private boolean hasTimeRelic;
    private Scanner scanner;
    private Random random;

    public LightBorne() {
        lives = 3;
        points = 0;
        currentRealm = 0;
        artifacts = new ArrayList<>();
        hasFlameRelic = false;
        hasTimeRelic = false;
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public static void main(String[] args) {
        LightBorne game = new LightBorne();
        game.startGame();
    }

    private void startGame() {
        displayTitleScreen();
        introNarration();
        
        // Main game loop through realms
        while (currentRealm < 6 && lives > 0) {
            switch (currentRealm) {
                case 0: whisperingWoods(); break;
                case 1: cavernOfEchoes(); break;
                case 2: bridgeOfTrials(); break;
                case 3: valeOfShadows(); break;
                case 4: crystalLabyrinth(); break;
                case 5: altarOfReckoning(); break;
            }
            currentRealm++;
        }
        
        // Final outcome
        if (lives > 0) {
            displayVictory();
        } else {
            displayDefeat();  // Corrected method name
        }
        scanner.close();
    }

    private void displayStatus() {
        System.out.println("\n----------------------------------");
        System.out.println("LIVES: " + lives + " | POINTS: " + points);
        System.out.println("ARTIFACTS: " + artifacts.size() + "/6");
        System.out.println("----------------------------------");
    }

    // ASCII Art and Narration Methods
    private void displayTitleScreen() {
        System.out.println();
        System.out.println("  _      _____ _    _ _______ ______  _____  ______  _____  ");
        System.out.println(" | |    |_   _| |  | |__   __|  ____|/ ____||  ____||  __ \\ ");
        System.out.println(" | |      | | | |__| |  | |  | |__  | (___  | |__   | |__) |");
        System.out.println(" | |      | | |  __  |  | |  |  __|  \\___ \\ |  __|  |  _  / ");
        System.out.println(" | |____ _| |_| |  | |  | |  | |____ ____) || |____ | | \\ \\ ");
        System.out.println(" |______|_____|_|  |_|  |_|  |______|_____/ |______||_|  \\_\\");
        System.out.println();
        System.out.println("        The Echo of Flame - A Morality-Based Quest");
        System.out.println("==============================================================");
        waitForEnter();
    }

    private void introNarration() {
        System.out.println();
        System.out.println("(Soft wind blows... crackling embers echo faintly)");
        System.out.println();
        System.out.println("Long ago, the kingdom of Elyndor gleamed like a crown beneath the stars.");
        System.out.println("But darkness crept in, seeded by greed and betrayal.");
        System.out.println("You awaken alone, carrying the last spark of light - the LightBorne.");
        System.out.println("The Flame still lives inside you...");
        System.out.println();
        System.out.println("         ,d");
        System.out.println("         88");
        System.out.println("       MM88MMM  ,adPPYba,");
        System.out.println("         88   a8\"     \"8a");
        System.out.println("         88   8b       d8");
        System.out.println("         88   \"8a,   ,a8\"");
        System.out.println("         88    `\"YbbdP\"'");
        System.out.println();
        waitForEnter();
    }

    // Realm Methods with ASCII Art, Choices, and Challenges
    private void whisperingWoods() {
        System.out.println();
        System.out.println("🌲 REALM 1: WHISPERING WOODS 🌲");
        System.out.println();
        System.out.println("          /\\");
        System.out.println("         /**\\");
        System.out.println("        /****\\   /\\");
        System.out.println("       /      \\ /**\\");
        System.out.println("      /  /\\    /    \\        A silent forest where trees");
        System.out.println("     /  /  \\  /      \\       remember lost names. Ancient");
        System.out.println("    /  /    \\/ /\\     \\      trunks form shadowed corridors.");
        System.out.println("   /  /      \\/  \\     \\");
        System.out.println("  /__/________\\___\\_____\\");
        System.out.println();
        
        // Moral dilemma
        System.out.println("A spectral figure appears before you:");
        System.out.println("\"Would you sacrifice your happiest memory to spare a stranger from their worst pain?\"");
        System.out.println("1. Yes, I would make that sacrifice");
        System.out.println("2. No, I would keep my memory");
        
        int choice = getChoice(2);
        if (choice == 1) {
            System.out.println("\nThe spirit nods: \"Your compassion shines bright.\"");
            artifacts.add("Amulet of Empathy");
            points += 30;
        } else {
            System.out.println("\nThe spirit fades: \"Self-preservation has its price.\"");
            lives--;
        }
        
        // Challenge
        System.out.println("\nA voice echoes from the trees:");
        System.out.println("\"I speak without a mouth and hear without ears. I have no body, but I come alive with wind.\"");
        System.out.println("What am I?");
        System.out.println("1. Fire  2. Water  3. Echo  4. Shadow");
        
        if (getChoice(4) == 3) {
            System.out.println("\nCorrect! The path clears before you.");
            points += 50;
            
            // Secret room
            System.out.println("\nYou found a hidden glade! (Quick thinking reward)");
            System.out.println("  (  )");
            System.out.println(" (    )");
            System.out.println("(      )");
            System.out.println("| FLAME|");
            System.out.println("| RELIC|");
            System.out.println(" \\    /");
            System.out.println("  \\__/");
            System.out.println("You gain the Flame Relic!");
            hasFlameRelic = true;
        } else {
            System.out.println("\nIncorrect! The forest grows darker.");
            lives--;
        }
        
        // Mini-boss
        System.out.println("\nA Forest Shade blocks your path! (Optional)");
        System.out.println("Fight or flee? (1. Fight 2. Flee)");
        if (getChoice(2) == 1) {
            if (hasFlameRelic) {
                System.out.println("\nFLAME RELIC ACTIVATED! The shade dissolves instantly.");
                points += 100;
            } else if (random.nextBoolean()) {
                System.out.println("\nVictory! You earn an extra life.");
                lives++;
                points += 50;
            } else {
                System.out.println("\nThe shade wounds you severely.");
                lives -= 2;
            }
        }
        
        displayStatus();
        waitForEnter();
    }

    private void cavernOfEchoes() {
        System.out.println();
        System.out.println("🕳️ REALM 2: CAVERN OF ECHOES 🕳️");
        System.out.println();
        System.out.println("      /\\");
        System.out.println("     /  \\");
        System.out.println("    / /\\ \\");
        System.out.println("   / /  \\ \\");
        System.out.println("  / /    \\ \\");
        System.out.println(" / / _____\\ \\");
        System.out.println("/_/ /`     \\_\\");
        System.out.println("    `.    .`");
        System.out.println("      `..`");
        System.out.println();
        System.out.println("A black void where whispers impersonate loved ones.");
        System.out.println("Phantom voices call from the darkness...");
        
        // Moral dilemma
        System.out.println("\nA familiar voice whispers:");
        System.out.println("\"Would you forgive the person who destroyed your family?\"");
        System.out.println("1. Yes, forgiveness brings peace");
        System.out.println("2. No, some things are unforgivable");
        
        int choice = getChoice(2);
        if (choice == 1) {
            System.out.println("\n\"Mercy tempers justice,\" the voice concedes.");
            artifacts.add("Chalice of Mercy");
            points += 30;
        } else {
            System.out.println("\n\"Vengeance consumes the vessel,\" the voice warns.");
            lives--;
        }
        
        // Challenge
        System.out.println("\nTwo paths diverge:");
        System.out.println("Left: A voice cries \"Help me!\"");
        System.out.println("Right: Complete silence");
        System.out.println("Which way do you go? (1. Left 2. Right)");
        
        if (getChoice(2) == 2) {
            System.out.println("\nWisdom prevails. Silence reveals the true path.");
            points += 50;
        } else {
            System.out.println("\nThe voice was a trap! You fall into a pit.");
            lives--;
        }
        
        displayStatus();
        waitForEnter();
    }

    private void bridgeOfTrials() {
        System.out.println();
        System.out.println("🌉 REALM 3: BRIDGE OF TRIALS 🌉");
        System.out.println();
        System.out.println("   _____________________________");
        System.out.println("  /_____________________________\\");
        System.out.println(" _|_____________________________|_");
        System.out.println("|_______________________________|");
        System.out.println("   _|_____|_____|_____|_____|_");
        System.out.println("  /_____/_____/_____/_____/___\\");
        System.out.println(" /_____________________________\\");
        System.out.println("|______________________________|");
        System.out.println();
        System.out.println("A bridge suspended by truth. Every lie weakens its structure.");
        
        // Moral dilemma
        System.out.println("\nThe Guardian asks:");
        System.out.println("\"Is betraying one innocent person justified to save many?\"");
        System.out.println("1. Yes, the greater good demands it");
        System.out.println("2. No, every life has equal value");
        
        int choice = getChoice(2);
        if (choice == 2) {
            System.out.println("\n\"Your integrity strengthens the bridge,\" the Guardian approves.");
            artifacts.add("Pendant of Integrity");
            points += 30;
        } else {
            System.out.println("\n\"The ends don't justify the means,\" the bridge trembles.");
            lives--;
        }
        
        // Challenge
        System.out.println("\nSolve the riddle to cross:");
        System.out.println("\"I have 4 legs in the morning, 2 legs at noon, and 3 legs in the evening.\"");
        System.out.println("What am I?");
        System.out.println("1. A tree  2. A human  3. A chair  4. A river");
        
        if (getChoice(4) == 2) {
            System.out.println("\nCorrect! The bridge stabilizes.");
            points += 50;
        } else {
            System.out.println("\nIncorrect! Part of the bridge collapses.");
            lives--;
        }
        
        // Mini-challenge
        System.out.println("\nYou see a lever. Pull it? (1. Yes 2. No)");
        if (getChoice(2) == 1) {
            if (random.nextBoolean()) {
                System.out.println("\nYou gain an extra life!");
                lives++;
            } else {
                System.out.println("\nA trap! You lose a life.");
                lives--;
            }
        }
        
        displayStatus();
        waitForEnter();
    }

    private void valeOfShadows() {
        System.out.println();
        System.out.println("🌫️ REALM 4: VALE OF SHADOWS 🌫️");
        System.out.println();
        System.out.println("      .-~~~-.");
        System.out.println("  .- ~ ~-(  )_ _");
        System.out.println(" /                    ~ -.");
        System.out.println("|                          \\");
        System.out.println(" \\                         .'");
        System.out.println("   ~- . _____________ . -~");
        System.out.println();
        System.out.println("Fog and regret surround you. Memories haunt the mist.");
        System.out.println("Shapes move just beyond sight...");
        
        // Moral dilemma
        System.out.println("\nA shadowy figure asks:");
        System.out.println("\"Would you erase your trauma if it meant losing the wisdom it brought?\"");
        System.out.println("1. Yes, I'd erase the pain");
        System.out.println("2. No, my struggles define me");
        
        int choice = getChoice(2);
        if (choice == 2) {
            System.out.println("\n\"Strength comes through adversity,\" the figure concedes.");
            artifacts.add("Crown of Resilience");
            points += 30;
        } else {
            System.out.println("\n\"Avoiding pain creates weakness,\" the mist thickens.");
            lives--;
        }
        
        // Challenge
        System.out.println("\nRiddle: \"I follow you all day but vanish in darkness. What am I?\"");
        System.out.println("1. Your shadow  2. Time  3. Hope  4. Memory");
        
        if (getChoice(4) == 1) {
            System.out.println("\nCorrect! The mist clears momentarily.");
            points += 50;
            
            // Secret room
            System.out.println("\nYou found a hidden shrine! (Quick thinking reward)");
            System.out.println("  _________");
            System.out.println(" /   TIME   \\");
            System.out.println("|   RELIC    |");
            System.out.println(" \\_________/");
            System.out.println("You gain the Time Relic!");
            hasTimeRelic = true;
        } else {
            System.out.println("\nIncorrect! Shadows cling to you.");
            lives--;
        }
        
        displayStatus();
        waitForEnter();
    }

    private void crystalLabyrinth() {
        System.out.println();
        System.out.println("💎 REALM 5: CRYSTAL LABYRINTH 💎");
        System.out.println();
        System.out.println("   /\\ /\\ /\\ /\\");
        System.out.println("  /  \\  /  \\  /\\");
        System.out.println(" / /\\ \\/ /\\ \\/  \\");
        System.out.println(" \\ \\/ /\\ \\/ /\\  /");
        System.out.println("  \\  /  \\  /  \\/");
        System.out.println("   \\/\\  \\/\\ /");
        System.out.println("      \\  /\\/");
        System.out.println("       \\/");
        System.out.println();
        System.out.println("A maze where decisions reflect your soul. Crystals trap hesitation.");
        
        // Moral dilemma
        System.out.println("\nA crystal mirror shows your reflection:");
        System.out.println("\"Would you give your greatest dream to help a stranger achieve theirs?\"");
        System.out.println("1. Yes, their happiness matters more");
        System.out.println("2. No, I must pursue my own destiny");
        
        int choice = getChoice(2);
        if (choice == 1) {
            System.out.println("\n\"True selflessness is rare,\" the crystals chime.");
            artifacts.add("Heart of Altruism");
            points += 30;
        } else {
            System.out.println("\n\"Ambition has its place,\" the maze shifts.");
            lives--;
        }
        
        // Challenge
        System.out.println("\nSolve the puzzle:");
        System.out.println("Three switches control three lamps in another room.");
        System.out.println("You can flip switches but only enter the room once.");
        System.out.println("How do you determine which switch controls which lamp?");
        System.out.println("1. Turn one on, turn it off and turn another on, then enter");
        System.out.println("2. Turn two on, leave one off, then enter");
        System.out.println("3. Turn all on, then enter");
        System.out.println("4. Turn one on, leave others off, then enter");
        
        if (getChoice(4) == 1) {
            System.out.println("\nCorrect! The path clears.");
            points += 50;
        } else {
            System.out.println("\nIncorrect! The maze twists dangerously.");
            lives--;
        }
        
        displayStatus();
        waitForEnter();
    }

    private void altarOfReckoning() {
        System.out.println();
        System.out.println("🔥 REALM 6: ALTAR OF RECKONING 🔥");
        System.out.println();
        System.out.println("          /\\");
        System.out.println("         /  \\");
        System.out.println("        / /\\ \\");
        System.out.println("       / /  \\ \\");
        System.out.println("      / /    \\ \\");
        System.out.println("     / /      \\ \\");
        System.out.println("    / /        \\ \\");
        System.out.println("   / /__________\\ \\");
        System.out.println("  /_______________\\");
        System.out.println("  |               |");
        System.out.println("  |    GUARDIAN   |");
        System.out.println("  |      OF       |");
        System.out.println("  |     FLAME     |");
        System.out.println("  |_______________|");
        System.out.println();
        System.out.println("The Guardian of Flame appears: \"Your artifacts: " + artifacts.size() + "/6\"");
        
        // Battle difficulty based on artifacts
        int difficulty = 6 - artifacts.size(); // 0 (easiest) to 6 (hardest)
        int guardianStrength = difficulty * 2;
        int playerStrength = artifacts.size() * 3;
        
        System.out.println("\nChoose your approach:");
        System.out.println("1. Fight with all your strength");
        System.out.println("2. Try to reason with the Guardian");
        System.out.println("3. Use your artifacts strategically");
        
        int choice = getChoice(3);
        boolean victory = false;
        
        switch (choice) {
            case 1:
                if (playerStrength > guardianStrength) {
                    System.out.println("\nYour might overwhelms the Guardian!");
                    victory = true;
                } else {
                    System.out.println("\nThe Guardian is too powerful in direct combat!");
                }
                break;
            case 2:
                if (artifacts.size() >= 4) {
                    System.out.println("\nThe Guardian recognizes your wisdom!");
                    victory = true;
                } else {
                    System.out.println("\n\"Words are empty without proof,\" the Guardian roars.");
                }
                break;
            case 3:
                if (artifacts.size() >= 2) {
                    System.out.println("\nYour artifacts create a dazzling display of light!");
                    victory = true;
                } else {
                    System.out.println("\n\"You lack the artifacts needed!\" the Guardian scoffs.");
                }
                break;
        }
        
        if (!victory && hasTimeRelic) {
            System.out.println("\nTIME RELIC ACTIVATED! You get a second chance!");
            victory = random.nextBoolean();
        }
        
        if (victory) {
            System.out.println("\nVICTORY! The Flame is reignited!");
            points += 100 * artifacts.size();
        } else {
            System.out.println("\nThe Guardian strikes you down!");
            lives = 0;
        }
    }

    // Ending Sequences
    private void displayVictory() {
        System.out.println();
        System.out.println("**************************************************");
        System.out.println("        FROM SHADOW'S MAW TO SUN'S EMBRACE");
        System.out.println("        YOUR COURAGE LIT OUR DARKEST PLACE");
        System.out.println("        ELYNDOR SINGS YOUR NAME IN LIGHT");
        System.out.println("        FOREVERMORE, YOU END THE NIGHT");
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("          _   _   _   _   _   _  ");
        System.out.println("         / \\ / \\ / \\ / \\ / \\ / \\ ");
        System.out.println("        ( V ( I ( C ( T ( O ( R )");
        System.out.println("         \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ");
        System.out.println();
        System.out.println("FINAL SCORE: " + points);
        System.out.println("ARTIFACTS COLLECTED: " + artifacts.size() + "/6");
        System.out.println();
        System.out.println("The kingdom of Elyndor is restored!");
    }

    private void displayDefeat() {
        System.out.println();
        System.out.println("**************************************************");
        System.out.println("        NO FLAME ROSE. NO LIGHT RETURNED.");
        System.out.println("        THE WORLD FORGETS YOUR NAME.");
        System.out.println("        ONLY THE WIND MOURNS LIGHTBORNE.");
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("       *     *      ");
        System.out.println("    *    *     *    ");
        System.out.println("  *  D  E  A  D  *");
        System.out.println("    *    *     *    ");
        System.out.println("       *     *      ");
        System.out.println();
        System.out.println("FINAL SCORE: " + points);
        System.out.println();
        System.out.println("The altar remains dark...");
        System.out.println("But perhaps another will take up the flame?");
    }

    // Utility Methods
    private void waitForEnter() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private int getChoice(int max) {
        while (true) {
            System.out.print("\nEnter your choice (1-" + max + "): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= max) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                // Fall through to error message
            }
            System.out.println("Invalid input. Please enter a number between 1 and " + max + ".");
        }
    }
}


