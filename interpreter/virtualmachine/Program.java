package interpreter.virtualmachine;
import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    public Program(ArrayList<ByteCode> byteCodes) {
        program = new ArrayList<>();
        program = byteCodes;
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
            ByteCode byteCode = program.get(i);
               if (byteCode instanceof LabelCode){
                   addressestoResove.put(byteCode.getLabel(), i);
               }
        }
        for (int i = 0; i < this.program.size(); i++){
            ByteCode byteCode = program.get(i);
            if (byteCode instanceof FalseBranchCode){
                int value = addressestoResove.get(byteCode.getLabel());
                byteCode.setAddress(value);
            }
            else if(byteCode instanceof GotoCode){
                int value = addressestoResove.get(byteCode.getLabel());
                ((GotoCode) byteCode).setAddress(value);
            }
//            else if(byteCode instanceof CallCode){
//                int value = addressestoResove.get(byteCode.getLabel());
//                byteCode.setAddress(value);
//            }
        }

    }
}