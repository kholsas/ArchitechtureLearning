package za.co.kholofelo.architecture.designpatterns.lazy;

/**
 * @author Kholofelo Maloma
 * @since 2017/04/26.
 * @explained: Ok, this is still archieving the same result as any othe Singleton creation-mechanism, however, it does NOT go ahead and create the instance during class loading.
 * It only creates the instance of this class ONLY when asked for it - on demand creation. I think it should be renamed to 'On-Demand Initialisation' rather than 'Lazy *'
 * NB: This works fine with a single thread. It can be a problem when multiple threads are calling #getInstance() at the same time. This could kill the concept of a Singleton
 * To sort out this issue, look at the <link>za.co.kholofelo.architecture.designpatterns.threadsafe.ThreadSafeSingleton</lind>
 */
public class LazyInitSingleton {


    private static LazyInitSingleton singleton;

    private LazyInitSingleton() {
    }

    public static LazyInitSingleton getSingleton() {
        if (singleton == null) {
            singleton = new LazyInitSingleton();
        }
        return singleton;
    }
}
