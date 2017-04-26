package za.co.kholofelo.architecture.designpatterns.staticblock;

/**
 * @author Kholofelo Maloma
 * @since 2017/04/26.
 *
 * @explained Static block is EAGER, however, it provides an opportunity to handle exceptions that may be thrown during object construction
 */
public class StaticBlockSingleton {
    private static final StaticBlockSingleton INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        }catch (Exception e){
            throw new RuntimeException("Failed to create a singleton for class " + StaticBlockSingleton.class.getSimpleName() ,e);
        }
    }
    private StaticBlockSingleton(){}

    public static StaticBlockSingleton getINSTANCE() {
        return INSTANCE;
    }
}

