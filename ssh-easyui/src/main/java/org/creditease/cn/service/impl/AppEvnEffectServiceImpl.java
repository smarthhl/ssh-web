package org.creditease.cn.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.creditease.cn.dao.IAppEvnEffectDAO;
import org.creditease.cn.model.AppException;
import org.creditease.cn.model.AppStatistic;
import org.creditease.cn.model.BIEvnEffect;
import org.creditease.cn.model.LocationApp;
import org.creditease.cn.model.Retention;
import org.creditease.cn.model.UsageDuration;
import org.creditease.cn.service.IAppEvnEffectService;
import org.creditease.cn.utils.SortAndDistinctList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title: UserServiceImpl
 * @Description:
 * @Copyright:Copyright (c) 2014
 * @Date:2015-3-19
 * @author:xiezhongyong
 */
@Component
public class AppEvnEffectServiceImpl extends BaseService<BIEvnEffect, IAppEvnEffectDAO> implements  IAppEvnEffectService {

	@Resource
	private IAppEvnEffectDAO evnDAO;
	@Override
	protected IAppEvnEffectDAO getDao() {
		// TODO Auto-generated method stub
		return this.evnDAO;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONObject aapStr(String beginDate, String endDate, String appKey,String channel,String channel_sub)
			throws Exception {
		String sql = "SELECT "
				+ "date_key, "
				+ "a.app_key, "
				+ "a.app_ver_key, "
				+ "channel as app_chnl_key, "
				+ "period_type, "
				+ "CASE WHEN SUM(act_user_cnt) IS NULL THEN 0 ELSE SUM(act_user_cnt) END act_user_cnt, "
				+ "CASE WHEN SUM(new_user_cnt) IS NULL THEN 0 ELSE SUM(new_user_cnt) END new_user_cnt, "
				+ "CASE WHEN SUM(new_user_active_cnt) IS NULL THEN 0 ELSE SUM(new_user_active_cnt) END new_user_active_cnt, "
				+ "CASE WHEN SUM(new_user_cnt) / SUM(act_user_cnt) IS NULL THEN 0 ELSE SUM(new_user_cnt) / SUM(act_user_cnt) END rate  "
				+ "FROM "
				+ "app_active a  "
				+ "JOIN "
				+ "dim_period_act b  "
				+ "ON a.period_act_key = b.period_act_key  "
				+ "AND a.period_act_key IN (1, 96, 101, 93)  "
				+ "JOIN dim_app_channel d ON a.app_chnl_key=d.app_chnl_key "
				+ "JOIN dim_app_version e ON e.app_ver_key=a.app_ver_key "
				+ "WHERE a.app_key in ("+appKey+") AND date_key>=? AND date_key<=? AND channel = COALESCE(?, channel) AND channel_sub = COALESCE(?, channel_sub) GROUP BY date_key, "
				+ "a.period_act_key ";
		List<Object> args = new ArrayList<Object>();
		args.add(beginDate);
		args.add(endDate);
		args.add(channel);
		args.add(channel_sub);
		List<AppStatistic> list = (List<AppStatistic>) evnDAO.executeSqlQuery(sql, args, AppStatistic.class);

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
		// System.out.println(l_date_key.toString());
		return ob;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JSONObject retention(String beginDate, String endDate, String app_key,String channel,String channel_sub) throws Exception {
		String sql = "SELECT "
				+ "date_key, "
				+ "CASE WHEN radio IS NULL THEN 0 ELSE radio END radio, "
				+ "period_type "
				+ "FROM "
				+ "(SELECT "
				+ "date_key, "
				+ "app_key, "
				+ "app_ver_key, "
				+ "app_chnl_key, "
				+ "period_type, "
				+ "SUM(user_rtt_cnt), "
				+ "user_rtt_cnt / new_user_cnt AS radio "
				+ "FROM "
				+ "app_retention a "
				+ "LEFT JOIN "
				+ "dim_period_rtt b "
				+ "ON a.period_rtt_key = b.period_rtt_key "
				+ "WHERE a.period_rtt_key IN (1, 2, 3, 4, 5, 6, 7, 9) and app_key in ("+app_key+")  AND date_key>=? AND date_key<=? "
				+ "GROUP BY date_key, " + "app_key, " + "app_ver_key, "
				+ "app_chnl_key, " + "period_type) f " 
				+ "JOIN dim_app_channel d ON f.app_chnl_key=d.app_chnl_key "
				+ "JOIN dim_app_version e ON e.app_ver_key=f.app_ver_key "
				+ "where  channel = COALESCE(?, channel) AND channel_sub = COALESCE(?, channel_sub) "
				+ "GROUP BY date_key, "
				+ "period_type order by date_key";
		List<Object> args = new ArrayList<Object>();
		args.add(beginDate);
		args.add(endDate);
		args.add(channel);
		args.add(channel_sub);
		List<Retention> list = (List<Retention>) evnDAO.executeSqlQuery(sql,
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
		// System.out.println(ob.toJSONString());
		return ob;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JSONObject usageDur(String beginDate, String endDate, String app_key)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("app_key:"+app_key);
		String sql = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ")
				.append("duration_type,")
				.append("hours AS xhour,")
				.append("CASE WHEN SUM(a.open_cnt) IS NULL THEN 0 ELSE SUM(a.open_cnt) END usage_count ,")
				.append("CASE WHEN SUM(a.open_cnt) /c.open_cnt IS NULL THEN 0 ELSE round((SUM(a.open_cnt) /c.open_cnt)*100,2) END rate ")
				.append("FROM ")
				.append("app_usage_duration_groupby_duration a,")
				.append("dim_duration b ,")
				.append("(SELECT SUM(open_cnt)  open_cnt FROM app_usage_duration_groupby_duration ")
				.append("where app_key in (")
				.append(app_key)
				.append(") AND date_key>=? AND date_key<=?)c ")
				.append("WHERE a.duration_key = b.duration_key AND app_key in (")
				.append(app_key)
				.append(") AND date_key>=? AND date_key<=? ")
				.append("GROUP BY a.duration_key,  hours ");
		List<Object> args = new ArrayList<Object>();
		args.add(beginDate);
		args.add(endDate);
		args.add(beginDate);
		args.add(endDate);
		sql = sb.toString();
		List<UsageDuration> list = (List<UsageDuration>) evnDAO
				.executeSqlQuery(sql, args, UsageDuration.class);
		ArrayList data_list = new ArrayList();
		if (!list.isEmpty() && list.size() != 0) {
			//System.out.println("List大小：" + list.size());
			for (UsageDuration app : list) {
				ArrayList data = new ArrayList();
				data.add(app.getXhour());
				data.add(app.getDuration_type());
				data.add(app.getUsage_count());
				data.add(app.getRate());

				data_list.add(data);

			}
		}
		JSONObject ob = new JSONObject();
		ob.put("duration", data_list);

		 System.out.println(ob.toString());
		return ob;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JSONObject exception(String beginDate, String endDate, String app_key)
			throws Exception {

		String sql = "SELECT "
				+ "date_key, "
				+ "app_key, "
				+ "app_ver_key, "
				+ "app_chnl_key, "
				+ "CASE WHEN SUM(exception_cnt) IS NULL THEN  0 ELSE SUM(exception_cnt) END exception_cnt, " 
				+ "CASE WHEN SUM(exception_cnt) / SUM(open_cnt) IS NULL THEN  0 ELSE SUM(exception_cnt) / SUM(open_cnt) END radio " 
				+ "FROM "
				+ "app_exception "
				+ "WHERE app_key in ("+app_key+") AND date_key BETWEEN ? AND ? "
				+ "GROUP BY date_key";
		List<Object> args = new ArrayList<Object>();
//		args.add(app_key);
		args.add(beginDate);
		args.add(endDate);
		List<AppException> list = (List<AppException>) evnDAO.executeSqlQuery(
				sql, args, AppException.class);
		JSONObject ob = new JSONObject();

		ArrayList date_list = new ArrayList();
		ArrayList excep_cnt_list = new ArrayList();
		ArrayList excep_radio_list = new ArrayList();
		if (!list.isEmpty() && list.size() != 0) {
			for (AppException app : list) {
				date_list.add(app.getDate_key());
				excep_cnt_list.add(app.getException_cnt());
				excep_radio_list.add(app.getRadio());
			}
			ob.put("date_key", date_list);
			ob.put("excep_cnt_list", excep_cnt_list);
			ob.put("excep_radio_list", excep_radio_list);
		}
		// System.out.println(ob.toJSONString());
		return ob;
	}
	
	public JSONObject redLo(String beginDate, String endDate, String app_key)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT province AS name ,CASE WHEN SUM(a) IS NULL THEN 0 ELSE SUM(a) END value FROM (SELECT b.province,SUM(open_cnt) "
				+ "AS a FROM app_location a ,dim_location b WHERE a.location_key=b.provinceid "
				+ "AND app_key in ("+app_key+") AND date_key BETWEEN ? AND ? "
				+ "GROUP BY a.location_key)d GROUP BY province";
		List<Object> args = new ArrayList<Object>();
//		args.add(app_key);
		args.add(beginDate);
		args.add(endDate);
		long max=0;
		List<LocationApp> list = (List<LocationApp>) evnDAO.executeSqlQuery(
				sql, args, LocationApp.class);
		JSONObject ob1 = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		if (!list.isEmpty() && list.size() != 0) {
			for (LocationApp app : list) {
				JSONObject ob = new JSONObject();
				ob.put("name", app.getName());
				//BigDecimal mu=new BigDecimal(10);
				//ob.put("value", app.getValue().multiply(mu));
				ob.put("value", app.getValue());
				if (max < app.getValue().longValue()){
					max=app.getValue().longValue();
				}
				jsonArr.put(ob);
			}
			ob1.put("max", max);
			ob1.put("data", jsonArr);
		}
		 System.out.println(jsonArr.toString());
		return ob1;
	}
	
}
