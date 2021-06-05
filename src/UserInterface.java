public class UserInterface {

    public static void main(String[] args) {
        UserFunctions userFunctions = new UserFunctions();
        InterfaceFunctions interfaceFunctions = new FunctionTrigger(userFunctions);
        interfaceFunctions.runMenu();
    }
}