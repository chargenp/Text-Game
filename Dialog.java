
public class Dialog 
{
	private String mother;
	private String blacksmith;
	
	public Dialog()
	{
		mother = "\"Good morning, my child. Have you heard the aweful news? "
				+ "\nThe King’s daughter has been stolen and taken to the "
				+ "\nmysterious evil kingdom. She is in desperate need of help! "
				+ "\nCan you help save her? If so the blacksmith may be able to help you.\"\n";
		blacksmith = "So you're looking to help save the princess? The journey is long and"
				+ "\nthe dangers are many. The items you have are far less than plenty. I will"
				+"\nmake you a sword to help you throughout your journey.\n";
	}
	
	public String getMother()
	{
		return mother;
	}
	
	public String getBlacksmith()
	{
		return blacksmith;
	}
}
