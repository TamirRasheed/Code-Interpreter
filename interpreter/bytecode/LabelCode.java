package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private String label;


    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine machine) {

    }

    @Override
    public void dump(VirtualMachine machine) {
        System.out.println(("LABEL " + label));
    }

    @Override
    public void setAddress(int address) {
    }

    @Override
    public String getLabel() {
        return label;
    }
}
