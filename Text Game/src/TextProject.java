import java.util.Random;
import java.util.Scanner;

public class TextProject {

	public static void main(String[] args) {
		// System objects
		Scanner in = new Scanner(System.in);
			Random rand = new Random();
			
			// Game objects
			String[] enemies = {"Goblin", "Shank", "Dreg", "Screeb"};
			int maxEnemyHealth = 75;
			int enemyAttackDamage = 50;
			
			// Player variables
			int health = 100;
			int attackDamage = 50;
			int numHealthPots = 3;
			int healthPotionAmount = 30;
			int healthPotionDropChance = 50; // Percentage
			
			//Scoring
			int score = 0;
			
			boolean running = true;
			
			System.out.println("Welcome To The Dungeon");
			
			GAME:
			while(running) {
						
						
				int enemyHealth = rand.nextInt(maxEnemyHealth);
				String enemy = enemies[rand.nextInt(enemies.length)];
				System.out.println("---------------------------------");
				System.out.println("\t# A " + enemy + " has appeared! #\n");
				// Example of output: # Screeb has appeared! #
				
				while(enemyHealth > 0) {
					System.out.println("\tYour HP: " + health);
					System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
					System.out.println("\n\tWhat would you like to do?");
					System.out.println("\t1. Attack");
					System.out.println("\t2. Drink Health Potion");
					System.out.println("\t3. Run!\n");
					
					String input = in.nextLine();
					
					if (input.equals("1")) {
						int damageDealt = rand.nextInt(attackDamage);
						int damageTaken = rand.nextInt(enemyAttackDamage);
						enemyHealth -= damageDealt;
						health -= damageTaken;
						score += 5;
						
						System.out.println("\t> You shot the " + enemy + " for " + damageDealt + " damage!");
						System.out.println("\t> You have taken " + damageTaken + " damage in return! \n");
						
						if (health < 1) {
							System.out.println("\t You have taken too much damage! You are too weak to go on! \n");
							break;
							
						}
					
					}
					else if (input.equals("2")) {
						if (numHealthPots >= 0) {
							health += healthPotionAmount;
							numHealthPots--;
							System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionAmount + " HP."
									+ "\n\tYou have " + health + " HP."
									+ "\n\tYou now have " + numHealthPots + " Health Potions left.");
							score -= 2;
							}
						else {
							System.out.println("\tYou have no health potions left. Defeat enemies for a chance to get one.\n");
						}
						
					}
					else if (input.equals("3")) {
						score -= 3;
						System.out.println("\t # You run away from the " + enemy + "! # \n");
						String[] phrase = {"You have entered a strange room...", "You've found yourself in a locked castle... ", "You've journeyed into a mysterious abyss..."};
						String startPhrase = phrase[rand.nextInt(phrase.length)];
						System.out.println(startPhrase);
						continue GAME;
						
					}
					
					else {
						System.out.println("\t** Invalid command. ** \n");
					}
				}
				
				if (health < 1) {
					System.out.println("You limp out the dungeon weak from battle...\n");
					System.out.println("Score: " + score + " points \n");
					break;
				}
				
				System.out.println("---------------------------------");
				System.out.println(" # " + enemy + " was defeated! # ");
				System.out.println(" You have " + health + " HP left.");
				
				
				if (rand.nextInt(100) < healthPotionDropChance) {
					numHealthPots++;
					System.out.println(" # The " + enemy + " dropped a health potion! # ");
					System.out.println(" # You now have " + numHealthPots + " health potion(s). # ");
				}
				
				System.out.println("---------------------------------");
				System.out.println("What would you like to do now?");
				System.out.println("1. Continue fighting");
				System.out.println("2. Exit Dungeon\n");
				
				String input = in.nextLine();
				
				while (!input.equals("1") && !input.equals("2")) {
					System.out.println("Invalid command!");
					input = in.nextLine();
				}
				
				if (input.equals("1")) {
					System.out.println("You continue on your adventure! \n");
				}
				
				else if (input.equals("2")) {
					System.out.println("You exit the dungeon, successful from your adventures! \n");
					System.out.println("Score: " + score + " points \n");
					break;
				}
				
			}
			
			System.out.println("---------------------------------");
			System.out.println(" # THANKS FOR PLAYING! # ");
			System.out.println("---------------------------------");
			
	}
			
}
	

	

	



