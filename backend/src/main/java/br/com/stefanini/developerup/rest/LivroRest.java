package br.com.stefanini.developerup.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.dto.LivroDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Livro;
import br.com.stefanini.developerup.service.AutorService;
import br.com.stefanini.developerup.service.LivroService;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/livros")
public class LivroRest {
	
	@Inject
	LivroService service;
	
	@GET
    @Operation(summary = "Listar", description = "Retorna uma lista de Livros")
    @APIResponse(responseCode = "200", description = "Livro",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Livro.class))})
    public Response listar()  {
    	
        return Response.status(Response.Status.OK).entity(service.listar()).build();
    }
	
	
	@POST
    @Operation(summary = "Inserir", description = "Insere um livro")
    @APIResponse(responseCode = "204", description = "Inserir livro",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = LivroDto.class))})
    public Response inserir(@RequestBody LivroDto dto)  {
    	Livro livro = service.inserir(dto);
    	return Response.status(Response.Status.OK).entity(livro).build();
    }
	
	@PUT
	@Path("/{livro}")
    @Operation(summary = "Atualizar", description = "Atualizar um livro")
    @APIResponse(responseCode = "204", description = "Atualizar livro",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = LivroDto.class))})
    public Response atualizar(@PathParam("livro") Integer id, LivroDto dto )  {
    	Livro livro = service.atualizar(id, dto);
    	return Response.status(Response.Status.OK).entity(livro).build();
    }
	
	@DELETE
    @Path("/{livro}")
    @Operation(summary = "Deletar", description = "Deletar um livro")
    @APIResponse(responseCode = "200", description = "Deletar livro",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Livro.class))})
    public Response deletar(@PathParam("livro") Integer id)  {
    	service.deletar(id);
    	return Response.status(Response.Status.OK).entity("Sucesso").build();
    	
    }


}
