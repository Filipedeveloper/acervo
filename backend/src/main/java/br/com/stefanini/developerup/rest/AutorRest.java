package br.com.stefanini.developerup.rest;


import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.service.AutorService;
import br.com.stefanini.developerup.service.ClienteService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.text.ParseException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * @author Danilo Dorgam
 * email danilodorgam@gmail.com
 * created 30/03/2022
 * @version 0.1.0
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/autores")
@RequestScoped

public class AutorRest {
    @Inject
    AutorService service;

    @GET
    @Operation(summary = "Listar", description = "Retorna uma lista de AutoresDto")
    @APIResponse(responseCode = "200", description = "AutorDto",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = AutorDto.class))})
    public Response listar()  {
    	
        return Response.status(Response.Status.OK).entity(service.listar()).build();
    }
    
    
    @POST
    @Operation(summary = "Inserir", description = "Insere um autor")
    @APIResponse(responseCode = "204", description = "Inserir autor",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = AutorDto.class))})
    public Response inserir(@Valid @RequestBody AutorDto dto)  {
    	AutorDto autor = null;
		try {
			autor = service.inserir(dto);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return Response.status(Response.Status.OK).entity(autor).build();
    }
    
    @PUT
    @Path("/{autor}")
    @Operation(summary = "Ataulizar", description = "Atualizar um autor")
    @APIResponse(responseCode = "200", description = "Atualizar autor",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Autor.class))})
    public Response atualizar(@PathParam("autor") Integer id, Autor novoAutor)  {
    	Autor obj = service.atualizar(id, novoAutor);
    	return Response.status(Response.Status.OK).entity(obj).build();
    	
    }
    
    @DELETE
    @Path("/{autor}")
    @Operation(summary = "Deletar", description = "Deletar um autor")
    @APIResponse(responseCode = "200", description = "Deletar autor",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Autor.class))})
    public Response deletar(@PathParam("autor") Integer id)  {
    	service.deletar(id);
    	return Response.status(Response.Status.OK).entity("Sucesso").build();
    	
    }


}
