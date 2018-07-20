package com.luster.fistIdeaItem;

/**
 * 5TB的硬盘上放满了数据，请写一个算法将这些数据进行排重。如果这些数据是一些32bit大小的数据该如何解决？
 * 32bit数据的可能值有2^32bit=2^29Byte=512MB
 * 为所有可能值分配一个bit标识位，存在则标识为1，不存在则标识为0
 */
public class BitMapTest {

    public static final int _MB = 2 << 19;//左移19位,2^20

    //每个byte记录8bit信息,也就是8个数是否存在于数组中
    public static byte[] flags = new byte[512 * _MB];

    public static void main(String args[]) {
        //待判重数据
        int[] array = {0,1, 2, 3, 4, 5, 6, 7, 8,1,2,3,4};
        int index = 0;
        for(int num : array) {
            if(!getFlags(num)) {
                //未出现的元素
                array[index] = num;
                index = index + 1;
                //设置标志位
                setFlags(num);
                System.out.println("set " + num);
            } else {
                System.out.println(num + " already exist");
            }
        }
    }

    public static void setFlags(int num) {
        //num>>3 等于num/8,确定num在第几个字节；num & (0x07)等于num%8,确定num在字节中第几个位置
        flags[num >> 3] |= 0x01 << (num & (0x07));
    }

    public static boolean getFlags(int num) {
        return (flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01;
    }
}
