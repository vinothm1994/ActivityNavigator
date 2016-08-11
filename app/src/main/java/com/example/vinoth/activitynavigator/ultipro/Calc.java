package com.example.vinoth.activitynavigator.ultipro;

public class Calc {
	
	public static int [] naturalNumer(int size){
		
		int array []=new int[size];
		for(int count=0;count<size;count++)
		{
		 array[count]=count+1;
	
		}
		return array;
	}
public static int[] randomNumber(int size) {
    int array []=new int[size];
	for(int count=0;count<size;count++)
	{
	 
		 array[count]=(int) (Math.random()*1000);
	}
	return array;
}

public static int [] reverseNumber( int[] array){
	
	int index=0;
	for(int count=array.length;count>0;count--)
	{
	 array[index++]=count;

	}
	return array;
}

public static int[] bubblesort(int[] array) {
	
	
       
        int n = array.length;
        int temp = 0;
       
        for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                       
                        if(array[j-1] > array[j]){
                                //swap the elements!
                                temp = array[j-1];
                                array[j-1] = array[j];
                                array[j] = temp;
                        }
                       
                }
        }

	return array;
}


public static int[] selectionsort(int[] arr) {    
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
      
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }

public static int[] insertion(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    
                }
            }
        }
        return arr;
    }
    public static void printarray(int[] array){
	
	for (int i = 0; i < array.length; i++) {
		System.out.println(array[i]);
	}
	
}
}
