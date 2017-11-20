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
		if(mySize == 0)
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
	
	// A FlexArrayPrimitive will be compared by the sum of its active elements.
	// EXAMPLE:
	// flexy1.compareTo(flexy2) returns a negative int if the sum of the elements of
	// flexy1 < the sum of the elements of flexy2
	// flexy1.compareTo(flexy2) returns a zero if the sum of the elements are the same
	// flexy1.compareTo(flexy2) returns a positive int if the sum of the elements of
	// flexy1 > the sum of the elements of flexy2
	public int compareTo(FlexArrayPrimitive flexy){
		int sum = 0;
		int sum2 = 0;
		
		for(int i = 0; i < mySize; i++)
			sum = sum + myArray[i];
		for(int i = 0; i < flexy.mySize; i++)
			sum2 = sum2 + flexy.myArray[i];
		
		if(mySize < flexy.mySize)
			return -1;
		else if(mySize > flexy.mySize)
			return 1;
		return 0;
	}
	
	// A FlexArray object will be considered equal to another FlexArray if the quantity of
	// active elements are the same.
	// EXAMPLE: flexy1.equals(flexy2) returns true if the quantity of active elements
	// are the same; otherwise it returns false
	public boolean equals(FlexArrayPrimitive flexy){
		if(mySize == flexy.mySize)
			return true;
		return false;
	}
	
	//uses the bubble sort algorithm to sort the elements in the array
	public void sort(){
		//simple bubble sort 
		int n = mySize;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (myArray[j] > myArray[j+1])
                {
                	int temp = myArray[j];
                    myArray[j] = myArray[j+1];
                    myArray[j+1] = temp;
                }
	}
	
	//returns value at specified index
	public int getValue(int loc){
		return myArray[loc];
	}
	
	//using binary search to search the array for a specific  
	public int searchFor(int target){
		 int low = 0; 
		 int high = mySize - 1;
	        while (low <= high)
	        {
	            int mid = low + (high-low)/2;

	            if (myArray[mid] == target)
	                return mid;
	            
	            if (myArray[mid] < target)
	                low = mid + 1;
	            else
	                high = mid - 1;
	        }
	        //if target is not found return a negative number
	        return -1;
	}
}
