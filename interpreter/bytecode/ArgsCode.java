package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{
    int countofArgs;
    @Override
    public void init(ArrayList<String> args) {
    countofArgs = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine machine) {
    machine.newFrame(countofArgs);
    }

    @Override
    public void dump(VirtualMachine machine) {
    System.out.println("Args " + countofArgs);
    machine.setCountOfArgsForDump(countofArgs);
    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return String.valueOf(countofArgs);
    }
}
