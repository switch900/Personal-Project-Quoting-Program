
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * This class keeps track of the point thicknesses for various paper types as
 * part of the master class Apak_Quoting. 
 * 
 * @author User
 */

public class Paper_Thicknesses {

	public InputReader reader;
	public String description;
	public Double pointThickness;
	public static HashMap<String, Double> paperWeightHashMap;

	public Paper_Thicknesses() {
		paperWeightHashMap = new HashMap<String, Double>();

	}

	public Paper_Thicknesses(String description, Double pointThickness) {
		setDescription(description);
		setPointThickness(pointThickness);
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		// System.out.print(
		// "Enter description for paper(Enter as Brand/Description/Weight in lbs (i.e.
		// Pacesetter Silk Text 100# : ");
		// reader = new InputReader();
		// description = reader.getStringInput();
		if (description != null && description.length() >= 0) {
			description = description.toUpperCase();
			this.description = description;
		}
	}

	/**
	 * @return the pointThickness
	 */
	public Double getPointThickness() {
		return pointThickness;
	}

	/**
	 * @param pointThickness
	 *            the pointThickness to set as a double
	 */
	public void setPointThickness(Double pointThickness) {
		// System.out.print("Paper thickness in points: ");
		// reader = new InputReader();
		// pointThickness = reader.getDoubleInput();
		if (pointThickness >= 0.0) {
			this.pointThickness = pointThickness;
		}
	}

	public void addPaper(String description, Double pointThickness) {
		if (description != null && pointThickness != null) {
			 paperWeightHashMap.put(description, new Double(pointThickness));
		}	
		}
		
		public static void addPaperAuto() {
			
			paperWeightHashMap.put(" None                     ", new Double(0.0));
			
			paperWeightHashMap.put("Pacesetter Silk Text .060#", new Double(3.2));
			paperWeightHashMap.put("Pacesetter Silk Text .070#", new Double(3.8));
			paperWeightHashMap.put("Pacesetter Silk Text .080#", new Double(4.3));
			paperWeightHashMap.put("Pacesetter Silk Text .100#", new Double(5.6));
			paperWeightHashMap.put("Pacesetter Silk Cover .080#", new Double(8.8));
			paperWeightHashMap.put("Pacesetter Silk Cover .100#", new Double(11.0));
			paperWeightHashMap.put("Pacesetter Silk Cover .111#", new Double(12.5));
			paperWeightHashMap.put("Pacesetter Silk Cover .130#", new Double(14.9));
			paperWeightHashMap.put("Pacesetter Gloss Text .060#", new Double(2.8));
			paperWeightHashMap.put("Pacesetter Gloss Text .070#", new Double(3.3));
			paperWeightHashMap.put("Pacesetter Gloss Text .080#", new Double(3.8));
			paperWeightHashMap.put("Pacesetter Gloss Text .100#", new Double(4.9));
			paperWeightHashMap.put("Pacesetter Gloss Cover .081#", new Double(7.8));
			paperWeightHashMap.put("Pacesetter Gloss Cover .100#", new Double(9.4));
			paperWeightHashMap.put("Pacesetter Gloss Cover .111#", new Double(11.4));
			paperWeightHashMap.put("Pacesetter Gloss Cover .130#", new Double(7.8));
			
			paperWeightHashMap.put("Cougar Smooth text .050#", new Double(4.0));
			paperWeightHashMap.put("Cougar Smooth text .060#", new Double(4.6));
			paperWeightHashMap.put("Cougar Smooth text .080#", new Double(5.2));
			paperWeightHashMap.put("Cougar Smooth text .100#", new Double(5.9));
			paperWeightHashMap.put("Cougar Smooth cover .065#", new Double(8.8));
			paperWeightHashMap.put("Cougar Smooth cover .080#", new Double(10.9));
			paperWeightHashMap.put("Cougar Smooth cover .100#", new Double(13.9));
			paperWeightHashMap.put("Cougar Smooth cover .110#", new Double(14.7));
			paperWeightHashMap.put("Cougar Smooth cover .130#", new Double(17.6));
			paperWeightHashMap.put("Cougar Smooth cover .160#", new Double(21.8));
			
			paperWeightHashMap.put("Sterling Dull Text .080#", new Double(3.6));
			paperWeightHashMap.put("Sterling Dull Text .100#", new Double(4.7));
			paperWeightHashMap.put("Sterling Dull Cover .80#", new Double(7.6));
			paperWeightHashMap.put("Sterling Dull Cover .100#" , new Double(9.9));
			paperWeightHashMap.put("Sterling Dull Cover .120#", new Double(12.4));
			paperWeightHashMap.put("Sterling Gloss Text .80#", new Double(3.55));
			paperWeightHashMap.put("Sterling Gloss Text .100#", new Double(4.5));
			paperWeightHashMap.put("Sterling Gloss Cover .80#", new Double(7.4));
			paperWeightHashMap.put("Sterling Gloss Cover .100#", new Double(9.3));
			
			paperWeightHashMap.put("Lynx Opaque text .040#", new Double(3.1));
			paperWeightHashMap.put("Lynx Opaque text .045#", new Double(3.6));
			paperWeightHashMap.put("Lynx Opaque text .050#", new Double(3.8));
			paperWeightHashMap.put("Lynx Opaque text .060#", new Double(4.6));
			paperWeightHashMap.put("Lynx Opaque text .070#", new Double(5.2));
			paperWeightHashMap.put("Lynx Opaque text .080#", new Double(6.1));
			paperWeightHashMap.put("Lynx Opaque text .100#", new Double(7.7));
			paperWeightHashMap.put("Lynx Opaque cover .065#", new Double(8.8));
			paperWeightHashMap.put("Lynx Opaque cover .080#", new Double(11));
			paperWeightHashMap.put("Lynx Opaque cover .100#", new Double(14.1));
			
			paperWeightHashMap.put("Topkote gloss text .070#", new Double(3.3));
			paperWeightHashMap.put("Topkote gloss text .080#", new Double(3.7));
			paperWeightHashMap.put("Topkote gloss text .100#", new Double(5.0));
			paperWeightHashMap.put("Topkote gloss cover .078#", new Double(8.0));
			paperWeightHashMap.put("Topkote gloss cover .095#", new Double(10.2));
			paperWeightHashMap.put("Topkote gloss cover .111#", new Double(12.2));
			paperWeightHashMap.put("Topkote gloss cover .130#", new Double(14.3));
			paperWeightHashMap.put("Topkote dull text .070#", new Double(3.5));
			paperWeightHashMap.put("Topkote dull text .080#", new Double(4.1));
			paperWeightHashMap.put("Topkote dull text .100#", new Double(5.3));
			paperWeightHashMap.put("Topkote dull cover .078#", new Double(8.2));
			paperWeightHashMap.put("Topkote dull cover .095#", new Double(10.3));
			paperWeightHashMap.put("Topkote dull cover .111#", new Double(12.3));
			paperWeightHashMap.put("Topkote dull cover .130#", new Double(14.8));
			
			paperWeightHashMap.put("Husky text 50#/20#", new Double(3.9));
			paperWeightHashMap.put("Husky text 60#/24#", new Double(4.6));
			paperWeightHashMap.put("Husky text 70#/28#", new Double(5.3));
			paperWeightHashMap.put("Husky text 80#", new Double(5.9));
			
			paperWeightHashMap.put("Futura Laser gloss text .080#", new Double(4.3));
			paperWeightHashMap.put("Futura Laser gloss text .100#", new Double(5.4));
			paperWeightHashMap.put("Futura Laser gloss cover .080#", new Double(8.2));
			paperWeightHashMap.put("Futura Laser gloss cover .100#", new Double(10.3));
			paperWeightHashMap.put("Futura Laser gloss cover .120#", new Double(11.5));
			paperWeightHashMap.put("Futura Laser dull text .080#", new Double(4.3));
			paperWeightHashMap.put("Futura Laser dull text .100#", new Double(5.4));
			paperWeightHashMap.put("Futura Laser dull cover .080#", new Double(8.2));
			paperWeightHashMap.put("Futura Laser dull cover .100#", new Double(10.3));
			paperWeightHashMap.put("Futura Laser matte text .080#", new Double(4.8));
			paperWeightHashMap.put("Futura Laser matte text .100#", new Double(6.1));
			paperWeightHashMap.put("Futura Laser matte cover .080#", new Double(9.4));
			paperWeightHashMap.put("Futura Laser matte cover .100#", new Double(11.9));	
			
			paperWeightHashMap.put("Rolland Enviro Satin text .050#", new Double(3.0));	
			paperWeightHashMap.put("Rolland Enviro Satin text .060#", new Double(3.7));
			paperWeightHashMap.put("Rolland Enviro Satin text .070#", new Double(4.4));
			paperWeightHashMap.put("Rolland Enviro Satin text .080#", new Double(5.0));
			paperWeightHashMap.put("Rolland Enviro Satin cover .065#", new Double(8.5));
			paperWeightHashMap.put("Rolland Enviro Satin cover .080#", new Double(10.4));
			paperWeightHashMap.put("Rolland Enviro Satin cover .100#", new Double(12.8));
			
			paperWeightHashMap.put("Rolland Enviro Print/Digital text .040#", new Double(3.0));
			paperWeightHashMap.put("Rolland Enviro Print/Digital text .045#", new Double(3.3));
			paperWeightHashMap.put("Rolland Enviro Print/Digital text .050#", new Double(3.7));
			paperWeightHashMap.put("Rolland Enviro Print/Digital text .060#", new Double(4.4));
			paperWeightHashMap.put("Rolland Enviro Print/Digital text .070#", new Double(5.1));
			paperWeightHashMap.put("Rolland Enviro Print/Digital text .080#", new Double(5.9));
			paperWeightHashMap.put("Rolland Enviro Print/Digital text .100#", new Double(7.0));
			paperWeightHashMap.put("Rolland Enviro Print/Digital text .120#", new Double(8.3));
			paperWeightHashMap.put("Rolland Enviro Print/Digital cover .065#", new Double(8.5));
			paperWeightHashMap.put("Rolland Enviro Print/Digital cover .080#", new Double(10.4));
			paperWeightHashMap.put("Rolland Enviro Print/Digital cover .100#", new Double(12.8));
			
			paperWeightHashMap.put("Coronado Super Smooth text .070#", new Double(4.2));
			paperWeightHashMap.put("Coronado Super Smooth text .080#", new Double(4.8));
			paperWeightHashMap.put("Coronado Super Smooth text .100#", new Double(6.1));
			paperWeightHashMap.put("Coronado Super Smooth cover .080#", new Double(9.5));
			paperWeightHashMap.put("Coronado Super Smooth cover .100#", new Double(11.5));
			paperWeightHashMap.put("Coronado Super Smooth cover DTC .100#", new Double(11.5));
			paperWeightHashMap.put("Coronado Super Smooth cover DTC .130#", new Double(14.5));
			
			
			
						
		}
		
	/**
	 * Print all the paper types with their point thicknesses
	 */
	public static void displayAllPaper() {
		if (paperWeightHashMap != null) {
			Map<String, Double> sorted = new TreeMap<>(paperWeightHashMap);
			Set<String> paper = sorted.keySet();
			for (String index : paper) {
				System.out.println(index + ": " + paperWeightHashMap.get(index));
			}
		}
	}
}


