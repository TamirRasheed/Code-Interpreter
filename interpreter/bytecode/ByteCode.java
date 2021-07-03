package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {

        public abstract void init(ArrayList<String> args);

        public abstract void execute(VirtualMachine machine);

        public abstract void dump (VirtualMachine machine);

        public abstract void setAddress(int address); //note this wont be used all the time

        public abstract String getLabel(); //Note wont be used at all times but needed for some of the bytecodes
}
