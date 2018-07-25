package rui.coder.foundation.VM.Memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 当前的很多主流框架，如Spring、Hibernate，在对类进行增强时，都会使用到CGLib这类字节码技术.
 *      增强的类越多，就需要越大的方法区来保证动态生成的Class可以加载入内存。
 *      另外，JVM上的动态语言（例如Groovy等）通常都会持续创建类来实现语言的动态性，随着这类语言的流行，也越来越容易遇到这种场景
 *
 * 创建于 2017-02-06.
 *
 * @author 赵睿
 */
public class MethodAreaOOM {
    public static void main(final String[] args) {
        try {
            while(true){
                Enhancer enhancer=new Enhancer();
                enhancer.setSuperclass(OOMObject.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(objects,args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    static class OOMObject{
    }
}
