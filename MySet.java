package myMath;

public class MySet implements MyMath<MySet>{

	private int[] setArray;

	public MySet(int[] array){
		int count = 0;
		int k = 0;
		boolean duplicate;
		boolean unique;

		for (int i = 0 ; i < array.length ; i++) {
			duplicate = false;
			for (int j = i + 1 ; j < array.length ; j++) {
				if (array[i] == array[j]) {
					duplicate = true;
				}
			}
			if (duplicate) {
				count++;
			}
		}
		this.setArray = new int[array.length - count];

		for (int i = 0 ; i < array.length ; i++) {
			unique = true;
			for (int j = i + 1 ; j < array.length ; j++) {
				if (array[i] == array[j]) {
					unique = false;
				} 
			}
			if (unique) {
				k++;
				setArray[(k - 1)] = array[i];
			}
		}
	}
	
	public int[] getSetArray() {
		return setArray;
	}
	
	@Override
	public MySet add(MySet o) {
		int[] addedArray = new int[this.setArray.length + o.setArray.length]; //creates a new array the size of both sets combined

		for(int i = 0; i < this.setArray.length; i++){ //adds the current set into the new Array
			addedArray[i] = this.setArray[i];
		}
		for(int i = this.setArray.length; i < addedArray.length; i++){ //adds the object inputed set into the new Array
			addedArray[i] = o.setArray[i-this.setArray.length];
		}
		
		return new MySet(addedArray); // will be sorted in the duplicationChecker method
	}

	@Override
	public MySet subtract(MySet o) {
		int uniqueSize = 0;
		boolean existInO; //create a boolean to check if the 1st set's number exist inside the second set
		
		for(int i = 0; i < this.setArray.length; i++){ // loop to check if the number exist inside the second set
			existInO = false; //default is that it does not exist
			for(int j = 0; j < o.setArray.length; j++){
				if(o.setArray[j] == this.setArray[i]){
					existInO = true; //true if the number in set 1 is equal to that of set 2
				}
			}

			if(!existInO){ //adds the number if they are not subtracted from the 1st set
				uniqueSize++;
			}

		}

		int[] subtractedArray = new int[uniqueSize];
		for(int i = 0; i < uniqueSize; i++){
			for(int j = 0; j < this.setArray.length; j++){ // loop to check if the number exist inside the second set
				existInO = false; //default is that it does not exist
				for(int k = 0; k < o.setArray.length; k++){
					if(o.setArray[k] == this.setArray[j]){
						existInO = true; //true if the number in set 1 is equal to that of set 2
					}
				}
				if(!existInO){ //adds the number if they are not subtracted from the 1st set
					subtractedArray[i] = this.setArray[j];
					if(i < uniqueSize){
						i++;
					}
				}
			}
		}

		return new MySet(subtractedArray); // will be sorted in the duplicationChecker method
	}

	@Override
	public MySet divide(MySet o) {
		int uniqueSize = 0;
		for(int i = 0; i < this.setArray.length; i++){ // loop to look for the numbers that are equal between the two sets
			for(int j = 0; j < o.setArray.length; j++){
				if(o.setArray[j] == this.setArray[i]){ // if the numbers are equal it will add the number to the new array
					uniqueSize++;
				}
			}
		}

		int[] dividedArray = new int[uniqueSize]; //creates a new array
		for(int i = 0; i < uniqueSize; i++){
			for(int j = 0; j < this.setArray.length; j++){ // loop to look for the numbers that are equal between the two sets
				for(int k = 0; k < o.setArray.length; k++){
					if(o.setArray[k] == this.setArray[j]){ // if the numbers are equal it will add the number to the new array
						dividedArray[i] = this.setArray[j];
						i++;
					}
				}
			}
		}
		
		return new MySet(dividedArray); // will be sorted in the duplicationCheck method
	}

	@Override
	public MySet multiply(MySet o) {
		int count = 0;
		int count2 = 0;
		int uniqueChecker = 0;
		int[] temp = new int[this.setArray.length + o.setArray.length];

		for(int i = 0; i < this.setArray.length; i++){
			temp[i] = this.setArray[i];
			count++;
		}


		for(int i = count; i < o.setArray.length + this.setArray.length; i++){
			temp[i] = o.setArray[count2];
			count2++;
		}

		boolean duplicate;
		boolean unique;
		int k = 0;

		for (int i = 0 ; i < temp.length ; i++) {
			duplicate = false;
			for (int j = i + 1 ; j < temp.length ; j++) {
				if (temp[i] == temp[j]) {
					duplicate = true;
				}
			}
			if (duplicate) {
				uniqueChecker++;
			}
		}

		int[] multipliedArray = new int[temp.length - uniqueChecker - uniqueChecker];
		
		for (int i = 0 ; i < temp.length ; i++) {
			unique = true;
			for (int j = i + 1 ; j < temp.length ; j++) {
				if (temp[i] == temp[j]) {
					temp[j] = ' ';
					unique = false;
				}
			}
			if (unique) {
				if(temp[i] != ' '){
					k++;
					multipliedArray[(k - 1)] = temp[i];
				}
			}
		}
		
		return new MySet(multipliedArray);
	}

	public String toString() {
		String output;

		if (this.setArray.length == 0) {
			output = "Empty";
		} else {
			output = "{" + setArray[0];

			for (int i = 1 ; i < setArray.length ; i++) {
				output += ", " + setArray[i];
			}

			output += "}";
		}

		return output;
	}
}
