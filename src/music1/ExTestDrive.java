package music1;

class MyEx extends Exception{}

public class ExTestDrive {

	public static void main(String[] args) {
		//fake cmd lin argument
		args = new String[1];
		args[0] = "no";
		
		String test = args[0];
		
		try{
			System.out.println("t");
			
			doRisry(test);
			System.out.println("o");
		}catch(MyEx e){
			System.out.println("a");
			
		}finally{
			System.out.println("w");
		}
		System.out.println("s");

	}

	static void doRisry(String t)throws MyEx{
		System.out.println("h");
		if("yes".equals(t)){
			throw new MyEx();
		}
		System.out.println("r");
	}
}

