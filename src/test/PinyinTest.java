/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: PinyinTest.java
 * Author:   weih
 * Date:     2014年10月30日 上午10:21:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package test;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author weih
 */
public class PinyinTest {
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        String hanyu="拗";
        
        
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for(char c : hanyu.toCharArray()){
            String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
            System.out.println(pinyin[0]);
        }
    }
    
    public static String arrayToString(String[] arr){
        StringBuffer sb = new StringBuffer();
        for(String s: arr){
            sb.append(s);
        }
        return sb.toString();
    }
}
