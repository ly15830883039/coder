# jdk9 的新特性
1. java + REPL =jshell
2. JMH
3. G1 垃圾回收器，作为默认的垃圾收集器
4. HTTP2.0 支持
5. 进程Api的支持：获得进程PID
``` java
public static void main(String[] args) throws Exception {

  Process proc = Runtime.getRuntime().exec(new String[]{ "/bin/sh", "-c", "echo $PPID" });

  if (proc.waitFor() == 0) {

    InputStream in = proc.getInputStream();

    int available = in.available();

    byte[] outputBytes = new byte[available];

    in.read(outputBytes);

    String pid = new String(outputBytes);

    System.out.println("Your pid is " + pid);

  }

}
```
转为
```
System.out.println("Your pid is" + Process.getCurrentPid());
```