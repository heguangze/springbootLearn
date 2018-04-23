//package com.luster.fistIdeaItem;
//
//import com.luster.fistIdeaItem.primary.entity.Human;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//public class TestClient {
////    private static final Logger log = LoggerFactory.getLogger(TestClient.class);
//
//    public static void main(String[] args) {
//        WebClient client = WebClient.create("http://localhost:9099/");
//
//        Mono<Human> result = client.post()// 请求方法,get,post...
//                .uri("persion/getPersion/{id}.json", "123")// 请求相对地址以及参数
//                .accept(MediaType.APPLICATION_JSON).retrieve()// 请求类型
//                .bodyToMono(Human.class);// 返回类型
//        Human person = result.block();
//        System.out.println(person.getAddress());
//    }
//}
