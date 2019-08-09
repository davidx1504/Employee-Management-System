package com.ems.utility;

import java.util.List;

import com.ems.model.Model;

public class JSPUtility {
	public String formatToTable(List<Object> list) {
		String ret="";
		int i=1;
		for(Object obj : list) {
			Model m = (Model) obj;
			List<String> cells = m.toList();
			ret += "<tr><td>"+(i++)+"</td>";
			for(String cell: cells) {
				ret +="<td>"+cell+"</td>";
			}
			ret += "</tr>";
		}
		return ret;
	}
	public String formatToTable(Object obj) {
		String ret="<tr><td>1</td>";
		Model m = (Model) obj;
		List<String> cells = m.toList();
		for(String cell: cells) {
			ret +="<td>"+cell+"</td>";
		}
		ret+="</tr>";
		return ret;
	}
}
