package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode{
    @Override
    public void init(ArrayList<String> args) {
    }

    @Override
    public void execute(VirtualMachine machine) {
        Scanner input = new Scanner(System.in);
        Integer rInput;
        System.out.println("Please enter a number: ");
        rInput = Integer.parseInt(input.nextLine());
        machine.pushRunTimeStack(rInput);

    }

    @Override
    public void dump(VirtualMachine machine) {
        System.out.println("READ");
    }

    @Override
    public void setAddress(int address) {

    }

    @Override
    public String getLabel() {
        return ("READ ");
    }
}
