package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode{
    private int num;
    private String variable;
    private Integer finalValue;

    @Override
    public void init(ArrayList<String> args) {
        num = Integer.parseInt(args.get(0));
        if (args.size() > 1){
            variable = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine machine) {
    finalValue = machine.peekRunTimeStack();
    machine.storeRunTimeStack(num);
    }

    @Override
    public void dump(VirtualMachine machine) {
        System.out.println("STORE " + num + " " + variable + "\t" + variable + " = " + finalValue);
    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return variable;
    }
}
