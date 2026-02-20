package dev.kernelkaput.ai;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * REST resource for the Fibonacci endpoint.
 */
@Path("/fibonacci")
public class FibonacciResource {

    private final FibonacciController fibonacciController;

    @Inject
    public FibonacciResource(FibonacciController fibonacciController) {
        this.fibonacciController = fibonacciController;
    }

    /**
     * Returns the Fibonacci number at the specified position.
     * 
     * @param position the position in the Fibonacci sequence (required)
     * @return Response containing the Fibonacci number or error message
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFibonacci(@QueryParam("position") Integer position) {
        if (position == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Query parameter 'position' is required")
                    .build();
        }
        
        try {
            long result = fibonacciController.calculateFibonacci(position);
            return Response.ok().entity(result).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
