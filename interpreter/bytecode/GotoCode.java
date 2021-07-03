package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode{
    private String label;
    private int givenAddress;
    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine machine) {
        machine.setProgramCounter(givenAddress - 1);
    }

    @Override
    public  void dump (VirtualMachine machine){
        System.out.println("GOTO " + label);
    }

    @Override
    public void setAddress(int address) {
        givenAddress = address;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
