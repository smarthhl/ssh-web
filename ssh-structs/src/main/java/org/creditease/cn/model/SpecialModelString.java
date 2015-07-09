package org.creditease.cn.model;
/**
 * 用来标识sql模板中的特殊字符串处理
  * @ClassName: SpecialModelString
  * @Description: TODO
  * @author caliph
  * @date Jun 11, 2015 12:52:41 PM
 */
public class SpecialModelString implements SpecialModel<String>{
	
	private String value;
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		this.value=value;
	}
}
