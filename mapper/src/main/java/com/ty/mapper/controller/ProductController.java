package com.ty.mapper.controller;

import com.ty.mapper.entity.Product;
import com.ty.mapper.mapper.ProductMapper;
import com.ty.mapper.service.ProductService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 16:46
 **/
@RestController
public class ProductController {

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15,
            1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


    @Autowired
    private ProductService productService;

    @GetMapping("/product/list")
    public List<Product> findAll() {
        List<Product> all = productService.findAll();
        System.out.println();
        return all;
    }

    @GetMapping("/product/find/{id}")
    public Product findById(@PathVariable(value = "id") Integer id) {
        return productService.findById(id);
    }

    @GetMapping("/product/shop")
    public Object shop() {
        for (int i = 0; i < 2; i++) {
            threadPoolExecutor.execute(() -> {
                for (int j = 0;  j < 10;  j++) {
                    test111111();
                }
            });
        }
        return "成功拉";
    }

    public static void test111111() {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
        HttpPost httpPost = new HttpPost("https://creditcard.bankofchangsha.com/impMobile/order/initImpOrder");// 创建httpget实例
        CloseableHttpResponse response = null; // 执行http get请求
        httpPost.setHeader("Accept", "application/json, text/plain, */*");
        httpPost.setHeader("Origin", "https://creditcard.bankofchangsha.com");
        httpPost.setHeader("Referer", "https://creditcard.bankofchangsha.com/impFront/exchangeOrder?productId=38243&promotionId=4971&campId=2688&groupIndex=0");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1");
        httpPost.setHeader("Cookie", "Yr1B4j3mrFm8eHQ09Fnp7ifI=v1IqN+g8SctiH; sajssdk_2015_cross_new_user=1; smidV2=20211130094913c0cde1d84e72401459b471dafc2f0fe9002a4d829a798df80; MSESSIONID=0ab1eeb0-fea1-4566-aa9a-924e78635194; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%222615764%22%2C%22first_id%22%3A%2217d6e881caa99d-0826ecedad6735-978183a-1327104-17d6e881cabd0e%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%2217d6e881caa99d-0826ecedad6735-978183a-1327104-17d6e881cabd0e%22%7D");
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setEntity(new StringEntity("{\"rewardName\":\"奖励点\",\"productId\":37851,\"promotionId\":4971,\"cardInfo\":{\"id\":3787728,\"maFlag\":\"1\",\"bankCode\":null,\"userId\":null,\"cardNoAlis\":\"6228******6022\",\"cardType\":\"1\",\"branchCode\":\"9999\",\"branchName\":null,\"ccardProduct\":\"0053\",\"empCardFlag\":null,\"defaultFlag\":\"1\",\"member\":null,\"createTime\":null,\"cardStat\":\"\",\"cardSignPoint\":\"NO\",\"selected\":true},\"promProdInfo\":{\"id\":26263,\"bankCodes\":\"0461\",\"productId\":37851,\"promotionId\":4971,\"promBelong\":null,\"productNo\":\"234978\",\"rebateType\":\"1\",\"promProductSummary\":\"\",\"promProductName\":\"\",\"promProductStock\":4440,\"warnStock\":0,\"saledStock\":5560,\"rebateVal\":null,\"invoiceRate\":1.06,\"purseId\":\"S00000001789120211013\",\"rightPrice\":1,\"subsidyMode\":\"1\",\"subsidyRemark\":null,\"subsidyPrice\":null,\"productType\":\"1\",\"fullCredits\":0,\"partCredits\":0,\"partPrice\":0,\"salePrice\":0,\"returnCommissionFlag\":null,\"isDeleted\":\"0\",\"istmentRateRule\":null,\"stockFlag\":\"1\",\"linkInformation\":null,\"deferUseFlag\":null,\"fixedCostSettleFlag\":\"0\",\"vendorCostPrice\":null,\"cupdCostPrice\":null,\"promMarketPrice\":null,\"productPic\":null,\"validDays\":null,\"frontSort\":null,\"percent\":\"44.40\",\"promProdPic\":null,\"groupPriceType\":null,\"lotteryTime\":null,\"lotteryNum\":null,\"applyNum\":null,\"contentFlag\":null,\"sendRightNum\":null,\"stages\":null},\"productBreed\":\"B\",\"productType\":\"1\",\"accountNo\":\"\",\"campId\":\"2688\",\"orderChannel\":\"\",\"smsCode\":\"\"}", "utf-8"));
        try {
            response = httpClient.execute(httpPost);

            StatusLine status = response.getStatusLine();

            int state = status.getStatusCode();

            if (state == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();

                System.out.println(EntityUtils.toString(entity));
            } else {
                System.out.println("出错啦~~~~~~~~~~~~");
            }

        } catch (Exception e) {
            System.out.println("出异常了~~~~~~~~~~~~");
        } finally {
            if (response != null) {
                try {
                    response.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            try {
                httpClient.close();

            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }
}
