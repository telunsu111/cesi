package com.fictions.assist.service;

/**
 * 类说明: 数据不一致异常，当数据库数据不符合业务规则时抛出。
 * <br />
 * 设想在service层检测到不一致时抛出，在controller层框架自动捕获。非例外都使用带消息参数的构造函数，该消息用来返回给客户端。
 * <br />
 * 抛出举例：
 * <ul>
 * <li>用户名已注册</li>
 * <li>课程名称不能为空</li>
 * </ul>
 * <br />
 * Author: Huyihui
 * <br />
 * Date: 2016-8-4
 * <br />
 * Copyright (c) 2006-2015.Beijing WenHua Online Sci-Tech Development Co. Ltd
 * All rights reserved.
 */
public class DataInconsistentException extends RuntimeException {
    /* serialVersionUID: serialVersionUID */
    private static final long serialVersionUID = 1L;

    public DataInconsistentException() {
        super();
    }

    public DataInconsistentException(String s) {
        super(s);
    }
	
    public DataInconsistentException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DataInconsistentException(Throwable cause) {
        super(cause);
    }
}
