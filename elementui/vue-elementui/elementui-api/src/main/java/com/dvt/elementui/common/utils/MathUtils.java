package com.dvt.elementui.common.utils;

import java.math.BigDecimal;

public class MathUtils {
    /**
     * 用于数值的计算 加
     * @param a double 数值 a
     * @param b double 数值 b
     * @return double
     */
    public static double BDadd(double a,double b){
        BigDecimal b1=new BigDecimal(Double.toString(a));
        BigDecimal b2=new BigDecimal(Double.toString(b));
        b1=b1.add(b2);
        return b1.doubleValue();
    }
    /**
     * 用于数值的计算 加 先转换为Bigdecimal后运算
     * @param a Double 数值 a
     * @param b Double 数值 b
     * @param scale 精确到小数点的位数
     * @return double
     * */
    public static double BDadd(double a,double b,int scale){
        return round(BDadd(a,b),scale);
    }
    /**
     * 对两数值进行相加;scale=-1时,不进行精度运算
     * @param a Double 数值 a
     * @param b Double 数值 b
     * @param scale int 精度值
     * @return  Double
     */
    public static Double BDadd(Double a,Double b,int scale){
        if(a==null||b==null)
            throw new IllegalArgumentException("运算参数为空!");
        return Double.valueOf(round(scale,new BigDecimal(BDadd(a.doubleValue(),b.doubleValue()))).doubleValue()+"");
    }
    /**
     * 对两数值进行相加;scale=-1时,不进行精度运算
     * @param a BigDecimal
     * @param b BigDecimal
     * @param scale int
     * @return  BigDecimal
     */
    public static BigDecimal BDadd(BigDecimal a,BigDecimal b,int scale){
        if(a==null||b==null)
            throw new IllegalArgumentException("运算参数为空!");
        return round(scale,a.add(b));
    }

    /**
     * 用于数值的计算 乘 先转换为Bigdecimal后运算
     * @param a Double 数值 a
     * @param b Double 数值 b
     * @return double
     * */
    public static double BDmultiply(double a,double b){
        BigDecimal b1=new BigDecimal(Double.toString(a));
        BigDecimal b2=new BigDecimal(Double.toString(b));
        b1=b1.multiply(b2);
        return b1.doubleValue();
    }

    /**
     * 用于数值的计算 乘 先转换为Bigdecimal后运算
     * @param a double
     * @param b double
     * @param scale 精确到小数点的位数
     * @return double
     * */
    public static double BDmultiply(double a,double b,int scale){
        return round(BDmultiply(a,b),scale);
    }

    /**
     * 对两数值进行相乘;scale=-1时,不进行精度运算
     * @param a Double 数值 a
     * @param b Double 数值 b
     * @param scale int 精度
     * @return Double
     *
     * */
    public static Double BDmultiply(Double a,Double b,int scale){
        if(a==null||b==null)
            throw new IllegalArgumentException("运算参数为空!");
        return Double.valueOf(
                round(scale,new BigDecimal(BDmultiply(a.doubleValue(),b.doubleValue()))).doubleValue()+"");
    }
    /**
     * 对两数值进行相乘;scale=-1时,不进行精度运算
     * @param a BigDecimal 数值 a
     * @param b BigDecimal 数值 b
     * @param scale int 精度
     * @return BigDecimal
     */
    public static BigDecimal BDmultiply(BigDecimal a,BigDecimal b,int scale){
        if(a==null||b==null)
            throw new IllegalArgumentException("运算参数为空!");
        return round(scale,a.multiply(b));
    }


    /**
     * 用于数值的计算 减 return = a - b 先转换为Bigdecimal后运算
     * @param a double
     * @param b double
     * @return double
     * */
    public static double BDsubtract(double a,double b){
        BigDecimal b1=new BigDecimal(Double.toString(a));
        BigDecimal b2=new BigDecimal(Double.toString(b));
        b1=b1.subtract(b2);
        return b1.doubleValue();
    }

    /**
     * 用于数值的计算 减 return = a - b 先转换为Bigdecimal后运算
     * @param a double
     * @param b double
     * @param scale 精确到小数点的位数
     * @return double
     * */
    public static double BDsubtract(double a,double b,int scale){
        return round(BDsubtract(a,b),scale);
    }
    /**
     * 对两数值进行相减(a-b);scale=-1时,不进行精度运算
     * @param a Double 数值 a
     * @param b Double 数值 b
     * @param scale int 精度
     * @return Double
     *
     * */
    public static Double BDsubtract(Double a,Double b,int scale){
        if(a==null||b==null)
            throw new IllegalArgumentException("运算参数为空!");
        return Double.valueOf(
                round(scale,new BigDecimal(BDsubtract(a.doubleValue(),b.doubleValue()))).doubleValue()+"");
    }
    /**
     * 对两数值进行相减(a-b);scale=-1时,不进行精度运算
     * @param a BigDecimal 数值 a
     * @param b BigDecimal 数值 b
     * @param scale int 精度
     * @return BigDecimal
     */
    public static BigDecimal BDsubtract(BigDecimal a,BigDecimal b,int scale){
        if(a==null||b==null)
            throw new IllegalArgumentException("运算参数为空!");
        return round(scale,a.subtract(b));
    }

    /**
     * @deprecated
     * 用于数值的计算 除 return= a / b 先转换为Bigdecimal后运算 只适于可以整除的应用，
     * 该方法已不推荐使用，请使用BDdivide(double a,double b,int scale)代替
     * @param a double
     * @param b double
     * @return double
     * */
    public static double BDdivide(double a,double b){
        BigDecimal b1=new BigDecimal(Double.toString(a));
        BigDecimal b2=new BigDecimal(Double.toString(b));
        b1=b1.divide(b2,BigDecimal.ROUND_UNNECESSARY);
        return b1.doubleValue();
    }
    /**
     * 用于数值的计算 除 return= a / b 先转换为Bigdecimal后运算
     * @param a double
     * @param b double
     * @param scale 精确到小数点的位数
     * @return double
     * */
    public static double BDdivide(double a,double b,int scale){
        BigDecimal b1=new BigDecimal(Double.toString(a));
        BigDecimal b2=new BigDecimal(Double.toString(b));
        b1=b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
        return b1.doubleValue();
    }
    /**
     * 对两数值进行相除a/b;
     * @param a Double 数值 a
     * @param b Double 数值 b
     * @param scale int 精度
     * @return Double
     * */
    public static Double BDdivide(Double a,Double b,int scale){
        if(a==null||b==null)
            throw new IllegalArgumentException("运算参数为空!");
        return Double.valueOf(BDdivide(a.doubleValue(),b.doubleValue(),scale)+"");
    }
    /**
     * 对两数值进行相除a/b;
     * @param a BigDecimal 数值 a
     * @param b BigDecimal 数值 b
     * @param scale int 精度
     * @return BigDecimal
     */
    public static BigDecimal BDdivide(BigDecimal a,BigDecimal b,int scale){
        if(a==null||b==null)
            throw new IllegalArgumentException("运算参数为空!");
        return a.divide(b,scale,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 用于Double数据的精度运算
     * @param db
     * @param scale
     * @param roundmode  使用BigDecimal的处理方式 例如BigDecimal.ROUND_FLOOR表示向下取整
     * @return
     */
    public static Double round(Double db,int scale,int roundmode){
        if(db==null)
            throw new IllegalArgumentException("运算参数为空!");
        BigDecimal dbr = new BigDecimal(db.doubleValue());
        BigDecimal base = new BigDecimal("1");
        dbr=dbr.divide(base,scale,roundmode);
        return new Double(dbr.doubleValue());

    }

    /**
     * 用于double数据的四舍五入
     * @param d double
     * @param scale int
     * @return double
     */
    public static double round(double d,int scale){
        return round(new BigDecimal(Double.toString(d)),scale);
    }

    /**
     * 用于double数据的四舍五入
     * @param bd BigDecimal
     * @param scale int
     * @return double
     */
    private static double round(BigDecimal bd,int scale){
        BigDecimal base = new BigDecimal("1");
        bd=bd.divide(base,scale,BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
    /**
     * 用于BigDecimal数据的四舍五入
     * @param scale 精度,-1时返回原值
     * @param bd 传进的大数据数值
     * @return 大数据数值
     */
    private static BigDecimal round(int scale,BigDecimal bd){
        if(scale<0)
            return bd;
        return new BigDecimal(round(bd,scale)+"");
    }
    /**
     * 用于float数据的四舍五入
     * @param d float
     * @param scale int
     * @return float
     */
    public static float round(float d,int scale){
        BigDecimal b1=new BigDecimal(""+d);
        BigDecimal base = new BigDecimal("1");
        b1=b1.divide(base,scale,BigDecimal.ROUND_HALF_UP);
        return b1.floatValue();
    }

    /**
     * Double,Float空值处理
     * @param d Object(Double,Float)
     * @param defaultValue double
     * @return double
     * @deprecated
     * 请使用NumberUtil.getDoubleValue
     */
    public static double getDoubleValue(Object d,double defaultValue){
        if(d==null){
            return defaultValue;
        }else{
            if(d instanceof Double)
                return ((Double)d).doubleValue();
            else if(d instanceof Float)
                return ((Float)d).doubleValue();
            else
                return defaultValue;
        }
    }
    /**
     * Integer空值处理
     * @param i Integer
     * @param defaultValue int
     * @return int
     * @deprecated
     * 请使用NumberUtil.intValue
     */
    public static int getIntegerValue(Integer i,int defaultValue){
        if(i==null){
            return defaultValue;
        }else{
            return i.intValue();
        }
    }
    /**
     * Double类型数据转换成double类型数据
     * @param d  -Double类型数据
     * @return double类型数据
     * @deprecated
     * 请使用NumberUtil.doubleValue
     */
    public static double doubleValue(Double d,double defaultValue)
    {
        if (d == null)
            return defaultValue;
        else
            return d.doubleValue();
    }
    /**
     * Integer类型数据转换成int类型数据
     * @param i  -Integer类型数据
     * @return int类型数据
     * @deprecated
     * 请使用NumberUtil.intValue
     */
    public static int intValue(Integer i,int defaultValue) {
        if (i == null)
            return defaultValue;
        else
            return i.intValue();
    }
    /**
     * Short类型数据转换成short类型数据
     * @param s  -Short类型数据
     * @return short类型数据
     * @deprecated
     * 请使用NumberUtil.shortValue(Short s)
     */
    public static short shortValue(Short s) {
        short sh =0;
        if (s != null)
            return s.shortValue();
        else
            return sh;
    }

    /**
     * 比较两个值是否相等
     * @param double,double
     * @return int
     * 如果d1-d2的值小于10的-6次方则认为两个数相等
     * 返回值
     * 0  d1=d2
     * 1  d1>d2
     * -1 d1<d2
     */
    public static int compareAmount(double d1,double d2){
        if(d1==d2)
            return 0;
        double result = BDsubtract(d1,d2,10);
        if(Math.abs(result)<=1.0E-6)
            return 0;
        if(result<0)
            return -1;
        return 1;
    }

}
