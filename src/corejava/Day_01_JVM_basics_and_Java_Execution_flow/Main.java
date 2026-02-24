package corejava.Day_01_JVM_basics_and_Java_Execution_flow;

public class Main {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("Value of x: " + x);
    }
}

//1️⃣ Stack
//Stack stores:
//Local variables
//Method parameters
//References to objects
//Method call frames

//2️⃣ Heap
//Heap stores:
//Objects
//Instance variables
//Object data

//3️⃣ Method Area (Metaspace)
//This is where:
//Class metadata
//Method definitions
//Method signatures
//Static variables
//Constant pool
//Bytecode