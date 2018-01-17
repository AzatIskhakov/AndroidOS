package com.harman.apiserv.services.sfp;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.harman.apiserv.BusinessManager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/sfp/places")
@Api(value = "/places", description = "Manage places" )

public class PlacesResource {
	
	private static final Logger log = Logger.getLogger(PlacesResource.class.getName());
	
	@GET
	@Path("/{places}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get data",
	notes = "This API retrieves the information for free parking" +
			"<p><u>Input Parameters</u><ul><li><b>pointX, pointY, color</b> are required</li></ul>")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success: {  }"),
			@ApiResponse(code = 400, message = "Failed: {\"error\":\"error description\", \"status\":\"FAIL\"}")
	})
	
	public Response getData(@ApiParam(value = "pointX", required = true, defaultValue = "150", allowableValues = "", allowMultiple = false) 
	@PathParam("pointX") int pointX, @ApiParam(value = "pointY", required = true, defaultValue = "100", allowableValues = "", allowMultiple = false) 
	@PathParam("pointY") int pointY, @ApiParam(value = "color", required = true, defaultValue = "0", allowableValues = "", allowMultiple = false) 
	@PathParam("color") int color) {
		
//		if(pX == null) {
//			return Response.status(Response.Status.BAD_REQUEST)
//					.entity("{\"error\":\"Empty dara\", \"status\":\"FAIL\"}")
//					.build();
//		}
		
		log.info("Data retrieving");
		

//	Place place = new Place();
//	place.setPointX(150);
//	place.setPointY(100);
//	place.setColor(255);
		
		try {
			Place place = BusinessManager.getInstance().getPlace(pointX, pointY);
			
			return Response.status(Response.Status.OK).entity(place).build();
		}
		catch(Exception e) {
			
		}
	
//	return Response.status(Response.Status.OK).entity(place).build();
	return Response.status(Response.Status.BAD_REQUEST)
			.entity("{\"error\":\"Could Not Find Data\", \"status\":\"FAIL\"}")
			.build();
	}
	
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Show all places",
	notes = "This API retrieves all parking places")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success: { places : [] }"),
			@ApiResponse(code = 400, message = "Failed: {\"error\":\"error description\", \"status\":\"FAIL\"}")
	})
	public Response getData() {
		
		
		try {
			List<Place> places = BusinessManager.getInstance().getPlaces();
			
			PlacesHolder placeHolder = new PlacesHolder();
			
			placeHolder.setPlaces(places);
			
			return Response.status(Response.Status.OK).entity(placeHolder).build();
		}
		catch (Exception e) {
			
		}
		
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("{\"error\":\"Could Not Find Data\", \"status\":\"FAIL\"}")
				.build();
	}
	
	
	@POST
	@Path("/")
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Create new data",
	notes = "This API creates a new place if it does not exist" + 
		    "<p><u>Input Parameters</u><ul><li><b>new data</b> is required</li></ul>")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success: { }"),
	@ApiResponse(code = 400, message = "Failed: {\"error\":\"error description\", \"status\":\"FAIL\"}") })
	public Response createPlace(
			@ApiParam(value = "New User", required = true, defaultValue = "\"{\"pointX\":\"0\"}\"", allowableValues = "", allowMultiple = false)
		Place place) {
		
		try {
			Place newPlace = BusinessManager.getInstance().addPlace(place);
		
			return Response.status(Response.Status.CREATED).entity(newPlace).build();
		}
		catch (Exception e) {
		
		}
	
	return Response.status(Response.Status.BAD_REQUEST)
			.entity("{\"error\":\"Could not create data\", \"status\":\"FAIL\"}")
			.build();
	}
	
	
	@PUT
	@Path("/{places}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Update Place", 
    notes = "This API updates the data")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success: { }"),
    @ApiResponse(code = 400, message = "Failed: {\"error\":\"error description\", \"status\":\"FAIL\"}") })
	public Response updatePlace(@PathParam("pointX") int pointX, @PathParam("pointY") int pointY, String jsonString) {

		
		int color;
		
		try {
			Object obj = JSONValue.parse(jsonString);

			JSONObject jsonObject = (JSONObject) obj;
			color = Integer.parseInt(jsonObject.get("color").toString());

		}
		 catch (Exception e) {
				return Response.status(Response.Status.BAD_REQUEST)
						.entity("{\"error\":\"Invalid error\", \"status\":\"FAIL\"}")
						.build();
			}
		
		try {
			Place updatedPlace = BusinessManager.getInstance().updateColorAttribute(
				pointX, pointY, "color", color); 
		
			return Response.status(Response.Status.OK).entity(updatedPlace).build();
		}
		catch (Exception e) {
			
		}
		
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("{\"error\":\"Could not update data\", \"status\":\"FAIL\"}")
				.build();	
	}
	
}


