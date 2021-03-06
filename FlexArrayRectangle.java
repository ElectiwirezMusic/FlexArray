//Name: Tushar Shrivastav
//
//Period: 2
//
//Class Description: implements different methods which manipulates an array of rectangles.
public class FlexArrayRectangle {
	
	//declaring private data members
	private int mySize;
	
	private Rectangle[] myArray;
	
	//defualt constructor
	public FlexArrayRectangle(){
		myArray = new Rectangle[20];
		mySize = 0;
	}
	//accepts a size for an array (contructor)
	public FlexArrayRectangle(int myArraySize){
		myArray = new Rectangle[myArraySize];
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
	public void append(Rectangle data){
		
		if(mySize >= myArray.length )
			resize();
		myArray[mySize] = data;
		mySize++;
	}
	//inserts data at the the specified index
	public void insert(int index, Rectangle data){
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
	public Rectangle discard(int index){
		if(index >= mySize)
			return null;
		moveElementsBACKWARDS(index);
		return myArray[index];
		
	}
	//moves elements backwards so the order can be kept in discard method
	private void moveElementsBACKWARDS(int index){
		for(int i = index; i < (mySize-1) ; i++ )
			myArray[i] = myArray[i+1];
		mySize--;
	}
	//converts the array into a string that can be outputted to the monitor
	public String toString(){
		StringBuilder sb = new StringBuilder() ;
		
		for(int i = 0; i < mySize; i++){
			sb.append(myArray[i].toString());
			if(i < mySize -1)
				sb.append("\n");
		}
		return "[" + sb.toString() + "]" + "\n" ;
	}
	//resizes the array using the other resize method
	private void resize(){
		resize(5);
	}
	//resizes the array to accommodate for more values
	private void resize(int grownAmount){
		Rectangle [] rectArr = new Rectangle [myArray.length + grownAmount];
		
		int j = 0 ;
		for(Rectangle i : myArray)
			rectArr[j++] = i ;
		myArray = rectArr;
	}
	public void sort(){
		//simple bubble sort 
		int n = mySize;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (myArray[j].compareTo(myArray[j+1]) == 1)
                {
                	Rectangle temp = myArray[j];
                    myArray[j] = myArray[j+1];
                    myArray[j+1] = temp;
                }
	}
	
	//returns value at specified index
	public Rectangle getValue(int loc){
		return myArray[loc];
	}
	
	//using binary search to search the array for a specific  
	public int searchFor(Rectangle target){
		 int low = 0; 
		 int high = mySize - 1;
	        while (low <= high)
	        {
	            int mid = low + (high-low)/2;

	            if (myArray[mid].equals(target))
	                return mid;
	            
	            if (myArray[mid].compareTo(target) == -1)
	                low = mid + 1;
	            else
	                high = mid - 1;
	        }
	        //if target is not found return a negative number
	        return -1;
	}
	public int compareTo(Rectangle rectangle) {
		// TODO Auto-generated method stub
		return 0;
	}
}
