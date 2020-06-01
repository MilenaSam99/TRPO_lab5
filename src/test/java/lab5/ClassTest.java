package lab5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClassTest {

   /* private WebDriver driver;

    //открываем страницу по адресу, переходим на форму регистрации
    @BeforeClass()
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        //open the url
        driver.get("http://best.aliexpress.ru/");
    }

    //закрываем
    @AfterClass()
    public void downUp() {
        driver.quit();
    }

    @Test()
        public void first()
        {
            // Find the text input element and our input("ноутбуки")
            driver.findElement(By.id("search-key")).sendKeys("ноутбуки");
            //find form "search-button"
            driver.findElement(By.className("search-button")).click();
        }
*/
    //data-prov TaskAbs1
    @DataProvider(name = "TaskAbs1")
    public Object[][] data_prov1()
    {
        return new Object[][]{{Integer.MAX_VALUE}};
    }
    //data-prov TaskAbs2
    @DataProvider(name = "TaskAbs2")
    public Object[][] data_prov2()
    {
        return new Object[][]{{Integer.MIN_VALUE}};
    }
    //data-prov TaskAbs3
    @DataProvider(name = "TaskAbs3")
    public Object[][] data_prov3()
    {
        return new Object[][]{{0}};
    }
    //max
    @Test(dataProvider = "TaskAbs1")
    public void TaskAbs1(int n)
    {
        System.out.println("Тест 1.1");
        int res =Math.abs(n);
            System.out.println("n = " + n);
            System.out.println("Модуль n = " + res);
        System.out.println();
    }
    //min
    @Test(dataProvider = "TaskAbs2")
    public void TaskAbs2(int n)
    {
        System.out.println("Тест 1.2");
        int res =Math.abs(n);
        System.out.println("n = " + n);
        System.out.println("Модуль n = " + res);
        if(res < 0) System.out.println("Особая ситуация: java.lang.AssertionError");
        System.out.println();
    }
    //0
    @Test(dataProvider = "TaskAbs3")
    public void TaskAbs3(int n)
    {
        System.out.println("Тест 1.3");
        int res =Math.abs(n);
        System.out.println("n = " + n);
        System.out.println("Модуль n = " + res);
        System.out.println();
    }

    //data-prov TaskAddExact1
    @DataProvider(name = "TaskAddExact1")
    public Object[][] data_prov4()
    {
        double max = Integer.MAX_VALUE - 1;
        double min = Integer.MIN_VALUE + 1;
        int n = (int)(Math.random() * max);
        int m = (int)(Math.random() * min);
        return new Object[][]
                {
                        {n, m}
                };
    }
    //проверка сложения
    @Test(dataProvider = "TaskAddExact1")
    public void TaskAddExact1(int n, int m)
    {
        System.out.println("Задание 2.1");
        //нормальные условия
        int sum = Math.addExact(n,m);
        Assert.assertEquals(sum,n + m);
        System.out.println("Значение с помощью addExact = " + sum);
        System.out.println("Проверочное значение = " + (n + m));
        System.out.println();
    }
    //data-prov TaskAddExact2
    @DataProvider(name = "TaskAddExact2")
    public Object[][] data_prov5()
    {
        double max = Integer.MAX_VALUE - 1;
        int n = 1 + (int)(Math.random() * max) + 1;
        return new Object[][]
                {
                        {n}
                };
    }
    //переполнение
    @Test(dataProvider = "TaskAddExact2")
    public void TaskAddExact2(int m)
    {
        System.out.println("Задание 2.2");
        // проверка на переполнение типа int
        int n = Integer.MAX_VALUE;
        try {
            int sum = Math.addExact(n,m);
        }
        catch (RuntimeException e)
        {
            System.out.println("Ожидаем: integer overflow");
            System.out.println("Исключение: " + e);
            Assert.assertEquals(e.toString(),"java.lang.ArithmeticException: integer overflow");
        }
        System.out.println();
    }

    //data-prov TaskFloorDiv1
    @DataProvider(name = "TaskFloorDiv1")
    public Object[][] data_prov6()
    {
        double max = Integer.MAX_VALUE - 1;
        int n = 1 + (int)(Math.random() * max) + 1;
        int m = 1 + (int)(Math.random() * max) + 1;
        int result = n/m;
        return new Object[][]
                {
                        {n, m, result}
                };
    }
    //получение корректного остатка
    @Test(dataProvider = "TaskFloorDiv1")
    public void TaskFloorDiv1(int n, int m, int res)
    {
        System.out.println("Задание 3.1");
        //корректные значения
        int result = Math.floorDiv(n, m);
        System.out.println("Первое число = " + n + "; Второе число = " + m);
        System.out.println("Результат floorDiv: " + result);
        System.out.println("Проверка: " + res);
        Assert.assertEquals(result, res);
        System.out.println();
    }

    //data-prov TaskFloorDiv2
    @DataProvider(name = "TaskFloorDiv2")
    public Object[][] data_prov7()
    {
        double max = Integer.MAX_VALUE - 1;
        double min = Integer.MIN_VALUE + 1;
        int n = (int)(Math.random() * max);
        int m = (int)(Math.random() * min);
        int s = n + m;
        return new Object[][]
                {
                        {s}
                };
    }
    //тестирование деления на 0
    @Test(dataProvider = "TaskFloorDiv2")
    public void TaskFloorDiv2(int n)
    {
        System.out.println("Задание 3.2");

        int m = 0;
        try {
            Math.floorDiv(n,m);
        }
        catch (Throwable e)
        {
            System.out.println("Ожидаем: исключение (by zero)");
            System.out.println("Исключение: " + e);
            Assert.assertEquals(e.toString(),"java.lang.ArithmeticException: / by zero");
        }
        System.out.println();
    }
}
