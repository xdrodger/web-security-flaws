/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) radix(10) lradix(10) 
// Source File Name:   Page.java

package pers.xdrodger.wsf.dao;

import com.google.common.collect.Lists;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Page
{

    public Page()
    {
        pageNo = 1;
        pageSize = -1;
        orderBy = null;
        order = null;
        autoCount = true;
        result = Lists.newArrayList();
        totalCount = -1L;
    }

    public Page(int pageSize)
    {
        pageNo = 1;
        this.pageSize = -1;
        orderBy = null;
        order = null;
        autoCount = true;
        result = Lists.newArrayList();
        totalCount = -1L;
        this.pageSize = pageSize;
    }

    public int getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
        if(pageNo < 1)
            this.pageNo = 1;
    }

    public Page pageNo(int thePageNo)
    {
        setPageNo(thePageNo);
        return this;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public Page pageSize(int thePageSize)
    {
        setPageSize(thePageSize);
        return this;
    }

    public int getFirst()
    {
        return (pageNo - 1) * pageSize + 1;
    }

    public String getOrderBy()
    {
        return orderBy;
    }

    public void setOrderBy(String orderBy)
    {
        this.orderBy = orderBy;
    }

    public Page orderBy(String theOrderBy)
    {
        setOrderBy(theOrderBy);
        return this;
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder(String order)
    {
        String lowcaseOrder = StringUtils.lowerCase(order);
        String orders[] = StringUtils.split(lowcaseOrder, ',');
        String as[];
        int j = (as = orders).length;
        for(int i = 0; i < j; i++)
        {
            String orderStr = as[i];
            if(!StringUtils.equals("desc", orderStr) && !StringUtils.equals("asc", orderStr))
                throw new IllegalArgumentException((new StringBuilder("\u6392\u5E8F\u65B9\u5411")).append(orderStr).append("\u4E0D\u662F\u5408\u6CD5\u503C").toString());
        }

        this.order = lowcaseOrder;
    }

    public Page order(String theOrder)
    {
        setOrder(theOrder);
        return this;
    }

    public boolean isOrderBySetted()
    {
        return StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(order);
    }

    public boolean isAutoCount()
    {
        return autoCount;
    }

    public void setAutoCount(boolean autoCount)
    {
        this.autoCount = autoCount;
    }

    public Page autoCount(boolean theAutoCount)
    {
        setAutoCount(theAutoCount);
        return this;
    }

    public List getResult()
    {
        return result;
    }

    public void setResult(List result)
    {
        this.result = result;
    }

    public long getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }

    public long getTotalPages()
    {
        if(totalCount < 0L)
            return -1L;
        long count = totalCount / (long)pageSize;
        if(totalCount % (long)pageSize > 0L)
            count++;
        return count;
    }

    public boolean isHasNext()
    {
        return (long)(pageNo + 1) <= getTotalPages();
    }

    public int getNextPage()
    {
        if(isHasNext())
            return pageNo + 1;
        else
            return pageNo;
    }

    public boolean isHasPre()
    {
        return pageNo - 1 >= 1;
    }

    public int getPrePage()
    {
        if(isHasPre())
            return pageNo - 1;
        else
            return pageNo;
    }

    public static final String ASC = "asc";
    public static final String DESC = "desc";
    protected int pageNo;
    protected int pageSize;
    protected String orderBy;
    protected String order;
    protected boolean autoCount;
    protected List result;
    protected long totalCount;
}


/*
	DECOMPILATION REPORT

	Decompiled from: C:\Users\Administrator\git\wizarposOpen-server\wizarposOpen-server\src\main\webapp\WEB-INF\lib\wizarpos-wxcore.jar
	Total time: 78 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/