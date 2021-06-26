package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
     /**
      * Used for dumping the current state of the runTimeStack .
      * It will print portions of the stack based on respective
      * frame markers .
      * Example [1 ,2 ,3] [4 ,5 ,6] [7 ,8]
      * Frame pointers would be 0 ,3 ,6
      */
             public void dump () { }

         /**
  * returns the top of the runtime stack , but does not remove
  * @return copy of the top of the stack .
  */
         public int peek () {
             return runTimeStack.get(runTimeStack.size() - 1);
         }

         /**
  * push the value i to the top of the stack .
  * @param i value to be pushed .
  * @return value pushed
  */
         public int push ( int i ) {
             runTimeStack.add(i);
             return i;
         }

         /**
  * removes to the top of the runtime stack .
  * @return the value popped .
  */
         public int pop () { }
 /**
  * Takes the top item of the run time stack , and stores
  * it into a offset starting from the current frame .
  * @param offset number of slots above current frame marker
  * @return the item just stored
  */
         public int store ( int offset ) {
             runTimeStack.set(framePointer.peek() + offset, pop());
         }
 /**
  * Takes a value from the run time stack that is at offset
  * from the current frame marker and pushes it onto the top of
  * the stack .
  * @param offset number of slots above current frame marker
  * @return item just loaded into the offset
  */
         public int load ( int offset ) { }

         /**
  * create a new frame pointer at the index offset slots down
  * from the top of the runtime stack .
  * @param offset slots down from the top of the runtime stack
  */
         public void newFrameAt ( int offset ) { }

         /**
  * pop the current frame off the runtime stack . Also removes
  * the frame pointer value from the FramePointer Stack .
  */
         public void popFrame () { }

}
