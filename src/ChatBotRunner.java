//Mir Shahiduzzaman, Sheba, Juan, Calvin
import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{
	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		ChatBotJuan chatbot1 = new ChatBotJuan();
		ChatBotMir chatbot2 = new ChatBotMir();
		ChatBotSheba chatbot3 = new ChatBotSheba();
		ChatBotCalvin chatbot4 = new ChatBotCalvin();

		int chatbot = 0;
		int cuisine = 0;

		Scanner in = new Scanner (System.in);
		// Get the chatbot that user chooses
		System.out.println("Welcome to the chatbot place, nice to meet you!\nDo you want to talk to the traveler(1), the chef(2), the teacher(3), or the riddler(4)?");
		String statement = in.nextLine();
		if (statement.equals("1") || statement.equals("traveler") || statement.equals("the traveler"))
		{
			chatbot = 1;
		}
		if (statement.equals("2") || statement.equals("chef") || statement.equals("the chef"))
		{
			chatbot = 2;
		}
		if (statement.equals("3") || statement.equals("teacher") || statement.equals("the teacher"))
		{
			chatbot = 3;
		}
		if (statement.equals("4") || statement.equals("riddler") || statement.equals("the riddler"))
		{
			chatbot = 4;
		}
		// Get the cuisine that user chooses
		System.out.println("Which cuisine do you want to talk about American(1), Mexican(2), or Indian(3).");
		String statement2 = in.nextLine();
		statement2.toLowerCase();
		if (statement2.equals("1") || statement2.equals("american"))
		{
			cuisine = 1;
		}
		if (statement2.equals("2") || statement2.equals("mexican"))
		{
			cuisine = 2;
		}
		if (statement2.equals("3") || statement2.equals("indian"))
		{
			cuisine = 3;
		}

		while (!statement.equals("Bye"))
		{
			//Use Logic to control which chatbot is handling the conversation\
			//This example had only chatbot1

			if(chatbot == 1)
			{
				chatbot1.chatLoop(statement);
			}
			if(chatbot == 2)
			{
				chatbot2.chatLoop(statement);
			}
			if(chatbot == 3)
			{
				chatbot3.chatLoop(statement, cuisine);
			}
			if(chatbot == 4)
			{
				chatbot4.chatLoop(statement, cuisine);
			}


			statement = in.nextLine();


		}
		in.close();
	}

}
