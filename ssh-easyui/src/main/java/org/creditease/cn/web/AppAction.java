package org.creditease.cn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.SystemException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.creditease.cn.common.Datagrid;
import org.creditease.cn.common.PageToJson;
import org.creditease.cn.common.Result;
import org.creditease.cn.model.AppStatistic;
import org.creditease.cn.model.BIAppKey;
import org.creditease.cn.model.BIUser;
import org.creditease.cn.model.IpDown;
import org.creditease.cn.model.PageInfo;
import org.creditease.cn.model.Retention;
import org.creditease.cn.service.IAppEvnEffectService;
import org.creditease.cn.service.IBIAppKeyService;
import org.creditease.cn.service.IBIAppTypeService;
import org.creditease.cn.service.IBIUserService;
import org.creditease.cn.service.IIpDownService;
import org.creditease.cn.utils.SortAndDistinctList;
import org.creditease.cn.utils.SqlTemplateUtils;
import org.creditease.cn.utils.StringUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

















import com.strongmvc.orm.hibernate.Page;
import com.strongmvc.webapp.util.Struts2Util;
/**
 * 
* @ClassName: AppAction
* @Description: TODO(这里用一句话描述这个类的作用)
* @author A18ccms a18ccms_gmail_com
* @date 2015年6月18日 下午2:45:08
*
 */
@Component("appAction")
@Scope("prototype")
public class AppAction extends BaseAction {
	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -1658835539839912359L;
	
	public String app_key;
	public String app_name;
	public String app_pkg_name;
	public String app_desc;
	public BigInteger app_type_id;
	
	public String uname;
	public String upass;
	
	private String page;
	private String rows;
	private Page<BIUser> pageBo;
	private Page<BIAppKey> pageAppkey;
	public BIAppKey appkeyModel = new BIAppKey();
	
	public String id;
	
	public String user_name;
	public String pswd;
	public String pswd2;
	public String email;
	public String mobile;
	public String qq;
	public String company_name;
	public String user_id;
	public String beginDate;
	public String endDate;
	public String app_chnl_sub;
	
	public String ip;
	public String isp;
	public String browser;
	public String os;
	
	public String rptFlag;
	
	public String app_chnl_key;
	
	private BIUser umodel = new BIUser();;

	@Resource
	public IBIAppKeyService appkeyService;
	@Resource
	public IBIUserService biService;
	@Resource
	public IIpDownService ipService;
	@Resource
	public IBIAppTypeService appTypeService;
	@Resource
	public IAppEvnEffectService evnService;
	
	
	/**
	 * 判断appKey是否有效接口
	 * 
	 * @return
	 * @throws Exception
	 */
	public String checkAppKey() throws Exception {
		app_key = ServletActionContext.getRequest().getParameter("app_key");
		if(!StringUtils.isBlank(ServletActionContext.getRequest().getParameter("app_type_id"))){
			app_type_id = BigInteger.valueOf(Long.parseLong((ServletActionContext.getRequest().getParameter("app_type_id"))));
		}else{
			app_type_id=BigInteger.valueOf(2);
		}
		app_pkg_name = ServletActionContext.getRequest().getParameter(
				"app_pkg_name");
		BIAppKey app = new BIAppKey();
		app.setApp_key(app_key);
		app.setApp_type_id(app_type_id);
		app.setApp_pkg_name(app_pkg_name);
		JSONObject jsonObject = appkeyService.checkKeyStatus(app);

		this.write(ServletActionContext.getResponse(), jsonObject.toString());
		return null;
	}
	/**
	 * 
	* @Title: getAppkey
	* @Description: TODO(根据当前登录用户，得到所对应的AppKey)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	private String getAppkey() {
		String username = (String) this.getInfoFromSession(
				ServletActionContext.getRequest(), "username");
		BIUser biUser = new BIUser();
		biUser.setEmail(username);
		Result result = biService.getUserByEmail(biUser);
		if (result == null || result.getObj() == null) {
			return null;
		}
		biUser = (BIUser) result.getObj();
		BIAppKey appKey = new BIAppKey();
		appKey.setUser_id(BigInteger.valueOf(biUser.getUser_id()));
		List<BIAppKey> appKeys = appkeyService.getAppListByKey(appKey);
		return biService.formatApp_key(appKeys);
	}
	/**
	 * 
	* @Title: list
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String list() throws Exception {
		try {
			umodel.setEmail(uname);
			upass = org.creditease.cn.utils.StringUtil.encodePassword(
					"bi.creditease.cn", upass);
			umodel.setPswd(upass);
			Result result = biService.userLogin(umodel);
			if (result.getCode() == 1) {
				this.saveInfoToSession(ServletActionContext.getRequest(),
						"username", uname);
				return "success";
			} else {
				this.write(ServletActionContext.getResponse(), result);
				return "error";
			}
		} catch (Exception e) {
			return "error";
		}

	}
	/**
	 * 
	* @Title: login
	* @Description: TODO(用户登录判断)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String login() throws Exception {
		umodel.setEmail(uname);
		upass = org.creditease.cn.utils.StringUtil.encodePassword(
				"bi.creditease.cn", upass);
		umodel.setPswd(upass);
		Result result = biService.userLogin(umodel);
		if (result.getCode() == 1) {
			this.write(ServletActionContext.getResponse(), result);
			return null;
		} else {
			this.write(ServletActionContext.getResponse(), result);
			return null;
		}
	}
	/**
	 * 
	* @Title: showL
	* @Description: TODO(用户列表)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String showL() throws Exception {
		pageBo = new Page<BIUser>(10, true);
		int intPage = Integer.parseInt((page == null || page == "0") ? "1": page);// 当前页
		int number = Integer.parseInt((rows == null || rows == "0") ? "10": rows);// 每页显示条数
		pageBo.setPageSize(number);
		pageBo.setPageNo(intPage);
		pageBo = biService.getUserList(pageBo, umodel);
		List<BIUser> list = (ArrayList<BIUser>) pageBo.getResult();
		if (null == list) {
			list = new ArrayList<BIUser>();
		}
		Datagrid<BIUser> dg = new Datagrid<BIUser>(pageBo.getTotalCount(), list);
		Struts2Util.renderJson(dg); // 返回前端JSON
		return null;
	}
	/**
	 * 
	* @Title: showAppList
	* @Description: TODO(appKey列表)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String showAppList() throws Exception {
		user_name = (String) this.getInfoFromSession(
				ServletActionContext.getRequest(), "username");
		umodel.setEmail(user_name);
		Result result1 = biService.getUserByEmail(umodel);
		if (result1.getCode() == 1) {
			BIUser u = (BIUser) result1.getObj();
			if (!StringUtil.isDemoUser(user_name)) {
				appkeyModel.setUser_id(BigInteger.valueOf(u.getUser_id()));
			}
			pageAppkey = new Page<BIAppKey>(10, true);
			// 当前页
			int intPage = Integer.parseInt((page == null || page == "0") ? "1"
					: page);
			// 每页显示条数
			int number = Integer.parseInt((rows == null || rows == "0") ? "10"
					: rows);
			pageAppkey.setPageSize(number);
			pageAppkey.setPageNo(intPage);
			pageAppkey = appkeyService.getAppListByKey(pageAppkey,
						appkeyModel);
			List<BIAppKey> list = (ArrayList<BIAppKey>) pageAppkey.getResult();
			if (null == list) {
				list = new ArrayList<BIAppKey>();
			}
			Datagrid<BIAppKey> dg = new Datagrid<BIAppKey>(
					pageAppkey.getTotalCount(), list);
			Struts2Util.renderJson(dg); // 返回前端JSON
		}
		return null;
	}
	/**
	 * 
	* @Title: save
	* @Description: TODO(保存用户信息)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String save() throws Exception {
		Result result = new Result();

		umodel.setCompany_name(company_name);
		umodel.setEmail(email);
		umodel.setMobile(mobile);
		umodel.setPswd(pswd);
		umodel.setQq(qq);
		umodel.setUser_name(user_name);
		try {
			user_id = ServletActionContext.getRequest().getParameter("user_id");
			if (!user_id.isEmpty()) {
				umodel.setUser_id(Long.parseLong(user_id));
				result = biService.userUpdate(umodel);
			} else {
				result = biService.saveUser(umodel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = Result.errorResult();
			result.setMsg("保存用户信息出错：" + e.getMessage());
		}
		this.write(ServletActionContext.getResponse(), result);
		return null;
	}

	/**
	 * 
	* @Title: register
	* @Description: TODO(用户注册)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String register() throws Exception {
		Result result = new Result();
		umodel.setCompany_name(company_name);
		umodel.setEmail(email);
		umodel.setMobile(mobile);
		pswd = org.creditease.cn.utils.StringUtil.encodePassword(
				"bi.creditease.cn", pswd);
		umodel.setPswd(pswd);
		umodel.setQq(qq);
		umodel.setUser_name(user_name);
		try {
			result = biService.userRegister(umodel);
		} catch (Exception e) {
			e.printStackTrace();
			result = Result.errorResult();
			result.setMsg("注册用户信息出错：" + e.getMessage());
		}
		this.saveInfoToSession(ServletActionContext.getRequest(),
				"registerMessage", result.getMsg());
		return "register";
	}

	/**
	 * 
	* @Title: checkUser
	* @Description: TODO(判断用户名是否存在)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String checkUser() {
		email = ServletActionContext.getRequest().getParameter("email");
		umodel.setEmail(email);
		Result result = biService.getUserByEmail(umodel);
		if (result.getCode() == 1) {
			result.setMsg("邮箱已存在！");
		}
		this.write(ServletActionContext.getResponse(), result);
		return null;
	}

	/**
	 * 
	* @Title: editMM
	* @Description: TODO(修改密码)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String editMM() throws Exception {
		Result result = new Result();
		pswd = ServletActionContext.getRequest().getParameter("pswd");
		user_name = (String) this.getInfoFromSession(
				ServletActionContext.getRequest(), "username");
		// user_name=ServletActionContext.getRequest().getParameter("username");
		if (user_name.equals("demo@creditease.cn")) {
			result.setMsg("Demo用户密码不允许修改！");
		} else {
			umodel.setEmail(user_name);
			result = biService.getUserByEmail(umodel);
			if (result.getCode() == 1) {
				//
				BIUser u = (BIUser) result.getObj();
				pswd = org.creditease.cn.utils.StringUtil.encodePassword(
						"bi.creditease.cn", pswd);
				u.setPswd(pswd);
				try {
					result = biService.saveUser(u);
				} catch (Exception e) {
					e.printStackTrace();
					result = Result.errorResult();
					result.setMsg("保存用户信息出错：" + e.getMessage());
				}
			} else {
				result.setMsg("Sission已经过期！");
			}
		}

		this.write(ServletActionContext.getResponse(), result);
		return null;
	}

	/**
	 * 
	* @Title: delUser
	* @Description: TODO(删除用户)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String delUser() throws Exception {
		Result result = new Result();
		try {
			// adserverId = getRequest().getParameter("adserverId");
			biService.delete(Integer.parseInt(user_id));
			result = Result.successResult();
		} catch (Exception e) {
			e.printStackTrace();
			result = Result.errorResult();
			result.setMsg("删除用户信息出错：" + e.getMessage());
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(result.toString());
		return null;
	}

	/**
	 * 
	* @Title: delApp
	* @Description: TODO(删除应用)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String delApp() throws Exception {
		Result result = new Result();
		try {
			id = ServletActionContext.getRequest().getParameter("id");
			appkeyModel.setId(Long.parseLong(id));
			appkeyService.deleteAppKey(appkeyModel);
			result = Result.successResult();
		} catch (Exception e) {
			e.printStackTrace();
			result = Result.errorResult();
			result.setMsg("删除应用信息出错：" + e.getMessage());
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		this.write(response, result);
		return null;
	}
	
	/**
	 * 
	* @Title: downFile
	* @Description: TODO(下载sdk Ip地址统计)
	* @param @return
	* @param @throws UnsupportedEncodingException    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String downFile() throws UnsupportedEncodingException {
		user_name = (String) this.getInfoFromSession(
				ServletActionContext.getRequest(), "username");
		umodel.setEmail(user_name);
		Result result1 = biService.getUserByEmail(umodel);

		if (result1.getCode() == 1) {
			BIUser u = (BIUser) result1.getObj();

			IpDown ipModel = new IpDown();
			ipModel.setCreateTime(new Date());
			ipModel.setBrowser(browser);
			ipModel.setIsp(isp);
			ipModel.setOs(os);
			ipModel.setIp(ip);
			ipModel.setUser_id(BigInteger.valueOf(u.getUser_id()));
			this.write(ServletActionContext.getResponse(),
					ipService.saveIp(ipModel));
		}

		return null;
	}

	/**
	 * 
	* @Title: ipCount
	* @Description: TODO(下载统计)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String ipCount() {
		long count = (ipService.getIpList(null).isEmpty() && ipService
				.getIpList(null).size() == 0) ? 0 : ipService.getIpList(null)
				.size();
		this.write(ServletActionContext.getResponse(), count);
		return null;
	}

	/**
	 * 
	* @Title: getApptype
	* @Description: TODO(获取app类型)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String getApptype() {
		this.write(ServletActionContext.getResponse(),
				appTypeService.getAppType());
		return null;
	}

	/**
	 * 
	* @Title: getAppByUser
	* @Description: TODO(得到当前登录用户的所有app)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String getAppByUser() {
		user_name = (String) this.getInfoFromSession(
				ServletActionContext.getRequest(), "username");
		if (StringUtil.isDemoUser(user_name)) {
			this.write(ServletActionContext.getResponse(),
					appkeyService.getAppByUser(null));
		} else {
			umodel.setEmail(user_name);
			Result result1 = biService.getUserByEmail(umodel);
			if (result1.getCode() == 1) {
				BIUser u = (BIUser) result1.getObj();
				BIAppKey ak = new BIAppKey();
				ak.setUser_id(BigInteger.valueOf(u.getUser_id()));
				this.write(ServletActionContext.getResponse(),
						appkeyService.getAppByUser(ak));
			}
		}

		return null;
	}

	/**
	 * 
	* @Title: saveAppkey
	* @Description: TODO(保存AppKey)
	* @param @return
	* @param @throws SystemException
	* @param @throws IOException    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String saveAppkey() throws SystemException, IOException {

		Result result = Result.errorResult();

		user_name = (String) this.getInfoFromSession(
				ServletActionContext.getRequest(), "username");
		umodel.setEmail(user_name);
		Result result1 = biService.getUserByEmail(umodel);
		if (result1.getCode() == 1) {
			BIUser u = (BIUser) result1.getObj();
			appkeyModel.setUser_id(BigInteger.valueOf(u.getUser_id()));
			appkeyModel.setApp_type_id(app_type_id);
			appkeyModel.setApp_name(app_name);
			appkeyModel.setApp_pkg_name(app_pkg_name);
			appkeyModel.setApp_desc(app_desc);
			try {
				id = ServletActionContext.getRequest().getParameter("id");
				if (!id.isEmpty()) {
					appkeyModel.setId(Long.parseLong(id));
					result = appkeyService.updateAppKey(appkeyModel);
				} else {
					result = appkeyService.saveAppKey(appkeyModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
				result = Result.errorResult();
				result.setMsg("保存应用信息出错：" + e.getMessage());
			}
		}

		this.write(ServletActionContext.getResponse(), result);

		return null;
	}

	/**
	 * 
	* @Title: loginout
	* @Description: TODO(退出登录)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String loginout() {
		Result re = Result.successResult();
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);// 防止创建Session
		if (session == null) {
			this.write(ServletActionContext.getResponse(), re);
			return null;
		}
		session.removeAttribute("username");
		session.removeAttribute("registerMessage");
		this.write(ServletActionContext.getResponse(), re);
		return null;
	}
	
	/**
	 * 
	* @Title: evnEffectPage
	* @Description: TODO(事件列表)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public String evnEffectPage(){
		String sqlStr = SqlTemplateUtils.getSqlTemplate(rptFlag);
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("app_key",  "All".equals(app_key) || "请选择".equals(app_key)|| StringUtils.isBlank(app_key) ? getAppkey() : app_key);
		args.put("channel",  "All".equals(app_chnl_key) || "请选择".equals(app_chnl_key)|| StringUtils.isBlank(app_chnl_key)?null:app_chnl_key);
		args.put("channel_sub",  "All".equals(app_chnl_sub) || "请选择".equals(app_chnl_sub)|| StringUtils.isBlank(app_chnl_sub)?null:app_chnl_sub);
		args.put("os",  "All".equals(os) || "请选择".equals(os)|| StringUtils.isBlank(os)?null:os);
		args.put("beginDate",  StringUtils.isBlank(beginDate)?null:beginDate);
		args.put("endDate", StringUtils.isBlank(endDate)?null:endDate);
		
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>();
		pageInfo=PageToJson.pageGo(pageInfo, page, rows);
		pageInfo = evnService.getList(pageInfo, sqlStr, args, false, true);
		this.write(ServletActionContext.getResponse(), PageToJson.page2Json(pageInfo));
		return null;
	}
	/**
	 * 
	* @Title: appStatistics
	* @Description: TODO(用户统计-报表)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String appStatistics() throws Exception {
		String sqlStr = SqlTemplateUtils.getSqlTemplate("appStatistics");
		Map<String, Object> args = new HashMap<String, Object>();
		List<String> dates = formatDate(beginDate, endDate, 30);
		args.put("app_key",  "All".equals(app_key) || "请选择".equals(app_key)|| StringUtils.isBlank(app_key) ? getAppkey() : app_key);
		args.put("channel",  "All".equals(app_chnl_key) || "请选择".equals(app_chnl_key)|| StringUtils.isBlank(app_chnl_key)?null:app_chnl_key);
		args.put("channel_sub",  "All".equals(app_chnl_sub) || "请选择".equals(app_chnl_sub)|| StringUtils.isBlank(app_chnl_sub)?null:app_chnl_sub);
		args.put("beginDate",dates.get(0));
		args.put("endDate", dates.get(1));
		
		List<AppStatistic> list = (List<AppStatistic>) evnService.getList(sqlStr, args, AppStatistic.class);

		JSONObject ob = new JSONObject();

		ArrayList l_date_key = new ArrayList();
		ArrayList user_cnt_0 = new ArrayList();
		ArrayList user_cnt_30_ = new ArrayList();
		ArrayList user_cnt_8_30 = new ArrayList();
		ArrayList user_cnt_1_7 = new ArrayList();
		ArrayList radio = new ArrayList();

		if (!list.isEmpty() && list.size() != 0) {
			for (AppStatistic app : list) {
				l_date_key.add(app.getDate_key());
				if (app.getPeriod_type().equals("当天")) {
					user_cnt_0.add(app.getNew_user_cnt());
				}
				if (app.getPeriod_type().equals("30+天前")) {
					user_cnt_30_.add(app.getNew_user_active_cnt());
				}
				if (app.getPeriod_type().equals("8-30天内")) {
					user_cnt_8_30.add(app.getNew_user_active_cnt());
				}
				if (app.getPeriod_type().equals("1-7天内")) {
					user_cnt_1_7.add(app.getNew_user_active_cnt());
				}
				if (app.getPeriod_type().equals("当天")) {
					radio.add(app.getRate());
				}
			}
			l_date_key = SortAndDistinctList.sortAnddisList(l_date_key);
			ob.put("date_key", l_date_key);
			ob.put("user_cnt_0", user_cnt_0);
			ob.put("user_cnt_30_", user_cnt_30_);
			ob.put("user_cnt_8_30", user_cnt_8_30);
			ob.put("user_cnt_1_7", user_cnt_1_7);
			ob.put("radio", radio);
		}
		this.write(ServletActionContext.getResponse(), ob.toString());
		return null;
	}
	/**
	 * 
	* @Title: appStatisticsPage1
	* @Description: TODO(用户统计分析列表-当天)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public String appStatisticsPage1() throws Exception{
		String sqlStr = SqlTemplateUtils.getSqlTemplate("appStatisticsPage");
		Map<String, Object> args = new HashMap<String, Object>();
		uname = (String) this.getInfoFromSession(ServletActionContext.getRequest(), "username");
		if ("demo@creditease.cn".equals(uname)) {
			endDate = "2015-04-30";
		} else {
			endDate = null;
		}
		List<String> dates = formatDate(null, endDate, 0);
		args.put("app_key",  "All".equals(app_key) || "请选择".equals(app_key)|| StringUtils.isBlank(app_key) ? getAppkey() : app_key);
		args.put("channel",  "All".equals(app_chnl_key) || "请选择".equals(app_chnl_key)|| StringUtils.isBlank(app_chnl_key)?null:app_chnl_key);
		args.put("channel_sub",  "All".equals(app_chnl_sub) || "请选择".equals(app_chnl_sub)|| StringUtils.isBlank(app_chnl_sub)?null:app_chnl_sub);
		args.put("beginDate", dates.get(0));
		args.put("endDate", dates.get(1));
		
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>();
		pageInfo=PageToJson.pageGo(pageInfo, page, rows);
		pageInfo = evnService.getList(pageInfo, sqlStr, args, false, true);
		//System.out.println(PageToJson.page2Json(pageInfo));
		this.write(ServletActionContext.getResponse(), PageToJson.page2Json(pageInfo));
		return null;
	}
	
	/**
	 * 
	* @Title: appStatisticsPage
	* @Description: TODO(用户统计分析列表-30天)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public String appStatisticsPage() throws Exception{
		String sqlStr = SqlTemplateUtils.getSqlTemplate("appStatisticsPage");
		Map<String, Object> args = new HashMap<String, Object>();
		List<String> dates = formatDate(beginDate, endDate, 30);
		args.put("app_key",  "All".equals(app_key) || "请选择".equals(app_key)|| StringUtils.isBlank(app_key) ? getAppkey() : app_key);
		args.put("channel",  "All".equals(app_chnl_key) || "请选择".equals(app_chnl_key)|| StringUtils.isBlank(app_chnl_key)?null:app_chnl_key);
		args.put("channel_sub",  "All".equals(app_chnl_sub) || "请选择".equals(app_chnl_sub)|| StringUtils.isBlank(app_chnl_sub)?null:app_chnl_sub);
		args.put("beginDate",dates.get(0));
		args.put("endDate", dates.get(1));
		
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>();
		pageInfo=PageToJson.pageGo(pageInfo, page, rows);
		pageInfo = evnService.getList(pageInfo, sqlStr, args, false, true);
		this.write(ServletActionContext.getResponse(), PageToJson.page2Json(pageInfo));
		return null;
	}
	/**
	 * 
	* @Title: retention
	* @Description: TODO(用户留存报表)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String retention() throws Exception {
		String sqlStr = SqlTemplateUtils.getSqlTemplate("retention");
		Map<String, Object> args = new HashMap<String, Object>();
		List<String> dates = formatDate(beginDate, endDate, 30);
		args.put("app_key",  "All".equals(app_key) || "请选择".equals(app_key)|| StringUtils.isBlank(app_key) ? getAppkey() : app_key);
		args.put("channel",  "All".equals(app_chnl_key) || "请选择".equals(app_chnl_key)|| StringUtils.isBlank(app_chnl_key)?null:app_chnl_key);
		args.put("channel_sub",  "All".equals(app_chnl_sub) || "请选择".equals(app_chnl_sub)|| StringUtils.isBlank(app_chnl_sub)?null:app_chnl_sub);
		args.put("beginDate",dates.get(0));
		args.put("endDate", dates.get(1));
		
		List<Retention> list = (List<Retention>) evnService.getList(sqlStr,
				args, Retention.class);
		JSONObject ob = new JSONObject();
		ArrayList date_list = new ArrayList();
		ArrayList var_list = new ArrayList();

		ArrayList after_1_list = new ArrayList();
		ArrayList after_2_list = new ArrayList();
		ArrayList after_3_list = new ArrayList();
		ArrayList after_4_list = new ArrayList();
		ArrayList after_5_list = new ArrayList();
		ArrayList after_6_list = new ArrayList();
		ArrayList after_7_list = new ArrayList();
		ArrayList after_30_list = new ArrayList();

		if (!list.isEmpty() && list.size() != 0) {
			for (Retention app : list) {
				date_list.add(app.getDate_key());
				if (app.getPeriod_type().equals("1天后")) {
					after_1_list.add(app.getRadio());
				}
				if (app.getPeriod_type().equals("2天后")) {
					after_2_list.add(app.getRadio());
				}
				if (app.getPeriod_type().equals("3天后")) {
					after_3_list.add(app.getRadio());
				}
				if (app.getPeriod_type().equals("4天后")) {
					after_4_list.add(app.getRadio());
				}
				if (app.getPeriod_type().equals("5天后")) {
					after_5_list.add(app.getRadio());
				}
				if (app.getPeriod_type().equals("6天后")) {
					after_6_list.add(app.getRadio());
				}
				if (app.getPeriod_type().equals("7天后")) {
					after_7_list.add(app.getRadio());
				}
				if (app.getPeriod_type().equals("30天后")) {
					after_30_list.add(app.getRadio());
				}
				var_list.add(app.getPeriod_type());
			}
			date_list = SortAndDistinctList.sortAnddisList(date_list);
			var_list = SortAndDistinctList.distinct(var_list);
			System.out.println(after_1_list.toString());
			ob.put("date_key", date_list);
			ob.put("after_1_list", after_1_list);
			ob.put("after_2_list", after_2_list);
			ob.put("after_3_list", after_3_list);
			ob.put("after_4_list", after_4_list);
			ob.put("after_5_list", after_5_list);
			ob.put("after_6_list", after_6_list);
			ob.put("after_7_list", after_7_list);
			ob.put("after_30_list", after_30_list);
		}
		this.write(ServletActionContext.getResponse(), ob.toString());
		return null;
	}
	/**
	 * 
	* @Title: retentionPage
	* @Description: TODO(用户留存列表)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public String retentionPage() throws Exception {
		String sqlStr = SqlTemplateUtils.getSqlTemplate("retentionPage");
		Map<String, Object> args = new HashMap<String, Object>();
		List<String> dates = formatDate(beginDate, endDate, 30);
		args.put("app_key",  "All".equals(app_key) || "请选择".equals(app_key)|| StringUtils.isBlank(app_key) ? getAppkey() : app_key);
		args.put("channel",  "All".equals(app_chnl_key) || "请选择".equals(app_chnl_key)|| StringUtils.isBlank(app_chnl_key)?null:app_chnl_key);
		args.put("channel_sub",  "All".equals(app_chnl_sub) || "请选择".equals(app_chnl_sub)|| StringUtils.isBlank(app_chnl_sub)?null:app_chnl_sub);
		args.put("beginDate",dates.get(0));
		args.put("endDate", dates.get(1));
		
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>();
		pageInfo=PageToJson.pageGo(pageInfo, page, rows);
		pageInfo = evnService.getList(pageInfo, sqlStr, args, false, true);
		this.write(ServletActionContext.getResponse(), PageToJson.page2Json(pageInfo));
		return null;
	}
	/**
	 * 
	* @Title: usageDur
	* @Description: TODO(用户参与度统计)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String usageDur() throws Exception {
		JSONObject jsonArr = new JSONObject();
		List<String> dates = formatDate(beginDate, endDate, 30);
		jsonArr = evnService.usageDur(
				dates.get(0),
				dates.get(1),
				"All".equals(app_key) || "请选择".equals(app_key)
						|| StringUtils.isBlank(app_key) ? getAppkey() : "'"
						+ app_key + "'");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(jsonArr.toString());
		return null;
	}
	/**
	 * 
	* @Title: exception
	* @Description: TODO(错误分析报表)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String exception() throws Exception {
		JSONObject jsonArr = new JSONObject();
		List<String> dates = formatDate(beginDate, endDate, 30);
		jsonArr = evnService.exception(
				dates.get(0),
				dates.get(1),
				"All".equals(app_key) || "请选择".equals(app_key)
						|| StringUtils.isBlank(app_key) ? getAppkey() : "'"
						+ app_key + "'");
		this.write(ServletActionContext.getResponse(), jsonArr);
		return null;
	}
	/**
	 * 
	* @Title: redLocation
	* @Description: TODO(启动次数分布)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String redLocation() throws Exception {
		// System.out.println(sessionName);
		JSONObject jsonArr = new JSONObject();
		List<String> dates = formatDate(beginDate, endDate, 30);
		jsonArr = evnService.redLo(
				dates.get(0),
				dates.get(1),
				"All".equals(app_key) || "请选择".equals(app_key)
						|| StringUtils.isBlank(app_key) ? getAppkey() : "'"
						+ app_key + "'");
		// ServletActionContext.getRequest().setAttribute("data",jsonArr.toString());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(jsonArr.toString());
		return null;
	}
	/**
	 * 
	* @Title: getChannel
	* @Description: TODO(渠道下拉框)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String getChannel(){
		
		String sqlStr = SqlTemplateUtils.getSqlTemplate("appChannel");
		Map<String, Object> args = new HashMap<String, Object>();
		user_name = (String) this.getInfoFromSession(
				ServletActionContext.getRequest(), "username");
		if (StringUtil.isDemoUser(user_name)) {
			args.put("app_key",  null);
		}else{
			args.put("app_key",  getAppkey());
		}
		List<Map<String, Object>>list =evnService.getList(sqlStr, args, false, false);
		JSONArray ob= new JSONArray();
		JSONObject obs1= new JSONObject();
		obs1.put("id", "All");
		obs1.put("text", "All");
		obs1.put("selected", true);
		ob.put(obs1);
		for(Map<String, Object> o:list){
			JSONObject obs= new JSONObject();
			for (String k : o.keySet()){
				if(k.equals("id")){
					obs.put("id", o.get(k));
				}else{
					obs.put("text", o.get(k));
				}
				obs.put("selected", false);
	        }
			ob.put(obs);
		}
		this.write(ServletActionContext.getResponse(),ob.toString());
		return null;
	}
	/**
	 * 
	* @Title: getChannelSub
	* @Description: TODO(子渠道下拉框)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String getChannelSub(){
		String sqlStr = SqlTemplateUtils.getSqlTemplate("appChannelsub");
		Map<String, Object> args = new HashMap<String, Object>();
		user_name = (String) this.getInfoFromSession(
				ServletActionContext.getRequest(), "username");
		if (StringUtil.isDemoUser(user_name)) {
			args.put("app_key",  null);
		}else{
			args.put("app_key",  getAppkey());
		}
		args.put("channel",  "All".equals(app_chnl_key) || "请选择".equals(app_chnl_key)|| StringUtils.isBlank(app_chnl_key)?null:app_chnl_key);
		JSONArray ob= new JSONArray();
		JSONObject obs1= new JSONObject();
		obs1.put("id", "All");
		obs1.put("text", "All");
		obs1.put("selected", true);
		ob.put(obs1);
		if("All".equals(app_chnl_key) || "请选择".equals(app_chnl_key)|| StringUtils.isBlank(app_chnl_key)){
			
		}else{
			List<Map<String, Object>>list =evnService.getList(sqlStr, args, false, false);
			for(Map<String, Object> o:list){
				JSONObject obs= new JSONObject();
				for (String k : o.keySet()){
					if(k.equals("id")){
						if(!o.get(k).equals("")){
							obs.put("id", o.get(k));
						}
					}else{
						if(!o.get(k).equals("")){
							obs.put("text", o.get(k));
						}
					}
		        }
				try {
					if(!obs.get("id").equals(null)){
						ob.put(obs);
					}
				} catch (Exception e) {
				}
				
			}
			
		}
		this.write(ServletActionContext.getResponse(),ob.toString());
		return null;
	}
	/**
	 * 
	* @Title: showAppUserList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return
	* @param @throws Exception    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public String showAppUserList() throws Exception {
		String sqlStr = SqlTemplateUtils.getSqlTemplate("appUser");
		Map<String, Object> args = new HashMap<String, Object>();
		user_name = (String) this.getInfoFromSession(
				ServletActionContext.getRequest(), "username");
		if (StringUtil.isDemoUser(user_name)) {
			args.put("app_key",  null);
		}else{
			args.put("app_key",  getAppkey());
		}
		//args.put("app_key",   StringUtils.isBlank(app_key)?null:app_key);
		args.put("app_name",   StringUtils.isBlank(app_name)?null:app_name);
		args.put("email",   StringUtils.isBlank(email)?null:email);
		args.put("mobile",   StringUtils.isBlank(mobile)?null:mobile);
		args.put("qq",   StringUtils.isBlank(qq)?null:qq);
		
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>();
		pageInfo=PageToJson.pageGo(pageInfo, page, rows);
		pageInfo = evnService.getList(pageInfo, sqlStr, args, false, true);
		this.write(ServletActionContext.getResponse(), PageToJson.page2Json(pageInfo));
		return null;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	
}
