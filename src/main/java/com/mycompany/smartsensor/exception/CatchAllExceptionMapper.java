
package com.mycompany.smartsensor.exception;

import com.mycompany.smartsensor.model.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CatchAllExceptionMapper implements ExceptionMapper<Throwable>{
    
    @Override
    public Response toResponse (Throwable exception){
        ErrorMessage errorMessage = new ErrorMessage("Server Error", 500, "https://myuniversity.edu/api/docs/errors");
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    
    
    
    }
    
    
    
    
}
