import java.util.HashMap;

import com.alibaba.fastjson.JSON;

public class Testfa {
	
	
	private static void main(String[] arg0) {
		HashMap<String, Integer> js = new HashMap<>();
		js.put("可乐", 1);
		js.put("鸡米花", 2);
		System.out.println(JSON.toJSONString(js));
	}

}
