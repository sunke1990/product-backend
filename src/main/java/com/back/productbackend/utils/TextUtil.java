package com.back.productbackend.utils;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Pattern;

/**
 * text util
 * @author davidwang2006@aliyun.com DavidWang
 * @date 2020/5/26 14:21
 */
public abstract class TextUtil {
    private TextUtil(){}

    public static final char STAR = '*';

    //数字正则表达式
    public static final Pattern REGEXP_NUM = Pattern.compile("\\d+");

    public static final String PATTERN_ID_NUMBER = "\\d{17}([0-9]|X|x)";
    //身份证号码正则表达式
    public static final Pattern REGEXP_ID_NUMBER = Pattern.compile(PATTERN_ID_NUMBER);

    public static final Pattern REGEXP_CHINESE = Pattern.compile("[\u2E80-\u2FD5\u3190-\u319f\u3400-\u4DBF\u4E00-\u9FCC\uF900-\uFAAD]+");

    public static final String PATTERN_PHONE = "1[0-9]{10}";
    public static final String PATTERN_PHONE_OR_EMPTY = "^$|1[0-9]{10}";

    //手机号码
    public static final Pattern REGEXP_PHONE = Pattern.compile(PATTERN_PHONE);

    //math context added by www
    public static final MathContext MATH_CONTEXT = new MathContext(6, RoundingMode.HALF_UP);

    public static final SpelExpressionParser PARSER = new SpelExpressionParser();

    public static final Random RANDOM = new Random(System.currentTimeMillis());


    /**
     * 掩码
     * @param src
     * @return
     */
    public static String mask(String src){

        if(StringUtils.isEmpty(src)){
            return src;
        }
        if(src.length() > 14){
            return maskCertNo(src);
        }
        if(hasChinese(src)){
            return maskName(src);
        }
        return maskPhone(src);
    }

    /**
     * 脱敏房产证号
     * @param src
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-07-08 17:08:31
     * @return
     */
    public static String maskHouseCertNo(String src ){
        if(StringUtils.isEmpty(src)){
            return src;
        }

        char[] arr = src.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(Character.isDigit(c)){
                arr[i] = STAR;
            }
        }

        return new String(arr);
    }

    /**
     * 脱敏手机号码
     * @param phone
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-05-26 14:24:03
     * @return
     */
    public static String maskPhone(String phone){
        if(StringUtils.isEmpty(phone)){
            return phone;
        }
        char[] arr = phone.toCharArray();
        if(arr.length < 7){
            return phone;
        }
        for(int i = 3; i < 7;i++){
            arr[i] = STAR;
        }
        return new String(arr);
    }

    /**
     * 脱敏身份证
     * @param certNo
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-05-26 14:26:47
     * @return
     */
    public static String maskCertNo(String certNo){
        if(StringUtils.isEmpty(certNo)){
            return certNo;
        }

        char[] arr = certNo.toCharArray();
        if(arr.length < 14){
            return certNo;
        }
        for(int i = 3; i < 14; i++){
            arr[i] = STAR;
        }
        return new String(arr);
    }

    /**
     * 只显示姓，名隐藏
     * @param name
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-06-05 13:38:30
     * @return
     */
    public static String maskName(String name){
        if(StringUtils.isEmpty(name)){
            return name;
        }
        char[] arr = name.toCharArray();
        for(int i = arr.length > 3 ? 2 : 1; i < arr.length; i++){
            arr[i] = STAR;
        }

        return new String(arr);

    }

    /**
     * 房号前两位隐藏
     * @param room
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-06-05 13:38:30
     * @return
     */
    public static String maskRoom(String room){
        if(StringUtils.isEmpty(room)){
            return room;
        }
        char[] arr = room.toCharArray();
        for(int i = 0; i < (arr.length > 2 ? 2 : arr.length); i++){
            arr[i] = STAR;
        }

        return new String(arr);

    }
    /**
     *
     * @param pattern
     * @return
     */
    public static String now(String pattern){
        return new SimpleDateFormat(pattern).format(new Date());
    }

    /**
     *
     * @param pattern
     * @return
     */
    public static String format(String pattern,Date date){
        if(date == null){
            return "";
        }
        return new SimpleDateFormat(pattern).format(date);
    }


    /**
     * safe the string
     * @param text
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-06-11 11:06:13
     * @return
     */
    public String safe(String text){
        return text == null ? "" : text;
    }


    /**
     * 判断是否是有效的长整型
     * @param src
     * @return
     */
    public static boolean isNotEmpty(Long src){
        return src != null && src.compareTo(0L) > 0;
    }


    /**
     *
     * 格式化标题
     * @param date
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-07-01 13:53:10
     * @return
     */
    public static String cmtTitle(Date date){
       return new SimpleDateFormat("yyyy年MM月dd日业委会选举").format(date);
    }

    /**
     * now
     * @return
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-07-27 16:12:58
     */
    public static Date now(){
        return GregorianCalendar.getInstance().getTime();
    }

    /**
     * 是到性别
     * @param idNumber
     * @return  1男 2女
     */
    public static int gender(String idNumber){
        if (idNumber.length() < 17) return 1;
        return Character.getNumericValue(idNumber.charAt(16)) % 2 == 0 ? 2 : 1;
    }

    /**
     * short uuid
     * @return
     */
    public static String shortUUID(){
        UUID uuid = UUID.randomUUID();

        byte[] bs = uuid.toString().getBytes();
        long l = ByteBuffer.wrap(bs).getLong();

        String str = Long.toString(l < 0 ? -l : l, Character.MAX_RADIX);
        return str;

    }

    /**
     * 缩小化
     * @param line
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-09-09 18:13:12
     * @return
     */
    public static String minify(String line){
        if(StringUtils.isEmpty(line)){
            return line;
        }

        if(line.length() > 300){
            return line.substring(0, 300) + "...";
        }
        return line;

    }

    /**
     * 从身份证号码得到年龄
     * @param idNumber
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-10-13 11:44:08
     * @return
     */
    public static int age(String idNumber){
        if(StringUtils.isEmpty(idNumber) || idNumber.length() != 18){
            return -1;
        }
        //3422211987
        int anchor = Integer.parseInt(idNumber.substring(6, 10));

        return GregorianCalendar.getInstance().get(Calendar.YEAR) - anchor;
    }

    /**
     * yyyyMMdd
     * @param date
     * @return
     */
    public static int ymd(Date date){
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        return cal.get(Calendar.YEAR) * 10000 + (cal.get(Calendar.MONTH) + 1) * 100 + cal.get(Calendar.DATE);
    }

    /**
     * get remote ip
     * @param request
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-12-08 11:21:07
     * @return
     */
    public static String ip(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(StringUtils.isEmpty(ip)){
            ip = request.getHeader("x-real-ip");
        }

        if(StringUtils.isEmpty(ip)){
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * fake Id Number
     * @return
     */
    public static String fakeIdNumber(){

        // len 13
        long curr = System.currentTimeMillis();

        return String.format("0%014d%03d", curr,RANDOM.nextInt(999));
    }

    public static String extractException(Exception ex){
        if(ex.getCause() != null){
            return ex.getCause().getMessage();
        }
        return ex.getMessage();
    }

    /**
     * 计算天的差值
     * @param d1
     * @param d2
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-03-24 13:51:59
     * @return
     */
    public static int dateDiff(Date d1, Date d2){
        long delta = ChronoUnit.DAYS.between(d1.toInstant(), d2.toInstant());

        return (int)Math.abs(delta);
    }

    /**
     * 取第几个值
     * @param src
     * @param idx
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-06-03 14:58:32
     * @return
     */
    public static String v(List<String> src, int idx){
        String value = src.size() > idx ? src.get(idx) : null;
        if(Objects.isNull(value)) return value;
        return value.trim();
    }

    public static boolean isEmpty(List<?> list){
        return Objects.isNull(list) || list.size() == 0;
    }

    /**
     * 获取客服消息redis key
     * @param userId
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-05-25 10:17:31
     * @return
     */
    public static String custServiceKey(Long userId){
        return String.format("custservice:msg:%08d",userId);
    }

    /**
     * 判断内容是否为手机号
     * @param phone
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-06-11 15:38:29
     * @return
     */
    public static boolean isPhone(String phone){
        if(StringUtils.isEmpty(phone)){
            return false;
        }
        return REGEXP_PHONE.matcher(phone).matches();
    }

    /**
     * 判断内容是不是身份证号码
     * @param idNumber
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-08-26 14:02:30
     * @return
     */
    public static boolean isIdNumber(String idNumber){
        if(StringUtils.isEmpty(idNumber)){
            return false;
        }
        return REGEXP_ID_NUMBER.matcher(idNumber).matches();
    }


    /**
     * 判断是否有特殊字符
     * @param str
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-07-14 17:46:31
     * @return
     */
    public static boolean hasSpecialChar(String str){
        if(StringUtils.isEmpty(str)){
            return false;
        }
        if(str.indexOf('\n') >= 0 || str.indexOf('\r') >= 0
                || str.indexOf(' ') >= 0
                || str.indexOf('(') >= 0
                || str.indexOf(')') >= 0
                || str.indexOf('（') >= 0
                || str.indexOf('）') >= 0
                || str.indexOf('\t') >= 0) {
            return true;
        }
        return false;
    }



    /**
     * purify 移除前缀0以及汉字
     * @param text
     * @return
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-07-20 14:28:35
     */
    public static String purifyRoomText(String text){
        char[] chars = text.toCharArray();
        if(chars.length < 2){
            return text;
        }

        int start = -1;
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if(start == -1 && curr != '0' && curr <= '\u007f'){
                start = i;
                len++;
                continue;
            }

            if(start > -1 && curr > '\u007f'){
                break;
            }
            if(start > -1){
                len++;
            }
        }

        if(start == -1){
            return text;
        }

        return new String(chars, start, len);
    }



    /**
     * 校验是否有中文字符
     * @param str
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-07-27 11:11:05
     * @return
     */
    public static boolean hasChinese(String str){
        if(StringUtils.isEmpty(str)){
            return false;
        }

        return REGEXP_CHINESE.matcher(str).find();
    }

    /**
     * 接接单元字符串
     * @param unit
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-07-27 11:17:21
     * @return
     */
    public static String unitName(String unit){
        if(hasChinese(unit)){
            return unit;
        }
        return String.format("%s单元",unit);
    }


    /**
     * 组装房间地址
     * @param blockName
     * @param building
     * @param unit
     * @param room
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-07-27 16:06:01
     * @return
     */
    public static String houseAddress(String blockName, String building, String unit, String room){
        if(StringUtils.isEmpty(room)){
            return "";
        }
        unit = TextUtil.unitName(unit);
        if(room.contains("单元")){
            unit = "";
        }
        if(!room.contains("室")){
            room = String.format("%s室",room);
        }
        return String.format("%s%s%s%s", blockName,building,unit,room);
    }

    /**
     * 组装房间地址
     * @param building
     * @param unit
     * @param room
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2021-07-27 16:06:01
     * @return
     */
    public static String houseAddress(String building, String unit, String room){
        if(StringUtils.isEmpty(room)){
            return "";
        }
        unit = TextUtil.unitName(unit);
        if(room.contains("单元")){
            unit = "";
        }
        if(!room.contains("室")){
            room = String.format("%s室",room);
        }
        return String.format("%s%s%s", building,unit,room);
    }

    /**
     * 通过身份证获取年龄
     * @param idCard
     * @return
     */
    public static int ageFromIdCard(String idCard) {


        if (idCard == null || "".equals(idCard)) {
            return -1;
        }

        if(idCard.contains("*")){
            return -1;
        }

        // if (!PATTERN_ID_NUMBER.matches(idCard)) {
        //     return -1;
        // }


        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayNow = cal.get(Calendar.DATE);

        int year = Integer.parseInt(idCard.substring(6, 10));
        int month = Integer.parseInt(idCard.substring(10, 12));
        int day = Integer.parseInt(idCard.substring(12, 14));

        if ((month < monthNow) || (month == monthNow && day <= dayNow)) {
            return yearNow - year;
        } else {
            return yearNow - year - 1;
        }
    }

    /**
     * 格式化百分比
     * @param numerator
     * @param denominator
     * @param fractionDigits 保留小数点后位数
     * @return
     */
    public static String percentFormat(int numerator,int denominator,int fractionDigits){
        if(denominator == 0){
            return "";
        }

        NumberFormat nt = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(fractionDigits);
        return nt.format(1.0d * numerator / denominator);
    }

    /**
     * 格式化百分比
     * @param numerator
     * @param denominator
     * @param fractionDigits 保留小数点后位数
     * @return
     */
    public static String percentFormat(BigDecimal numerator, BigDecimal denominator, int fractionDigits){
        if(denominator.compareTo(BigDecimal.ZERO) == 0){
            return "";
        }

        NumberFormat nt = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(fractionDigits);
        return nt.format(numerator.doubleValue() / denominator.doubleValue());
    }


    /**
     * 只有十位时，才转换
     * @param decimalSn
     * @author davidwang2006@aliyun.com wangweiwei
     * @return
     */
    public static String cardSn2Hex(String decimalSn){
        if(Objects.isNull(decimalSn)){
            return decimalSn;
        }
        char[] chars = decimalSn.toCharArray();
        //如果含有十六进制字符，则直接返回
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'A'){
                return decimalSn;
            }
        }

        if(chars.length <= 8){
            return decimalSn;
        }

        int i = Integer.parseUnsignedInt(decimalSn, 10);

        i = Integer.reverseBytes(i);

        return String.format("%08X",i);
    }

}
