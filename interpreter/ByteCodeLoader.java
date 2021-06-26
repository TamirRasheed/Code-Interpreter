
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts. Can also use the split function in the String class.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        String line;
        String[] items;
        ArrayList<String> args = new ArrayList<>();
        String byteCodeName; //comes from the .x.cod file
        String className; //name after its mapped from source code
        Class classBlueprint;
        ByteCode bc;
        Program program = new Program();
        try {
            while (this.byteSource.ready()) {
                //tokenise the read line
                line = this.byteSource.readLine();
                items = line.split("\\s+");
                //grab first token of line
                byteCodeName = items[0];
                //grab class name from token
                className = CodeTable.getClassName(byteCodeName);
                //load classblueprint from classname
                classBlueprint = Class.forName("interpreter.bytecode." + className);
                // get declared consturctor (should be no-arg consturcotr)
                // create a new instance of bytecode using constructor
                bc = (ByteCode) classBlueprint.getDeclaredConstructor().newInstance();


                //grab remaining arguments

                // pass args to bytecode init function
                bc.init(args);
                // add bytecode to program

            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException ex) {
            System.out.println(ex);
            System.exit(-1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        program.resolveAddress();
        return program;
    }
}
