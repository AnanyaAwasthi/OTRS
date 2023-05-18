package com.otrs.user.Exception;

import java.io.IOException;

import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler{

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		return response.getStatusCode().is4xxClientError() || 
				response.getStatusCode().is5xxServerError();
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		if(response.getStatusCode().is4xxClientError())
		{
			if(response.getStatusCode() == HttpStatus.NOT_FOUND)
			{
				throw new NoRestaurantsPresent("Service is currently unavailable");
			}
		}
		
	}

}
