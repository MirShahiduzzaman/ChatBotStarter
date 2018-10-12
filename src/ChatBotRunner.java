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
		ChatBot1 chatbot1 = new ChatBot1();
		ChatBotMir chatbot2 = new ChatBotMir();
		ChatBotSheba chatbot3 = new ChatBotSheba();
		ChatBotCalvin chatbot4 = new ChatBotCalvin();
		

		Scanner in = new Scanner (System.in);
		System.out.println("Welcome to the chatbot place, nice to meet you!\nDo you want to talk to the traveler(1), the chef(2), the teacher(3), or the riddler(4)?");
		String statement = in.nextLine();


		while (!statement.equals("Bye"))
		{
			//Use Logic to control which chatbot is handling the conversation\
			//This example had only chatbot1



			chatbot3.chatLoop(statement);


			statement = in.nextLine();


		}
		in.close();
	}

}
