package cn.edu.gdupt.common;

import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import cn.edu.gdupt.model.User;

import com.google.gson.Gson;

public class GsonUtil {
	static String beanListToJson;
	public static  String getJson(final String  url){  
		 
//      new Thread() {
    	 

//		public void run() {
    		   HttpClient client = new DefaultHttpClient();  
    	          
    	        HttpPost  request;  
    	        try {  
    	         request = new HttpPost(new URI(url));  
    	         HttpResponse  response  =  client.execute(request);  
    	           // 判断请求是否成功      
    	         if (response.getStatusLine().getStatusCode() == 200) { //200表示请求成功    
    	             HttpEntity  entity = response.getEntity();  
    	             if(entity!=null){  
//    	            	 System.out.println("111111111111111111");
    	                 beanListToJson = EntityUtils.toString(entity,"utf8");
    	             }  
//    	        	 System.out.println("222222222222222222222222");

    	         }  
    	  } catch (Exception e) {  
    	         // TODO: handle exception  
    	     }  
//    	      return  null;  
//    	  }
//      }.start();
     
 
      return beanListToJson;
      
    }  
	public  static  List<User>  getListFromJson(String json){  
     java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<User>>() {  
     }.getType();  
     Gson gson = new Gson();  
     List<User>  list  = gson.fromJson(json, type);  
     return list;  
}  
}
