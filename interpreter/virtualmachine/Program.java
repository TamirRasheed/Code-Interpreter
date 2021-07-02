package interpreter.virtualmachine;
import interpreter.bytecode.BopCode;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    public Program(ArrayList<ByteCode> byteCodes) {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        HashMap<String, Integer> addressestoResove = new HashMap<>();

        for (int i = 0; i < program.size(); i++) {
            if (program.get(i) instanceof LabelCode) {
                addressestoResove.put(((LabelCode) program.get(i)).getLabel(), i);
            }
        }

    }
}