package com.luster.fistIdeaItem.arithmetic;

/**
 * Created by dell on 2018-1-24.
 * 动态规划算法
 */
public class DynamicTest {

    private final static int[] w = {0, 2, 3, 4, 5};//物品体积
    private final static int[] v = {0, 3, 4, 5, 6};//物品价值
    private final static int[] item = new int[w.length];
    private final static int capacity=8;//背包容量
    private final static int number=w.length;//物品数
    private final static int[][] V=new int[number][capacity+1];


    /**
     * @param capacity 最大容量
     */
    private static void findOptimals(int capacity) {
        int i, j;
        //填表
        for (i = 0; i < number; i++) {
            for (j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    V[i][j] = 0;
                } else {
                    if (j < w[i])//包装不进
                    {
                        V[i][j] = V[i - 1][j];
                    } else//能装
                    {
                        if (V[i - 1][j] > V[i - 1][j - w[i]] + v[i])//不装价值大
                        {
                            V[i][j] = V[i - 1][j];
                        } else//前i-1个物品的最优解与第i个物品的价值之和更大
                        {
                            V[i][j] = V[i - 1][j - w[i]] + v[i];
                        }
                    }
                }
            }
        }
    }

    /**
     * 寻找解的组成方式
     *
     * @param i
     * @param j
     */
    private static void findWhat( int i, int j) {
        if (i >= 1) {
            if (V[i][j] == V[i - 1][j])//相等说明没装
            {
                item[i] = 0;//全局变量，标记未被选中
                findWhat( i - 1, j);
            } else if (j - w[i] >= 0 && V[i][j] == V[i - 1][j - w[i]] + v[i]) {
                item[i] = 1;//标记已被选中
                findWhat( i - 1, j - w[i]);//回到装包之前的位置
            }
        }
    }

    public static void main(String[] args) {
        int capacity = 8;
        findOptimals(capacity);
        findWhat(4, capacity);
        for(int i=0;i<item.length;i++){
            System.out.print(" "+i);
            System.out.print(" "+w[i]);
            System.out.print(" "+v[i]);
            System.out.print(" "+item[i]);
            System.out.println("");
        }
    }
}
