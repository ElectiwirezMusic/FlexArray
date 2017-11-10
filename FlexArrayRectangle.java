public class FlexArrayRectangle {
	
	private int mySize;
	
	private Rectangle[] myArray;
	
	// constructors are missing
	// array is not initialized
	public FlexArrayRectangle(){
		myArray = new Rectangle[20];
		mySize = 0;
	}
	public FlexArrayRectangle(int myArraySize){
		myArray = new Rectangle[myArraySize];
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

	public void append(Rectangle data){
		
		if(mySize >= myArray.length )
			resize();
		myArray[mySize] = data;
		mySize++;
	}
	
	public void insert(int index, Rectangle data){
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
	
	public int discard(int index){
		if(index >= mySize)
			return -999;
		moveElementsBACKWARDS(index);
		return index;
		
	}
	private void moveElementsBACKWARDS(int index){
		for(int i = index; i <= 0; i-- )
			myArray[i-1] = myArray[i];
		mySize--;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder() ;
		
		for(int i = 0; i < mySize; i++){
			sb.append(myArray[i].toString());
			if(i < mySize -1)
				sb.append("\n");
		}
		return "[" + sb.toString() + "]";
		
	}
	private void resize(){
		resize(5);
	}
	
	private void resize(int grownAmount){
		Rectangle [] rectArr = new Rectangle [myArray.length + grownAmount];
		
		int j = 0 ;
		for(Rectangle i : myArray)
			rectArr[j++] = i ;
		myArray = rectArr;
	}

}
