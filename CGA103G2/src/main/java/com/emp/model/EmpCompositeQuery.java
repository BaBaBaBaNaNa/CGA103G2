/*
 *  1. 萬用複合查詢-可由客戶端隨意增減任何想查詢的欄位
 *  2. 為了避免影響效能:
 *     所以動態產生萬用SQL的部份,本範例無意採用MetaData的方式,也只針對個別的Table自行視需要而個別製作之
 * */


package com.emp.model;

import java.util.*;

public class EmpCompositeQuery {

	public static String getConditionForMyDB(String columnName, String value) {

		String aCondition = null;

		 // 用於其他
		if ("empID".equals(columnName) || "jobID".equals(columnName)) {
			aCondition = columnName + "=" + value;
		}
		// 用於varchar
		else if ("empName".equals(columnName) || "jobName".equals(columnName)) {
			aCondition = columnName + " like '%" + value + "%'";
		}
		// 用於date
		else if ("empHiredate".equals(columnName)){
			aCondition = columnName + "=" + "'"+ value +"'";                          //for 其它DB  的 date
//		    aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";  //for Oracle 的 date
		}   
		return aCondition + " ";
	}

	public static String getWhereCondition(Map<String, String[]> map) {
		Set<String> keys = map.keySet();
		StringBuffer whereCondition = new StringBuffer();
		int count = 0;
		for (String key : keys) {
			String value = map.get(key)[0];
			if (value != null && value.trim().length() != 0	&& !"action".equals(key)) {
				count++;
				String aCondition = getConditionForMyDB(key, value.trim());

				if (count == 1)
					whereCondition.append(" where " + aCondition);
				else
					whereCondition.append(" and " + aCondition);

				System.out.println("有送出查詢資料的欄位數count = " + count);
			}
		}
		
		return whereCondition.toString();
	}

	public static void main(String argv[]) {

		// 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
		Map<String, String[]> map = new TreeMap<String, String[]>();
		map.put("empID", new String[] { "2" });
		map.put("empName", new String[] { "KING" });
//		map.put("empAccount", new String[] { "PRESIDENT" });
//		map.put("empPassword", new String[] { "1981-11-17" });
//		map.put("empPermission", new String[] { "5000.5" });
//		map.put("empPhone", new String[] { "0.0" });
//		map.put("empAddress", new String[] { "10" });
//		map.put("jobID", new String[] { "getXXX" });
//		map.put("empHiredate", new String[] { "getXXX" });

		String finalSQL = "select * from employee "
				          + EmpCompositeQuery.getWhereCondition(map)
				          + "order by empID";
		System.out.println("●●finalSQL = " + finalSQL);

	}
}
