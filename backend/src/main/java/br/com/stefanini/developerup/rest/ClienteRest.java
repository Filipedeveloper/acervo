package br.com.stefanini.developerup.rest;

import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Cliente;
import br.com.stefanini.developerup.service.ClienteService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
@Path("/cliente")
@RequestScoped

public class ClienteRest {
    @Inject
    ClienteService service;

    @GET
    @Operation(summary = "Listar", description = "Retorna uma lista de Clientes")
    @APIResponse(responseCode = "200", description = "ClienteDto",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClienteDto.class))})
    public Response listar()  {
        return Response.status(Response.Status.OK).entity(service.listar()).build();
    }
    
    @POST
    @Operation(summary = "Inserir", description  = "Inserir um Cliente")
    @APIResponse(responseCode = "204", description = "Inserir Cliente",
    content = {@Content(mediaType = "application/json", 
    schema = @Schema(implementation = Cliente.class))})
    public Response inserir(@RequestBody Cliente cliente) {
    	service.inserir(cliente);
    	return Response.status(Response.Status.OK).entity(cliente).build();
    }
    
    @PUT
    @Path("/{cliente}")
    @Operation(summary = "Ataulizar", description = "Atualizar um cliente")
    @APIResponse(responseCode = "200", description = "Atualizar cliente",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Cliente.class))})
    public Response atualizar(@PathParam("cliente") Integer id, Cliente novoCliente)  {
    	Cliente obj = service.atualizar(id, novoCliente);
    	return Response.status(Response.Status.OK).entity(obj).build();
    	
    }
    
    
    @DELETE
    @Path("/{cliente}")
    @Operation(summary = "Deletar", description = "Deletar um cliente")
    @APIResponse(responseCode = "200", description = "Deletar cliente",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Cliente.class))})
    public Response deletar(@PathParam("cliente") Integer id)  {
    	service.deletar(id);
    	return Response.status(Response.Status.OK).entity("Sucesso").build();
    	
    }
    

}
