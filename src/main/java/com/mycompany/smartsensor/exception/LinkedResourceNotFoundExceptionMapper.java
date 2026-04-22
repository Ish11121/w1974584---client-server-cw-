
package com.mycompany.smartsensor.exception;

import com.mycompany.smartsensor.model.ErrorMessage;
import javax.ws.rs.core.Response; 
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class LinkedResourceNotFoundExceptionMapper implements ExceptionMapper<LinkedResourceNotFoundException>{
    
    @Override
    public Response toResponse(LinkedResourceNotFoundException exception){
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 422, "https://myuniversity.edu/api/docs/errors");
        
        return Response.status(422)
                .entity(errorMessage)
                .build();
                
    
    }
    
    
    
            
    
}
