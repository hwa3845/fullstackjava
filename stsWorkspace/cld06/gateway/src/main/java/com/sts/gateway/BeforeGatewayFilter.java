package com.sts.gateway;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.PrefixPathGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.PrefixPathGatewayFilterFactory.Config;
import org.springframework.stereotype.Component;

@Component
public class BeforeGatewayFilter 
    extends AbstractGatewayFilterFactory<PrefixPathGatewayFilterFactory.Config> {
    //api 접근할 때 토큰 확인해서 접근 허용시키는 filter
    
    public BeforeGatewayFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain)->{
            List<String> list=exchange.getRequest().getHeaders().get("Authorization");
            String token=(String)list.get(0);
            //token 값이 DB의 값과 같으면 filter chain, 아니면 throw나 error 
            if(token==null)throw new UnsupportedOperationException("Unimplemented method 'apply'");
            return chain.filter(exchange);
        };
    }


}
