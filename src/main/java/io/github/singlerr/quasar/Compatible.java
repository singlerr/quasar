package io.github.singlerr.quasar;

import java.lang.reflect.Method;

/***
 * Root interface of compatible minecraft classes.
 * Defines universal methods regarding compatibility of forge mod.
 * Since implementing all minecraft and forge classes to bukkit plugin is so hard, instead Quasar goes reflection-like ways.
 * Let minecraft / forge / mod class to forge class in all comments in this class.
 * <br>
 * Any classes implementing {@link Compatible}, is a wrapper class of bukkit class.
 * Casting normal bukkit class(e.g. {@link org.bukkit.block.Block}) to {@link Compatible} block class gives you access to minecraft/forge/mod class.
 * <p>
 *     e.g. Getting minecraft class
 *          Invoke methods in minecraft class
 *          etc
 * </p>
 * @author Singlerr
 */
public interface Compatible {

    /***
     * Returns forge class of class this compatible class wrapping, not bukkit class
     * @return forge class
     */
    Class<?> getOriginalClass();

    /***
     * Returns defined method in forge class
     * @param methodName name of method to find
     * @return defined method in forge class
     */
    Method getMethod(String methodName);

    /***
     * Invoke method in the context of current forge object.
     * It invokes the method using object that this compatible class wrapping.
     * @param method method to invoke
     * @param params parameters of method
     */
    void invoke(Method method, Object... params);
}
