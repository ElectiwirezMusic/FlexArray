public class FlexArrayRectangle {
	
	private int mySize;
	
	private Rectangle [] myArray;
	
	// constructors are missing
	// array is not initialized
	public FlexArrayRectangle(){
		myArray = new Rectangle[20];
		mySize = 0;
	}
	public FlexArrayRectangle(int myArraySize){
		myArray = new Rectangle [myArraySize];
		mySize = 0;
	}
	
	public int getLength(){
		return mySize;
	}
	
	public boolean isEmpty(){
		
		if( mySize == 0)
			return true;
		return false;
	}

	public void append(int data){
		
		if(mySize >= myArray.length ){
			//System.out.println(this);
			resize();
			//System.out.println(this);
		}
		
		myArray[mySize] = data;
		mySize++;
	}
	
	public void insert(int index, Rectangle data){
		if(index>= mySize)
			append(data);
		
		moveElementsFORWARD(index);
		myArray[index] = data;
		
	}
	
	private void moveElementsFORWARD(int index) {
		for(int i = mySize - 1; i >= index; i--)
			myArray[i+1] = myArray[i];
		mySize++;
	}
	
	// [1][2][3][<>][]
	public int discard(int index){
		if(index >= mySize)
			return -999;
		moveElementsBACKWARDS(index);
		return index;
		
	}
	private void moveElementsBACKWARDS(int index){
		// start at the location and go till end of valid data and move the elements
		for(int i = index; i < (mySize-1) ; i++ )
			myArray[i] = myArray[i+1];
		mySize--;
	}
	
	public String toString(){
		String str = "";
		for(Rectangle i : myArray) {
			str += " " ;
			str += String.valueOf( i );
		}
		return str;
		
	}
	private void resize(){
		int [] intArr = new int [myArray.length + 1];
		
		int j = 0 ;
		for(int i : myArray)
			intArr[j++] = i ;
		myArray = intArr;
	}
	
	private void resize(int grownAmount){
		int [] intArr = new int [myArray.length + grownAmount];
		
		int j = 0 ;
		for(Rectangle i : myArray)
			intArr[j++] = i ;
		myArray = intArr;
	}
}
