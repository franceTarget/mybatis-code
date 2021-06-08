package com.ren;


import com.ren.config.DataSourceConfig;
import com.ren.config.GlobalConfig;
import com.ren.config.PackageConfig;
import com.ren.config.StrategyConfig;
import com.ren.config.rules.DbType;
import com.ren.config.rules.NamingStrategy;
import com.ren.run.AutoGenerator;

public class CodeGenertor {

	public static void main(String[] args) {
		
		AutoGenerator ag = new AutoGenerator();
		//设置名称
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("c:\\code");
		gc.setFileOverride(true);
		gc.setActiveRecord(false);
		gc.setEnableCache(false);
		gc.setBaseResultMap(true);
		gc.setBaseColumnList(true);
		gc.setInsertOrUpdate(true);
		gc.setAuthor("xxx");
		gc.setControllerName("%sController");
		gc.setMapperName("%sDao");
		gc.setServiceName("%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setXmlName("%sMapper");
		gc.setKotlin(false);
		gc.setOpen(true);
		ag.setGlobalConfig(gc);
		//设置数据源
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("Zyli*M1fX%09q");
		dsc.setUrl("jdbc:mysql://192.168.1.47:3417/olmn");
		ag.setDataSource(dsc);
		//设置超类
		StrategyConfig strategy = new StrategyConfig();
		//strategy.setTablePrefix("trace_");
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setEntityBooleanColumnRemoveIsPrefix(false);
		//strategy.setInclude("trace_breed_drugs");
		strategy.setSuperMapperClass("com.gtrip.common.datasource.BaseDao");
		strategy.setSuperControllerClass(null);
		strategy.setSuperServiceClass("com.gtrip.service.BaseService");
		strategy.setSuperServiceImplClass("com.gtrip.service.BaseServiceImpl");
		strategy.setSuperEntityClass(null);
		strategy.setEntityLombokModel(true);
		ag.setStrategy(strategy);
		//设置包信息
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.gtrip");
		pc.setController("controller");
		pc.setEntity("models.entity");
		pc.setMapper("dao");
		pc.setService("service");
		pc.setServiceImpl("service.impl");
		pc.setXml("mapper");
		ag.setPackageInfo(pc);
		
		ag.execute();
		
	}

}
