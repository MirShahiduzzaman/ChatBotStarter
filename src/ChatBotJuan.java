//Juan Osorio

import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotJuan
{
    // constant and some astract variables that can be preset
    int emotion = 0;
    int AMERICAN = 0, MEXICAN = 1, INDIAN = 2;
    int NAME = 0, ADDRESS = 1;

    String choice = "American";
    /**
     * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
     * @param statement the statement typed by the user
     */

    public void chatLoop(String statement)
    {
        Scanner in = new Scanner (System.in);
        System.out.println ("Hi, My name is The traveler, I know all about restaurants you can get American, Mexican and Indian food, which cuisine do you want to learn about today?");
        System.out.println("Also, if you want to change at any time then just say you want to switch.");
        statement = in.nextLine();
        choice = setCuisine(statement);
        intro(choice);
        while (!statement.equals("Bye"))
        {
            System.out.println(getResponse(statement));
            statement = in.nextLine();
        }
    }
    public void intro(String choice)
    {
        System.out.println("Hey, I see you chose" + choice);
        System.out.println("I know some cities where you can get some nice "+choice+" food");
        recomend(choice);
    }
    public void recomend(String choice)
    {
        Scanner confirmation = new Scanner (System.in);
        boolean like = false;
        int option = 0;
        String input = "";
            System.out.print("Do you like" + cities[option]+"?");
            input = confirmation.nextLine();
            if(findKeyword(input, "yes")>=0)
            {
                getResponse(input);
            }
            else
                getResponse(input); //Maybe choice??
    }
    public String setCuisine(String str)
    {
        if(findKeyword(str,"american") >= 0)
            return ("american");
        else if (findKeyword(str,"mexican")  >= 0)
        return ("mexican");
        else if (findKeyword(str,"indian") >= 0)
        return ("indian");
        else
        return "american";
    }
    /**
     * Gives a response to a user statement
     * @param statement - the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        Scanner oolean = new Scanner(System.in);

        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }
        else if (findKeyword(statement,"i want to switch")>=0)
        {
            System.out.println("Hey just making sure, do you want to switch?");
            String confirmation = oolean.nextLine();
            if(findKeyword(confirmation,"yes")>=0)
            {
                ChatBotRunner.main(randomNeutralResponses);
            }
            else
            {
                response = "ok then!";
            }
        }
        else if (findKeyword(statement, "no") >= 0)
        {
            response = "I'm sorry I don't need that negativity in my life.";
            emotion--;
        }
        else if (findKeyword(statement, "levin") >= 0)
        {
            response = "More like LevinLife, amiright?";
            emotion++;
        }
        else if (findKeyword(statement, "folwell") >= 0)
        {
            response = "Watch your backpacks, Mr. Folwell doesn't fall well.";
            emotion++;
        }
        else if (findKeyword(statement, "goldman") >= 0)
        {
            response = "Go for the gold, man.";
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
        else if (findKeyword(statement,"I want to switch") >= 0)
        {
            return response;
        }
        else
        {
            response = getRandomResponse();
        }
        return(response);
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
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        // The only change to incorporate the startPos is in the line below
        int psn = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after the word
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

            // If before and after aren't letters, we've found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                    // letter
                    && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0)))
            {
                return psn;
            }
            // The last position didn't work, so let's find the next, if there is one.
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


    private String [] randomNeutralResponses = {"Interesting, tell me more", "Hmmm.", "Do you really think so?", "You don't say.", "It's all boolean to me.", "So, would you like to go for a walk?", "Could you say that again?"};
    private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
    private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};

    private String [][] NewYork = {{"Bleeker Street Pizza","69 7th Ave S, New York City, NY 10014-4043"},{"El Cnetro","824 9th Ave New York City, NY"},{"Milon Restaurant","93 1st Ave, New York City,Ny 10003-2922"}};
    private String [][] SanFrancisco = {{"Hollywood Cafe","530 North Point St, San Francisco, CA"},{"Tacorea","809 Bush St, San Francisco, CA"},{"Curry Leaf Restaurant","943 Columbus Ave, San Francisco,CA"}};
    private String [][] Miami = {{"Texas Roadhouse","9161 W flagler St, Miami, FL"},{"Coyo Taco","2320 NW 2nd Ave, " +
            "Miami, FL"},{"Zaika Indian Cuisine","2176 NE 123rd St, Miami, FL"}};
    private String [][] Washington = {{"Commissary","1443 P St NW Washington DC, DC"},{"El Rinconcito","1129 11th St " +
            "NW, between N L St & N M St, Washington DC, DC"},{"Rasika","633 D St NW, Washington DC, DC"}};
    private String [][] Seattle = {{"Tat's Deli","159 Yesler Way, Seattle, WA"},{"Cactus Restaurant","2820 Alki Ave " +
            "SW, Seattle, WA"},{"Taste of India","5517 Roosevelt way NE, Seattle, WA"}};

    private String [] cities = {"New York","San Francisco","Miami","Washington DC","Seattle"};
}