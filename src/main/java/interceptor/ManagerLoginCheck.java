package interceptor;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class ManagerLoginCheck extends AbstractInterceptor{

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation ai) throws Exception {//没有登陆管理，不准访问。改用filter，针对所有manage文件夹
		Map session = ai.getInvocationContext().getSession();
		String managerName = (String)session.get("managerLoginName");
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentURL = request.getRequestURI();
		if(currentURL.contains("manage")){//确定是管理员登陆页面
			if(!(managerName == null || "".equals(managerName.trim()))){
				return ai.invoke();
			}else{
				return "managerLogin";
			}
		}else{
			return ai.invoke();
		}
	}
}
