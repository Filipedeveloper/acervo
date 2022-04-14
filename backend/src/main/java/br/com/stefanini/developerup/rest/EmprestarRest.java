package br.com.stefanini.developerup.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.dto.EmprestarDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Emprestar;
import br.com.stefanini.developerup.service.EmprestarService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/emprestimos")
@RequestScoped
public class EmprestarRest {
	
	@Inject
	EmprestarService service;
	
	
	@GET
    @Operation(summary = "Listar", description = "Retorna uma lista de Emprestimos")
    @APIResponse(responseCode = "200", description = "Emprestimo",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmprestarDto.class))})
    public Response listar()  {
    	
        return Response.status(Response.Status.OK).entity(service.listar()).build();
    }
	
	@GET
	@Path("/teste")
    @Operation(summary = "Listar", description = "Retorna uma lista de Emprestimos")
    @APIResponse(responseCode = "200", description = "Emprestimo",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmprestarDto.class))})
    public Response emprestimos()  {
    	
        return Response.status(Response.Status.OK).entity(service.listarEmprestimo()).build();
    }
	
	
	@POST
    @Operation(summary = "Inserir", description = "Insere um emprestimo")
    @APIResponse(responseCode = "204", description = "Inserir emprestimo",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmprestarDto.class))})
    public Response inserir(@RequestBody EmprestarDto dto)  {
    	Emprestar emprestimo = service.inserir(dto);
    	return Response.status(Response.Status.OK).entity(emprestimo).build();
    }

}
