package com.luster.fistIdeaItem.common.utils;

import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by luster on 2017-8-22.
 */
public class HttpRequestUtils {
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("Authorization", "o_LVTPFpsM_W6TRNbttP99jcL-OfkEHiz9VVrgmXaZx3n71_3tjHEQ==");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Authorization", "o_LVTPFpsM_W6TRNbttP99jcL-OfkEHiz9VVrgmXaZx3n71_3tjHEQ==");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @param uri
     * @param json
     * @param authorization
     */
    public static void sendPostJson(String uri, String json, String authorization) {
        //创建连接
        URL url = null;
        try {
            url = new URL(uri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.setDoOutput(true);
        connection.setDoInput(true);
        try {
            connection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", authorization);
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // POST请求
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(connection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(json);
            out.write(json.getBytes("utf-8"));//utf-8编码
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 读取响应
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lines;
        StringBuffer sb = new StringBuffer("");
        try {
            while ((lines = reader.readLine()) != null) {
                try {
                    System.out.println(lines);
                    lines = URLDecoder.decode(lines, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 断开连接
        connection.disconnect();
    }

    public static void main(String[] args) throws Exception {
        String url = "http://172.16.6.88:8088/api/user/register";
        JSONObject obj = new JSONObject();
        obj.put("account", "db37");
        obj.put("code", "db37");
        obj.put("confirmPassword", "13890909090");
        obj.put("inheritOrganizationPower", false);
        obj.put("name", "db37");
        obj.put("organizationId", "25");
        obj.put("password", "13890909090");
        obj.put("phoneNumber", "13890909090");
        obj.put("roles", new ArrayList<>());
        obj.put("sex", "Man");
        sendPostJson(url, obj.toString(), "o_LVTPFpsM_W6TRNbttP99jcL-OfkEHiz9VVrgmXaZx3n71_3tjHEQ==");

//        String url = "http://172.16.6.88:8088/api/resourcePool/queryAccessiblesResourcePool";
//        sendGet(url, "resourcePoolId=14&page=0&size=10&sort=");
    }
}
