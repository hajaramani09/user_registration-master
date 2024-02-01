package codingtechniques.AppSecurityConfig;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import codingtechniques.Filter.JWTFilter;

public class ExceptionHandler extends ResponseEntityExceptionHandler {
    private static final org.apache.commons.logging.Log LOG = LogFactory.getLog(JWTFilter.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            org.springframework.web.bind.MethodArgumentNotValidException ex,
            org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError->fieldError.getDefaultMessage()).collect(Collectors.toList());
                LOG.info("Validation error list : "+validationList);
             
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }


    
       
 
}
