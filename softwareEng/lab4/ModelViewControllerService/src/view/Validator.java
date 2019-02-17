package view;

public class Validator {

	public static boolean isValid(String name){
		String regx = "^[\\p{L} .'-]+$";
		String lessGoodregx = ".*\\d+.*"; //use this to check if there any numbers in the string
		
		if(!name.matches(lessGoodregx)){
			if (name.length() < 9)
			{
				if (!name.contains("or") && !name.contains("be") && !name.contains("an") && !name.contains("as"))
				{
					if (!(name.length() == 3))
					return true;
				}
			}
		}
		return false;
	}
	
}
