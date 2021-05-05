# 极客时间的成长笔记
极客时间Java训练营作业

###### 第一周作业

1.（选做）自己写一个简单的Hello.java，涉及基本类型，四则运算，if和for，然后自己分析一下对应的字节码，有问题群里讨论。

```java
public class Hello {
    public static void main(String[] args) {
        int a = 1;
        int b = 5;
        if (a < b) {
            System.out.println("a less than b");
        } else {
            System.out.println("a more than b");
        }
        System.out.println("a * b ="+(a*b));
        System.out.println("a / b ="+(a/b));
        System.out.println("a + b ="+(a+b));
        System.out.println("b - a ="+(b-a));
        int[] array = new int[]{10,5,20,6,8,2};
        int length = array.length;
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }
}
```

执行代码，打印结果：

>a less than b
>a * b =5
>a / b =0
>a + b =6
>b - a =4
>打印数组：
>10 5 20 6 8 2 

字节码分析：

> javac Hello.java

> javap -c Hello

```cmake
Compiled from "Hello.java"
public class org.nero.interview.geektime.Hello {
  public org.nero.interview.geektime.Hello();
    Code:
       0: aload_0   第0这个偏移位置加载到栈上来
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_1  将值为1的常量压入栈中
       1: istore_1
       2: iconst_5  将值为5的常量压入栈中
       3: istore_2
       4: iload_1   在局部变量表中索引位置为1的地方装载变量
       5: iload_2   在局部变量表中索引位置为2的地方装载变量
       6: if_icmpge     20  判断a是否小于b，如果小于跳转到位置20
       9: getstatic     #2  获取2个字节的常量                // Field java/lang/System.out:Ljava/io/PrintStream;
      12: ldc           #3  加载常量                // String a less than b
      14: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      17: goto          28
      20: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      23: ldc           #5                  // String a more than b
      25: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      28: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      31: new           #6                  // class java/lang/StringBuilder
      34: dup
      35: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
      38: ldc           #8                  // String a * b =
      40: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      43: iload_1
      44: iload_2
      45: imul
      46: invokevirtual #10                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      49: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      52: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      55: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      58: new           #6                  // class java/lang/StringBuilder
      61: dup
      62: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
      65: ldc           #12                 // String a / b =
      67: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      70: iload_1
      71: iload_2
      72: idiv
      73: invokevirtual #10                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      76: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      79: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      82: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      85: new           #6                  // class java/lang/StringBuilder
      88: dup
      89: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
      92: ldc           #13                 // String a + b =
      94: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      97: iload_1
      98: iload_2
      99: iadd
     100: invokevirtual #10                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
     103: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
     106: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     109: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     112: new           #6                  // class java/lang/StringBuilder
     115: dup
     116: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
     119: ldc           #14                 // String b - a =
     121: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
     124: iload_2
     125: iload_1
     126: isub
     127: invokevirtual #10                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
     130: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
     133: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     136: bipush        6     压入栈中6个字节值
     138: newarray       int
     140: dup
     141: iconst_0
     142: bipush        10
     144: iastore
     145: dup
     146: iconst_1
     147: iconst_5
     148: iastore
     149: dup
     150: iconst_2
     151: bipush        20
     153: iastore
     154: dup
     155: iconst_3
     156: bipush        6
     158: iastore
     159: dup
     160: iconst_4
     161: bipush        8
     163: iastore
     164: dup
     165: iconst_5
     166: iconst_2
     167: iastore
     168: astore_3
     169: aload_3
     170: arraylength
     171: istore        4
     173: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     176: ldc           #15                 // String 打印数组：
     178: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     181: iconst_0
     182: istore        5
     184: iload         5
     186: iload         4
     188: if_icmpge     215
     191: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     194: aload_3
     195: iload         5
     197: iaload
     198: invokevirtual #16                 // Method java/io/PrintStream.print:(I)V
     201: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     204: ldc           #17                 // String
     206: invokevirtual #18                 // Method java/io/PrintStream.print:(Ljava/lang/String;)V
     209: iinc          5, 1
     212: goto          184
     215: return
}
```



2.（必做）自定义一个Classloader，加载一个Hello.xlass文件，执行hello方法，此文件内容是一个Hello.class文件所有字节（x=255-x）处理后的文件。文件群里提供。

```java
import java.io.*;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) throws Exception {
        Object instance = new HelloClassLoader().findClass("Hello").newInstance();
        Method method = instance.getClass().getMethod("hello");
        System.out.println("执行Hello.xlass文件的hello方法：");
        System.out.println(method.invoke(instance));
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            File file = new File("Hello/Hello.xlass");
            InputStream fileIn = new FileInputStream(file);
            BufferedInputStream in = new BufferedInputStream(fileIn);
            byte[] bytes = in.readAllBytes();
          	int length = bytes.length;
            for (int i = 0; i < length; i++) {
                bytes[i] = (byte) (0xff - bytes[i]);
            }
            return defineClass(name, bytes, 0, length);
        } catch (FileNotFoundException e) {
            return defineClass(name, new byte[]{}, 0, 0);
        } catch (IOException e) {
            return defineClass(name, new byte[]{}, 0, 0);
        }
    }

}
```

执行代码，打印结果：

>执行Hello.xlass文件的hello方法：
>Hello, classLoader!
>null

3.（必做）画一张图，展示Xmx、Xms、Xmn、Meta、DirectMemory、Xss这些内存参数的关系。

文件：jvm配置关系图.png
![jvm配置关系图](https://github.com/zerolbsony/geektime/jvm配置关系图.png)

4.（选做）检查一下自己维护的业务系统的JVM参数配置，用jstat和jstack、jmap查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。

注意：如果没有线上系统，可以自己run一个web/java项目。

第一步：jstack查看进程使用情况jstack 2743

这里截取了一部分结果，可以看到pushMsg-schedule-pool-1到pushMsg-schedule-pool-5这5个线程等待nioEventLoopGroup-3-1释放锁住的那块内存。

怀疑时NioEventLoop运行太多，导致连接数太多响应不了。

>"pushMsg-schedule-pool-5" #40 daemon prio=5 os_prio=0 tid=0x00007f6450002800 nid=0xb6c waiting on condition [0x00007f6443ffe000]
>
>java.lang.Thread.State: TIMED_WAITING (parking)
>
>at sun.misc.Unsafe.park(Native Method)
>
>\- parking to wait for <0x00000000e0bf6338> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
>
>at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
>
>at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
>
>at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1074)
>
>at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1134)
>
>at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
>
>at java.lang.Thread.run(Thread.java:748)
>
>"pushMsg-schedule-pool-4" #39 daemon prio=5 os_prio=0 tid=0x00007f6450001000 nid=0xb63 waiting on condition [0x00007f64b01ce000]
>
>java.lang.Thread.State: WAITING (parking)
>
>at sun.misc.Unsafe.park(Native Method)
>
>\- parking to wait for <0x00000000e0bf6338> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
>
>at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
>
>at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1088)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
>
>at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1074)
>
>at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1134)
>
>at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
>
>at java.lang.Thread.run(Thread.java:748)
>
>"pushMsg-schedule-pool-3" #38 daemon prio=5 os_prio=0 tid=0x00007f644c004800 nid=0xb5b waiting on condition [0x00007f64b02cf000]
>
>java.lang.Thread.State: WAITING (parking)
>
>at sun.misc.Unsafe.park(Native Method)
>
>\- parking to wait for <0x00000000e0bf6338> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
>
>at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
>
>at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1088)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
>
>at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1074)
>
>at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1134)
>
>at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
>
>at java.lang.Thread.run(Thread.java:748)
>
>"pushMsg-schedule-pool-2" #37 daemon prio=5 os_prio=0 tid=0x00007f644c003000 nid=0xb55 waiting on condition [0x00007f64b03d0000]
>
>java.lang.Thread.State: WAITING (parking)
>
>at sun.misc.Unsafe.park(Native Method)
>
>\- parking to wait for <0x00000000e0bf6338> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
>
>at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
>
>at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1088)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
>
>at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1074)
>
>at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1134)
>
>at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
>
>at java.lang.Thread.run(Thread.java:748)
>
>"pushMsg-schedule-pool-1" #36 daemon prio=5 os_prio=0 tid=0x00007f6458221000 nid=0xb54 waiting on condition [0x00007f64b04d1000]
>
>java.lang.Thread.State: WAITING (parking)
>
>at sun.misc.Unsafe.park(Native Method)
>
>\- parking to wait for <0x00000000e0bf6338> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
>
>at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
>
>at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1088)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
>
>at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1074)
>
>at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1134)
>
>at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
>
>at java.lang.Thread.run(Thread.java:748)
>
>"nioEventLoopGroup-3-1" #35 prio=10 os_prio=0 tid=0x00007f6454059800 nid=0xb53 runnable [0x00007f64b15d3000]
>
>java.lang.Thread.State: RUNNABLE
>
>at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
>
>at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
>
>at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
>
>at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
>
>\- locked <0x00000000e0c01000> (a io.netty.channel.nio.SelectedSelectionKeySet)
>
>\- locked <0x00000000e0c00ff0> (a java.util.Collections$UnmodifiableSet)
>
>\- locked <0x00000000e0c00fa8> (a sun.nio.ch.EPollSelectorImpl)
>
>at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
>
>at io.netty.channel.nio.SelectedSelectionKeySetSelector.select(SelectedSelectionKeySetSelector.java:62)
>
>at io.netty.channel.nio.NioEventLoop.select(NioEventLoop.java:756)
>
>at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:411)
>
>at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:884)
>
>at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
>
>at java.lang.Thread.run(Thread.java:748)
>
>"DestroyJavaVM" #34 prio=5 os_prio=0 tid=0x00007f6510009000 nid=0xab8 waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"nioEventLoopGroup-2-1" #31 prio=10 os_prio=0 tid=0x00007f65116a5000 nid=0xb03 runnable [0x00007f64b18d4000]
>
>java.lang.Thread.State: RUNNABLE
>
>at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
>
>at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
>
>at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
>
>at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
>
>\- locked <0x00000000e0b2de48> (a io.netty.channel.nio.SelectedSelectionKeySet)
>
>\- locked <0x00000000e0b2ef20> (a java.util.Collections$UnmodifiableSet)
>
>\- locked <0x00000000e0b2dda0> (a sun.nio.ch.EPollSelectorImpl)
>
>at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
>
>at io.netty.channel.nio.SelectedSelectionKeySetSelector.select(SelectedSelectionKeySetSelector.java:62)
>
>at io.netty.channel.nio.NioEventLoop.select(NioEventLoop.java:756)
>
>at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:411)
>
>at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:884)
>
>at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
>
>at java.lang.Thread.run(Thread.java:748)
>
>"ObjectCleanerThread" #30 daemon prio=1 os_prio=0 tid=0x00007f651169d000 nid=0xb02 in Object.wait() [0x00007f64c4202000]
>
>java.lang.Thread.State: TIMED_WAITING (on object monitor)
>
>at java.lang.Object.wait(Native Method)
>
>at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
>
>\- locked <0x00000000e0ab9230> (a java.lang.ref.ReferenceQueue$Lock)
>
>at io.netty.util.internal.ObjectCleaner$1.run(ObjectCleaner.java:54)
>
>at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
>
>at java.lang.Thread.run(Thread.java:748)
>
>"commons-pool-EvictionTimer" #29 daemon prio=5 os_prio=0 tid=0x00007f6510bef800 nid=0xb00 in Object.wait() [0x00007f64c4101000]
>
>java.lang.Thread.State: TIMED_WAITING (on object monitor)
>
>at java.lang.Object.wait(Native Method)
>
>at java.util.TimerThread.mainLoop(Timer.java:552)
>
>\- locked <0x00000000e0b94108> (a java.util.TaskQueue)
>
>at java.util.TimerThread.run(Timer.java:505)
>
>"pool-3-thread-1" #27 prio=5 os_prio=0 tid=0x00007f6510f66800 nid=0xafe waiting on condition [0x00007f64c4303000]
>
>java.lang.Thread.State: TIMED_WAITING (parking)
>
>at sun.misc.Unsafe.park(Native Method)
>
>\- parking to wait for <0x00000000e0764f38> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
>
>at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
>
>at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
>
>at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
>
>at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1074)
>
>at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1134)
>
>at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
>
>at java.lang.Thread.run(Thread.java:748)
>
>"main-EventThread" #25 daemon prio=5 os_prio=0 tid=0x00007f6510a73800 nid=0xaf8 waiting on condition [0x00007f64c481b000]
>
>java.lang.Thread.State: WAITING (parking)
>
>at sun.misc.Unsafe.park(Native Method)
>
>\- parking to wait for <0x00000000e07cadf0> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
>
>at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
>
>at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
>
>at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
>
>at org.apache.zookeeper.ClientCnxn$EventThread.run(ClientCnxn.java:501)
>
>"main-SendThread(10.59.8.31:2181)" #24 daemon prio=5 os_prio=0 tid=0x00007f6510a70000 nid=0xaf7 runnable [0x00007f64c551d000]
>
>java.lang.Thread.State: RUNNABLE
>
>at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
>
>at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
>
>at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
>
>at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
>
>\- locked <0x00000000e08176d8> (a sun.nio.ch.Util$3)
>
>\- locked <0x00000000e08176c8> (a java.util.Collections$UnmodifiableSet)
>
>\- locked <0x00000000e0817260> (a sun.nio.ch.EPollSelectorImpl)
>
>at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
>
>at org.apache.zookeeper.ClientCnxnSocketNIO.doTransport(ClientCnxnSocketNIO.java:349)
>
>at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1141)
>
>"Service Thread" #17 daemon prio=9 os_prio=0 tid=0x00007f65102d6000 nid=0xadb runnable [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C1 CompilerThread11" #16 daemon prio=9 os_prio=0 tid=0x00007f65102d3000 nid=0xad8 waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C1 CompilerThread10" #15 daemon prio=9 os_prio=0 tid=0x00007f65102d0800 nid=0xad7 waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C1 CompilerThread9" #14 daemon prio=9 os_prio=0 tid=0x00007f65102ce800 nid=0xad6 waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C1 CompilerThread8" #13 daemon prio=9 os_prio=0 tid=0x00007f65102cc800 nid=0xad4 waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C2 CompilerThread7" #12 daemon prio=9 os_prio=0 tid=0x00007f65102ca000 nid=0xad3 waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C2 CompilerThread6" #11 daemon prio=9 os_prio=0 tid=0x00007f65102c8000 nid=0xad2 waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C2 CompilerThread5" #10 daemon prio=9 os_prio=0 tid=0x00007f65102c6000 nid=0xad1 waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C2 CompilerThread4" #9 daemon prio=9 os_prio=0 tid=0x00007f65102bb800 nid=0xacf waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C2 CompilerThread3" #8 daemon prio=9 os_prio=0 tid=0x00007f65102b9800 nid=0xace runnable [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C2 CompilerThread2" #7 daemon prio=9 os_prio=0 tid=0x00007f65102b7800 nid=0xacd waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C2 CompilerThread1" #6 daemon prio=9 os_prio=0 tid=0x00007f65102b5800 nid=0xacc waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"C2 CompilerThread0" #5 daemon prio=9 os_prio=0 tid=0x00007f65102b2800 nid=0xacb waiting on condition [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"Signal Dispatcher" #4 daemon prio=9 os_prio=0 tid=0x00007f65102b1000 nid=0xaca runnable [0x0000000000000000]
>
>java.lang.Thread.State: RUNNABLE
>
>"Finalizer" #3 daemon prio=8 os_prio=0 tid=0x00007f651027e000 nid=0xac8 in Object.wait() [0x00007f64c73f2000]
>
>java.lang.Thread.State: WAITING (on object monitor)
>
>at java.lang.Object.wait(Native Method)
>
>at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
>
>\- locked <0x00000000e00e67e8> (a java.lang.ref.ReferenceQueue$Lock)
>
>at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
>
>at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)
>
>"Reference Handler" #2 daemon prio=10 os_prio=0 tid=0x00007f6510279000 nid=0xac7 in Object.wait() [0x00007f64c74f3000]
>
>java.lang.Thread.State: WAITING (on object monitor)
>
>at java.lang.Object.wait(Native Method)
>
>at java.lang.Object.wait(Object.java:502)
>
>at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
>
>\- locked <0x00000000e00e6a60> (a java.lang.ref.Reference$Lock)
>
>at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)
>
>"VM Thread" os_prio=0 tid=0x00007f6510271800 nid=0xac6 runnable
>
>"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x00007f651001e800 nid=0xab9 runnable
>
>"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x00007f6510020800 nid=0xaba runnable
>
>"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x00007f6510022000 nid=0xabb runnable
>
>"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x00007f6510024000 nid=0xabc runnable
>
>"GC task thread#4 (ParallelGC)" os_prio=0 tid=0x00007f6510025800 nid=0xabd runnable
>
>"GC task thread#5 (ParallelGC)" os_prio=0 tid=0x00007f6510027800 nid=0xabe runnable
>
>"GC task thread#6 (ParallelGC)" os_prio=0 tid=0x00007f6510029800 nid=0xabf runnable
>
>"GC task thread#7 (ParallelGC)" os_prio=0 tid=0x00007f651002b000 nid=0xac0 runnable
>
>"GC task thread#8 (ParallelGC)" os_prio=0 tid=0x00007f651002d000 nid=0xac1 runnable
>
>"GC task thread#9 (ParallelGC)" os_prio=0 tid=0x00007f651002f000 nid=0xac2 runnable
>
>"GC task thread#10 (ParallelGC)" os_prio=0 tid=0x00007f6510030800 nid=0xac3 runnable
>
>"GC task thread#11 (ParallelGC)" os_prio=0 tid=0x00007f6510032800 nid=0xac4 runnable
>
>"GC task thread#12 (ParallelGC)" os_prio=0 tid=0x00007f6510034800 nid=0xac5 runnable
>
>"VM Periodic Task Thread" os_prio=0 tid=0x00007f65102da800 nid=0xadc waiting on condition
>
>JNI global references: 702

第二步：JMap查内存

>num #instances #bytes class name
>
>\----------------------------------------------
>
>1: 64375 238175704 [B
>
>2: 142437 158343616 [C
>
>3: 58181 8101248 [Ljava.lang.Object;
>
>4: 188674 6037568 java.lang.ThreadLocal$ThreadLocalMap$Entry
>
>5: 13954 5246704 java.lang.Thread
>
>6: 31931 2795680 [I
>
>7: 13891 2007408 [Ljava.lang.ThreadLocal$ThreadLocalMap$Entry;
>
>8: 29294 1640464 sun.nio.cs.UTF_8$Encoder
>
>9: 2496 1637376 io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue
>
>10: 13888 1444352 org.apache.logging.log4j.core.impl.MutableLogEvent
>
>11: 28177 1352496 java.nio.HeapCharBuffer
>
>12: 28150 1351200 java.nio.HeapByteBuffer
>
>13: 54527 1308648 java.lang.String
>
>14: 2145 1302480 [Lio.netty.util.Recycler$DefaultHandle;
>
>15: 29408 1176320 java.lang.ref.SoftReference
>
>16: 32529 1040928 java.util.HashMap$Node
>
>17: 14259 1026648 org.apache.logging.log4j.core.util.datetime.FixedDateFormat
>
>18: 14266 798896 sun.util.calendar.ZoneInfo
>
>19: 7005 785216 java.lang.Class
>
>20: 48180 770880 java.lang.Object
>
>21: 31106 746544 java.lang.StringBuilder
>
>22: 16734 669360 io.netty.util.DefaultAttributeMap$DefaultAttribute
>
>23: 13936 668928 java.util.concurrent.ThreadPoolExecutor$Worker
>
>24: 7512 634376 [Ljava.util.HashMap$Node;
>
>25: 19796 633472 java.util.concurrent.ConcurrentHashMap$Node
>
>26: 14259 570360 org.apache.logging.log4j.core.pattern.DatePatternConverter$FixedFormatter
>
>27: 17324 554368 java.lang.StackTraceElement
>
>28: 16733 535456 java.util.concurrent.locks.AbstractQueuedSynchronizer$Node
>
>29: 14687 352488 org.apache.logging.log4j.core.time.MutableInstant
>
>30: 2855 352480 [Ljava.nio.channels.SelectionKey;
>
>31: 13891 333384 java.lang.ThreadLocal$ThreadLocalMap
>
>32: 6708 321984 java.util.HashMap
>
>33: 2790 312480 sun.nio.ch.SocketChannelImpl
>
>34: 2789 290056 io.netty.channel.socket.nio.NioSocketChannel
>
>35: 2789 223120 [Ljava.util.concurrent.RunnableScheduledFuture;
>
>36: 2789 223120 java.util.concurrent.ScheduledThreadPoolExecutor
>
>37: 13888 222208 org.apache.logging.log4j.message.ReusableSimpleMessage
>
>38: 2790 200880 io.netty.channel.AdaptiveRecvByteBufAllocator$HandleImpl
>
>39: 2790 200880 io.netty.channel.DefaultChannelPipeline$HeadContext
>
>40: 2790 200880 io.netty.channel.DefaultChannelPipeline$TailContext
>
>41: 2788 200736 java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask
>
>42: 6180 197760 java.util.concurrent.locks.ReentrantLock$NonfairSync
>
>43: 5681 181792 java.net.InetAddress$InetAddressHolder
>
>44: 2834 180752 [Ljava.security.ProtectionDomain;

其中，class name列有一些很奇怪的名字：

> [C 
>
> [S i
>
> [I 
>
> [B 
>
> [[I i

它们分别对应的对象是

> [C is a char[]
>
> [S is a short[]
>
> [I is a int[]
>
> [B is a byte[]
>
> [[I is a int

[][]

五、jmap -heap 2743 查看内存堆信息

>Attaching to process ID 2743, please wait...
>
>Debugger attached successfully.
>
>Server compiler detected.
>
>JVM version is 25.152-b16
>
>using thread-local object allocation.
>
>Parallel GC with 13 thread(s)
>
>Heap Configuration:
>
>MinHeapFreeRatio = 0
>
>MaxHeapFreeRatio = 100
>
>MaxHeapSize = 536870912 (512.0MB)
>
>NewSize = 175112192 (167.0MB)
>
>MaxNewSize = 178782208 (170.5MB)
>
>OldSize = 351272960 (335.0MB)
>
>NewRatio = 2
>
>SurvivorRatio = 8
>
>MetaspaceSize = 21807104 (20.796875MB)
>
>CompressedClassSpaceSize = 1073741824 (1024.0MB)
>
>MaxMetaspaceSize = 17592186044415 MB
>
>G1HeapRegionSize = 0 (0.0MB)
>
>Heap Usage:
>
>PS Young Generation
>
>Eden Space:
>
>capacity = 173539328 (165.5MB)
>
>used = 173539328 (165.5MB)
>
>free = 0 (0.0MB)
>
>100.0% used
>
>From Space:
>
>capacity = 2621440 (2.5MB)
>
>used = 0 (0.0MB)
>
>free = 2621440 (2.5MB)
>
>0.0% used
>
>To Space:
>
>capacity = 2621440 (2.5MB)
>
>used = 0 (0.0MB)
>
>free = 2621440 (2.5MB)
>
>0.0% used
>
>PS Old Generation
>
>capacity = 358088704 (341.5MB)
>
>used = 357875160 (341.29634857177734MB)
>
>free = 213544 (0.20365142822265625MB)
>
>99.94036561399044% used
>
>10989 interned Strings occupying 1061928 bytes.

可以看到老年代和年轻代的内存被占用满了。

第三步：通过工具**Memory Analyzer**分析堆

jmap -dump:live,format=b,file=heap2743.bin 2743 将堆dump到文件heap2743.bin文件中，通过工具打开该文件看到如下：

![img](data:image/png;base64,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)

通过点击details，然后在中间页，点击弹出的菜单栏中的”list_objects"项，找到如下的：

![img](data:image/png;base64,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)

经排查，发现这是老代码，之前在每次连接后，运行一个5核心数的线程池，而且也不随客户端断开连接后释放，导致每次连接都要有5个线程，所以导致线程不够申请的了。

**最终解决方案**：

1.将线程池改成单线程

```java
@OnOpen
public void onOpen(final Session session, HttpHeaders headers, ParameterMap parameterMap) throws IOException {
	String cityCode = parameterMap.getParameter("cityCode");
	final String driverCode = parameterMap.getParameter("driverCode");
	long connTime = System.currentTimeMillis();
	ScheduledExecutorService sc = Executors.newSingleThreadScheduledExecutor();
}
```

这里之前是5个核心数的线程池，当初其实是希望将整体websocket连接中的长连接的推送逻辑保持在5个常驻线程的量，如果超出后要等待，其实后面想了一下即便这里改成这个，也会造成问题，因为推送逻辑是始终保持的，那么如果实现成这样了，就只能支持5个司机的推送，再多就不支持了。

2.客户端断开连接时未释放长连接推送逻辑的线程

```java
@OnOpen
public void onOpen(final Session session, HttpHeaders headers, ParameterMap parameterMap) throws IOException {
  String cityCode = parameterMap.getParameter("cityCode");
  final String driverCode = parameterMap.getParameter("driverCode");
  long connTime = System.currentTimeMillis();
  ScheduledExecutorService sc = Executors.newSingleThreadScheduledExecutor();
  
  selfM.put("cityCode", cityCode);
  selfM.put("driverCode", driverCode);
  selfM.put("connTime", connTime);
  selfM.put("session", session);
  selfM.put("sc", sc);

  sM.put( driverCode, selfM );

  Runnable runnable = new Runnable() {
    @Override
    public void run() {
      WmLog.busLog( "开始推送" );
      try {
        long startTimeMillis = System.currentTimeMillis();
        while (!Thread.currentThread().isInterrupted()) {
          long curTimeMillis = System.currentTimeMillis();
          if ((curTimeMillis-startTimeMillis) >= (long) INTERVAL_TIME) {
            break;
          }

          String pushMsgData = WmJedisClient.get( wlc.driverPushMsg+driverCode );
          WmLog.busLog( "pushMsgData is "+pushMsgData+", driverCode is "+driverCode );
          if (StringUtils.isEmpty(pushMsgData)) {
            break;
          }

        	try {
            //连接断掉的情况不处理redis消息源，因为有其它server处理或者等它过期
            if (sM.get(driverCode) != null) {
              session.sendText( pushMsgData );
              //默认认为是发送成功，不需要额外判断
              WmJedisClient.del( wlc.driverPushMsg+driverCode );
            } else {
            	WmLog.busLog( "driverCode["+driverCode+"] session channel closed." );
            }
          } catch (Exception e) {
          	WmLog.busLog( "exception message is " + e.getMessage()+ ", driverCode["+driverCode+"] session channel may be closed." );
          }
  			}
  		} catch (Exception e) {
  			WmLog.sysLog( "WmLbsPushServer onOpen occur exception, message is "+ e.getMessage() +", stack trace is "+e.getStackTrace().toString() );
  		}
  	}
  };

  // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
  sc.scheduleAtFixedRate(runnable, 0, INTERVAL_TIME, TimeUnit.MILLISECONDS);
  WmLog.sysLog("推送连接成功 ==> [driverCode=" + driverCode + ", cityCode=" + cityCode + ", connTime=" + connTime + "]");
}

@OnClose
public void onClose(Session session) throws IOException {
  if (sM.get(selfM.get("driverCode")) != null) {
    ScheduledExecutorService sc = (ScheduledExecutorService) sM.get(selfM.get("driverCode")).get( "sc" );
    sc.shutdownNow();
    sM.remove(selfM.get("driverCode"));
  }

  WmLog.sysLog("推送连接断开 ==> [driverCode=" + selfM.get("driverCode") + ", cityCode=" + selfM.get("cityCode") + ", connTime=" + selfM.get("connTime") + "]");
}
```

5.（选做）本机使用G1 GC启动一个程序，仿照课上案例分析一下JVM情况。



###### 第二周作业
