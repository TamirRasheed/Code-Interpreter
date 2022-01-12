package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        dumpChecker;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void halt(){
        isRunning = false;
    }
    public void executeProgram() {
            programCounter = 0;
            runTimeStack = new RunTimeStack();
            returnAddress = new Stack<Integer>();
            isRunning = true;

            while (isRunning){
                ByteCode code = program.getCode(programCounter);
                code.execute(this);
                programCounter++;
            }
    }
    public void newFrame(int num){
        runTimeStack.newFrameAt(num);
    }

    public void setCountOfArgsForDump(int countOfArgs){
        runTimeStack.setCountOfArgsForDump(countOfArgs);
    }

    public void popRunStackFrame(){
        runTimeStack.popFrame();
    }
    public int peekRunTimeStack(){
        return runTimeStack.peek();
    }
    public void pushRunTimeStack(int value) {
        runTimeStack.push(value);
    }
    public void loadRunTimeStack(Integer value) {
        runTimeStack.load(value);
    }
    public int popRunStack(){
        return runTimeStack.pop();
    }
    public void storeRunTimeStack(int value){
        runTimeStack.store(value);
    }
    public void setProgramCounter(int value){
        programCounter = value;
    }
    public void saveProgramCounter(){
        pushRunTimeStack(programCounter);
    }
    public void returnProgramCounter(){setProgramCounter(returnAddress.pop());}
    public void dump(boolean dump){
        dumpChecker = dump;
    }
}
