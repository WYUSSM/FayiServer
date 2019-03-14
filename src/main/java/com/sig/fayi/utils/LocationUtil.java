package com.sig.fayi.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LocationUtil {

    public static String getDistance(String startLng,String startLat,String endLng,String endLat){
        Map<String, String> params = new HashMap<String, String>();
        params.put("output", "json");//输出方式为json
        params.put("tactics", "12");//10不走高速11常规路线12 距离较短（考虑路况）13距离较短（不考虑路况）
        params.put("ak", "W5bb7eTRrACi61YqfFyIGRZZcZBzhouI");
        params.put("origins", startLat + "," + startLng + "|" + startLat + "," + startLng);
        params.put("destinations", endLat + "," + endLng + "|" + endLat + "," + endLng);

        String result = HttpClientUtil.doGet("http://api.map.baidu.com/routematrix/v2/driving", params);
        com.alibaba.fastjson.JSONArray jsonArray = com.alibaba.fastjson.JSONObject.parseObject(result).getJSONArray("result");
        // 获取距离、米
        String text = jsonArray.getJSONObject(0).getJSONObject("distance").getString("text");
        return text;
    }

    public static JSONObject getAddress(String lng,String lat){
        Map<String, String> params = new HashMap<String, String>();
        params.put("output", "json");//输出方式为json
        params.put("ak", "W5bb7eTRrACi61YqfFyIGRZZcZBzhouI");
        params.put("location", lat+","+lng);
        String result = HttpClientUtil.doGet("http://api.map.baidu.com/geocoder/v2/", params);
        JSONObject jsonObjectAdds = JSONObject.parseObject(result);
        String status = jsonObjectAdds.getString("status");
        if (status == "0" || "0".equals(status)){
//            String province = jsonObjectAdds.getJSONObject("result").getJSONObject("addressComponent").getString("province");// 省
//            String city = jsonObjectAdds.getJSONObject("result").getJSONObject("addressComponent").getString("city");// 市
//            String district=jsonObjectAdds.getJSONObject("result").getJSONObject("addressComponent").getString("district");// 区
            return jsonObjectAdds;
        }else {
            return null;
        }
    }
}
