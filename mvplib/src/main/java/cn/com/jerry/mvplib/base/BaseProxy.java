package cn.com.jerry.mvplib.base;


import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.com.jerry.mvplib.annotation.Implement;

/**
 *
 * Created by LiuLei on 2017/11/27.
 */
public class BaseProxy {
    private static final BaseProxy m_instance = new BaseProxy();

    private Map<Class, Object> mObjects;

    public static BaseProxy getInstance() {
        return m_instance;
    }

    private BaseProxy() {
        mObjects = new HashMap<>();
    }

    public void init(Class... clss) {
        List<Class> list = new LinkedList<Class>();
        for (Class cls : clss) {
            if (cls.isAnnotationPresent(Implement.class)) {
                list.add(cls);
                for (Annotation ann : cls.getDeclaredAnnotations()) {
                    if (ann instanceof Implement) {
                        try {
                            mObjects.put(cls, ((Implement) ann).value().newInstance());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public <T> T getProxy(Class cls) {
        return (T) mObjects.get(cls);
    }

    public <T> T bind(Class cls, BaseView o) {
        Object ret = mObjects.get(cls);
        ((BasePresenter) ret).attachView(o);
        return (T) ret;
    }
}
