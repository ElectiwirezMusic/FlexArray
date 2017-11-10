public class FlexArrayPrimitive {
	
	private int mySize;
	
	private int [] myArray;
	
	// constructors are missing
	// array is not initialized
	public FlexArrayPrimitive(){
		myArray = new int[20];
		mySize = 0;
	}
	public FlexArrayPrimitive(int myArraySize){
		myArray = new int[myArraySize];
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
		
		if(mySize >= myArray.length )
			resize();
		myArray[mySize] = data;
		mySize++;
	}
	
	public void insert(int index, int data){
		if(index < 0)
			return;
		if(index>= mySize){
			append(data);
			return;
		}
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
		if(index < 0)
			return -999;
		if(index >= mySize)
			return -999;
		moveElementsBACKWARDS(index);
		return myArray[index];
		
	}
	private void moveElementsBACKWARDS(int index){
		// start at the location and go till end of valid data and move the elements
		for(int i = index; i < (mySize-1) ; i++ )
			myArray[i] = myArray[i+1];
		mySize--;
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i < mySize; i++) {
			if(i > 0)
				str += ", " ;
			str += String.valueOf(myArray[i]);
		}
		return "[" + str + "]";
		
	}
	private void resize(){
		resize(5);
	}
	
	private void resize(int grownAmount){
		int [] intArr = new int [myArray.length + grownAmount];
		
		int j = 0 ;
		for(int i : myArray)
			intArr[j++] = i ;
		myArray = intArr;
	}
}
