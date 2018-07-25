package rui.coder.foundation.VM.GC;

/**
 * 使用finalize方法逃过GC
 *
 * 创建于 2017-02-06.
 *
 * @author 赵睿
 */
@SuppressWarnings("deprecation")
//TODO 过时
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOCK=null;

    public void isAlive(){
        System.out.println("亲们，我还在堆中");
    }

    // finalize方法对于一个对象而言，只会被系统自动调用一次，如果下一次回收，finalize方法就不会执行
    /*
        finalize的运行代价高昂，不确定性大，无法保证各个对象的调用顺序。有些教材中描述它适合做“关闭外部资源”之类的工作，这完全是对这个方法用途的一种自我安慰。
        finalize（）能做的所有工作，使用try-finally或者其他方式都可以做得更好、更及时，
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 方法执行！");
        FinalizeEscapeGC.SAVE_HOCK=this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOCK=new FinalizeEscapeGC();
        setNullThenGC();
        setNullThenGC();
    }

    /**
     * 设置引用为空，然后触发Gc，通过finalize实现一次自救
     * @throws InterruptedException
     */
    private static void setNullThenGC() throws InterruptedException {
        SAVE_HOCK=null;
        System.gc();

        //finalize 方法优先级很低，所以暂停0.5秒等待一下
        Thread.sleep(500);

        if(SAVE_HOCK!=null){
            SAVE_HOCK.isAlive();
        }else{
            System.out.println("挂了！");
        }
    }
}
