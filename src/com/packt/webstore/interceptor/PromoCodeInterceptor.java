package com.packt.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PromoCodeInterceptor extends HandlerInterceptorAdapter {
	private String promoCode;
	private String errorRedirect;
	private String offerRedirect;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String givenPromoCode =  request.getParameterValues("promo")==null ? "":request.getParameterValues("promo")[0];
		if(request.getRequestURI().endsWith("products/specialOffer")){
			if(givenPromoCode.equals(promoCode)){
				response.sendRedirect(request.getContextPath()+"/"+ offerRedirect);
			}else{
				response.sendRedirect(errorRedirect);
			}
			return false;
		}
		return true;

	}
	
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public String getErrorRedirect() {
		return errorRedirect;
	}
	public void setErrorRedirect(String errorRedirect) {
		this.errorRedirect = errorRedirect;
	}
	public String getOfferRedirect() {
		return offerRedirect;
	}
	public void setOfferRedirect(String offerRedirect) {
		this.offerRedirect = offerRedirect;
	}

	
}
