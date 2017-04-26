package za.co.kholofelo.architecture.designpatterns.eager;

/**
 * @author Kholofelo Maloma
 * @since 2017/04/26.
 * @Explained: In Eager initialisation, the instance of Singleton is created at class loading. It is cool, because you don't get to worry about creating it at a later stage.
However, it has a memory-draw-back. Why? well, because you create an instance of an object that you may never get to use. So throughout the application lifecycle, your RAM would be containing an object that may never be used.

 */
public class EagerInitSingleton {

    //static: makes it be created at load time.
    //private: no one else can minupulate this object
    //final: No one can re-assign this handler
    private static final EagerInitSingleton INSTANCE = new EagerInitSingleton();

    //private constructor to prevent other classes from creating another instance
    private EagerInitSingleton(){}

    //provides a windows to access the instance of this class
    public static EagerInitSingleton getInstance(){
        return INSTANCE;
    }
}
