package CartPackage;

public class Dao {
	public boolean isValidUser(String id,String pwd){
		
		if(id.equals("niit") && pwd.equals("niit"))
		{
			return true;
		}
		
		else
		{
			
			return false;
		}
	} 
}
