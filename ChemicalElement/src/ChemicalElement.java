import java.util.Arrays;
public class ChemicalElement {
	
	String symbolicName;
	int atomicNumber;
	String fullName;
	
	public ChemicalElement(String symbolicName, int atomicNumber, String fullName) {
		this.symbolicName = symbolicName;
		this.atomicNumber = atomicNumber;
		this.fullName = fullName;
	}
	
	public boolean equals(Object o){
		ChemicalElement other = (ChemicalElement) o;
		
		return true ;
	}
	
	public String isAlkaliMetal(int atomicNumber) {
		String a="false"; 
		switch(atomicNumber) {
		case 3:
		a=(String)"true";
		case 11:
		a=(String)"true";
		case 19:
			a=(String)"true";
		case 37:
			a=(String)"true";
		case 55:
			a=(String)"true";
		case 87:
			a=(String)"true";
			/*
			 * default: a = (String)"False";
			 */
		}
		return a;
	}
	public Boolean isTransitionMetal(int atomicNumber) {
		
		boolean array[];
		array = new boolean[115];
		Arrays.fill(array, false);
		array[21] = true; 
		array[22]=true;
		array[23] = true; 
		array[24]=true;
		array[25] = true; 
		array[26]=true;
		array[27] = true; 
		array[28]=true;
		array[29] = true; 
		array[30]=true;
		return array[atomicNumber];
	}
	public String isMetal(int atomicNumber) {
		String a="false"; 
		switch(atomicNumber) {
		case 13:
		a=(String)"true";
		case 49:
		a=(String)"true";
		case 50:
			a=(String)"true";
		case 81:
			a=(String)"true";
		case 82:
			a=(String)"true";
		case 83:
			a=(String)"true";
		case 113:
			a=(String)"true";
		case 114:
			a=(String)"true";
		case 115:
			a=(String)"true";
		case 116:
			a=(String)"true";
			/*
			 * default: a = (String)"False";
			 */
		}
		return a;
	}
	
	public static void main(String[] args) {
		
	ChemicalElement metal = new ChemicalElement("H",22,"Hydrogen");
	System.out.println(metal.isAlkaliMetal(metal.atomicNumber));
	System.out.println(metal.isTransitionMetal(metal.atomicNumber));
	System.out.println(metal.isMetal(metal.atomicNumber));
	
	}

}
