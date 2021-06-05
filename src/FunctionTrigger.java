import java.util.Scanner;

public class FunctionTrigger implements InterfaceFunctions {

    InterfaceFunctions interfaceFunctions;

    FunctionTrigger(InterfaceFunctions interfaceFunctions) {
        this.interfaceFunctions = interfaceFunctions;
    }

    @Override
    public void runMenu() {
        interfaceFunctions.runMenu();
    }

    @Override
    public void showOptions() {
        interfaceFunctions.showOptions();
    }

    @Override
    public void selectOption(int option) {
        interfaceFunctions.selectOption(option);
    }

    @Override
    public void runTests() {
        interfaceFunctions.runTests();
    }

    @Override
    public void runBasicProgram() {
        interfaceFunctions.runBasicProgram();
    }

    @Override
    public void runExtendedProgram() {
        interfaceFunctions.runExtendedProgram();
    }

    @Override
    public String toString() {
        return interfaceFunctions.toString();
    }
}