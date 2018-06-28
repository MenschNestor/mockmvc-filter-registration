package com.github.menschnestor.mockmvcfilterregistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class SampleFilter extends GenericFilterBean {
    private static final Logger LOG = LoggerFactory.getLogger(SampleFilter.class);

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        LOG.info("SampleFilter says hi");
        chain.doFilter(request, response);
    }
}
