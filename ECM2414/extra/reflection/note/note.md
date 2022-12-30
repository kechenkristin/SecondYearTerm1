## 反射：框架设计的灵魂
- 框架：半成品软件。可以在框架的基础上进行软件开发，简化编码
- 反射：将类的各个组成部分封装为其他对象，这就是反射机制
	- 好处：
		- 可以在程序运行过程中，操作这些对象。
		- 可以解耦，提高程序的可扩展性。

![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/threeStages.png)

### 获取Class对象的方式：
#### note
- Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
	- 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
- 类名.class：通过类名的属性class获取
	- 多用于参数的传递
- 对象.getClass()：getClass()方法在Object类中定义着。
	- 多用于对象的获取字节码的方式

- 结论：
	- 同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的Class对象都是同一个。

#### code
https://github.com/kechenkristin/SecondYearTerm1/blob/main/ECM2414/extra/reflection/code/ReflectDemo1.java
```java
//1.Class.forName("全类名")
 Class cls1 = Class.forName("cn.itcast.domain.Person");
System.out.println(cls1);

//2.类名.class
Class cls2 = Person.class;
System.out.println(cls2);
        
//3.对象.getClass()
Person p = new Person();
Class cls3 = p.getClass();
System.out.println(cls3);

//== 比较三个对象
 System.out.println(cls1 == cls2);//true
 System.out.println(cls1 == cls3);//true
```



### Class对象功能：
#### note
https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html  

- 获取成员变量们
	- Field[] getFields() ：获取所有public修饰的成员变量
	- Field getField(String name)   获取指定名称的 public修饰的成员变量

	- Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
	- Field getDeclaredField(String name)  
- 获取构造方法们
	- Constructor<?>[] getConstructors()  
	- Constructor<T> getConstructor(类<?>... parameterTypes)  

	- Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)  
	- Constructor<?>[] getDeclaredConstructors()  
- 获取成员方法们：
	- Method[] getMethods()  
	- Method getMethod(String name, 类<?>... parameterTypes)  

	- Method[] getDeclaredMethods()  
	- Method getDeclaredMethod(String name, 类<?>... parameterTypes)  

- 获取全类名	
	- String getName()  



### Field：成员变量
#### note
https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html
- 操作：
	- 设置值
		- void set(Object obj, Object value)  
	- 获取值
		- get(Object obj) 

	- 忽略访问权限修饰符的安全检查
		- setAccessible(true):暴力反射
		
#### code
https://github.com/kechenkristin/SecondYearTerm1/blob/main/ECM2414/extra/reflection/code/ReflectDemo2.java
	
```java
public static void main(String[] args) throws Exception {

        //0.获取Person的Class对象
        Class personClass = Person.class;
        
        //1.Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        //2.Field getField(String name)
        Field a = personClass.getField("a");
        //获取成员变量a 的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,"张三");
        System.out.println(p);

        //Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);

    }
```



### Constructor:构造方法
#### note
https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html
- 创建对象：
	- T newInstance(Object... initargs)  

	- 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
	
#### code
https://github.com/kechenkristin/SecondYearTerm1/blob/main/ECM2414/extra/reflection/code/ReflectDemo3.java
```java
public static void main(String[] args) throws Exception {

        //0.获取Person的Class对象
        Class personClass = Person.class;
      
        //Constructor<T> getConstructor(类<?>... parameterTypes)
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
       
        //创建对象
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);

        System.out.println("----------");


        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        //创建对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);

        Object o = personClass.newInstance();
        System.out.println(o);


        //constructor1.setAccessible(true);
    }
```


### Method：方法对象
#### note
https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html
- 执行方法：
	- Object invoke(Object obj, Object... args)  

- 获取方法名称：
	- String getName:获取方法名
	
#### code
https://github.com/kechenkristin/SecondYearTerm1/blob/main/ECM2414/extra/reflection/code/ReflectDemo4.java
```java
public static void main(String[] args) throws Exception {

        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
          3. 获取成员方法们：
             * Method[] getMethods()
             * Method getMethod(String name, 类<?>... parameterTypes)
             * Method[] getDeclaredMethods()
             * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         */
        //获取指定名称的方法
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        //执行方法
        eat_method.invoke(p);


        Method eat_method2 = personClass.getMethod("eat", String.class);
        //执行方法
        eat_method2.invoke(p,"饭");

        System.out.println("-----------------");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
            //method.setAccessible(true);
        }

        //获取类名
        String className = personClass.getName();
        System.out.println(className);//cn.itcast.domain.Person

    }
```
