import java.lang.reflect.Field;

public class HeadFirstString {
	
	public static void main(String[] args) {
		String style1_1 = "HeadFirst";
		String style1_2 = "HeadFirst1";
		String style1_3 = "HeadFirst";
		System.out.println("string adrr : " + System.identityHashCode(style1_1));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style1_1));
		System.out.println("string adrr : " + System.identityHashCode(style1_2));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style1_2));
		System.out.println("string adrr : " + System.identityHashCode(style1_3));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style1_3));
		System.out.println("");
			
		String style2_1 = "Head" + "First";
		String style2_2 = "Head" + "First" + "1";
		System.out.println("string adrr : " + System.identityHashCode(style2_1));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style2_1));
		System.out.println("string adrr : " + System.identityHashCode(style2_2));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style2_2));
		System.out.println();
		
		String style3_1 = new String("HeadFirst");
		String style3_2 = new String("HeadFirst");
		String style3_3 = new String("HeadFirst1");
		System.out.println("string adrr : " + System.identityHashCode(style3_1));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style3_1));
		System.out.println("string adrr : " + System.identityHashCode(style3_2));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style3_2));
		System.out.println("string adrr : " + System.identityHashCode(style3_3));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style3_3));
		System.out.println("");
		
		String style4_1 = style1_1 + "1";
		String style4_2 = style3_1 + "1";
		System.out.println("string adrr : " + System.identityHashCode(style4_1));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style4_1));
		System.out.println("string adrr : " + System.identityHashCode(style4_2));
		System.out.println("char adrr : " + getAddressOfCharArrayInString(style4_2));
	}
	
	public static int getAddressOfCharArrayInString(String str) {
		try {
			Field field = str.getClass().getDeclaredField("value");
			field.setAccessible(true);
			return System.identityHashCode(field.get(str));		
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
