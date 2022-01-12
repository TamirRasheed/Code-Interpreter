package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode{

    private String operand;

    @Override
    public void init(ArrayList<String> args) {
    operand = args.get(0);
    }

    @Override
    public void execute(VirtualMachine machine) {
    int operand2 = machine.popRunStack();
    int operand1 = machine.popRunStack();

        switch (operand){
            case "+":
                machine.pushRunTimeStack(operand1 + operand2);
            case "-":
                machine.pushRunTimeStack(operand1 - operand2);
            case "*":
                machine.pushRunTimeStack(operand1 * operand2);
            case "/":
                machine.pushRunTimeStack(operand1 / operand2);
            case "==":
                machine.pushRunTimeStack((operand1 == operand2 ? 1: 0));
            case "!=":
                machine.pushRunTimeStack((operand1 != operand2 ? 1: 0));
            case ">":
                machine.pushRunTimeStack((operand1 > operand2 ? 1: 0));
            case "<":
                machine.pushRunTimeStack((operand1 < operand2 ? 1: 0));
            case ">=":
                machine.pushRunTimeStack((operand1 >= operand2 ? 1: 0));
            case "<=":
                machine.pushRunTimeStack((operand1 >= operand2 ? 1: 0));
            case "|":
                machine.pushRunTimeStack(((operand1!=0) || (operand2!=0)) ? 1: 0);
            case "&":
                machine.pushRunTimeStack(((operand1!=0) && (operand2!=0)) ? 1: 0);
            default:
                System.out.println("Error! Operand is not a correct value");
                System.exit(0);
        }
    }

    @Override
    public void dump(VirtualMachine machine) {
        System.out.println("BOP " + operand);
    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return operand;
    }
}
