/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) radix(10) lradix(10) 
// Source File Name:   PropertyFilter.java

package pers.xdrodger.wsf.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import java.lang.Enum;
import java.lang.String;

public class PropertyFilter
{
//    public static final class MatchType extends Enum
//    {
//
//        public static MatchType[] values()
//        {
//            MatchType amatchtype[];
//            int i;
//            MatchType amatchtype1[];
//            System.arraycopy(amatchtype = ENUM$VALUES, 0, amatchtype1 = new MatchType[i = amatchtype.length], 0, i);
//            return amatchtype1;
//        }
//
//        public static MatchType valueOf(String s)
//        {
//            return (MatchType)Enum.valueOf(pers/xdrodger/wsf/orm/PropertyFilter$MatchType, s);
//        }
//
//        public static final MatchType EQ;
//        public static final MatchType LIKE;
//        public static final MatchType LT;
//        public static final MatchType GT;
//        public static final MatchType LE;
//        public static final MatchType GE;
//        private static final MatchType ENUM$VALUES[];
//
//        static 
//        {
//            EQ = new MatchType("EQ", 0);
//            LIKE = new MatchType("LIKE", 1);
//            LT = new MatchType("LT", 2);
//            GT = new MatchType("GT", 3);
//            LE = new MatchType("LE", 4);
//            GE = new MatchType("GE", 5);
//            ENUM$VALUES = (new MatchType[] {
//                EQ, LIKE, LT, GT, LE, GE
//            });
//        }
//
//        private MatchType(String s, int i)
//        {
//            super(s, i);
//        }
//    }
//
//    public static final class PropertyType extends Enum
//    {
//
//        public Class getValue()
//        {
//            return clazz;
//        }
//
//        public static PropertyType[] values()
//        {
//            PropertyType apropertytype[];
//            int i;
//            PropertyType apropertytype1[];
//            System.arraycopy(apropertytype = ENUM$VALUES, 0, apropertytype1 = new PropertyType[i = apropertytype.length], 0, i);
//            return apropertytype1;
//        }
//
//        public static PropertyType valueOf(String s)
//        {
//            return (PropertyType)Enum.valueOf(com/wizarpos/wx/core/orm/PropertyFilter$PropertyType, s);
//        }
//
//        public static final PropertyType S;
//        public static final PropertyType I;
//        public static final PropertyType L;
//        public static final PropertyType N;
//        public static final PropertyType D;
//        public static final PropertyType B;
//        public static final PropertyType DL;
//        private Class clazz;
//        private static final PropertyType ENUM$VALUES[];
//
//        static 
//        {
//            S = new PropertyType("S", 0, java/lang/String);
//            I = new PropertyType("I", 1, java/lang/Integer);
//            L = new PropertyType("L", 2, java/lang/Long);
//            N = new PropertyType("N", 3, java/lang/Double);
//            D = new PropertyType("D", 4, java/util/Date);
//            B = new PropertyType("B", 5, java/lang/Boolean);
//            DL = new PropertyType("DL", 6, java/lang/Long);
//            ENUM$VALUES = (new PropertyType[] {
//                S, I, L, N, D, B, DL
//            });
//        }
//
//        private PropertyType(String s, int i, Class clazz)
//        {
//            super(s, i);
//            this.clazz = clazz;
//        }
//    }
//
//
//    public PropertyFilter()
//    {
//        matchType = null;
//        matchValue = null;
//        propertyClass = null;
//        propertyNames = null;
//    }
//
//    public PropertyFilter(String filterName, String value)
//    {
//        matchType = null;
//        matchValue = null;
//        propertyClass = null;
//        propertyNames = null;
//        String firstPart = StringUtils.substringBefore(filterName, "_");
//        String matchTypeCode = StringUtils.substring(firstPart, 0, firstPart.length() - 1);
//        String propertyTypeCode = StringUtils.substring(firstPart, firstPart.length() - 1, firstPart.length());
//        if(filterName.contains("_D_"))
//        {
//            Long times = Long.valueOf(0L);
//            try
//            {
//                times = getMatchValueWithDateType(firstPart, value);
//            }
//            catch(ParseException e)
//            {
//                e.printStackTrace();
//            }
//            value = String.valueOf(times);
//        }
//        try
//        {
//            matchType = (MatchType)Enum.valueOf(com/wizarpos/wx/core/orm/PropertyFilter$MatchType, matchTypeCode);
//        }
//        catch(RuntimeException e)
//        {
//            throw new IllegalArgumentException((new StringBuilder("filter\u540D\u79F0")).append(filterName).append("\u6CA1\u6709\u6309\u89C4\u5219\u7F16\u5199,\u65E0\u6CD5\u5F97\u5230\u5C5E\u6027\u6BD4\u8F83\u7C7B\u578B.").toString(), e);
//        }
//        try
//        {
//            propertyClass = ((PropertyType)Enum.valueOf(com/wizarpos/wx/core/orm/PropertyFilter$PropertyType, propertyTypeCode)).getValue();
//        }
//        catch(RuntimeException e)
//        {
//            throw new IllegalArgumentException((new StringBuilder("filter\u540D\u79F0")).append(filterName).append("\u6CA1\u6709\u6309\u89C4\u5219\u7F16\u5199,\u65E0\u6CD5\u5F97\u5230\u5C5E\u6027\u503C\u7C7B\u578B.").toString(), e);
//        }
//        String propertyNameStr = "";
//        if(!filterName.contains("_D_"))
//            propertyNameStr = StringUtils.substringAfter(filterName, "_");
//        else
//            propertyNameStr = StringUtils.substringAfterLast(filterName, "_");
//        Assert.isTrue(StringUtils.isNotBlank(propertyNameStr), (new StringBuilder("filter\u540D\u79F0")).append(filterName).append("\u6CA1\u6709\u6309\u89C4\u5219\u7F16\u5199,\u65E0\u6CD5\u5F97\u5230\u5C5E\u6027\u540D\u79F0.").toString());
//        propertyNames = StringUtils.splitByWholeSeparator(propertyNameStr, "_OR_");
//        String newValue = getPropertyValueWithDateType(propertyTypeCode, matchTypeCode, value);
//        matchValue = ConvertUtils.convertStringToObject(newValue, propertyClass);
//    }
//
//    private String getPropertyValueWithDateType(String type, String matchTypeCode, String value)
//    {
//        if(type.equals("D"))
//            if(matchTypeCode.equals("GE"))
//                value = (new StringBuilder(String.valueOf(value))).append(" 00:00:01").toString();
//            else
//            if(matchTypeCode.equals("LE"))
//                value = (new StringBuilder(String.valueOf(value))).append(" 23:59:59").toString();
//        return value;
//    }
//
//    private static Long getMatchValueWithDateType(String type, String value)
//        throws ParseException
//    {
//        if(type.equals("GEL"))
//            value = (new StringBuilder(String.valueOf(value))).append(" 00:00:01").toString();
//        else
//        if(type.equals("LEL"))
//            value = (new StringBuilder(String.valueOf(value))).append(" 23:59:59").toString();
//        return strDateTimeToLong(value);
//    }
//
//    public static Long strDateTimeToLong(String date)
//        throws ParseException
//    {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date dt = sdf.parse(date);
//        return Long.valueOf(dt.getTime());
//    }
//
//    public static List buildFromHttpRequest(HttpServletRequest request)
//    {
//        return buildFromHttpRequest(request, "filter");
//    }
//
//    public static List buildFromHttpRequest(HttpServletRequest request, String filterPrefix)
//    {
//        List filterList = new ArrayList();
//        Map filterParamMap = ServletUtils.getParametersStartingWith(request, (new StringBuilder(String.valueOf(filterPrefix))).append("_").toString());
//        for(Iterator iterator = filterParamMap.entrySet().iterator(); iterator.hasNext();)
//        {
//            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
//            String filterName = (String)entry.getKey();
//            String value = (String)entry.getValue();
//            if(StringUtils.isNotBlank(value))
//            {
//                PropertyFilter filter = new PropertyFilter(filterName, value);
//                filterList.add(filter);
//            }
//        }
//
//        return filterList;
//    }
//
//    public Class getPropertyClass()
//    {
//        return propertyClass;
//    }
//
//    public MatchType getMatchType()
//    {
//        return matchType;
//    }
//
//    public Object getMatchValue()
//    {
//        return matchValue;
//    }
//
//    public String[] getPropertyNames()
//    {
//        return propertyNames;
//    }
//
//    public String getPropertyName()
//    {
//        Assert.isTrue(propertyNames.length == 1, "There are not only one property in this filter.");
//        return propertyNames[0];
//    }
//
//    public boolean hasMultiProperties()
//    {
//        return propertyNames.length > 1;
//    }
//
//    public static final String OR_SEPARATOR = "_OR_";
//    private MatchType matchType;
//    private Object matchValue;
//    private Class propertyClass;
//    private String propertyNames[];
}


/*
	DECOMPILATION REPORT

	Decompiled from: C:\Users\Administrator\git\wizarposOpen-server\wizarposOpen-server\src\main\webapp\WEB-INF\lib\wizarpos-wxcore.jar
	Total time: 47 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/