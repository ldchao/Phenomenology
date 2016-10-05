package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class DownloadController {

	/**前端下载所用代码
	 <Script>
	 function submit(){
	 var form=$("<form>");//定义一个form表单
	 form.attr("style","display:none");
	 form.attr("target","");
	 form.attr("method","post");
	 form.attr("action","../download");

	 var input1=$("<input>");
	 input1.attr("type","hidden");
	 input1.attr("name","fileName");
	 input1.attr("value","upload/55.txt");//路径名
	 $("body").append(form);//将表单放置在web中
	 form.append(input1);

	 form.submit();//表单提交
	 }
	 </Script>
     */


	@RequestMapping("/download")
	public String download(@RequestParam String fileName , HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		// TODO: 2016/9/29 文件下载路径
		String ctxPath = request.getSession().getServletContext().getRealPath("/");
		String downLoadPath = ctxPath + fileName;
		System.out.println(downLoadPath);
		try {
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;

	}
	
}
