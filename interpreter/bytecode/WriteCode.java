package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode{
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine machine) {
        System.out.println(machine.peekRunTimeStack());
    }

    @Override
    public void dump(VirtualMachine machine) {
        System.out.println("WRITE");
    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return null;
    }
}
