package com.goldeasy.common.config;


import com.github.pagehelper.PageHelper;


import com.goldeasy.common.mapper.BaseMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;
import java.util.Properties;


/**
 * Created by Administrator on 2018/1/8.
 */
@Configuration
public class MyMapperScannerConfigurer {

    /**配置扫描Mapper**/
    @Bean
    public tk.mybatis.spring.mapper.MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setMarkerInterface(BaseMapper.class);
        mapperScannerConfigurer.setBasePackage("com.goldeasy");
        return mapperScannerConfigurer;
    }
    /**分页*/
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }



//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        return sessionFactory.getObject();
//    }

}
