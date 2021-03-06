package com.zuoxiaolong.servlet;

/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.zuoxiaolong.dao.ArticleDao;
import com.zuoxiaolong.dao.HeroDao;
import com.zuoxiaolong.orm.DaoFactory;

/**
 * @author 左潇龙
 * @since 2015年5月10日 上午1:30:40
 */
public class HeroFinder extends AbstractServlet {

	private static final long serialVersionUID = 7397746086771972627L;

	@Override
	protected void service() throws ServletException, IOException {
		HttpServletRequest request = getRequest();
		String param = request.getParameter("term");
		List<String> heroList = DaoFactory.getDao(HeroDao.class).getList(param);
		writeJsonArray(heroList);
	}

}
