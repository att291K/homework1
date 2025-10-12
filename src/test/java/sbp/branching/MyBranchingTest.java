package sbp.branching;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import sbp.common.Utils;

import static org.mockito.ArgumentMatchers.anyString;

public class MyBranchingTest {

    /**
     * Проверка на 0 при Utils#utilFunc2() возвращающем true
     */
    @Test
    public void maxInt_Test()
    {
        final int int1 = 2;
        final int int2 = 5;

        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);
        int rez = myBranching.maxInt(int1, int2);
        Assertions.assertEquals(0,rez);

        //Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    /**
     * Поверка на результат выполнения метода в зависимости от возможных реализаций {@link Utils}
     */
    @Test
    public void ifElseExample_Test()
    {
        Utils utilsMock = Mockito.mock(Utils.class);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);
        boolean res = myBranching.ifElseExample();
        Assertions.assertTrue(res);
    }

    /**
     * Проверка количества обращений к {@link Utils}
     */
    @Test
    public void switchExample_Test0()
    {
        final int iteration = 0;

        Utils utilsMock = Mockito.mock(Utils.class);
        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(iteration);

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }
    @Test
    public void switchExample_Test1()
    {
        final int iteration = 1;

        Utils utilsMock = Mockito.mock(Utils.class);
        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        MyBranching myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(iteration);

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }
    @Test
    public void switchExample_Test2()
    {
        final int iteration = 2;

        Utils utilsMock = Mockito.mock(Utils.class);
        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(iteration);

        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }
    @Test
    public void switchExample_Test()
    {
        Utils utilsMock = Mockito.mock(Utils.class);
        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        int off = 0;
        for(int i = 0;i<5;i++){
            System.out.println("i="+i);
            MyBranching myBranching = new MyBranching(utilsMock);
            myBranching.switchExample(i);
            if (i==2) {
                off++;
            }

            Mockito.verify(utilsMock, Mockito.times(1+i-off)).utilFunc1(anyString());
            Mockito.verify(utilsMock, Mockito.times(1+i)).utilFunc2();
        }

    }
}
