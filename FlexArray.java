public class FlexArray{
	public static void main(String[] args) {

		FlexArrayPrimitive prim = new FlexArrayPrimitive(5);
		
		prim.append(1);
		prim.append(2);
		prim.append(4);
		prim.append(5);
		

		System.out.println(prim);
		//prim.append(6);
		prim.insert(2, 3);
		prim.append(6);
		prim.append(7);
		prim.append(8);
		prim.append(9);
		prim.append(10);
		prim.append(11);
		prim.append(12);
		System.out.println(prim);

		prim.discard(0);
		System.out.println(prim);
		
		/*
		FlexArrayRectangle rect = new FlexArrayRectangle(5);

		rect.append(new Rectangle(1,1));
		rect.append(new Rectangle(6,8));
		rect.append(new Rectangle(3,7));
		rect.append(new Rectangle(4,5));
		System.out.println(rect);
		rect.insert(0, new Rectangle(6,8));
		System.out.println(rect);
		
		*/
		
		//resize() ;
		//delete 
	
	}
}