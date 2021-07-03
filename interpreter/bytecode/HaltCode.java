package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode{
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine machine) {
        machine.halt();
    }

    @Override
    public  void dump (VirtualMachine machine){
        System.out.println("HALT");
    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return null;
    }
}
