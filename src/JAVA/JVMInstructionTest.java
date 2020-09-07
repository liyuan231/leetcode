package JAVA;

import JAVA.proxy.SomethingThatAPersonShouldDo;
import JAVA.proxy.SomethingThatAStudentShouldDo;
import JAVA.proxy.Student;
import org.junit.Test;

import java.util.Stack;

public class JVMInstructionTest {
    /**
     * 从数组中加载引用
     */
    @Test
    public void aaload() {
        String[] strings = "abcdabcdabcd".split("a");
        String[] strings1 = strings;
        String s = strings[2];
        System.out.println(s);
    }

    /**
     * 将null值推入...
     */
    @Test
    public void aconst_null() {
        Stack<Integer> stack = new Stack<>();
        stack.push(null);
    }

    /**
     * 从局部变量表加载第n个变量
     */
    @Test
    public void aload_n() {
        Integer i = 10;
        Integer j = i;
    }

    /**
     * 创建一个新的数组
     */
    @Test
    public void anewarray() {
        String[] strings = new String[10];
    }

    /**
     * 返回一个引用类型，此处由于junit必须返回值为void，故注释掉
     * @return
     */
//    @Test public int areturn(){
//        return 10;
//    }

    /**
     * 获得数组长度
     */
    @Test
    public void arraylength() {
        String[] strings = new String[10];
        int length = strings.length;
    }

    /**
     * 将引用存入局部变量表
     */
    @Test
    public void astore_n() {
        String s = "liyuan";
    }

    /**
     * 抛出异常或错误
     */
    @Test
    public void athrow() {
        throw new OutOfMemoryError();
    }

    /**
     * 从数组中获得一个byte或boolean元素
     */
    @Test
    public void baload() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5};
        byte aByte = bytes[2];
        System.out.println(aByte);
    }

    /**
     * 将一个byte或boolean元素存入数组中
     */
    @Test
    public void bastore() {
        byte[] bytes = new byte[3];
        bytes[0] = 0;
    }


    /**
     * 从数组中获得一个char元素
     */
    @Test
    public void caload() {
        char[] chars = "liyuan".toCharArray();
        char aChar = chars[0];

        System.out.println(aChar);
    }

    /**
     * 将一个char元素存入char数组中
     */
    @Test
    public void castore() {
        char[] chars = new char[3];
        chars[0] = '1';
    }

    /**
     * 检查该对象是否为指定类型，
     * 需为一个类，接口或数组的符号引用
     */
    @Test
    public void checkcast() {
        SomethingThatAPersonShouldDo somethingThatAPersonShouldDo = new Student();
        SomethingThatAStudentShouldDo somethingThatAStudentShouldDo = (SomethingThatAStudentShouldDo) somethingThatAPersonShouldDo;
    }

    /**
     * 将double强转为float
     */
    @Test
    public void d2f() {
        double d = 0.1d;
        float f = (float) d;
    }

    /**
     * double强转为int
     */
    @Test
    public void d2i() {
        double d = 0.1d;
        int i = (int) d;
    }

    /**
     * double强转为long
     */
    @Test
    public void d2l() {
        double d = 0.1d;
        long l = (long) d;
    }

    /**
     * 加上一个double
     */
    @Test
    public void dadd() {
        double d1 = 0.1D;
        double d2 = 0.2D;
        double d3 = d1 + d2;
    }

    /**
     * 从数组中获得一个double元素
     */
    @Test
    public void dalaod() {
        double[] doubles = new double[]{0.1, 0.2};
        double aDouble = doubles[0];
    }

    /**
     * 将一个double元素存储数组中
     */
    @Test
    public void dastore() {
        double[] d = new double[2];
        d[0] = 0.1;
    }

    /**
     * 比较两个double元素
     */
    @Test
    public void dcmp() {
        double d1 = 0.1;
        double d2 = 0.2;
        boolean b = d1 > d2;
    }

    /**
     * double的value1/double的value2
     */
    @Test
    public void ddiv() {
        double d1 = 0.9d;
        double d2 = 0.3d;
        double d3 = d1 / d2;
    }

    /**
     * 从局部变量中依照index获得一个double元素
     */
    @Test
    public void dload() {
        double d1 = 0.1;
        double d2 = 0.2;
        double d3 = d1 + d2;
    }

    /**
     * 乘以一个double
     */
    @Test public void dmul(){
        double d = 0.1;
        double d1=d*10;
    }
    /**
     * double的负值
     */
    @Test public void dneg(){
        double d = -0.1;
    }
    /**
     * double余数
     */
    @Test
    public void drem(){
        double d1=0.9;
        double d2 = 0.2;
        double d3 = d1%d2;
    }
    /**
     * 将一个double值存入对应索引的局部变量表
     */
    @Test public void dstore(){
        double d1 = 0.1;
        double d2 = 0.2;

    }
    /**
     * 减去一个double元素
     */
    @Test public void dsub(){
        double d1=0.1;
        int i1 = 10;
        double v = i1 - d1;
        System.out.println(v);
    }
    /**
     * 复制操作数栈栈顶的值
     */
    @Test public void dup(){
        Student student = new Student();
    }
    /**
     * float->double
     */
    @Test
    public void f2d(){
        float f = 0.1F;
        double d = f;
    }

    /**
     * 获取某一对象的成员变量
     */
    @Test public void getfield(){
        Student student = new Student();
        boolean gender = student.gender;
    }
    /**
     * 获取某一类的静态变量
     */
    @Test public void getstatic(){
        Student student = new Student();
        long serialVersionUID = Student.serialVersionUID;
        String mark = Student.mark;
        Student.test();
    }

    /**
     * 决定指定对象是否为指定类型
     */
    @Test public void instanceof_(){
        Student student = new Student();
        boolean b = student instanceof Object;
    }
    /**
     * 调用动态方法
     */
    @Test public void invokedynamic(){
        Student student = new Student();
        student.play();
    }
    /**
     * int左移
     */
    @Test public void ishl(){
        int n = (int) (Math.random()*10);
        int i = 10<<n;
    }
}


