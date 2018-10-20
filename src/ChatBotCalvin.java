//Calvin Lam
import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotCalvin
{
	/**
	 * Stores variables that is used throughout the program.
	 */
	private String randomA;
	private String randomQ;
	private int score;
	private int numberofquestions;
	private int type = 1;
	private int num = 0;
	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement, int cuisine)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());
		statement = in.nextLine();
		System.out.println(intro(statement));
		if (findKeyword(statement, "I had", 0) >= 0)
		{
			ChatBotRunner.main(randomQuestionsAmerican);
		}
		else if (findKeyword(statement, "I have", 0) >= 0)
		{
			if(findKeyword(statement, "not", 0) >= 0)
				ChatBotRunner.main(randomQuestionsAmerican);
		}
		else if(findKeyword(statement, "no", 0) >= 0)
		{
			ChatBotRunner.main(randomQuestionsAmerican);
		}
		score = 0;
		numberofquestions = 0;
		num = 0;
		type = cuisine;
		while (!statement.equals("Bye") && numberofquestions < 10)
		{
			System.out.println(getQ(statement));
			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(afterQ(statement));
		}
		System.out.println(yourScore());
	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, I am the riddler. \nHave you talked to the other chatbots?";
	}
	/**
	 * Gives a response to a user statement to the greeting
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String intro(String statement)
	{
		String response = "";
		if (findKeyword(statement, "I had", 0) >= 0)
		{
			if(findKeyword(statement, "not", 0) >= 0)
				response = transformIHadNStatement(statement);
		}
		else if (findKeyword(statement, "I have", 0) >= 0)
		{
			if(findKeyword(statement, "not", 0) >= 0)
				response = transformIHaveNStatement(statement);
		}
		else if(findKeyword(statement, "no", 0) >= 0)
		{
			response = "No?, well then you should go talk to them first.";
		}
		else
			response = "Ok, I'm going to give you a trivia now.";
		return response;
	}

	public String afterQ(String statement)
	{
		String response = "";
		statement.toLowerCase();
		if (statement.equalsIgnoreCase(randomA))
		{
			response = "Correct!";
			score++;
		}
		else
		{
			response = "Wrong. The correct answer is " + randomA + ".";
		}
		if (statement.length() == 0)
		{
			response = "Your not talking? Well I'll count that as you got it wrong.";
		}
		numberofquestions++;
		return response;
	}
	/**
	 * Gives the score at the end
	 *
	 * @return a the amount of question that the user got right
	 */
	public String yourScore()
	{
		String reaction = "";
		if(score < 6)
		{
			reaction = "Aww too bad.\nTalk to you later bye.";
		}
		else
		{
			reaction = "Congrats. You remember what my fellow chatbots were talking about.\nTalk to you later bye.";
		}
		return "You got " + score + " out of " + numberofquestions + " questions correct.\n" + reaction;
	}
	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getQ(String statement)
	{
		String response = "";

		// Response transforming I want to statement
		if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
        else if (findKeyword(statement, "I don't know the answer to", 0) >= 0)
        {
            response = transformIDontKnowTheAnswerToStatement(statement);
        }
		else
		{
			response = getRandomQuestions();
		}
		return response;
	}
	/**
	 * Take a statement with "I don't know the answer to <something>." and transform it into
	 * "The answer to <something> is <answer>."
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIDontKnowTheAnswerToStatement(String statement)
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
		int psn = findKeyword (statement, "I don't know the answer to", 0);
		String restOfStatement = statement.substring(psn + 26).trim();
		return "The answer to " + restOfStatement + " is " + randomA + ".";
	}
	/**
	 * Take a statement with "I had <something>." and transform it into
	 * "You had <something>?, well then you should go talk to them first."
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIHadNStatement(String statement)
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
		int psn = findKeyword (statement, "I had", 0);
		String restOfStatement = statement.substring(psn + 5).trim();
		return "You had " + restOfStatement + "?, well then you should go talk to them first.";
	}
	/**
	 * Take a statement with "I have <something>." and transform it into
	 * "You have <something>?, well then you should go talk to them first."
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIHaveNStatement(String statement)
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
		int psn = findKeyword (statement, "I have", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "You have " + restOfStatement + "?, well then you should go talk to them first.";
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
	private String getRandomQuestions ()
	{
		if(type == 1)
		{
			// American
			randomQ = randomQuestionsAmerican[num];
			randomA = randomAnswersAmerican[num];

		}
		if(type == 2)
		{
			// Mexican
			randomQ = randomQuestionsMexican[num];
			randomA = randomAnswersMexican[num];

		}
		if(type == 3)
		{
			// Indian
			randomQ = randomQuestionsIndian[num];
			randomA = randomAnswersIndian[num];
		}
		num++;
		return randomQ;
	}
	/**
	 * Creates an array of questions and answers for 3 cuisines.
	 */
	private String [] randomQuestionsAmerican = {"What word means, to plunge fruits or vegetables briefly in boiling water to lock in colour and flavour?.", "What food uses a whole turkey?", "What is it called to make a crisscross pattern on the outside of grilled or broiled food?", "What type of dry heat cooking — cook food by submerging it in hot oil called?", "What is it called to add something to food or drink that changes its taste or gives it a particular taste?", "What is it called to add a liquid to dried food so that you can eat it;tenderize verb to make meat soft by hitting it or putting it in a liquid containing oi?", "What food uses 2 pounds freshly ground chuck?", "What word means, to sauté meat or vegetables, which are then slowly cooked over low heat using ceramic earthenware or a stockpot?", "What word means, to moisten foods with fat or other seasoned liquids during cooking?", "What word means, to mix foods thoroughly to a smooth consistency using a spoon, fork, whisk or electric beater/mixer?"};
	private String [] randomAnswersAmerican = {"blanch", "roast turkey", "quadriller", "deep-fry", "flake", "reconstitute", "cheeseburger", "braise", "baste", "beat"};
	private String [] randomQuestionsMexican = {"What word means, a mashed up preparation of avocado that literally means avocado sauce?", "What is a sauce that includes many different spices and chocolate?", "What does pollo mean?", "What does cerveza mean?", "What is a tortilla rolled and filled with a seasoned mixture?", "What are meat and cornmeal wrapped in corn husks called?", "What word means, raw fish marinated in citrus juice, which essentially cooks the delicate seafood?", "What is the signature meal is made of rice, chicken, seafood, and other ingredients seasoned with saffron called?", "What is a mild green chile, usually a poblano, that is stuffed with cheese and/or meat, dipped in batter, and fried?", "What are fried ice cream called?"};
	private String [] randomAnswersMexican = {"guacamole", "mole", "chicken", "beer", "enchilada", "tamales", "ceviche", "paella", "chiles rellenos", "helado frito"};
	private String [] randomQuestionsIndian = {"What is a dish with layers of meat called?", "What is a deep-fried Indian appetizer with a spicy vegetable filling covered in batter?", "What is tea made by boiling tea leaves along with milk?", "What is thin pancake made of whole wheat flour that's cooked on a hotplate?", "What is small pieces of boneless chicken cooked on a skewer in a tandoor oven?", "What is beans, as in frijoles refritos?", "What is tortilla chips covered with cheese and various other ingredients?", "What is a strip of sweet fried dough sprinkled with sugar and cinnamon?", "What is a tortilla that's folded over and filled with meat, beans and cheese", "What is a paste or marinade of chillies, vinegar, herbs and spices for flavouring meat or fish."};
	private String [] randomAnswersIndian = {"biryani", "bhaji", "chai", "chapati", "chicken tikka", "Frijoles", "nachos", "churro", "burrito", "adobo"};
}