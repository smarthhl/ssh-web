package org.creditease.cn.model;
/**
 * 特殊模板声明，用来标识sql模板中的特殊处理
  * @ClassName: SpecialModel
  * @Description: TODO
  * @author caliph
  * @date Jun 11, 2015 12:49:10 PM
 */
public interface SpecialModel<T> {
	public T getValue();
	public void setValue(T value);
}
