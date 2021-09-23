package com.dbs.java;

import java.util.ArrayList;
import java.util.List;

import com.dbs.interfaces.Filter;

public class exs1 {
	public static void print(List<Integer> list) {
		Filter f = n ->
		{
			if(n%2==0)
				return true;
			return false;
		};
		for(Integer i:list) {
			System.out.println(i+"->"+f.find(i));
		}
			
		}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++)
		list.add(i+1);
		print(list);
	
	}

}
