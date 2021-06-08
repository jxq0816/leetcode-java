package utils;

import java.util.regex.Pattern;

/**
 * 计算imei校验位的值
 */
public class UGetImeiCheckBit{

    // 预编译正则表达式
    private final static Pattern imeiPattern = Pattern.compile("[0-9]{15}.*");

    public String evaluate(String imei){
        try {
            // 如果开头是15位数字，就认为可能是imei
            if (imeiPattern.matcher(imei).matches()) {
                return getImeiCheckBit(imei);
            }
            else {
                return "InvalidFormat";
            }
        } catch (Exception e) {
            return "Error";
        }
    }

    /**
     * 计算imei校验位的值
     * Luhn算法 来源 电信产业终端协会官网 http://www.taf.net.cn/
     * @param imei 15位数字的imei
     * @return 校验位字符串
     */
    private String getImeiCheckBit(String imei){

        // 截取imei前14位
        imei = imei.substring(0, 14);

        // 将string变成数组
        int sum = 0;

        // 处理imei各位数字，根据奇偶位进行不同处理
        for (int i = 0; i < imei.length(); i++) {

            // 取指定位置的数字
            int number = imei.charAt(i) - '0';

            // 如果是偶数位，乘以2
            if (i % 2 == 1){
                number *= 2;
            }

            // 计算个位数和十位数之和，如果超过10，则为 个位+1，例如 11 = 1+1 = 11-9
            sum += number >9 ? number -9 : number;

        }

        // Luhn算法：将上步得出的所有结果相加得到的和，用10减去其最后一位；如果结果为10，则校验位为0，其它情况取原结果。
        return Integer.toString((10 - sum % 10) == 10 ? 0 : (10 - sum % 10));
    }

    public static void main(String [] args){

        // 测试正则
        String imei = "355766043371076";
        UGetImeiCheckBit checkBit=new UGetImeiCheckBit();

        System.out.println(checkBit.evaluate(imei));

//
//
//        if (Pattern.compile("[0-9]{15}.*").matcher(imei).matches()) {
//            System.out.println(imei.substring(0,15));
//        }
//
//        String str = "0123456789";
//
//        // 测试转string，再转int效率
//        long start1 = System.currentTimeMillis();
//
//        for(int i=0; i<10000000; i++){
//
//            for (int j=0; j<10; j++){
//                int number = Integer.parseInt(String.valueOf(str.charAt(j)));
//            }
//        }
//        long end1 = System.currentTimeMillis();
//
//        // 测试charAt效率
//        long start2 = System.currentTimeMillis();
//        for(int i=0; i<10000000; i++){
//
//            for (int j=0; j<10; j++){
//                int number = str.charAt(j) - '0';
//            }
//        }
//        long end2 = System.currentTimeMillis();
//
//        /*  转string,再转int用时：654
//         *  减去字符'0'用时：59
//         */
//        System.out.println("转string,再转int用时："+(end1 - start1));
//        System.out.println("减去字符'0'用时："+(end2 - start2));


    }
}
