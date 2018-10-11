import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotSheba
{

	String wordList = "Al dente: To the tooth in Italian, the term refers to firm pasta cooked to the right level of resistance when chewed; Braise: To sauté meat or vegetables, which are then slowly cooked over low heat using ceramic earthenware or a stockpot; Bechamel: A rich white sauce infused with milk, herbs and butter; Charcuterie: A fancy French term for the preparation of cooked meats ranging from bacon to cured meats and sausage. The video above provides tips for preparing your own charcuterie plate;Chiffonade: Delicate looking curlicues of shredded or finely cut vegetable leaves used to garnish a plate or soup;Deglaze: To remove browned bits adhering to a saucepan through the judicious use of water and the application of high heat;Dredge: To lightly coat food with a mixture of cornmeal, breadcrumbs and flour;Dust: To lightly coat food with a powdery ingredient or to lightly coat a work surface with flour;Emulsion: To have one liquid suspended in another, often with liquids that do not mix easily, so emulsions are performed through vigorous stirring or shaking. For example, the combination of oil and vinegar to make salad dressing. The video above demonstrates a few different emulsion techniques for dressings and sauces; Fond: The roasted bits that stick to the surface area of a baking sheet, often used to make sauces and soup stocks;Fines herbes: A seasoning mix that forms the basis of French cooking. Involving a combination of fresh herbs, such as parsley, garlic greens, and tarragon, fines herbes are used in the preparations of meat and vegetables;Gratin: Any dish that is topped with cheese or breadcrumbs and dabs of butter and then baked in the oven, like the pumpkin and pasta gratin above;Grease: To apply butter or oil to a cooking surface to prevent food from sticking when cooked;Hotchpotch: A catchall phrase used to describe any combinations of meat and vegetables braised over low heat to make stew;Infuse: To soak herbs, teas or fruits in liquid to extract their repsective flavors;Julienne: A technique used to describe the process of cutting vegetables into matchstick-sized strips. The video above demonstrates the style;Kosher salt: A flaky type of granular salt preferred by cooks due to its lack of additives, such as iodine;Leaven: The addition of yeast, baking soda or powder that causes bread and cakes to rise during the baking process. When combined with dough or batter, these ingredients form carbon dioxide bubbles, thereby lightening the texture and increasing the volume of baked goods;Mesclun: A combination of small leafy greens often found in specialty stores and food co-ops;Macerate: To immerse food in liquid to breakdown and soften. The technique is commonly used to infuse fruit with liquor and vise versa;Nap: To cover cooked food in a thin layer of sauce. The term is derived from the French word for tablecloth, which is nappe.;Muddle: To press fruit and herbs against the side of a glass to release their juices;Pinch: To grasp a small quantity of spices or seasonings between the thumb and forefinger for sprinkling over food.";
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.

	int emotion = 0;




	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());


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
		//return "There's a lot of weird terms in the world of food. Type some below and I will define it";
		return "Hey there, what food shows do you watch?";
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

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
			emotion--;
		}

		else if (findKeyword(statement, "levin") >= 0)
		{
			response = "More like LevinTheDream amiright?";
			emotion++;
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "like watching", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "favorite food is",0) >= 0)
		{
			response = transformIWantStatement(statement);
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
		int psn = findKeyword (statement, "like watching", 0);
		String restOfStatement = statement.substring(psn + 13).trim();
		return "Is " + restOfStatement + "a Baking or Cooking show?";
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
		int psn = findKeyword (statement, "favorite food is", 0);
		String restOfStatement = statement.substring(psn + 16).trim();
		return "That pretty good. Where do you like to get " + restOfStatement + "?";
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
