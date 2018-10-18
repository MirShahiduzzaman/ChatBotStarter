import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotMir
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;

	//NEED TO FINISH
	String[] foods = {"Roast Turkey", "Cheeseburger","Reuben Sandwich","Hot dogs","Philly Cheese Steak","Nachos","Chicago Style Pizza","Delmonico’s Steak","Blueberry Cobbler","Chocolate Chip Cookies","Butter Chicken","Tandoori Chicken","Chicken Tikka Masala","Rogan Josh","Malai Kofta","Chole","Spinach and Cottage Cheese","Black Lentils","Papdi Chaat","Naan","Tamales","Vaca Frita","Hispanic Tilapia and Rice Bowl","Shrimp Diabla","Shrimp Ceviche","Black Bean Plantain Empanadas","Fried Yuca Strips","Polvorones de Limón","Latin burger","Cuban beef picadillo"};

	String[][] ingredients = 	{
			{"1 (16 pound) whole turkey, neck and giblets removed","1/4 cup extra-virgin olive oil", "1 teaspoon salt","1/2 teaspoon ground black pepper","1 teaspoon ground thyme1 cup honey","1/2 cup melted butter","2 teaspoons dried sage leaves","1 tablespoon minced fresh parsley","1 teaspoon dried basil","1 teaspoon salt","1 teaspoon ground black pepper"},

			{"2 pounds freshly ground chuck, (at least 80% lean, a.k.a. 80/20)", "1 tablespoon onion powder", "1 teaspoon salt","1 teaspoon freshly ground black pepper","12 slices deli-counter American cheese","6 large burger buns, preferably homemade, toasted if desired","Any ingredient for garnishing"},

			{"2 tablespoons butter","8 slices rye bread", "8 slices deli sliced corned beef", "8 slices Swiss cheese", "1 cup sauerkraut, drained","1/2 cup Thousand Island dressing"},

			{"4 hot dog buns", "2 tbsp. butter, softened", "1/4 tsp. garlic powder", "1/4 tsp. onion powder", "4 hot " +
					"dogs, split lengthwise (be careful not to cut all the way through)", "3 c. shredded cheddar", "4 Green onions, sliced"},

			{"1 (12-ounce) flank steak, trimmed","1/4 teaspoon kosher salt","1/4 teaspoon freshly ground black pepper","2 (5-inch) portobello mushroom caps","2 teaspoons extra-virgin olive oil, divided","1 cup thinly sliced onion","1 1/2 cups thinly sliced green bell pepper","2 teaspoons minced garlic","1/2 teaspoon Worcestershire sauce","1/2 teaspoon lower-sodium soy sauce","2 teaspoons all-purpose flour","1/2 cup 1% low-fat milk","1 ounce provolone cheese, torn into small pieces","2 tablespoons grated Parmigiano-Reggiano cheese","1/4 teaspoon dry mustard","4 (3-ounce) hoagie rolls, toasted"},

			{"1 pound ground beef", "1 (1.25 ounce) package taco seasoning mix", "3/4 cup water", "1 (18 ounce) " +
					"package ", "restaurant-style tortilla chips", "1 cup shredded sharp Cheddar cheese, or more to " +
					"taste", "1 (15.5 ounce) can refried beans", "1 cup sour cream, or more to taste", "Friendship " +
					"Sour Cream 16 Oz","1 (10 ounce) can pitted black olives, drained and chopped","4 green onions," +
					" diced","1 (4 ounce) can sliced jalapeno peppers, drained"},

			{"3 and 1/4 cups all-purpose flour", "1/2 cup yellow cornmeal", "1 and 1/4 teaspoons salt", "1 Tablespoon" +
					" granulated sugar", "2 and 1/4 teaspoons Red Star Platinum yeast (1 standard packet)", "1 and " +
					"1/4 cups slightly warm water", "1/2 cup unsalted butter, divided (1/4 cup melted, 1/4 cup " +
					"softened)", "olive oil for coating","2 Tablespoons unsalted butter", "1 small onion, grated " +
					"(about 1/3 cup)1", "3/4 teaspoon salt", "1 teaspoon dried oregano", "1/2 teaspoon crushed red " +
					"pepper flakes (optional, but recommended)", "3 garlic cloves, minced", "one 28-ounce can crushed" +
					" tomatoes","1 1/4 teaspoon granulated sugar","4 cups shredded mozzarella cheese2","1/2 cup grated parmesan cheese", "Optional:Toppings"},

			{"1/2 cup olive oil","1/4 cup Worcestershire sauce","6 tablespoons soy sauce","1/4 cup minced " +
					"garlic","1/2 medium onion, chopped","2 tablespoons salt","1 tablespoon pepper","1 " +
					"tablespoon crushed dried rosemary","3 tablespoons steak seasoning","3 tablespoons steak sauce (e" +
					".g. A-1)","4 (10 ounce) Delmonico (rib-eye) steaks"},

			{"3 cups fresh blueberries\n" +
					"3 tablespoons white sugar\n" +
					"1/3 cup orange juice\n" +
					"2/3 cup all-purpose flour\n" +
					"1/4 teaspoon baking powder\n" +
					"1 pinch salt\n" +
					"1/2 cup butter, softened\n" +
					"1/2 cup white sugar\n" +
					"1 egg\n" +
					"1/2 teaspoon vanilla extract\n"},

			{"3 cups all-purpose flour\n" +
					"2 cups semisweet chocolate chips\n" +
					"1 cup chopped walnuts\n" +
					"1 cup butter, softened\n" +
					"1 cup white sugar\n" +
					"1 cup packed brown sugar\n" +
					"2 eggs\n" +
					"2 teaspoons vanilla extract\n" +
					"1 teaspoon baking soda\n" +
					"2 teaspoons hot water\n" +
					"1/2 teaspoon salt\n"}
								};


	String[][] Directions = new String[30][30];


	public void inputIngred(String[][] arr)
	{
		String allIng = "1/4 pound (1 stick) unsalted butter:1 lemon, zested and juiced:1 teaspoon chopped fresh " +
				"thyme leaves:1 fresh turkey (10 to 12 pounds):Kosher salt:Freshly ground black pepper:1 large bunch " +
				"fresh thyme:1 whole lemon,halved:1 Spanish onion, quartered:1 head garlic,halved crosswise;hi:buy:bye";

		String[][] final1 = new String[30][30];

		String[] temp = allIng.split(";");

		for(int i = 0; i<temp.length; i++)
		{
			final1[0] = temp[i].split(":");
		}

		for(int i = 0; i<temp.length; i++)
		{
			final1[0] = temp[i].split(":");
		}
		System.out.println(final1[0][0]);
		System.out.println(final1[0][1]);
		System.out.println(temp[0]);
		System.out.println(temp[1]);
	}


	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());

		inputIngred(ingredients);

		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));


		}

	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hey, wasup? What recipe do you wanna learn about?";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";

		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}

		else if(findKeyword(statement, "recipe for",0) >= 0)
		{
			response = transformRecipeForStatement(statement);
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
                	emotion--;
		}
		
		else if (findKeyword(statement, "mir") >= 0)
		{
			response = "More like MirTheDream amiright?";
			emotion++;
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if((findKeyword(statement, "I",0) >= 0) && (findKeyword(statement, "you",statement.indexOf("I")))>=0)
		{
			response = transformIYouStatement(statement);
		}
		else
		{
			response = getRandomResponse();
		}
		
		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}

	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}

	/**
	 * Take a statement with "recipe for <something>." and transform it into
	 * "The recipe for <something> is simple!"
	 * @param statement the user statement, assumed to contain "recipe for"
	 * @return the transformed statement
	 */
	private String transformRecipeForStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "recipe for", 0);
		String restOfStatement = statement.substring(psn + 10).trim();
		return "The recipe for " + restOfStatement + " is simple!";

		//if(restOfStatement )
	}

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
	
}
