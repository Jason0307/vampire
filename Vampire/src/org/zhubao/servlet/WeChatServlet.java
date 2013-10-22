package org.zhubao.servlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zhubao.util.EncryptUtil;
import org.zhubao.util.XmlUtil;
  
public class WeChatServlet extends HttpServlet {  
  
    private static final long serialVersionUID = 1L;  
      
    //微信平台上填的Token和这里需要一致  
    public static final String Token = "loveplat";  
  
    /** 
     * 微信公众平台验证调用方法 
     */  
    @Override  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        String signature = request.getParameter("signature");  
        String timestamp = request.getParameter("timestamp");  
        String nonce = request.getParameter("nonce");  
        String[] ArrTmp = { Token, timestamp, nonce };  
        Arrays.sort(ArrTmp);  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < ArrTmp.length; i++) {  
            sb.append(ArrTmp[i]);  
        }  
        String pwd = EncryptUtil.Encrypt(sb.toString());  
        String echostr = request.getParameter("echostr");  
        System.out.println("pwd=="+pwd);  
        System.out.println("echostr=="+echostr);  
        if(pwd.equals(signature)){  
            if(!"".equals(echostr) && echostr != null){  
                response.getWriter().print(echostr);  
            }  
        }  
    }  
  
    /** 
     * 用户向公众平台发信息并自动返回信息 
     */  
    @Override  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        StringBuffer sb = new StringBuffer();  
        String line;  
        Map<String, String> map = null;  
        try {  
            request.setCharacterEncoding("UTF-8");  
            BufferedReader reader = request.getReader();  
            while ((line = reader.readLine()) != null) {  
                sb.append(line);  
            }  
            map = XmlUtil.xml2Map(sb.toString());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        sb = new StringBuffer();  
      
        sb.append("<xml><ToUserName><![CDATA[").append(  
                map.get("xml.FromUserName")).append(  
                "]]></ToUserName><FromUserName><![CDATA[").append(  
                map.get("xml.ToUserName")).append(  
                "]]></FromUserName><CreateTime>").append(  
                map.get("xml.CreateTime")).append(  
                "</CreateTime><MsgType><![CDATA[text]]></MsgType>").append(  
                "<Content><![CDATA[收到");  
        sb.append("]]></Content>").append("<FuncFlag>0</FuncFlag></xml>");  
        response.setCharacterEncoding("UTF-8");  
        System.out.println(sb.toString());  
        response.getWriter().print(sb.toString());  
    }  
  
  
    @Override  
    public void destroy() {  
        super.destroy();  
    }  
  
    @Override  
    public void init() throws ServletException {  
        super.init();  
    }  
  
} 