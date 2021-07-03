package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode{
    private boolean dumpCheck;
    @Override
    public void init(ArrayList<String> args) {
    dumpCheck = args.get(1).equals("ON");
    }

    @Override
    public void execute(VirtualMachine machine) {
    machine.dump(dumpCheck);
    }

    @Override
    public void dump(VirtualMachine machine) {
        System.out.println("dump " + dumpCheck);
    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return null;
    }
}
