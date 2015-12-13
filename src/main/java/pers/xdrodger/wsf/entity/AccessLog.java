package pers.xdrodger.wsf.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 访问日志表
 * 
 * @author xudongdong
 *         2015年12月12日 下午9:34:56
 */
@Entity
@Table(name = "access_log")
public class AccessLog  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String info;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	@Id
	@GeneratedValue(generator = "uuid")
	// 指定生成器名称
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", length = 80)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
