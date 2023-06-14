import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		
		dataDriven dd = new dataDriven();
		ArrayList<String> aa = dd.getData("Add Profile");
		//System.out.println(aa.get(0));
		for(String s:aa) {
			System.out.println(s);
		}
		
		
		
	}

}
