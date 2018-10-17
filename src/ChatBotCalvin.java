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
	private String randomA;
	private int score = 0;
	private int numberofquestions = 0;
	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());
		statement = in.nextLine();
		intro(statement);
		while (!statement.equals("Bye") || numberofquestions < 10)
		{
			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));
		}
		System.out.println(yourScore());
	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hi, what is up?\nHave you talked to the other chatbots?";
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
	/**
	 * Gives the score at the end
	 *
	 * @return a the amount of question that the user got right
	 */
	public String yourScore()
	{
		return "You got " + score + " out of " + numberofquestions + " questions correct." + score/numberofquestions;
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

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
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
			response = getRandomResponse();
		}
		if (randomA == response)
		{
			response = "Correct";
			score++;
			numberofquestions++;
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
		String randomQ = randomQuestions [r.nextInt(randomQuestions.length)];
		randomA = randomAnswers [r.nextInt(randomAnswers.length)];
		return randomQ;
	}
	private String [] randomQuestions = {"fries made in ...?", "pizza?", "food?"};
	private String [] randomAnswers = {"fries made in ...?", "pizza?", "food?"};
}