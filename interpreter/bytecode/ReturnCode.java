package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode{
    private String func;
    private String id;
    @Override
    public void init(ArrayList<String> args) {
    if(args.size() > 0){
        func = args.get(0);
        id = args.get(0).split("<<", 2)[0];

    }
    }

    @Override
    public void execute(VirtualMachine machine) {
        machine.popRunStackFrame();
        machine.returnProgramCounter();
    }

    @Override
    public void dump(VirtualMachine machine) {

    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return id;
    }
}
