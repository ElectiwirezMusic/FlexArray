//Name: Tushar Shrivastav
//
//Period: 2
//
//Class Description: implements different methods which manipulates an array of integers.
public class FlexArrayPrimitive {
	
	//declaring private data members
	private int mySize;
	private int [] myArray;
	
	//defualt constructor
	public FlexArrayPrimitive(){
		myArray = new int[20];
		mySize = 0;
	}
	//accepts a size for an array (contructor)
	public FlexArrayPrimitive(int myArraySize){
		myArray = new int[myArraySize];
		mySize = 0;
	}
	//returns the logical length of the array
	public int getLength(){
		return mySize;
	}
	//returns true if the array is logically empty
	public boolean isEmpty(){
		
		if( mySize == 0)
			return true;
		return false;
	}
	//adds data to the end of the array
	public void append(int data){
		
		if(mySize >= myArray.length )
			resize();
		myArray[mySize] = data;
		mySize++;
	}
	//inserts data at the the specified index
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
	//moves elements forward to keep the elements in order while inserting
	private void moveElementsFORWARD(int index) {
		for(int i = mySize - 1; i >= index; i--)
			myArray[i+1] = myArray[i];
		mySize++;
	}
	
	//removes the element at the specified index
	public int discard(int index){
		if(index < 0)
			return -999;
		if(index >= mySize)
			return -999;
		moveElementsBACKWARDS(index);
		return myArray[index];
		
	}
	//moves elements backwards so the order can be kept in discard method
	private void moveElementsBACKWARDS(int index){
		// start at the location and go till end of valid data and move the elements
		for(int i = index; i < (mySize-1) ; i++ )
			myArray[i] = myArray[i+1];
		mySize--;
	}
	//converts the array into a string that can be outputted to the monitor
	public String toString(){
		String str = "";
		for(int i = 0; i < mySize; i++) {
			if(i > 0)
				str += ", " ;
			str += String.valueOf(myArray[i]);
		}
		return "[" + str + "]";
		
	}
	
	//resizes the array one element a time
	private void resize(){
		resize(5);
	}
	
	//resizes the array in steps of 
	private void resize(int grownAmount){
		int [] intArr = new int [myArray.length + grownAmount];
		
		// copy existing elements to the new Array
		int j = 0 ;
		for(int i : myArray)
			intArr[j++] = i ;
		
		// change the pointer to the new resized array
		myArray = intArr;
	}
}
