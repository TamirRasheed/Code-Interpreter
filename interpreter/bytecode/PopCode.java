package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{
    private int elementToPop;
    @Override
    public void init(ArrayList<String> args) {
        elementToPop = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine machine) {
        for (int i = 0; i < elementToPop; i ++){
            machine.popRunStack();
        }
    }

    @Override
    public void dump(VirtualMachine machine) {
        System.out.println("POP " + elementToPop);
    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return null;
    }
}
