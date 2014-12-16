/**
 * *****************************************
 * 文件名称: ${type_name} <br/>
 * 系统名称: 直销银行V1.0
 * 模块名称: WEB业务平台帐户类
 * 软件版权: 信雅达系统工程股份有限公司
 * 功能说明: ${todo} ADD FUNCTION. <br/>
 * 系统版本: 1.0.0.1
 * 开发人员:  Terrance
 * 开发时间: 2014/11/18 21:32 <br/>
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期    修改人员    修改说明
 * V3.0.0.2 20130530-01  XXXX        提示报错 M201305300011
 * *******************************************
 */
package net.mindview.util;

import java.util.*;

public class New {
    public static  <K,V> Map<K,V> map(){
        return new HashMap<K,V>();
    }

    public static  <T> List<T> list(){
        return  new ArrayList<T>();
    }
    public static  <T> Set<T> set(){
        return  new HashSet<T>();
    }

    public static  <T> Queue<T> queue(){
        return new LinkedList<T>();
    }


    public static void main(String[] args) {
        Map<String,List<String>>  sls = New.map();
    }
}

