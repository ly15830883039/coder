# 自动拆装箱
1. 循环中避免自动装箱，GC 影响
2. == 判断，是否自动装箱带来的问题
3.  Integer 未初始化，造成的 拆箱时候的 NullPointerException
4. Integer缓冲池。在 -128 到 127 的Integer对象。


1. [importnew： Java中的自动装箱与拆箱](http://www.importnew.com/15712.html)