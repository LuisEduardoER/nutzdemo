package org.nutz.extras.mvc.init;

import java.lang.reflect.Method;
import java.util.List;

import org.nutz.extras.mvc.annotation.Authority;
import org.nutz.lang.util.Context;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ViewMaker;
import org.nutz.mvc.init.NutConfig;
import org.nutz.mvc.init.UrlMapImpl;


/**
 * @author <a href="mailto:json.shen@gmail.com">Json Shen</a>
 * 2010-7-18 下午02:44:08
 */
public class MyUrlMapImpl extends UrlMapImpl {
	
	private static final Log log = Logs.getLog(MyUrlMapImpl.class);

	public MyUrlMapImpl(NutConfig config, Context context, Class<?> mainModule) {
		super(config, context, mainModule);
	}

	/**
	 * 添加URL时初始化权限
	 */
	@Override
	public boolean add(List<ViewMaker> makers, Class<?> moduleType) {
		boolean isModule = super.add(makers, moduleType);
		for (Method method : moduleType.getMethods()) {
			Authority a = method.getAnnotation(Authority.class);
			if(null == a){
				continue;
			}
			String id = a.value();
			String module = a.module();
			String desc = a.desc();
			boolean isDefault = a.isDefault();
			
			log.infof("AuthID=%s Module=%s Default=%s Desc=%s", id,module,isDefault,desc);
		}
		return isModule;
	}
}
