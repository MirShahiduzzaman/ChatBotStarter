import java.util.*;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotSheba
{


	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;




	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement, int cuisine)
	{
		dictionary(cuisine);

	}
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "There's a lot of weird terms in the world of food. Type some below and I will define it";

	}
	public void dictionary (int cuisine) {
		String wordList = "Al dente; To the tooth in Italian, the term refers to firm pasta cooked to the right level of resistance when chewed;Acidulate;To make a dish slightly sour or acidic in order to bring out other flavours, or to make the dish more tender. Usually done by adding a small amount of lemon juice or vinegar;Braise; To sauté meat or vegetables, which are then slowly cooked over low heat using ceramic earthenware or a stockpot;  Bake blind ; To bake an empty pie, tart or flan shell so the pastry is partially cooked before the filling is added, or to cook completely if the filling isn’t to be cooked with the shell; Baste;To moisten foods with fat or other seasoned liquids during cooking.Basting prevents drying out and adds flavour; Beat; To mix foods thoroughly to a smooth consistency using a spoon, fork, whisk or electric beater/mixer; Blanch;To plunge fruits or vegetables briefly in boiling water to lock in colour and flavour. They are then refreshed in very cold or ice water to stop it cooking further; Braise;To cook gently in a small amount of liquid in a covered pan;Bechamel; A rich white sauce infused with milk, herbs and butter; Charcuterie; A fancy French term for the preparation of cooked meats ranging from bacon to cured meats and sausage. The video above provides tips for preparing your own charcuterie plate;Broil; To cook above or below a direct heat source, usually on a rack or spit in an oven; Bruise;To crush gently using a heavy knife, pestle or rolling pin to release the flavours of spices, citrus peel, lemongrass, etc;Caramelise;The process of browning sugar. Granulated sugar can be caramelised in a pan until it turns brown and takes on a nutty flavour. Fruit and vegetables can also be caramelised by cooking them slowly in a small amount of fat until they are brown and shiny;Crumb;To coat uncooked food in a breadcrumbs or other crumbs (such as cereal), before frying or baking to give it a crisp, crunchy texture;Deseed;To take the seeds out of a fruit or vegetable, for example, a chilli or tomatoes.;Chiffonade; Delicate looking curlicues of shredded or finely cut vegetable leaves used to garnish a plate or soup;Deglaze; To remove browned bits adhering to a saucepan through the judicious use of water and the application of high heat;Dredge; To lightly coat food with a mixture of cornmeal, breadcrumbs and flour;Dust; To lightly coat food with a powdery ingredient or to lightly coat a work surface with flour;Emulsion; To have one liquid suspended in another, often with liquids that do not mix easily, so emulsions are performed through vigorous stirring or shaking. For example, the combination of oil and vinegar to make salad dressing. The video above demonstrates a few different emulsion techniques for dressings and sauces; Fond; The roasted bits that stick to the surface area of a baking sheet, often used to make sauces and soup stocks;Fines herbes; A seasoning mix that forms the basis of French cooking. Involving a combination of fresh herbs, such as parsley, garlic greens, and tarragon, fines herbes are used in the preparations of meat and vegetables;Gratin; Any dish that is topped with cheese or breadcrumbs and dabs of butter and then baked in the oven, like the pumpkin and pasta gratin above;Grease; To apply butter or oil to a cooking surface to prevent food from sticking when cooked;Hotchpotch; A catchall phrase used to describe any combinations of meat and vegetables braised over low heat to make stew;Infuse; To soak herbs, teas or fruits in liquid to extract their repsective flavors;Julienne; A technique used to describe the process of cutting vegetables into matchstick-sized strips. The video above demonstrates the style;Kosher salt; A flaky type of granular salt preferred by cooks due to its lack of additives, such as iodine;Leaven; The addition of yeast, baking soda or powder that causes bread and cakes to rise during the baking process. When combined with dough or batter, these ingredients form carbon dioxide bubbles, thereby lightening the texture and increasing the volume of baked goods;Mesclun; A combination of small leafy greens often found in specialty stores and food co-ops;Macerate; To immerse food in liquid to breakdown and soften. The technique is commonly used to infuse fruit with liquor and vise versa;Nap; To cover cooked food in a thin layer of sauce. The term is derived from the French word for tablecloth, which is nappe.;Muddle; To press fruit and herbs against the side of a glass to release their juices;Pinch; To grasp a small quantity of spices or seasonings between the thumb and forefinger for sprinkling over food;Devein ; The process of removing the black thread-like tract from the back of a prawn with a small knife;Dilute;Thinning a liquid or reducing the intensity of flavour by adding liquid;Dry-fry;to cook food in a dry frying pan (usually non-stick) without any oil. this method is usually used for sausages, bacon, nuts and seeds; Dust;To top or decorate a dessert with a fine coating of icing sugar or cocoa powder by using a fine sieve and sifting the icing or powder through;Emulsify; To put two or more liquids together that do not usually mix into one another – like oil and vinegar. The process involves whisking one liquid very slowly into the other;Fold;A way of mixing light ingredients together without altering the consistency. Best performed with a rubber spatula and an over-and-under turning technique, rather than traditional stirring;Grease;To cover a pan or dish with butter or oil to prevent food from sticking; Knead;To work the dough by folding, pushing away, turning slightly then repeating. Bread dough is kneaded for at least 10 minutes to develop the gluten in the dough scone or pastry dough is kneaded lightly and gently and only once or twice to make dough smooth (over-kneading will result in tough scones or pastry dough!);Knock back;After bread dough has been left to rise, it needs to be pressed down to allow excess air to escape. This is known as knocking back;Julienne;To cut food into long thin strips resembling matchsticks. Most commonly used when preparing vegetables; Marinate;To soak meat, chicken or fish in a flavoured liquid mixture;Macerate ;To soak fruit in a flavoured liquid mixture;Parboil;To boil a food, usually a vegetable, until it is partially cooked; Pare;To cut the skin off a fruit or vegetable with a small knife, to ensure you lose as little of the flesh as possible;Poach;To cook a food by placing it in a pot of seasoned simmering liquid;Reduction;To thicken and intensify the flavour of a liquid by boiling it till the liquid reduces in volume, so the flavour is concentrated;Reduce;To thicken and intensify the flavour of a liquid by boiling it till the liquid reduces in volume, so the flavour is concentrated; Scald;To heat a liquid almost to boiling point, but only until tiny bubbles form around the edge of the mixture; Sauté;To cook small pieces of food in a small amount of butter or oil over a high heat in a shallow pan, turning and tossing the food so it colours evenly;Score;To make narrow cuts in a diamond-shaped pattern on the surface of a food. This may be done to allow the food to absorb more flavour, to tenderise the dish or simply to decorate it;Sear;To brown meat over a high temperature very quickly in order to seal in the juices; Season ; To improve the flavour of food by adding salt, pepper and other spices and flavours;Shallow-fry;To cook food (such as cutlets, fritters, fish cakes) in enough butter or oil (about halfway up the pieces) so that once you turn it over, it cooks evenly on both sides;Shuck;To remove the shells from seafood; Simmer; To cook a pot or pan of food just below boiling point;Steep; To stand a food in water that is just below boiling point to allow the flavours to emerge;Stir;To mix with a utensil the whole contents of a bowl or saucepan, for example, to combine ingredients completely or to keep the mixture moving so that it heats evenly as it cooks;Stir-fry;Food that is cooked over a high heat with a small amount of oil and is constantly tossed in the pan or wok. The food is usually cut in small pieces to ensure quick cooking;Whisk;Using a fork, wire whisk or beater, to incorporate as much air as possible into the mixture so it is light and airy.";
		String aWordList = "Quadriller; to make a crisscross pattern on the outside of grilled or broiled food.;Deep-fry; type of dry heat cooking — cook food by submerging it in hot oil.;Flake;to add something to food or drink that changes its taste or gives it a particular taste;reconstitute;to add a liquid to dried food so that you can eat it;tenderize verb to make meat soft by hitting it or putting it in a liquid containing oil";
		String mWordList = "Molé ; A sauce that includes many different spices and chocolate.;Guacamole; A mashed up preparation of avocado that literally means avocado sauce.;Enchilada (ehn-chee-lah-dah); A tortilla rolled and filled with a seasoned mixture, usually containing meat, and covered with a sauce flavored with chili.Origin: enchilado or spiced with chili.;Tamales; Meat and cornmeal (masa) wrapped in corn husks;Ceviche; Raw fish marinated in citrus juice, which essentially cooks the delicate seafood;Paella: This signature meal is made of rice, chicken, seafood, and other ingredients seasoned with saffron (the most expensive spice in the world).;Chiles rellenos; A mild green chile, usually a poblano, that is stuffed with cheese and/or meat, dipped in batter, and fried. Pollo; Chicken;Carne; meat;Cerveza; Beer. You could go beyond Corona and drink a Negra Modelo with a lime.;Tres leches; A cake soaked in evaporated milk, sweetened condensed milk, and heavy cream. The name is literally three milks cake.;Helado frito; Fried ice cream. Ice cream is rolled in something crunchy, usually corn flakes, then doused in potent liquor and set on fire. Cinnamon sparks as it is sprinkled over.;Pepitas; Pumpkin seeds.;Queso fresco; A mild, cow’s milk cheese that does not melt. Similar in texture to feta cheese, but milder.;Chipotle; A smoked jalapeño.;Arroz; Rice is a staple in Mexican cooking and arroz y frijoles (rice and beans) is served with nearly every dish;Frijoles; Beans, as in frijoles refritos, the ever popular refried beans.;quesadilla; a cheese-filled tortilla that's grilled, with vegetables and spices sometimes added;sopapilla; a small, pillow-shaped fried pastry dough mostly eaten as a dessert;taco; a folded or rolled tortilla filled with minced beef or chicken, beans, spices, etc;salsa; a spicy sauce made from tomatoes, onions, chilli peppers, etc;nachos; tortilla chips covered with cheese and various other ingredients;churro; a strip of sweet fried dough sprinkled with sugar and cinnamon;burrito; a tortilla that's folded over and filled with meat, beans and cheese;adobo; a paste or marinade of chillies, vinegar, herbs and spices for flavouring meat or fish";
		String iWordList = "aloo gobi; a dish of potato and cauliflower flavoured with garam masala and tumeric;bhaji; a deep-fried Indian appetizer with a spicy vegetable filling covered in batter;biryani; a dish with layers of meat, fish or vegetables mixed with spices cooked between layers of rice;chai; tea made by boiling tea leaves along with milk, sugar and a blend of spices;chapati; thin pancake made of whole wheat flour that's cooked on a hotplate;Roti; thin pancake made of whole wheat flour that's cooked on a hotplate;chicken tikka; small pieces of boneless chicken cooked on a skewer in a tandoor oven;curry; a meat or vegetable dish cooked in a spicy Indian-style sauce, often eaten with rice;dal; lentils cooked with various spices and flavourings;dosa; a thin Indian pancake made with rice flour and black beans;garam masala; a mixture of powdered spices used in Indian cooking;masala; a mixture of powdered spices used in Indian cooking;ghee; a type of butter used in Indian cooking;kebab; meat and vegetable pieces grilled or roasted on a skewer;korma; meat, fish, or vegetables braised with cream or yoghurt;kulfi; traditional Indian ice-cream;lassi; an Indian drink made of yogurt, water and spices, with fruit sometimes added;nan; a soft, thick, leavened flatbread that's baked in a tandoor oven;paneer; Indian cooking cheese similar to cottage cheese;samosa; an appetizer in which a filling of cooked meat or vegetables is wrapped in pastry and deep-fried;tandoor; an oven traditionally made of clay in which flatbreads, samosas, roast meats and vegetables, etc. are cooked";
		String [] pos = {"awesome","nice","great","fantastic","amazing","cool","oh wow","excellent"};
		String termList[];
		String defList[];
		termList = new String[wordList.split(";").length / 2];
		defList = new String[wordList.split(";").length / 2];
		makearray(wordList.split(";"), termList, defList);
		String aTerm[];
		String aDef[];
		aTerm = new String[aWordList.split(";").length / 2];
		aDef = new String[aWordList.split(";").length / 2];
		makearray(aWordList.split(";"), aTerm, aDef);
		String iTerm[];
		String iDef[];
		iTerm = new String[iWordList.split(";").length / 2];
		iDef = new String[iWordList.split(";").length / 2];
		makearray(iWordList.split(";"), iTerm, iDef);
		String mTerm[];
		String mDef[];
		mTerm = new String[mWordList.split(";").length / 2];
		mDef = new String[mWordList.split(";").length / 2];
		makearray(mWordList.split(";"), mTerm, mDef);
		String chosenWord = "";
		String chosenFood = "";
		String chosenFoodDef = "";
		int randIdx = 0;
		if (cuisine == 1) {
			chosenWord = "American";
			randIdx = (int) Math.round(Math.random() * (aTerm.length - 1));
			chosenFood = aTerm[randIdx];
			chosenFoodDef = aDef[randIdx];

		} else if (cuisine == 2) {
			chosenWord = "Mexican";
			randIdx = (int) Math.round(Math.random() * (mTerm.length - 1));
			chosenFood = mTerm[randIdx];
			chosenFoodDef = mDef[randIdx];
		} else if (cuisine == 3) {
			chosenWord = "Indian";
			randIdx = (int) Math.round(Math.random() * (iTerm.length - 1));
			chosenFood = iTerm[randIdx];
			chosenFoodDef = iDef[randIdx];

		} else {
			chosenWord = "all kinds of foods";
			randIdx = (int) Math.round(Math.random() * (termList.length - 1));
			chosenFood = termList[randIdx];
			chosenFoodDef = defList[randIdx];
		}
		System.out.println("Cooking is so much fun but it can be difficult to read recipes due to the strange vocabulary. Since you love " + chosenWord +" cuisine want to learn some cool vocabulary words related to it(press 1) or learn some food terms in general (press 2). If you don't wanna talk to me press 3 :( ");

		Scanner input = new Scanner(System.in);
		String found = "";
		String userInput = input.nextLine();
		while(!userInput.equals("3")) {
            if (userInput.equals("1")) {
				System.out.println("So do you know what " + chosenFood + " means?");
				userInput = input.nextLine();
				if (userInput.toLowerCase().equals("no")) {
					System.out.println(chosenFood + ": " + chosenFoodDef);
                    System.out.println("want another word (press 1) or type a word you want the defenition to. If I know what it means I'll tell you");
                    if(input.nextLine().equals("1"))
                    {

                    }
                } else if (userInput.toLowerCase().equals("yes")) {
					System.out.println(generatePositiveComment(pos));
				} else {
					System.out.println("I'll take that as a no... " + chosenFood + " : " + chosenFoodDef);
				}
			}
			else if (userInput.equals("2"))
			{
				System.out.println("Type in a word and lets see if I know the answer");
                userInput = input.nextLine();
				found = find(userInput, termList,defList,aTerm,aDef,iTerm,iDef,mTerm,mDef,pos);
				System.out.println(found);
				System.out.println("press 33 anytime to leave");
			}
		}
		ChatBotRunner.main(pos);


	/*	catch (InputMismatchException e)
		{
			System.out.println("Well you either know it or you don't...Do you know what it means?");
			input = input.next();
		}
	}*/
		/**
		 * Gives a response to a user statement
		 *
		 * @param statement
		 *            the user statement
		 * @return a response based on the rules given
		 */
	}
public String find(String word, String[]listOne,String[] oneDef,String[]listTwo,String[] twoDef,String[]listThree,String[] threeDef,String[]listFour,String[] fourDef,String[] phrase)
{
	for(int x = 0; x<listOne.length;x++){
	if(listOne[x].equals(word))
	{
		return oneDef[x];
	}
	}
	for(int x = 0; x<listTwo.length;x++){
		if(listTwo[x].equals(word))
		{
			return twoDef[x];

		}
	}
	for(int x = 0; x<listThree.length;x++){
		if(listThree[x].equals(word))
		{
			return threeDef[x];

		}
	}
	for(int x = 0; x<listOne.length;x++){
		if(listThree[x].equals(word))
		{
			return fourDef[x];

		}
	}
	System.out.println("uhh I dont know what that means. Can you tell me");
	Scanner ans = new Scanner(System.in);
	if (ans.nextLine().length() == 0)
	{
		return "Say something, please.";
	}

	else if (findKeyword(ans.nextLine(), "no") >= 0)
	{
		return"Why so negative?";
	}
	else
	{
		return generatePositiveComment(phrase);
	}
}
	public static String generatePositiveComment(String[] phrases)
		{
			int posIdx = (int)Math.round(Math.random()*phrases.length-1);
			return phrases [posIdx];
		}
	public static void makearray (String[] list, String[] listOne, String[] listTwo)
    {
		int idxOne = 0;
        int idxTwo = 0;
        if(list.length % 2 == 0) {
			for (int x = 0; x < list.length; x++) {

				if (x % 2 == 0) {
					listOne[idxOne] = list[x].trim().toLowerCase();
					idxOne++;
				} else {
					listTwo[idxTwo] = list[x].trim().toLowerCase();
					idxTwo++;
				}

			}
		}
		else
		{
			for (int x = 0; x < list.length-1; x++) {

				if (x % 2 == 0) {
					listOne[idxOne] = list[x].trim().toLowerCase();
					idxOne++;
				} else {
					listTwo[idxTwo] = list[x].trim().toLowerCase();
					idxTwo++;
				}

			}
		}

    }
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

		}

		else if (findKeyword(statement, "levin") >= 0)
		{
			response = "More like LevinTheDream amiright?";

		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "i want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if (findKeyword(statement, "like watching",0) >= 0)
		{
			response = transformLikeWatchingStatement(statement);
		}
		else if (findKeyword(statement, "favorite food is",0) >= 0)
		{
			response = transformFavoriteFoodIsStatement(statement);
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
	private String transformLikeWatchingStatement(String statement)
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
		return "Is " + restOfStatement + " a Baking or Cooking show?";
	}
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
	private String transformFavoriteFoodIsStatement(String statement)
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
