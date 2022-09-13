package com.orders.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class test {
	public static void main(String[] args) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		System.out.println(new Timestamp(System.currentTimeMillis()));
	}
}
