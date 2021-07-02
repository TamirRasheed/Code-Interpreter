package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private String label;
    public String getLabel() {
        return label;
    }

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine machine) {

    }

    @Override
    public void dump(VirtualMachine machine) {

    }
}
