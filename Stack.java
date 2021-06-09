package Buffet;

//All methods are public so stack can be accessed easily, but the data about the stack is private.
public class Stack {
    private int top;
    //arr is the values in the stack
    private int[] arr;
    private int size;

    //constructor that takes in size to create a stack, a stack needs a declared size in my program.
    public Stack(int size){
        //top has the default value of -1 to signify it is empty. This is important for the boolean methods.
        this.top = -1;
        this.arr = new int[size];
        this.size = size;
    }

    //checks if the stack is empty.
    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    //checks if the stack is full.
    public boolean isFull(){
        //subtracted 1 from the size because arrays start at index 0, not 1.
        if (this.top == this.size-1){
            return true;
        } else{
            return false;
        }
    }

    //pushes a specified value onto the stack unless its full.
    public void push(int x){
        //Buffet.Stack will not be affected unless its not full.
        if (isFull()){
            //This print statement is mostly for debugging purposes and if no case is made in the program it is used in for when the stack is full.
            System.out.println("Error cannot push, stack is full.");
        } else{
            //adds to the top before altering any values because top starts at -1 which isn't a valid index
            this.top++;
            this.arr[this.top] = x;
        }
    }

    //pops top value from the stack and returns it. If the stack is empty it will just return -1.
    public int pop(){
        if(isEmpty()){
            //This is mostly for debugging purposes if the program doesn't already compensate for this case.
            System.out.println("Error cannot pop, stack is empty");
            return -1;
        } else{
            //stores the top value in an integer before decrementing top so the top value is preserved for the return statement.
            int element = this.arr[this.top];
            this.top--;
            return element;
        }
    }

    //returns the value on the top of the stack without taking it out. Returns -1 if the stack is empty.
    public int peek(){
        //Buffet.Stack must not be empty for a valid value to be returned
        if(!(isEmpty())){
            return this.arr[this.top];
        } else{
            //These statements are mostly for debugging in case the program it's used in does not compensate for the case of an empty stack.
            System.out.println("Error cannot peek, stack is empty");
            return -1;
        }
    }
}
