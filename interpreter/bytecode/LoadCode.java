package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{

    private int num;
    private String variable;
    @Override
    public void init(ArrayList<String> args) {
        num = Integer.parseInt(args.get(0));
        if(args.size()>0){
            variable = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine machine) {
    machine.loadRunTimeStack(num);
    }

    @Override
    public void dump(VirtualMachine machine) {
        System.out.print("LOAD " + num);
        if (!variable.equals("")) {
            System.out.print(" " + variable + "\t" + "<load " + variable + ">");
        }
        System.out.println();
    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return null;
    }
}

