package za.co.kholofelo.architecture.designpatterns.enumsingleton;

/**
 * @author Kholofelo Maloma
 * @since 2017/04/26.
 *
 * @explained: Ok, so now that we see that singletons are only singletons in theory, they can be compromised using reflection, enums are therefore
 * preferred in some cases as Java ensures that members of an enum type class get instantiated only once, making them singletons. But, enums are private and final. So you cannot temper with them once created. That's a little drawback
 */
public enum EnumeratedSingleton {
    INSTANCE;
}
