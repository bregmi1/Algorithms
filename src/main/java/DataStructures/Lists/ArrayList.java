package DataStructures.Lists;

/*
Simple implementation of integer ArrayList using Array
 */

public class ArrayList{
    private int[] array;
    private int size;    //represents the current size of the array i.e. how many elements are present in the array

    public ArrayList(){
        array = new int[10];
        size = 0;
    }

    public ArrayList(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Initial capacity of the ArrayList cannot be negative number");
        }
        array = new int[initialCapacity];
        size = 0;
    }

    public void add(int value){
        if(size == array.length){
            expandArray(size);
        }
        array[size++] = value;
    }


    public int remove(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound.");
        }
        int temp = array[index];
        for(int i= index; i < size-1; i++){
            array[i] = array[i+1];
        }
        size--;
        return temp;
    }

    public int get(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound.");
        }
        return array[index];
    }

    public void clear(){
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public void expandArray(int originalSize){
        int newSize = 0;
        if(originalSize < 2){
            newSize = 2;
        } else {
            newSize = originalSize + (originalSize >> 1); //new size is 1.5 times original size
        }
        int[] newArray = new int[newSize];

        for(int i=0 ;i < originalSize; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }
}