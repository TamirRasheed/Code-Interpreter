package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{
    private String labeltoJumpto;
    private String labelID;
    private int addresstoSet;
    @Override
    public void init(ArrayList<String> args) {
        labeltoJumpto = args.get(0);
        labelID = args.get(0).split("<<", 2)[0];

    }

    @Override
    public void execute(VirtualMachine machine) {
    machine.saveProgramCounter();
    machine.setProgramCounter(addresstoSet -1);
    }

    @Override
    public void dump(VirtualMachine machine) {

    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return labelID;
    }
}
