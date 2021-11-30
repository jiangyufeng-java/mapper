package com.ty.mapper.VO;

import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 11:46
 **/
@Data
public class ProductVO implements Serializable {

    private Integer id;

    private Integer categoryId;

    private String productName;
    private Date createTime;
    private Date updateTime;

    private String categoryName;


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    }


}
